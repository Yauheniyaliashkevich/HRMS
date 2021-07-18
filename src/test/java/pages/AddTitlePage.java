package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class AddTitlePage extends CommonMethods {

    @FindBy (id= "jobTitle_jobTitle")
    public WebElement jobTitleField;

    @FindBy (id = "jobTitle_jobDescription")
    public WebElement jobDescriptionField;

    @FindBy (id = "btnSave")
    public WebElement addTitleSaveBtn;

    @FindBy (xpath = "//table[@id = 'resultTable']/tbody/tr/td")
    public List<WebElement> jobTitlesTable;

    public AddTitlePage (){
        PageFactory.initElements(driver,this);
    }

}
