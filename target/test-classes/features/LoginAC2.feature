@endtoend
Feature: Login AC2 using keyboard controls

  Background:
    Given that I am on the login page
@login
    Scenario: The one where I am focused on username field and tab on keyboard takes me to password field
      Given that I am currently focused on the username field
     When I enter valid username as "standard_user" and hit tab
  Then the current focus will be on password field

  @login
  Scenario: The one where I am focused on password field and tab on keyboard takes me to login button
    Given I enter valid username as "standard_user" and hit tab
    And the current focus will be on password field
    When I enter valid password as "secret_sauce" and hit tab
    Then the current focus will be on login button

    @login
    Scenario: The one where pressing the enter key while on the login button will log me in successfully
      Given I enter valid username as "standard_user" and hit tab
      And I enter valid password as "secret_sauce" and hit tab
      Then the current focus will be on login button
      And When I press the enter button
      Then the user will be navigated to the "inventory.html" page
