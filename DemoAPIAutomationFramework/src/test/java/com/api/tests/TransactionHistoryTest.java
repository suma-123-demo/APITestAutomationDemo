package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TransactionHistoryTest {

	@Test
	public void getTransactionsHistory()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("uday1234","uday1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		TransactionService transactionService = new TransactionService();
		Response response1=transactionService.history(token, "accountNumber", "5224855672");
		//response1.toString();
		System.out.println(response1.asPrettyString());
		JsonPath js = response1.jsonPath();
		//JsonPath js = new JsonPath(response1);
		
		//long balanceAfterTransaction=js.getLong("balanceAfterTransaction");
		Object balanceAfterTransaction= js.getJsonObject("balanceAfterTransaction");
		//Integer id=js.getInt("content.id");
		String id =js.getString("content.balanceAfterTransaction");
		System.out.println(id);
		//System.out.println(balanceAfterTransaction);
		//Assert.assertEquals(id, "[100.0]");
	}
}
