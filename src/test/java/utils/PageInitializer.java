package utils;

import io.cucumber.java.bs.A;
import pages.*;

public class PageInitializer {

    public static AddEmployeePage addEmployeePage;
    public static DashBoardPage dashBoardPage;
    public static EmployeeListPage employeeListPage;
    public static LoginPage loginPage;
    public static AddTitlePage addTitlePage;

    public static void initializePageObjects (){
        addEmployeePage = new AddEmployeePage();
        dashBoardPage = new DashBoardPage();
        employeeListPage = new EmployeeListPage();
        loginPage = new LoginPage();
        addTitlePage = new AddTitlePage();
    }
}
