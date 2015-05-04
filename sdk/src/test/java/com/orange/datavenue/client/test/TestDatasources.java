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

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.api.DatasourcesApi;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.ApiKey;
import com.orange.datavenue.client.model.Datasource;
import com.orange.datavenue.client.model.HasId;
import com.orange.datavenue.client.model.Stream;
import com.orange.datavenue.client.model.Value;

public class TestDatasources {
	
	private static final Config cfg = new Config(Constant.OPE_KEY,Constant.MASTER_KEY);
	
	private static DatasourcesApi datasourcesApi = null;

	@BeforeClass
	public static void initBeforeTestClass() throws SDKException {
		System.setProperty ("jsse.enableSNIExtension", "false");
		datasourcesApi = new DatasourcesApi(cfg);
	}

	@Before
	public void initBeforeEachTest() throws SDKException, HTTPException, Exception {

		List<Datasource> listDatasources = datasourcesApi.listDatasource(null, null);
		if (listDatasources != null) {
			for (HasId datasource : listDatasources) {
				datasourcesApi.deleteDatasource(datasource.getId());
			}
		}
	}

	@Test
	public void listDatasource() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreate = datasourcesApi.createDatasource(bodyDatasource);

		bodyDatasource.setName("SODA2");
		bodyDatasource.setDescription("Datasource 2 de test pour SDK Java");

		HasId responseCreate2 = datasourcesApi.createDatasource(bodyDatasource);

		List<Datasource> listDatasource = datasourcesApi.listDatasource(null, null);

		datasourcesApi.deleteDatasource(responseCreate.getId());
		datasourcesApi.deleteDatasource(responseCreate2.getId());

