Feature: Partners

  Scenario: Create partner
    Given that Jakub opens login page
    And he logs in
    And she navigate to Partners under System
    When he creates partner Jakub with email jakub@mail.com from Slovakia (SK)
    Then his partner should be created successfully