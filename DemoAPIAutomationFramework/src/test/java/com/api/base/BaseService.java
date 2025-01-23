package com.api.base;

import com.api.filters.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // wrapper for Rest Assured
//base URI
// creating the request
//handling the response
	
	private static  final String BASE_URL ="http://64.227.160.186:8080";
	
	RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		requestSpecification = RestAssured.given().baseUri(BASE_URL);
	}
	
	public void setAuthToken(String token)
	{
		//requestSpecification.header("Authorization","Bearer " + token);
		requestSpecification.auth().oauth2(token);
	}
	
	public Response postRequest(Object payload, String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	public Response getRequest(String endpoint)
	{
		return requestSpecification.get(endpoint);
	}
	
	/*public Response getRequest(String endpoint,Object payload)
	{
		return requestSpecification.get(endpoint);
	}*/
	
	public Response putRequest(Object payload,String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	public Response patchRequest(Object payload,String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).patch(endpoint);
	}
	
	public Response getRequestwithpathparam(String endpoint,  String key , String value)
	{
		//return requestSpecification.contentType(ContentType.JSON).queryParam(key, value)
		//.queryParam(key, value)
	return	requestSpecification.contentType(ContentType.JSON).pathParam(key, value)
			.get(endpoint);
	}
	
	public Response getRequestwithqueryparam(String endpoint,  String key , String value)
	{
		return requestSpecification.contentType(ContentType.JSON).queryParam(key, value).get(endpoint);
	}
	
}
