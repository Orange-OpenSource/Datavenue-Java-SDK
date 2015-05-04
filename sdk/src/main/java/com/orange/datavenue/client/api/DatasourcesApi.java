/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.common.ApiInvoker;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.ApiKey;
import com.orange.datavenue.client.model.Datasource;
import com.orange.datavenue.client.model.Stream;
import com.orange.datavenue.client.model.Value;

/**
 * All data associated with a device. Include stream, meta-data and APIs keys.
 * 
 * @author MELIS Mathieu
 *
 */
public class DatasourcesApi {

	final String basePath;
	final String opeKey;
	final String XISSKey;
	
	ApiInvoker apiInvoker = ApiInvoker.getInstance();

	public DatasourcesApi(Config config) {
		this.basePath = config.getBaseUrl();
		this.opeKey = config.getOpeKey();
		this.XISSKey = config.getXISSKey();
	}

	/**
	 * Get all data-source
	 * 
	 * @param page
	 *            page number (default value 1)
	 * @param size
	 *            page size (default value 10)
	 * @return a data-source list
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 925 : Invalid input data</li>
	 *             </ul>
	 */
	public List<Datasource> listDatasource(String page, String size) throws SDKException, HTTPException {
		Object postBody = null;
		// create path and map variables
		String path = "/datasources".replaceAll("\\{format\\}", "json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		if (!"null".equals(String.valueOf(page)))
			queryParams.put("page", String.valueOf(page));
		if (!"null".equals(String.valueOf(size)))
			queryParams.put("size", String.valueOf(size));
		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";
		
		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (List<Datasource>) ApiInvoker.deserialize(response, "List", Datasource.class);
		} else {
			return null;
		}

	}

	/**
	 * Get data-source information with id
	 * 
	 * @param datasourcesId
	 *            datasource id
	 * @return Data-source
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found</li>
	 *             </ul>
	 */
	public Datasource getDatasource(String datasourcesId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourcesId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{datasources_id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "datasources_id" + "\\}",
				apiInvoker.escapeString(datasourcesId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Datasource) ApiInvoker.deserialize(response, "", Datasource.class);
		} else {
			return null;
		}

	}

	/**
	 * Update data-source informations
	 * 
	 * @param datasourceId
	 *            data-source id to update
	 * @param body
	 *            new data-source body
	 * @return the new Datasource
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found</li>
	 *             <li>Code 920 : Invalid input data (Missing field)</li>
	 *             <li>Code 924 : Invalid input data (Bad field format)</li>
	 *             </ul>
	 */
	public Datasource updateDatasource(String datasourceId, Datasource body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (datasourceId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(datasourceId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Datasource) ApiInvoker.deserialize(response, "", Datasource.class);
		} else {
			return null;
		}

	}

