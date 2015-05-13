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

import org.junit.BeforeClass;
import org.junit.Test;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.api.AccountsApi;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.AccountsUpdate;
import com.orange.datavenue.client.model.MasterKey;

public class TestAccount {

	private static final Config cfg = new Config(Constant.OPE_KEY, Constant.PRIMARY_MASTER_KEY);

	private static String accountID = Constant.ACCOUNT_ID;
	private static AccountsApi accountsApi;

	@BeforeClass
	public static void initBeforeTestClass() throws SDKException {
		System.setProperty ("jsse.enableSNIExtension", "false");
		accountsApi = new AccountsApi(cfg);

	}

	@Test
	public void getMyAccount() throws SDKException, HTTPException, Exception {

		accountsApi.getAccount(accountID);

		AccountsUpdate body = new AccountsUpdate();
		body.setFirstname("Mathieu");
		body.setLastname("MELIS");
		body.setOpeClientId(Constant.OPE_KEY);
		body.setEmail("mathieu.melis@orange.com");
		body.setUserPassword(Constant.PASSWORD);

		accountsApi.updateAccount(accountID, body);

		accountsApi.getAccount(accountID);

	}
	
	@Test
	public void getPMKey() throws SDKException, HTTPException, Exception {

		accountsApi.getPrimaryMasterKey(accountID);

	}

	@Test
	public void listAPIKey() throws SDKException, HTTPException, Exception {

		List<MasterKey> listMasterKey = accountsApi.listMasterKey(accountID, null, null);
		System.out.println(listMasterKey);
	}

	@Test
	public void getOneAPIKey() throws SDKException, HTTPException, Exception {

		accountsApi.getMasterKey(accountID, "127acaa62c4942d49d8e4ecbfe26bffa");

	}

	@Test
	public void createAPIKey() throws SDKException, HTTPException, Exception {

		MasterKey body = new MasterKey();

		body.setName("Test key");
		body.setDescription("The Test key");
		body.setStatus("activated");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		body.setRights(rights);

		MasterKey create_AccountsApi_0 = accountsApi.createMasterKey(accountID, body);

		accountsApi.getMasterKey(accountID, create_AccountsApi_0.getId());

		accountsApi.deleteMasterKey(accountID, create_AccountsApi_0.getId());

	}

}
