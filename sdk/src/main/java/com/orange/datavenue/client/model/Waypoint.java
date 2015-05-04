/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

/**
 * Waypoint designate, in navigation, a point on the road to reach to make a
 * change.
 * 
 * @author MELIS Mathieu
 *
 */
public class Waypoint {

	/** Timestamp of the waypoint*/
	private String at = null;
	
	/** Latitude of the waypoint*/
	private String latitude = null;
	
	/** Longitude of the waypoint*/
	private String longitude = null;
	
	/** Elevation of the waypoint*/
	private Integer elevation = null;

	/**
	 * Get the waypoint timestamp
	 * @return at the waypoint timestamp
	 */
	public String getAt() {
		return at;
	}

	/**
	 * Set the waypoint timestamp
	 * @param at the new waypoint timestamp
	 */
	public void setAt(String at) {
		this.at = at;
	}

	/**
	 * Get the waypoint latitude
	 * @return latitude the waypoint latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Set the waypoint latitude
	 * @param latitude the new waypoint latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get the waypoint longitude
	 * @return longitude the waypoint longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Set the waypoint longitude
	 * @param longitude the new waypoint longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Get the waypoint elevation
	 * @return the waypoint elevation
	 */
	public Integer getElevation() {
		return elevation;
	}

	/**
	 * Set the waypoint elevation 
	 * @param elevation the new waypoint elevation
	 */
	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Waypoints {\n");
		sb.append("  at: ").append(at).append("\n");
		sb.append("  latitude: ").append(latitude).append("\n");
		sb.append("  longitude: ").append(longitude).append("\n");
		sb.append("  elevation: ").append(elevation).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
