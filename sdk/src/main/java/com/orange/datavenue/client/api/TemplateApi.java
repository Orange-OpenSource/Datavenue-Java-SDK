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
import com.orange.datavenue.client.model.Template;

/**
 * TemplateApi allows to manage the template API.
 * 
 * @author MELIS Mathieu
 *
 */
public class TemplateApi {

	final String basePath;
	final String opeKey;
	final String XISSKey;

	private static final String PAGE_SIZE_PARAM = "pagesize";
	private static final String PAGE_NUMBER_PARAM = "pagenumber";
	
	ApiInvoker apiInvoker = ApiInvoker.getInstance();

	public TemplateApi(Config config) {
		this.basePath = config.getBaseUrl();
		this.opeKey = config.getOpeKey();
		this.XISSKey =config.getXISSKey();
	}

	/**
	 * Get template with id
	 * 
	 * @param templateId
	 *            template id
	 * @return Template
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied (Account probably disable)</li>
	 *             <li>Code 914 : Resource not found</li>
	 *             </ul>
	 */
	public Template getTemplate(String templateId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (templateId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/templates/{id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(templateId.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);
		
		String contentType =  "application/json";

		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);

		return (Template) ApiInvoker.deserialize(httpResponse.body, "", Template.class);
	}

	/**
	 * Update template informations
	 * 
	 * @param templateId
	 *            template id
	 * @param body
	 *            new template body
	 * @return Template updated
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied (Account probably disable)</li>
	 *             <li>Code 914 : Resource not fount</li>
	 *             <li>Code 924 : Invalid input data</li>
	 *             <li>Code 928 : Invalid input data (Empy field)</li>
	 *             </ul>
	 */
	public void updateTemplate(String templateId, Template body) throws SDKException, HTTPException {
		Object postBody = body;
		// verify required params are set
		if (templateId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/templates/{id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(templateId.toString()));

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
	 * Delete a template with id
	 * 
	 * @param templateId
	 *            template id to delete
	 * @return
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied (Account probably disable)</li>
	 *             <li>Code 914 : Resource not fount</li>
	 *             </ul>
	 */
	public void deleteTemplate(String templateId) throws SDKException, HTTPException {
		Object postBody = null;
		// verify required params are set
		if (templateId == null) {
			throw new SDKException(400, "missing required params");
		}
		// create path and map variables
		String path = "/templates/{id}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(templateId.toString()));

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
	 * Create a template
	 * 
	 * @param body
	 *            the template body
	 * @return the new template
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied (Account probably disable)</li>
	 *             <li>Code 913 : Resource not fount (Prototype not found)</li>
	 *             <li>Code 924 : Invalid input data</li>
	 *             <li>Code 928 : Invalid input data(Empty field)</li>
	 *             </ul>
	 */
	public Template createTemplate(Template body) throws SDKException, HTTPException {
		Object postBody = body;
		// create path and map variables
		String path = "/templates".replaceAll("\\{format\\}", "json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		headerParams.put(ApiInvoker.OPE_KEY_NAME, opeKey);
		headerParams.put("X-ISS-Key", XISSKey);

		String contentType =  "application/json";

		System.out.println(postBody);
		HttpResponse httpResponse = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);

		return (Template) ApiInvoker.deserialize(httpResponse.body, "", Template.class);
	}

	/**
	 * Get all template
	 * 
	 * @param page
	 *            page number (default value 1)
	 * @param size
	 *            page size (default value 10)
	 * @return a templates list
	 * @throws HTTPException
	 *             <ul>
	 *             <li>Code 901 : Access denied (Account probably disable)</li>
	 *             <li>Code 925 : Invalid input data</li>
	 *             </ul>
	 */
	public List<Template> listTemplate(String page, String size) throws SDKException, HTTPException {
		Object postBody = null;
		// create path and map variables
		String path = "/templates/".replaceAll("\\{format\\}", "json");

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

		return (List<Template>) ApiInvoker.deserialize(httpResponse.body, "List", Template.class);
	}
}
