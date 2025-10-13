package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddNewActivityTemplateTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNewTemplateTest() throws  InterruptedException {

		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		activityTemplatePage = companySettingsPage.clickActivityTemplatesLink();
		activityTemplatePage.clickAddActivityTemplateButton();
		activityTemplatePage.fillAddActivityTemplateForm(CompanySettingsConstant.ACTIVITY_TEMPLATE_NAME_TEST,
				CompanySettingsConstant.ACTIVITY_CODE_TEST);
		activityTemplatePage.fillSurveyQuestionnaire(CompanySettingsConstant.QUESTION_TYPE_TEST,
				CompanySettingsConstant.QUESTION_TEXT_TEST);
		activityTemplatePage.clickSaveQuestionButton();

	}

}
