package testcases;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.testng.annotations.Test;
public class PostMethod {
	
	@Test
	public void postMethod() {
		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "Virender"); // Cast
		 requestParams.put("LastName", "Singh");
		 requestParams.put("UserName", "sdimpleuser2dd2011");
		 requestParams.put("Password", "password1");
		 
		 requestParams.put("Email",  "sample2ee26d9@gmail.com");
		 
		
		 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json");
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/register");
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, "201");
		 String successCode = response.jsonPath().get("SuccessCode");
		 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		
				
				
		
	}

}
