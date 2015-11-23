@Boards
  Feature: Boards
    create a new board,delete a board, add user stories

    Background:
      Given I navigate to login page of Trello.com
      And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario: create a new board in a project
    Given I create a project "Project_With_Board"
      And I create a board "BackLog"
      And I create a User Stories "Stories_1"
      Then the board "BackLog" is created in the project with a user stories