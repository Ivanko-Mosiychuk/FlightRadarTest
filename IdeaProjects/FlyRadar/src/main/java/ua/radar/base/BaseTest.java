package ua.radar.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.radar.util.driver.DriverManager;
import ua.radar.pageObject.MainPage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class BaseTest {

    protected static WebDriver driver;

    protected static MainPage mainPage;

    @BeforeSuite(alwaysRun = true)
    public static void initDriver(){
        Path driverPath = Paths.get("src", "main", "resources");
        System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
        driver = DriverManager.getBrowserInstance();
        driver.get("https://www.flightradar24.com/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public static void closeDriver(){
        driver.close();
    }

}
