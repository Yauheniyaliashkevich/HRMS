package utils;

import com.google.gson.JsonObject;
import org.json.JSONObject;



public class apiPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Vladik1\",\n" +
                "  \"emp_lastname\": \"Savi\",\n" +
                "  \"emp_middle_name\": \"vladimirovna\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1992-02-15\",\n" +
                "  \"emp_status\": \"Master\",\n" +
                "  \"emp_job_title\": \"CEO\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeBody(){

        /**
         * We imported a dependency for JSONObject
         *       + import org.json.JSONObject;
         */

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Vladik1");
        obj.put("emp_lastname","Savi");
        obj.put("emp_middle_name","vladimirovna");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1992-02-15");
        obj.put("emp_status","Master");
        obj.put("emp_job_title","CEO");
        return obj.toString();
    }

    public static String createEmployeeBodyMoreDynamic(String firstName, String lastName, String middleName, String gender, String emoloyeeBday, String employeeStatus, String employeeJobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",firstName);
        obj.put("emp_lastname",lastName);
        obj.put("emp_middle_name",middleName);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",emoloyeeBday);
        obj.put("emp_status",employeeStatus);
        obj.put("emp_job_title",employeeJobTitle);
        return obj.toString();
    }

}
