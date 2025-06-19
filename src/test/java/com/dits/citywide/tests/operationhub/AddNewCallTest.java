package com.dits.citywide.tests.operationhub;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

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
		callsPage.fillAddNewCallForm(OperationsHubConstant.OFFICER_RECEIVED_VIA, HRManagementConstants.SITE);
		callsPage.fillReportingPersonForm(OperationsHubConstant.REPORTING_PERSON_FIRST_NAME,
				OperationsHubConstant.REPORTING_PERSON_LAST_NAME, OperationsHubConstant.REPORTING_PERSON_PHONE_NUMBER);
		callsPage.selectAvailableUnits(prop.getProperty("employeeID"));
		callsPage.doClickSaveAddNewCall();
		Assert.assertEquals(callsPage.getSuccessMessageText(), OperationsHubConstant.CALL_CREATED_SUCCESSFULLY);

		String callId = callsPage.getCallId();
		System.out.println(callId); // Print callID
		driverFactory.updatePropertyValue("callid", callId);
	}

}
