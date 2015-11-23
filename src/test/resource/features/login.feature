@Login
Feature: Login
  Test successfully and unsuccessfully and logout

  Background:
    Given I navigate to login page of Trello.com

  @SmokeTest
  Scenario Outline: Users should be able to Login using valid credentials
    When I login in Trello.com as "<User_Name>" with password "<Password>"
    Then I should login to Trello.com successfully

  Examples:
    |           User_Name              | Password |
    |miguel.terceros@fundacion-jala.org|morfeo3730|
    |ivan.morales@fundacion-jala.org   |Control123|

  @SmokeTest
  Scenario Outline: Users should be able to Login using wrong credentials
    When I login using wrong credentials in Trello.com as "<User_Name>" with password "<Password>"
    Then I not should login to Trello.com

  Examples:
    |           User_Name              | Password |
    |miguel.terceros@fundacion-jala.org|control123|
    |miguelTerceros@jalasoft.com       |          |
    |                                  |          |