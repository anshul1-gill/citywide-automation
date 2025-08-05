package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class PatrolStartShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void patrolStartShiftTest() throws InterruptedException {
		// Thread.sleep(500);
		patrolStartShiftPage.handleMessageOfTheWeek();
		// fieldAgentStartShiftPage.doClickTabStartShift();
		patrolStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		softAssert.assertTrue(patrolStartShiftPage.isClickableViewSite(), "View Site button should be clickable");
//		softAssert.assertTrue(patrolStartShiftPage.isStartShiftButtonVisible(), "Start Shift button should be visible");

		softAssert.assertTrue(fieldAgentStartShiftPage.isConfirmShiftButtonVisible(),
				"Confirm Shift button should be visible after clicking Start Shift");

		softAssert.assertTrue(fieldAgentStartShiftPage.isRejectShiftButtonVisible(),
				"Reject Shift button should be visible after clicking Start Shift");

		patrolStartShiftPage.doClickStartShift();
		patrolStartShiftPage.logoutFromPreviousShift();
		softAssert.assertEquals(patrolStartShiftPage.getFieldAgentNameWithWelcome().trim(), "Welcome, "
				+ HRManagementConstants.FIRST_NAME_PATROL + " " + HRManagementConstants.LAST_NAME_PATROL + "!");
		softAssert.assertEquals(patrolStartShiftPage.getWelcomeDescriptionText().trim(),
				FieldAgentConstants.WELCOME_TEXT);
		fieldAgentReportsPage = patrolStartShiftPage.doClickStartShiftBegin();
		fieldAgentStartShiftPage.handlePassdownOfTheDay();

		softAssert.assertTrue(fieldAgentReportsPage.isStartShiftButtonVisible(),
				"Start Shift button should be visible after clicking Start Shift Begin");

		softAssert.assertAll();
	}

}
