package ua.radar.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.radar.base.BasePage;
import ua.radar.base.BaseTest;
import ua.radar.pages.MainPage;
import ua.radar.pages.StatisticPage;

public class StatisticPageTest extends BaseTest {

    private StatisticPage statisticPage;

    @BeforeClass
    public void preparePage() {
        System.out.println("Before class " + this.getClass().getSimpleName());
        statisticPage = new MainPage().goToStatisticPage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRadarListIsEmpty(){
        Assert.assertTrue(statisticPage.isRadarListNotEmpty());
    }

    @Test
    public void testCountryIsInList(){
    Assert.assertTrue(statisticPage.isCountryInList("Germany"));
    }

    @AfterClass
    public void goToMainPage(){
        System.out.println("After class " + this.getClass().getSimpleName());
        statisticPage.goToMainPage();
    }
}
