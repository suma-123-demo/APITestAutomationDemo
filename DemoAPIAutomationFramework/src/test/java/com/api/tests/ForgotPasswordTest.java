package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="verify account creation")
	public void passwordforgotTest()
	{
		AuthService authService = new AuthService();
		Response response =authService.forgotpassword("disha102@yahoo.com");
		System.out.println(response.asPrettyString());
	}

}
