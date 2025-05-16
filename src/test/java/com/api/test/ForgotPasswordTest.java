package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthServices;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPassword() {
		
		AuthServices authservice = new AuthServices();
		Response response = authservice.forgotPassword("swarajdube14@gmail.com");
		
		System.out.println(response.asPrettyString());
	}

}
