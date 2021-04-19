Feature: When user read a Demand, Demands is returned

  Background:
    Given a Demands with title "Create folder into datalake" and description "Create a folder and manage credentiels infos"

  Scenario: user read Demands
    When User read previously created Demands
    Then title is "Create folder into datalake" and description is "Create a folder and manage credentiels infos"