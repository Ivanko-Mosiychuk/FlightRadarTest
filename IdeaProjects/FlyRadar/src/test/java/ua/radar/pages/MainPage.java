package ua.radar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.radar.base.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"fr24_Fullscreen\"]/a/svg[2]/use")
    WebElement fullScreenButton;

    @FindBy(xpath = "//*[@id=\"searchBox\"]")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"premiumOverlay\"]/a/span")
    WebElement logInButton;

    @FindBy(xpath = "//*[@id=\"fr24_ViewsDropdownContainer\"]/button/span")
    WebElement mapSelect;

    @FindBy(xpath = "//*[@id=\"map\"]/div[16]")
    WebElement fullScreenMes;

    @FindBy(xpath = "//*[@id=\"menuPlanesValue\"]")
    WebElement numberOfPlanes;

    @FindBy(xpath = "//*[@id=\"menuAirportStatsContent\"]")
    WebElement delayTable;

    @FindBy(xpath = "//*[@id=\"menuAirportStats\"]/a")
    WebElement delayChoise;



}
