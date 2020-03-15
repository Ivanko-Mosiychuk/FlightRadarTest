package ua.radar.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getBrowserInstance() {
        if (threadLocal.get() == null) {
            WebDriverManager.chromedriver().setup();
            threadLocal.set(new ChromeDriver());
        }
        return threadLocal.get();
    }
}
