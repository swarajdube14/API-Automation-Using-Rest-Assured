package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.Loggingfilters;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseServices {

	private static final String BASE_URI = "http://64.227.160.186:8080";

	private RequestSpecification requestSpecification;
	static {
	RestAssured.filters(new Loggingfilters());
	}
	public BaseServices() {
		requestSpecification = given().baseUri(BASE_URI);
	}
	protected void getAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	protected Response postRequest(Object payload, String Endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(Endpoint);
	}
	public Response getRequest(String Endpoint) {
		return requestSpecification.get(Endpoint);
	}
	public Response putRequest(Object payload, String Endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(Endpoint);
	}

}
