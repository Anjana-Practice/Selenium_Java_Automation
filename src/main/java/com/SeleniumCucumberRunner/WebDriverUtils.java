/* 
* @(#)WebDriverUtils.java 2.12 21/12/22 
* Copyright (c) 2022-2023 
*/
/**
 * Description(webdriver initialization)
 * @author sruthirajk 
 * @version 00:00:01
 * @see <com.SeleniumCucumberRunner.WebDriverUtils>
 */

package com.SeleniumCucumberRunner;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

	protected static WebDriver driver;

// To set Webdriver
	public static void setDriver(WebDriver webDriver) {
		if (driver == null) {
			driver = webDriver;
		}
	}

	// To get the getdriver
	public static WebDriver getDriver() {
		if (driver == null) {
			throw new AssertionError("Driver is null. Initialize driver before calling this method.");
		}
		return driver;
	}
}
