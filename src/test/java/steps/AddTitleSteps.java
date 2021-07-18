package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.CommonMethods;
import utils.GlobalVariables;

public class AddTitleSteps extends CommonMethods {
    @Then("user clicks on Admin button")
    public void user_clicks_on_admin_button() {
        click(dashBoardPage.adminButton);
    }

    @Then("user clicks on Job Titles button")
    public void user_clicks_on_job_titles_button() {
        Actions actions = new Actions(driver);
        actions.moveToElement(dashBoardPage.jobButton).perform();
        click(dashBoardPage.jobTitlesButton);
    }

    @Then("user adds new {string} and {string}")
    public void user_adds_new_and(String jobTitle, String jobDescription) {
        click(dashBoardPage.addTitleButton);
        GlobalVariables.newJobTitle= jobTitle;
        sendText(addTitlePage.jobTitleField,GlobalVariables.newJobTitle);
        GlobalVariables.newJobDescription=jobDescription;
        sendText(addTitlePage.jobDescriptionField,GlobalVariables.newJobDescription);
        click(addTitlePage.addTitleSaveBtn);
    }

    @Then("verify that new job title added successfully")
    public void verify_that_new_job_title_added_successfully() {
        /*for (WebElement jobTitle: addTitlePage.jobTitlesTable) {
            if(jobTitle.getText().equals("LifeEnjoyer")){
                Assert.assertEquals(jobTitle.getText(),"LifeEnjoyer");
                System.out.println("Test passed");
                break;
            }else if (jobTitle.getText().equals("HumanLover")){
                Assert.assertEquals(jobTitle.getText(),"HumanLover");
                System.out.println("Test passed");
                break;
            }
        }*/

        System.out.println("Frontend");
        System.out.println("New Job Title: "+GlobalVariables.newJobTitle);
        System.out.println("New Job Description: "+GlobalVariables.newJobDescription);
        System.out.println("Backend");
        System.out.println("New Job Title DB: "+GlobalVariables.dbNewJobTitle);
        System.out.println("New Job Description DB: "+GlobalVariables.dbNewJobDescription);
        Assert.assertEquals(GlobalVariables.newJobTitle, GlobalVariables.dbNewJobTitle);
        Assert.assertEquals(GlobalVariables.newJobDescription, GlobalVariables.dbNewJobDescription);

    }
}
