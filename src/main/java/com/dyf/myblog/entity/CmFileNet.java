package com.dyf.myblog.entity;

import com.dyf.myblog.common.base.BasePO;

public class CmFileNet extends BasePO{
	private Long id;
	private String fileName;
	private String fileType;
	private int size;
	private String status;
	private String storageType;
	private String mimeType;
	private String fileUuid;
	private String path;
	private String sha512;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getFileUuid() {
		return fileUuid;
	}
	public void setFileUuid(String fileUuid) {
		this.fileUuid = fileUuid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSha512() {
		return sha512;
	}
	public void setSha512(String sha512) {
		this.sha512 = sha512;
	}
	
}