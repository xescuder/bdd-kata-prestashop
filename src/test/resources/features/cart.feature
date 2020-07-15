Feature: Shopping basket

  Scenario: Adding a product to basket
    Given I am on a product detail page
    When I click the add to basket button
    Then the product is added to my shopping basket
