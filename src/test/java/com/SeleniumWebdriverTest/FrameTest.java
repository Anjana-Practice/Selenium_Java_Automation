package com.SeleniumWebdriverTest;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.SeleniumTestPages.AlertPage;
import com.SeleniumTestPages.CalenderPage;
import com.SeleniumTestPages.DropdownPage;
import com.SeleniumTestPages.Frames;
import com.SeleniumWebdriver.DriverClass;

public class FrameTest extends DriverClass {

	
	Frames frames;
	
	// Test for iframes
		@Test(priority = 4, enabled = true)
		public void verifyIframes() throws InterruptedException, IOException {
			frames = new Frames(driver);
			frames.handleIframes();
			
		}
	
}