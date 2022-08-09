package demotester;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import demotester.SignInPage;

public class SignInTest extends BaseSetup {

	@Test
	public void init() throws Exception {

		// driver.get("https:// www.gmail.com");
		SignInPage loginpage =
		PageFactory.initElements(driver, SignInPage.class);
	
		loginpage.setEmail("linhvu@yopmail.com");
		loginpage.clickOnNextButton();
		loginpage.setPassword("Abc@123456");
		loginpage.clickOnNextButton();
		Assert.assertEquals(driver.getCurrentUrl(),"https://team-test3.goodhuman.me/dashboard");
	}
}

