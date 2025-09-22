package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BirthFormInMedicalFacility extends BasePage {
    @FindBy(xpath = "//input[@id='firstNamesEng']")
    public WebElement txtChildGivenName;

    public BirthFormInMedicalFacility(WebDriver driver) {
        super(driver);
    }

    public void childGivenName(String giveName) {
        txtChildGivenName.sendKeys(giveName);
    }
}
