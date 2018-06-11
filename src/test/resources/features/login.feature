Feature: Login as different users

  Scenario: Login as superadmin
    Given that Jakub opens login page
    When he logs in
    Then he should be logged in successfully
