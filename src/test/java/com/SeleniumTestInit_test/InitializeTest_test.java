/**
 * Initialize the test from here.
 * Read the ./src/main/resources/config.json and update the testNG xml 
 * start the execution.
 */

/**
 * @(#)InitializeTest.java
 * 
 * Copyright (c) 2022-2023
 
 * Description: To Initialize the test.
 * Read the ./src/main/resources/config.json, update the testNG xml and 
 * start the execution.
 * author shakira 
 * @version 00:00:01
 * @see <com.SeleniumTestInit.InitializeTest>
 * 
*/

package com.SeleniumTestInit_test;

import java.io.File;
import org.testng.TestNG;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;
import org.json.simple.parser.ParseException;

import com.SeleniumUtilities.XMLUpdate;
import com.SeleniumUtilities.getJsonDataSet;

public class InitializeTest_test {
	
	public static void main(String[] args) throws XPathExpressionException, IOException, TransformerFactoryConfigurationError, ParseException, TransformerException{
		
		File configDataFile = new File("./src/main/resources/Config.json");
		//Creating getJsonDataSet class object.
		getJsonDataSet getJsonDataSetObj = new getJsonDataSet();
		//Get dataSet string array
		List<String> dataSet = getJsonDataSetObj.getDataSet(configDataFile);
		
		String TestNGXMLDataFile = "./src/main/resources/TestNGXmlSingle.xml";
		
		XMLUpdate xmlUpdateObj = new XMLUpdate();
		xmlUpdateObj.updateTestNGXMLData(TestNGXMLDataFile, dataSet);
		//setAllureEnvironment(dataSet);		 
	    
	    //run the test
	    runTest(TestNGXMLDataFile);
	}
	
	public static void runTest(String data){			
			//Start the execution by running with updated testNG xml file.
			// Create object of TestNG Class
			TestNG runner=new TestNG();

			// Create a list of String 
			List<String> suitefiles=new ArrayList<String>();

			// Add xml file which you have to execute
			suitefiles.add(data);

			// now set xml file for execution
			runner.setTestSuites(suitefiles);

			// finally execute the runner using run method
			runner.run();		    
		}
		
}


	
	
	