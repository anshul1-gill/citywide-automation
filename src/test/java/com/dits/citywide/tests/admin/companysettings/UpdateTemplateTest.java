package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class UpdateTemplateTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateTemplateTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		activityTemplatePage = companySettingsPage.clickActivityTemplatesLink();
		activityTemplatePage.clickEditViolationButton(CompanySettingsConstant.ACTIVITY_TEMPLATE_NAME_TEST);

		activityTemplatePage.updateActivityTemplate(CompanySettingsConstant.QUESTION_TYPE_UPDATED,
				CompanySettingsConstant.QUESTION_TEXT_UPDATED);

	}

}
