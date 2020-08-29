package TestCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Reqres {
	@Test(enabled=true, description="GET")
	public  void getSingleUser() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=";							//Initialize URI
		RequestSpecification httpRequest=RestAssured.given();							//Initialize HTTP Request
		Response response=httpRequest.request(Method.GET, "2");   				//Send Request and GET Response(2 = path parameter)
		
		
			int statusCode = response.getStatusCode();
			System.out.println("Status  Code : " + statusCode);
			Assert.assertEquals(statusCode, 200);
		

	
			String statusLine = response.getStatusLine();
			System.out.println("Status  Line : " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
			String responseBody = response.getBody().asString();
			System.out.println("Response Body : " + responseBody);
			Assert.assertTrue(responseBody != null);
	

		
			String contentType = response.contentType();
			System.out.println("Content Type: " + contentType);
			Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
	
			String serverType = response.header("Server");
			System.out.println("Sever Type: " + serverType);
			Assert.assertEquals(serverType, "cloudflare");
		     System.out.println("time"+response.getTime());
		     System.out.println("Length"+response.header("Content-Length"));
		
			String contentEncoding = response.header("Content-Encoding");
			System.out.println("Content Encoding : " + contentEncoding);
			Assert.assertEquals(contentEncoding, "gzip");
		

		
			long contentLength = Integer.parseInt(response.header("Content-Length"));
			System.out.println("Content Length : " + contentLength);
			if (contentLength < 100) {
				System.out.println("Content Length is less than 100");
			}
			Assert.assertTrue(contentLength > 100);
		

		
			long responseTime = response.getTime();
			System.out.println("Response Time : " + responseTime);
			if (responseTime > 200) {
				System.out.println("Response time is greater than 2000  ms ");
			}
			Assert.assertTrue(responseTime < 200);
		
		
			String cookies = response.getCookie("dc35e1258e0e572abc0cb45bbfc6f0cec1596431645");
			System.out.println("Cookies : " + cookies);
			Assert.assertEquals(cookies, "dc35e1258e0e572abc0cb45bbfc6f0cec1596431645");
		}

		

		
	
	//@Test(enabled=true, description="POST")
	public  void createUser() {
		RestAssured.baseURI="https://reqres.in/api"; 												//Initialize URI
		RequestSpecification httpRequest=RestAssured.given();								//Initialize HTTP Request
		
		
		//Request Payload
		JSONObject requestParam=new JSONObject();												//To provide data in Json Format
		requestParam.put("name", "ABC");
		requestParam.put("job", "QA");
		httpRequest.header("Content Type","application/json; charset=utf-8");	//specifying content Type is json
		httpRequest.body(requestParam.toString());  										//attach data to request
		
		
		//Response
		Response response=httpRequest.post("/users"); 											//Send Request and GET Response(2 = path parameter)
		
		
		//Status Validation
		System.out.println("Status Code: "+response.getStatusCode());
		System.out.println("Status Line: "+response.getStatusLine());
		System.out.println("Content Type: "+response.getContentType());
		
		
		//Response Body Validation
		System.out.println("Response Body:  "+response.getBody().asString());
		System.out.println("Response Body Specific Message(ID:): "+response.jsonPath().getString("id"));
		
		
		//Response Header Validation
	//	System.out.println("Response Header : "+response.getHeaders());
		System.out.println("Response Header (Sever) : "+response.getHeader("Server"));
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
