/* 
* @PIMPage.java 
* Copyright (c) 2022-2023 
*/
/**
 * Description(Implementing wrappers in PIM Page for Add Employee feature)
 * @author Asish 
 * @version 00:00:01
 * @see <com.SeleniumTestPages.PIMPage>
 */

package com.SeleniumTestPages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.SeleniumAssertion.Assertions;
import com.SeleniumUtilities.BrowserActions;
import com.SeleniumUtilities.JsonReader;

public class PIMPage extends BrowserActions {
	WebDriver driver;

	By addEmployee = By.xpath("//*[text()='Add Employee']");
	By pim = By.xpath("//*[text()='PIM']");
	By firstname = By.xpath("//*[@name=\"firstName\"]");
	By middlename = By.xpath("//*[@name=\"middleName\"]");
	By lastname = By.xpath("//*[@name=\"lastName\"]");
	By createlogindetails = By.xpath("//*[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]");
	By createlogindetailsusername = By.xpath("(//*[@class=\"oxd-input oxd-input--active\"] )[3]");
	By createlogindetailspassword = By.xpath("(//*[@type=\"password\"])[1]");
	By createlogindetailsconfirmpassword = By.xpath("(//*[@type=\"password\"])[2]");
	By saveButton = By.xpath("//*[text()=' Save ']");
	By report = By.xpath("//*[text()='Reports']");
	By reportName = By.xpath("//*[@placeholder=\"Type for hints...\"]");
	By search = By.xpath("//*[text()=' Search ']");

	// Class constructor
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for generating Add Employee form
	public void addEmployeeForm() {
		Assertions.validateAssertion(clickElement(pim));
		Assertions.validateAssertion(checkElementVisibility(addEmployee));
		Assertions.validateAssertion(clickElement(addEmployee));
	}

	// Method for reading from Json file and Appending the Calendar instance
	public String readJsonData(String dataKey) throws IOException, ParseException {
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		StringBuffer tmp = new StringBuffer();

		if (employeeDataFile.exists()) {
			System.out.println(tmp.append(employeeDataFile).append(" is a valid path").toString());
		} else {
			System.out.println(tmp.append(employeeDataFile).append(" is not a valid path").toString());
		}

		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String data = (String) userDetails.get(dataKey);
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss:");
		long timeMilli = date.getTime();
		String strDate = dateFormat.format(date);

		StringBuffer tmpa = new StringBuffer();
		String dataValue = tmpa.append(data).append(strDate).append(timeMilli).toString();
		return dataValue;
	}

	// Method for entering First Name
	public void setFirstName() throws IOException, ParseException {
		String firstName = readJsonData("firstName");
		Assertions.validateAssertion(checkElementVisibility(firstname));
		Assertions.validateAssertion(performSendkeys(firstname, firstName));
	}

	// Method for entering Middle Name
	public void setMidddleName() throws IOException, ParseException {
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		if (employeeDataFile.exists()) {
			System.out.println(employeeDataFile);
		} else {
			System.out.println(employeeDataFile + " no valid path");
		}
		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String mName = (String) userDetails.get("middleName");
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss:");
		long timeMilli = date.getTime();
		String strDate = dateFormat.format(date);
		String middleName = mName + strDate + timeMilli;
		Assertions.validateAssertion(performSendkeys(middlename, middleName));
	}

	// Method for entering Last Name
	public void setLastName() throws IOException, ParseException {
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		if (employeeDataFile.exists()) {
			System.out.println(employeeDataFile);
		} else {
			System.out.println(employeeDataFile + " no valid path");
		}
		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String lName = (String) userDetails.get("lastName");
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss:");
		long timeMilli = date.getTime();
		String strDate = dateFormat.format(date);
		String lastName = lName + strDate + timeMilli;
		Assertions.validateAssertion(performSendkeys(lastname, lastName));
	}

	// Method for clicking Create Login Details button
	public void createLoginDetails() {
		Assertions.validateAssertion(clickElement(createlogindetails));
	}

	// Method for entering new Username
	public void setCreateLoginDetailsUsername() throws IOException, ParseException {
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		if (employeeDataFile.exists()) {
			System.out.println(employeeDataFile);
		} else {
			System.out.println(employeeDataFile + " no valid path");
		}
		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String nUserName = (String) userDetails.get("newusername");
		String regexUsername = (String) userDetails.get("usernameRegex");
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss:");
		long timeMilli = date.getTime();
		String strDate = dateFormat.format(date);
		String newUserName = nUserName + strDate + timeMilli;
		Assertions.validateAssertion(performSendkeys(createlogindetailsusername, newUserName));
		if (newUserName.matches(regexUsername)) {
			System.out.println("Valid new username");
		} else if (!newUserName.matches(regexUsername)) {
			System.out.println("Should be least 5 characters");
		}

	}

	// Method for entering new Password
	public void setCreateLoginDetailsPassword() throws IOException, ParseException {
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		if (employeeDataFile.exists()) {
			System.out.println(employeeDataFile);
		} else {
			System.out.println(employeeDataFile + " no valid path");
		}
		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String newPassword = (String) userDetails.get("newpassword");
		String regexPassword = (String) userDetails.get("passwordRegex");
		Assertions.validateAssertion(performSendkeys(createlogindetailspassword, newPassword));
		if (newPassword.matches(regexPassword)) {
			System.out.println("Valid new password");
		} else if (!newPassword.matches(regexPassword)) {
			System.out.println(
					"Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password");
		}
	}

	// Method for confirming the password
	public void setConfirmPassword() throws IOException, ParseException {
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		if (employeeDataFile.exists()) {
			System.out.println(employeeDataFile);
		} else {
			System.out.println(employeeDataFile + " no valid path");
		}
		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String newPassword = (String) userDetails.get("newpassword");
		String confirmPassword = (String) userDetails.get("confirmnewpassword");
		Assertions.validateAssertion(performSendkeys(createlogindetailsconfirmpassword, confirmPassword));
		if (confirmPassword.equals(newPassword)) {
			System.out.println("Passwords match each other");
		} else {
			System.out.println("Passwords do not match");
		}
	}

	// Method for saving the Add Employee form
	public void save() {
		Assertions.validateAssertion(clickElement(saveButton));
	}

	// Method for generating report
	public void report() throws IOException, ParseException {
		Assertions.validateAssertion(clickElement(report));
		File employeeDataFile = new File("./src/test/resources/EmployeeData.json");
		if (employeeDataFile.exists()) {
			System.out.println(employeeDataFile);
		} else {
			System.out.println(employeeDataFile + " no valid path");
		}
		int employeeIndex = 0;
		JsonReader jsonReaderObj = new JsonReader();
		JSONObject userDetails = jsonReaderObj.readJsonEmployeeDetails(employeeDataFile, employeeIndex);
		String reportSearchName = (String) userDetails.get("reportSearchName");
		Assertions.validateAssertion(performSendkeys(reportName, reportSearchName));
		Assertions.validateAssertion(clickElement(search));
	}
}
