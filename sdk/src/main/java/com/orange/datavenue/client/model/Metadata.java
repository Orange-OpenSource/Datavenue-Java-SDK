/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

/**
 * Represent a metadata, value and id key.
 * 
 * @author MELIS Mathieu
 *
 */

public class Metadata {

	/** the meta-data id */
	private String key;

	/** The meta-data value */
	private String value;

	/**
	 * Set the meta-data id
	 * 
	 * @param key
	 *            new meta-data id
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the meta-data id
	 * 
	 * @return key the meta-data id
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Set the meta-data value
	 * 
	 * @param value
	 *            the new meta-data value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Get the meta-data value
	 * 
	 * @return value the meta-data value
	 */
	public String getValue() {
		return this.value;
	}

}