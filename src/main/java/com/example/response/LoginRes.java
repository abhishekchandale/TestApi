package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("response")
public class LoginRes extends MessageResponse {
	

	public LoginRes(String message, String uniqueKey) {
		super();
		this.message = message;
		this.uniqueKey = uniqueKey;
	}

	@JsonProperty
	private String message;
	@JsonProperty
	private String uniqueKey;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUniqueKey() {
		return uniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
	
}
