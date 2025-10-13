package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;
import com.dits.citywide.utilities.ServerTimeUtil;

public class FieldAgentStartShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void startShiftTest() throws InterruptedException {
		// Thread.sleep(500);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		softAssert.assertTrue(fieldAgentStartShiftPage.isViewSiteVisible(), "View Site button should be clickable");
		softAssert.assertTrue(fieldAgentStartShiftPage.isStartShiftButtonVisible(),
				"Start Shift button should be visible");

		fieldAgentStartShiftPage.doClickStartShift();
		String startshiftdatetime = ServerTimeUtil.getServerTimeInPST();
		driverFactory.updatePropertyValue("startShiftDateTime", startshiftdatetime);

		fieldAgentStartShiftPage.logoutFromPreviousShift();
		softAssert.assertEquals(fieldAgentStartShiftPage.getFieldAgentNameWithWelcome().trim(),
				"Welcome, " + HRManagementConstants.FIRST_NAME + " " + HRManagementConstants.LAST_NAME + "!");
		softAssert.assertEquals(fieldAgentStartShiftPage.getWelcomeDescriptionText().trim(),
				FieldAgentConstants.WELCOME_TEXT);
		fieldAgentReportsPage = fieldAgentStartShiftPage.doClickStartShiftBegin();
		fieldAgentStartShiftPage.handlePassdownOfTheDay();

		softAssert.assertTrue(fieldAgentReportsPage.isPreFlightReportsButtonVisible(),
				"Pre-Flight Reports button should be visible");
		softAssert.assertTrue(fieldAgentReportsPage.isStartShiftButtonVisible(),
				"Start Shift button should be visible after clicking Start Shift Begin");

		softAssert.assertAll();
	}

}
