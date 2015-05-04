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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * Data-source is the elements set associated with a device.
 * 
 * @author MELIS Mathieu
 *
 */
@JsonSerialize(include = Inclusion.NON_EMPTY)
public class Datasource implements HasId {

	/** Data-source serial number */
	private String serial = null;

	/** Group name list */
	private List<String> group = null;

	/** link to the template */
	private DatasourceTemplate template = null;

	/** Data-source description */
	private String description = null;

	/** Data-source name */
	private String name = null;

	/** Data-source mete-data list */
	private List<Metadata> metadata = null;

	/** Data-source URL */
	private Link link = null;

	/** Data-source streams list */
	private Map<String, Link> streams = null;

	/** Data-source apiKeys list */
	private Map<String, Link> apikeys = null;

	/** Data-source id */
	private String id = null;

	/** Data-source date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** Data-source date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get data-source serial
	 * 
	 * @return serial the data-source serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * Set data-source serial
	 * 
	 * @param serial
	 *            the new data-source serial
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * Get data-source group list
	 * 
	 * @return group the data-source group list
	 */
	public List<String> getGroup() {
		return group;
	}

	/**
	 * Set data-source group list
	 * 
	 * @param group
	 *            the new data-source group list
	 */
	public void setGroup(List<String> group) {
		this.group = group;
	}

	/**
	 * Get data-source template
	 * 
	 * @return template
	 */
	public DatasourceTemplate getTemplate() {
		return template;
	}

	/**
	 * Set data-source template
	 * 
	 * @param template
	 *            the new data-source template
	 */
	public void setTemplate(DatasourceTemplate template) {
		this.template = template;
	}

	/**
	 * Get data-source description
	 * 
	 * @return description the data-source description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set data-source description
	 * 
	 * @param description
	 *            the new data-source description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get data-source name
	 * 
	 * @return name the data-source name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set data-source name
	 * 
	 * @param name
	 *            the new data-source name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get data-source mete-data list
	 * 
	 * @return meta-data the data-source meta-data list
	 */
	public List<Metadata> getMetadata() {
		return metadata;
	}

	/**
	 * Set the data-source mete-data list
	 * 
	 * @param metadata
	 *            the new data-source meta-data list
	 */
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	/**
	 * get data-source URL
	 * 
	 * @return link the data-source URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set data-source URL
	 * 
	 * @param link
	 *            the new data-source URl
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get data-source streams list
	 * 
	 * @return streams the data-source streams list
	 */
	public Map<String, Link> getStreams() {
		return streams;
	}

	/**
	 * Set data-source streams list
	 * 
	 * @param streams
	 *            the new data-source streams list
	 */
	public void setStreams(Map<String, Link> streams) {
		this.streams = streams;
	}

	/**
	 * Get data-source apikeys list
	 * 
	 * @return apikeys the data-source apikeys list
	 */
	public Map<String, Link> getApikeys() {
		return apikeys;
	}

	/**
	 * Set data-source apikeys list
	 * 
	 * @param apikeys
	 *            the new data-source apikeys list
	 */
	public void setApikeys(Map<String, Link> apikeys) {
		this.apikeys = apikeys;
	}

	/* (non-Javadoc)
	 * @see com.orange.datavenue.client.model.HasId#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.orange.datavenue.client.model.HasId#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the data-source date and time creation.
	 * 
	 * @return created the data-source date and time creation.
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the data-source date and time creation.
	 * 
	 * @param created
	 *            the new date and time creation.
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the data-source date and time update.
	 * 
	 * @return the data-source date and time update.
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the data-source date and time update.
	 * 
	 * @param updated
	 *            the new date and time update.
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
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
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
