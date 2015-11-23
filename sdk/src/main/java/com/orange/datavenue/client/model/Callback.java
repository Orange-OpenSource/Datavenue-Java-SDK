/**
 * Copyright (C) 2015 Orange
 *
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'.
 */

package com.orange.datavenue.client.model;

/**
 * @author Stéphane SANDON
 */
public class Callback {

    /**
     * Callback name :
     */
    private String name = null;

    /**
     * Callback description :
     */
    private String description = null;

    /**
     * Callback url :
     */
    private String url = null;

    /**
     * Callback status :
     * <ul>
     * <li>activated</li>
     * <li>deactivated</li>
     * </ul>
     * Max size : 32 characters
     */
    private String status = null;

    /**
     * Callback startDate :
     */
    private String startDate = null;

    /**
     * Callback endDate :
     */
    private String endDate = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
