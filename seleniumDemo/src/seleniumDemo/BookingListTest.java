package seleniumDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class BookingListTest extends BaseTest{
	
	public static Logger log = LogManager.getLogger(BookingListTest.class);

	
	@Test
	public void BookingDateFilter() {
		LoginPage loginpage = new LoginPage(driver);
		BookingListPage bookinglist = new BookingListPage(driver);
		loginpage.verifyLogin("tuyen.hoangvan@powergatesoftware.com", "123456Aa@");
		System.out.print("Success");
		log.info("Login success");
		log.error("this is error");
		log.warn("this is a warning");
		bookinglist.openBookingPage();
		log.info("Booking page is opened successfully");
		bookinglist.selectDateFilter();
		bookinglist.getBookingListByDate();
	}
}
