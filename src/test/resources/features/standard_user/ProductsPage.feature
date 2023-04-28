Feature: Inventory Page

  Background: Login as a standard_user
    Given Open Secret Sauce
    And Login as a standard_user
    Then Click on the 'Login' button
    Then Verify that the user is on "Products" Page


  Scenario: Check the App Logo 'Swag Labs' is displayed in Home Page
    And Verify the App's Logo "Swag Labs" is displayed
      #Question: This scenario is short, should it be placed in the Background scenario or left as it is?


  Scenario: Check the Copy Rights Footer is present
    And Verify the Copy Rights Text: "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy" is displayed on the bottom Page


  Scenario:Check the social media links on the bottom of the Page
    Given Check that the 3 social medias: "Twitter", "Facebook", "LinkedIn" are displayed on the footer
    #And Click on "Twitter" and proceed to return to the app -in progress
    #And Click on "Facebook" and proceed to return to the app -in progress
    #Then Click on "LinkedIn" and proceed to return to the app -in progress


  Scenario: Sorting Functionality
    Given Sort the items by "Name (A to Z)"
    When Sort the items by "Name (Z to A)"
    And Sort the items by "Price (low to high)"
    Then Sort the items by "Price (high to low)"


  Scenario: Purchase 1 item
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    Then Verify the Items information in the Checkout Overview: "1", "Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99" are present
    Then Verify the Summary Info: "SauceCard #31337", "Free Pony Express Delivery!", "Item total: $7.99", "Tax: $0.64", "Total: $8.63" are present
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





