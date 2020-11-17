package com.dyf.myblog.entity;

import com.dyf.myblog.common.base.BasePO;
import com.dyf.myblog.common.jpa.annotation.Entity;
import com.dyf.myblog.common.jpa.annotation.NotColumn;
import com.dyf.myblog.common.jpa.annotation.PrimaryKey;

@Entity(tableName = "USER_INFO")
public class UserInfo extends BasePO {

	@NotColumn
	private static final long serialVersionUID = 1186104787054696549L;
	@PrimaryKey(autoIncrement = true)
	private Long id;
	private String password;
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
