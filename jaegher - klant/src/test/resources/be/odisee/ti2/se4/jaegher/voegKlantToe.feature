Feature: Voeg klant toe

Het zou mogelijk moeten zijn om een klant toe te voegen aan een lijst van klanten
Na het toevoegen van een klant, zou de klant zichtbaar moeten zijn in de lijst van klanten


Scenario: Voeg een klant toe
  Given I am on the login page
  When I enter "admin" in the username field
  And I enter "adminww" in the password field
  And I press on the Submit button
  Then I press on the Klanten button
  When I enter "Test" in the naam field
  And I enter "Achternaam" in the achternaam field
  And I enter "Email@gmail.com" in the email field
  And I enter "2001-05-02" in the geboortedatum field
  Then I press on the submit button klant