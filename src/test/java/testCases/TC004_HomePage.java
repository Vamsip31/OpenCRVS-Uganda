package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CreateLoginPin;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OtpPage;
import testBase.BaseClass;

public class TC004_HomePage extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_home_page_features() {
        logger.info("****** Starting TC004_HomePage *****");

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

            // Create Application
            HomePage hp = new HomePage(driver);
            WebElement CreateButton = wait.until(ExpectedConditions.visibilityOf(hp.btnCreate));
            Assert.assertTrue(CreateButton.isDisplayed(), "Title is not visible");
            hp.clickCreate();
//            Assert.assertTrue(CreateButton.isSelected());
            logger.info("HomePage loading is successful");
        } catch (Exception e) {
            logger.error("HomePage loading is failed", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("****** Finished TC004_HomePage *****");
    }


}
