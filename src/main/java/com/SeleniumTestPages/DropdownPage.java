/* 
* @DropdownPage.java   
* Copyright (c) 2022-2023 
*/
/**
 * Description(implementing wrappers for selecting options from the dropdown using select methods)
 * @author Nishija 
 * @version 00:00:01
 * @see <com.SeleniumTestPages.DropdownPage>
 */
package com.SeleniumTestPages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.SeleniumAssertion.Assertions;
import com.SeleniumUtilities.BrowserActions;

public class DropdownPage extends BrowserActions {
	WebDriver driver;

	By dropdownboxSingleSelect = By.xpath("//*[@id=\"mySelect\"]");
	By dropdownboxMultiSelect = By.xpath("//*[@id=\"cars\"]");

	// Class constructor
	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for selecting single value from the dropdown
	public void singleSelectDropdown() throws IOException {
		Assertions.validateAssertion(dropDownSingleSelect(dropdownboxSingleSelect, "Orange", "Visible Text"));
		Assertions.validateAssertion(dropDownSingleSelect(dropdownboxSingleSelect, "banana", "Value"));
		Assertions.validateAssertion(dropDownSingleSelect(dropdownboxSingleSelect, "2", "Index"));
		
	}

	// Method for selecting multiple values from the dropdown by using
	// visibletext,value,index method
	public void multiSelectDropdown() throws IOException {
		String[] arrayVisibleText = { "Opel", "Saab" };
		String[] arrayValue = { "volvo", "audi" };
		String[] arrayIndex = { "1", "3" };
		Assertions.validateAssertion(dropDownMultiSelect(dropdownboxMultiSelect, arrayVisibleText, "Visible Text"));
		Assertions.validateAssertion(
				dropDownMultiSelectDeSelect(dropdownboxMultiSelect, arrayVisibleText, "Visible Text"));
		Assertions.validateAssertion(dropDownMultiSelect(dropdownboxMultiSelect, arrayValue, "Value"));
		Assertions.validateAssertion(dropDownMultiSelectDeSelect(dropdownboxMultiSelect, arrayValue, "Value"));
		Assertions.validateAssertion(dropDownMultiSelect(dropdownboxMultiSelect, arrayIndex, "Index"));
		Assertions.validateAssertion(dropDownMultiSelectDeSelect(dropdownboxMultiSelect, arrayIndex, "Index"));
		Assertions.validateAssertion(dropDownMultiSelect(dropdownboxMultiSelect, arrayVisibleText, "Visible Text"));
		Assertions.validateAssertion(dropDownMultiSelectDeSelectAll(dropdownboxMultiSelect));
	}
}
