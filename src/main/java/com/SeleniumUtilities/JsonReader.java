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
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	/**
	 * Class used for parsing the json file.
	 */
	
	public JSONObject readJsonEmployeeDetails(File employeeDataFile, int employeeIndex) throws IOException, ParseException{
	/**
	 * Method used for parsing the json file which is in array format.
	 * @param File employeeDataFile - Full path of the json file to be parse and return the details.
	 * @param int employeeIndex - Index of the employee in json file(value of the key "employeeIndex").
	 * @return user - Details of the user based on the index value as json object.
	 */		
		
		//create jsonparser object to parse the json file.
		JSONParser jsonparser = new JSONParser();
		
		//create file reader object to read the file.		
		FileReader reader = new FileReader(employeeDataFile);
		
		// parsing json file	
		Object obj = jsonparser.parse(reader);
		
		// type casting obj to JSONObject
		JSONObject empDetailsJson = (JSONObject)obj;
		
		//getting details
		JSONArray userDetails = (JSONArray)empDetailsJson.get("EmployeeDetails");
		
		//Taking user's details based on the given userIndex value.
		JSONObject employee = (JSONObject)userDetails.get(employeeIndex);
		
		//Return specific user's details as a json object.
		return employee;
	}
	
	public String  readJsonConfig(File configDataFile, String primaryKey, String secondaryKey) throws IOException, ParseException{
		/**
		 * Method used for parsing the config json file.
		 * @param File configDataFile - Full path of the json file to be parse and return the data.
		 * @param String primaryKey - Primary key of the group of config in json.
		 * @param String secondaryKey - Specific key of the required field in primary key.
		 * @return value - value of the secondary key.
		 */	
		//create jsonparser object to parse the json file.
		JSONParser jsonparser = new JSONParser();
		
		//create file reader object to read the file.		
		FileReader reader = new FileReader(configDataFile);
		
		// parsing json file	
		Object obj = jsonparser.parse(reader);
		// type casting obj to JSONObject
		JSONObject configDetailsJson = (JSONObject)obj;
		Map execConfig = ((Map)configDetailsJson.get(primaryKey));
		String secondaryKeyValue =(String)execConfig.get(secondaryKey);
		return secondaryKeyValue;
	}
}
