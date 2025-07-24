package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentConfirmMultipleShiftsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void confirmMultipleShiftsTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.doClickConfirmRejectMultipleShifts();
		fieldAgentStartShiftPage.doClickSelectAllShifts();
		fieldAgentStartShiftPage.doClickConfirm();
		fieldAgentStartShiftPage.doClickOkButton();
		softAssert.assertEquals(fieldAgentStartShiftPage.getSuccessMessage(),
				FieldAgentConstants.SUCCESS_MESSAGE_CONFIRM_SHIFT, "Success message should match");

		softAssert.assertAll();
	}

}
