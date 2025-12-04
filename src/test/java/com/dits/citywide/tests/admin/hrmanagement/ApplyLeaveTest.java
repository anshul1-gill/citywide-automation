package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ApplyLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void applyLeaveTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		leaveRequestsPage = dashboardPage.doClickLeaveRequests();
		applyLeavePage = leaveRequestsPage.doClickApplyLeave();
		leaveRequestsPage = applyLeavePage.fillApplyLeaveForm(HRManagementConstants.LEAVE_TYPE,
				HRManagementConstants.LEAVE_FROM_MONTH, HRManagementConstants.LEAVE_FROM_YEAR,
				HRManagementConstants.LEAVE_FROM_DATE, HRManagementConstants.LEAVE_START_TIME,
				HRManagementConstants.LEAVE_TO_MONTH, HRManagementConstants.LEAVE_TO_YEAR,
				HRManagementConstants.LEAVE_TO_DATE, HRManagementConstants.LEAVE_END_TIME,
				HRManagementConstants.LEAVE_DESCRIPTION);

		softAssert.assertTrue(applyLeavePage.isLeaveAppliedSuccessMessageDisplayed());

		softAssert.assertEquals(leaveRequestsPage.getLeaveTypeText(HRManagementConstants.EMPLOYEE_ID,
				HRManagementConstants.LEAVE_TYPE), HRManagementConstants.LEAVE_TYPE);

		String[] fromDateParts = leaveRequestsPage.getFromDateText(HRManagementConstants.EMPLOYEE_ID,
				HRManagementConstants.LEAVE_TYPE);
		softAssert.assertEquals(fromDateParts[0], HRManagementConstants.LEAVE_FROM_MONTH);
		softAssert.assertEquals(fromDateParts[1], HRManagementConstants.LEAVE_FROM_DATE);
		softAssert.assertEquals(fromDateParts[2], HRManagementConstants.LEAVE_FROM_YEAR);

		String[] toDateParts = leaveRequestsPage.getToDateText(HRManagementConstants.EMPLOYEE_ID,
				HRManagementConstants.LEAVE_TYPE);
		softAssert.assertEquals(toDateParts[0], HRManagementConstants.LEAVE_TO_MONTH);
		softAssert.assertEquals(toDateParts[1], HRManagementConstants.LEAVE_TO_DATE);
		softAssert.assertEquals(toDateParts[2], HRManagementConstants.LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(
				leaveRequestsPage.getTotalDaysText(HRManagementConstants.EMPLOYEE_ID, HRManagementConstants.LEAVE_TYPE)
						.trim(),
				String.valueOf(totalDays));

		softAssert.assertAll();
	}
}