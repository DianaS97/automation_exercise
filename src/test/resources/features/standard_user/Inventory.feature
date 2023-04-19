Feature: Inventory Page

  Background: Login as a standard_user
    Given Open Secret Sauce
    When Login as a standard_user
    Then Click on the 'Login' button

  Scenario: Sorting Functionality
    Given Sort the items by "Name (A to Z)"
    When Sort the items by "Name (Z to A)"
    And Sort the items by "Price (low to high)"
    Then Sort the items by "Price (high to low)"


  Scenario: Purchase 1 item
    Given Add an item to the cart from the Main Page
    When Click on the cart
    And Select 'Continue Shopping'
    And Add another item to the cart from the Main Page
    And Click on the cart
    Then Verify that the items have been added
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    And Verify the Summary Info in Checkout Overview
    Then Click on 'Finish'
    Then Click on 'Back Home'



