package com.bean;

import java.sql.Timestamp;

public class AccountStatus {

	private long accountid;
	private String accountStatus;
	private String message;
	private Timestamp lastUpdated;
	
	
	public AccountStatus(long accountid, String accountStatus, String message, Timestamp lastUpdated) {
		super();
		this.accountid = accountid;
		this.accountStatus = accountStatus;
		this.message = message;
		this.lastUpdated = lastUpdated;
	}


	public long getAccountid() {
		return accountid;
	}


	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}


	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Timestamp getLastUpdated() {
		return lastUpdated;
	}


	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	




}
