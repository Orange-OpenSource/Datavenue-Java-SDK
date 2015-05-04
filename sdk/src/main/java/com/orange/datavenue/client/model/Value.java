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

	/** The value timestamp */
	private String at = null;

	/** The value location */
	private Location location = null;

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
	 * Get value location
	 * 
	 * @return location the value location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Set the value location
	 * 
	 * @param location
	 *            the new value location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Values {\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  value: ").append(value).append("\n");
		sb.append("  at: ").append(at).append("\n");
		sb.append("  location: ").append(location).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
