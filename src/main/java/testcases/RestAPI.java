package testcases;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
public class RestAPI {
	
	
	@Test
	public void getDetails() {
		
		RestAssured.baseURI ="http://10.10.13.211/ProleazTestingService1/Proleaz/";
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("username");
		authScheme.setPassword("password123!");
		RestAssured.authentication = authScheme;
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"GetSites");
		String responseBody = response.getBody().asString();
		
		
		
		System.out.println(responseBody);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
		System.out.println(response.header("Content-Type"));
		System.out.println(response.header("Server"));
		//System.out.println(response.header("Content-Encoding"));
		
	
			JsonPath jsonPathEvaluvator = response.jsonPath();
			
		
			List<String> allValues = jsonPathEvaluvator.get("SiteName");
		
		for(String s : allValues) {
			
			System.out.println(s);
		}
		
	}

}
