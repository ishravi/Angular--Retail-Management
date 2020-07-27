package com.interfaces;

import com.exception.LoginCredentialsNotFoundException;

public interface DaoLoginInterface {
	public abstract boolean loginCheck(String loginid,String password) throws LoginCredentialsNotFoundException;
}
