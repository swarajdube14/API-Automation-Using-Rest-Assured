package com.api.base;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AuthServices extends BaseServices {
		
private static final String BASE_PATH = "/api/auth/";

	public Response login(Object payload) {
	
	return postRequest(payload, BASE_PATH + "login");
}

	public Response signUp(SignUpRequest payload) {
	
	return postRequest(payload, BASE_PATH + "signup");
}

	public Response forgotPassword(String Emailaddress) {
		
		HashMap<String, String> payload = new HashMap<String, String>();
		
		payload.put("email", Emailaddress);
		
		return postRequest(payload, BASE_PATH + "forgot-password");
	}


}
