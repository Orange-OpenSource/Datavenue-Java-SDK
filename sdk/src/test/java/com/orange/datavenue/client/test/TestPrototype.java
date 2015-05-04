/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.api.PrototypeApi;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.ApiKey;
import com.orange.datavenue.client.model.Prototype;
import com.orange.datavenue.client.model.Stream;
import com.orange.datavenue.client.model.Value;

public class TestPrototype {
	
	private static final Config cfg = new Config(Constant.OPE_KEY,Constant.MASTER_KEY);

	
	private static PrototypeApi prototypesApi;

	@BeforeClass
	public static void initBeforeTestClass() throws SDKException {
		System.setProperty ("jsse.enableSNIExtension", "false");
		prototypesApi = new PrototypeApi(cfg);
	}

	@Before
	public void initBeforeEachTest() throws SDKException, HTTPException, Exception {
		List<Prototype> listPrototypes = prototypesApi.listPrototype(null, null);
		if (listPrototypes != null) {
			for (Prototype prototypes : listPrototypes) {
				prototypesApi.deletePrototype(prototypes.getId());
			}
		}
	}

	@Test
	public void getPrototype() throws SDKException, HTTPException, Exception {

		Prototype body = new Prototype();
		body.setName("SODA");
		body.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreation = prototypesApi.createPrototype(body);

		Prototype prototypes = prototypesApi.getPrototype(responseCreation.getId());

		prototypesApi.deletePrototype(responseCreation.getId());

		Assert.assertEquals(body.getName(), prototypes.getName());
	}

	@Test
	public void updatePrototype() throws SDKException, HTTPException, Exception {

		Prototype body = new Prototype();
		body.setName("SODA");
		body.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreation = prototypesApi.createPrototype(body);

		body.setName("SODA2");
		body.setDescription("Prototype 2 de test pour SDK Java");

		prototypesApi.updatePrototype(responseCreation.getId(), body);

		Prototype responseGet = prototypesApi.getPrototype(responseCreation.getId());

		Assert.assertEquals("SODA2", responseGet.getName());

		prototypesApi.deletePrototype(responseCreation.getId());
	}

	@Test
	public void deletePrototype() throws SDKException, HTTPException, Exception {

		Prototype body = new Prototype();
		body.setName("SODA");
		body.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreation = prototypesApi.createPrototype(body);

		prototypesApi.deletePrototype(responseCreation.getId());
		try {
			prototypesApi.getPrototype(responseCreation.getId());

		} catch (HTTPException ex) {
			Assert.assertEquals(ex.getDatavenueError().getCode(), 913);
		}
	}

	@Test
	public void createPrototype() throws SDKException, HTTPException, Exception {

		Prototype body = new Prototype();
		body.setName("SODA");
		body.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreation = prototypesApi.createPrototype(body);

		Prototype prototypes = prototypesApi.getPrototype(responseCreation.getId());

		prototypesApi.deletePrototype(responseCreation.getId());

		Assert.assertEquals(body.getName(), prototypes.getName());

	}

	@Test
	public void listPrototype() throws SDKException, HTTPException, Exception {

		Prototype body = new Prototype();
		body.setName("SODA");
		body.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreation = prototypesApi.createPrototype(body);

		body.setName("SODA2");
		body.setDescription("Prototype 2 de test pour SDK Java");
		Prototype responseCreation2 = prototypesApi.createPrototype(body);

		List<Prototype> list = prototypesApi.listPrototype(null, null);
		prototypesApi.deletePrototype(responseCreation.getId());
		prototypesApi.deletePrototype(responseCreation2.getId());

		Assert.assertEquals(responseCreation2.getName(), list.get(0).getName());
		Assert.assertEquals(responseCreation.getName(), list.get(1).getName());
	}

	@Test
	public void createApiKey() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		ApiKey apiKeyBody = new ApiKey();
		apiKeyBody.setName("SODA");
		apiKeyBody.setDescription("ApiKeys de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		apiKeyBody.setRights(rights);
		ApiKey responseCreationApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);

