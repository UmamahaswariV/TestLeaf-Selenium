Feature: User Profile in Saleforce Application

Scenario: User tries to login using the valid credentials
	Given user launch the Web browser.
    And user is on Salesforce login page.
    And user logs into Salesforce
    And user clicks toggle menu button from left corner
    And user clicks View All and selects Sales from App Launcher
    And user navigates to Accounts tab
    And user clicks New button
    And user enters Your Name as account name
    And user selects Ownership as Public
    When user clicks Save button
    Then account name Your Name is displayed successfully
