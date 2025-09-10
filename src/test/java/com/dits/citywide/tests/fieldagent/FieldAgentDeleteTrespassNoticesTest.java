package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class FieldAgentDeleteTrespassNoticesTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void deleteTrespassNoticesFieldAgentTest() throws InterruptedException {

		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentTrespassNoticesPage = fieldAgentStartShiftPage.clickOnTrespassNoticesFormLink();

		fieldAgentTrespassNoticesPage.searchTrespassNotice(prop.getProperty("employeeID"));
		fieldAgentTrespassNoticesPage.deleteParkingCitation(prop.getProperty("trespassNoticesID"));
		softAssert.assertEquals(fieldAgentTrespassNoticesPage.isSuccessMessageDisplayed(),
				"Notice deleted successfully.");

		fieldAgentTrespassNoticesPage.searchTrespassNoticeID(prop.getProperty("parkingcitationID"));
		softAssert.assertEquals(fieldAgentTrespassNoticesPage.getNoRecordFoundMessage(), "Records found");

		softAssert.assertAll();
	}

}
