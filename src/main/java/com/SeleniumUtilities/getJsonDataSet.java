/**
 * @(#)JsonReader.java
 * Copyright (c) 2022-2023
 
 * Description: To Read the josn files.
 * @author shakira 
 * @version 00:00:01
 * @see <com.SeleniumUtilities.JsonReader>
 * usage : String firstName=(String)user.get("firstName");
*/

package com.SeleniumUtilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;

public class getJsonDataSet {
	/**
	 * Class used for parsing the json file.
	 */
	
	//Get configuration data list as an array
	public List<String> getDataSet(File configDataFile) throws IOException, ParseException{			
		/**
		 * Method used for parsing the json file, and return as string array. Accessing the elements based on the index
		 * dataSet[0] - Suite name
		 * dataSet[1] - Browser name
		 * dataSet[2] - Test case name
		 * dataSet[3] - Test class name
		 * dataSet[4] - Browser version
		 * dataSet[5] - Application name
		 * dataSet[6] - Application URL
		 * @param File configDataFile - Full path of the json file to be parse and return the details.
		 * @return List<String> dataSet - String data dataSet array.
		 */	
		// Declaring dataSet String array.
		List<String> dataSet = new ArrayList<String>();
		
		//Read data from json
	    JsonReader jsonReaderObj = new JsonReader();
	    
	    //Get Suite
	    String suiteKey = jsonReaderObj.readJsonConfig(configDataFile, "ExecutionConfig", "Suite");
	    String executionSuite = jsonReaderObj.readJsonConfig(configDataFile, "Suites", suiteKey);
	    dataSet.add(executionSuite);
	    		
		//Get Browser
		String executionBrowserKey = jsonReaderObj.readJsonConfig(configDataFile, "ExecutionConfig", "Browser");
	    String executionBrowser = jsonReaderObj.readJsonConfig(configDataFile, "Browsers", executionBrowserKey);
	    dataSet.add(executionBrowser);
	    		
		//Get Test Case
		String executioTestCaseKey = jsonReaderObj.readJsonConfig(configDataFile, "ExecutionConfig", "TestCase");
	    String executionTestCase = jsonReaderObj.readJsonConfig(configDataFile, "TestCases", executioTestCaseKey);
	    dataSet.add(executionTestCase);
	   	    
	    //Get Test Class
		String executioTestClassKey = jsonReaderObj.readJsonConfig(configDataFile, "ExecutionConfig", "TestClass");
	    String executionTestClass = jsonReaderObj.readJsonConfig(configDataFile, "TestClasses", executioTestClassKey);
	    dataSet.add(executionTestClass);
	   	    
	    //Get Browser Version 
	    String executionBrowserVersion = jsonReaderObj.readJsonConfig(configDataFile, "Browsers_version", executionBrowserKey);
	    dataSet.add(executionBrowserVersion);
	    	    
	    //Get application name and URL
	    String applicationName = jsonReaderObj.readJsonConfig(configDataFile, "ExecutionConfig", "application");
	    dataSet.add(applicationName);
	    
	    //Get application URL
	    String applicationURL = jsonReaderObj.readJsonConfig(configDataFile, "AppUrls", applicationName);
	    dataSet.add(applicationURL);
	    
	    //Return string array
	    return dataSet;
	}
}
