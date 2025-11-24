package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolConstants;

public class PatrolApplyLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void applyLeavePatrolTest() throws InterruptedException {
		patrolStartShiftPage.handleMessageOfTheWeek();
		Thread.sleep(2000);
		patrolStartShiftPage.clickOnHRManagementMenu();
		patrolLeaveRequestsPage = patrolStartShiftPage.clickOnLeaveRequestsTab();
		patrolLeaveRequestsPage.clickAddLeaveRequest();
		patrolLeaveRequestsPage.fillApplyLeaveForm(PatrolConstants.LEAVE_TYPE, PatrolConstants.LEAVE_FROM_MONTH,
				PatrolConstants.LEAVE_FROM_YEAR, PatrolConstants.LEAVE_FROM_DATE, PatrolConstants.LEAVE_START_TIME,
				PatrolConstants.LEAVE_TO_MONTH, PatrolConstants.LEAVE_TO_YEAR, PatrolConstants.LEAVE_TO_DATE,
				PatrolConstants.LEAVE_END_TIME, PatrolConstants.LEAVE_DESCRIPTION);
		patrolLeaveRequestsPage.doApplyLeave();

		patrolLeaveRequestsPage.applyDefaultDateFilters();

		softAssert.assertTrue(patrolLeaveRequestsPage.isAddLeaveRequestButtonDisplayed());

		softAssert.assertEquals(patrolLeaveRequestsPage.getLeaveType(), PatrolConstants.LEAVE_TYPE);

		String[] fromDateParts = patrolLeaveRequestsPage.getFromDate();
		softAssert.assertEquals(fromDateParts[0], PatrolConstants.LEAVE_FROM_MONTH);
		softAssert.assertEquals(fromDateParts[1], PatrolConstants.LEAVE_FROM_DATE);
		softAssert.assertEquals(fromDateParts[2], PatrolConstants.LEAVE_FROM_YEAR);

		String[] toDateParts = patrolLeaveRequestsPage.getToDate();
		softAssert.assertEquals(toDateParts[0], PatrolConstants.LEAVE_TO_MONTH);
		softAssert.assertEquals(toDateParts[1], PatrolConstants.LEAVE_TO_DATE);
		softAssert.assertEquals(toDateParts[2], PatrolConstants.LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(patrolLeaveRequestsPage.getTotalDays().trim(), String.valueOf(totalDays));

		softAssert.assertAll();
	}

}