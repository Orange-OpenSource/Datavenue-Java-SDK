/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

public interface HasId {

	/**
	 * Get data-source id
	 * 
	 * @return id the data-source id
	 */
	public abstract String getId();

	/**
	 * Set data-source id
	 * 
	 * @param id
	 *            the new data-source id
	 */
	public abstract void setId(String id);

}