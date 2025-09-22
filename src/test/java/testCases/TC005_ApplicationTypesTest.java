package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.List;

public class TC005_ApplicationTypesTest extends BaseClass {
    @Test(groups = {"Sanity", "Master"})
    public void verify_Application_types_selection() {
        logger.info("****** Starting TC005_ApplicationTypesTest *****");

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
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='title-text']"))
            );
            clp.setPin(p.getProperty("pin"));
            clp.setRePin(p.getProperty("pin"));

            // Create Application
            HomePage hp = new HomePage(driver);
            wait.until(ExpectedConditions.visibilityOf(hp.btnCreate));
            hp.clickCreate();

            //Application Types Selection
            ApplicationTypes ap = new ApplicationTypes(driver);
            List<WebElement> applist = ap.lstApplTypes;
            for (WebElement app : applist) {
                String text = app.getText().trim();
                System.out.println("Found option: " + text);  // or getText() if it's in label

                if (text.equalsIgnoreCase("Birth")) {
                    ap.selectOptions(text);
                    break;
                }
                logger.info("Option selected successful");
            }
            ap.clickContinueBtn();
            ap.clickContinueBtn1();
        } catch (Exception e) {
            logger.error("Option selection is failed", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("****** Finished TC005_ApplicationTypesTest *****");
    }
}
