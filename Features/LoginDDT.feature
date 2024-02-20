Feature: Login functionality with Data Driven set

  #Scenario Outline: Login with valid data
    #Given Open app url
    #When User enter username as "<email>" and password as "<password>"
    #And User click on login button
    #Then User navigate to account overview page
#
    #Examples: 
      #| email                   | password |
      #| hitesh@gmail.com        | Pass,123 |
      #| hiteshpatiyal@gmail.com | Pass@123 |
      #| hiteshp@gmail.com       | Pass.123 |

  Scenario Outline: Login with valid data
    Given Open app url
    When User enter username and password with excel row "<row_index>"
    And User click on login button
    Then User navigate to account overview page "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
