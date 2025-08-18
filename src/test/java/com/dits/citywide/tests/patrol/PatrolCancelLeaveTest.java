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
		patrolStartShiftPage.clickOnHRManagementMenu();
		patrolLeaveRequestsPage = patrolStartShiftPage.clickOnLeaveRequestsTab();
		patrolLeaveRequestsPage.doClickCancelButton(prop.getProperty("patrolID"), PatrolConstants.EDIT_LEAVE_TYPE);
		softAssert.assertEquals(patrolLeaveRequestsPage.getCancelValidationMessage(),
				PatrolConstants.LEAVE_CANCEL_VALIDATION_MESSAGE);
		patrolLeaveRequestsPage.doClickOkButton();
		softAssert.assertEquals(patrolLeaveRequestsPage.getCancelConfirmationMessage(),
				PatrolConstants.LEAVE_CANCEL_CONFIRMATION_MESSAGE);
		softAssert.assertEquals(
				patrolLeaveRequestsPage.getStatus(prop.getProperty("patrolID"), PatrolConstants.EDIT_LEAVE_TYPE),
				PatrolConstants.LEAVE_STATUS);
		softAssert.assertAll();
	}

}
