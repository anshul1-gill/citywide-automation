package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentUpdateTrespassNoticesTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void updateTrespassNoticesTest() throws InterruptedException {

		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentTrespassNoticesPage = fieldAgentStartShiftPage.clickOnTrespassNoticesFormLink();
		fieldAgentTrespassNoticesPage.searchTrespassNotice(prop.getProperty("employeeID"));
		fieldAgentTrespassNoticesPage.clickOnEditButton(prop.getProperty("trespassNoticesID"));
		fieldAgentTrespassNoticesPage.updateLocationDetails(FieldAgentConstants.UPDATED_TRESPASS_SITE,
				FieldAgentConstants.UPDATED_TRESPASS_DATE_TIME, FieldAgentConstants.UPDATED_TRESPASS_ACTIVITY_CODE,
				FieldAgentConstants.UPDATED_TRESPASS_STREET_NUMBER, FieldAgentConstants.UPDATED_TRESPASS_STREET_NAME,
				FieldAgentConstants.UPDATED_TRESPASS_UNIT_NUMBER, FieldAgentConstants.UPDATED_TRESPASS_CITY,
				FieldAgentConstants.UPDATED_TRESPASS_STATE, FieldAgentConstants.UPDATED_TRESPASS_ZIP);

		softAssert.assertAll();
	}

}
