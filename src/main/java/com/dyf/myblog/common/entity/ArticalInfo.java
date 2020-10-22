package com.dyf.myblog.common.entity;

import com.dyf.myblog.common.base.BasePO;

public class ArticalInfo extends BasePO{
	private Long id;
	private byte[] articalContext;
	private String articalTitle;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getArticalContext() {
		return articalContext;
	}
	public void setArticalContext(byte[] articalContext) {
		this.articalContext = articalContext;
	}
	public String getArticalTitle() {
		return articalTitle;
	}
	public void setArticalTitle(String articalTitle) {
		this.articalTitle = articalTitle;
	}
	
}
