package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {


    @Test(groups = {"Sanity", "Master"})
    public void verify_login() throws InterruptedException {
        logger.info("****** Starting TC001_LoginTest *****");

        try {
            //Login
            LoginPage lp = new LoginPage(driver);
            Thread.sleep(2000);
            lp.setUsername(p.getProperty("username"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            //MyAccount
//            MyAccountPage macc = new MyAccountPage(driver);
//            boolean targetPage = macc.isMyAccountPageExists();

//            Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("****** Finished TC001_LoginTest *****");
    }

}
