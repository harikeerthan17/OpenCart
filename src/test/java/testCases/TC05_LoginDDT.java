package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import utilities.DataProviders;

public class TC05_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void Login_DDT(String username, String pwd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		logger.info("Login page appeared");
		
		LoginPage lp=new LoginPage(driver);
		lp.clickEmail(username);
		logger.info("Email entered");
		System.out.println(username);
		lp.clickPassword(pwd);
		logger.info("password entered");
		lp.clickSubmitLogin();
		
		
		if (lp.validateLogin().equals("My Account")) {
			logger.info("log in succesful");
//			LogoutPage lgt=new LogoutPage(driver);
//			lgt.clickLogout();
			TC04_Logout lgt = new TC04_Logout();
			lgt.logoutCase();
			Assert.assertTrue(true);
		}else {
			logger.info("Login failed");
			Assert.fail();
		}
	}
}
