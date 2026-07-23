package testCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;

public class TC03_SearchProduct extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void SearchProduct() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SearchProduct sp=new SearchProduct(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("Test execution started");
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		logger.info("Login page appeared");
		
		LoginPage lp=new LoginPage(driver);
		lp.clickEmail("hakkajaak@gmail.com");
		logger.info("Email entered");
		lp.clickPassword("82738300");
		logger.info("password entered");
		lp.clickSubmitLogin();
		
		
		sp.searchProduct("Laptop");
		System.out.println("Value entered");
		sp.clickSearchIcon();
		System.out.println("Clicked on search icon");
	}
}
