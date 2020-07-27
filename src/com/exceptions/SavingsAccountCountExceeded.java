package com.exception;

public class SavingsAccountCountExceeded extends Exception {

	public SavingsAccountCountExceeded()
	{
		System.out.println("can not have more than one savings account");
	}
}
