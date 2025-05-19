package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class DeclineLeaveRequestsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void declineLeaveRequestsTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		leaveRequestsPage = dashboardPage.doClickLeaveRequests();
		leaveRequestsPage.doClickDecline(prop.getProperty("email"), HRManagementConstants.LEAVE_TYPE);

		softAssert.assertEquals(leaveRequestsPage.getAreYouSureText(),
				HRManagementConstants.POPUP_MESSAGE_ARE_YOU_SURE);
		softAssert.assertEquals(leaveRequestsPage.getCancelLeaveWarningText(),
				HRManagementConstants.POPUP_MESSAGE_ACTION_WILL_CANCEL_LEAVE);
		leaveRequestsPage.doClickOk();
		softAssert.assertEquals(leaveRequestsPage.getCancelConfirmationMessage(),
				HRManagementConstants.CANCEL_CONFIRMATION_MESSAGE);
		softAssert.assertAll();

	}

}
