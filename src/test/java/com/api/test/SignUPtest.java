package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class SignUPtest {
	
	@Test
	public void signUP() {
		
		SignUpRequest signUPrequest = new SignUpRequest.builder().username("Sanjot")
		.email("SanjotSingh12@gmail.com")
		.firstName("Sanjot")
		.lastName("Khod")
		.password("Sanjot123")
		.mobileNumber("8989898999")
		.Build();
		
		AuthServices authServices = new AuthServices();
		
		Response response = authServices.signUp(signUPrequest);
		
		System.out.println(response.asPrettyString());
		
	//	Assert.assertEquals(response.asPrettyString(), );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		SignUpRequest signUp = new SignUpRequest();
//		
//		signUp.setFirstName("Sanjay");
//		signUp.setUsername("Sanjay123");
//		signUp.setPassword("Sanjay12");
//		signUp.setEmail("sanjayKhod12@gmail.com");
//		signUp.setLastName("Khod");
//		signUp.setMobileNumber("9860684024");
//		
//		Response response = authServices.signUp(signUp);
//		
//		
//		
//		if(response.asPrettyString()=="Username is already taken!") {
//			System.out.println("User is already registered");
//		}
//		else {
//			System.out.println(response.asPrettyString());
//		}
	}
	
}
