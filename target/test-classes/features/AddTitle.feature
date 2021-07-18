Feature: Add job title

  @title
  Scenario Outline: Adding new job title
    And user is logged in with valid admin credentials
    Then user clicks on Admin button
    And user clicks on Job Titles button
    And user adds new "<Job Title>" and "<Job Description>"
    And enter query into HRMS database
    Then verify that new job title added successfully

    Examples:
    |Job Title  | Job Description  |
    |LifeEnjoyer|Enjoy every moment|
    |HumanLover |Love people       |

