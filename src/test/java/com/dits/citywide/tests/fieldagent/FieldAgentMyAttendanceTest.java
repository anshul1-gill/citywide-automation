package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgentMyAttendanceTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void myAttendanceTest() throws InterruptedException {
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		fieldAgentMyAttendancePage = fieldAgentStartShiftPage.clickOnMyAttendanceTab();

		softAssert.assertTrue(fieldAgentMyAttendancePage.getDataBranchName().contains(HRManagementConstants.BRANCHES),
				"Branch name does not match");
		softAssert.assertTrue(fieldAgentMyAttendancePage.getDataSiteOrBeat().contains(HRManagementConstants.SITE),
				"Site or Beat does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataShiftStart(), FieldAgentConstants.SHIFT_START,
				"Shift start time does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataCheckIn(), FieldAgentConstants.CHECK_IN,
				"Check-in time does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataShiftEnd(), FieldAgentConstants.SHIFT_END,
				"Shift end time does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataCheckOut(), FieldAgentConstants.CHECK_OUT,
				"Check-out time does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataShiftHours(), FieldAgentConstants.SHIFT_HOURS,
				"Shift hours do not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataBreakDuration(), FieldAgentConstants.BREAK_DURATION,
				"Break duration does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataActualBreak(), FieldAgentConstants.ACTUAL_BREAK,
				"Actual break does not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataTotalHours(), FieldAgentConstants.TOTAL_HOURS,
				"Total hours do not match");
		softAssert.assertEquals(fieldAgentMyAttendancePage.getDataStatus(), FieldAgentConstants.STATUS,
				"Status does not match");

		softAssert.assertAll();
	}

}
