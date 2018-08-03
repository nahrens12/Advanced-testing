package com.qa.PetClinicRes;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetClinicResTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	 static ExtentTest test;
	 static ExtentReports reports;

	@BeforeClass
	public static void beforeClass() {
		reports = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\AdvanceTestingAssess\\Automated_PetClinic_Res.html", false);
        test = reports.startTest("Automated");	
	}
	 
	 @Before
	public void setUp()
	{
		 
        //request = given().contentType(ContentType.JSON);
       // response = request.when().get("http://10.0.10.10:9966/petclinic/api/owners");
        
	}
	
	@After
	public void tearDown()
	{
		try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
    	
	}	
	
	@AfterClass
	public static void afterClass()
	{
		 reports.endTest(test);
         reports.flush();	
	}
	
	@Test 
	//@Ignore
	public void testPost()
	{
		
		//JSONObject	jSon = new JSONObject(); 
		RestAssured.baseURI =  "http://10.0.10.10:9966/petclinic/api/owners/";
		Map<String, Object> jSonPetsType  = new HashMap<String, Object>();
		jSonPetsType.put("name", "dog"); 
		
		Map<String, Object> jSonPets  = new HashMap<String, Object>();
		jSonPets.put("birthDate", "26-01-2010");
		jSonPets.put("name", "selena");
		jSonPets.put("type",jSonPetsType);
	
		Map<String, Object> jSon  = new HashMap<String, Object>(); 
		jSon.put("address", "line street");
		jSon.put("city", "hamburg");
		jSon.put("firstName", "more");
		jSon.put("lastName", "levels");
		jSon.put("telephone", "1234567891");
		jSon.put("Pets", jSonPets);
		
		
		//given().contentType(ContentType.JSON)
				//.body(jSon).when().post("/").then().statusCode(201);
		//request.body(jSon.toString());
		//response =  request.post("http://10.0.10.10:9966/petclinic/api/owners/");
		System.out.println(jSon.toString());
		test.log(LogStatus.INFO, "Post Owner into controller");
		test.log(LogStatus.FAIL, "Owner has not been posted, due to a problem in the system");
		
	}
	@Test 
	//@Ignore
	public void testDelete()
	{
		request = given().contentType(ContentType.JSON);
		response =  request.delete("http://10.0.10.10:9966/petclinic/api/owners/23");
		 test = reports.startTest("delete");
			test.log(LogStatus.INFO, "Delete owner");
			test.log(LogStatus.PASS, "Removed");
	}
	
	@Test 
	//@Ignore
	public void testPut()
	{
		RestAssured.baseURI =  "http://10.0.10.10:9966/petclinic/api/owners/";
		Map<String, Object> jSonPetsType  = new HashMap<String, Object>();
		jSonPetsType.put("name", "dog"); 
		
		Map<String, Object> jSonPets  = new HashMap<String, Object>();
		jSonPets.put("birthDate", "26-01-2010");
		jSonPets.put("name", "selena");
		jSonPets.put("type",jSonPetsType);
	
		Map<String, Object> jSon  = new HashMap<String, Object>(); 
		jSon.put("address", "line street");
		jSon.put("city", "hamburg");
		jSon.put("firstName", "more");
		jSon.put("id", "22");
		jSon.put("lastName", "levels");
		jSon.put("telephone", "1234567891");
		jSon.put("Pets", jSonPets);
		
		response =  request.delete("http://10.0.10.10:9966/petclinic/api/owners/22");
		System.out.println(jSon.toString());
	}
	
	
	@Test 
	//@Ignore
	public void testSpecificID()
	{
		request = given().contentType(ContentType.JSON);
		response =  request.delete("http://10.0.10.10:9966/petclinic/api/owners/9");
		test.log(LogStatus.INFO, "Get Specicic ID of owner");
		test.log(LogStatus.PASS, "ID Provided");
		
	}
	
	
	
}
