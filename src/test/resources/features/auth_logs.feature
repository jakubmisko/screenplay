Feature: Authentication logs

  Scenario: Check authentication logs from current login
    Given that Jakub opens login page
    And he logs in
    And he navigate to Authentication logs under System
    When he filter logs by username jakub.misko
    And he sort logs by Date descending
    Then 1 st row Date should be from today

