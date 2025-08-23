package com.dits.citywide.tests.operationhub;

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
		callsPage.fillAddNewCallForm(OperationsHubConstant.OFFICER_RECEIVED_VIA, HRManagementConstants.SITE,
				OperationsHubConstant.ACTIVITY_CODE);
		callsPage.fillReportingPersonForm(OperationsHubConstant.REPORTING_PERSON_FIRST_NAME,
				OperationsHubConstant.REPORTING_PERSON_LAST_NAME, OperationsHubConstant.REPORTING_PERSON_PHONE_NUMBER,
				OperationsHubConstant.REPORTING_PERSON_DEMEANOR);
		callsPage.doClickSameAsAboveAddress();
		callsPage.doClickCollapseSuspectDescription();
		callsPage.fillSuspectDescriptionForm(OperationsHubConstant.SUSPECT_NAME, OperationsHubConstant.SUSPECT_GENDER,
				OperationsHubConstant.SUSPECT_RACE, OperationsHubConstant.SUSPECT_HAIR_TYPE,
				OperationsHubConstant.SUSPECT_HAIR_COLOR, OperationsHubConstant.SUSPECT_EYE_COLOR,
				OperationsHubConstant.SUSPECT_HEIGHT, OperationsHubConstant.SUSPECT_BUILD,
				OperationsHubConstant.SUSPECT_WEIGHT, OperationsHubConstant.SUSPECT_AGE,
				OperationsHubConstant.SUSPECT_CLOTHING_WORN, OperationsHubConstant.SUSPECT_LAST_KNOWN_DIRECTION);
		callsPage.fillCallDescription(OperationsHubConstant.CALL_DESCRIPTION);
		callsPage.selectAvailableUnits(prop.getProperty("employeeID"));
		callsPage.doClickSaveAddNewCall();
		softAssert.assertTrue(callsPage.isOpenCallsTabDisplayed(),
				"Open Calls tab is not displayed after adding a new call.");
		softAssert.assertTrue(callsPage.isClosedCallsTabDisplayed(),
				"Closed Calls tab is not displayed after adding a new call.");
		softAssert.assertEquals(callsPage.getActivityCode(), OperationsHubConstant.ACTIVITY_CODE,
				"Activity code does not match after adding a new call.");
		softAssert.assertTrue(callsPage.getSite().contains(HRManagementConstants.SITE),
				"Patrol site does not match after adding a new call.");
		softAssert.assertTrue(callsPage.getAssignedTo().contains(prop.getProperty("employeeID")),
				"Assigned officer does not match after adding a new call.");

		String callId = callsPage.getCallId(prop.getProperty("employeeID"));
		System.out.println(callId);
		driverFactory.updatePropertyValue("callid", callId);

		softAssert.assertAll();
	}

}
