package demotester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	@FindBy(id="login")
	WebElement emailTextBox;

	@FindBy(id="password")
	WebElement passwordTextBox;
	
	@FindBy(css="[type='submit']")
	WebElement nextButton;

	// Defining all the user actions (Methods)
	//that can be performed in the Facebook home page

	// This method is to set Email in the email text box
	public void setEmail(String strEmail) {
			emailTextBox.sendKeys(strEmail);
		}
		// This method is to set Password in the password text box
	public void setPassword(String strPassword) {
			passwordTextBox.sendKeys(strPassword);
		}
		// This method is to click on Next Button
	public void clickOnNextButton() {
		nextButton.click();
	}
}

