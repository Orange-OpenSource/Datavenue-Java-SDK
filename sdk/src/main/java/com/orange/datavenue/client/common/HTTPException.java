/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.common;

public class HTTPException extends Exception {
	
	private int codeErrorHTTP = 0;
	private DatavenueError datavenueError = null;

	public HTTPException(int code, DatavenueError datavenueError) {
		this.codeErrorHTTP = code;
		this.datavenueError = datavenueError;
	}

	public int getCodeErrorHTTP() {
		return codeErrorHTTP;
	}

	public void setCodeErrorHTTP(int code) {
		this.codeErrorHTTP = code;
	}

	public DatavenueError getDatavenueError() {
		return datavenueError;
	}

	public void setDatavenueError(DatavenueError datavenueError) {
		this.datavenueError = datavenueError;
	}

}
