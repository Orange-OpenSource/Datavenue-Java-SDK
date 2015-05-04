/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.common;

public class SDKException extends Exception {

	private int code = 0;
	private String message = null;

	public SDKException() {
	}

	public SDKException(int code, String message, Throwable e) {
		super(e);
		this.code = code;
		this.message = message;
	}
	
	public SDKException(int code, String message) {
		this.code = code;
		this.message = message;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
