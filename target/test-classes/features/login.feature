Feature: Login feature


  Scenario:  Verify user is on the login page
    Given user entered correct URL
    Then verify the title of the webpage is Digital Bank
    And verify all sign-in text boxes and buttons are present

  Scenario: Verify user is able to login with valid credentials
    Given user enters valid username "<username>" and password "<password>"
    When user clicks on Sign In button
    Then verify user is successfully logged in to the account

  Scenario Outline: Verify user is not able to login with invalid credentials
    Given user enters invalid username "<invalidUsername>" and password "<invalidPassword>"
    When user clicks on Sign In button
    Then verify user login failed with an error message
    Examples:
      | invalidUsername       | invalidPassword |
      | nicolesmith@gmail.com | abc123          |
      | chirag                | admin123        |
      | chirag                | devx            |
      |                       | admin123        |
      | admin                 |                 |
      |                       |                 |


  Scenario:  Verify database
    Given user can retrieve data
