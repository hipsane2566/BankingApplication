Feature: User Login

  #Scenario: Login with valid data
    #Given Open app url
    #When User enter username as "hitesh@gmail.com" and password as "Pass,123"
    #And User click on login button
    #Then User navigate to account overview page

    Scenario Outline: Login with valid data
    Given Open app url
    When User enter username as "<email>" and password as "<password>"
    And User click on login button
    Then User navigate to account overview page

    Examples: 
      | email                   | password |
      | hitesh@gmail.com        | Pass,123 |
      | hiteshpatiyal@gmail.com | Pass@123 |
      | hiteshp@gmail.com       | Pass.123 |