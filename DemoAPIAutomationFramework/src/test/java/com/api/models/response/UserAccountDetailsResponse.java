package com.api.models.response;

public class UserAccountDetailsResponse {

	private String accountNumber; 
	private String accountType; 
	private int   balance;
	private String  status; 
	private String  branch; 
	private String  createdAt; 
	private String  ownerName;
	
	public UserAccountDetailsResponse()
	{
		
	}
	
	public UserAccountDetailsResponse(String accountNumber, String accountType, int balance, String status,
			String branch, String createdAt, String ownerName) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.branch = branch;
		this.createdAt = createdAt;
		this.ownerName = ownerName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Override
	public String toString() {
		return "UserAccountDetailsResponse [accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", balance=" + balance + ", status=" + status + ", branch=" + branch + ", createdAt=" + createdAt
				+ ", ownerName=" + ownerName + "]";
	} 
	
	
}