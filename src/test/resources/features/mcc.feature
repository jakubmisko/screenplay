Feature: Merchant category codes

  Scenario: Create merchant category code
    Given that Jakub opens login page
    And he logs in
    And she navigate to Merchant category codes under System
    When he creates category Test with code 9998
    Then his mcc should be created successfully