Feature: ASOS register

  Scenario: Verify that a user can register successfully using email address method
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    And User entails valid details
    When User clicks the JOIN ASOS button
    Then User is taken to ITEM BAG page

  Scenario: User trys to register with no email
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    When User clicks the JOIN ASOS button
    Then User receive's no email error message

    Scenario: User tries to register with an email in the wrong format
      Given User is on the ASOS home page
      When User clicks on the account icon
      When User clicks on the JOIN link
      And User enters email in invalid format
      When User clicks the JOIN ASOS button
      Then User receive's invalid format email error message

  Scenario: User tries to register with an email which has already been used
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    And User enters email which has already been used
    And User enters valid FirstName
    And User enters valid LastName
    And User enters valid Password
    And User selects valid DOB
    And User selects Gender
    When User clicks the JOIN ASOS button
    Then User receive's already registered email error message

  Scenario: User tries to register with an email which is too long
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    And User enters email which is more than 100 characters
    And User enters valid FirstName
    And User enters valid LastName
    And User enters valid Password
    And User selects valid DOB
    And User selects Gender
    When User clicks the JOIN ASOS button
    Then User receive's email is too long email error message

  Scenario: User tries to register no Firstname
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    When User clicks the JOIN ASOS button
    Then User receive's no firstname error message

  Scenario: User tries to register no Lastname
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    When User clicks the JOIN ASOS button
    Then User receive's no lastname error message

  Scenario: User tries to register no Password
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    When User clicks the JOIN ASOS button
    Then User receive's no password error message


  Scenario: User tries to register Password which is invalid
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    And User enters an invalid password
    When User clicks the JOIN ASOS button
    Then User receive's invalid password error message

  Scenario: User trying to register is too young
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    And User selects invalid DOB
    When User clicks the JOIN ASOS button
    Then User receive's invalid DOB error message

