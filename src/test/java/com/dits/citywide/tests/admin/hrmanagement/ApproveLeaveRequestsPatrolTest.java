package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class ApproveLeaveRequestsPatrolTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void approveLeaveRequestsTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		leaveRequestsPage = dashboardPage.doClickLeaveRequests();

		softAssert.assertTrue(leaveRequestsPage.isAddLeaveRequestButtonDisplayed());
		leaveRequestsPage.doSearchLeaveRequest(prop.getProperty("patrolID"));

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

		leaveRequestsPage.doClickApprove(prop.getProperty("patrolID"), PatrolConstants.LEAVE_TYPE);

		softAssert.assertEquals(leaveRequestsPage.getAreYouSureText(),
				HRManagementConstants.POPUP_MESSAGE_ARE_YOU_SURE);
		softAssert.assertEquals(leaveRequestsPage.getApproveLeaveWarningText(),
				HRManagementConstants.POPUP_MESSAGE_ACTION_WILL_APPROVE_LEAVE);
		leaveRequestsPage.doClickOk();
		softAssert.assertEquals(leaveRequestsPage.getApprovedConfirmationMessage(),
				HRManagementConstants.APPROVED_CONFIRMATION_MESSAGE);

		softAssert.assertEquals(
				leaveRequestsPage.getApprovedStatus(prop.getProperty("patrolID"), PatrolConstants.LEAVE_TYPE),
				HRManagementConstants.STATUS_APPROVED);

		softAssert.assertAll();
	}

}
