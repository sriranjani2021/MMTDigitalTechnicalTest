@endtoend
Feature: Remove item from Basket - As a subscribed member I can remove product(s) from my cart so that I can check out cart with a only containing the items I want

  Background:
    Given that I am on the login page
    And I have entered "standard_user" and "secret_sauce"
    When I click Login
    Then the user will be navigated to the "inventory.html" page


    Scenario: The one where I am removing an item from basket and checking counter
      Given that I am on the inventory page with 2 item in basket
      When I click Remove on an item I have in my basket
      Then it will change the REMOVE button to a ADD TO CART button
      And the basket counter value is decreased by 1


      Scenario: The one where I have multiple items in basket and basket page shows remove option for each product
        Given that I am on the inventory page with 2 item in basket
        When I visit the basket page
        Then I can see options to remove each product present from the basket

  @inventory
        Scenario: The one where I remove a product from the basket page and the count is decreased by 1
          Given that I am on the inventory page with 2 item in basket
          When I visit the basket page
          And I remove 1 item from the basket
          Then the basket counter value is decreased by 1 in Basket Page

@inventory
    Scenario: The one where I remove the only item available from basket and the counter disappears
      Given that I am on the inventory page with 1 item in basket
      When I visit the basket page
      And I remove 1 item from the basket
      Then the item is removed from basket
      And the basket counter icon is disappeared
