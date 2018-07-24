package com.qa.OMDB;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;



public class OMDBTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request; 

	
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two()  {
	    // Write code here that turns the phrase above into concrete actions
		request = given().contentType(ContentType.JSON);
	
	}
	
	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two()  {
	    // Write code here that turns the phrase above into concrete actions
	    response = request.when().get
	  ("http://www.omdbapi.com/?i=tt3896198&apikey=f8c3e119");
	}
	
	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1)  {
	    // Write code here that turns the phrase above into concrete actions
	    json = response.then().statusCode(arg1);
	}
	
	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() {
	    // Write code here that turns the phrase above into concrete actions
		request = given().contentType(ContentType.JSON);
	}
	
	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() {
	    // Write code here that turns the phrase above into concrete actions
	   response = request.when().get
			   ("http://www.omdbapi.com/?i=tt1396484&apikey=f8c3e119");
	}
	
	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R()  {
	    // Write code here that turns the phrase above into concrete actions
	    json = response.then().statusCode(200).body("Rated", equalTo("R")); 
	}
	
	
	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	  request = given().contentType(ContentType.JSON); 
	}
	
	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	   response = request.when().get("http://www.omdbapi.com/?t=" + arg1 +"&apikey=f8c3e119");
	  // json = response.then().body("Title", equalTo("Hop"));
	   //json = response.then().body("Year", equalTo("2011"));
	   System.out.println("response: " + response.prettyPrint());
	   
	}
	
	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		json = response.then().statusCode(200).body("Rated", equalTo(arg1));
	}

	

}
