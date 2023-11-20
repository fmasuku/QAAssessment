Feature: Placing an order

  Scenario: Search Experience for product in home page


    Given User is on Landing Page
    When User searched with shortname "App" and extracted actual name of the product
    Then User add more than one "App" into the cart
    And User check if correct product is added to the Cart
