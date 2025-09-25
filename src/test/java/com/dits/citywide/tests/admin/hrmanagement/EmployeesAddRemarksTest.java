package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class EmployeesAddRemarksTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addRemarksEmployeesTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		employeesPage = dashboardPage.doClickEmployees();

		employeesPage.selectStatus();
		employeesPage.searchInTextbox(prop.getProperty("employeeID"));
		Thread.sleep(4000);
		softAssert.assertTrue(employeesPage.isAddRemarksButtonDisplayed(), "Add Remarks button is not displayed");
		softAssert.assertTrue(employeesPage.isAddRemarksButtonClickable(), "Add Remarks button is not clickable");
		employeesPage.clickAddRemarks();
		Thread.sleep(500);
		softAssert.assertEquals(employeesPage.getHeadingAddRemarks(), "Add New Remark",
				"Heading for Add Remarks is not displayed correctly");
		employeesPage.fillAddNewRemark(HRManagementConstants.EMPLOYEE_REMARKS_TYPE,
				HRManagementConstants.EMPLOYEE_REMARKS_CATEGORY, HRManagementConstants.EMPLOYEE_INCIDENT_DATE,
				HRManagementConstants.SITE, HRManagementConstants.EMPLOYEE_REMARKS_REASON,
				HRManagementConstants.EMPLOYEE_REMARKS_DESCRIPTION);
		employeesPage.submitAddNewRemark();
		Thread.sleep(500);
		softAssert.assertEquals(employeesPage.getSuccessMessage(),
				HRManagementConstants.EMPLOYEE_REMARKS_ADDED_SUCCESS_MESSAGE,
				"Success message is not displayed correctly");

		softAssert.assertAll();
	}

}
