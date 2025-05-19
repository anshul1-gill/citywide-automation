package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentViewShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void viewShiftDetailsTest() throws InterruptedException {
		Thread.sleep(5000);
		// fieldAgentDashboardPage.btnMarkAsRead();
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		Thread.sleep(15000);
	}
}
