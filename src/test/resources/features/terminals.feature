Feature: Terminals
  
  Scenario: Create new terminal
    Given that Jakub opens login page
    And he logs in
    And she navigate to Terminals under Terminals
    When he creates new Spire - SPm2 terminal with serial staring with 400 and merchant Test merch1
    Then his terminal should be created successfully