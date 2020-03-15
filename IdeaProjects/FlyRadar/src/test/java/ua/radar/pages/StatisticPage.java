package ua.radar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.radar.base.BasePage;
import ua.radar.util.DelayUtil;

import java.util.List;

public class StatisticPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"users\"]/div/table/tbody/tr")
    List<WebElement> radarsList;

    @FindBy (xpath = "//*[@id=\"radars\"]/div/table")
    WebElement usersTable;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div/div/div[1]/form/div")
    WebElement searchField;

    public boolean isRadarListNotEmpty(){
        return !radarsList.isEmpty();
    }

    public boolean isCountryInList(String country){
        System.out.println(radarsList.size());
        for (WebElement element:radarsList) {
         if(element.findElements(By.tagName("td")).get(3).getText().equals(country))return true;
        }
        return false;
    }
}
