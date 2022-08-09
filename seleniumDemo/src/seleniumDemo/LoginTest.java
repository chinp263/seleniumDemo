package seleniumDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import demotester.SignInPage;

public class LoginTest extends BaseTest {
	@Test
	public void validLogin() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.verifyLogin("linhvu@yopmail.com","Abc@123456");
		Boolean getURL = loginpage.driver.getCurrentUrl().contains(urlDashboard);
		Assert.assertTrue(true);
	};
//	@Test
//	public void loginBlank() {
//		verifyLogin("","");
//		WebElement errorMessage = driver.findElement(By.className("ant-form-explain"));
//		Assert.assertTrue(errorMessage.isDisplayed());
//	};
}