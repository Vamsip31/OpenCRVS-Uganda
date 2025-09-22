package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLoginPin extends BasePage {
    @FindBy(xpath = "(//input[@id='pin-input'])")
    public WebElement NumPin;

    public CreateLoginPin(WebDriver driver) {
        super(driver);
    }

    public void setPin(String pin) {
        NumPin.sendKeys(pin);
    }

    public void setRePin(String pin) {
        NumPin.sendKeys(pin);
    }

}
