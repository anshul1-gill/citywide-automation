package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentEndShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void endShiftTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentStartShiftPage.doClickTabStartShift();
		Thread.sleep(3000);
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);
		softAssert.assertTrue(fieldAgentStartShiftPage.isEndShiftButtonVisible(), "End Shift button should be visible");
		fieldAgentReportsPage = fieldAgentStartShiftPage.doClickEndShift();

		fieldAgentReportsPage.clickEndShift();

//		softAssert.assertEquals(fieldAgentReportsPage.getNoDataFoundText(), FieldAgentConstants.NO_DATA_FOUND_TEXT,
//				"No Data Found text mismatch!");
		softAssert.assertTrue(fieldAgentReportsPage.isReOpenPatrolLogVisible(),
				"Re-Open Patrol Log button should be visible");
		softAssert.assertAll();
	}

}
