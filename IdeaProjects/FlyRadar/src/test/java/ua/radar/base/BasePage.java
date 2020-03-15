package ua.radar.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.radar.driver.DriverManager;
import ua.radar.pages.AircraftPage;
import ua.radar.pages.AirlinesPage;
import ua.radar.pages.MainPage;
import ua.radar.pages.StatisticPage;
import ua.radar.util.DelayUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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
//        addCoverageButton.click();
        return this;
    }

    private BasePage goToDataMenu(){
        dataButton.click();
//        driver.findElement(By.xpath("//*[@id=\"navTopDataHistory\"]")).click();
        return this;
    }


}
