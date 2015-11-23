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

import org.junit.BeforeClass;
import org.junit.Test;

import com.orange.datavenue.client.Config;
import com.orange.datavenue.client.api.AccountsApi;
import com.orange.datavenue.client.common.HTTPException;
import com.orange.datavenue.client.common.SDKException;
import com.orange.datavenue.client.model.Account;
import com.orange.datavenue.client.model.AccountsUpdate;
import com.orange.datavenue.client.model.MasterKey;
import com.orange.datavenue.client.model.PrimaryMasterKey;

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

		Account account = accountsApi.getAccount(accountID);
		Assert.assertNotNull(account);
		Assert.assertEquals(accountID, account.getId());

		AccountsUpdate body = new AccountsUpdate();
		
		String firstName = "FirstName_" + (int)(Math.random()*1000);
		String lastName = "LastName_" + (int)(Math.random()*1000);
		String email = firstName + "@datavenue.com";
		
		body.setFirstname(firstName);
		body.setLastname(lastName);
		body.setOpeClientId(Constant.OPE_KEY);
		body.setEmail(email);
		body.setUserPassword(Constant.PASSWORD);

		accountsApi.updateAccount(accountID, body);

		account = accountsApi.getAccount(accountID);
		Assert.assertNotNull(account);
		Assert.assertEquals(accountID, account.getId());
		Assert.assertEquals(firstName, account.getFirstname());
		Assert.assertEquals(lastName, account.getLastname());
		Assert.assertEquals(email, account.getEmail());
	}
	
	@Test
	public void getPMKey() throws SDKException, HTTPException, Exception {
		PrimaryMasterKey pmk = accountsApi.getPrimaryMasterKey(accountID);
		Assert.assertNotNull(pmk);
	}

	@Test
	public void listMasterKey() throws SDKException, HTTPException, Exception {
		List<MasterKey> listMasterKey = accountsApi.listMasterKey(accountID, null, null);
		Assert.assertNotNull(listMasterKey);
		Assert.assertTrue(listMasterKey.size()>0);
	}

	@Test
	public void getOneMasterKey() throws SDKException, HTTPException, Exception {
		List<MasterKey> listMasterKey = accountsApi.listMasterKey(accountID, null, null);
		Assert.assertNotNull(listMasterKey);
		Assert.assertTrue(listMasterKey.size()>0);
		
		MasterKey mk = accountsApi.getMasterKey(accountID, listMasterKey.get(0).getId());
		Assert.assertNotNull(mk);
	}

	@Test
	public void createMasterKey() throws SDKException, HTTPException, Exception {

		MasterKey body = new MasterKey();

		body.setName("Test key");
		body.setDescription("The Test key");
		body.setStatus("activated");
		ArrayList<String> rights = new ArrayList<String>();
		rights.add("GET");
		body.setRights(rights);

		MasterKey newMasterKey = accountsApi.createMasterKey(accountID, body);
		Assert.assertNotNull(newMasterKey);
		
		MasterKey readMasterKey = accountsApi.getMasterKey(accountID, newMasterKey.getId());
		Assert.assertNotNull(readMasterKey);
		Assert.assertEquals(newMasterKey.getId(), readMasterKey.getId());
		
		MasterKey regeneratedMasterKey = accountsApi.regenerateMasterKey(accountID, newMasterKey.getId());
		
		Assert.assertNotNull(regeneratedMasterKey);
		Assert.assertEquals(readMasterKey.getId(), regeneratedMasterKey.getId());
		Assert.assertFalse(readMasterKey.getValue().equals(regeneratedMasterKey.getValue()));
		
		accountsApi.deleteMasterKey(accountID, newMasterKey.getId());
		
		try {
			readMasterKey = accountsApi.getMasterKey(accountID, newMasterKey.getId());
		} catch(HTTPException e) {
			Assert.assertEquals(404, e.getCodeErrorHTTP());
		}
	}

}
