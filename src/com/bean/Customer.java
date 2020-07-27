package com.bean;

import java.util.ArrayList;

public class Customer {
	private String customerSsnId;
	private String customerName;
	private int customerAge;
	private long mobileNo;
	private String email;
	private String address;
	private String city;
	private String state;
	
	private String customerStatus;
	private String message;
	
	
	
	private CustomerStatus customerStatusObj = new CustomerStatus();
	private ArrayList<Account> accountList = new ArrayList<Account>();	
	
	
	
	
	public Customer(String customerSsnId, String customerName, int customerAge, long mobileNo,
			String email, String address, String city, String state, String customerStatus, String message) {
		super();
		this.customerSsnId = customerSsnId;
		
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.customerStatus = customerStatus;
		this.message = message;
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

  
	
	
	public Customer() {
		super();
	}

	public String getCustomerSsnId() {
		return customerSsnId;
	}

	public void setCustomerSsnId(String customerSsnId) {
		this.customerSsnId = customerSsnId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}	
	
	
}