package testCases;

import org.testng.annotations.Test;

import pageObjects.LogoutPage;

public class TC04_Logout extends BaseClass{
	@Test(groups= {"Sanity"})
	public void logoutCase() {
		LogoutPage ltp=new LogoutPage(driver);
		ltp.clickLogout();
	}
}
