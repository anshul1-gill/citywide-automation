package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddNotificationTypeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNotificationTypeTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		hrConfigurationsPage = companySettingsPage.clickHRConfigurationsLink();
		hrConfigurationsPage.clickOnAddNotificationTypeButton();
		hrConfigurationsPage.fillAddNotificationTypeForm(CompanySettingsConstant.NOTIFICATION_TYPE_NAME,
				CompanySettingsConstant.EMPLOYEE_NAME, CompanySettingsConstant.NOTIFICATION_EMAILS);

	}

}