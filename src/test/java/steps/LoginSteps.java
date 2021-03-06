package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enters valid admin username amd password")
    public void user_enters_valid_admin_username_amd_password() {
        sendText(loginPage.usernameBox, ConfigReader.getPropertiesValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertiesValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        //Assert.assertTrue(dash.welcomeMessage.isDisplayed());
        String expected = "Welcome Admin";
        String actual = dashBoardPage.welcomeMessage.getText();
        Assert.assertEquals("Values do not match", expected,actual);
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        sendText(loginPage.usernameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        sendText(loginPage.usernameBox, "Admin");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("user see invalid credentials text on login page")
    public void user_see_invalid_credentials_text_on_login_page() {
        System.out.println("Error message is displayed");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox, password);
    }

    @When("{string} is successfully logged in")
    public void is_successfully_logged_in(String string) {
        System.out.println("Working fine");
    }

    @When("user enters valid username and inlavid password and verify the error")
    public void user_enters_valid_username_and_inlavid_password_and_verify_the_error(DataTable errordata) {
        List<Map<String, String>> employeeNames = errordata.asMaps();
        for (Map<String, String> employeeName : employeeNames) {
            String usernamevalue = employeeName.get("username");
            String passwordvalue = employeeName.get("password");
            String errorvalue = employeeName.get("errormessage");
            System.out.println(usernamevalue + " " + passwordvalue + " " + errorvalue);

            sendText(loginPage.usernameBox,usernamevalue);
            sendText(loginPage.passwordBox,passwordvalue);
            click(loginPage.loginBtn);

            String actual = loginPage.errorMessage.getText();
            Assert.assertEquals("Values do not match", errorvalue,actual);
            System.out.println("My test case is passed");
        }
    }

    @When("user enters different {string} and {string} and verify the {string} for all the combinations")
    public void user_enters_different_and_and_verify_the_for_all_the_combinations(String usernamevalue, String passwordvalue, String errorvalue) {
        sendText(loginPage.usernameBox,usernamevalue);
        sendText(loginPage.passwordBox,passwordvalue);
        click(loginPage.loginBtn);
        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals("Values do not match",errorvalue,actual);

    }

}
