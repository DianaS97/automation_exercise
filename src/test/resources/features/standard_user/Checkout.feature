Feature: Checkout Pages

  Background: Login as a standard_user
    Given Open Secret Sauce
    And Login as a standard_user
    Then Click on the 'Login' button
    Then Verify that the user is on "Products" Page


  Scenario: Check the 'Remove' button functionality for 1 product in the cart
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Click on 'Remove' button
    Then Verify that the cart is empty


  Scenario: Check the 'Remove' button functionality for 1 product in Products menu
    Given Add "Sauce Labs Onesie" item to the cart from Products Page
          #The method used for the above line needs improvement, the incorrect item is selected
    When Click on Add Button and verify that "1" items have been added
    #And Click on 'Remove' button for "Sauce Labs Onesie" item -in progress, will do after "Add "Sauce Labs Onesie" item to the cart from Products Page" is resolved
    Then Verify that the cart is empty


  Scenario: Check the 'Continue Shopping' button functionality
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    Then Click on 'Continue Shopping' button to go back to "Products" Page


  Scenario: Check the 'Cancel' button functionality
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    Then Click on 'Cancel' button to go back to 'Your Cart' Page
          #Bug? After reaching 'Checkout: Overview' Page and proceeding to click on Cancel button
          #in order to go back to 'Checkout: Your Information' Page, the user is redirected to Home Page


  Scenario: Verify the information displayed for 1 product in Checkout Overview Page
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    Then Verify the Items information in the Checkout Overview: "1", "Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99" are present
         #"Quantity of the item", "Title of the item", "Description of the item", "Item's Price" the order for the values entered above
         #Question regarding the assertions: For e.g. When deleting the "Onesie" from the Item Title assertion from above the test still passes(is this normal?), the test fails when inserting totally different information for e.g 124332 instead of "Sauce Labs Onesie".
    Then Verify the Summary Info: "SauceCard #31337", "Free Pony Express Delivery!", "Item total: $7.99", "Tax: $0.64", "Total: $8.63" are present
         #"Payment Information", "Shipping Information", "Item Total", "Tax", "Total" the order for the values entered above


  Scenario: Verify the messages in Checkout: Complete! Page
    Given Click on "Sauce Labs Onesie" item title
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    Then Click on 'Finish' and check the "Thank you for your order!" order title message and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" order description message
    Then Verify the name of the Page: "Checkout: Complete!" and the Green Tick image displayed


  Scenario: Verify the information displayed for 2 products in Checkout Overview Page
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Select 'Continue Shopping'
    And Click on "Sauce Labs Fleece Jacket" item title
    And Click on Add Button and verify that "2" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    Then Verify the Items information in the Checkout Overview: "1", "Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99" are present
    #Then Verify the 2nd item information in the Checkout Overview -in progress
        #"Quantity of the item", "Title of the item", "Description of the item", "Item's Price" the order for the values entered above
        #Question regarding the assertions: For e.g. When deleting the "Onesie" from the Item Title assertion from above the test still passes(is this normal?), the test fails when inserting totally different information for e.g 124332 instead of "Sauce Labs Onesie".
    Then Verify the Summary Info: "SauceCard #31337", "Free Pony Express Delivery!", "Item total: $7.99", "Tax: $0.64", "Total: $8.63" are present
    #Then Verify the 2nd item Summary Info -in progress
        #"Payment Information", "Shipping Information", "Item Total", "Tax", "Total" the order for the values entered above


  Scenario: An error message is displayed when the form has no data entered
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
        #The form is empty, no data has been entered. Improvement: Verify if the fields are empty before proceeding to click on Continue?
    And Click on 'Continue'
    Then Verify that the "Error: First Name is required" error message is displayed


  Scenario: An error message is displayed when the First Name fields is not filled
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert data in the Last Name and Postal Code fields: "Sintamarian", "400682"
    And Click on 'Continue'
    Then Verify that the "Error: First Name is required" error message is displayed


  Scenario: An error message is displayed when the user does not enter the Last Name
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert data in the First Name and Postal Code fields: "Diana", "400682"
    And Click on 'Continue'
    Then Verify that the "Error: Last Name is required" error message is displayed


  Scenario: An error message is displayed when the user does not enter the Postal Code
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert data in the First Name and Last Name fields: "Diana ", "Sintamarian"
    And Click on 'Continue'
    Then Verify that the "Error: Postal Code is required" error message is displayed