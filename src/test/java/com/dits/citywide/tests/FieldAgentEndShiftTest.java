package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentEndShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void endShiftTest() throws InterruptedException {
		// Thread.sleep(2000);
		fieldAgentStartShiftPage.btnMarkAsRead();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);
		softAssert.assertTrue(fieldAgentStartShiftPage.isEndShiftButtonVisible(), "End Shift button should be visible");
		fieldAgentStartShiftPage.doClickEndShift();

		Thread.sleep(15000);
		softAssert.assertAll();

	}

}
