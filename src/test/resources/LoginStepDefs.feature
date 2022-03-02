@Smoke
Feature: cucumberBDD_Test

  @tac001_to_tc005
  Scenario: As an Orbis user, can do successfull login with valid credential
    Given Open browser
    And go to application URL "<Applink>"
    When put valid username "<username>"
    And put valid password "<pass>"
    And click signin button
    Then login should be successfull and showed sign out button
    Then click Fight URL
    And close browser
    
    
   Examples:
    
    |Applink|  |username| |pass|
    
    	|url|			|user| 		|password|