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
 * A prototype is a data source. The prototype is used to define the data
 * structure and access and to create a template.
 * 
 * @author MELIS Mathieu
 *
 */
public class Prototype implements HasId{

	/**
	 * Prototype ID. Format UUID (16 bytes), supply by Datavenue service. Ex:
	 * d985f3b7ad9f027faab453635c11d06b
	 */
	private String id = null;

	/**
	 * <p>
	 * Prototype name.
	 * </p>
	 * <p>
	 * Size:
	 * </p>
	 * <ul>
	 * <li>Min : 1 character</li>
	 * <li>Max : 64 characters</li>
	 * </ul>
	 */
	private String name = null;

	/**
	 * Prototype description.
	 * <p>
	 * Size:
	 * </p>
	 * <ul>
	 * <li>Min : 0 character</li>
	 * <li>Max : 512 characters</li>
	 * </ul>
	 */
	private String description = null;

	/** Prototype meta-data list */
	private List<Metadata> metadata = null;

	/** Prototype URL */
	private Link link = null;

	/** Prototype streams list */
	private Map<String, Link> streams = null;

	/** Prototype ApiKey list */
	private Map<String, Link> apikeys = null;

	/** Prototype date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** Prototype date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/** Prototype status */
	private String status = null;

	/**
	 * Get the prototype name
	 * 
	 * @return name the prototype name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the prototype name
	 * 
	 * @param name
	 *            the new prototype name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the prototype description
	 * 
	 * @return description the prototype description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the prototype description
	 * 
	 * @param description
	 *            the new prototype description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the prototype meta-data list
	 * 
	 * @return metatdata the prototype meta-data list
	 */
	public List<Metadata> getMetadata() {
		return metadata;
	}

	/**
	 * Set th prototype meta-data list
	 * 
	 * @param metadata
	 *            the new prototype meta-data list
	 */
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	/**
	 * Get the prototype URL
	 * 
	 * @return link the prototype URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set the prototype URL
	 * 
	 * @param link
	 *            the new prototype URL
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get the prototype streams list
	 * 
	 * @return streams the prototype streams list
	 */
	public Map<String, Link> getStreams() {
		return streams;
	}

	/**
	 * Set the prototype streams list
	 * 
	 * @param streams
	 *            the new prototype streams list
	 */
	public void setStreams(Map<String, Link> streams) {
		this.streams = streams;
	}

	/**
	 * Get the prototype apikeys list
	 * 
	 * @return apikeys the prototype apikey list
	 */
	public Map<String, Link> getApikeys() {
		return apikeys;
	}

	/**
	 * Set the prototype apikey list
	 * 
	 * @param apikeys
	 *            the new prototype apikey list
	 */
	public void setApikeys(Map<String, Link> apikeys) {
		this.apikeys = apikeys;
	}

	/**
	 * Get the prototype id
	 * 
	 * @return id the prototype id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the prototype id
	 * 
	 * @param id
	 *            the new prototype id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the prototype date and time creation
	 * 
	 * @return created the prototype date and time creation
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the prototype date and time creation
	 * 
	 * @param created
	 *            the new prototype date and time creation
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the prototype date and time update
	 * 
	 * @return updated the prototype date and time update
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the prototype date and time update
	 * 
	 * @param updated
	 *            the new prototype date and time update
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	/**
	 * Get the status
	 *
	 * @return status the prototype status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the prototype status
	 *
	 * @param status the new prototype status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Prototypes {\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  metadata: ").append(metadata).append("\n");
		sb.append("  link: ").append(link).append("\n");
		sb.append("  streams: ").append(streams).append("\n");
		sb.append("  apikeys: ").append(apikeys).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}