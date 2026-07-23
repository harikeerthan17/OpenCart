package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage{
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	WebElement logout=driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
	
	public void clickLogout() {
		logout.click();
	}
}
