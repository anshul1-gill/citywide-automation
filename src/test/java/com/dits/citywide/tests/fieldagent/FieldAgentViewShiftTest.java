package com.dits.citywide.tests.fieldagent;

import java.time.LocalDate;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentViewShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void viewShiftDetailsTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.doClickTabStartShift();
		Thread.sleep(2000);

		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		// Verify basic shift info
		softAssert.assertTrue(fieldAgentStartShiftPage.getSite().contains(HRManagementConstants.SITE),
				"Site name not found!");
		softAssert.assertTrue(fieldAgentStartShiftPage.getSchedule(), "Schedule Time not found!");
		softAssert.assertTrue(fieldAgentStartShiftPage.getServiceType(), "Service Type not found!");
		softAssert.assertTrue(fieldAgentStartShiftPage.getAddress(), "Address not found!");
		softAssert.assertEquals(fieldAgentStartShiftPage.getNotes(), SchedulingConstant.ADD_NOTES);

		// Compare dates
		LocalDate serverDate = fieldAgentStartShiftPage.getServerDate(prop.getProperty("url"));
		int scheduledDay = Integer.parseInt(SchedulingConstant.ADD_SHIFT_DATE);

		System.out.println("Scheduled Day: " + scheduledDay);
		System.out.println("Server Date: " + serverDate);
		System.out.println("Server DayOfMonth: " + serverDate.getDayOfMonth());

		int serverDay = serverDate.getDayOfMonth();

		// Case 1: Today → all buttons visible
		if (serverDay == scheduledDay) {
			softAssert.assertTrue(fieldAgentStartShiftPage.isViewSiteVisible(), "View Site should be visible today");
			softAssert.assertTrue(fieldAgentStartShiftPage.isStartShiftButtonVisible(),
					"Start Shift should be visible today");
			softAssert.assertTrue(fieldAgentStartShiftPage.isConfirmShiftButtonVisible(),
					"Confirm should be visible today");
			softAssert.assertTrue(fieldAgentStartShiftPage.isRejectShiftButtonVisible(),
					"Reject should be visible today");

			// Case 2: Future → Start Shift hidden, others visible
		} else if (scheduledDay > serverDay) {
			softAssert.assertTrue(fieldAgentStartShiftPage.isViewSiteVisible(),
					"View Site should be visible for future shifts");
			softAssert.assertFalse(fieldAgentStartShiftPage.isStartShiftButtonVisible(),
					"Start Shift should NOT be visible for future shifts");
			softAssert.assertTrue(fieldAgentStartShiftPage.isConfirmShiftButtonVisible(),
					"Confirm should be visible for future shifts");
			softAssert.assertTrue(fieldAgentStartShiftPage.isRejectShiftButtonVisible(),
					"Reject should be visible for future shifts");

			// Case 3: Past → only View Site visible
		} else {
			softAssert.assertTrue(fieldAgentStartShiftPage.isViewSiteVisible(),
					"View Site should be visible for past shifts");
			softAssert.assertFalse(fieldAgentStartShiftPage.isStartShiftButtonVisible(),
					"Start Shift should NOT be visible for past shifts");
			softAssert.assertFalse(fieldAgentStartShiftPage.isConfirmShiftButtonVisible(),
					"Confirm should NOT be visible for past shifts");
			softAssert.assertFalse(fieldAgentStartShiftPage.isRejectShiftButtonVisible(),
					"Reject should NOT be visible for past shifts");
		}

		softAssert.assertAll();
	}
}
