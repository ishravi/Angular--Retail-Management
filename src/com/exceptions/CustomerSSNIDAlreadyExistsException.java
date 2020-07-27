package com.exception;

public class CustomerSSNIDAlreadyExistsException extends Exception {
	
	public CustomerSSNIDAlreadyExistsException(){
	   System.out.println("Customer SSNID IS ALREADY PRESENT");
	}
}
