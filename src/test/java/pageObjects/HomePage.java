package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@id='header_new_event']")
    public WebElement btnCreate;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCreate() {
        btnCreate.click();
    }
}
