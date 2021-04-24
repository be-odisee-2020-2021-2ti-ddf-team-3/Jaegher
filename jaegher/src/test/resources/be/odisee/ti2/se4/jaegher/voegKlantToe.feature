Feature: Voeg klant toe

Het zou mogelijk moeten zijn om een klant toe te voegen aan een lijst van klanten
Na het toevoegen van een klant, zou de klant zichtbaar moeten zijn in de lijst van klanten


Scenario: Voeg een klant toe
Given Ik ben op de pagina waar ik de lijst van klanten kan raadplegen
When I enter "Sanne" in the voornaam field
And I enter "Putzeys" in the familienaam field
And I enter "selah@sue.be" in the emailadres field
And I enter "Haachstesteenweg 195, Steenokkerzeel" in the address field
And I enter "19-10-2000" in the geboortedatum field
And I press on the Submit button
Then I should see the following on the screen

| Voornaam:    |  Familienaam: |   E-mailadres:     |               Address:                 |   Geboortedatum |
|   Sanne      |    Putzeys    |   selah@sue.be     | Haachstesteenweg 195, Steenokkerzeel   |    19-10-2000   |


And I close the browser