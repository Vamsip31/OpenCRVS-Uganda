package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.OtpPage;
import testBase.BaseClass;

public class TC002_OTPTest extends BaseClass {
    @Test(dependsOnMethods = {"verify_login"}, groups = {"Sanity", "Master"})

    public void verify_otp() throws InterruptedException {
        logger.info("****** Starting TC002_OTPTest *****");

        try {
            //Login
            LoginPage lp = new LoginPage(driver);
            Thread.sleep(2000);
            lp.setUsername(p.getProperty("username"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();
            //OTP
            OtpPage op = new OtpPage(driver);
            op.setOtp(p.getProperty("otp"));

            op.clickVerifyOTP();

            //MyAccount
//            MyAccountPage macc = new MyAccountPage(driver);
//            boolean targetPage = macc.isMyAccountPageExists();

//            Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("****** Finished TC002_OTPTest *****");
    }
}
