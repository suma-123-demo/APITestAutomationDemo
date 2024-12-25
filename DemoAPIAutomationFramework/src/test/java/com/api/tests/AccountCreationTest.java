package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description="verify account creation")
	public void createAccountTest()
	{
		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("gkhh1234")
		.email("disha102@yahoo.com")
		.firstName("Disha")
		.lastName("sigh")
		.mobileNumber("9845236770")
		.password("disha123").build();
		
		AuthService authService = new AuthService();
		Response response =authService.signup(signUpRequest);
		System.out.println(response.asPrettyString());
		//Assert.assertEquals(response.asPrettyString(),"User registered successfully!" );
	}
}
