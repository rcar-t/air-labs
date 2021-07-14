package com.rhonda.AirLabsChallenge.dto;

import java.util.Date;

public class ResponseError {
	private String errorMsg;
	private Date timestamp;
	public ResponseError(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		this.timestamp = new Date();
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	} 
}
