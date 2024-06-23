Feature: Purchases happy path

  Scenario Outline: creation of a new purchase order
    Then I go the page My Store
    And I click to the Sign in button
    When I enter "<email>" in the Email
    And I enter "<password>" i the Password
    And I click the Login button Sign In
    Then I'm logged in
    And I search for "<productSearched>"
    Then see list of products
    And I click on "<productSearched>" product
    When I am on the page with the selected product
    And I choose the size "<size>" on size selection
    And I choose "<pieces>" pieces
    And I click Add To cart button
    Then I click Proceed to checkout button
    When I am on controller cart action show page
    Then I click Proceed to checkout btn
    When I am on controller order page
    And I click continue button
    And I click on radio button method of delivery "<methodOfDelivery>"
    And I click continue button on Shipping Method
    And I choice radio method of payment "<methodOfPayment>"
    And I check checkbox "i agree terms and conditions"
    And I click Place order button
    When I am on order confirmation page
    Then I make screenshot confirment order and price

    Examples:
      | email                      | password | productSearched             | size | pieces | methodOfDelivery | methodOfPayment |
      | karolina+test@qsoft.com.pl | testowe  | Hummingbird Printed Sweater | M    | 5      | Self pick up | Pay by Check    |
