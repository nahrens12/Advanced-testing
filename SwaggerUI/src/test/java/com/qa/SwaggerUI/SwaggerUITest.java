package com.qa.SwaggerUI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SwaggerUITest {

	//WebDriver driver;
   
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;  
	
	 ExtentTest test;
	 ExtentReports reports;
	
	
	@Before
	public void setUp()
	{
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels?page=0&size=100");
		System.out.println(response.prettyPrint());
		//json = response.then().statusCode(200);​
		reports = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\Automated_Reports_SU.html", false);
        //test = reports.startTest("Automated");
			}
	
	@After
	public void tearDown()
	{
		// driver.quit();
	        reports.endTest(test);
	        reports.flush();
	}
	
	@Test

	public void testAddSwagger() {
	
		JSONObject	jSon = new JSONObject(); 
		request = given().contentType(ContentType.JSON);
		
	jSon.put("city", "hamburg");
	jSon.put("description", "levels");
	jSon.put("name", "selena");
	jSon.put("rating", "5");	
	
	request.body(jSon.toString());
	//test.log(LogStatus.INFO, "Inserting New Hotel");
	response =  request.post("http://localhost:8090/example/v1/hotels");
	//test.log(LogStatus.INFO, "New Hotel has been added");
	//test.log(LogStatus.PASS, "Added");
	System.out.println(response.getStatusCode()); 
	 test = reports.startTest("Add");
	  test.log(LogStatus.PASS, "P");
	}

	@Test

	public void testDeleteSwagger()
	{
		//request.body(jSon, toString());
		request = given().contentType(ContentType.JSON);
		response =  request.delete("http://localhost:8090/example/v1/hotels/5");
		 test = reports.startTest("delete");
		test.log(LogStatus.INFO, "Hotel has been deleted");
		test.log(LogStatus.PASS, "Removed");
	}
	
	@Test

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
		test = reports.startTest("update");
		test.log(LogStatus.INFO, "Hotel changed have been made");
		test.log(LogStatus.PASS, "Updated");
	}
	
	@Test
	//@Ignore
	public void testGetSwagger()
	{
		request = given().contentType(ContentType.JSON);
		response =  request.get("http://localhost:8090/example/v1/hotels/7");
		 test = reports.startTest("get");
		test.log(LogStatus.INFO, "Getting Specific Hotel");
		test.log(LogStatus.PASS, "Pass");
	}
	
}
