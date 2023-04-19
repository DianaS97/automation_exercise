Feature: Checkout Pages

  Background: Login as a standard_user
    Given Open Secret Sauce
    When Login as a standard_user
    Then Click on the 'Login' button


  Scenario: Check the 'Remove' button functionality
    Given Add an item to the cart from the Main Page
    When Click on 'Remove' button
    And Add 2 items from the Main Page
    And Click on the cart
    Then Click on 'Remove' button
    Then Verify that the item has been removed

  Scenario: Check the 'Continue Shopping' button functionality
    Given Add an item to the cart from the Main Page
    When Click on the cart
    Then Click on 'Continue Shopping' button



    Scenario: Check the 'Cancel' button functionality
      Given Add an item to the cart from the Main Page
      When Click on the cart
      And Proceed to checkout
      And Click on 'Cancel' button to go back to 'Your Cart' Page


      Scenario: Checkout Overview
        Given Add an item to the cart from the Main Page
        When Click on the cart
        And Proceed to checkout
        And Insert the following data in the form: "Diana", "Sintamarian", "400682"
        And Click on 'Continue'
        Then Verify the Items information in the Checkout Overview: QTY, Description, Title of the item, Description of the item, Item's Price
        Then Verify the Summary Info: Payment Information, Shipping Information, Price Total, Total