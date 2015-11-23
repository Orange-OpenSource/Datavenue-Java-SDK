/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;


/**
 * Mapping between Datasource and Template
 * 
 * @author MELIS Mathieu
 *
 */
public class DatasourceTemplate {

	/** Template id */
	private String id = null;

	/** Template name */
	private String name = null;

	/** Template link */
	private Link link = null;

	/** Template status */
	private String status = null;

	/**
	 * Get template id
	 * 
	 * @return id the template id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set template id
	 * 
	 * @param id
	 *            the new template id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get template name
	 * 
	 * @return name the template name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set template name
	 * 
	 * @param name
	 *            the new template name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get template URL
	 * 
	 * @return link the template URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set template URL
	 * 
	 * @param link
	 *            thge new template URL
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get the status
	 *
	 * @return status the template status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the template status
	 *
	 * @param status the new template status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Template {\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  link: ").append(link).append("\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
