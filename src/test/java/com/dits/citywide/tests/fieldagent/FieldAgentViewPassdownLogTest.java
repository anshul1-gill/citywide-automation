package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentViewPassdownLogTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void viewPassdownLogTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentPassdownLogsPage = fieldAgentStartShiftPage.clickOnPassdownLogsTab();
		fieldAgentPassdownLogsPage.clickViewPassdownLog(FieldAgentConstants.PASSDOWN_MESSAGE);
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getHeadingViewPassdownDetails(), "Passdown Details",
				"Heading of the passdown details page is not as expected");
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getDataTitle(), FieldAgentConstants.PASSDOWN_IMAGE_NAME,
				"Title of the passdown log is not as expected");
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getDataDescription(), FieldAgentConstants.IMAGE_DESCRIPTION,
				"Description of the passdown log is not as expected");
		softAssert.assertTrue(fieldAgentPassdownLogsPage.isImageDisplayed(),
				"Image in the passdown log details is not displayed as expected");

		softAssert.assertAll();
	}

}
