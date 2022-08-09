package seleniumDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;

public class BookingListPage {
	WebDriver driver;
	DevTools devtools;
	
	By dateFilter = By.xpath("//b[contains(text(), 'Date')]");
	By selectDate = By.xpath("//div[contains(text(), 'Today')]");
	By applyBtn = By.xpath("//span[contains(text(), 'Apply')]");
	By bookingDate = By.xpath("//div[@class='pr-small']/span"); 
	
//	WebElement dateFilter = driver.findElement(By.xpath("//b[contains(text(), 'Dates')]"));
//	WebElement selectDate = driver.findElement(By.xpath("//div[contains(text(), 'Today')]"));
//	WebElement applyBtn = driver.findElement(By.xpath("//span[contains(text(), 'Apply')]"));
//	List<WebElement> bookingDate = driver.findElements(By.xpath("//div[@class='pr-small']/span"));
	//WebElement teamMemberFilter = driver.findElement(By.xpath("//b[contains(text(), 'Team member')]"));
	
	public BookingListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openBookingPage() {
		WebElement menu = driver.findElement(By.className("anticon-menu-unfold"));
		WebElement bookingpage = driver.findElement(By.cssSelector("ul li:nth-of-type(2)"));
		menu.click();
		bookingpage.click();
	}
	
	public void selectDateFilter() {
		driver.findElement(dateFilter).click();
		driver.findElement(selectDate).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(applyBtn));
	}
	
	public String DateStartsWith() {
		Date today = Calendar.getInstance().getTime();
		DateFormat dateformat = new SimpleDateFormat("EEE d");
		String todayDate = dateformat.format(today);
		return todayDate;
	}
	
	public String DateEndsWith() {
		Date today = Calendar.getInstance().getTime();
		DateFormat dateformat = new SimpleDateFormat("MMM ''yy");
		String todayDate = dateformat.format(today);
		return todayDate;
	}
	
//	public String[] getTodayDate2() {
//		Calendar today2 = Calendar.getInstance();
//		String[] checkmultiday = new String[2];
//		DateFormat dateformat = new SimpleDateFormat("EEE d MMM ''yy");
//		checkmultiday[0]= dateformat.format(today2);
//		String monthyear = new SimpleDateFormat("MMM ''y").format(today2);
//		checkmultiday[1] = monthyear;
//		return checkmultiday;
//	}
	
	public void getBookingListByDate() {
		int totalBookingNumber = driver.findElements(bookingDate).size();
		//String[] multiday = getTodayDate2();
		//String date = multiday[0].toString();
		System.out.print(totalBookingNumber);
		for (int i = 1; i <= totalBookingNumber; i++) {
			WebElement bookingItem = driver.findElement(By.cssSelector("tbody tr.evenodd:nth-of-type("+i+") div.pr-small span"));
			String bookingCurrentDate = bookingItem.getText();
			System.out.print(bookingCurrentDate);
//			Assert.assertEquals(bookingCurrentDate, getTodayDate());
			Assert.assertTrue(bookingCurrentDate.startsWith(DateStartsWith()) && bookingCurrentDate.endsWith(DateEndsWith()));
			}
	}
}
	
//	public static void main(String[] args) {
//		BookingListPage bookinglist = new BookingListPage();
//		System.out.print(bookinglist.getTodayDate());
//	}
