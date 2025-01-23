package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.LoginRequest;
import com.api.models.request.TransferRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class InitiateTransactionTest {
  
	@Test
	public void initiateTransction()
	{
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequest("uday1234","uday1234"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		
		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setFromAccount("5222336320");
		transferRequest.setToAccount("4367731262");
		transferRequest.setDescription("transfered");
		transferRequest.setAmount("10");
		
		TransactionService transactionService = new TransactionService();
		response =transactionService.initiate(transferRequest, token);
		//response =transactionService.transfer(transferRequest, token);
		System.out.println(response.asPrettyString());
		
	}
}
