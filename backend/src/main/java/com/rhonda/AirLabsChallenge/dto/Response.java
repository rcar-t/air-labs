package com.rhonda.AirLabsChallenge.dto;

import java.util.Date;

public class Response<T> {
	
	private Status status;
	private T body; 
	private Date timestamp;
	private ResponseError error;
	
	
	public Response(Status status, T body) {
		super();
		this.status = status;
		this.body = body;
		this.timestamp = new Date();
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public ResponseError getError() {
		return error;
	}
	public void setError(ResponseError error) {
		this.error = error;
	}


	public enum Status {
		HTTP_OK("200"),
		HTTP_ERROR("500");
		
		private final String value;
		
		private Status(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
	}
}
