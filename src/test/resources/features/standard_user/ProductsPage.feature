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
    Given Click on "Test.allTheThings() T-Shirt (Red)" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    Then Click on 'Finish' and check the "Thank you for your order!" order title message and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" order description message
    Then Click on 'Back Home' and verify that the user is on "Products" Page


  Scenario: Purchase 2 items
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Select 'Continue Shopping'
    And Click on "Sauce Labs Fleece Jacket" item title
    And Click on Add Button and verify that "2" items have been added
    And Click on the cart
    #Then Verify that the "", "" items are present in the cart -in progress
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    #Then Verify the Items information in the Checkout Overview: QTY, Description, Title of the item, Description of the item, Item's Price are present -in progress
    Then Verify the Summary Info: "Payment Information", "Shipping Information", "Price Total", "Total" are present
    Then Click on 'Finish' and check the "Thank you for your order!" order title message and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" order description message
    Then Click on 'Back Home' and verify that the user is on "Products" Page


  Scenario: Add 2 items to the cart, remove one and purchase the remaining one
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Select 'Continue Shopping'
    And Click on "Sauce Labs Fleece Jacket" item title
    And Click on Add Button and verify that "2" items have been added
    And Click on the cart
    #And Remove this "" item from the cart -in progress
    #Then Verify that "" item is present in the cart -in progress
    And Click on 'Continue'
    Then Verify the Summary Info: "Payment Information", "Shipping Information", "Price Total", "Total" are present
    Then Click on 'Finish' and check the "Thank you for your order!" order title message and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" order description message
    Then Click on 'Back Home' and verify that the user is on "Products" Page


  Scenario: Purchase all 6 items from Products Page by accessing each item's Page
    Given Click on "Sauce Labs Backpack" item title
    When Click on Add Button and verify that "1" items have been added
    And Select 'Back to products' button
    And Click on "Sauce Labs Bike Light" item title
    And Click on Add Button and verify that "2" items have been added
    And Select 'Back to products' button
    And Click on "Sauce Labs Bolt T-Shirt" item title
    And Click on Add Button and verify that "3" items have been added
    And Select 'Back to products' button
    And Click on "Sauce Labs Fleece Jacket" item title
    And Click on Add Button and verify that "4" items have been added
    And Select 'Back to products' button
    And Click on "Sauce Labs Onesie" item title
    And Click on Add Button and verify that "5" items have been added
    And Select 'Back to products' button
    And Click on "Test.allTheThings() T-Shirt (Red)" item title
    And Click on Add Button and verify that "6" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "FirstNameTest", "LastNameTest", "400682"
    And Click on 'Continue'
    Then Click on 'Finish' and check the "Thank you for your order!" order title message and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" order description message
    Then Click on 'Back Home' and verify that the user is on "Products" Page





