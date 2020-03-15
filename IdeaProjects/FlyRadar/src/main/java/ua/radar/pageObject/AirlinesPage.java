package ua.radar.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.radar.base.BasePage;

public class AirlinesPage extends BasePage {
    @FindBy (xpath = "//*[@id=\"searchAirline\"]")
    WebElement searchField;

    @FindBy (xpath = "//*[@id=\"tbl-datatable\"]/tbody")
    WebElement tableOfAirlines;

    @FindBy (xpath = "//*[@id=\"tbl-datatable\"]/thead/tr/th[2]/div")
    WebElement AlphabetSelectLine;
}
