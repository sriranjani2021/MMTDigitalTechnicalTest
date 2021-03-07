@endtoend
Feature: Login Success AC1

    Scenario Outline: The one where I login with different combinations

      Given that I am on the login page
      And I have entered "<username>" and "<password>"
      When I click Login
      Then an error will be thrown below the form stating "<error message>"

      Examples:
        |username     |password|error message                                                            |
        |             |        |Epic sadface: Username is required                                       |
        |standard-user|        |Epic sadface: Password is required                                       |
        |invalid-user |invalid |Epic sadface: Username and password do not match any user in this service|


      Scenario: The one where I successfully login with valid username and password
        Given that I am on the login page
        And I have entered "standard_user" and "secret_sauce"
        When I click Login
        Then the user will be navigated to the "inventory.html" page
    
