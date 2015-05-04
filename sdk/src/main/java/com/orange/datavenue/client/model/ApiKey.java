/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

import java.util.ArrayList;

/**
 * A API key allows an application to access to the single data-source
 * operations.
 * 
 * @author MELIS Mathieu
 *
 */
public class ApiKey {

	/** The API key URl */
	private Link link = null;

	/** Start date of validity. If empty, start date equal creation date */
	private String startDate = null;

	/** End date of validity. If empty, no end date of validity. */
	private String endDate = null;

	/**
	 * The API key right access. Possible values:
	 * <ul>
	 * <li>GET</li>
	 * <li>PUT</li>
	 * <li>POST</li>
	 * <li>DELETE</li>
	 * </ul>
	 */
	private ArrayList<String> rights = null;

	/** The API key description */
	private String description = null;

	/**
	 * The API key status. Exemple :
	 * <ul>
	 * <li>ACTIVATED</li>
	 * <li>DEACTIVATED</li>
	 * </ul>
	 */
	private String status = null;

	/** The API key name */
	private String name = null;

	/** The API key value */
	private String value = null;

	/** The API key value */
	private String id = null;

	/** APIKey date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** APIKey date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get the API key URl
	 * 
	 * @return link the APi key URL
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set the API key URL
	 * 
	 * @param link
	 *            the new API key URl
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get the start date of validity
	 * 
	 * @return startDate the start date of validity
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Set the start date of validity
	 * 
	 * @param startDate
	 *            the new start date of validity
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get the end date of validity
	 * 
	 * @return endDate the end date of validity
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Set the end date of validity
	 * 
	 * @param endDate
	 *            the new end date if validity
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/***
	 * Get the APi key rights
	 * 
	 * @return rights the API key rights
	 */
	public ArrayList<String> getRights() {
		return rights;
	}

	/**
	 * Set the APi key rights
	 * 
	 * @param rights
	 *            the new APi key rights
	 */
	public void setRights(ArrayList<String> rights) {
		this.rights = rights;
	}

	/**
	 * Get the API key description
	 * 
	 * @return description the API key description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the API key description
	 * 
	 * @param description
	 *            the new AIP key description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the APi key status
	 * 
	 * @return status the API key status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the APi key status
	 * 
	 * @param status
	 *            the new Api key status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the APi key name
	 * 
	 * @return name the APi key name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the APi key name
	 * 
	 * @param name
	 *            the new API key name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the API key value
	 * 
	 * @return value the API key value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the API key value
	 * 
	 * @param value
	 *            the new API key value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Get the APi key id
	 * 
	 * @return id the API key id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the API key id
	 * 
	 * @param id
	 *            the new API key id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the API key date and time creation.
	 * 
	 * @return created the API key date and time creation.
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the API key date and time creation.
	 * 
	 * @param created
	 *            the new date and time creation.
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the API key date and time update.
	 * 
	 * @return the API key date and time update.
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the API key date and time update.
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
		sb.append("class ApiKeys {\n");
		sb.append("  link: ").append(link).append("\n");
		sb.append("  startDate: ").append(startDate).append("\n");
		sb.append("  endDate: ").append(endDate).append("\n");
		sb.append("  rights: ").append(rights).append("\n");
		sb.append("  description: ").append(description).append("\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  value: ").append(value).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
