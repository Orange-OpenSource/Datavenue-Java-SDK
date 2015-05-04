/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

/**
 * AccountUpdate is similar to Account but only with modifiable attributes
 * 
 * @author MELIS Mathieu
 *
 */
public class AccountsUpdate {

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
	 * Portal password :
	 * <ul>
	 * <li>Min : 8 character</li>
	 * <li>Max : 64 characters</li>
	 * </ul>
	 */
	private String userPassword = null;

	/**
	 * Client ID APIGEE :
	 * <ul>
	 * <li>Min : 32 character</li>
	 * <li>Max : 64 characters</li>
	 * </ul>
	 */
	private String opeClientId = null;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Accounts {\n");
		sb.append("  email: ").append(email).append("\n");
		sb.append("  lastname: ").append(lastname).append("\n");
		sb.append("  firstname: ").append(firstname).append("\n");
		sb.append("  userPassword: ").append(userPassword).append("\n");
		sb.append("}\n");
		return sb.toString();
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
	 *            the new account ope client id
	 */
	public void setOpeClientId(String opeClientId) {
		this.opeClientId = opeClientId;
	}
}
