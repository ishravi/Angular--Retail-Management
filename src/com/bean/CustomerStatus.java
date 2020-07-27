package com.bean;

import java.sql.Timestamp;

public class CustomerStatus {
	private String customerStatus;
	private String message;
	private Timestamp lastUpdated;
	
	public CustomerStatus() {
		super();
	}

	public CustomerStatus(String customerStatus, String message, Timestamp lastUpdated) {
		super();
		this.customerStatus = customerStatus;
		this.message = message;
		this.lastUpdated = lastUpdated;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
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
