package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgnetTeamSupportTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void teamSupportFieldAgentTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentTeamSupportPage = fieldAgentStartShiftPage.clickOnTeamSupportTab();
		fieldAgentTeamSupportPage.clickOnAddNewRequestButton();
		fieldAgentTeamSupportPage.fillOutAndSubmitAbuseRequestForm(HRManagementConstants.SITE,
				FieldAgentConstants.SUBJECT_NAME, FieldAgentConstants.MESSAGE);

		fieldAgentTeamSupportPage.fillAbuseRequestForm(FieldAgentConstants.EXPLAIN_INCIDENCE,
				FieldAgentConstants.Name_OR_Badge, FieldAgentConstants.INCIDENCE_DATE);

		fieldAgentTeamSupportPage.clickOnSaveButton();
	}

}
