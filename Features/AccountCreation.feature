Feature: Create new account against existing account and transfer fund

  Scenario Outline: Create a new account and transfer fund in it from existing account
    Given login to the application "<row_index>"
    When click on open new account link
    And select the account type as "<type>"
    And select the account from which the amount to be transfer "<accounNo>"
    And click on open new account button
    Then account opened message should be displayed
    And account number should be generated

    Examples: 
      | row_index | type    | accounNo |
      |         1 | SAVINGS |    14343 |
