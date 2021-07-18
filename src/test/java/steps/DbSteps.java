package steps;

import io.cucumber.java.en.Then;
import utils.DbUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DbSteps  {

    @Then("query the HRMS database")
    public void query_the_hrms_database() {
         //String query="select emp_firstname,\" +\n" +
         //        "                \"emp_middle_name,emp_lastname\" +\n" +
         //        "                \" from hs_hr_employees where emp_number="+ GlobalVariables.empId;


          String query = "select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where emp_number="+GlobalVariables.empId;

         List<Map<String,String >> tableDataAsList =  DbUtils.getTableDataAsList(query);
         GlobalVariables.dbFirstName= tableDataAsList.get(0).get("emp_firstname");
         GlobalVariables.dbMiddleName= tableDataAsList.get(0).get("emp_middle_name");
         GlobalVariables.dbLastName= tableDataAsList.get(0).get("emp_lastname");
    }

    @Then("enter query into HRMS database")
    public void enter_query_into_hrms_database() {
        String query = "select job_title,job_description from ohrm_job_title where job_title ='"+GlobalVariables.newJobTitle+"'";
        List<Map<String,String>> newJobTable = DbUtils.getTableDataAsList(query);
        GlobalVariables.dbNewJobTitle = newJobTable.get(0).get("job_title");
        GlobalVariables.dbNewJobDescription = newJobTable.get(0).get("job_description");


    }

}


