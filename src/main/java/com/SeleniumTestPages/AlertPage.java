/* 
* @AlertPage.java   
* Copyright (c) 2022-2023 
*/
/**
 * Description(Implementing wrappers for alert handling by either accepting or dismissing alerts)
 * @author Nishija 
 * @version 00:00:01
 * @see <com.SeleniumTestPages.AlertPage>
 */
package com.SeleniumTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.SeleniumAssertion.Assertions;
import com.SeleniumUtilities.BrowserActions;

public class AlertPage extends BrowserActions {
	WebDriver driver;
	By alertWithOK = By.xpath("//*[text()=\"Alert with OK \"]");
	By alertWithOKandCancel = By.xpath("//*[text()=\"Alert with OK & Cancel \"]");
	By alertwithTextbox = By.xpath("//*[text()=\"Alert with Textbox \"]");
	By alertBoxAlertWithOK = By.xpath("//*[@onclick=\"alertbox()\"]");
	By alertBoxAlertWithOKandCancel = By.xpath("//*[text()=\"click the button to display a confirm box \"]");
	By alertBoxAlertwithTextbox = By.xpath("//*[text()=\"click the button to demonstrate the prompt box \"]");

	// Class constructor
	public AlertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for accepting an alert
	public void alertBoxAccept() {
		Assertions.validateAssertion(isAlertPresentHandle(alertBoxAlertWithOK, "Accept"));

	}

	// Method for dismissing an alert

	public void alertBoxDismiss() {
		Assertions.validateAssertion(clickElement(alertWithOKandCancel));
		Assertions.validateAssertion(isAlertPresentHandle(alertBoxAlertWithOKandCancel, "Dismiss"));

	}

	// Method for handling an prompt
	public void prompt() {
		Assertions.validateAssertion(clickElement(alertwithTextbox));
		Assertions.validateAssertion(isAlertPresentHandle(alertBoxAlertwithTextbox, "Accept"));

	}
}
