package demotester;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSetup {

	public static WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void initialize() throws IOException {

		System.setProperty("webdriver.chrome.driver","/Users/chinguyen/Downloads/chromedriver");
	
		driver = new ChromeDriver();
	
		// To maximize browser
		driver.manage().window().maximize();
	
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		// To open Gmail site
		driver.get("https://login-test3.goodhuman.me/login?redirect=https://team-test3.goodhuman.me");
	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		BaseSetup.driver.quit();
	}
}

