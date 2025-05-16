package com.api.base;

import com.api.models.request.UpdateProfileInfo;

import io.restassured.response.Response;

public class UserProfileManagemanetServices extends BaseServices{

	
	private static final String BASE_PATH = "/api/users/";
	
	public Response getProfile(String token) {
		getAuthToken(token);
		return getRequest(BASE_PATH + "profile");
		
	}
	
	public Response UpdateProfil(String token, UpdateProfileInfo payload) {
		getAuthToken(token);
		
		return putRequest(payload, BASE_PATH + "profile");
		
	}
}
