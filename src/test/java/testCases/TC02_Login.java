package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC02_Login extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void Login() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		logger.info("Login page appeared");
		
		LoginPage lp=new LoginPage(driver);
		lp.clickEmail(prop.getProperty("username"));
		logger.info("Email entered");
		lp.clickPassword(prop.getProperty("password"));
		logger.info("password entered");
		lp.clickSubmitLogin();
		
		Thread.sleep(3000);		
		if (lp.validateLogin().equals("My Account")) {
			logger.info("loggin succesful");
			Assert.assertTrue(true);
		}else {
			logger.info("Login failed");
			Assert.fail();
		}
	}
}
