package com.SeleniumWebdriverTest;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.SeleniumTestPages.CalenderPage;
import com.SeleniumWebdriver.DriverClass;


public class CalenderTest extends DriverClass {

	CalenderPage calanderpage;

	// Test for automating calendar
	@Test(priority = 1, enabled = true)
	public void verifyCalender() throws InterruptedException {
		calanderpage = new CalenderPage(driver);
		calanderpage.calenderAutomation("June", "1756", 21);
	}
	
}