/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

import java.util.List;
import java.util.Map;

/**
 * Data set, of the same type, set up by one device and stored by the Datavenue
 * platform.
 * 
 * @author MELIS Mathieu
 *
 */
public class Stream {

	/** The stream name */
	private String name = null;

	/** The stream description */
	private String description = null;

	/** The last stream value */
	private Object lastValue = null;

	/** The stream unit */
	private Unit unit = null;

	/** The meta-data stream list */
	private List<Metadata> metadata = null;

	/** The stream values list URL */
	private Map<String, Link> values = null;

	/** The stream location */
	private Double[] location = null;

	/** The stream callback */
	private Callback callback = null;

	/** The stream URL */
	private Link link = null;

	/** The stream id */
	private String id = null;

	/** Stream date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** Stream date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get the stream name
	 * 
	 * @return name the stream name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the stream name
	 * 
	 * @param name
	 *            the new stream name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the stream description
	 * 
	 * @return description the stream description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the stream description
	 * 
	 * @param description
	 *            the new stream description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the last stream value
	 * 
	 * @return lastValue the last stream value
	 */
	public Object getLastValue() {
		return lastValue;
	}

	/**
	 * Set the last stream value
	 * 
	 * @param lastValue
	 *            the new last stream value
	 */
	public void setLastValue(Object lastValue) {
		this.lastValue = lastValue;
	}

	/**
	 * Get the stream unit
	 * 
	 * @return unit the stream unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * Set the stream unit
	 * 
	 * @param unit
	 *            the new stream unit
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * Get the meta-data stream list
	 * 
	 * @return meta-data the meta-data stream list
	 */
	public List<Metadata> getMetadata() {
		return metadata;
	}

	/**
	 * Set the meta-data stream list
	 * 
	 * @param metadata
	 *            the new meta-data stream list
	 */
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	/**
	 * Get the stream values list URL
	 * 
	 * @return values the stream values list URL
	 */
	public Map<String, Link> getValues() {
		return values;
	}

	/**
	 * Set the stream values list URL
	 * 
	 * @param values
	 *            the new stream values list URL
	 */
	public void setValues(Map<String, Link> values) {
		this.values = values;
	}

	/**
	 * Get the stream location
	 * 
	 * @return location the stream location
	 */
	public Double[] getLocation() {
		return location;
	}

	/**
	 * Set the stream location
	 * 
	 * @param location
	 *            the new stream location
	 */
	public void setLocation(Double[] location) {
		this.location = location;
	}

	/**
	 * Get the stream callback
	 *
	 * @return callback the stream callback
	 */
	public Callback getCallback() {
		return this.callback;
	}

	/**
	 * Set the stream callback
	 *
	 * @param callback
	 */
	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	/**
	 * Get the stream URL
	 * 
	 * @return link the stream URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set the stream URL
	 * 
	 * @param link
	 *            the new stream URL
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get the stream id
	 * 
	 * @return id the stream id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the stream id
	 * 
	 * @param id
	 *            the new stream id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the stream date and time creation
	 * 
	 * @return created the stream date and time creation
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the stream date and time creation
	 * 
	 * @param created
	 *            the new stream date and time creation
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the stream date and time update
	 * 
	 * @return updated the stream date and time update
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the stream date and time update
	 * 
	 * @param updated
	 *            the new stream date and time update
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Streams {\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  lastValue: ").append(lastValue).append("\n");
		sb.append("  unit: ").append(unit).append("\n");
		sb.append("  metadata: ").append(metadata).append("\n");
		sb.append("  values: ").append(values).append("\n");
		sb.append("  location: ").append(location).append("\n");
		sb.append("  link: ").append(link).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
