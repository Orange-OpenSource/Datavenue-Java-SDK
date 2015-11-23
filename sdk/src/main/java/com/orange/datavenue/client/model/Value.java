/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;


/**
 * The value object contain, the value, the id of the value the location and
 * timestamp of the value. It's a data value storage in a data stream.
 * 
 * @author MELIS Mathieu
 *
 */
public class Value {

	/** The value id */
	private String id = null;

	/** The value */
	private Object value = null;

	/** Date of creation **/
	private String created = null;

    /** Date of latest modification **/
	private String updated = null;

	/** The value timestamp */
	private String at = null;

	/** The value location */
	private Double[] location = null;

	/** Metadata **/
	private Object metadata = null;

	/**
	 * Get the value id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the value id
	 * 
	 * @param id
	 *            the new value id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the value
	 * 
	 * @return value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Set the value
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Get the metadata
	 *
	 * @return metadata
	 */
	public Object getMetadata() {
		return metadata;
	}

	/**
	 * Set the metadata
	 *
	 * @param metadata
	 *            the new metadata
	 */
	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

	/**
	 * Get the value timestamp
	 * 
	 * @return at the value timestamp
	 */
	public String getAt() {
		return at;
	}

	/**
	 * Set the value timestamp
	 * 
	 * @param at
	 *            the new value timestamp
	 */
	public void setAt(String at) {
		this.at = at;
	}

	/**
	 * Get the created timestamp
	 *
	 * @return the created date
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the created timestamp
	 *
	 * @param created timestamp
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the updated timestamp
	 *
	 * @return the updated date
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the updated timestamp
	 *
	 * @param updated timestamp
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	/**
	 * Get value location
	 * 
	 * @return location the value location
	 */
	public Double[] getLocation() {
		return location;
	}

	/**
	 * Set the value location
	 * 
	 * @param location
	 *            the new value location
	 */
	public void setLocation(Double[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Values {\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  value: ").append(value).append("\n");
		sb.append("  at: ").append(at).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("  location: ").append(location).append("\n");
		sb.append("  metadata: ").append(metadata).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