		ApiKey responseGetApiKey = prototypesApi.getApiKeys(responseCreationPrototype.getId(), responseCreationApiKey.getId());

		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responseCreationApiKey.getName(), responseGetApiKey.getName());

	}

	@Test
	public void getApiKeys() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		ApiKey apiKeyBody = new ApiKey();
		apiKeyBody.setName("SODA");
		apiKeyBody.setDescription("ApiKeys de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		apiKeyBody.setRights(rights);
		ApiKey responseCreationApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);

		ApiKey responseGetApiKey = prototypesApi.getApiKeys(responseCreationPrototype.getId(), responseCreationApiKey.getId());

		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responseCreationApiKey.getName(), responseGetApiKey.getName());
	}

	@Test
	public void listApiKey() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		ApiKey apiKeyBody = new ApiKey();
		apiKeyBody.setName("SODA");
		apiKeyBody.setDescription("ApiKeys de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		apiKeyBody.setRights(rights);
		ApiKey responseCreationApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);

		apiKeyBody.setName("SODA2");
		apiKeyBody.setDescription("ApiKeys 2 de test pour SDK Java");
		apiKeyBody.setRights(rights);
		ApiKey responseCreation2ApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);

		List<ApiKey> listApiKey = prototypesApi.listApiKey(responseCreationPrototype.getId(), null, null);
		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreation2ApiKey.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responseCreationApiKey.getName(), listApiKey.get(0).getName());
		Assert.assertEquals(responseCreation2ApiKey.getName(), listApiKey.get(1).getName());
	}

	@Test
	public void updateApiKeys() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		ApiKey apiKeyBody = new ApiKey();
		apiKeyBody.setName("SODA");
		apiKeyBody.setDescription("ApiKeys de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		apiKeyBody.setRights(rights);
		ApiKey responseCreationApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);

		apiKeyBody.setName("SODA2");

		prototypesApi.updateApiKeys(responseCreationPrototype.getId(), responseCreationApiKey.getId(), apiKeyBody);

		ApiKey responseGetApiKey = prototypesApi.getApiKeys(responseCreationPrototype.getId(), responseCreationApiKey.getId());

		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responseGetApiKey.getName(), "SODA2");
	}

	@Test
	public void deleteApiKey() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		ApiKey apiKeyBody = new ApiKey();
		apiKeyBody.setName("SODA");
		apiKeyBody.setDescription("ApiKeys de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		apiKeyBody.setRights(rights);
		ApiKey responseCreationApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);
		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());
		try {
			prototypesApi.getApiKeys(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		} catch (HTTPException ex) {
			Assert.assertEquals(ex.getDatavenueError().getCode(), 916);
		}
	}

	@Test
	public void regenerateApiKey() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		ApiKey apiKeyBody = new ApiKey();
		apiKeyBody.setName("SODA");
		apiKeyBody.setDescription("ApiKeys de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		apiKeyBody.setRights(rights);
		ApiKey responseCreationApiKey = prototypesApi.createApiKey(responseCreationPrototype.getId(), apiKeyBody);
		ApiKey responseRegenerateApiKey = prototypesApi.regenerateApiKey(responseCreationPrototype.getId(),
				responseCreationApiKey.getId());

		prototypesApi.deleteApiKey(responseCreationPrototype.getId(), responseCreationApiKey.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertFalse(responseCreationApiKey.getValue() == responseRegenerateApiKey.getValue());

	}

	@Test
	public void listStreams() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);
		streamBody.setName("SODA2");
		Stream responsePost2Sreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);
		List<Stream> responseGetAllSreams = prototypesApi.listStreams(responseCreationPrototype.getId(), null, null);

		prototypesApi.deleteStream(responseCreationPrototype.getId(), responsePostSreams.getId());
		prototypesApi.deleteStream(responseCreationPrototype.getId(), responsePost2Sreams.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responsePostSreams.getName(), responseGetAllSreams.get(1).getName());
		Assert.assertEquals(responsePost2Sreams.getName(), responseGetAllSreams.get(0).getName());
	}

	@Test
	public void createStream() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);
		Stream responseGetSreams = prototypesApi.getStreams(responseCreationPrototype.getId(), responsePostSreams.getId());

		prototypesApi.deleteStream(responseCreationPrototype.getId(), responsePostSreams.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responseGetSreams.getName(), "SODA");

	}

	@Test
	public void getStreams() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);
		Stream responseGetSreams = prototypesApi.getStreams(responseCreationPrototype.getId(), responsePostSreams.getId());

		prototypesApi.deleteStream(responseCreationPrototype.getId(), responsePostSreams.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(responseGetSreams.getName(), "SODA");
	}

	@Test
	public void updateStream() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);

		streamBody.setName("SODA2");
		prototypesApi.updateStream(responseCreationPrototype.getId(), responsePostSreams.getId(), streamBody);

		Stream responseGetSreams = prototypesApi.getStreams(responseCreationPrototype.getId(), responsePostSreams.getId());

		prototypesApi.deleteStream(responseCreationPrototype.getId(), responsePostSreams.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertFalse(responsePostSreams.getName() == responseGetSreams.getName());
	}

	@Test
	public void deleteStream() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);
		prototypesApi.deleteStream(responseCreationPrototype.getId(), responsePostSreams.getId());
		try {
			prototypesApi.getStreams(responseCreationPrototype.getId(), responsePostSreams.getId());
		} catch (HTTPException ex) {
			Assert.assertEquals(ex.getDatavenueError().getCode(), 912);
		}

	}

	@Test
	public void listValue() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);
		prototypesApi.createValue(responseCreationPrototype.getId(), responsePostSreams.getId(), valuesBody);
		List<Value> listValues = prototypesApi.listValue(responseCreationPrototype.getId(), responsePostSreams.getId(), null, null);
		prototypesApi.deletePrototype(responseCreationPrototype.getId());

		Assert.assertEquals(value.getValue(), listValues.get(0).getValue());
	}

	@Test
	public void createValue() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		prototypesApi.listPrototype(null, null);
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);
		prototypesApi.createValue(responseCreationPrototype.getId(), responsePostSreams.getId(), valuesBody);
		List<Value> listValues = prototypesApi.listValue(responseCreationPrototype.getId(), responsePostSreams.getId(), null, null);
		prototypesApi.deletePrototype(responseCreationPrototype.getId());
		Assert.assertEquals(value.getValue(), listValues.get(0).getValue());

	}

	@Test
	public void deleteAllStreamValues() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);
		prototypesApi.createValue(responseCreationPrototype.getId(), responsePostSreams.getId(), valuesBody);
		prototypesApi.deleteAllStreamValues(responseCreationPrototype.getId(), responsePostSreams.getId());
		prototypesApi.deletePrototype(responseCreationPrototype.getId());
	}

	@Test
	public void deleteStreamValue() throws SDKException, HTTPException, Exception {

		Prototype prototypeBody = new Prototype();
		prototypeBody.setName("SODA");
		prototypeBody.setDescription("Prototype de test pour SDK Java");
		Prototype responseCreationPrototype = prototypesApi.createPrototype(prototypeBody);

		Stream streamBody = new Stream();
		streamBody.setName("SODA");
		Stream responsePostSreams = prototypesApi.createStream(responseCreationPrototype.getId(), streamBody);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);
		value.setValue(12);
		valuesBody.add(value);
		prototypesApi.createValue(responseCreationPrototype.getId(), responsePostSreams.getId(), valuesBody);
		List<Value> values = prototypesApi.listValue(responseCreationPrototype.getId(), responsePostSreams.getId(), null, null);
		prototypesApi.deleteStreamValue(responseCreationPrototype.getId(), responsePostSreams.getId(), values.get(0).getId());
		values = prototypesApi.listValue(responseCreationPrototype.getId(), responsePostSreams.getId(), null, null);
		prototypesApi.deletePrototype(responseCreationPrototype.getId());
		Assert.assertEquals(values.size(), 1);

	}
}
