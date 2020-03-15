package ua.radar.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.radar.base.BasePage;
import ua.radar.util.DelayUtil;

import java.util.List;

public class AircraftPage extends BasePage {


    @FindBy (xpath = "//*[@id=\"list-aircraft\"]/table/tbody/tr")
    List<WebElement> aircraftsList;

    @FindBy (xpath = "//*[@id=\"list-aircraft\"]/table/tbody/tr[@class='border-top']")
    List<WebElement> aircraftsNameList;

    @FindBy (xpath = "//*[@id=\"cnt-subpage-title\"]/h1")
    WebElement pageName;

    @FindBy (xpath = "//*[@id=\"data\"]/div[1]/div[1]/img")
    WebElement cookiesNotificationCloseButton;

    public boolean isPageNameCorrect(String pageName){
        return this.pageName.getText().equals(pageName);
    }

    public boolean isAircraftListEmpty(){
        return aircraftsList.isEmpty();
    }

    public boolean isAircraftNamePresent(String name){
        for (WebElement element: aircraftsNameList) {
            System.out.println(element.getText()+"  ???? "+name);
            if(element.getText().contains(name)) return true;
        }
        return false;
    }

    public void closeCookiesNotification(){
        DelayUtil.waitAndClick(cookiesNotificationCloseButton);
    }
}
