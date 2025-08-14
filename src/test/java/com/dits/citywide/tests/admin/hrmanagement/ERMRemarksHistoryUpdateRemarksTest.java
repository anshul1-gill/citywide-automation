package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ERMRemarksHistoryUpdateRemarksTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
	}

	@Test
	public void UpdateRemarksERMTest() throws InterruptedException {
		ermRemarksHistoryPage = ermPage.clickRemarksHistory();
		ermRemarksHistoryPage.searchRemarks(prop.getProperty("employeeID"));
		ermRemarksHistoryPage.clickViewRemarks();
		ermRemarksHistoryPage.clickEditRemark();
		Thread.sleep(2000);
		softAssert.assertEquals(ermRemarksHistoryPage.getHeadingEditRemarks(), "Edit Remark", "Heading does not match");
		ermRemarksHistoryPage.fillUpdateRemark(HRManagementConstants.UPDATED_REMARKS_TYPE,
				HRManagementConstants.UPDATED_REMARKS_CATEGORY, HRManagementConstants.UPDATED_INCIDENT_DATE,
				HRManagementConstants.SITE, HRManagementConstants.UPDATED_REMARKS_REASON,
				HRManagementConstants.UPDATED_REMARKS_DESCRIPTION);
		ermRemarksHistoryPage.submitUpdateRemark();
		softAssert.assertEquals(ermRemarksHistoryPage.getSuccessMessage(),
				HRManagementConstants.REMARKS_UPDATED_SUCCESS_MESSAGE);
		softAssert.assertEquals(ermRemarksHistoryPage.getRemarkName(), HRManagementConstants.UPDATED_REMARKS_CATEGORY,
				"Category does not match after update");
		softAssert.assertEquals(ermRemarksHistoryPage.getReason(), HRManagementConstants.UPDATED_REMARKS_REASON,
				"Reason does not match after update");
		softAssert.assertEquals(ermRemarksHistoryPage.getIncidentDate(), HRManagementConstants.UPDATED_INCIDENT_DATE,
				"Incident date does not match after update");
		softAssert.assertTrue(ermRemarksHistoryPage.getSiteName().contains(HRManagementConstants.SITE),
				"Site name does not match after update");
		softAssert.assertEquals(ermRemarksHistoryPage.getDescription(),
				HRManagementConstants.UPDATED_REMARKS_DESCRIPTION, "Description does not match after update");
		softAssert.assertAll();
	}

}
