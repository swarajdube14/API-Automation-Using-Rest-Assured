package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.model.response.LoginResponse;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPItest {
	
	@Test(description = "Verify if login API is working ......")
	public void login() {
		
		AuthServices authServices = new AuthServices();
		
		LoginRequest loginrequest = new LoginRequest("swaraj", "Swaparul@133");
		
		Response response = authServices.login(loginrequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "sanjaykhod2@gmail.com");
		
	}
	
}
