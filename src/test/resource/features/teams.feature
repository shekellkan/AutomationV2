@Teams
Feature: Teams
  create a team, delete team, edit perfil, add members

  Background:
    Given I navigate to login page of Trello.com
    And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario Outline: create a new team with description
    Given I go to Create Team page
    And I have to create a new team "<Name Team>" with description "<Description>"
    Then The new team "<Name Team>" is created.

    Examples:
    |     Name Team       |         Description               |
    |New_Team             |                                   |
    |Team_Description     |This is a new Team with description|

  Scenario: delete a team existent "Teams_Deleted"
    Given I create a team "Teams_Deleted" with description "This teams is for deleted"
      And I deleted the team
      Then The team "Teams_Deleted" is deleted

  Scenario Outline: add members existent in a team
    Given I add new members in team "Team_Members" with description "added members in this team"
      And I navigate until to menu Members
      And I add to member "<Name Member>" with the email "<Email>"
      Then The  member "<Name Member>" is added in the team

    Examples:
    |Name Member  |            Email              |
    |Ivan Morales |ivan.morales@fundacion-jala.org|
    |Diego Olivera|diegoC3730@gmail.com           |