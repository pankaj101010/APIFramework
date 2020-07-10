package TestCases;

import static ApiCode.GetApi.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTest {
   @Test
     public void GetEmp(){
       Response response = GetApiCode();
       response.prettyPrint();
       System.out.println(response.getStatusCode());
     }
   @Test
  public void GetEmpByid(){
    Response response = GetApiCodeByID("50");
    response.prettyPrint();
    System.out.println(response.getStatusCode());
  }
}
