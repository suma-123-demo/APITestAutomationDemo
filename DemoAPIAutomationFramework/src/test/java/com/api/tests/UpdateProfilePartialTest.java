package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfilePartialTest {

	@Test(description="Updating the profile partially")
	public void updatepartialProfile()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("suma","suma1234"));
		LoginResponse loginresponse=response.as(LoginResponse.class);
		String token=loginresponse.getToken();
		
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.setFirstName("abc");
		updateRequest.setLastName("xyz");
		updateRequest.setEmail("sumarangaswamy987@gmail.com");
		updateRequest.setMobileNumber("9535856478");
		updateRequest.setAddress("mysore");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response =userProfileManagementService.updatepartialProfile(token, updateRequest);
		UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);
		
		System.out.println(response.asPrettyString());
		
		Assert.assertNotEquals(userProfileResponse.getFirstName(), "disha");
		
	}
}
