package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
	WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
	WebElement submit_login=driver.findElement(By.xpath("//input[@value='Login']"));
	
	
	public void clickEmail(String eml) {
		email.sendKeys(eml);;
	}
	public void clickPassword(String pwd) {
		password.sendKeys(pwd);;
	}
	public void clickSubmitLogin() {
		submit_login.click();
	}
	public String validateLogin() {
		try {
			return driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
}