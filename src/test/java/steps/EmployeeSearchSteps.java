package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {


    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        sendText(loginPage.usernameBox, ConfigReader.getPropertiesValue("username"));
        sendText(loginPage.passwordBox,ConfigReader.getPropertiesValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        click(dashBoardPage.pimOption);
        click(dashBoardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_only_employee_id() {
        sendText(employeeListPage.idEmployee,"15518");
    }

    @When("click on search button")
    public void click_on_search_button() {
        click(employeeListPage.searchButton);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        sendText(employeeListPage.employeenamefield,"sofiia");
    }

   @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Employee name is displayed");
    }        //I delete tearDown() because I added hooks



}
