package com.qa.SwaggerUI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;


import cucumber.api.java.Before;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class SwaggerUITest {

	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;  
	
	
	@Before
	public void beforeSwagger()
	{
		request = given().contentType(ContentType.JSON);
		
	}
	
	@Test
	@Ignore
	public void testAddSwagger() {
	
		JSONObject	jSon = new JSONObject(); 
		request = given().contentType(ContentType.JSON);
	
	jSon.put("city", "hamburg");
	jSon.put("description", "levels");
	jSon.put("name", "selena");
	jSon.put("rating", "5");	
	
	request.body(jSon.toString());
	
	response =  request.post("http://localhost:8090/example/v1/hotels");
	//System.out.println(response.getStatusCode()); 
	}

	@Test
	@Ignore
	public void testDeleteSwagger()
	{
		//request.body(jSon, toString());
		request = given().contentType(ContentType.JSON);
		
		response =  request.delete("http://localhost:8090/example/v1/hotels/5");	
	}
	
	@Test
	@Ignore
	public void testUpdateSwagger()
	
	{
		JSONObject	jSon = new JSONObject();
		
		request = given().contentType(ContentType.JSON);
		
		jSon.put("city", "hamburg");
		jSon.put("description", "more levels");
		jSon.put("id", "7");
		jSon.put("name", "arwa");
		jSon.put("rating", "1");
		
		request.body(jSon.toString());
		
		response =  request.put("http://localhost:8090/example/v1/hotels/7");
		
	}
	
	@Test
	public void testGetSwagger()
	{
		request = given().contentType(ContentType.JSON);
		response =  request.get("http://localhost:8090/example/v1/hotels/7");
		
	}
	
	
	
	


	

}
