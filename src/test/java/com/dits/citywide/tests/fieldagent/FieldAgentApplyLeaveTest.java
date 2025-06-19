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

	@Test(groups = "leave-apply")
	public void applyLeaveTest() throws InterruptedException {
		fieldAgentStartShiftPage.btnMarkAsRead();
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

		softAssert.assertTrue(fieldAgentLeaveRequestsPage.isAddLeaveRequestButtonDisplayed());

		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getLeaveType(), FieldAgentConstants.LEAVE_TYPE);

		String[] fromDateParts = fieldAgentLeaveRequestsPage.getFromDate();
		softAssert.assertEquals(fromDateParts[0], FieldAgentConstants.LEAVE_FROM_MONTH);
		softAssert.assertEquals(fromDateParts[1], FieldAgentConstants.LEAVE_FROM_DATE);
		softAssert.assertEquals(fromDateParts[2], FieldAgentConstants.LEAVE_FROM_YEAR);

		String[] toDateParts = fieldAgentLeaveRequestsPage.getToDate();
		softAssert.assertEquals(toDateParts[0], FieldAgentConstants.LEAVE_TO_MONTH);
		softAssert.assertEquals(toDateParts[1], FieldAgentConstants.LEAVE_TO_DATE);
		softAssert.assertEquals(toDateParts[2], FieldAgentConstants.LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getTotalDays().trim(), String.valueOf(totalDays));

		softAssert.assertAll();
	}

}
