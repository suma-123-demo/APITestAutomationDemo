package com.api.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "verify login")
	public void loginTest()
	{
		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification req =RestAssured.given();
		RequestSpecification actualReq=req.header("Content-Type", "application/json");
		actualReq.body("{\r\n"
				+ "  \"username\": \"uday1234\",\r\n"
				+ "  \"password\": \"uday1234\"\r\n"
				+ "}'");
		Response res=actualReq.when().post("/api/auth/login");
		System.out.println(res.asPrettyString());
		
	}
}
