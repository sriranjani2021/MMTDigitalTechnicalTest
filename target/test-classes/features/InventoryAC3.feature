@endtoend @inventory
Feature: Add to Basket - AC3
  #As a subscribed member I can add product(s) to my cart so that I can build up an online order

  Background:
    Given that I am on the login page
    And I have entered "standard_user" and "secret_sauce"
    When I click Login
    Then the user will be navigated to the "inventory.html" page

@smoke
    Scenario: The one where I am adding a product to an empty basket
      Given that I am on the inventory shop page with an empty basket
      When I click Add to cart on a product
      Then it will change the ADD TO CART button to a REMOVE button
      And it creates a counter on the basket icon with the value "1" in it

@smoke
      Scenario: The one where I am adding a product to a basket with existing item
        Given that I am on the inventory page with 2 item in basket
        When I Add one more product to the cart
        Then the basket counter is incremented by 1
