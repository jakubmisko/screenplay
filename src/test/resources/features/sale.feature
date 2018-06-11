Feature: Sales

  Scenario: Filter sales by status
    Given that Jakub opens login page
    And he logs in
    And he navigate to Sales under Sales
    When he filters sales by merchant name : Test merch1
    Then only sales with Merchant name containing Wirecard Merchant should be visible
