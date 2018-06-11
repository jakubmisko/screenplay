Feature: Tax categories

  Scenario: Create tax category
    Given that Jakub opens login page
    And he logs in
    And he navigate to Tax categories under System
    When he creates 20% standard tax category with name default for Slovakia (SK) valid from today
    Then his tax category should be created successfully