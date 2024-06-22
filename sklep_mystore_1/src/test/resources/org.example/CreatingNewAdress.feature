Feature: Creating New Address

  Scenario Outline: Creating New Address
    Then I go the page My Store
    And I click to the Sign in button
    When I enter "<email>" in the Email
    And I enter "<password>" i the Password
    And I click the Login button Sign In
    Then I'm logged in
    And I click to Adresses
    Then I go to the controller addressess page
    And I click to Create new addres
    When I enter the alias "<alias>"
    And I enter the adress "<address>"
    And I enter the city "<city>"
    And I enter the zip "<zip>"
    And Select the country
    And I enter the phone "<phone>"
    And I save the new address
    When I click Update
    Then I verify the new alias "<alias>", address "<address>", city "<city>", zip "<zip>", phone "<phone>"
    #Then I verify the new alias with "<alias>"
    #And I verify the new address "<address>"
    #And I verify the new city "<city>"
    #And I verify the new  zip "<zip>"
    #And I verify the new phone "<phone>"
    Then Go to controlel address page
    When I delete added address


    Examples:
      | email                      | password | alias    | address | city     | zip    | phone     |
      | karolina+test@qsoft.com.pl | testowe  | Karolina | Klonowa | Warszawa | 01-111 | 444444444 |

