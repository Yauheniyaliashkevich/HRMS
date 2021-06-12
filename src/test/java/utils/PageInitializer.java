package utils;

import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {

    public static AddEmployeePage addEmployeePage;
    public static DashBoardPage dashBoardPage;
    public static EmployeeListPage employeeListPage;
    public static LoginPage loginPage;

    public static void initializePageObjects (){
        addEmployeePage = new AddEmployeePage();
        dashBoardPage = new DashBoardPage();
        employeeListPage = new EmployeeListPage();
        loginPage = new LoginPage();
    }
}
