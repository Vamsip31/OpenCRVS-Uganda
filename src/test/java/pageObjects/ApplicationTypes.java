package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ApplicationTypes extends BasePage {
    @FindBy(xpath = "//div[@class='Contents-sc-1y9h23z-15 iOnnSH']//label")
    public List<WebElement> lstApplTypes;
    @FindBy(xpath = "//label[normalize-space()='Birth']")
    public WebElement btnBirth;
    @FindBy(xpath = "//label[normalize-space()='Death']")
    public WebElement btnDeath;
    @FindBy(xpath = "//div[@class='Contents-sc-1y9h23z-15 iOnnSH']")
    public WebElement BtnOtherSrervices;
    @FindBy(xpath = "//button[@id='continue']")
    public WebElement btnContinue;
    @FindBy(xpath = "//button[@id='next_section']")
    public WebElement btnContinue1;

    public ApplicationTypes(WebDriver driver) {
        super(driver);
    }

    public void selectOptions(String type) {
        switch (type) {
            case "Birth":
                btnBirth.click();
                break;

            case "Death":
                btnDeath.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid application type: " + type);
        }


    }

    public void clickContinueBtn() {
        btnContinue.click();
    }

    public void clickContinueBtn1() {
        btnContinue1.click();
    }
}
