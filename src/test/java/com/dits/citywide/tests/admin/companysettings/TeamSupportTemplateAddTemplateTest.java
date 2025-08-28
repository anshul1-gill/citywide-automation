package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class TeamSupportTemplateAddTemplateTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addTemplateTest() throws InterruptedException {
		companySettingsPage = dashboardPage.doClickCompanySettingsTab();
		teamSupportTemplatePage = companySettingsPage.clickTeamSupportTemplateLink();
		teamSupportTemplatePage.clickOnAddNewTemplate();
		softAssert.assertTrue(teamSupportTemplatePage.isPageHeaderVisible(), "Add Template heading is not visible");

		teamSupportTemplatePage.fillAddTemplateDetails(CompanySettingsConstant.TEMPLATE_NAME,
				CompanySettingsConstant.DEPARTMENT, CompanySettingsConstant.ASSIGNED_TO,
				CompanySettingsConstant.DECISION_MAKER, CompanySettingsConstant.STATUS,
				CompanySettingsConstant.DESCRIPTION);

		teamSupportTemplatePage.clickOnTextInputToolbox();
		teamSupportTemplatePage.addTextInput(CompanySettingsConstant.TEXT_INPUT_TO_DISPLAY,
				CompanySettingsConstant.TEXT_LABEL_TO_DISPLAY);
		teamSupportTemplatePage.clickOnNumberToolbox();
		teamSupportTemplatePage.addNumberField(CompanySettingsConstant.NUMBER_TEXT_TO_DISPLAY,
				CompanySettingsConstant.NUMBER_LABEL_TO_DISPLAY);
		teamSupportTemplatePage.clickOnTextAreaToolbox();
		teamSupportTemplatePage.addTextArea(CompanySettingsConstant.TEXTAREA_TEXT_TO_DISPLAY,
				CompanySettingsConstant.TEXTAREA_LABEL_TO_DISPLAY);
		teamSupportTemplatePage.clickOnDropdownToolbox();
		teamSupportTemplatePage.addDropdown(CompanySettingsConstant.DROPDOWN_TEXT_TO_DISPLAY,
				CompanySettingsConstant.DROPDOWN_LABEL_TO_DISPLAY, CompanySettingsConstant.DROPDOWN_OPTIONS);
		teamSupportTemplatePage.clickOnDateFieldToolbox();
		teamSupportTemplatePage.addDateField(CompanySettingsConstant.DATE_TEXT_TO_DISPLAY,
				CompanySettingsConstant.DATE_LABEL_TO_DISPLAY);
		teamSupportTemplatePage.clickOnRadioGroupToolbox();
		teamSupportTemplatePage.addRadioGroup(CompanySettingsConstant.RADIO_TEXT_TO_DISPLAY,
				CompanySettingsConstant.RADIO_LABEL_TO_DISPLAY, CompanySettingsConstant.RADIO_OPTIONS);
//		teamSupportTemplatePage.clickOnFileUploadToolbox();

		teamSupportTemplatePage.clickOnEmailToolbox();
		teamSupportTemplatePage.addEmailField(CompanySettingsConstant.EMAIL_TEXT_TO_DISPLAY,
				CompanySettingsConstant.EMAIL_LABEL_TO_DISPLAY);
		teamSupportTemplatePage.clickOnSaveButton();
		softAssert.assertEquals(teamSupportTemplatePage.getSuccessMessage(),
				CompanySettingsConstant.TEMPLATE_SUCCESS_MESSAGE, "Template success message is not matched");

		softAssert.assertAll();
	}

}
