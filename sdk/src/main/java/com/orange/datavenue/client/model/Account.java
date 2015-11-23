/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;


/**
 * A client account. The client account creation in Datavenue portal is a
 * requested for use the JAVA SDK.
 * 
 * @author MELIS Mathieu
 *
 */
public class Account {

	/**
	 * Account status :
	 * <ul>
	 * <li>activated</li>
	 * <li>deactivated</li>
	 * </ul>
	 * Max size : 32 characters
	 */
	private String status = null;

	/**
	 * User email :
	 * <ul>
	 * <li>Min : 6 character</li>
	 * <li>Max : 254 characters</li>
	 * </ul>
	 */
	private String email = null;

	/**
	 * User lastname :
	 * <ul>
	 * <li>Min : 1 character</li>
	 * <li>Max : 128 characters</li>
	 * </ul>
	 */
	private String lastname = null;

	/**
	 * User firstname :
	 * <ul>
	 * <li>Min : 1 character</li>
	 * <li>Max : 128 characters</li>
	 * </ul>
	 */
	private String firstname = null;

	/**
	 * Client ID APIGEE :
	 * <ul>
	 * <li>Min : 32 character</li>
	 * <li>Max : 64 characters</li>
	 * </ul>
	 */
	private String opeClientId = null;

	/**
	 * Portal password :
	 * <ul>
	 * <li>Min : 8 character</li>
	 * <li>Max : 64 characters</li>
	 * </ul>
	 */
	private String userPassword = null;

	/**
	 * Account primary master key : Format UUID (16 bytes), supply by Datavenue
	 * service. Ex: d985f3b7ad9f027faab453635c11d06b
	 */
	private PrimaryMasterKey primaryMasterKey = null;

	/** Account master key*/
	private MasterKey masterKey = null;

	/** The account id */
	private String id = null;

	/** Account date and time creation. Ex : 2014-06-16T14:25:000.000Z */
	private String created = null;

	/** Account date and time update. Ex : 2014-06-16T14:25:000.000Z */
	private String updated = null;

	/**
	 * Get the account status
	 * 
	 * @return status the account status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the account status
	 * 
	 * @param status
	 *            the new account status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the account email
	 * 
	 * @return email the account email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the account email
	 * 
	 * @param email
	 *            the new account email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the account lastname
	 * 
	 * @return lastname the account lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Set the account lastname
	 * 
	 * @param lastname
	 *            the new account lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Get the account firstname
	 * 
	 * @return the account firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Set the account firstname
	 * 
	 * @param firstname
	 *            the new account firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Get the OPE client id
	 * 
	 * @return opeClientId the OPE client id
	 */
	public String getOpeClientId() {
		return opeClientId;
	}

	/**
	 * Set the OPE client id
	 * 
	 * @param opeClientId
	 *            the new OPE client id
	 */
	public void setOpeClientId(String opeClientId) {
		this.opeClientId = opeClientId;
	}

	/**
	 * Get account userPassword
	 * 
	 * @return the account userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * Set account userPassword
	 * 
	 * @param userPassword
	 *            the new userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * Get account primaryMasterKey
	 * 
	 * @return primaryMasterKey the account primaryMasterKey
	 */
	public PrimaryMasterKey getPrimaryMasterKey() {
		return primaryMasterKey;
	}

	/**
	 * Set the account primaryMasterKey
	 * 
	 * @param primaryMasterKey
	 *            the new account primaryMasterKey
	 */
	public void setPrimaryMasterKey(PrimaryMasterKey primaryMasterKey) {
		this.primaryMasterKey = primaryMasterKey;
	}

	/**
	 * Get the account master key
	 * 
	 * @return masterKey the account master key 
	 */
	public MasterKey getMasterKey() {
		return masterKey;
	}

	/**
	 * Set the account master key
	 * 
	 * @param masterKey
	 *            the new account master key
	 */
	public void setMasterKey(MasterKey masterKey) {
		this.masterKey = masterKey;
	}

	/**
	 * Get the account id
	 * 
	 * @return id the account id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the account id
	 * 
	 * @param id
	 *            the new account id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the account date and time creation
	 * 
	 * @return created the account date and time creation
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Set the account date and time creation
	 * 
	 * @param created
	 *            the new account date and time creation
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Get the account date and time update
	 * 
	 * @return updated the account date and time update
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * Set the account date and time update
	 * 
	 * @param updated
	 *            the new account date and time update
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Accounts {\n");
		sb.append("  status: ").append(status).append("\n");
		sb.append("  email: ").append(email).append("\n");
		sb.append("  lastname: ").append(lastname).append("\n");
		sb.append("  firstname: ").append(firstname).append("\n");
		sb.append("  opeClientId: ").append(opeClientId).append("\n");
		sb.append("  userPassword: ").append(userPassword).append("\n");
		sb.append("  primaryMasterKey: ").append(primaryMasterKey).append("\n");
		sb.append("  masterKey: ").append(masterKey).append("\n");
		sb.append("  id: ").append(id).append("\n");
		sb.append("  created: ").append(created).append("\n");
		sb.append("  updated: ").append(updated).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
