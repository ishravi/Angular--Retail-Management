package com.mappings;

public class SearchCustomer {
	
	private String ssnId;
	private int custId;
	
	
	public SearchCustomer(String ssnId, int custId) {
		super();
		this.ssnId = ssnId;
		this.custId = custId;
	}
	public String getSsnId() {
		return ssnId;
	}
	public void setSsnId(String ssnId) {
		this.ssnId = ssnId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
}
