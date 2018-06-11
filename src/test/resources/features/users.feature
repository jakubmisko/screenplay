Feature: Users

  Scenario: Create System admin
    Given that Jakub opens login page
    And he logs in
    And he navigate to Users under System
    When he creates user Jakub Misko with username jakubmisko and System administrator role
    Then his user should be created successfully