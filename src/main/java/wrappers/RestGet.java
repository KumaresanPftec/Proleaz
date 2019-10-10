package wrappers;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestGet {
	
	@Test
	public void getDetails() {
		
		RestAssured.baseURI ="http://10.10.13.211/ProleazTestingService1/Proleaz/";
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("username");
		authScheme.setPassword("password123!");
		RestAssured.authentication = authScheme;
		
		Response response = RestAssured.given()
				.when().queryParam("leaseTypeId", "1").queryParam("transactionType", "2")
				.queryParam("fromDate", "10-Oct-2018").queryParam("toDate", "10-Oct-2019")
				.get("GetInvoice");
		
		
		
		
		
		
		
		String responseBody = response.getBody().asString();
		JsonPath jsonPathEvaluvator = response.jsonPath();
		String mallCompanyName = jsonPathEvaluvator.getString("MallBillingCompany");
		System.out.println(mallCompanyName);
		Assert.assertTrue(mallCompanyName.equalsIgnoreCase("[City Center Pvt Ltd]"));
	
	
		
		
		/*System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
		
		System.out.println("Header Content Type " +response.header("Content-Type"));
		System.out.println("Header Server " +response.header("Server"));
		System.out.println("Header Content-Encoding "+response.header("Content-Encoding"));
		
	
			JsonPath jsonPathEvaluvator = response.jsonPath();
			
		
			List<String> allValues = jsonPathEvaluvator.get("SiteName");
		
		for(String s : allValues) {
			
			System.out.println(s);
			
			}*/
		
		
		
	}

}
