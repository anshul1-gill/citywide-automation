package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class EmployeesViewRemarksTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		employeesPage = dashboardPage.doClickEmployees();
	}

	@Test
	public void viewRemarksEmployeesTest() throws InterruptedException {
		employeesPage.selectStatus();
		employeesPage.searchInTextbox(prop.getProperty("employeeID"));
		Thread.sleep(4000);
		softAssert.assertTrue(employeesPage.isViewRemarksButtonDisplayed(), "View Remarks button is not displayed");
		softAssert.assertTrue(employeesPage.isViewRemarksButtonClickable(), "View Remarks button is not clickable");
		employeesPage.clickViewRemarks();
		employeesPage.selectRemarkTypeOnViewPage(HRManagementConstants.EMPLOYEE_REMARKS_TYPE);
		softAssert.assertTrue(employeesPage.isExportButtonDisplayed(),
				"Export button is not displayed on View Remarks page");
		softAssert.assertTrue(employeesPage.isExportButtonClickable(),
				"Export button is not clickable on View Remarks page");
		softAssert.assertTrue(employeesPage.isPrintButtonDisplayed(),
				"Print button is not displayed on View Remarks page");
		softAssert.assertTrue(employeesPage.isPrintButtonClickable(),
				"Print button is not clickable on View Remarks page");
		softAssert.assertEquals(employeesPage.getReason(), HRManagementConstants.EMPLOYEE_REMARKS_REASON,
				"Reason is not displayed correctly on View Remarks page");
		softAssert.assertEquals(employeesPage.getDescription(), HRManagementConstants.EMPLOYEE_REMARKS_DESCRIPTION,
				"Description is not displayed correctly on View Remarks page");
		softAssert.assertEquals(employeesPage.getIncidentDate(), HRManagementConstants.EMPLOYEE_INCIDENT_DATE,
				"Incident Date is not displayed correctly on View Remarks page");
		softAssert.assertEquals(employeesPage.getSiteName().contains(HRManagementConstants.SITE), true,
				"Site Name is not displayed correctly on View Remarks page");
		softAssert.assertEquals(employeesPage.getRemarkName(), HRManagementConstants.EMPLOYEE_REMARKS_CATEGORY,
				"Remark Type is not displayed correctly on View Remarks page");
		softAssert.assertEquals(employeesPage.getDescription(), HRManagementConstants.EMPLOYEE_REMARKS_DESCRIPTION,
				"Description is not displayed correctly on View Remarks page");

		softAssert.assertAll();
	}

}
