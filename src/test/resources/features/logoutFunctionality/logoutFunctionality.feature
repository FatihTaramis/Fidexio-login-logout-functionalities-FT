@FID10-397
Feature: Logout Functionality
  Agile story: As a user, I should be able to log out and end up on the log in page.

  Background:
    #@FID10-394
    Given user is already logged in


  #1- User can log out and ends up in login page.
  @FID10-395
  Scenario: User can log out and land on login page.
    When user clicks the logout button
    Then user should land on to the login page


  #2- The user can not go to the home page again by clicking the step back button after successfully logged out.
  @FID10-396
  Scenario: The user cannot go back to the home page by clicking the backward button after successfully logging out
    Given user has logged out
    When user presses the backward button after logging out
    Then user cannot go back to the homepage