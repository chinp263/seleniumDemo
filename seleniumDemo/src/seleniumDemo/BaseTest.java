package seleniumDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

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
	
	@DataProvider (name="dp")
	public String[] JsonData() throws IOException, ParseException {
		JSONParser jsonParse = new JSONParser();
		FileReader reader = new FileReader("jsonfiles/testdata.json");
		Object obj = jsonParse.parse(reader);
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jsonObj.get("userlogin");
		String[] arr = new String[jsonArray.size()];
		for (int i=0; i<arr.length; i++) {
			JSONObject jsonlogin = (JSONObject) jsonArray.get(i);
			String username = (String) jsonlogin.get("email");
			String pwd = (String) jsonlogin.get("password");
			arr[i] = username + "," + pwd;
		}
		return arr;
		
	}
	
	
}
