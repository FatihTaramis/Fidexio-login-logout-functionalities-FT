Feature: Fidexio Login Functionality
  Agile story: As a user, I should be able to log in so that I can land on homepage.

  Background:
    Given User is on Fidexio log in page

  Scenario Outline: Users can log in with valid credentials: SalesManager
    When User enters an email "<email>"
    And User enters a password "<password>"
    Then User clicks the login button
    Then User should successfully log in to the homepage

    Examples: Valid credentials for SM
      | email                   | password     |
      | salesmanager46@info.com | salesmanager |
      | salesmanager15@info.com | salesmanager |

  Scenario Outline: Users can log in with valid credentials: PosManager
    When User enters an email "<email>"
    And User enters a password "<password>"
    Then User clicks the login button
    Then User should successfully log in to the homepage

    Examples: Valid credentials for PM
      | email                 | password   |
      | posmanager46@info.com | posmanager |
      | posmanager10@info.com | posmanager |

  Scenario Outline: "Please fill out this field" message should be displayed for empty fields
    When User enters an email "<email>"
    And User enters a password "<password>"
    And User clicks the login button
    Then User should see the message

    Examples: email and/or password left empty
      | email                    | password     |
      |                          | salesmanager |
      | salesmanager100@info.com |              |
      |                          |              |


  Scenario: "Wrong login/password" message should be displayed for invalid credentials
    When User enters incorrect credentials
    Then "Wrong login/password" should be displayed


