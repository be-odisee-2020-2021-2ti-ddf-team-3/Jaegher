Feature: Log in

  een persoon kan zich inloggen


  Scenario: inloggen
    Given I am on the login page
    When I enter "admin" in the username field
    And I enter "adminww" in the password field
    And I press on the Submit button
