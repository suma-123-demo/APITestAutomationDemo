package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AccountService;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserAccountDetailsResponse;

import io.restassured.response.Response;

public class AllAccountDetailsofUser {
	
	@Test(description= "All account details of user")
	public void getAllAcountDetailsofUser()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("suma","suma1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		UserAccountDetailsResponse userAccountDetailsResponse = new UserAccountDetailsResponse();
		AccountService accountService = new AccountService();
		response =accountService.getAllAccountDetailsofUser(token);
		
		Assert.assertEquals(userAccountDetailsResponse.getAccountNumber(), "5213730251");;
	}

}
