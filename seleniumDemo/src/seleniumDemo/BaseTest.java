package seleniumDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	
	public WebDriver driver = null;
	public static String driverPath = "/Users/chinguyen/Downloads/chromedriver";
	String urlLogin = "https://login-test3.goodhuman.me/login?redirect=https://team-test3.goodhuman.me";
	String urlDashboard = "https://team-test3.goodhuman.me/dashboard";
	
	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.navigate().to(urlLogin);
		//return driver;
	}
}
