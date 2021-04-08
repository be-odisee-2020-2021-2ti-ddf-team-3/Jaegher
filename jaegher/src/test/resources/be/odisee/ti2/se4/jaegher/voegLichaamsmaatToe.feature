Feature: Voeg lichaamsmaat toe

Het zou mogelijk moeten zijn om de lichaamsmaten toe te voegen aan een klant
Na het toevoegen van de lichaamsmaten wordt de lijst van klanten weer getoond
Door de details van de gewenste klant nog eens te bekijken zouden de lichaamsmaten nu getoond moeten worden


Scenario: Voeg een lichaamsmaat toe
Given Ik ben op de pagina waar ik de gegevens van een klant kan wijzigen
When I enter "85.5" in the Lengte linkerbeen field
And I enter "86.0" in the Lengte rechterbeen field
And I enter "15.0" in the Bekken kanteling field
And I enter "53.0" in the Lengte linkerarm field
And I enter "52.0" in the Lengte rechterarm field
And I enter "72.0" in the gewicht field
And I enter "172.0" in the grootte field
And I press on the Submit button
Then I should see the lijst van klanten

When I click the klant dat ik heb gewijzigd
Then I should see the following on the screen

| rechterbeen(mm) | linkerBeen(mm)  | Beenlengte verschil(mm) |	Bekken kanteling(mm)  |	linker arm(mm)  | rechter arm(mm) | gewicht(kg) | grootte(cm) |

|      86.0       |     85.5        |          -0.5           |        15.0	          |      53.0       |      52.0       |     72.0    |    172.0   |

And I close the browser