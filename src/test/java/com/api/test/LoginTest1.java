package com.api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest1 {
	
	@Test
	public void login() {
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		
		Response response = given()
		
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"username\": \"swaraj\",\r\n"
				+ "  \"password\": \"Swaparul@133\"\r\n"
				+ "}")
		
		.when()
		.post("/api/auth/login")
		.then()
		
		.extract().response();
		
		String res = response.asPrettyString();
		
		System.out.println(res);
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
}
