
Feature: Product purchase flow on Automation Exercise

  Scenario Outline: User logs in, searches for a product, adds it to cart, and proceeds to checkout
    Given the user is on the Automation Exercise homepage
    When the user clicks on Signup / Login
    And the user enters valid "<email>" and "<password>" and clicks Login
    And the user clicks on Products in the navigation bar
    And the user searches for "blue top"
    And the user adds the first search result to the cart
    And the user clicks on Cart in the navigation bar
    And the user clicks on Proceed To Checkout
    Then the user should be taken to the checkout page
    And the user should see the Place Order button
    Examples:
        | email | password | 
        | raiarti@tgh.com | test@123 |
        