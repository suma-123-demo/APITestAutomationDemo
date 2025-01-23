package com.api.models.request;

public class AccountCreationRequest {

	
		private String  accountType; 
		private String	  branch;
		
		public AccountCreationRequest()
		{
			
		}
		
		public AccountCreationRequest(String accountType, String branch) {
			super();
			this.accountType = accountType;
			this.branch = branch;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		@Override
		public String toString() {
			return "AccountCreationRequest [accountType=" + accountType + ", branch=" + branch + "]";
		} 
		
		
		
}
