/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.common.ApiInvoker;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.HttpResponse;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.Account;
import com.orange.datavenue.client.model.AccountsUpdate;
import com.orange.datavenue.client.model.MasterKey;
import com.orange.datavenue.client.model.PrimaryMasterKey;

public class AccountsApi {
	final String basePath;
	final String opeKey;
	final String XISSKey;

	private static final String PAGE_SIZE_PARAM = "pagesize";
	private static final String PAGE_NUMBER_PARAM = "pagenumber";
	
	ApiInvoker apiInvoker = ApiInvoker.getInstance();

	public AccountsApi(Config config) {
		this.basePath = config.getBaseUrl();
		this.opeKey = config.getOpeKey();
		this.XISSKey = config.getXISSKey();
	}

	public ApiInvoker getInvoker() {
		return apiInvoker;
	}

	
	/**
	 * Retrieve account data by id
	 * 
	 * @param accountId id of the account you want to retrieve
	 * @return Account with the given id
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public Account getAccount(String accountId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "account_id" + "\\}",
				apiInvoker.escapeString(accountId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (Account) ApiInvoker.deserialize(response.body, "", Account.class);
	}

	/**
	 * Update the given account data
	 * 
	 * @param accountId Id of the account you want to update
	 * @param body Modified element of the account
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public void updateAccount(String accountId, AccountsUpdate body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (accountId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "account_id" + "\\}",
				apiInvoker.escapeString(accountId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType);
	}

	/**
	 * Regenerate primary master key for the given account
	 * 
	 * @param accountId Account id of the primary master key you want to regenerate
	 * @return New generated master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public PrimaryMasterKey regeneratePrimaryMasterKey(String accountId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/pmkey/regenerate".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "account_id" + "\\}",
				apiInvoker.escapeString(accountId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (PrimaryMasterKey) ApiInvoker.deserialize(httpResponse.body, "", PrimaryMasterKey.class);
	}

	/**
	 * Retrieve the primary master key of the given account
	 * 
	 * @param accountId account id associated to the master key
	 * @return primary master key of the given account
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public PrimaryMasterKey getPrimaryMasterKey(String accountId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/pmkey".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "account_id" + "\\}",
				apiInvoker.escapeString(accountId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (PrimaryMasterKey) ApiInvoker.deserialize(httpResponse.body, "", PrimaryMasterKey.class);
	}

	
	/**
	 * List account master keys
	 * 
	 * @param accountId Account id of the listed master key
	 * @param page optional page number
	 * @param size optional size of the page
	 * @return List of account master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public List<MasterKey> listMasterKey(String accountId, String page, String size) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/keys".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "account_id" + "\\}",
				apiInvoker.escapeString(accountId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		if (!"null".equals(String.valueOf(page)))
			queryParams.put(PAGE_NUMBER_PARAM, String.valueOf(page));
		if (!"null".equals(String.valueOf(size)))
			queryParams.put(PAGE_SIZE_PARAM, String.valueOf(size));
		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (List<MasterKey>) ApiInvoker.deserialize(httpResponse.body, "List", MasterKey.class);
	}

	/**
	 * Create a master key for the given account
	 * 
	 * @param accountId account id to create the master key for
	 * @param body master key description and rights
	 * @return Created master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public MasterKey createMasterKey(String accountId, MasterKey body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (accountId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/keys".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "account_id" + "\\}",
				apiInvoker.escapeString(accountId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);

		return (MasterKey) ApiInvoker.deserialize(httpResponse.body, "", MasterKey.class);
	}

	/**
	 * Update a master key with the given id of a specified account
	 * 
	 * @param accountId associated account id of the master key 
	 * @param keyId master key identifier
	 * @param body modification to be done
	 * @return Updated master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public MasterKey updateMasterKey(String accountId, String keyId, MasterKey body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (accountId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/keys/{key_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "account_id" + "\\}", apiInvoker.escapeString(accountId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType);

		return (MasterKey) ApiInvoker.deserialize(httpResponse.body, "", MasterKey.class);
	}

	/**
	 * 
	 * Delete a master key from an account
	 * 
	 * @param accountId accound id of the master key
	 * @param keyId identifier of the master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public void deleteMasterKey(String accountId, String keyId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/keys/{key_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "account_id" + "\\}", apiInvoker.escapeString(accountId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType);
	}

	/**
	 * Retrieve master key description
	 * 
	 * @param accountId account id associated to the master key
	 * @param keyId id of the master key
	 * @return Description of the master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public MasterKey getMasterKey(String accountId, String keyId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/keys/{key_id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "account_id" + "\\}", apiInvoker.escapeString(accountId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (MasterKey) ApiInvoker.deserialize(httpResponse.body, "", MasterKey.class);
	}

	/**
	 * Regenerate a given master key
	 * 
	 * @param accountId account id associated to the master key
	 * @param keyId id of the master key to regenerate
	 * @return new generated master key
	 * @throws SDKException Exception before calling the webservice
	 * @throws HTTPException Exception returned by the webservice
	 */
	public MasterKey regenerateMasterKey(String accountId, String keyId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (accountId == null || keyId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/accounts/{account_id}/keys/{key_id}/regenerate".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "account_id" + "\\}", apiInvoker.escapeString(accountId.toString()))
				.replaceAll("\\{" + "key_id" + "\\}", apiInvoker.escapeString(keyId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (MasterKey) ApiInvoker.deserialize(httpResponse.body, "", MasterKey.class);
	}
}
