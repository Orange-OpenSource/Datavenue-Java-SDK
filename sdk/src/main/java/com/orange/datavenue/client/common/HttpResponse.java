/**
 * Copyright (C) 2015 Orange
 *
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'.
 */

package com.orange.datavenue.client.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stéphane SANDON
 */
public class HttpResponse {

    private static final String TAG_NAME = HttpResponse.class.toString();

    public String body;
    public Map<String, List<String>> headers;

    public HttpResponse() {
        headers = new HashMap<String, List<String>>();
    }

    /**
     *
     * @return
     */
    public void log() {

        for (String key: headers.keySet()) {
            System.out.println("key : " + ((key == null) ? "" : key) + "\n");
            for (String property: headers.get(key)) {
            	System.out.println("value : " + property + "\n");
            }
        }

        if (body != null) {

        	System.out.println("body : \n");

            int start = 0;
            int end = body.length();

            while (start < end) {
                if ((end-start) >= 1000) {
                    end = start + 1000;
                }

                System.out.println(body.substring(start, end));

                start = end;
                end = body.length();
            }
        }
    }

}