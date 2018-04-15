Feature: ASOS register

  Scenario: Verify that a user can register successfully using email address method
    Given User is on the ASOS home page
    When User clicks on the account icon
    When User clicks on the JOIN link
    And User entails valid details
    When User clicks the JOIN ASOS button
    Then User is taken to ITEM BAG page

