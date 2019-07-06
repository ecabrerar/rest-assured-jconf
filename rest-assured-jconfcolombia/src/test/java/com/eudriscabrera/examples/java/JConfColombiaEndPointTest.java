/**
 * 
 */
package com.eudriscabrera.examples.java;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

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


}
