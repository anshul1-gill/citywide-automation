package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;

public class FieldAgentAddPatrolLogsForCallTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void addPatrolLogsForCallTest() throws InterruptedException {
		Thread.sleep(2000);
		fieldAgentCallsPage = fieldAgentStartShiftPage.doClickCallsTab();
		fieldAgentCallsPage.doClickAddPatrolLogsForCall(prop.getProperty("callid"));
		fieldAgentCallsPage.fillNewOfficerReportEntry(OperationsHubConstant.ARRIVE_DATE,
				OperationsHubConstant.ARRIVE_TIME, OperationsHubConstant.DEPART_DATE, OperationsHubConstant.DEPART_TIME,
				OperationsHubConstant.ACTIVITY_CODE, OperationsHubConstant.STREET_NUMBER,
				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK);
		softAssert.assertTrue(fieldAgentCallsPage.isAreYouSureTextVisible());
		softAssert.assertEquals(fieldAgentCallsPage.getConfirmationText(),
				OperationsHubConstant.REPORT_CONFRIMATION_MESSAGE);
		fieldAgentCallsPage.doClickOk();

		softAssert.assertAll();
	}

}
