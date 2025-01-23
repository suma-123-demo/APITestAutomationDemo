package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AccountService;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserAccountDetails {

	
	@Test(description = "User account details")
	public void userAccountDetailsTest()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("suma","suma1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		/*RestAssured.baseURI="http://64.227.160.186:8080";
		given().log().all().header("Authorization","Bearer " + token).pathParam("accountNumber", "5224855672")
		.when().get("/api/accounts/{accountNumber}").then().log().all();*/
		
		//.queryParam("accountNumber", "5224855672")
		//.pathParam("accountNumber", "5224855672")
		
		AccountService accountService = new AccountService();
		response=accountService.getUserAccountDetails(token, "accountNumber","5213730251");
		
		System.out.println(response.asPrettyString());
	}
}
