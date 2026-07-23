package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;


public class TC01_Account_Register extends BaseClass{
	@Test(groups= {"Sanity","Master"})
	public void registration_page() {
		HomePage hp=new HomePage(driver);
		logger.info("Script started");
		hp.clickAccount();
		hp.clickRegister();
		
		logger.info("Clicked on Register");
		
		AccountRegistration ar=new AccountRegistration(driver);
		ar.setFirstname("Varun");
		ar.setLastname("M");
		ar.settelephone("9879999");
		ar.setemail("varun@gmail.com");
		ar.setpass("987654321");
		ar.confirmpass("987654321");
		ar.clickagree();
		ar.submit();
		
		
		if (ar.validateText().equals("Your Account Has Been Created!")) {
			logger.info("Registration successful");
			Assert.assertTrue(true);
		}else {
			logger.info("Registration failed");
			Assert.fail();
		}
	}
}
