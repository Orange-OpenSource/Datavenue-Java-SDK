/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.common;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stéphane SANDON
 */
public class ApiInvoker {

	private static final String TAG_NAME = ApiInvoker.class.getSimpleName();

	public static final String OPE_KEY_NAME = "X-OAPI-Key";
	private static ApiInvoker INSTANCE = new ApiInvoker();
	private Map<String, String> defaultHeaderMap = new HashMap<String, String>();

	public static ApiInvoker getInstance() {
		return INSTANCE;
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
				List list = (List<?>) JsonUtil.getJsonMapper().readValue(json, typeInfo);
				return list;
			} else if (String.class.equals(cls)) {
				if (json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
					return json.substring(1, json.length() - 2);
				else
					return json;
			} else {
				if (json != null) {
					return JsonUtil.getJsonMapper().readValue(json, cls);
				}
				throw new SDKException(500, "Unexpected Service Response");
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

	public HttpResponse invokeAPI(String host, String path, String method,
			Map<String, String> queryParams, Object body, Map<String, String> headerParams,
			Map<String, String> formParams, String contentType) throws SDKException, HTTPException {

		System.out.println( "invokeAPI()");

		System.out.println( String.format("host : %1$s", host));
		System.out.println( String.format("path : %1$s", path));
		System.out.println( String.format("method : %1$s", method));
		System.out.println( String.format("contentType : %1$s", contentType));

		HttpResponse response = new HttpResponse();

		StringBuilder paramsBuilder = new StringBuilder();

		for (String key : queryParams.keySet()) {
			String value = queryParams.get(key);
			if (value != null) {
				if (paramsBuilder.toString().length() == 0)
					paramsBuilder.append("?");
				else
					paramsBuilder.append("&");
				paramsBuilder.append(escapeString(key)).append("=").append(escapeString(value));
			}
		}

		String query = paramsBuilder.toString();
		//System.out.println( String.format("query : %1$s", query));
		//System.out.println( String.format("body : %1$s", (String)body));

		HttpURLConnection urlConnection = null;

		try {
			URL url = new URL(String.format("%1$s%2$s%3$s",host, path, query));
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(method);

			for (String key : headerParams.keySet()) {
				urlConnection.setRequestProperty(key, headerParams.get(key));
			}

			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.setRequestProperty("Content-Type", contentType);

			if (body != null) {
				urlConnection.setDoOutput(true);
			}

			if ("GET".equals(method)) {
				if (body != null) {
					writeStream(urlConnection.getOutputStream(), serialize(body));
				}
				response.body = readStream(urlConnection.getInputStream());

				System.out.println( String.format("response : %1$s", response.body));
			} else if ("POST".equals(method)) {
				if (body != null) {
					writeStream(urlConnection.getOutputStream(), serialize(body));
				}
				response.body = readStream(urlConnection.getInputStream());

				System.out.println( String.format("response : %1$s", response.body));
			} else if ("PUT".equals(method)) {

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
								System.out.println( e.toString());
							}
						}
					}

					writeStream(urlConnection.getOutputStream(), formParamBuilder.toString());
				} else {
					writeStream(urlConnection.getOutputStream(), serialize(body));
				}

				response.body = readStream(urlConnection.getInputStream());

				System.out.println( String.format("response : %1$s", response));
			} else if ("DELETE".equals(method)) {
				if (body != null) {
					writeStream(urlConnection.getOutputStream(), serialize(body));
				}
				response.body = readStream(urlConnection.getInputStream());

				System.out.println( String.format("response : %1$s", response));
			} else if ("OPTIONS".equals(method)) {
				System.out.println( "method not implemented");
				throw new SDKException(500, String.format("method not implemented %1$s", method));
			} else if ("HEAD".equals(method)) {
				System.out.println( "method not implemented");
				throw new SDKException(500, String.format("method not implemented %1$s", method));
			} else if ("TRACE".equals(method)) {
				System.out.println( "method not implemented");
				throw new SDKException(500, String.format("method not implemented %1$s", method));
			} else {
				System.out.println( "Unknown method");
				throw new SDKException(500, String.format("method not implemented %1$s", method));
			}

			response.headers =urlConnection.getHeaderFields();

		} catch (MalformedURLException e) {
			System.out.println( e.toString());
		} catch (IOException e) {
            // When an IOException occured, we have to read on the ErrorStream
            if (urlConnection != null) {
                try {
                    int code = urlConnection.getResponseCode();
                    String json = readStream(urlConnection.getErrorStream());
                    try {

                        JSONObject jsonObject = new JSONObject(json);

                        int datavenueCode = 0;

                        if (jsonObject.has("code")) {
                            datavenueCode = jsonObject.getInt("code");
                        }

                        String datavenueMessage = "";

                        if (jsonObject.has("message")) {
                            datavenueMessage = jsonObject.getString("message");
                        }

                        String datavenueDescription = "";

                        if (jsonObject.has("description")) {
                            datavenueDescription = jsonObject.getString("description");
                        }

                        DatavenueError datavenueError = new DatavenueError();
                        datavenueError.setCode(datavenueCode);
                        datavenueError.setMessage(datavenueMessage);
                        datavenueError.setDescription(datavenueDescription);

                        throw new HTTPException(code, datavenueError);

                    } catch (JSONException je) {
                        System.out.println( je.toString());
                    }

                } catch(IOException io) {
                    System.out.println( io.toString());
					throw new SDKException(500, io.toString(), io);
                }
            } else {
                System.out.println( e.toString());
				throw new SDKException(500, e.toString(), e);
            }
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}

		response.log();

		return response;
	}

	/**
	 *
	 * @param in
	 * @return
	 */
	private String readStream(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder out = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			reader.close();
		} catch(IOException e) {
			System.out.println( e.toString());
		}
		return out.toString();
	}

	/**
	 *
	 * @param out
	 * @param body
	 */
	private void writeStream(OutputStream out, String body) {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		try {
			writer.write(body);
			writer.close();
		} catch(IOException e) {
			System.out.println( e.toString());
		}
	}
}