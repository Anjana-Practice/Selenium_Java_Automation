/* 
* @PIMPageTestCase.java  28/12/22 
* Copyright (c) 2022-2023 
*/
/**
 * Description(Testcases for adding a employee)
 * @author Anandu Raj 
 * @version 00:00:01
 * @see <com.SeleniumWebdriver.PIMPageTestCase>
 */

package com.SeleniumWebdriverTest;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.SeleniumTestPages.PIMPage;
import com.SeleniumWebdriver.DriverClass;

public class PIMPageTestcase extends DriverClass {

	PIMPage pimpage;
	@Test
	public void verifyAddEmployee() throws IOException, ParseException {
		pimpage = new PIMPage(driver);
		pimpage.addEmployeeForm();
		pimpage.setFirstName();
		pimpage.setMidddleName();
		pimpage.setFirstName();
		pimpage.createLoginDetails();
		pimpage.createLoginDetails();
		pimpage.createLoginDetails();
		pimpage.setConfirmPassword();
		pimpage.save();
	}
}
