Feature: Add products to basket

  Scenario: Adding a new product item to empty basket
    Given I've an empty basket
    When I add a product item
    Then the basket should have 1 unit of this product item
