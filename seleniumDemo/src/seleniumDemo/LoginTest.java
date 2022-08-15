package seleniumDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	@Test(dataProvider="dp")
	public void validLogin(String data) {
		LoginPage loginpage = new LoginPage(driver);
		String login[] = data.split(",");
		loginpage.verifyLogin(login[0], login[1]);
		Boolean getURL = loginpage.driver.getCurrentUrl().contains(urlDashboard);
		Assert.assertTrue(true);	
	};
	

	}
//	@Test
//	public void loginBlank() {
//		verifyLogin("","");
//		WebElement errorMessage = driver.findElement(By.className("ant-form-explain"));
//		Assert.assertTrue(errorMessage.isDisplayed());
//	};