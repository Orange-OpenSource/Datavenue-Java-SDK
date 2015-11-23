/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client;

/**
 * Datavenue Client configuration
 */
public class Config {
	//public static final String DEFAULT_BASE_URL = "https://api.orange.com/datavenue/v1";
	public static final String DEFAULT_BASE_URL = "http://127.0.0.1:7000/datavenue/v1";
	//public static final String DEFAULT_BASE_URL = "http://api.iss-int.isaservicefor.me/api/v1";
	String baseUrl;
	String opeKey;
	String XISSKey;

	public Config(String opeKey, String XISSKey) {
		this.baseUrl = DEFAULT_BASE_URL;
		this.opeKey = opeKey;
		this.XISSKey = XISSKey;
	}

	public Config(String baseUrl, String opeKey, String XISSKey) {
		this.baseUrl = baseUrl;
		this.opeKey = opeKey;
		this.XISSKey = XISSKey;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getOpeKey() {
		return opeKey;
	}

	public void setOpeKey(String opeKey) {
		this.opeKey = opeKey;
	}
	

	public String getXISSKey() {
		return XISSKey;
	}

	public void setXISSKey(String xISSKey) {
		XISSKey = xISSKey;
	}

}
