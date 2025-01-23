package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequest {

	@Test(description = "Get the user profile request")
	public void getProfileInfoTest()
	{
		AuthService authService = new AuthService();
		Response response=	authService.login(new LoginRequest("suma","suma1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
	    System.out.println(token);
		
		UserProfileManagementService userProfileManagement = new UserProfileManagementService();
		response =userProfileManagement.getProfile(token);
		UserProfileResponse userProfileResponse =	response.as(UserProfileResponse.class);
		System.out.println( userProfileResponse.getEmail());
		Assert.assertEquals(userProfileResponse.getUsername(), "suma");
		
	}
}
