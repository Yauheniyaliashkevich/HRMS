package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user click on PIM option")
    public void user_click_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }
    @When("user click on Add employee button")
    public void user_click_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add= new AddEmployeePage();
        sendText(add.firstName,"Nelson123");
        sendText(add.middleName,"MS");
        sendText(add.lastName,"MS123");
    }
    @When("user enters first name {string} middle name {string} and last name {string}")
    public void user_enters_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        AddEmployeePage add= new AddEmployeePage();
        sendText(add.firstName,firstName);
        sendText(add.middleName,middleName);
        sendText(add.lastName,lastName);
    }
    @When("user enter {string} {string} and {string} in the application")
    public void user_enter_and_in_the_application(String firstName, String middleName, String lastName) {
        AddEmployeePage add= new AddEmployeePage();
        sendText(add.firstName,firstName);
        sendText(add.middleName,middleName);
        sendText(add.lastName,lastName);
    }

    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add= new AddEmployeePage();
        click(add.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added successfully");
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String,String>> employeeNames = employees.asMaps();
        for(Map<String,String> employeeName:employeeNames){
            String firstnamevalue = employeeName.get("FirstName");
            String middlenamevalue = employeeName.get("MiddleName");
            String lastnamevalue = employeeName.get("LastName");
            System.out.println(firstnamevalue+" "+middlenamevalue+" "+lastnamevalue);

            AddEmployeePage addEmployeePage=new AddEmployeePage();
            sendText(addEmployeePage.firstName,firstnamevalue);
            sendText(addEmployeePage.middleName,middlenamevalue);
            sendText(addEmployeePage.lastName,lastnamevalue);
            click(addEmployeePage.saveBtn);

            //assertion take it as HW
            String actual = addEmployeePage.firstName.getText();
            Assert.assertEquals("Values do not matches",firstnamevalue,actual );

            Thread.sleep(2000);
            DashBoardPage dash=new DashBoardPage();
            click(dash.addEmployeeButton);

        }
    }

    @When("user adds multiple employees from excel file {string} sheet and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_sheet_and_verify_they_are_added(String sheetname) {
        List<Map<String,String >> newemployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetname);

        DashBoardPage dash = new DashBoardPage();
        AddEmployeePage addEmployeePage=new AddEmployeePage();

        Iterator<Map<String ,String >> it= newemployees.iterator();
        while (it.hasNext()){
            Map <String ,String > mapNewEmp=it.next();
            sendText(addEmployeePage.firstName,mapNewEmp.get("FirstName"));
            sendText(addEmployeePage.middleName,mapNewEmp.get("MiddleName"));
            sendText(addEmployeePage.lastName,mapNewEmp.get("LastName"));
            click(addEmployeePage.saveBtn);

            //assertion complete in HW
            //assertion complete in HW
           // boolean actual=addEmployeePage.employeesRecordData.isDisplayed();
            //Assert.assertTrue(actual);
           // System.out.println("Employee full name displayed "+addEmployeePage.employeesRecordData.getText());
            click(dash.addEmployeeButton);

        }
    }
}
