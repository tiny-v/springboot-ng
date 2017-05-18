package com.my.sa.dto;

public class LoginUser {
	
	private String userId;
	private String account;
	private String userName;
	private String token;
	private String role;
	
	public LoginUser(){}
	
	public LoginUser(String userId,String account,String userName,String token,String role){
		this.userId = userId;
		this.account = account;
		this.userName = userName;
		this.token = token;
		this.role = role;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getAccount() {
		return account;
	}
	public String getUserName() {
		return userName;
	}
	public String getToken() {
		return token;
	}
	public String getRole() {
		return role;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
