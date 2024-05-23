/* 
* @CalenderPage.java   
* Copyright (c) 2022-2023 
*/
/**
 * Description(Implementing the feature of calendar automation)
 * @author Nishija 
 * @version 00:00:01
 * @see <com.SeleniumTestPages.CalenderPage>
 */
package com.SeleniumTestPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"datepicker2\"]")
	WebElement calendar;
	@FindBy(xpath = "//*[@title=\"Change the month\"]")
	WebElement monthDropdown;
	@FindBy(xpath = "//*[@title=\"Change the year\"]")
	WebElement yearDropdown;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/select[2]/option[1]")
	WebElement upArrow;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/select[2]/option[23]")
	WebElement backArrow;

	// Class constructor
	public CalenderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Description:Method for selecting a user-specified day, month, and year from
	 * the calendar (via a dropdown).
	 * 
	 * @param month: for selecting a user-specified month from the dropdown
	 * @param year:  for selecting a user-specified year from the dropdown
	 * @param day:   for selecting a user-specified day from the calendar
	 */
	public void calenderAutomation(String month, String year, int day) throws InterruptedException {

		boolean clicked = false;
		calendar.click();

		// Selecting user specified month from the dropdown using select method
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText(month);

		// Storing current dropdown values in a list
		yearDropdown.click();
		Select yearSelect_Default = new Select(yearDropdown);
		List<WebElement> currentYearList = yearSelect_Default.getOptions();
		System.out.println(currentYearList.get(1).getText());

		// Storing the value of first and last index to the variables
		int minValue = Integer.parseInt(currentYearList.get(1).getText());
		int maxValue = Integer.parseInt(currentYearList.get(21).getText());

		/*
		 * Checking that the user-specified year is less than the first year in the
		 * current list. If the condition is true, click on the upper arrow, and all
		 * values are stored in a list. If the user-specified year exists in the list,
		 * selecting the specified year.
		 */
		if (minValue > Integer.parseInt(year)) {
			while (true) {
				upArrow.click();
				yearDropdown.click();
				Select yearSelect = new Select(yearDropdown);
				List<WebElement> year_List = yearSelect.getOptions();
				System.out.println(year_List.get(1).getText());

				for (WebElement options : year_List) {
					String stringList = options.getText();
					System.out.println(stringList);
					if (stringList.equals(year)) {
						driver.findElement(By.xpath("//option[contains(text()," + year + ")]")).click();
						clicked = true;
						break;
					}
				}

				if (clicked) {
					break;
				}
			}

		}
		
		/*
		 * Checking that the user-specified year is grater than the last year in the
		 * current list. If the condition is true, click on the lower arrow, and all
		 * values are stored in a list. If the user-specified year exists in the list,
		 * selecting the specified year.
		 */
		else if (maxValue < Integer.parseInt(year)) {
			while (true) {

				backArrow.click();
				yearDropdown.click();

				Select yearSelect = new Select(yearDropdown);
				List<WebElement> year_List = yearSelect.getOptions();
				System.out.println(year_List.get(1).getText());
				for (WebElement options : year_List) {
					String stringList = options.getText();
					System.out.println(stringList);
					if (stringList.equals(year)) {
						driver.findElement(By.xpath("//option[contains(text()," + year + ")]")).click();
						clicked = true;
						break;
					}
				}
				if (clicked) {
					break;
				}
			}

		}
		
		/*
		 * Stored all the values of the current list in a list. If user-specified year
		 * is exist on the current list selecting the specified year.
		 */
		else {

			for (WebElement options : currentYearList) {
				String stringList = options.getText();
				System.out.println(stringList);
				if (stringList.equals(year)) {

					driver.findElement(By.xpath("//option[contains(text()," + year + ")]")).click();
					break;
				}

			}

		}
		
		/*
		 * Checking the user-specified day is grater than 31 and less than 0 If the
		 * user-specified day between 31 and 0 selecting the specified day.
		 */
		if (day <= 31 && day > 0) {
			driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text()," + day + ")]")).click();

		} else {
			System.out.println("please enter a valid day");
		}

	}
}
