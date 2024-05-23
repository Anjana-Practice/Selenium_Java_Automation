/* 
* @LoginPage.java  
* Copyright (c) 2022-2023 
*/
/**
 * Description(Implementing Login page features)
 * @author Asish 
 * @version 00:00:01
 * @see <com.SeleniumTestPages.LoginPage>
 */

package com.SeleniumTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// Class constructor
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