		Assert.assertEquals(listDatasource.get(1).getName(), "SODA");
		Assert.assertEquals(listDatasource.get(0).getName(), "SODA2");
	}

	@Test
	public void getDatasource() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		Datasource responseCreate = datasourcesApi.createDatasource(bodyDatasource);

		Datasource responseGet = datasourcesApi.getDatasource(responseCreate.getId());

		datasourcesApi.deleteDatasource(responseCreate.getId());

		Assert.assertEquals(responseCreate.getName(), responseGet.getName());
	}

	@Test
	public void updateDatasource() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreate = datasourcesApi.createDatasource(bodyDatasource);

		bodyDatasource.setName("SODA2");
		bodyDatasource.setDescription("Datasource 2 de test pour SDK Java");

		datasourcesApi.updateDatasource(responseCreate.getId(), bodyDatasource);

		Datasource responseGet = datasourcesApi.getDatasource(responseCreate.getId());

		datasourcesApi.deleteDatasource(responseCreate.getId());

		Assert.assertEquals(responseGet.getName(), "SODA2");
	}

	@Test
	public void deleteDatasource() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreate = datasourcesApi.createDatasource(bodyDatasource);

		datasourcesApi.deleteDatasource(responseCreate.getId());
		try {
			datasourcesApi.getDatasource(responseCreate.getId());
		} catch (HTTPException ex) {
			Assert.assertEquals(ex.getDatavenueError().getCode(), 911);
		}
	}

	@Test
	public void createDatasource() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		Datasource responseCreate = datasourcesApi.createDatasource(bodyDatasource);

		Datasource responseGet = datasourcesApi.getDatasource(responseCreate.getId());

		datasourcesApi.deleteDatasource(responseCreate.getId());

		Assert.assertEquals(responseCreate.getName(), responseGet.getName());

	}

	@Test
	public void createApiKey() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		ApiKey bodyApiKey = new ApiKey();
		bodyApiKey.setName("SODA");
		bodyApiKey.setDescription("ApiKey de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		bodyApiKey.setRights(rights);
		ApiKey responseCreateApiKey = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);

		ApiKey responseGetApiKey = datasourcesApi.getApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());

		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseCreateApiKey.getName(), responseGetApiKey.getName());
	}

	@Test
	public void listApiKey() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		ApiKey bodyApiKey = new ApiKey();
		bodyApiKey.setName("SODA");
		bodyApiKey.setDescription("ApiKey de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		bodyApiKey.setRights(rights);
		ApiKey responseCreateApiKey = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);

		bodyApiKey.setName("SODA2");
		bodyApiKey.setDescription("ApiKey 2 de test pour SDK Java");
		ApiKey responseCreateApiKey2 = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);

		List<ApiKey> responseListApiKey = datasourcesApi.listApiKey(responseCreateDatasource.getId(), null, null);

		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey2.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseListApiKey.get(0).getName(), "SODA");
		Assert.assertEquals(responseListApiKey.get(1).getName(), "SODA2");
	}

	@Test
	public void deleteApiKey() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		ApiKey bodyApiKey = new ApiKey();
		bodyApiKey.setName("SODA");
		bodyApiKey.setDescription("ApiKey de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		bodyApiKey.setRights(rights);
		ApiKey responseCreateApiKey = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);

		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());
		try {
			datasourcesApi.getApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		} catch (HTTPException ex) {
			Assert.assertEquals(ex.getDatavenueError().getCode(), 916);
		}
	}

	@Test
	public void getApiKey() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		ApiKey bodyApiKey = new ApiKey();
		bodyApiKey.setName("SODA");
		bodyApiKey.setDescription("ApiKey de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		bodyApiKey.setRights(rights);
		ApiKey responseCreateApiKey = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);

		ApiKey responseGetApiKey = datasourcesApi.getApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());

		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseCreateApiKey.getName(), responseGetApiKey.getName());
	}

	@Test
	public void updateApiKey() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		ApiKey bodyApiKey = new ApiKey();
		bodyApiKey.setName("SODA");
		bodyApiKey.setDescription("ApiKey de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		bodyApiKey.setRights(rights);
		ApiKey responseCreateApiKey = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);

		bodyApiKey.setName("SODA2");
		bodyApiKey.setDescription("ApiKey 2 de test pour SDK Java");
		datasourcesApi.updateApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId(), bodyApiKey);

		ApiKey responseGetApiKey = datasourcesApi.getApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());

		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseGetApiKey.getName(), "SODA2");
	}

	@Test
	public void regenerateApiKey() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		ApiKey bodyApiKey = new ApiKey();
		bodyApiKey.setName("SODA");
		bodyApiKey.setDescription("ApiKey de test pour SDK Java");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		rights.add("POST");
		rights.add("PUT");
		rights.add("DELETE");
		bodyApiKey.setRights(rights);
		ApiKey responseCreateApiKey = datasourcesApi.createApiKey(responseCreateDatasource.getId(), bodyApiKey);
		ApiKey responseRegenerateApiKey = datasourcesApi.regenerateApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());

		datasourcesApi.deleteApiKey(responseCreateDatasource.getId(), responseCreateApiKey.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertFalse(responseCreateApiKey.getValue() == responseRegenerateApiKey.getValue());
	}

	@Test
	public void listStreams() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		bodyStream.setName("SODA2");
		bodyStream.setDescription("Stream 2 de test pour SDK Java");

		Stream responseCreateStream2 = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		List<Stream> responseListStream = datasourcesApi.listStreams(responseCreateDatasource.getId(), null, null);

		datasourcesApi.deleteStream(responseCreateDatasource.getId(), responseCreateStream.getId());
		datasourcesApi.deleteStream(responseCreateDatasource.getId(), responseCreateStream2.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseListStream.get(1).getName(), "SODA");
		Assert.assertEquals(responseListStream.get(0).getName(), "SODA2");
	}

	@Test
	public void createStream() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		Stream responseGetStream = datasourcesApi.getStream(responseCreateDatasource.getId(), responseCreateStream.getId());

		datasourcesApi.deleteStream(responseCreateDatasource.getId(), responseCreateStream.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseGetStream.getName(), "SODA");
	}

	@Test
	public void getStream() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		Stream responseGetStream = datasourcesApi.getStream(responseCreateDatasource.getId(), responseCreateStream.getId());

		datasourcesApi.deleteStream(responseCreateDatasource.getId(), responseCreateStream.getId());
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());

		Assert.assertEquals(responseGetStream.getName(), "SODA");
	}

	@Test
	public void updateStream() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		bodyStream.setName("SODA2");
		bodyStream.setDescription("Stream 2 de test pour SDK Java");

		datasourcesApi.updateStream(responseCreateDatasource.getId(), responseCreateStream.getId(), bodyStream);

		Stream responseGetStream = datasourcesApi.getStream(responseCreateDatasource.getId(), responseCreateStream.getId());

		Assert.assertEquals(responseGetStream.getName(), "SODA2");
	}

	@Test
	public void deleteStream() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		datasourcesApi.deleteStream(responseCreateDatasource.getId(), responseCreateStream.getId());

		try {
			datasourcesApi.getStream(responseCreateDatasource.getId(), responseCreateStream.getId());
		} catch (HTTPException ex) {
			Assert.assertEquals(ex.getDatavenueError().getCode(), 912);
		}
		datasourcesApi.deleteDatasource(responseCreateDatasource.getId());
	}

	@Test
	public void listValues() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);

		datasourcesApi.createValues(responseCreateDatasource.getId(), responseCreateStream.getId(), valuesBody);

		List<Value> responseListValues = datasourcesApi.listValues(responseCreateDatasource.getId(), responseCreateStream.getId(), null,
				null);

		Assert.assertEquals(responseListValues.get(0).getValue(), value.getValue());
	}

	@Test
	public void createValues() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);

		datasourcesApi.createValues(responseCreateDatasource.getId(), responseCreateStream.getId(), valuesBody);

		List<Value> responseListValues = datasourcesApi.listValues(responseCreateDatasource.getId(), responseCreateStream.getId(), null,
				null);

		Assert.assertEquals(responseListValues.get(0).getValue(), value.getValue());

	}

	@Test
	public void deleteAllStreamValues() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);
		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);

		datasourcesApi.createValues(responseCreateDatasource.getId(), responseCreateStream.getId(), valuesBody);
		datasourcesApi.deleteAllStreamValues(responseCreateDatasource.getId(), responseCreateStream.getId());
	}

	@Test
	public void deleteStreamValue() throws SDKException, HTTPException, Exception {

		Datasource bodyDatasource = new Datasource();
		bodyDatasource.setName("SODA");
		bodyDatasource.setDescription("Datasource de test pour SDK Java");

		HasId responseCreateDatasource = datasourcesApi.createDatasource(bodyDatasource);

		Stream bodyStream = new Stream();
		bodyStream.setName("SODA");
		bodyStream.setDescription("Stream de test pour SDK Java");

		Stream responseCreateStream = datasourcesApi.createStream(responseCreateDatasource.getId(), bodyStream);

		Value value = new Value();
		value.setValue(10);
		ArrayList<Value> valuesBody = new ArrayList<Value>();
		valuesBody.add(value);
		value.setValue(12);
		valuesBody.add(value);
		datasourcesApi.createValues(responseCreateDatasource.getId(), responseCreateStream.getId(), valuesBody);
		List<Value> responseListValues = datasourcesApi.listValues(responseCreateDatasource.getId(), responseCreateStream.getId(), null,
				null);
		datasourcesApi.deleteStreamValue(responseCreateDatasource.getId(), responseCreateStream.getId(), responseListValues.get(0)
				.getId());

		responseListValues = datasourcesApi.listValues(responseCreateDatasource.getId(), responseCreateStream.getId(), null, null);
		Assert.assertEquals(responseListValues.size(), 1);
	}
}
