@endtoend @login
Feature: Login Success - AC1
  #As a subscribed member I can log in using my credentials so that my account is securely accessible

    Scenario Outline: The one where I test login with different invalid combinations

      Given that I am on the login page
      And I have entered "<username>" and "<password>"
      When I click Login
      Then an error will be thrown below the form stating "<error message>"

      Examples:
        |username     |password|error message                                                            |
        |             |        |Epic sadface: Username is required                                       |
        |standard-user|        |Epic sadface: Password is required                                       |
        |invalid-user |invalid |Epic sadface: Username and password do not match any user in this service|

@smoke
      Scenario: The one where I successfully login with valid username and password
        Given that I am on the login page
        And I have entered "standard_user" and "secret_sauce"
        When I click Login
        Then the user will be navigated to the "inventory.html" page
    
