package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.base.UserProfileManagemanetServices;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;
import com.api.models.request.LoginRequest;

import groovy.util.logging.Log;
import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfile() {
		AuthServices authservice = new AuthServices();
		Response response = authservice.login(new LoginRequest("swaraj", "Swaparul@133"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		UserProfileManagemanetServices userProfile = new UserProfileManagemanetServices();
		response = userProfile.getProfile(loginResponse.getToken());
		UserProfileResponse UserProfileResponse = response.as(UserProfileResponse.class);
		String firstName = UserProfileResponse.getFirstName();
		System.out.println(firstName);
	}
}
