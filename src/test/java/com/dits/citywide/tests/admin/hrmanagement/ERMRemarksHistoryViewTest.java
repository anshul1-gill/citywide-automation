package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ERMRemarksHistoryViewTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
	}

	@Test
	public void viewRemarksERMTest() throws InterruptedException {
		ermRemarksHistoryPage = ermPage.clickRemarksHistory();
		ermRemarksHistoryPage.searchRemarks(prop.getProperty("employeeID"));
		ermRemarksHistoryPage.clickViewRemarks();
		softAssert.assertTrue(ermRemarksHistoryPage.isExportButtonDisplayed(),
				"Export button is not displayed on the view remarks page");
		softAssert.assertTrue(ermRemarksHistoryPage.isExportButtonClickable(),
				"Export button is not clickable on the view remarks page");
		softAssert.assertTrue(ermRemarksHistoryPage.isPrintButtonDisplayed(),
				"Print button is not displayed on the view remarks page");
		softAssert.assertTrue(ermRemarksHistoryPage.isPrintButtonClickable(),
				"Print button is not clickable on the view remarks page");
		ermRemarksHistoryPage.selectRemarkTypeOnViewPage(HRManagementConstants.REMARKS_TYPE);
		softAssert.assertEquals(ermRemarksHistoryPage.getReason(), HRManagementConstants.REMARKS_REASON,
				"Reason does not match");
		softAssert.assertEquals(ermRemarksHistoryPage.getRemarkName(), HRManagementConstants.REMARKS_CATEGORY,
				"Category does not match");
		softAssert.assertEquals(ermRemarksHistoryPage.getIncidentDate(), HRManagementConstants.INCIDENT_DATE,
				"Incident date does not match");
		softAssert.assertTrue(ermRemarksHistoryPage.getSiteName().contains(HRManagementConstants.SITE),
				"Site name does not match");
		softAssert.assertEquals(ermRemarksHistoryPage.getDescription(), HRManagementConstants.REMARKS_DESCRIPTION,
				"Description does not match");
		softAssert.assertAll();
	}

}
