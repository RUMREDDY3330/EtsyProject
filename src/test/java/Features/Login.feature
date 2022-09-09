Feature: Etsy login functionality

  @ValidCredentials
  Scenario: Verify user is able to login with valid credentials
    Given User is on login page
    When User entered username "maheshreddy3330@gmail.com" and password "Password"
    And User clicks on login button
    Then verify user is on home page

  Scenario: Verify user is able to login with invalid credentials
    Given User is on login page
    When User entered username "maheshreddy3330@gmail.com" and password "Passwor"
    And User clicks on login button
    Then Verify enter valid username and invalid password error message should display

  @Invalidcredentials
  Scenario: Verify user is able to login with invalid credentials by fetching data from excel sheet
    Given User is on login page
    When User enters username and password from excel
    And User clicks on login button
    Then Verify enter valid username and invalid password error message should display

