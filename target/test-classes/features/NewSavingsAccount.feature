Feature: This feature allows user to create new savings account

  Background: user is logged on the site
    Given user is on the login page
    When user enters the valid credentials
    Then verify user is on the Home page
    Then user clicks on the Savings field
    Then verify View Savings and New Savings options are displayed
    When user clicks on New Savings option

  Scenario: verify New Savings page is opened
    Given page with corresponding URL is opened
    Then verify New Saving Account header is displayed

  Scenario: verify Select Savings Account Type radio button options are visible and unchecked by default
    Given Select Savings Account Type header is displayed
    Then verify Savings and Money Market radio buttons unchecked by default


  Scenario: verify the Select Account Ownership radio button options are visible and unchecked by default
    Given verify the Select Account Ownership header is displayed
    Then verify the Individual and Joint radio buttons unchecked by default

  Scenario:  Verify user is able to enter the account name with alphanumeric and special characters
    Given user is in account name field
    When user enters the account name with alphanumeric and special characters
    Then verify that entered account name corresponds to the name displayed in the field

  Scenario Outline: Verify user can enter valid numeric whole or decimal amount in the Initial Deposit Amount field
    Given user is in input field Initial Deposit Amount
    When user enters valid numeric whole or decimal number "<amount>"
    Then verify amount in the field is the same "<amount>"

    Examples:
      | amount      |
      | 2500.00     |
      | 2500        |
      | 1000000     |

  Scenario Outline: Verify user cannot to enter invalid input
    Given user is in input field initial deposit amount
    When user enters the invalid "<input>"
    Then verify corresponding error message is displayed

    Examples:
      | input       |
      | $25.00      |
      | 15          |
      | hundred     |
      |             |
  Scenario: verify user is able to create an account and redirected to page to view saving account
    Given user filled the fields
    When user clicks on the Submit button
    Then verify user is redirected to page to view saving account

  Scenario: verify user can click on Reset button
    Given user filled the fields
    When user clicks on the Reset button
    Then verify all the filled values are reset to default





#* Rule 1: Unselected Account Type:
# Logic: Account Type options are not selected.
#Error Msg: "Please select one of these options."
#* Rule 2: Unselected Account Ownership:
# Logic: Account Ownership options are not selected.
#Error Msg: "Please select one of these options."
#* Rule 3: Empty Account Name:
# Logic: Clicking submit button with an empty Account Name.
#Error Msg: "Please fill out these field."
#* Rule 4: Empty Initial Deposit Amount:
# Logic: Clicking submit button with an empty Initial Deposit Amount.
#Error Msg: "Please fill out these field."
#* Rule 5: Invalid Initial Deposit Amount:
# Logic: Clicking submit button with an invalid Initial Deposit Amount.
#Error Msg: "Please match the requested format."
#* Rule 6: Minimum Initial Deposit Amount:
# Logic: Clicking submit button with Initial Deposit Amount less than a minimum amount.
#Error Msg: "TThe initial deposit ($enteredAmount) entered does not meet the minimum amount ($2500.00) required.
# Please enter a valid deposit amount."