package com.api.models.request;

public class TransferRequest {

	private String fromAccount; 
	private String  toAccount; 
	//private int   amount; 
	private String amount;
	 private String description; 
	 
	 public TransferRequest()
	 {
		 
	 }

	public TransferRequest(String fromAccount, String toAccount, String amount, String description) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.description = description;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
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
		return "TransferRequest [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
				+ ", description=" + description + "]";
	}
	 
}
