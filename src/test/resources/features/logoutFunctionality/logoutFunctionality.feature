Feature: Logout Functionality
  Agile story: As a user, I should be able to log out and end up on the log in page.

  Background:
    Given user is already logged in


  Scenario: User can log out and land on login page.
    When user clicks the logout button
    Then user should land on to the login page


  Scenario: The user cannot go back to the home page by clicking the backward button after successfully logging out
    Given user has logged out
    When user presses the backward button after logging out
    Then user cannot go back to the homepage