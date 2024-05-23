/* 
* @Frames.java  
* Copyright (c) 2022-2023 
*/
/**
 * Description(Implementing wrappers for Iframes)
 * @author Asish 
 * @version 00:00:01
 * @see <com.SeleniumTestPages.Frames>
 */

package com.SeleniumTestPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.SeleniumAssertion.Assertions;
import com.SeleniumUtilities.BrowserActions;

public class Frames extends BrowserActions {
	WebDriver driver;

	By FirstIframe = By.xpath("//iframe[@src='MultipleFrames.html']");
	By SecondIframe = By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']");
	By IframeWithInAnIframeButton = By.xpath("//a[text()='Iframe with in an Iframe']");
	By iframeTextbox = By.xpath("//input[@type='text']");
	By homeButton = By.xpath("//*[text()='Home']");

	// Class constructor
	public Frames(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for handling Iframes
	public void handleIframes() throws InterruptedException, IOException {
		Assertions.validateAssertion(clickElement(IframeWithInAnIframeButton));
		//Thread.sleep(200);
		Assertions.validateAssertion(switchToFrame(FirstIframe));
		//Thread.sleep(200);
		Assertions.validateAssertion(switchToFrame(SecondIframe));
		//Thread.sleep(200);
		Assertions.validateAssertion(performSendkeys(iframeTextbox, "Hello"));
		//Thread.sleep(200);
		Assertions.validateAssertion(switchToParentWindow());
		//Thread.sleep(200);
		Assertions.validateAssertion(clickElement(homeButton));
		//Thread.sleep(200);
		System.out.println("Title -->" + driver.getTitle());

	}

}
