Feature: Log in

een persoon kan zich inloggen


Scenario: inloggen
Given Ik ben op de log in pagina
When I enter "admin" in the username field
And I enter "adminww" in the password field
Then I should see the following on the screen

  | USERNAME:    | admin        |
  | PASSWORD:    | adminww      |


When I press on the login button
Then I should go to the home screen



And I close the browser