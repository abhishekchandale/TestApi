package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse extends SuperResponse{

	@JsonProperty
	private String message = null;
	
	public MessageResponse() {
		super();
		this.message = null;
	}
	
	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
