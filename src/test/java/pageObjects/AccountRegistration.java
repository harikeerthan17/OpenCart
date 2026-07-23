package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountRegistration extends BasePage {
	public AccountRegistration(WebDriver driver) {
		super(driver);
	}
	WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
	WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
	WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
	WebElement telephone=driver.findElement(By.xpath("//input[@name='telephone']"));
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	WebElement confirm_pwd=driver.findElement(By.xpath("//input[@name='confirm']"));
	WebElement agree_ch_box=driver.findElement(By.xpath("//input[@name='agree']"));
	WebElement clickSubmit=driver.findElement(By.xpath("//input[@type='submit']"));
//	WebElement validationtext=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
	public void setFirstname(String fstname) {
		firstname.sendKeys(fstname);
	}
	public void setLastname(String lstname) {
		lastname.sendKeys(lstname);
	}
	public void setemail(String eml) {
		email.sendKeys(eml);
	}
	public void settelephone(String tel) {
		telephone.sendKeys(tel);
	}
	public void setpass(String pwd) {
		password.sendKeys(pwd);
	}
	public void confirmpass(String con_pwd) {
		confirm_pwd.sendKeys(con_pwd);
	}
	public void clickagree() {
		agree_ch_box.click();
	}
	public void submit() {
		clickSubmit.click();
	}
	public String validateText() {
		try {
			return driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
}
