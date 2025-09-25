package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ERMRemarksHistoryAddRemarksTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
	}

	@Test
	public void addRemarksERMTest() throws InterruptedException {
		ermRemarksHistoryPage = ermPage.clickRemarksHistory();
		ermRemarksHistoryPage.searchRemarks(prop.getProperty("employeeID"));
		Thread.sleep(1000);
		ermRemarksHistoryPage.clickAddRemarks();
		ermRemarksHistoryPage.fillAddNewRemark(HRManagementConstants.REMARKS_TYPE,
				HRManagementConstants.REMARKS_CATEGORY, HRManagementConstants.INCIDENT_DATE, HRManagementConstants.SITE,
				HRManagementConstants.REMARKS_REASON, HRManagementConstants.REMARKS_DESCRIPTION);
		ermRemarksHistoryPage.submitAddNewRemark();
		softAssert.assertEquals(ermRemarksHistoryPage.getSuccessMessage(),
				HRManagementConstants.COMMENT_ADDED_SUCCESS_MESSAGE);
		softAssert.assertAll();
	}

}
