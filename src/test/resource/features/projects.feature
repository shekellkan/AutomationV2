@Projects
Feature: Projects
  create new projects, add members, change background, delete project

  Background:
    Given I navigate to login page of Trello.com
      And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

#  Scenario: Add a new project
#    Given I go to create Project page
#      And I add a new project "Test"
#      Then the new project "Test" is created

#  Scenario: Add a new project with team
#    Given I go to create Project page  with a "Project_Team2" team
#      And I add a new project "Project_With_Team" by selecting the team "Project_Team2"
#      Then the new project "Project_With_Team" is created

#  Scenario: Deleted a project
#    Given I create a project "Project_Deleted"
#    And I deleted the project
#    Then the project "Project_Deleted" is deleted