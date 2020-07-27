package com.exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException()
	{
		System.out.println("Customer Not Found Exception");
	}
}
