Feature: Login

  @loginPositive
  Scenario: Successful login
    Given User is on Home Page
    When User clicks on User icon
    Then User verifies Login form
    When User enters valid data
    And User clicks on Anmelden button
    Then User verifies user name status
    When User clicks on User icon
    Then User verifies user name

  @invalidEmail
  Scenario Outline: Login with invalid email and valid password
    Given User is on Home Page
    When User clicks on User icon
    Then User verifies Login form
    When User enters invalid email and valid password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Anmelden button
    Then User verifies Error Message is displayed
    Examples:
      | email          | password   |
      | afali.com      | 123456Qwe@ |
      | afali@emailcom | 123456Qwe@ |
      | afali@email.m  | 123456Qwe@ |
      | afali@g.com    | 123456Qwe@ |