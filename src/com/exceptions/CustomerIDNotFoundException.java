package com.exception;

public class CustomerIDNotFoundException extends Exception {
	public CustomerIDNotFoundException()
	{
		System.out.println("Customer ID Not Found Exception");
	}
}
