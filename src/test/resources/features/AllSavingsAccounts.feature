Feature: this feature allows user to see all the saving account information

  Background: user logged on the site
    Given user on the login page
    When user enter valid credentials
    Then verify user on the Home page
    Then user click on the Savings field
    Then verify View Savings and New Savings options displayed
    When user click on View Savings option

  Scenario: this feature allows user to see all the transaction headers are displayed
    Given Transactions header is displayed
    Then verify Date header is displayed
    Then verify Category header is displayed
    Then verify Description header is displayed
    Then verify Amount header is displayed
    Then verify Balance header is displayed


  Scenario: verify if user has more than one account, only one of them is activated
    Given user has several accounts
    Then check the number of accounts
    Then verify only one toggle button is activated

  Scenario: verify transaction history for a particular checking account
    Given only one toggle button is activated
    Then verify user can see the same account data in the transaction table





### AllSavingsAccounts###

#>As a User,
#I want to have the ability to view all my Savings bank account
#so that I can manage my accounts and see account balance and transactions.
#>
#
#Functionalities:
#1. After User creates a new savings account, user should be able to view savings account information.
###All information should match the entered values during the submission of savings account.
#2. Display "Transactions" table with all transaction details:
#- Display header "Date": Date and time when transaction happened.
#- Display header "Category": What kind of transaction was made: Income, Misc etc
#- Display header "Description": Displays transaction id and type of Transaction
#- Display header "Amount": Displays the amount of made transaction
#- Display header "Balance": Displays balance amount, after each transaction
#3. If User has more than 1 checking accounts, only one of the accounts can be Actived:
#- Display ON/OFF toggle button on each Savings account
#- Display transaction history for a particular checking accou