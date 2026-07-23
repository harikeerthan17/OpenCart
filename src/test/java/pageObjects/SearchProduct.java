package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct extends BasePage {
	public SearchProduct(WebDriver driver) {
		super(driver);
	}
	WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search']"));
	WebElement searchicon=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']/parent::span/parent::div"));
	public void searchProduct(String srch) {
		search.sendKeys(srch);
	}
	public void clickSearchIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
		    wait.until(ExpectedConditions.elementToBeClickable(searchicon));
		    System.out.println("Search icon is clickable");
		} catch (Exception e) {
		    System.out.println("Search icon is NOT clickable");
		}
	}
}
