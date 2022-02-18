package com.bootrest.spring.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseWrapper {

	private String datetime;
	private HttpStatus code;
	private String message;
	private String dataCount;
	private List data;

	public ResponseWrapper(String datetime, HttpStatus code, String message, List data) {
		super();
		this.datetime = datetime;
		this.code = code;
		this.message = message;
		this.data = data;
		this.dataCount = data == null ? "0" : data.size() + "";
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public String getDataCount() {
		return dataCount;
	}

	public void setDataCount(String dataCount) {
		this.dataCount = dataCount;
	}

}
