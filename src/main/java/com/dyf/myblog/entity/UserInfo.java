package com.dyf.myblog.entity;


import com.dyf.myblog.common.base.BasePO;

public class UserInfo extends BasePO {
	private Long id;
	private String passWord;
	private String userName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
