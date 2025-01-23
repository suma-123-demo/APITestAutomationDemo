package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest3 {

	@Test(description ="Verifying the login func")
	public void loginTest()
	{
		AuthService authService = new AuthService();
		//LoginRequest loginRequest = new LoginRequest("uday1234","uday1234");
		LoginRequest loginRequest = new LoginRequest("suma","suma1234");
		Response response =	authService.login(loginRequest);
		LoginResponse loginResponse= response.as(LoginResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println("token"+ " "+loginResponse.getToken());
		System.out.println("email"+ " "+loginResponse.getEmail());
		
		Assert.assertEquals(loginResponse.getUsername(), "suma");


	}
}
