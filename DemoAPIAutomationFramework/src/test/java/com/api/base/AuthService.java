package com.api.base;

import java.util.HashMap;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
 public  static final String BASE_PATH = "/api/auth/";

  public Response login(Object payload)
  {
	return  postRequest(payload ,BASE_PATH + "login");
  }
 
  public Response signup(Object payload)
  {
	return  postRequest(payload ,BASE_PATH + "signup");
  }
  
  public Response forgotpassword(String emailaddress)
  {
	  HashMap<String,String> payload = new HashMap<>();
	  payload.put("email", emailaddress);
	  return  postRequest(payload ,BASE_PATH + "forgot-password");
  }
  
  
}
