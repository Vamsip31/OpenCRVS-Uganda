package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtpPage extends BasePage {
    @FindBy(xpath = "//input[@id='code']")
    WebElement txtOTP;
    @FindBy(xpath = "//button[@id='login-mobile-submit']")
    WebElement btnVerifyOTP;

    public OtpPage(WebDriver driver) {
        super(driver);
    }

    public void setOtp(String otp) {
        txtOTP.sendKeys(otp);
    }

    public void clickVerifyOTP() {

        btnVerifyOTP.click();
    }
}
