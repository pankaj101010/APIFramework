package ApiCode;
import BaseTest.BaseClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class PostApi extends BaseClass {

    public static Response CreateApi(){
        String create ="create";
        String body ="{\"name\":\"test\",\"salary\":\"testdata\",\"age\":\"44\"}";
        Response response = given().contentType(ContentType.JSON).body(body).log().all().post(""+Base_url+""+BASE_Path+""+create+"");
        return response;
    }
    public static Response CreateApiById(String id){
        String update ="update/";
        String body ="{\"name\":\"test\",\"salary\":\"testdataupdate\",\"age\":\"46\",\"id\":\"75\"}";
        Response response = given().contentType(ContentType.JSON).body(body).put(""+Base_url+""+BASE_Path+""+update+""+id+"");
        return response;
    }
}
