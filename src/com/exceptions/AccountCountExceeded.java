package com.exception;

import org.omg.Messaging.SyncScopeHelper;

public class AccountCountExceeded extends Exception {
	public AccountCountExceeded()
	{
		System.out.println("Customer can not have more than 2 Account");
	}
}
