package com.api.base;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{

	public static String BASE_PATH="/api/users/";
	
	public Response getProfile(String token)
	{
		setAuthToken(token);
	 return	getRequest(BASE_PATH + "profile");
	}
	
	public Response updateProfile(String token, Object payload)
	{
		setAuthToken(token);
		return putRequest(payload, BASE_PATH + "profile");
	}
	
	public Response updatepartialProfile(String token,Object payload)
	{
		setAuthToken(token);
		return patchRequest(payload,BASE_PATH + "profile" );
	}
}
