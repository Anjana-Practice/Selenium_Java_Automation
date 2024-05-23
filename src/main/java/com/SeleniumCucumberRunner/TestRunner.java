/* 
* @(#)TestRunner.java 2.12 15/02/23 
* Copyright (c) 2022-2023
*/
/*
 * Description(Run the cucumber test)
 * @author Priyanka 
 * @version 00:00:01
 * @see <com.SeleniumCucumberRunner.TestRunner>
 */

package com.SeleniumCucumberRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*@RunWith (), which tells JUnit what is the test runner class */

@RunWith(Cucumber.class)

/*Used to set some specific properties for the Cucumber test
 * features: The paths of the feature file
 * glue :The paths of the step definition files
 * plugin : what all report formate to used
 * monochrome :display the console output in much readable way
 * */

@CucumberOptions
      (features ="C:\\Users\\THINKPAD\\Downloads\\TestvoxAutomationSuite-main\\TestvoxAutomationSuite-main\\src\\main\\java\\com\\Featurefile\\Login.feature", 
       glue = {"com.stepdefinition" }, 
       plugin = { "pretty", "json:target/cucumber-report/cucumber.json",
				"html:target/cucumber-report/cucumber.html" }, 
       monochrome = true)
public class TestRunner {
	
}