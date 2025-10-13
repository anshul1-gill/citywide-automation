package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentUpdateLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void editLeaveTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		fieldAgentLeaveRequestsPage = fieldAgentStartShiftPage.clickOnLeaveRequestsTab();
		fieldAgentLeaveRequestsPage.doClickEditButton(prop.getProperty("employeeID"), FieldAgentConstants.LEAVE_TYPE);

		fieldAgentLeaveRequestsPage.updateLeaveForm(FieldAgentConstants.EDIT_LEAVE_TYPE,
				FieldAgentConstants.EDIT_LEAVE_FROM_MONTH, FieldAgentConstants.EDIT_LEAVE_FROM_YEAR,
				FieldAgentConstants.EDIT_LEAVE_FROM_DATE, FieldAgentConstants.EDIT_LEAVE_START_TIME,
				FieldAgentConstants.EDIT_LEAVE_TO_MONTH, FieldAgentConstants.EDIT_LEAVE_TO_YEAR,
				FieldAgentConstants.EDIT_LEAVE_TO_DATE, FieldAgentConstants.EDIT_LEAVE_END_TIME,
				FieldAgentConstants.EDIT_LEAVE_DESCRIPTION);
		
		fieldAgentLeaveRequestsPage.doClickUpdateLeave();

		softAssert.assertTrue(fieldAgentLeaveRequestsPage.isAddLeaveRequestButtonDisplayed());

		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getLeaveType(), FieldAgentConstants.EDIT_LEAVE_TYPE);

		String[] fromDateParts = fieldAgentLeaveRequestsPage.getFromDate();
		softAssert.assertEquals(fromDateParts[0], FieldAgentConstants.EDIT_LEAVE_FROM_MONTH);
		softAssert.assertEquals(fromDateParts[1], FieldAgentConstants.EDIT_LEAVE_FROM_DATE);
		softAssert.assertEquals(fromDateParts[2], FieldAgentConstants.EDIT_LEAVE_FROM_YEAR);

		String[] toDateParts = fieldAgentLeaveRequestsPage.getToDate();
		softAssert.assertEquals(toDateParts[0], FieldAgentConstants.EDIT_LEAVE_TO_MONTH);
		softAssert.assertEquals(toDateParts[1], FieldAgentConstants.EDIT_LEAVE_TO_DATE);
		softAssert.assertEquals(toDateParts[2], FieldAgentConstants.EDIT_LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getTotalDays().trim(), String.valueOf(totalDays));

		softAssert.assertAll();
	}
}
