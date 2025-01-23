package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Update the profile")
	public void profileUpdateTest()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("suma","suma1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token =loginResponse.getToken();


		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("disha")
				.lastName("sh")
				.email("sumarangaswamy987@gmail.com")
				.mobileNumber("9535856473").build();

		UserProfileManagementService  userProfileManagementService = new UserProfileManagementService();
		response =userProfileManagementService.updateProfile(token, profileRequest);
		UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);

		Assert.assertEquals(userProfileResponse.getFirstName(), "disha");
		System.out.println(response.asPrettyString());
	}

}
