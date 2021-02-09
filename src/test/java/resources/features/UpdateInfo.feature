Feature: Update Personal Information in My Account

Background: User is logged in
    Given user is logged in
	
Scenario: Update First Name 
	When user navigates to My Personal Information Page
	And user updates First Name to "John"
	Then Personal Information updated successfully

