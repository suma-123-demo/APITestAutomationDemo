package com.api.base;

import io.restassured.response.Response;

public class TransactionService extends BaseService{

	private final String BASE_PATH="/api/transactions/";
	
	public Response deposit(Object payload,String token)
	{
		setAuthToken(token);
		return postRequest(payload,BASE_PATH + "deposit");			
	}
	
	public Response history(String token, String key,String value)
	{
		setAuthToken(token);
	  return getRequestwithqueryparam(BASE_PATH +"history", key, value);
		
	}
	
	public Response transfer(Object payload, String token) 
	{
		setAuthToken(token);
		return postRequest(payload,BASE_PATH + "transfer");
	}
	
	public void completetransaction()
	{
		
	}
	
	public Response initiate(Object payload, String token)
	{
		setAuthToken(token);
		return postRequest(payload,BASE_PATH + "transfer/initiate");
	}
	
	public Response withdraw(Object payload, String token)
	{
		setAuthToken(token);
		return postRequest(payload,BASE_PATH + "withdraw");
	}
}
