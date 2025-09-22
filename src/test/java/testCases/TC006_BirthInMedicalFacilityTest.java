package testCases;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.List;
import java.util.Locale;

public class TC006_BirthInMedicalFacilityTest extends BaseClass {
    @Test(groups = {"Sanity", "Master", "BirthAppl"})
    public void verify_Brith_Form_Fields_in_Medical_Facility() {
        logger.info("****** Starting TC006_BirthInMedicalFacilityTest *****");
        Faker faker = new Faker(new Locale("en", "IND"));

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
                    logger.info("Form field validation successful: Birth option selected");
                    break;
                }

            }
            ap.clickContinueBtn();
            ap.clickContinueBtn1();

//            Birth in Medical Facility Form
            BirthFormInMedicalFacility bmf = new BirthFormInMedicalFacility(driver);
            bmf.childGivenName(faker.name().firstName());
            

            logger.info("Form field validation successful");
        } catch (Exception e) {
            logger.error("Form field validation is failed", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("****** Finished TC006_BirthInMedicalFacilityTest *****");
    }
}
