Feature: Add Person

  Scenario: Login
    Given I am on the login page
    When I enter "Imke" in the username field
    And I enter "courtois" in the password field
    And I press on the Submit button
    Then I should see "Lijst van plannings"