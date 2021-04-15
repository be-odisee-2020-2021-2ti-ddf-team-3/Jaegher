Feature: Log in

een persoon kan zich inloggen


Scenario: inloggen
Given Ik ben op de log in pagina
When I enter "admin" in the username field
And I enter "adminww" in the password field
And I press on the login button
Then I should go to the home screen


| USERNAME:    | admin        |
| PASSWORD: | adminww      |

And I close the browser