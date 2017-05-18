package com.my.sa.domain;

public class User {
	
	private String userId;
	private String userName;
	private String account;
	private String password;
	private String role;
	private String createTime;
	private String updateTime;
	
	public User(){}
	
	public User(String userId,String userName,String account,String password,String role,
			    String createTime,String updateTime){
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.role = role;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
    
}
