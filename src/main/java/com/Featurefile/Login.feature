#Author: Priyank Gachale 
Feature: orangeHRM Login Test Scenario
  
Scenario: start browser
When I initialize driver
Then open browser

 Scenario Outline: OrangeHRM Login Test Scenario
Given user is already on Login Page
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then check whether user is navigated to Home page


Examples:
	| username | password |
	| Admin    | admin123 |

	Scenario: Close browser
	Then Close browser