/* 
* @TestCases.java  26/12/22 
* Copyright (c) 2022-2023 
*/
/**
 * Description(Testcases for diffrent webapplications(Calender,Alert handling,dropdown,frames)
 * @author Nishija 
 * @version 00:00:01
 * @see <com.SeleniumWebdriver.TestCases>
 */
package com.SeleniumWebdriverTest;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.SeleniumTestPages.AlertPage;
import com.SeleniumTestPages.CalenderPage;
import com.SeleniumTestPages.DropdownPage;
import com.SeleniumTestPages.Frames;
import com.SeleniumWebdriver.DriverClass;

public class AlertTest extends DriverClass {

	AlertPage alertpage;
	
	// Test for alert handling
	@Test(priority = 2, enabled = true)
	public void verifyAlerts() {
		alertpage = new AlertPage(driver);
		alertpage.alertBoxAccept();
		alertpage.alertBoxDismiss();
		alertpage.prompt();
	}

	

}
