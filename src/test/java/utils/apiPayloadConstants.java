package utils;

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

}
