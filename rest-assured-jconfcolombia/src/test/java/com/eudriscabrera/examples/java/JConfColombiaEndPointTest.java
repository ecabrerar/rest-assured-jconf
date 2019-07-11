/**
 * 
 */
package com.eudriscabrera.examples.java;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;


import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * @author ecabrerar
 *
 */
public class JConfColombiaEndPointTest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void should_response_status_code_200() {

		given()
		.when()
		.get("jconfcolombia/sessions")
		.then()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.body("size()", equalTo(27));

	}

	@Test
	public void should_response_status_code_200_with_query_param() {

		given()
		.param("time", "13:00")
		.when()
		.get("jconfcolombia/sessions")
		.then()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.body("size()",  equalTo(4));

	}
	
	@Test
	public void should_response_status_code_200_with_path_param() {

	Session[] session =	given()
		.pathParam("sessionId", "101")
		.when().get("jconfcolombia/sessions/{sessionId}")
		.then()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.extract()
		.as(Session[].class);
	
		assertTrue(session.length==1);

	}
	
	@Test
	public void should_response_status_code_200_with_path_param_2() {

	given()
		.pathParam("sessionId", "101")
		.when().get("jconfcolombia/sessions/{sessionId}")
		.then()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.body("session.id",  equalTo(101))
		.body("[0].title",  equalTo("Modern Identity Management (en la Era de Serverless y Microservices)"));
	
		

	}

}
