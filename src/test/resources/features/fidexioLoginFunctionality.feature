@FID10-392
Feature: Fidexio Login Functionality
  Agile story: As a user, I should be able to log in so that I can land on homepage.

  Background:
    #@FID10-381
    Given User is on Fidexio log in page


  #1- Users can log in with valid credentials (We have 5 types of users but will test only 2 user: PosManager, SalesManager)
  @FID10-382
  Scenario Outline: Users can log in with valid credentials: SalesManager and PosManager
    When User enters an email "<email>"
    And User enters a password "<password>"
    And User clicks the login button
    Then User should successfully log in to the homepage

    Examples: Valid credentials for SM & PM
      | email                   | password     |
      | salesmanager46@info.com | salesmanager |
      | salesmanager15@info.com | salesmanager |
      | posmanager46@info.com   | posmanager   |
      | posmanager10@info.com   | posmanager   |


  #2- "Wrong login/password" should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
  @FID10-383
  Scenario Outline: "Wrong login/password" message should be displayed for invalid credentials
    When User enters an email "<email>"
    And User enters a password "<password>"
    And User clicks the login button
    Then The User should see the message "Wrong login/password"

    Examples: email or password is invalid
    | email                   | password     |
    | asdf@info.com           | asdf         |
    | asdf@info.com           | salesmanager |
    | salesmanager15@info.com | asdf         |



  #3- "Please fill out this field" message should be displayed if the password or username is empty
  @FID10-384
  Scenario Outline: "Please fill in this field." message should be displayed for empty fields
    When User enters an email "<email>"
    And User enters a password "<password>"
    And User clicks the login button
    Then User should see the "Please fill in this field." message

    Examples: email and/or password left empty
      | email                    | password     |
      |                          | salesmanager |
      | salesmanager46@info.com  |              |
      |                          |              |



  #4- Scenario Outline: User lands on the ‘reset password’ page after clicking on the "Reset password" link - BUG



  #5- User should see the password in bullet signs by default
  @FID10-386
  Scenario Outline: User should see the password in bullet signs by default
    When User enters a password "<password>"
    Then User should see the password in bullet signs

    Examples: Valid passwords for SM & PM
      | password     |
      | salesmanager |
      | posmanager   |



  #6- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
  @FID10-390
  Scenario Outline: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When User enters an email "<email>"
    And User enters a password "<password>"
    And User presses the 'enter' key
    Then User should successfully log in to the homepage

    Examples: Valid credentials for SM & PM
      | email                   | password     |
      | salesmanager46@info.com | salesmanager |
      | salesmanager15@info.com | salesmanager |
      | posmanager46@info.com   | posmanager   |
      | posmanager10@info.com   | posmanager   |


