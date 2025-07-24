package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentConfirmShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void confirmShiftTest() throws InterruptedException {
		Thread.sleep(500);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		softAssert.assertTrue(fieldAgentStartShiftPage.isConfirmShiftButtonVisible(),
				"Confirm Shift button should be visible");
		fieldAgentStartShiftPage.doClickConfirmShift();
		fieldAgentStartShiftPage.doClickOkButton();
		// fieldAgentStartShiftPage.doClickCancelButton();
		softAssert.assertEquals(fieldAgentStartShiftPage.getSuccessMessage(),
				FieldAgentConstants.SUCCESS_MESSAGE_CONFIRM_SHIFT,
				"Success message does not match after confirming shift.");

		softAssert.assertAll();
	}

}
