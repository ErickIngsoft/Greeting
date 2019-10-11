package com.eg.springboot.greeting.app.models;

import java.io.Serializable;

public class Greeting  implements Serializable {

	private static final long serialVersionUID = 920308948388739985L;
	
	private String account;
	private String type;
	private int userId;
	
	public Greeting(String account, String type, int userId) {
		this.account = account;
		this.type = type;
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
	
}
