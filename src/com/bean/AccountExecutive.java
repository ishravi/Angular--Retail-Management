package com.bean;

public class AccountExecutive {
		private String loginId;
		private String password;
		private long mobileNo;
		private String secretAnswer;
		
		public AccountExecutive() {
			super();
		}
		
		public AccountExecutive(String loginId, String password) {
			super();
			this.loginId = loginId;
			this.password = password;
		}

		public AccountExecutive(String loginId, String password, long mobileNo, String secretAnswer) {
			super();
			this.loginId = loginId;
			this.password = password;
			this.mobileNo = mobileNo;
			this.secretAnswer = secretAnswer;
		}
		
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getSecretAnswer() {
			return secretAnswer;
		}
		public void setSecretAnswer(String secretAnswer) {
			this.secretAnswer = secretAnswer;
		}
		
		
}
