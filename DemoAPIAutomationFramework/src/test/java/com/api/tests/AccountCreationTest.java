package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AccountService;
import com.api.base.AuthService;
import com.api.models.request.AccountCreationRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.AccountCreationResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AccountCreationTest {


	@Test(description="Verify account creation")
	public void createAccountTest()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("suma","suma1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
		accountCreationRequest.setAccountType("SAVINGS");
		accountCreationRequest.setBranch("main");
		
		
		AccountService accountService = new AccountService();
		response=accountService.createAccounts(token, accountCreationRequest);
		AccountCreationResponse accresponse = new AccountCreationResponse();
		accresponse=response.as(AccountCreationResponse.class);
		Assert.assertEquals("main", accresponse.getBranch());
		
	}
}
