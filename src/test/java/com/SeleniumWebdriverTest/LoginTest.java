package com.SeleniumWebdriverTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SeleniumWebdriver.DriverClass;
import com.SeleniumTestPages.LoginPage;

import org.testng.annotations.Test;

public class LoginTest extends DriverClass{
	LoginPage loginpage;
	WebDriverWait wait;
	public static Properties loc = new Properties();

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() {
		return new Object[][] {

			/*	{ "vt@testvox.com", "  ", "Please fill out the field" },
				{ " ", "vt@testvox.com", "Please fill out the field" }, { "  ", "  ", "Please fill out the field" },
				{ "vt@testvox.com", "abc", "*Incorrect Credentials! Try again" },
				{ "abc", "vt@testvox.com", "*Incorrect Credentials! Try again" },
				{ "abc", "def", "*Incorrect Credentials! Try again" }, { "Admin", "admin123", " " }, };
	*/
			
			{ "vt@testvox.com", "  ", "Required" },
			{ " ", "abc", "Required" },
			{ "  ", "  ", "Required" },
			{ "Admin", "abc", "Invalid credentials" },
			{ "abc", "admin123", "Invalid credentials" },
			{ "vt@testvox.com", "abc", "Invalid credentials" },
			{ "Admin", "admin123", "Valid" },
			 };
			
			}

	//Test for login
	@Test(dataProvider = "loginCredentials")
	public void loginfunction(String UserName, String Password,String Errormessage) throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		WebElement username = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys(Keys.CONTROL + "t");
		username.clear();
		username.sendKeys(UserName);
		Thread.sleep(100);

		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@Placeholder='Password']")));
		password.sendKeys(Keys.CONTROL + "t");
		password.clear();
		password.sendKeys(Password);
		Thread.sleep(100);

		WebElement loginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		loginButton.sendKeys(Keys.CONTROL + "t");
		loginButton.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		
		
	}
	
}
