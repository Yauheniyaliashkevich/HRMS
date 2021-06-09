Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user click on PIM option
    And user click on Add employee button

  @smoke
  Scenario:Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user clicks on save button option
    Then employee added successfully

    @smoke
    Scenario: Adding employee from add employee page via feature file
      And user enters first name "Yulia123" middle name "MS" and last name "Yulia456"
      And user clicks on save button option
      Then employee added successfully

      @example
      Scenario Outline: Adding employee from add employee page via feature file
        And user enter "<FirstName>" "<MiddleName>" and "<LastName>" in the application
        And user clicks on save button option
        Then employee added successfully

        Examples:
        |FirstName|MiddleName|LastName|
        |Test12345| MS      |Test9876|
        |Test1212 | MS      |Test7654|
        |Test3232 | MS      |Test5454|


  @datatablewithheader
  Scenario: Adding multiple employees in a single execution
    When add multiple employees and verify they are added successfully
      |FirstName|MiddleName|LastName|
      |John04014 |MS1        |US1      |
      |Jack05051 |MSS1       |USA1     |
      |Janna123  |MS123      |USA1     |

    @excel
    Scenario: Adding the employee from excel file
      When user adds multiple employees from excel file "newdata" sheet and verify they are added

