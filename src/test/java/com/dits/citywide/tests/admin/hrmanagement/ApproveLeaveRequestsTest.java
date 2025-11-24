package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class ApproveLeaveRequestsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void approveLeaveRequestsTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		leaveRequestsPage = dashboardPage.doClickLeaveRequests();

		// Apply default date filters (new functionality added to page object)
		leaveRequestsPage.applyDefaultDateFilters();

		softAssert.assertTrue(leaveRequestsPage.isAddLeaveRequestButtonDisplayed(),
				"Apply Leave button not visible");

		softAssert.assertEquals(leaveRequestsPage.getLeaveTypeText(), FieldAgentConstants.LEAVE_TYPE,
				"Leave type mismatch");

		String[] fromDateParts = leaveRequestsPage.getFromDateText();
		softAssert.assertEquals(fromDateParts[0], FieldAgentConstants.LEAVE_FROM_MONTH, "From month mismatch");
		softAssert.assertEquals(fromDateParts[1], FieldAgentConstants.LEAVE_FROM_DATE, "From day mismatch");
		softAssert.assertEquals(fromDateParts[2], FieldAgentConstants.LEAVE_FROM_YEAR, "From year mismatch");

		String[] toDateParts = leaveRequestsPage.getToDateText();
		softAssert.assertEquals(toDateParts[0], FieldAgentConstants.LEAVE_TO_MONTH, "To month mismatch");
		softAssert.assertEquals(toDateParts[1], FieldAgentConstants.LEAVE_TO_DATE, "To day mismatch");
		softAssert.assertEquals(toDateParts[2], FieldAgentConstants.LEAVE_TO_YEAR, "To year mismatch");

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		softAssert.assertEquals(leaveRequestsPage.getTotalDaysText().trim(), String.valueOf(totalDays),
				"Total days mismatch");

		leaveRequestsPage.doClickApprove(prop.getProperty("employeeID"), FieldAgentConstants.LEAVE_TYPE);

		softAssert.assertEquals(leaveRequestsPage.getAreYouSureText(),
				HRManagementConstants.POPUP_MESSAGE_ARE_YOU_SURE, "Are you sure popup text mismatch");
		softAssert.assertEquals(leaveRequestsPage.getApproveLeaveWarningText(),
				HRManagementConstants.POPUP_MESSAGE_ACTION_WILL_APPROVE_LEAVE, "Approve warning text mismatch");
		leaveRequestsPage.doClickOk();
		softAssert.assertEquals(leaveRequestsPage.getApprovedConfirmationMessage(),
				HRManagementConstants.APPROVED_CONFIRMATION_MESSAGE, "Approved confirmation mismatch");

		softAssert.assertEquals(
				leaveRequestsPage.getApprovedStatus(prop.getProperty("employeeID"), FieldAgentConstants.LEAVE_TYPE),
				HRManagementConstants.STATUS_APPROVED, "Approved status mismatch");

		softAssert.assertAll();
	}

}