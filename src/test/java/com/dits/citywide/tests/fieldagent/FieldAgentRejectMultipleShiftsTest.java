package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentRejectMultipleShiftsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void rejectMultipleShiftsTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.doClickConfirmRejectMultipleShifts();
		fieldAgentStartShiftPage.doClickSelectAllShifts();
		fieldAgentStartShiftPage.doClickReject();
		fieldAgentStartShiftPage.enterRejectReasonMultipleShifts(FieldAgentConstants.REJECTION_REASON);
		fieldAgentStartShiftPage.doClickSaveRejectReasonMultipleShifts();
		fieldAgentStartShiftPage.doClickOkButton();
		softAssert.assertEquals(fieldAgentStartShiftPage.getSuccessMessage(),
				FieldAgentConstants.SUCCESS_MESSAGE_REJECTED_SHIFT, "Success message should match");

		softAssert.assertAll();
	}

}
