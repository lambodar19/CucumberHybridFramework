Feature: Search Functionality

Scenario: User searches for valid product 
Given User has opened the application 
When User has entered valid product "hp" into the search box field 
And User clicks on Search button 
Then User should get valid product displayed in search results

Scenario: User searches for invalid product 
Given User has opened the application 
When User has entered invalid product "877777" into the search box field 
And User clicks on Search button 
Then User should get valid error message 
