#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#Tagging feature to control testcases(@regtest,@sanityTest,@smokeTest)using (not,and,or)
      
     #jolly 
          
Feature: Application login

Background:
Scenario: Home page default login
	Given validate the browser
	When Browser is Triggered 
	Then Check if the browser is started     

@regtest

Scenario: Home page default login
    Given User is on Net bank landing page1
    When User login into application with "mithun" and "2345"
    Then Home page is populated
	  And Card are displayed "true"
	  
	 @sanityTest 
Scenario: Home page default login
    Given User is on Net bank landing page1
    When User sign with following detail
    | Murugan | 1234 | Murugan@gmail.com | india | Male |
    Then Home page is populated
	  And Card are displayed "false"
	  
#paramitaisation
@smokeTest	  
Scenario Outline: Home page default login
	Given User is on Net bank landing page1
	When user sign in to following detail<username> and <password>
	Then Home page is populated
	And Card are displayed "true"
	
Examples:
| username	| password |
| user1     | pass123  |
| user2     | pass163  |
| user3     | pass133  |
| user4     | pass143  |
| user5     | pass153  |

