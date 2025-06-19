package com.dits.citywide.tests.fieldagent;

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
		//Thread.sleep(5000);
		fieldAgentStartShiftPage.btnMarkAsRead();
		fieldAgentStartShiftPage.doClickTabStartShift();
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);

		softAssert.assertTrue(fieldAgentStartShiftPage.getSite().contains(HRManagementConstants.SITE),
				"Site name not found!");
		softAssert.assertTrue(fieldAgentStartShiftPage.getSchedule(), "Schedule Time not found!");
		softAssert.assertTrue(fieldAgentStartShiftPage.getServiceType(), "Service Type not found!");
		softAssert.assertTrue(fieldAgentStartShiftPage.getAddress(), "Address not found!");
		softAssert.assertEquals(fieldAgentStartShiftPage.getNotes(), SchedulingConstant.ADD_NOTES);
		fieldAgentStartShiftPage.doClickViewSite();

	}
}
