package com.demo.ibatis.model;
public class User implements java.io.Serializable {
	private Integer userId;
	private String userName;
	private String password;
	private String mobile;
	private String email;
	
	public User(){
		userId=0;
		userName="default";
		password="123";
		mobile="18817560811";
		email="default@dp.com";
	}
	
//省略属性的getter和setter方法
	@Override
	public String toString() {
		return "User [userId=" + userId + ",email=" + email + ", mobile=" + mobile + ", password="
				+ password + ",  userName=" + userName
				+ "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}