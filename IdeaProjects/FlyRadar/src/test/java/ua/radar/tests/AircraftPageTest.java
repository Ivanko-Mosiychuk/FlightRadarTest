package ua.radar.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.radar.base.BaseTest;
import ua.radar.pages.AircraftPage;
import ua.radar.pages.MainPage;

import java.util.ArrayList;

public class AircraftPageTest extends BaseTest {

    private AircraftPage aircraftPage;

    @BeforeClass
    public void preparePage() {
        System.out.println("Before class "+this.getClass().getSimpleName());
        aircraftPage = new MainPage().goToAircraftPage();
    }

    @Test
    public void testAircraftPageName() {
        Assert.assertTrue(aircraftPage.isPageNameCorrect("Production lists"),"Тест не пройшов");
    }

    @Test
    public void testAircraftListNotEmpty(){
        Assert.assertTrue(aircraftPage.isAircraftListEmpty(),"Aircraft list is empty.");
    }

    @DataProvider(name ="AircraftName")
    public Object[][] nameProvider(){
        return new Object[][]{
                {"Airbus"},{"Boeing"},{"Bombardier"},{"Embraer"}
        };
    }

    @Test(dataProvider ="AircraftName")
    public void testIsAllNamePresent(String name){
        System.out.println("test time");
        Assert.assertTrue(aircraftPage.isAircraftNamePresent(name));
    }

    @AfterClass
    public void goToMainPage(){
        System.out.println("After class " +this.getClass().getSimpleName());
        aircraftPage.closeCookiesNotification();
        aircraftPage.goToMainPage();
    }
}

