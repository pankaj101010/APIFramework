package ApiCode;
import BaseTest.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class GetApi extends BaseClass {

/*
    public static Response GetApiCode(){
      String emp = "employees";
      Response response = given().get(""+Base_url+""+BASE_Path+""+emp+"");
      System.out.println(""+Base_url+""+BASE_Path+""+emp+"");
          return  response;
    }

 */
public static Response GetApiCode(){
    String emp = "user";
    Response response = given().auth().basic("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIyMzIiLCJ1bmlxdWVfbmFtZSI6IjIzMiIsImdpdmVuX25hbWUiOiJUZXN0IFByb2R1Y3Rpb24iLCJqdGkiOiJjZjEwZDlkMi1lYjY3LTRlZGYtOTRmNS0wMmU2MjcyYWM3ZTAiLCJlbWFpbCI6IlRlc3RQcm9kdWN0aW9uQHlvcG1haWwuY29tIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy91c2VyZGF0YSI6Ik11bHRpLVN0YXRlIiwibmJmIjoxNTg3OTYyNTYxLCJleHAiOjE1ODgwNDg5NjEsImlzcyI6Imh0dHA6Ly9rcGZvcm1zbW9kdWxlLmNvbSIsImF1ZCI6Imh0dHA6Ly9rcGZvcm1zbW9kdWxlLmNvbSJ9.M2SKQv5CTpufj1-5AEjfZ3A87kkJNOx6PafKVUFiK_A","").get(""+Base_url+""+BASE_Path+""+emp+"");
    System.out.println(""+Base_url+""+BASE_Path+""+emp+"");
    return  response;
}

    public static Response GetApiCodeByID(String id){
        String emp = "employee/";
        Response response = given().get(""+Base_url+""+BASE_Path+""+emp+""+id+"");
        System.out.println(""+Base_url+""+BASE_Path+""+emp+""+id+"");
        return  response;
    }

    public static String token(){
        RestAssured.baseURI ="https://restful-booker.herokuapp.com/auth/";
        RequestSpecification rr = RestAssured.given();
        String body = "{\"username\":\"admin\",\"password\":\"password123\"}";
        Response rs = given().contentType(ContentType.JSON).body(body).post(baseURI);
        String rt = rs.getSessionId();
        System.out.println(rs.prettyPrint());
        System.out.println(rs.getStatusCode());
        JSONObject obj = new JSONObject(rs.getBody().asString());
        String accesstoken = obj.get("token").toString();
    return accesstoken;
    }

    public static void getBookId(){

    }

}
