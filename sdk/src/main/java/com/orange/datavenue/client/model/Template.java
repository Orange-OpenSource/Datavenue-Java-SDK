/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

import java.util.Map;

/**
 * A template is a Prototype snapshot. The template is used as a parent element
 * for Datasource.
 * 
 * @author MELIS Mathieu
 *
 */
public class Template {

	/** The template name */
	private String name = null;

	/** The template description */
	private String description = null;

	/** The template URL */
	private Link link = null;

	/** The template streams */
	private Map<String, Link> streams = null;

	/** The template id */
	private String id = null;

	/** Template date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** Template date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get the template name
	 * 
	 * @return name the template name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the template name
	 * 
	 * @param name
	 *            the new template name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the template description
	 * 
	 * @return description the template description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the template description
	 * 
	 * @param description
	 *            the new template description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the template URl
	 * 
	 * @return link the template URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set the template URl
	 * 
	 * @param link
	 *            the new template URl
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get the template streams list
	 * 
	 * @return streams the template streams list
	 */
	public Map<String, Link> getStreams() {
		return streams;
	}

	/**
	 * Set the template streams list
	 * 
	 * @param streams
	 *            the new template streams list
	 */
	public void setStreams(Map<String, Link> streams) {
		this.streams = streams;
	}

	/**
	 * get the template id
	 * 
	 * @return id the template id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the template id
	 * 
	 * @param id
	 *            the new template id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the template date and time creation
	 * 
	 * @return created the template date and time creation
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the template date and time creation
	 * 
	 * @param created
	 *            the new template date and time creation
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the template date and time update
	 * 
	 * @return updated the template date and time update
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the template date and time update
	 * 
	 * @param updated
	 *            the new template date and time update
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Templates {\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  link: ").append(link).append("\n");
		sb.append("  streams: ").append(streams).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
