package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.DepositRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class DepositTransactionTest {

	@Test
	public void depositTransactions()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("uday1234","uday1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		DepositRequest depositRequest = new DepositRequest();
		depositRequest.setAccountNumber("5224855672");
		depositRequest.setAmount(100);
		depositRequest.setDescription("deposited");
		TransactionService transactionService = new TransactionService();
		response =transactionService.deposit(depositRequest,token);	
		System.out.println(response.asPrettyString());
	}
}
