package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolConstants;

public class PatrolUpdateLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void updateLeavePatrolTest() throws InterruptedException {
		patrolStartShiftPage.handleMessageOfTheWeek();
		patrolStartShiftPage.clickOnHRManagementMenu();
		patrolLeaveRequestsPage = patrolStartShiftPage.clickOnLeaveRequestsTab();
		patrolLeaveRequestsPage.doClickEditButton(prop.getProperty("patrolID"), PatrolConstants.LEAVE_TYPE);

		patrolLeaveRequestsPage.updateLeaveForm(PatrolConstants.EDIT_LEAVE_TYPE, PatrolConstants.EDIT_LEAVE_FROM_MONTH,
				PatrolConstants.EDIT_LEAVE_FROM_YEAR, PatrolConstants.EDIT_LEAVE_FROM_DATE,
				PatrolConstants.EDIT_LEAVE_START_TIME, PatrolConstants.EDIT_LEAVE_TO_MONTH,
				PatrolConstants.EDIT_LEAVE_TO_YEAR, PatrolConstants.EDIT_LEAVE_TO_DATE,
				PatrolConstants.EDIT_LEAVE_END_TIME, PatrolConstants.EDIT_LEAVE_DESCRIPTION);

		patrolLeaveRequestsPage.doClickUpdateLeave();

		softAssert.assertTrue(patrolLeaveRequestsPage.isAddLeaveRequestButtonDisplayed());

		softAssert.assertEquals(patrolLeaveRequestsPage.getLeaveType(), PatrolConstants.EDIT_LEAVE_TYPE);

		String[] fromDateParts = patrolLeaveRequestsPage.getFromDate();
		softAssert.assertEquals(fromDateParts[0], PatrolConstants.EDIT_LEAVE_FROM_MONTH);
		softAssert.assertEquals(fromDateParts[1], PatrolConstants.EDIT_LEAVE_FROM_DATE);
		softAssert.assertEquals(fromDateParts[2], PatrolConstants.EDIT_LEAVE_FROM_YEAR);

		String[] toDateParts = patrolLeaveRequestsPage.getToDate();
		softAssert.assertEquals(toDateParts[0], PatrolConstants.EDIT_LEAVE_TO_MONTH);
		softAssert.assertEquals(toDateParts[1], PatrolConstants.EDIT_LEAVE_TO_DATE);
		softAssert.assertEquals(toDateParts[2], PatrolConstants.EDIT_LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(patrolLeaveRequestsPage.getTotalDays().trim(), String.valueOf(totalDays));

		softAssert.assertAll();
	}
}
