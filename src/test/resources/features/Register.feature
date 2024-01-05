Feature: Registration Functionality
Scenario: Register a new user 
Given User has navigated to Register Account Page
When User enters the below details in below fields 
|firstname|Jiki|
|lastname|Patra|
|email|jiki@gmail.com|
|telephone|9003263449|
|password|Test|
|passwordConfirmation|Test|
And User selects Privacy Policy 
And User clicks on Continue button
Then User account should be created successfully 

Scenario: Register a duplicate user 
Given User has navigated to Register Account Page
When User enters the below details in below fields with duplicate email
|firstname|Jiki|
|lastname|Patra|
|email|jinki@gmail.com|
|telephone|9003263449|
|password|Test|
|passwordConfirmation|Test|
And User selects Privacy Policy 
And User clicks on Continue button
Then User receives error message

  @regression
  Scenario Outline: User registers multiple account
    Given User has navigated to Register Account Page
    When User enters firstname "<FirstName>"
    And User enters lastname "<LastName>"
    And User enters unique email address
    And User enters telephone "<Telephone>"
    And User enters password "<Password>"
    And User enters confirm password "<ConfirmationPassword>"
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should be created successfully
    Examples:
              |FirstName|LastName|Telephone|Password|ConfirmationPassword|
              |   AmirT  |Joy     | 9078616454| Amir123   | Amir123   |
              |   KalpanaT  |Joy     | 9970656754| Kal123   | Kal123   |
              |   SudhirT  |Sa     | 7988696454| Sud990   | Sud990   |