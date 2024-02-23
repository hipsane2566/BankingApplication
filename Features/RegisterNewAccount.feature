Feature: Register a new account functionality

  Scenario: Register a new account from scratch
    Given open app url
    And navigate to registration page
    When user enters the details into required fields
      | firstname | Shyam  |
      | lastname  | Sharma |
    And click on register button
    Then account register successfully message should be displayed
    And user able to login with the register account details
