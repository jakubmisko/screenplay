Feature: Terminal capability template

  Scenario: Create terminal capability template
    Given that Jakub opens login page
    And he logs in
    And he navigate to Terminal Capabilities Templates under Terminals
    When he creates terminal capability with name capability and capabilities E002233
    Then his terminal capability should be created successfully