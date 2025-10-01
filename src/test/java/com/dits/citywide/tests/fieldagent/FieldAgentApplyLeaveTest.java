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
		Thread.sleep(2000);
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		Thread.sleep(2000);
		fieldAgentLeaveRequestsPage = fieldAgentStartShiftPage.clickOnLeaveRequestsTab();
		fieldAgentLeaveRequestsPage.clickAddLeaveRequest();
		fieldAgentLeaveRequestsPage.fillApplyLeaveForm(FieldAgentConstants.LEAVE_TYPE,
				FieldAgentConstants.LEAVE_FROM_MONTH, FieldAgentConstants.LEAVE_FROM_YEAR,
				FieldAgentConstants.LEAVE_FROM_DATE, FieldAgentConstants.LEAVE_START_TIME,
				FieldAgentConstants.LEAVE_TO_MONTH, FieldAgentConstants.LEAVE_TO_YEAR,
				FieldAgentConstants.LEAVE_TO_DATE, FieldAgentConstants.LEAVE_END_TIME,
				FieldAgentConstants.LEAVE_DESCRIPTION);
		fieldAgentLeaveRequestsPage.doApplyLeave();
		Thread.sleep(2000);
		softAssert.assertTrue(fieldAgentLeaveRequestsPage.isAddLeaveRequestButtonDisplayed(),
				"Add Leave Request button is not displayed");

		fieldAgentLeaveRequestsPage.doSearch("Pending");
		Thread.sleep(4000);

		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getLeaveType(), FieldAgentConstants.LEAVE_TYPE);

		String[] fromDateParts = fieldAgentLeaveRequestsPage.getFromDate();
		softAssert.assertEquals(fromDateParts[0], FieldAgentConstants.LEAVE_FROM_MONTH);
		// softAssert.assertEquals(fromDateParts[1],
		// FieldAgentConstants.LEAVE_FROM_DATE);
		softAssert.assertTrue(fromDateParts[1].contains(FieldAgentConstants.LEAVE_FROM_DATE),
				"Expected from date contains: " + FieldAgentConstants.LEAVE_FROM_DATE + " but found: "
						+ fromDateParts[1]);
		softAssert.assertEquals(fromDateParts[2], FieldAgentConstants.LEAVE_FROM_YEAR);

		String[] toDateParts = fieldAgentLeaveRequestsPage.getToDate();
		softAssert.assertEquals(toDateParts[0], FieldAgentConstants.LEAVE_TO_MONTH);
		// softAssert.assertEquals(toDateParts[1], FieldAgentConstants.LEAVE_TO_DATE);
		softAssert.assertTrue(toDateParts[1].contains(FieldAgentConstants.LEAVE_TO_DATE),
				"Expected to date contains: " + FieldAgentConstants.LEAVE_TO_DATE + " but found: " + toDateParts[1]);

		softAssert.assertEquals(toDateParts[2], FieldAgentConstants.LEAVE_TO_YEAR);

		int totalDays = (Integer.parseInt(toDateParts[1]) - Integer.parseInt(fromDateParts[1])) + 1;
		System.out.println(totalDays);
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getTotalDays().trim(), String.valueOf(totalDays));

		softAssert.assertAll();
	}

}
