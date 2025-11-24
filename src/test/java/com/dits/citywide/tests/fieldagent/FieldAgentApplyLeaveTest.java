package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentApplyLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void applyLeaveTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		fieldAgentLeaveRequestsPage = fieldAgentStartShiftPage.clickOnLeaveRequestsTab();
		fieldAgentLeaveRequestsPage.clickAddLeaveRequest();
		fieldAgentLeaveRequestsPage.fillApplyLeaveForm(FieldAgentConstants.LEAVE_TYPE,
				FieldAgentConstants.LEAVE_FROM_MONTH, FieldAgentConstants.LEAVE_FROM_YEAR,
				FieldAgentConstants.LEAVE_FROM_DATE, FieldAgentConstants.LEAVE_START_TIME,
				FieldAgentConstants.LEAVE_TO_MONTH, FieldAgentConstants.LEAVE_TO_YEAR,
				FieldAgentConstants.LEAVE_TO_DATE, FieldAgentConstants.LEAVE_END_TIME,
				FieldAgentConstants.LEAVE_DESCRIPTION);
		fieldAgentLeaveRequestsPage.doApplyLeave();

		// Apply default date filters (newly added for consistency with patrol test)
		fieldAgentLeaveRequestsPage.applyDefaultDateFilters();

		softAssert.assertTrue(fieldAgentLeaveRequestsPage.isAddLeaveRequestButtonDisplayed(),
				"Add Leave Request button is not displayed");

		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getLeaveType(), FieldAgentConstants.LEAVE_TYPE);

		String[] fromDateParts = fieldAgentLeaveRequestsPage.getFromDate();
		softAssert.assertEquals(fromDateParts[0], FieldAgentConstants.LEAVE_FROM_MONTH, "From month mismatch");
		softAssert.assertEquals(fromDateParts[1], FieldAgentConstants.LEAVE_FROM_DATE, "From date mismatch");
		softAssert.assertEquals(fromDateParts[2], FieldAgentConstants.LEAVE_FROM_YEAR, "From year mismatch");

		String[] toDateParts = fieldAgentLeaveRequestsPage.getToDate();
		softAssert.assertEquals(toDateParts[0], FieldAgentConstants.LEAVE_TO_MONTH, "To month mismatch");
		softAssert.assertEquals(toDateParts[1], FieldAgentConstants.LEAVE_TO_DATE, "To date mismatch");
		softAssert.assertEquals(toDateParts[2], FieldAgentConstants.LEAVE_TO_YEAR, "To year mismatch");

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getTotalDays().trim(), String.valueOf(totalDays),
				"Total days mismatch");

		softAssert.assertAll();
	}

}