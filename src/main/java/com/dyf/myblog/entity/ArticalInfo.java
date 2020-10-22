package com.dyf.myblog.entity;

import com.dyf.myblog.common.base.BasePO;

public class ArticalInfo extends BasePO{
	private Long id;
	private byte[] articalContent;
	private String articalTitle;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getArticalContent() {
		return articalContent;
	}
	public void setArticalContent(byte[] articalContent) {
		this.articalContent = articalContent;
	}
	public String getArticalTitle() {
		return articalTitle;
	}
	public void setArticalTitle(String articalTitle) {
		this.articalTitle = articalTitle;
	}
	
	
}
