
Feature: Google search functionality
  Agile story As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information
@google
  Scenario: go the home page
    When user are login
    Then user can see the title


  @student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

  @admin @employee
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard



