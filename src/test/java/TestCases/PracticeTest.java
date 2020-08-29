package TestCases;

import com.codoid.products.exception.FilloException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static DataDriven.TestFillo.getData;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PracticeTest {
   public static String accesstoken ="";
   public  Response rs;
   @BeforeClass
   public void config(){
       RestAssured.baseURI ="https://restful-booker.herokuapp.com/";
       RequestSpecification rq = RestAssured.given();
   }
  @Test(priority = 0)
    public void tc(){

      RequestSpecification rr = RestAssured.given();
      String body = "{\"username\":\"admin\",\"password\":\"password123\"}";
       rs = given().contentType(ContentType.JSON).body(body).post("/auth");
        String rt = rs.getSessionId();
        System.out.println(rs.prettyPrint());
        System.out.println(rs.getStatusCode());
      JSONObject obj = new JSONObject(rs.getBody().asString());
      accesstoken = obj.get("token").toString();
     // String tokenType = obj.get("token_type").toString();
      System.out.println(accesstoken);
//      tc_02();
//      tc_03();
//      tc_04();
//     Response rs1 = given().auth().basic(accesstoken,"").get("https://restful-booker.herokuapp.com/");
//       // System.out.println(rs1.prettyPrint());
//     Response rs3 =  given().auth().basic(accesstoken,"").queryParam("firstname","sally").queryParam("lastname","brown").get("https://restful-booker.herokuapp.com/booking/");
//System.out.println(rs3.prettyPrint());
    }
    @Test(priority = 2)
   public  void tc_03() throws FilloException {
      System.out.println("calling tc_03 method");
     // baseURI = "https://restful-booker.herokuapp.com/";
       rs = given().auth().basic(accesstoken,"").get(getData().get("tc_03"));
      System.out.println(rs.prettyPrint());
       System.out.println(rs.getBody());
   }
    @Test(priority = 1 )
    public void tc_02() throws FilloException {
        System.out.println("calling tc_02 method");
        System.out.println(getData().get("tc_02"));
     //   baseURI = "https://restful-booker.herokuapp.com/";
        RequestSpecification rq = given();
          rs =  rq.auth().basic(accesstoken,"").queryParam("checkin","2019-06-07").queryParam("checkout","2020-04-12").get(getData().get("tc_02"));
//        ResponseBody body = rs.body();
//        System.out.println(body.asString());
        JsonPath jsonPathEvaluator = rs.jsonPath();
        System.out.println(jsonPathEvaluator.get("bookingid").toString());
    }
    @Test(priority =3 )
    public void tc_04() throws FilloException {
      System.out.println("Calling tc_04 method");
      //baseURI = "https://restful-booker.herokuapp.com/booking/";
      RequestSpecification rq = RestAssured.given();
       rs = given().auth().basic(accesstoken,"").contentType(ContentType.JSON).request(Method.GET,getData().get("tc_04"));
      System.out.println(rs.prettyPrint());
      System.out.println("=====================");
        JsonPath jsonPathEvaluator = rs.jsonPath();
        System.out.println(jsonPathEvaluator.get("bookingdates"));
    }
}
