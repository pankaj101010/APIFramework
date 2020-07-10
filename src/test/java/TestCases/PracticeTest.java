package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PracticeTest {
   public static String accesstoken ="";
  @Test(priority = 0)
    public void tc(){
      RestAssured.baseURI ="https://restful-booker.herokuapp.com/auth/";
      RequestSpecification rr = RestAssured.given();
      String body = "{\"username\":\"admin\",\"password\":\"password123\"}";
      Response rs = given().contentType(ContentType.JSON).body(body).post(baseURI);
        String rt = rs.getSessionId();
        System.out.println(rs.prettyPrint());
        System.out.println(rs.getStatusCode());
      JSONObject obj = new JSONObject(rs.getBody().asString());
      accesstoken = obj.get("token").toString();
     // String tokenType = obj.get("token_type").toString();
      System.out.println(accesstoken);
      tc_02();
      tc_03();
      tc_04();
//     Response rs1 = given().auth().basic(accesstoken,"").get("https://restful-booker.herokuapp.com/");
//       // System.out.println(rs1.prettyPrint());
//     Response rs3 =  given().auth().basic(accesstoken,"").queryParam("firstname","sally").queryParam("lastname","brown").get("https://restful-booker.herokuapp.com/booking/");
//System.out.println(rs3.prettyPrint());
    }
   public  void tc_03(){
      System.out.println("calling tc_03 method");
      baseURI = "https://restful-booker.herokuapp.com/booking";
      Response rs = given().auth().basic(accesstoken,"").get();
      System.out.println(rs.prettyPrint());
       System.out.println(rs.getBody());
   }
    public void tc_02(){
        System.out.println("calling tc_02 method");
      baseURI = "https://restful-booker.herokuapp.com/";
        RequestSpecification rq = given();
         Response rs =  rq.auth().basic(accesstoken,"").queryParam("checkin","2019-06-07").queryParam("checkout","2020-04-12").get("/booking");
//        ResponseBody body = rs.body();
//        System.out.println(body.asString());
        JsonPath jsonPathEvaluator = rs.jsonPath();
        System.out.println(jsonPathEvaluator.get("bookingid").toString());
    }
    public void tc_04(){
      System.out.println("Calling tc_04 method");
      baseURI = "https://restful-booker.herokuapp.com/booking/";
      RequestSpecification rq = given();
      Response rs = rq.auth().basic(accesstoken,"").contentType(ContentType.JSON).get("1");
      System.out.println(rs.prettyPrint());
      System.out.println("=====================");
        JsonPath jsonPathEvaluator = rs.jsonPath();
        System.out.println(jsonPathEvaluator.get("bookingdates"));
    }
}
