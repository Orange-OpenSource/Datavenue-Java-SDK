/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

/**
 * Resource URL
 * @author MELIS Mathieu
 *
 */
public class Link {

	/** Resource URL */
	private String href = null;

	/** Relationship semantics */
	private String rel = null;

	/**
	 * Get the resource URl
	 * @return href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * Set the resource URl
	 * @param href the new resource URL
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * Get the relationship semantics
	 * @return rel
	 */
	public String getRel() {
		return rel;
	}

	/**
	 * Set the relationship semantics
	 * @param rel the new relationship semantics
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Link {\n");
		sb.append("  href: ").append(href).append("\n");
		sb.append("  rel: ").append(rel).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
