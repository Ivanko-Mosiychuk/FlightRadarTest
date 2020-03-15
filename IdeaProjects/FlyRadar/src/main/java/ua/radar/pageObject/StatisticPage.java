package ua.radar.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.radar.base.BasePage;

import java.util.List;

public class StatisticPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"users\"]/div/table/tbody/tr")
    List<WebElement> radarsList;

    @FindBy (xpath = "//*[@id=\"radars\"]/div/table/tbody/tr")
    List<WebElement> usersList;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div/div/div[1]/form/div")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"top_users\"]")
    private WebElement topUsersButton;

    public boolean isRadarListNotEmpty(){
        return !radarsList.isEmpty();
    }

    public boolean isCountryInRadarsList(String country){
        System.out.println(radarsList.size());
        for (WebElement element:radarsList) {
         if(element.findElements(By.tagName("td")).get(3).getText().equals(country))return true;
        }
        return false;
    }

    public boolean isUsernameInUsersList(String username){

        for (WebElement element: usersList) {
            System.out.println(element.findElements(By.tagName("td")).get(1));
            if(element.findElements(By.tagName("td")).get(1).equals(username)) return true;
        }
        return false;
    }

    private StatisticPage goToUsersList(){
        this.topUsersButton.click();
        return this;
    }
}
