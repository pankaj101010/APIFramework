package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class KpLogin {
@Test(enabled = false)
    public void test(){
        RestAssured.baseURI = "https://uat.kpcaseconnect.org/";

       RequestSpecification rq = given();
        Response tr = rq.urlEncodingEnabled(true).formParam("NHJZB7D8KD","testproduction@40yopmail.com")
                 .formParam("Password","Admin@12345").formParam("Departmentstring","Multi-State Account Management_3a286789-699e-4cfe-99aa-f87863f663d6")
                 .post(); //Multi-State Account Management_3a286789-699e-4cfe-99aa-f87863f663d6
    //Membership Admin_c92c907e-2274-46b8-a07e-17f87ff45f02
          System.out.println(tr.header("Content-Type"));
    System.out.println(tr.header("Content-Length"));
    System.out.println(tr.header("Server"));
            System.out.println(tr.getHeaders());
          System.out.println(tr.getBody().asString());
        int status = tr.getStatusCode();
        System.out.println(status);
    System.out.println(tr.getTimeIn(TimeUnit.SECONDS));
    System.out.println(tr.getTime());
    }
@Test(enabled = false)
    public void test2(){
    //http://qa.kpcaseconnect.com/Casetimeline/GetRegions?_=1594192553015
    //http://qa.kpcaseconnect.com/Casetimeline/EditCaseTimeline?CaseTimelineID=58186
   // RestAssured.baseURI = "http://qa.kpcaseconnect.com/Home/GetDashboardTiles?_=1594186235119";
    RestAssured.baseURI = "http://qa.kpcaseconnect.com/Home/PopulateDepartmentDropdown";
    RequestSpecification rq = given();
       Response rs = rq.get();
    // Response rs =  rq.queryParam("CaseTimelineID","58186").get("EditCaseTimeline");
     System.out.println(rs.prettyPrint());
     System.out.println(rs.getStatusCode());
     //System.out.println(rs.jsonPath().getMap("CurrentTiles").values());
//      JsonPath path = rs.jsonPath(JsonPathConfig.jsonPathConfig());
//      System.out.println(path.getList("CurrentTiles.TileName"));
//      List<String> ps = path.getList("CurrentTiles.TileName");
//    for (String tiles: ps) {
//        System.out.println(tiles);
//    }
    }
   @Test(enabled = true)
    public void posttask(){
    RestAssured.baseURI ="http://qa.kpcaseconnect.com/Casetimeline";
    RequestSpecification rq = given();
       JSONObject obj = new JSONObject();
       obj.put("caseTimeLineId","58186");
       obj.put("ccdDate","08/08/2020");
       obj.put("milestoneId","6");
       obj.put("taskId","259308");
       obj.put("id","1");
       obj.put("expendAll","false");
       rq.header("Content-Type", "application/x-www-form-urlencoded");
       rq.body(obj.toString());
       //Response re = given().get();
       Response rs =  rq.post("/SaveCcdDate");
       System.out.println(rs.getStatusCode());
       System.out.println();


   }




}
