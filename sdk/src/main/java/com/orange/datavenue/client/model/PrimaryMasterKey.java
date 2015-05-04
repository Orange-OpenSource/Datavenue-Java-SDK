/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

/**
 * PrimaryMasterKey a key, automatically created when a account is create. That
 * key allows the client to manage service access key (master key).
 * 
 * @author MELIS Mathieu
 *
 */
public class PrimaryMasterKey {

	/** Primary Master Key name */
	private String name = null;

	/** Primary Master Key value */
	private String value = null;

	/** Primary Master Key id */
	private String id = null;

	/**
	 * Primary Master Key date and time creation. Ex : 2014-06-16T14:25:000.000Z
	 */
	private String created = null;

	/** Primary Master Key date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get the Primary Master Key name
	 * 
	 * @return name the Primary Master Key name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Primary Master Key name
	 * 
	 * @param name
	 *            the new Primary Master Key name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Primary Master Key value
	 * 
	 * @return value the Primary Master Key value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set de Primary Master Key value
	 * 
	 * @param value
	 *            the new Primary Master Key value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Get the Primary Master Key id
	 * 
	 * @return id the Primary Master Key id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the Primary Master Key id
	 * 
	 * @param id
	 *            the new Primary Master Key id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the Primary Master Key date and time creation
	 * 
	 * @return created the Primary Master Key date and time creation
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the Primary Master Key date and time creation
	 * 
	 * @param created
	 *            the new Primary Master Key date and time creation
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the Primary Master Key date and time update
	 * 
	 * @return updated the Primary Master Key date and time update
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the Primary Master Key date and time update
	 * 
	 * @param updated
	 *            the new Primary Master Key date and time update
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PrimaryMasterKeyBase {\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  value: ").append(value).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
