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
public class Page<T> {

    public T object;
    public int resultCount = -1;
    public int totalCount = -1;
}
