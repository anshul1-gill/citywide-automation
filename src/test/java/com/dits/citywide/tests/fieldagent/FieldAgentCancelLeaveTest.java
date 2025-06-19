package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentCancelLeaveTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void deleteLeaveTest() throws InterruptedException {
		fieldAgentStartShiftPage.btnMarkAsRead();
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		fieldAgentLeaveRequestsPage = fieldAgentStartShiftPage.clickOnLeaveRequestsTab();
		fieldAgentLeaveRequestsPage.doClickCancelButton(prop.getProperty("employeeID"),
				FieldAgentConstants.EDIT_LEAVE_TYPE);
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getCancelValidationMessage(),
				FieldAgentConstants.LEAVE_CANCEL_VALIDATION_MESSAGE);
		fieldAgentLeaveRequestsPage.doClickOkButton();
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getCancelConfirmationMessage(),
				FieldAgentConstants.LEAVE_CANCEL_CONFIRMATION_MESSAGE);
		softAssert.assertEquals(fieldAgentLeaveRequestsPage.getStatus(prop.getProperty("employeeID"),
				FieldAgentConstants.EDIT_LEAVE_TYPE), FieldAgentConstants.LEAVE_STATUS);

		softAssert.assertAll();
	}

}
