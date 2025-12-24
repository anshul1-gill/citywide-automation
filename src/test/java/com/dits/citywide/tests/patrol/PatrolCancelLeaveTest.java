package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolConstants;

public class PatrolCancelLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void deleteLeaveTest() throws InterruptedException {
		patrolStartShiftPage.handleMessageOfTheWeek();
		patrolStartShiftPage.handlePassdownOfTheDay();
		patrolStartShiftPage.clickOnHRManagementMenu();
		patrolLeaveRequestsPage = patrolStartShiftPage.clickOnLeaveRequestsTab();
		patrolLeaveRequestsPage.applyDefaultDateFilters();
		patrolLeaveRequestsPage.doClickCancelButton(prop.getProperty("patrolID"), PatrolConstants.EDIT_LEAVE_TYPE);

		String expectedValidation = PatrolConstants.LEAVE_CANCEL_VALIDATION_MESSAGE;
		String actualValidation = patrolLeaveRequestsPage.getCancelValidationMessage();
		softAssert.assertEquals(actualValidation, expectedValidation,
				"Validation message mismatch. Expected: '" + expectedValidation + "' | Found: '" + actualValidation + "'");

		patrolLeaveRequestsPage.doClickOkButton();

		String expectedConfirmation = PatrolConstants.LEAVE_CANCEL_CONFIRMATION_MESSAGE;
		String actualConfirmation = null;
		try {
			actualConfirmation = patrolLeaveRequestsPage.getCancelConfirmationMessage();
			softAssert.assertEquals(actualConfirmation, expectedConfirmation,
					"Confirmation message mismatch. Expected: '" + expectedConfirmation + "' | Found: '" + actualConfirmation + "'");
		} catch (Exception e) {
			System.out.println("Confirmation popup not visible or timed out. Proceeding to status check.");
		}

		String expectedStatus = PatrolConstants.LEAVE_STATUS;
		String actualStatus = patrolLeaveRequestsPage.getStatus(prop.getProperty("patrolID"), PatrolConstants.EDIT_LEAVE_TYPE);
		softAssert.assertEquals(actualStatus, expectedStatus,
				"Leave status mismatch. Expected: '" + expectedStatus + "' | Found: '" + actualStatus + "'");

		softAssert.assertAll();
	}

}