	/**
	 * Delete a datasource with id
	 * 
	 * @param datasourceId
	 *            data-source id to delete
	 * @return
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found</li>
	 *             </ul>
	 */
	public Datasource deleteDatasource(String datasourceId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(datasourceId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Datasource) ApiInvoker.deserialize(response, "", Datasource.class);
		} else {
			return null;
		}

	}

	/**
	 * Create a data-source
	 * 
	 * @param body
	 *            the data-source body
	 * @return the new data-source
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 914 : Resource not found</li>
	 *             <li>Code 920 : Invalid input data (Missing field)</li>
	 *             <li>Code 924 : Invalid input data (Bad field format)</li>
	 *             <li>Code 928 : Invalid input data (Empty field)</li>
	 *             </ul>
	 */
	public Datasource createDatasource(Datasource body) throws SDKException, HTTPException {
		Object postBody = body;
		// create path and map variables
		String path = "/datasources".replaceAll("\\{format\\}", "json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Datasource) ApiInvoker.deserialize(response, "", Datasource.class);
		} else {
			return null;
		}

	}

	/**
	 * Create an API key
	 * 
	 * @param datasourceId
	 *            data-source id id
	 * @param body
	 *            ApiKey body
	 * @return ApiKey the new APikay
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 920 : Invalid input data (Field missing)</li>
	 *             <li>Code 923 : Invalid input data (Incorrect field format)</li>
	 *             <li>Code 928 : Invalid input data (Empty field)</li>
	 *             <li>Code 934 : Naming conflict</li>
	 *             </ul>
	 */
	public ApiKey createApiKey(String datasourceId, ApiKey body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (datasourceId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}/keys".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}",
				apiInvoker.escapeString(datasourceId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (ApiKey) ApiInvoker.deserialize(response, "", ApiKey.class);
		} else {
			return null;
		}

	}

	/**
	 * Get an ApiKey list
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param page
	 *            page number (default value 1)
	 * @param size
	 *            page size (default value 10)
	 * @return an Apikey list
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 910 : Resource not found</li>
	 *             <li>Code 925 : Invalid input data</li>
	 *             </ul>
	 */
	public List<ApiKey> listApiKey(String datasourceId, String page, String size) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}/keys".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}",
				apiInvoker.escapeString(datasourceId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		if (!"null".equals(String.valueOf(page)))
			queryParams.put("page", String.valueOf(page));
		if (!"null".equals(String.valueOf(size)))
			queryParams.put("size", String.valueOf(size));
		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (List<ApiKey>) ApiInvoker.deserialize(response, "List", ApiKey.class);
		} else {
			return null;
		}

	}

	/**
	 * Delete an Apikey with id
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param keyId
	 *            Apikey id to delete
	 * @return
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 910 : Resource not found (Account not found)</li>
	 *             <li>Code 916 : Resource not found (ApiKey not found)</li>
	 *             </ul>
	 */
	public ApiKey deleteApiKey(String datasourceId, String keyId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}/keys/{key_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (ApiKey) ApiInvoker.deserialize(response, "", ApiKey.class);
		} else {
			return null;
		}

	}

	/**
	 * Get ApiKey informations
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param keyId
	 *            ApiKey id
	 * @return Apikey informations
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 910 : Resource not found (Account not found)</li>
	 *             <li>Code 916 : Resource not found (ApiKey not found)</li>
	 *             </ul>
	 */
	public ApiKey getApiKey(String datasourceId, String keyId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}/keys/{key_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (ApiKey) ApiInvoker.deserialize(response, "", ApiKey.class);
		} else {
			return null;
		}

	}

	/**
	 * Update Apikey informations
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param keyId
	 *            Apikey id
	 * @param body
	 *            new Apikey body
	 * @return Apikey
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 916 : Resource not found</li>
	 *             <li>Code 920 : Invalid input data (Field missing)</li>
	 *             <li>Code 923 : Invalid input data (Invalid field format)</li>
	 *             <li>Code 928 : Invalid input data (Empty field)</li>
	 *             <li>Code 934 : Naming conflict</li>
	 *             </ul>
	 */
	public ApiKey updateApiKey(String datasourceId, String keyId, ApiKey body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (datasourceId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}/keys/{key_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (ApiKey) ApiInvoker.deserialize(response, "", ApiKey.class);
		} else {
			return null;
		}

	}

	/**
	 * Regenerate an Apikey
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param keyId
	 *            Apikey id
	 * @return Apikey
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 910 : Resource not found (Account not found)</li>
	 *             <li>Code 916 : Resource not found (ApiKey not found)</li>
	 *             </ul>
	 */
	public ApiKey regenerateApiKey(String datasourceId, String keyId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{id}/keys/{key_id}/regenerate".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (ApiKey) ApiInvoker.deserialize(response, "", ApiKey.class);
		} else {
			return null;
		}

	}

	/**
	 * Get all streams
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param page
	 *            page number (default value 1)
	 * @param size
	 *            page size (default value 10)
	 * @return a streams list
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 910 : Resource not found (Account not found)</li>
	 *             <li>Code 916 : Resource not found (ApiKey not found)</li>
	 *             </ul>
	 */
	public List<Stream> listStreams(String datasourceId, String page, String size) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "parent_id" + "\\}",
				apiInvoker.escapeString(datasourceId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		if (!"null".equals(String.valueOf(page)))
			queryParams.put("page", String.valueOf(page));
		if (!"null".equals(String.valueOf(size)))
			queryParams.put("size", String.valueOf(size));
		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			if ("".equals(response)) {
				return new ArrayList<Stream>();
			} else {
				return (List<Stream>) ApiInvoker.deserialize(response, "List", Stream.class);
			}
		} else {
			return null;
		}

	}

	/**
	 * Create a stream
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param body
	 *            the stream body
	 * @return the new stream
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             <li>Code 924 : Invalid input data (Input data size)</li>
	 *             <li>Code 928 : Resource not found (Empty field)</li>
	 *             <li>Code 933 : Naming conflict</li>
	 *             </ul>
	 */
	public Stream createStream(String datasourceId, Stream body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (datasourceId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "parent_id" + "\\}",
				apiInvoker.escapeString(datasourceId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Stream) ApiInvoker.deserialize(response, "", Stream.class);
		} else {
			return null;
		}

	}

	/**
	 * Get data-source stream by id
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            the stream id
	 * @return Steam
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             </ul>
	 */
	public Stream getStream(String datasourceId, String streamId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || streamId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Stream) ApiInvoker.deserialize(response, "", Stream.class);
		} else {
			return null;
		}

	}

	/**
	 * Update a stream body
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            stream id
	 * @param body
	 *            the new stream body
	 * @return Stream
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             <li>Code 924 : Invalid input data (Bad input data format)</li>
	 *             <li>Code 928 : Invalid input data (Empty input data)</li>
	 *             </ul>
	 */
	public Stream updateStream(String datasourceId, String streamId, Stream body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (datasourceId == null || streamId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Stream) ApiInvoker.deserialize(response, "", Stream.class);
		} else {
			return null;
		}

	}

	/**
	 * Delete a stream
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            stream id to delete
	 * @return
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             <li>Code 923 : Invalid input data</li>
	 *             </ul>
	 */
	public Stream deleteStream(String datasourceId, String streamId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || streamId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (Stream) ApiInvoker.deserialize(response, "", Stream.class);
		} else {
			return null;
		}

	}

	/**
	 * Get all stream values
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            stream id
	 * @param page
	 *            page number (default value 1)
	 * @param size
	 *            page size (default value 10)
	 * @return a values list
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 25 : Invalid input data (Bad input data format)</li>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             <li>Code 923 : Invalid input data</li>
	 *             <li>Code 926 : Invalid input data</li>
	 *             <li>Code 927 : Invalid input data</li>
	 *             </ul>
	 */
	public List<Value> listValues(String datasourceId, String streamId, String page, String size) throws SDKException, HTTPException,
			Exception {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || streamId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}/values".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		if (!"null".equals(String.valueOf(page)))
			queryParams.put("page", String.valueOf(page));
		if (!"null".equals(String.valueOf(size)))
			queryParams.put("size", String.valueOf(size));
		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return (List<Value>) ApiInvoker.deserialize(response, "List", Value.class);
		} else {
			return null;
		}

	}

	/**
	 * Create values, add one or more values in a stream.
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            stream id
	 * @param body
	 *            values list body
	 * @return the values list
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             <li>Code 920 : Invalid input data (Missing field)</li>
	 *             <li>Code 921 : Invalid input data (Invalid data input format)
	 *             </li>
	 *             <li>Code 922 : Invalid input data (Invalid data input format)
	 *             </li>
	 *             <li>Code 928 : Invalid input data (Empty field)</li>
	 *             </ul>
	 */
	public List<Value> createValues(String datasourceId, String streamId, List<Value> body) throws SDKException, HTTPException,
			Exception {
		Object postBody = body;
		// verify required params are set
		if (datasourceId == null || streamId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}/values".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			if ("".equals(response)) {
				return new ArrayList<Value>();
			} else {
				return (List<Value>) ApiInvoker.deserialize(response, "", Value.class);
			}
		} else {
			return null;
		}

	}

	/**
	 * Delete all values in a stream
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            stream id
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             </ul>
	 */
	public void deleteAllStreamValues(String datasourceId, String streamId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || streamId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}/values".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return;
		} else {
			return;
		}

	}

	/**
	 * Delete a value in a stream
	 * 
	 * @param datasourceId
	 *            data-source id
	 * @param streamId
	 *            stream id
	 * @param valueId
	 *            values id to delete
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied</li>
	 *             <li>Code 911 : Resource not found (Data-source not found)</li>
	 *             <li>Code 912 : Resource not found (Stream not found)</li>
	 *             <li>Code 913 : Resource not found (Prototype not found)</li>
	 *             <li>Code 915 : Resource not found (Value not found)</li>
	 *             </ul>
	 */
	public void deleteStreamValue(String datasourceId, String streamId, String valueId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (datasourceId == null || streamId == null || valueId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/datasources/{parent_id}/streams/{stream_id}/values/{value_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "parent_id" + "\\}", apiInvoker.escapeString(datasourceId.toString()))
				.replaceAll("\\{" + "stream_id" + "\\}", apiInvoker.escapeString(streamId.toString()))
				.replaceAll("\\{" + "value_id" + "\\}", apiInvoker.escapeString(valueId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
		if (response != null) {
			return;
		} else {
			return;
		}

	}
}
