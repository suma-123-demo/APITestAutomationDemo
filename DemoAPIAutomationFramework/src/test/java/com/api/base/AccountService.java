package com.api.base;

import io.restassured.response.Response;

public class AccountService extends BaseService{

	private final String BASE_PATH="/api/accounts";
	
	public Response createAccounts(String token,Object payload)
	{
		setAuthToken(token);
	    return	postRequest(payload,BASE_PATH +"" );	
	}
	
	public  Response getUserAccountDetails(String token,String key,String value )
	{
		setAuthToken(token);
		return getRequestwithpathparam(BASE_PATH + "/"+ "{" + key +"}", key, value);
	}
	
	public Response getAllAccountDetailsofUser(String token)
	{
		setAuthToken(token);
		return getRequest(BASE_PATH + "/user");
	}
}
