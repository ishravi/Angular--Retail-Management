package com.bean;

public class Account {
	private long accountId;
	private String accountType;
	private double accountBalance;
	private int cusid;
	
	private AccountStatus accountStatusObj ;

	public Account() {
		super();
	}
	public Account(long accountId, String accountType, double accountBalance,int cusid) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public AccountStatus getAccountStatusObj() {
		return accountStatusObj;
	}
	public void setAccountStatusObj(AccountStatus accountStatusObj) {
		this.accountStatusObj = accountStatusObj;
	}
	
	
}
