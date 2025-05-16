package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.base.UserProfileManagemanetServices;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileInfo;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfile() {
		
		AuthServices authServices = new AuthServices();
		Response response = authServices.login(new LoginRequest("Swaraj", "Swaparul@133"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("-----------------------------------------------------------");
		
		UserProfileManagemanetServices userManagement = new UserProfileManagemanetServices();
		response = userManagement.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getFirstName(), "Swaraj");
		
		System.out.println("-----------------------------------------------------------");
		
		UpdateProfileInfo updateProfileInfo = new UpdateProfileInfo.Builder()
				.firstName("Sanjay")
				.lastName("Khod")
				.email("sanjaykhod2@gmail.com")
				.mobileNumber("2342342341")
				.Build();
			
		response = userManagement.UpdateProfil(loginResponse.getToken(), updateProfileInfo);
		System.out.println(response.asPrettyString());
				
		
	}

}
