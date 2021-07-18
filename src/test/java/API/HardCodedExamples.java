package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    /*
     * NOTE:
     *
     * Given - Preparing the request
     *
     * When - making the request/making the call/hitting the endpoint
     *
     * Then- verification/assertions
     */

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjY2MTgwNDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjY2MTI0NSwidXNlcklkIjoiMjkyOCJ9.neBZTyfaDcPNcXNKdBybAVh9MmBdh6FFzusB8f-3N_Y";
    static String employee_id;


    //@Test
    public void sampleTest() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type","application/json")
                .queryParam("employee_id","14158A");
        Response response = preparedRequest.when().get("/getOneEmployee.php");

        /*
         * Printing response using atString() method to convert JSON object to a String
         * and printing using System.out.println()
         */
        System.out.println(response.asString());
    }

    @Test
    public void aPostCreateEmployee(){
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type","application/json").body("{\n" +
                "  \"emp_firstname\": \"Vladik1\",\n" +
                "  \"emp_lastname\": \"Savi\",\n" +
                "  \"emp_middle_name\": \"vladimirovna\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1992-02-15\",\n" +
                "  \"emp_status\": \"Master\",\n" +
                "  \"emp_job_title\": \"CEO\"\n" +
                "}") ; //.log().all();
        /*
         * log().all() will log and print all information being sent with the request
         */
        Response response = preparedRequest.when().post("/createEmployee.php");
        /*
         * prettyPrint() does the same as System.out.println(response.atString());
         */
        //response.prettyPrint();
        /*
         * jsonPath() allows us to retrieve specific data from a json object - just like an xpath with selenium
         */
        employee_id = response.jsonPath().getString("Employee.employee_id");

        //System.out.println(employee_id);

        /**
         * Preforming assertions
         */
        response.then().assertThat().statusCode(201);
        /**
         * Using Hamcrest Matchers class. Type import manually
         */
        response.then().assertThat().body("Message",equalTo("Employee Created"));

        // Write an assertion that verifies that the response body has the name you used
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Vladik1"));

        /**
         * Verifying server
         */
        response.then().assertThat().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bGetCreatedEmployee(){

        RequestSpecification preparedRequest = given().header("Authorization",token).header("Content-type","application/json").queryParam("employee_id",employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        String empID = response.jsonPath().getString("employee.employee_id");
        //1 way
        boolean comparingEmpIDs = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpIDs);
        //2 way
        //Assert.assertTrue(empID.contentEquals(employee_id));

        //Task: Retrieve the first name and assert that the first name is the same as the one you used
        // DO NOT USE HAMCREST MATCHERS

        String firstName = response.jsonPath().getString("employee.emp_firstname");
        //boolean comparingFirstName = firstName.contentEquals("Vladik1");
        //Assert.assertTrue(comparingFirstName);
        Assert.assertTrue(firstName.contentEquals("Vladik1"));
    }

    //@Test
    public void cGetAllEmployees(){
        RequestSpecification preparedRequest = given().header("Authorization",token).header("Content-type","application/json");
        Response response = preparedRequest.when().get("/getAllEmployees.php");
        String allEmployees = response.prettyPrint();

        /**
         * Creating number of employees in response body
         */
        JsonPath js = new JsonPath(allEmployees);
        /**
         * Retrieving number of employees in response body
         */
        int count = js.getInt("Employees.size()");
        System.out.println(count);

        //Print out all employee IDs from the response
        for (int i = 0; i < count; i++) {
            String employeesIDs = js.getString("Employees[" +i+ "].employee_id");
            //System.out.println(employeesIDs);
            /**
             * Verify stored employee ID from previous call is in response body
             */
            if (employeesIDs.contentEquals(employee_id)){
                /**
                 * printing out the employee ID
                 */
                System.out.println("Employee ID "+employee_id +" is present in response body");
                String firstName = js.getString("Employees[" +i+ "].emp_firstname");
                /**
                 * Printing out the first name of the employee that we created
                 */
                System.out.println("Employee name is "+firstName);
                break;
            }
        }
    }
@Test
    public void dPutUpdateCreatedEmployee(){
        /*
         * Update the created employee
         */

        RequestSpecification preparedRequest = given().header("Authorization",token)
                .header("Content-type","application/json")
                .body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"JaneSmartGirl\",\n" +
                        "  \"emp_lastname\": \"Savi\",\n" +
                        "  \"emp_middle_name\": \"Vladimirovna\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1992-02-15\",\n" +
                        "  \"emp_status\": \"Tester\",\n" +
                        "  \"emp_job_title\": \"Tester\"\n" +
                        "}");
        Response response =  preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();


    }






}
