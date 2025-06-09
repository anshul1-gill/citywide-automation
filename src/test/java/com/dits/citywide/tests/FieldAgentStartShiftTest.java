package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentStartShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void startShiftTest() throws InterruptedException {
		Thread.sleep(500);
		fieldAgentStartShiftPage.btnMarkAsRead();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		softAssert.assertTrue(fieldAgentStartShiftPage.isStartShiftButtonVisible(),
				"Start Shift button should be visible");
		fieldAgentStartShiftPage.doClickStartShift();
		softAssert.assertEquals(fieldAgentStartShiftPage.getFieldAgentNameWithWelcome().trim(),
				"Welcome, " + HRManagementConstants.FIRST_NAME + " " + HRManagementConstants.LAST_NAME + "!");
		softAssert.assertEquals(fieldAgentStartShiftPage.getWelcomeDescriptionText().trim(),
				FieldAgentConstants.WELCOME_TEXT);
		fieldAgentReportsPage = fieldAgentStartShiftPage.doClickStartShiftBegin();
		softAssert.assertTrue(fieldAgentReportsPage.isPreFlightReportsButtonVisible());

		softAssert.assertAll();
	}

}
