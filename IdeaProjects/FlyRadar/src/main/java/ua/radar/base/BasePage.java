package ua.radar.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.radar.util.driver.DriverManager;
import ua.radar.pageObject.AircraftPage;
import ua.radar.pageObject.AirlinesPage;
import ua.radar.pageObject.MainPage;
import ua.radar.pageObject.StatisticPage;
import ua.radar.util.DelayUtil;

public abstract class BasePage {

    @FindBy (css = "#data > a > svg")
   private  WebElement mainPageLogo;

    @FindBy (xpath = "//*[@id=\"navTopAddCoverage\"]")
    private WebElement addCoverageButton;

    @FindBy (xpath = "//*[@id=\"navTopAddCoverageShareStatistics\"]")
    private WebElement statisticButton;

    @FindBy (xpath = "//*[@id=\"navTopDataHistory\"]")
    private WebElement dataButton;

    @FindBy (xpath = "//*[@id=\"navTopDataHistoryAirlines\"]")
    private WebElement airlineButton;

    @FindBy (xpath = "//*[@id=\"navTopDataHistoryAirline\"]/span[2]")
    private  WebElement aircraftButton;

    protected BasePage(){
        PageFactory.initElements(DriverManager.getBrowserInstance(),this);
    }

    public MainPage goToMainPage(){
        DriverManager.getBrowserInstance().get("https://www.flightradar24.com/");
        return new MainPage();
    }

    public AircraftPage goToAircraftPage() {
        goToDataMenu();
        aircraftButton.click();
        return new AircraftPage();
    }

    public AirlinesPage goToAirlinesPage(){
        goToDataMenu();
        airlineButton.click();
        return new AirlinesPage();
    }

    public StatisticPage goToStatisticPage(){
        goToAddCoverageMenu();
        statisticButton.click();
        return new StatisticPage();
    }

    private BasePage goToAddCoverageMenu(){    //Повинен повертати this
        DelayUtil.waitAndClick(addCoverageButton);
        return this;
    }

    private BasePage goToDataMenu(){
        dataButton.click();
        return this;
    }


}
