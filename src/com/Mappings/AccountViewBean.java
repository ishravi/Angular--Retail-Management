package com.mappings;

public class AccountViewBean {
	
	private int cusid;
	private long accountid;
	
	
	public AccountViewBean(int cusid, long accountid) {
		super();
		this.cusid = cusid;
		this.accountid = accountid;
	}


	public int getCusid() {
		return cusid;
	}


	public void setCusid(int cusid) {
		this.cusid = cusid;
	}


	public long getAccountid() {
		return accountid;
	}


	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}
	
	
	

}
