package ua.radar.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.radar.base.BaseTest;
import ua.radar.pageObject.MainPage;
import ua.radar.pageObject.StatisticPage;

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
    public void testIsCountryInList(){
    Assert.assertTrue(statisticPage.isCountryInRadarsList("Germany"));
    }

    @Test
    public void testIsUsernameInList(){
        Assert.assertTrue(statisticPage.isUsernameInUsersList("davekm3t"),"This name wasn't found in the list");
    }

    @AfterClass
    public void goToMainPage(){
        System.out.println("After class " + this.getClass().getSimpleName());
        statisticPage.goToMainPage();
    }
}
