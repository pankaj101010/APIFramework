package TestCases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static ApiCode.PostApi.*;
public class PostTest {

    @Test
public void createApi(){
    Response response = CreateApi();
     response.prettyPrint();
    System.out.println(response.statusCode());

}
    @Test
    public void createApiByid(){
        Response response = CreateApiById("33");
        response.prettyPrint();
        System.out.println(response.statusCode());

    }
}
