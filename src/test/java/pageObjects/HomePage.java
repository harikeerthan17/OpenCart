package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	WebElement myAccount=driver.findElement(By.xpath("//span[text()='My Account']"));
	WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));
	WebElement loginbtn=driver.findElement(By.xpath("//a[normalize-space()='Login']"));
	
	public void clickAccount() {
		myAccount.click();
	}
	public void clickRegister() {
		register.click();
	}
	public void clickLogin() {
		loginbtn.click();
	}
}
