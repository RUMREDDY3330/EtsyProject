Feature: New user creation functionality

  @NewUserCreation
  Scenario: Verify user is able to create new user
    Given User is on login page
    Then User click on the signin button
    Then User click on the register button
    Then User enter the Email address
    Then User enter the first name
    Then User enter the password
    Then User click on the register button and
    And Verify user is on home page
    Then Add the user details in notepad
    Then Enter the product name
    Then Click on search button
    Then click on filter button
    Then select the bestseller box
    Then click on applybutton
    Then filter selection should be display
    Then select the product
    Then click on add to cart button
    #Then Verify product is added to cart
    Then click on close button
    Then click on basket icon
    Then verify user is on basket checkout page
    Then verify product is added to cart
    Then fetch all the product information in to excel like product name price reviews seller information\
    Then click on account button 
    Then clisk on signout button
