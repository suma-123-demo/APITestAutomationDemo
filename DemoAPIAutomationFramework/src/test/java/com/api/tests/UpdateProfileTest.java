package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test(description = "update the profile")
	public void profileUpdateTest()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("uday1234", "uday1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token =loginResponse.getToken();
		
		UserProfileManagementService  userProfileManagementService = new UserProfileManagementService();
		response =userProfileManagementService.getProfile(token);
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
		
		//userProfileManagementService.setAuthToken(token);
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("disha")
				.lastName("sh")
				.email("disha102@gmail.com")
				.mobileNumber("9535856473").build();
		 response =userProfileManagementService.updateProfile(token, profileRequest);
		 System.out.println(response.asPrettyString());
	}

}
