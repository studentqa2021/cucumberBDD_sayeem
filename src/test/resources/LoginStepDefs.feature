@Smoke
Feature: login function test

  @tac001_to_tc005
  Scenario Outline: As an Orbits user, can do successful login with valid credential
    Given Open Browser
    Then go to application URL "<App link>"
    And put valid username "<username>"
    And put valid password "<pass>"
    Then click signin button
    Then login should be successful and showed sign out button
    Then click Fight URL
    And close browser

    Examples: 
      | App link |  | username |  | pass     |
      | url      |  | user     |  | password |
