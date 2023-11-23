@Test
Feature: Login in the website
  As a client, I want to login into the website
  Scenario: Login into the website
    Given I navigate to the website
    When I enter the username and password
    And Press Login button
    Then I am logged into OrangeHRM


    Scenario: As a user I want to log into my account with invalid credentials
      Given I access OrangeHRM page
      When I enter invalid login credentials
      And I press the Login button to log into my account
      Then I verify that an appropriate message is displayed for invalid credentials


  Scenario: As a user I want to log into my account with valid credentials
      Given I access OrangeHRM page
      When I enter valid login credentials
      And I press the Login button to log into my account
      Then I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application by using XPath selector

  Scenario: As a user I can verify that the Rejected status is correctly added to the leave records search
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Leave link from the menu
    And I select the Rejected status from the Show Leave with Status section
    Then I check that the Rejected status is present as a selection by using XPath selector


  Scenario: As a user I am able to update my street and country details
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I click the My Info option from the menu
    And I click on the Contact Details link which will redirect me to the contactDetails page
    And I update the Street 1 field from contact details
    And I select Algeria as country
    And I press the Save button
    Then I should see the successfully updated confirmation message


    Scenario: As a user I am able to add an attachment into my Contact Details
      Given I access OrangeHRM page
      When I enter valid login credentials
      And I press the Login button to log into my account
      And I click the My Info option from the menu
      And I click on the Contact Details link which will redirect me to the contactDetails page
      And I click the Add Attachments button
      And I add a comment for this document uploaded in the comment field
      And I press the Save button for this attachment added

  Scenario: As a user I am able to access the Language Packages
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link from the menu
    And I click on the Configuration dropdown menu button
    And I click on the Language Packages option
    And I click on the Translate button for Spanish - Español language package
    Then I should be redirected to the languageCustomization page

  Scenario: As a user I want to display all the leave records in Rejected status
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Leave link from the menu
    And I click on the Leave List option
    And I select Rejected status by filtering from Show Leave section
    Then I check that the Rejected status is present as a selection by using XPath selector

  Scenario: As a user I am able to add a new language Package
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link from the menu which will redirect me to the viewSystemUsers page
    And I click on the Configuration dropdown menu button
    And I click on the Language Packages option
    And I click the Add button to add a new language to the packages
    And I select the language Colognian(Germany) from that list
    And I press the Save to add this new language to my packages
    Then I should be able to see the confirmation message that the language was successfully saved

#  Scenario: As a user I can add a comment for a leave request
#    Given I access OrangeHRM page
#    When I enter valid login credentials
#    And I press the Login button to log into my account
#    And I click the Leave link from the menu
#    And I click on the button with three dots which is located in the left corner for an employee record
#    And I select to Add Comment from that list
#    And I enter a comment in the Leave Request Comments section
#    And I save the comment
#    Then I should be able to see the confirmation message that the comment was added successfully

  Scenario: As a user I can add a comment for a leave request
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Leave link from the menu
    And I select a period from 2021-12-01 to 2023-12-31
    And I select to see only leave with Pending Approval status
    And I select Leave Type as CAN - Personal
    And I enter Anthony Nolan in the Employee Name field
    And I press the Search button
    And I click on the Reset button
    Then I should see a pop-up message that says no records found

  Scenario: As a user I want to add a new job
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link from the menu
    And I select the Job Titles option from the Job menu dropdown
    And I click the Add button to add a new job
    And I add a name for the job in the Job Title field
    And I add a job description
    And I click the Save button to add the new job
    Then I should see the confirmation message that the job was successfully added

    Scenario: As a user I am able to schedule an interview with a candidate
      Given I access OrangeHRM page
      When I enter valid login credentials
      And I press the Login button to log into my account
      And I click on the Recruitment link from the menu
      And I click on the view icon located in the Actions section to see a candidate's application in Status Shortlisted
      And I click the Schedule Interview button for that candidate
      And I add the title of the interview
      And I add two interviewers in the Interviewer field
      And I select a date and hour
      And I press the Save button to schedule the interview
      Then I should see the confirmation message for this scheduled interview

  Scenario: As a user I can see all the Automation Tester vacancies
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click on the Recruitment link from the menu
    And I click on the Vacancies option
    And I search for vacancies with job title as Account Assistant
    Then I can see that all records are displayed for Account Assistant

  Scenario: As a user I am able to add a new employee
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click on the PIM option from the menu
    And I choose the Add Employee option
    And I enter the employee's full name in the Employee Full Name section
    And I enter an employee id in the Employee Id field
    And I click the Create Login Details button to make the option available
    And I add a username and password
    And I press the Save button
    Then I should see a confirmation message that the employee was successfully saved

  Scenario: As a user I can access an employee's records
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click on the Maintenance option from the menu which will redirect me to the purgeEmployee page
    And I enter my password to validate my administrator credentials
    And I click the Confirm button
    And I click on the Access Records option
    And I enter Anthony Anadebe in the Employee Name field
    And click on the Search button
    Then I can see that the employee ID is displayed in the Selected Employee section by using css selector
