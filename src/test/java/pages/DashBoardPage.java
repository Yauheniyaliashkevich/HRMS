package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashBoardPage extends CommonMethods {

    @FindBy (id = "welcome")
    public WebElement welcomeMessage;

    @FindBy (xpath = "//b[text()='PIM']") //(id= "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy (id= "menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy (id= "menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy (xpath= "//div[@class='menu']/ul/li")
    public List<WebElement> dashboardtabs;

    @FindBy (xpath = "//*[@id='menu_admin_viewAdminModule']/b")
    public WebElement adminButton;

    @FindBy (id = "menu_admin_Job")
    public WebElement jobButton;

    @FindBy (id = "menu_admin_viewJobTitleList")
    public WebElement jobTitlesButton;

    @FindBy (id = "btnAdd")
    public WebElement addTitleButton;

    public DashBoardPage (){
        PageFactory.initElements(driver,this);
    }

}
