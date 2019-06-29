package com.eudriscabrera.examples.java;
import static io.restassured.RestAssured.*;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;



public class JConfDominicanaEndPointTest {
	
	@Before
	public void setup() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = 8080;
	}

	
	@Test
	public void should_response_status_code_200() {
	 	
			given().
		    when().
		        get("jconfdominicana/sessions")
		        .then()
		        .statusCode(200)
		       ;
		 
		 
		
		    
		       
		
	}

}
