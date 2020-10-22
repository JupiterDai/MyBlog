package com.dyf.myblog.common.entity;


import com.dyf.myblog.common.base.BasePO;

public class UserInfo extends BasePO {
	private Long id;
	private String passWord;
	private String userName;
	
	public Long getID() {
		return id;
	} 
	public void setID() {
		this.id=id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassword() {
		this.passWord=passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void  setUserName() {
		this.userName=userName;
	}
}
