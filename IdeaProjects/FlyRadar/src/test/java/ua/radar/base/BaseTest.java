package ua.radar.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ua.radar.driver.DriverManager;
import ua.radar.pages.MainPage;

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
}
