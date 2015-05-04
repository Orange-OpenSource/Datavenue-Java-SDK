/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.api.TemplateApi;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.Template;

public class TestTemplate {
	
	private static final Config cfg = new Config(Constant.OPE_KEY,Constant.MASTER_KEY);
	
	private static TemplateApi templateApi;

	@BeforeClass
	public static void initBeforeTestClass() throws SDKException, HTTPException, Exception {
		System.setProperty ("jsse.enableSNIExtension", "false");
		templateApi = new TemplateApi(cfg);

	}

	@Before
	public void initBeforeEachTest() throws SDKException, HTTPException, Exception {

		List<Template> listTemplates = templateApi.listTemplate(null, null);
		if (listTemplates != null) {
			for (Template template : listTemplates) {
				templateApi.deleteTemplate(template.getId());
			}
		}
	}

	@Test
	public void getTemplate() throws SDKException, HTTPException, Exception {

		Template templateBody = new Template();
		templateBody.setName("SODA");
		templateBody.setDescription("Template de test pour SDK Java");
		Template responseCreate = templateApi.createTemplate(templateBody);

		Template responseGet = templateApi.getTemplate(responseCreate.getId());

		templateApi.deleteTemplate(responseCreate.getId());

		Assert.assertEquals(responseCreate.getName(), responseGet.getName());
	}

	@Test
	public void updateTemplate() throws SDKException, HTTPException, Exception {

		Template templateBody = new Template();
		templateBody.setName("SODA");
		templateBody.setDescription("Template de test pour SDK Java");
		Template responseCreate = templateApi.createTemplate(templateBody);

		templateBody.setName("SODA2");
		templateBody.setDescription("Template 2 de test pour SDK Java");
		templateApi.updateTemplate(responseCreate.getId(), templateBody);

		Template responseGet = templateApi.getTemplate(responseCreate.getId());

		templateApi.deleteTemplate(responseCreate.getId());

		Assert.assertEquals(responseGet.getName(), "SODA2");
	}

	@Test
	public void deleteTemplate() throws SDKException, HTTPException, Exception {

		Template templateBody = new Template();
		templateBody.setName("SODA");
		templateBody.setDescription("Template de test pour SDK Java");
		Template responseCreate = templateApi.createTemplate(templateBody);

		templateApi.deleteTemplate(responseCreate.getId());
		try {
			templateApi.getTemplate(responseCreate.getId());
		} catch (HTTPException e) {
			Assert.assertEquals(e.getDatavenueError().getCode(), 914);
		}
	}

	@Test
	public void createTemplate() throws SDKException, HTTPException, Exception {

		Template templateBody = new Template();
		templateBody.setName("SODA");
		templateBody.setDescription("Template de test pour SDK Java");
		Template responseCreate = templateApi.createTemplate(templateBody);

		Template responseGet = templateApi.getTemplate(responseCreate.getId());

		templateApi.deleteTemplate(responseCreate.getId());

		Assert.assertEquals(responseCreate.getName(), responseGet.getName());

	}

	@Test
	public void listTemplate() throws SDKException, HTTPException, Exception {

		Template templateBody = new Template();
		templateBody.setName("SODA");
		templateBody.setDescription("Template de test pour SDK Java");
		Template responseFirstCreate = templateApi.createTemplate(templateBody);

		templateBody.setName("SODA2");
		templateBody.setDescription("Template 2 de test pour SDK Java");
		Template responseSecondCreate = templateApi.createTemplate(templateBody);

		List<Template> responseList = templateApi.listTemplate(null, null);

		templateApi.deleteTemplate(responseFirstCreate.getId());
		templateApi.deleteTemplate(responseSecondCreate.getId());

		Assert.assertEquals(responseList.get(1).getName(), "SODA");
		Assert.assertEquals(responseList.get(0).getName(), "SODA2");

	}
}
