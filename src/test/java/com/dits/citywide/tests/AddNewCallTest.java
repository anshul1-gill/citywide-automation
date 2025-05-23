package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class AddNewCallTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNewCallTest() throws InterruptedException {
		Thread.sleep(4000);
		callsPage = dashboardPage.doClickCallsTab();

		callsPage.doClickAddNewCallButton();
		callsPage.fillAddNewCallForm(HRManagementConstants.OFFICER_RECEIVED_VIA, HRManagementConstants.SITE);
		callsPage.selectAvailableUnits();
		callsPage.doClickSaveAddNewCall();

	}

}
