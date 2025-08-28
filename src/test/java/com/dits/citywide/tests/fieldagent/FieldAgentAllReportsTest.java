package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class FieldAgentAllReportsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void endShiftTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentReportsPage = fieldAgentStartShiftPage.clickOnReportsTab();
		fieldAgentReportsPage.clickAllReports();
		fieldAgentReportsPage.enterTextInSearchBox(prop.getProperty("employeeID"));
		fieldAgentReportsPage.clickDropdownColumn();
		fieldAgentReportsPage.selectActivityCode();
		softAssert.assertEquals(fieldAgentReportsPage.getOfficerNameDataStartOfShift(), prop.getProperty("employeeID")
				+ " " + HRManagementConstants.FIRST_NAME + " " + HRManagementConstants.LAST_NAME);
		softAssert.assertEquals(fieldAgentReportsPage.getArriveDataStartOfShift(),
				prop.getProperty("startShiftDateTime"));
		softAssert.assertEquals(fieldAgentReportsPage.getActivityCodeDataStartOfShift(),
				OperationsHubConstant.START_SHIFT_ACTIVITY_CODE);

		softAssert.assertAll();
	}

}
