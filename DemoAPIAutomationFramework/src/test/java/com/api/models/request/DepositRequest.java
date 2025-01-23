package com.api.models.request;

public class DepositRequest {

	private String accountNumber; 
	private int  amount; 
	private String  description;
	
	public DepositRequest()
	{
	
	}
	 
	public DepositRequest(String accountNumber, int amount, String description) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.description = description;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "DepositRequest [accountNumber=" + accountNumber + ", amount=" + amount + ", description=" + description
				+ "]";
	}
	 
	 
}
