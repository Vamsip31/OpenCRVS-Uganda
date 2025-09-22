package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='username']")
    WebElement txtUsername;
    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;
    @FindBy(xpath = "//button[@id='login-mobile-submit']")
    WebElement btnLogin;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

}
