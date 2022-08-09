package seleniumDemo;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait;
	
	WebDriver driver;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="[type='submit']")
	WebElement submit;
	

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogin(String email, String pw) {
		driver.findElement(By.id("login")).sendKeys(email);;
		password.sendKeys(pw);
		submit.click();
	};

}