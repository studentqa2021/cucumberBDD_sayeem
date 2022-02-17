@Smoke
Feature: Title of your feature
  I want to use this template for my feature file

  @tac001_to_tc005
  Scenario: As an Orbis user, can do successfull login with valid credential
    Given Open browser
    And go to application URL
    When put valid username
    And put valid password
    And click signin button
    Then login should be successfull and showed sign out button
    And close browser