Feature: Checkout Pages

  Background: Login as a standard_user
    Given Open Secret Sauce
    When Login as a standard_user
    Then Click on the 'Login' button


  Scenario: Check the 'Remove' button functionality
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    When Click on 'Remove' button
    And Add 2 items from the Main Page
    And Click on the cart
    Then Click on 'Remove' button
    Then Verify that the item has been removed

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
    #     in order to go back to 'Checkout: Your Information' Page, the user is redirected to Home Page


  Scenario: Verify the information displayed in Checkout Overview Page
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert the following data in the form: "Diana", "Sintamarian", "400682"
    And Click on 'Continue'
    #Then Verify the Items information in the Checkout Overview: QTY, Description, Title of the item, Description of the item, Item's Price are present
    Then Verify the Summary Info: "Payment Information", "Shipping Information", "Price Total", "Total" are present


  Scenario: An error message is displayed when the form has no data entered
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
      #The form is empty
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

  Scenario: An error message is displayed when the user does not enter the Last Name
    Given Click on "Sauce Labs Onesie" item title
    When Click on Add Button and verify that "1" items have been added
    And Click on the cart
    And Proceed to checkout
    And Insert data in the First Name and Last Name fields: "Diana ", "Sintamarian"
    And Click on 'Continue'
    Then Verify that the "Error: Postal Code is required" error message is displayed