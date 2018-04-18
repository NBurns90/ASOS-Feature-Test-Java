Feature: ASOS register

  Scenario: Verify that a user can register successfully using email address method
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter valid details
    When I click the JOIN ASOS button
    Then I am taken to ITEM BAG page

  Scenario: User trys to register with no email
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter all valid details except email
    When I click the JOIN ASOS button
    Then I receive a no email error message

  Scenario: User tries to register with an email in the wrong format
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter an email in invalid format
    And I enter all valid details except email
    When I click the JOIN ASOS button
    Then I receive an invalid format email error message

  Scenario: User tries to register with an email which has already been used
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter an email which has already been used
    And I enter all valid details except email
    When I click the JOIN ASOS button
    Then I receive an already registered email error message

  Scenario: User tries to register with an email which is too long
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter an email which is more than 100 characters
    And I enter all valid details except email
    When I click the JOIN ASOS button
    Then I receive an email is too long email error message

  Scenario: User tries to register no Firstname
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter all valid details except Firstname
    When I click the JOIN ASOS button
    Then I receive a no firstname error message

  Scenario: User tries to register no Lastname
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter all valid details except Lastname
    When I click the JOIN ASOS button
    Then I receive a no lastname error message

  Scenario: User tries to register no Password
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter all valid details except Password
    When I click the JOIN ASOS button
    Then I receive a no password error message


  Scenario: User tries to register Password which is invalid
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter an invalid password
    And I enter all valid details except Password
    When I click the JOIN ASOS button
    Then I receive an invalid password error message

  Scenario: User trying to register is too young
    Given I am on the ASOS home page
    And I click on the account icon
    And I click on the JOIN link
    And I enter all valid details except DOB
    And I select invalid DOB
    When I click the JOIN ASOS button
    Then I receive an invalid DOB error message


