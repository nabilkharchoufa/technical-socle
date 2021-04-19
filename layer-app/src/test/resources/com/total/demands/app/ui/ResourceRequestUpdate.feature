Feature: When user update a Demands, Demands is saved

  Background:
    Given a Demands with title "Create folder into datalake" and description "Create a folder and manage credentiels infos"

  Scenario: user read Demands
    When User Change description of previously created Demands with Title "Go to the Supermarket" and description to "Buy some cucumbers"
    When User read previously created Demands
    Then title is "Go to the Supermarket" and description is "Buy some cucumbers"