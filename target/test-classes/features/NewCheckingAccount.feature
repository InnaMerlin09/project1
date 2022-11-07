Feature: This feature allows user to create new checking account

  Background: user is logged in
    Given user is on login page
    When user enters valid credentials
    Then verify user is on Home page
    Then user clicks on Checking field
    Then verify View Checking and New Checking options are displayed
    When user clicks on New Checking Account

  Scenario: verify New Checking Account header is visible
    Then verify New Checking Account header is displayed

  Scenario: verify Select Checking Account Type radio button options are unchecked by default
    Then verify Select Checking Account header is displayed
    And verify Standard and Interest Checking radio buttons unchecked by default


  Scenario: verify Select Account Ownership radio button options are unchecked by default
    Then verify Select Account Ownership header is displayed
    And verify Individual and Joint radio buttons unchecked by default

  Scenario:  Verify user is able to enter account name with alphanumeric and special characters
    Given user is in the account name Field
    When user field user enters account name with alphanumeric and special characters
    Then verify that the entered account name corresponds to the name displayed in the field

  Scenario Outline: Verify user is able to enter valid numeric whole or decimal amount
    Given user is in the input field Initial Deposit Amount
    When user enters valid numeric whole or decimal "<amount>"
    Then verify amount in the field is the same as entered "<amount>"

    Examples:
      | amount      |
      | 25.00       |
      | 25          |
      | 1000000     |

  Scenario Outline: Verify user is not able to enter invalid input
    Given user is in the input field initial deposit amount
    When user enters invalid "<input>"
    Then verify user can't continue and corresponding error message is displayed

    Examples:
      | input       |
      | $25.00      |
      | 15          |
      | hundred     |

  Scenario: verify user is able to create an account and redirected to page to view checking account
    Given user filled all the fields
    When user clicks on Submit button
    Then verify user is redirected to page with checking accounts and cen see message Successfully created new Interest Checking account named account name

  Scenario: verify user is able to click on Reset button
    Given user filled all the fields
    When user clicks on Reset button
    Then verify all filled values are reset to default


###PreferredCheckingAccount###
 #Functionalities:
 #1. Display Checking field under BANKING ACCOUNTS section,
 #clicking on 'Checking' dropdown should be displayed with following options: View Checking, New Checking
 #2. Clicking on 'New Checking' option, should redirect user to "http://3.131.35.165:8080/bank/account/checking-add"
 ###(Note: Click on 'New Checking' and try to open it in new tab) ------
 #3. Display a header "New Checking Account"
 #4. Display a label "Select Checking Account Type" with the following radio button options:
 #  Standard Checking, Interest Checking
 #  - All Radio buttons should be unchecked by default
 #5. Display a label "Select Account Ownership" with the following radio button options: Individual, Joint
 #  - All Radio buttons should be unchecked by default
 #6. Display an Input filed "Account Name".
 #- Accepts alphanumeric and special characters.
 #6. Display an Input filed "Initial Deposit Amount"
 #- Minimum opening deposit is $25.00. Accepts numeric whole or decimal values.
 #7. Display 'Submit' button, clicking on it should successfully create an account
 # and user will be redirected to page to view checking account.
 #8. Display 'Reset' button, clicking on it should reset all filled values to default state.