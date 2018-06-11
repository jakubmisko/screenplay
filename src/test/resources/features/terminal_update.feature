Feature: Terminal updates

  Scenario: Create terminal update
    Given that Jakub opens login page
    And he logs in
    And he navigate to Updates under Terminals
    When he tries to create update with no data
    Then he should see marked all mandatory fields for terminal update