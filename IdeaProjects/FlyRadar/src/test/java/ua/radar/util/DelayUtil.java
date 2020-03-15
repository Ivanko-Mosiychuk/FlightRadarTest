package ua.radar.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.radar.driver.DriverManager;

public class DelayUtil {
    private static WebDriverWait wait;

    public static void waitAndClick(WebElement element) { waitAndClick(element, 10); }

    public static void waitAndClick(WebElement element, int sec) {
        initWaitObject(sec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void clickIfVisible(WebElement element, int sec){
        initWaitObject(sec);
    }

    private static void initWaitObject(int sec){
        wait = new WebDriverWait(DriverManager.getBrowserInstance(), sec);
    }

}
