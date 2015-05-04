/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The location of an object is the determination of its geographical position
 * 
 * @author MELIS Mathieu
 *
 */
public class Location {

	/** Waypoint list to go to the location */
	private List<Waypoint> waypoints = new ArrayList<Waypoint>();
	
	/** Location latitude */
	private String latitude = null;
	
	/** Location longitude */
	private String longitude = null;
	
	/** Location elevation */
	private Integer elevation = null;

	/**
	 * Get the waypoints list
	 * @return waypoints the waypoints list
	 */
	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	/**
	 * Set waypoints the location waypoints list
	 * @param waypoints the new waypoints list
	 */
	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	/**
	 * Get the location latitude
	 * @return latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Set location latitude
	 * @param latitude the new location latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get location longitude
	 * @return longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Set location longitude
	 * @param longitude the new location longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Get location elevation
	 * @return elevation
	 */
	public Integer getElevation() {
		return elevation;
	}

	/**
	 * Set the location elevation
	 * @param elevation the new location elevation
	 */
	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Location {\n");
		sb.append("  waypoints: ").append(waypoints).append("\n");
		sb.append("  latitude: ").append(latitude).append("\n");
		sb.append("  longitude: ").append(longitude).append("\n");
		sb.append("  elevation: ").append(elevation).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
