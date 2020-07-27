package com.bean;

import java.sql.Timestamp;

public class UserStore {
	private String loginId;
	private String password;
	private Timestamp loggedAt;
	
	public UserStore() {
		super();
	}
	
	public UserStore(String loginId, String password, Timestamp loggedAt) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.loggedAt = loggedAt;
	}
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Timestamp getLoggedAt() {
		return loggedAt;
	}
	public void setLoggedAt(Timestamp loggedAt) {
		this.loggedAt = loggedAt;
	}
	
	
}
