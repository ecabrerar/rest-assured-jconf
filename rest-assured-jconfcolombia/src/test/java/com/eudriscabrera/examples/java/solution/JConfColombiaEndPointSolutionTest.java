package com.eudriscabrera.examples.java.solution;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JConfColombiaEndPointSolutionTest {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	@Test
	public void should_response_status_code_200() {

		given().when().get("jconfcolombia/sessions").then().statusCode(200).and().contentType(ContentType.JSON);

	}

	@Test
	public void should_return_status_code_200_and_session_with_id_101() {
		String contenido = given().pathParam("sessionId", "101").when().get("jconfcolombia/sessions/{sessionId}")
				.then()				
				.statusCode(200).extract().asString();

		Assert.assertTrue(!contenido.isEmpty());
	}

	@Test
	public void should_return_status_code_200_and_session_with_title() {

		given().pathParam("sessionId", "101").when().get("jconfcolombia/sessions/{sessionId}").then()
				.contentType(ContentType.JSON)
				.body("[0].id", equalTo(101))
				.body("[0].title", equalTo("Modern Identity Management (en la Era de Serverless y Microservices)"));

	}
	
	@Test
	public void should_response_status_code_200_and_session_by_time() {

		given()
		.param("time", "13:00")
		.when().get("jconfcolombia/sessions").then().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and()
		.assertThat()
		.body("size()", equalTo(4));

	}
	
	

}
