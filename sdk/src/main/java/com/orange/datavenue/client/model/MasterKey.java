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
 * A master key allows an application to operations access on all data-source
 * for a account
 * 
 * @author MELIS Mathieu
 *
 */
public class MasterKey {

	/** The master key URL */
	private Link link = null;

	/** Start date of validity. If empty, start date equal creation date */
	private String startDate = null;

	/** End date of validity. If empty, no end date of validity. */
	private String endDate = null;

	/**
	 * The master key right access. Possible values:
	 * <ul>
	 * <li>GET</li>
	 * <li>PUT</li>
	 * <li>POST</li>
	 * <li>DELETE</li>
	 * </ul>
	 */
	private ArrayList<String> rights = null;

	/** The master key description */
	private String description = null;

	/**
	 * The master key status. Exemple :
	 * <ul>
	 * <li>ACTIVATED</li>
	 * <li>DEACTIVATED</li>
	 * </ul>
	 */
	private String status = null;

	/** The master key name */
	private String name = null;

	/** The master key value */
	private String value = null;

	/** The master key id */
	private String id = null;

	/** MasterKey date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** MasterKey date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get the master key URL.
	 * 
	 * @return link the master key URL.
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * Set master key URL.
	 * 
	 * @param link
	 *            the new master key URL.
	 */
	public void setLink(Link link) {
		this.link = link;
	}

	/**
	 * Get start date validity.
	 * 
	 * @return startDate the start date validity.
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Set start date validity.
	 * 
	 * @param startDate
	 *            the new start date validity.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get end date validity.
	 * 
	 * @return endDate the end date validity.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Set end date validity.
	 * 
	 * @param endDate
	 *            the new end date validity.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Get rights list.
	 * 
	 * @return rights the rights list.
	 */
	public ArrayList<String> getRights() {
		return rights;
	}

	/**
	 * Set rights list.
	 * 
	 * @param rights
	 *            the new right list.
	 */
	public void setRights(ArrayList<String> rights) {
		this.rights = rights;
	}

	/**
	 * Get the master key description.
	 * 
	 * @return description the master key description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the master key description.
	 * 
	 * @param description
	 *            the new master key description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the master key status.
	 * 
	 * @return status the master key status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the master key status.
	 * 
	 * @param status
	 *            the new master key status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the master key name.
	 * 
	 * @return name the master key name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the master key name.
	 * 
	 * @param name
	 *            the new master key name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the master key value.
	 * 
	 * @return value the master key value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the master key value.
	 * 
	 * @param value
	 *            the new master key value.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Get the master key id.
	 * 
	 * @return id the master key id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the master key id.
	 * 
	 * @param id
	 *            the new master key id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the master key date and time creation.
	 * 
	 * @return created the master key date and time creation.
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the master key date and time creation.
	 * 
	 * @param created
	 *            the new date and time creation.
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the master key date and time update.
	 * 
	 * @return the master key date and time update.
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the master key date and time update.
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
		sb.append("class MasterKeys {\n");
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
