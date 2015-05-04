/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response.Status.Family;

import com.fasterxml.jackson.databind.JavaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.multipart.FormDataMultiPart;

public class ApiInvoker {
	public static final String OPE_KEY_NAME = "X-OAPI-Key";
	private static ApiInvoker INSTANCE = new ApiInvoker();
	private Map<String, Client> hostMap = new HashMap<String, Client>();
	private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
	private boolean isDebug = false;

	public void enableDebug() {
		isDebug = true;
	}

	public static ApiInvoker getInstance() {
		return INSTANCE;
	}

	public void addDefaultHeader(String key, String value) {
		defaultHeaderMap.put(key, value);
	}

	public String escapeString(String str) {
		try {
			return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}

	public static Object deserialize(String json, String containerType, Class cls) throws SDKException {
		try {
			if ("List".equals(containerType)) {
				JavaType typeInfo = JsonUtil.getJsonMapper().getTypeFactory().constructCollectionType(List.class, cls);
				List response = (List<?>) JsonUtil.getJsonMapper().readValue(json, typeInfo);
				return response;
			} else if (String.class.equals(cls)) {
				if (json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
					return json.substring(1, json.length() - 2);
				else
					return json;
			} else {
				return JsonUtil.getJsonMapper().readValue(json, cls);
			}
		} catch (IOException e) {
			throw new SDKException(500, e.getMessage());
		}
	}

	public static String serialize(Object obj) throws SDKException {
		try {
			if (obj != null)
				return JsonUtil.getJsonMapper().writeValueAsString(obj);
			else
				return null;
		} catch (Exception e) {
			throw new SDKException(500, e.getMessage());
		}
	}

	public String invokeAPI(String host, String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headerParams,
			Map<String, String> formParams, String contentType) throws SDKException, HTTPException {
		Client client = getClient(host);

		StringBuilder b = new StringBuilder();

		for (String key : queryParams.keySet()) {
			String value = queryParams.get(key);
			if (value != null) {
				if (b.toString().length() == 0)
					b.append("?");
				else
					b.append("&");
				b.append(escapeString(key)).append("=").append(escapeString(value));
			}
		}
		String querystring = b.toString();

		Builder builder = client.resource(host + path + querystring).accept("application/json");
		for (String key : headerParams.keySet()) {
			builder.header(key, headerParams.get(key));
		}

		for (String key : defaultHeaderMap.keySet()) {
			if (!headerParams.containsKey(key)) {
				builder.header(key, defaultHeaderMap.get(key));
			}
		}
		ClientResponse response = null;

		if ("GET".equals(method)) {
			response = (ClientResponse) builder.get(ClientResponse.class);
		} else {

			if ("POST".equals(method)) {
				if (body == null)
					response = builder.post(ClientResponse.class, null);
				else if (body instanceof FormDataMultiPart) {
					response = builder.type(contentType).post(ClientResponse.class, body);
				} else {
					String serialize = serialize(body);
					response = builder.type(contentType).post(ClientResponse.class, serialize);
				}
			} else if ("PUT".equals(method)) {
				if (body == null) {
					String serialize = serialize(body);
					response = builder.put(ClientResponse.class, serialize);
				} else {
					if ("application/x-www-form-urlencoded".equals(contentType)) {
						StringBuilder formParamBuilder = new StringBuilder();

						// encode the form params
						for (String key : formParams.keySet()) {
							String value = formParams.get(key);
							if (value != null && !"".equals(value.trim())) {
								if (formParamBuilder.length() > 0) {
									formParamBuilder.append("&");
								}
								try {
									formParamBuilder.append(URLEncoder.encode(key, "utf8")).append("=").append(URLEncoder.encode(value, "utf8"));
								} catch (Exception e) {
									// move on to next
								}
							}
						}
						response = builder.type(contentType).put(ClientResponse.class, formParamBuilder.toString());
					} else {
						String serialize = serialize(body);
						response = builder.type(contentType).put(ClientResponse.class, serialize);
					}
				}
			} else if ("DELETE".equals(method)) {
				String serialize = serialize(body);
				if (body == null)
					response = builder.delete(ClientResponse.class, serialize);
				else
					response = builder.type(contentType).delete(ClientResponse.class, serialize);
			} else {
				throw new SDKException(500, "unknown method type " + method);
			}
		}
		// WORKAROUND : check if response length is equal to 0. Used for getListValues() bug.
		if (response.getClientResponseStatus() == ClientResponse.Status.NO_CONTENT || response.getLength() == 0) {
			return null;
		} else if (response.getClientResponseStatus().getFamily() == Family.SUCCESSFUL) {
			return (String) response.getEntity(String.class);
		} else {
			DatavenueError datavenueError;
			try {
				datavenueError = (DatavenueError) deserialize(response.getEntity(String.class), "", DatavenueError.class);
			} catch (Exception ex) {
				throw new SDKException(500, "Serialization error ",ex);
			}
			throw new HTTPException(response.getClientResponseStatus().getStatusCode(), datavenueError);
		}
	}

	private Client getClient(String host) {
		if (!hostMap.containsKey(host)) {
			Client client = Client.create();
			if (isDebug)
				client.addFilter(new LoggingFilter());
			hostMap.put(host, client);
		}
		return hostMap.get(host);
	}
}
