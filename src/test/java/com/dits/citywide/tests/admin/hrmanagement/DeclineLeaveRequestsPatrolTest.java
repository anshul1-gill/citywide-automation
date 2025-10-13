package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class DeclineLeaveRequestsPatrolTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void declineLeaveRequestsTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		leaveRequestsPage = dashboardPage.doClickLeaveRequests();

		softAssert.assertTrue(leaveRequestsPage.isAddLeaveRequestButtonDisplayed());

		softAssert.assertEquals(leaveRequestsPage.getLeaveTypeText(), PatrolConstants.LEAVE_TYPE);

		String[] fromDateParts = leaveRequestsPage.getFromDateText();
		softAssert.assertEquals(fromDateParts[0], PatrolConstants.LEAVE_FROM_MONTH);
		softAssert.assertEquals(fromDateParts[1], PatrolConstants.LEAVE_FROM_DATE);
		softAssert.assertEquals(fromDateParts[2], PatrolConstants.LEAVE_FROM_YEAR);

		String[] toDateParts = leaveRequestsPage.getToDateText();
		softAssert.assertEquals(toDateParts[0], PatrolConstants.LEAVE_TO_MONTH);
		softAssert.assertEquals(toDateParts[1], PatrolConstants.LEAVE_TO_DATE);
		softAssert.assertEquals(toDateParts[2], PatrolConstants.LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(leaveRequestsPage.getTotalDaysText().trim(), String.valueOf(totalDays));

		leaveRequestsPage.doClickDecline(prop.getProperty("patrolID"), PatrolConstants.LEAVE_TYPE);
		softAssert.assertEquals(leaveRequestsPage.getDeclineValidationMessage(),
				HRManagementConstants.LEAVE_CANCEL_VALIDATION_MESSAGE);

		leaveRequestsPage.doEnterDeclinedReason(HRManagementConstants.DECLINE_REASON);
		leaveRequestsPage.doClickSubmitDecline();

		softAssert.assertEquals(leaveRequestsPage.getCancelConfirmationMessage(),
				HRManagementConstants.DECLINED_CONFIRMATION_MESSAGE);

		softAssert.assertEquals(
				leaveRequestsPage.getDeclinedStatus(prop.getProperty("patrolID"), PatrolConstants.LEAVE_TYPE),
				HRManagementConstants.STATUS_DECLINED);
		softAssert.assertAll();
	}

}
