package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CreateLoginPin;
import pageObjects.LoginPage;
import pageObjects.OtpPage;
import testBase.BaseClass;

public class TC003_CreatePINTest extends BaseClass {
    //    @Test(dependsOnMethods = {"verify_login"}, groups = {"Sanity", "Master"})
    @Test(groups = {"Sanity", "Master"})
    public void verify_create_pin() {
        logger.info("****** Starting TC003_CreatePINTest *****");

        try {
            // Login
            LoginPage lp = new LoginPage(driver);
            lp.setUsername(p.getProperty("username"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            // OTP
            OtpPage op = new OtpPage(driver);
            op.setOtp(p.getProperty("otp"));
            op.clickVerifyOTP();

            // Create Pin
            CreateLoginPin clp = new CreateLoginPin(driver);
            WebElement title = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='title-text']"))
            );
            Assert.assertTrue(title.isDisplayed(), "Title is not visible");


            // wait.until(ExpectedConditions.visibilityOfElementLocated(clp.NumPin)); // if NumPin is By
            System.out.println(title.isDisplayed());
            clp.setPin(p.getProperty("pin"));
            clp.setRePin(p.getProperty("pin"));

            logger.info("PIN creation successful");
        } catch (Exception e) {
            logger.error("PIN creation failed", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("****** Finished TC003_CreatePINTest *****");
    }

}
