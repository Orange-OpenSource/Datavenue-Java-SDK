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
 * Datasource is the elements set associated with a device.
 * 
 * @author MELIS Mathieu
 *
 */
//@JsonSerialize(include = Inclusion.NON_EMPTY)
public class Datasource implements HasId {

	/** Datasource serial number */
	private String serial = null;

	/** callback */
	private Callback callback = null;

	/** Group name list */
	private List<String> group = null;

	/** link to the template */
	private DatasourceTemplate template = null;

	/** Datasource description */
	private String description = null;

	/** Datasource name */
	private String name = null;

	/** Datasource mete-data list */
	private List<Metadata> metadata = null;

	/** Datasource URL */
	private Link link = null;

	/** Datasource streams list */
	private Map<String, Link> streams = null;

	/** Datasource apiKeys list */
	private Map<String, Link> apikeys = null;

	/** Datasource id */
	private String id = null;

	/** Datasource date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** Datasource date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/** Datasource status */
	private String status = null;

	/**
	 * Get datasource serial
	 * 
	 * @return serial the datasource serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * Set datasource serial
	 * 
	 * @param serial
	 *            the new datasource serial
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * Get the status
	 *
	 * @return status the datasource status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the datasource status
	 *
	 * @param status the new datasource status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get datasource group list
	 * 
	 * @return group the datasource group list
	 */
	public List<String> getGroup() {
		return group;
	}

	/**
	 * Set datasource group list
	 * 
	 * @param group
	 *            the new datasource group list
	 */
	public void setGroup(List<String> group) {
		this.group = group;
	}

	/**
	 * Get datasource template
	 * 
	 * @return template
	 */
	public DatasourceTemplate getTemplate() {
		return template;
	}

	/**
	 * Set datasource template
	 * 
	 * @param template
	 *            the new datasource template
	 */
	public void setTemplate(DatasourceTemplate template) {
		this.template = template;
	}

	/**
	 * Get datasource description
	 * 
	 * @return description the datasource description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set datasource description
	 * 
	 * @param description
	 *            the new datasource description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get datasource name
	 * 
	 * @return name the datasource name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set datasource name
	 * 
	 * @param name
	 *            the new datasource name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get datasource mete-data list
	 * 
	 * @return metadata the datasource meta-data list
	 */
	public List<Metadata> getMetadata() {
		return metadata;
	}

	/**
	 * Set the datasource metadata list
	 * 
	 * @param metadata the new datasource metadata list
	 */
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	/**
	 * get datasource URL
	 * 
	 * @return link the datasource URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set datasource URL
	 * 
	 * @param link the new datasource URl
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get datasource streams list
	 * 
	 * @return streams the datasource streams list
	 */
	public Map<String, Link> getStreams() {
		return streams;
	}

	/**
	 * Set datasource streams list
	 * 
	 * @param streams the new datasource streams list
	 */
	public void setStreams(Map<String, Link> streams) {
		this.streams = streams;
	}

	/**
	 * Get datasource apikeys list
	 * 
	 * @return apikeys the datasource apikeys list
	 */
	public Map<String, Link> getApikeys() {
		return apikeys;
	}

	/**
	 * Set datasource apikeys list
	 * 
	 * @param apikeys the new datasource apikeys list
	 */
	public void setApikeys(Map<String, Link> apikeys) {
		this.apikeys = apikeys;
	}

	/* (non-Javadoc)
	 * @see HasId#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see HasId#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the datasource date and time creation.
	 * 
	 * @return created the datasource date and time creation.
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the datasource date and time creation.
	 * 
	 * @param created the new date and time creation.
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the datasource date and time update.
	 * 
	 * @return the datasource date and time update.
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the datasource date and time update.
	 * 
	 * @param updated the new date and time update.
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	/**
	 * Set the datasource callback
	 * @param callback
	 */
	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	/**
	 * Get datasource callback
	 * @return
	 */
	public Callback getCallback() {
		return this.callback;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Datasources {\n");
		sb.append("  serial: ").append(serial).append("\n");
		sb.append("  group: ").append(group).append("\n");
		sb.append("  template: ").append(template).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  metadata: ").append(metadata).append("\n");
		sb.append("  link: ").append(link).append("\n");
		sb.append("  streams: ").append(streams).append("\n");
		sb.append("  apikeys: ").append(apikeys).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  callback: ").append(callback.getUrl()).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
