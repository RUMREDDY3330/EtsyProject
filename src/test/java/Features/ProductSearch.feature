Feature: Etsy ProductSearch functionality

  @SearchProduct
  Scenario: Verify user is able to add the product to the cart and add product details to the excel sheet
    Given User is on login page
    When User entered username "maheshreddy3330@gmail.com" and password "Password"
    And User clicks on login button
    Then verify user is on home page
    Then Enter the product name 
    Then Click on search button
   	Then select the product
   	Then click on add to cart button
   	#Then Verify product is added to cart
   	Then click on close button
   	Then click on basket icon
   	Then verify user is on basket checkout page
   	Then verify product is added to cart
   	Then fetch all the product information in to excel like product name price reviews seller information
   	 
   	