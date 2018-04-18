Feature: ASOS login

  Scenario: As a user I should be able to login with valid credentials
    Given I am on the ASOS login page
    When I enter valid credentials
    And I click the sign in button
    Then I am taken to my account page
    And Sign out is now an option

  Scenario: As a user I should receive an error message when I don't enter an email
    Given I am on the ASOS login page
    When I leave my email blank and enter a password
    Then I should receive an email error message

  Scenario: As a user I should receive an error message when I don't enter an password
    Given I am on the ASOS login page
    When I leave my password blank and enter a username
    Then I should receive an password error message