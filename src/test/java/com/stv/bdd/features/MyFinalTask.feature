Feature: Wiggle Individual Task

  Scenario: Sign In Attempt In The Shopping Cart
    Given Home page is opened
    And All cookies are accepted on the Home page
    When The basket icon is clicked
    Then The empty basket page is displayed
    When The Sign In button is pressed
    Then The login page is opened
    When The continue button is pressed
    Then The login page is opened


  Scenario Outline: Check the forgotten password field
    Given Home page is opened
    And All cookies are accepted on the Home page
    When The user clicks the Sign In icon
    And The forgot password link in clicked
    Then The password recovery page is opened
    And The user inputs "<email>"
    And The user clicks Continue Button
    And Validation error appears
    And The user clears the input
    Examples:
      |email|
      |user@gmail|
      |mail_gmail.com|
      |new.mail@com  |

