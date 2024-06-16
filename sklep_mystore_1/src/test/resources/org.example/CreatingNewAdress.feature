Feature: Creating New Address

  Scenario Outline: Creating New Address
    Then I go the page My Store
    And I click to the Sign in button
    When I enter "<email>" in the Email
    And I enter "<password>" i the Password
    And I click the Login button Sign In
    Then I'm logged in
    And I click to Adresses
    Then hen I go to the controller addressess page
    And I click to Create new addres
    When I enter the alias "<alias>"
  And I enter the adress "<address>"
  And I enter the city "<city>"
  And I enter the zip "<zip>"
    And Select the country
  And I enter the phone "<phone>"
    And I save the new address

    Examples:
      | email                      | password | alias    | address | city     | zip   | phone     |
      | karolina+test@qsoft.com.pl | testowe  | Karolina | Klonowa | Warszawa | 01-111 | 444444444 |

