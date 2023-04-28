Feature: Login feature with different user types

  Scenario: Login as a standard_user
    Given Open Secret Sauce
    When Login as a standard_user
    Then Click on the 'Login' button
    Then Verify that the user is on "Products" Page

  Scenario: Login as a locked_out_user
    Given Open Secret Sauce
    When Login as a locked_out_user
    Then Click on the 'Login' button
    Then Verify that the error message is displayed


  Scenario: Login as a problem_user
    Given Open Secret Sauce
    When Login as a problem_user
    Then Click on the 'Login' button
    Then Verify that the user is on "Products" Page


  Scenario: Login as a performance_glitch_user
    Given Open Secret Sauce
    When Login as a performance_glitch_user
    Then Click on the 'Login' button
    Then Verify that the user is on "Products" Page
