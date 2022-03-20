package com.rest.api.entities;

import org.springframework.web.multipart.MultipartFile;

public class MultiType {
	private MultipartFile fileData;
	private String test;

	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public MultiType(MultipartFile fileData) {
		super();
		this.fileData = fileData;
		this.test = test;
	}

}
