package com.exception;

public class CurrentAccountCountExceeded extends Exception {

	public CurrentAccountCountExceeded()
	{
		System.out.println("can not have more than one Current account");
	}
}
