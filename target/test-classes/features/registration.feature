Feature:This feature will allow user to successfully create an account


  Background: Verify Sign Up Here link redirects the user to the Sign Up page
    Given user is on Login page
    When user clicks on sign Up Here link
    Then verify user is on the registration page

  Scenario Outline: Verify user is able to choose a proper title from the drop-down window
    When user click on Title field
    Then verify user can see the drop-down window with title options
    And verify chosen "<selection>" appears in the "<title>" field
    Examples:
      | title | selection |
      | Ms.   | Ms.       |
      | Mr.   | Mr.       |
      | Mrs.  | Mrs.      |


  Scenario: Verify user can enter first name
    When user enters "<First Name>" in first name field
    Then verify first name is displayed in the first name field


  Scenario: Verify user can enter last name
    When user enters "<Last Name>" in last name
    Then verify Last Name is displayed in the last name field

  Scenario: Verify user can select gender
    When user clicks on M radio button
    Then verify active radio button is M
    When user clicks on F radio button
    Then verify active radio button is F


  Scenario Outline: Verify user can enter correct date of birth
    Given user clicks on DOB field
    When user types correct "<month>", "<day>", "<year>" format
    Then verify "<month>", "<day>", "<year>" is displayed  in the corresponding field
    Examples:
      | month | day | year |
      | 01    | 03  | 2000 |
      | 12    | 01  | 1995 |
      | 08    | 15  | 1967 |


  Scenario Outline: Verify user can't enter invalid date of birth
    Given user clicks on DOB field
    When user types incorrect "<invalidMonth>", "<invalidDay>", "<invalidYear>" format
    Then verify user gets an error message "Please match the requested format"
    Examples:
      | invalidMonth | invalidDay | invalidYear |
      | 13           | 32         | 2023        |
      | 12           | 01         | 1867        |
      | 02           | 30         | 1998        |
      | 12           | 06         | 2007        |

  Scenario Outline:  Verify user is able to enter correct SSN
    Given user clicks on SSN field
    When user types in correct "<ssn>" format
    Then "<ssn>" is displayed in the SSN field
    Examples:
      | ssn         |
      | 123-45-6789 |
      | 123456789   |
      | 003-45-7777 |

  Scenario Outline:  Verify user is not able to enter incorrect SSN
    Given user clicks on SSN field
    When user types incorrect "<InvalidSSN>" format
    Then error message is displayed prompting to enter correct format SSN
    Examples:
      | InvalidSSN   |
      | 123456789999 |
      | 123$567*900  |
      | 00-000-0000  |
      | 123$567*900  |
      | 0a-000-j000  |