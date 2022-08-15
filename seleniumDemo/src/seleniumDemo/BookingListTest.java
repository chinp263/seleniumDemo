package seleniumDemo;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.devtools.v100.network.Network.GetResponseBodyResponse;
import org.openqa.selenium.devtools.v100.network.model.RequestId;
import org.openqa.selenium.devtools.v100.network.model.Response;
import org.testng.annotations.Test;
import org.json.simple.JSONArray;

public class BookingListTest extends BaseTest{
	
	public static Logger log = LogManager.getLogger(BookingListTest.class);

	
	@Test
	public void BookingDateFilter() {
		LoginPage loginpage = new LoginPage(driver);
		BookingListPage bookinglist = new BookingListPage(driver);
		loginpage.verifyLogin("tuyen.hoangvan@powergatesoftware.com", "123456Aa@");
		checkAPIResponse();
		System.out.print("Success");
		log.info("Login success");
		bookinglist.openBookingPage();
		log.info("Booking page is opened successfully");
		bookinglist.selectDateFilter();
		bookinglist.getBookingListByDate();
	}
	
	public void checkAPIResponse() {
		DevTools devtools = ((ChromeDriver) driver).getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));	
		//devtools.addListener(Network.requestWillBeSent(), null);
		devtools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			log.info(res.getUrl().toString());
			log.info(res.getStatus());
			RequestId reqid = response.getRequestId();
			log.info(reqid.toJson());
			String reqbody = devtools.send(Network.getResponseBody(reqid)).getBody();
			log.info(reqbody);
		});
	}
}
