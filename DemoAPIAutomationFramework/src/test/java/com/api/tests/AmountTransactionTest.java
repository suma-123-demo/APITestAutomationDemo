package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.LoginRequest;
import com.api.models.request.TransferRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AmountTransactionTest {

	@Test
	public void amountTransaction()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("uday1234","uday1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setFromAccount("5224855672");
		transferRequest.setToAccount("5222336320");
		transferRequest.setDescription("transfered");
		transferRequest.setAmount("100");
		
		TransactionService transactionService = new TransactionService();
		response =transactionService.transfer(transferRequest, token);
		System.out.println(response.asPrettyString());
	}
}
