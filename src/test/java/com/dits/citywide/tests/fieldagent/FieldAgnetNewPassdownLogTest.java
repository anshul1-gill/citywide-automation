package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgnetNewPassdownLogTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void addNewPassdownLogTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentPassdownLogsPage = fieldAgentStartShiftPage.clickOnPassdownLogsTab();
		fieldAgentPassdownLogsPage.clickAddPassdownLog();
//		softAssert.assertTrue(passdownLogsPage.getSiteNameDropdownValue().contains(HRManagementConstants.SITE),
//				"Site name dropdown value is not as expected");
		fieldAgentPassdownLogsPage.searchSiteName(HRManagementConstants.SITE);
		fieldAgentPassdownLogsPage.enterMessage(FieldAgentConstants.PASSDOWN_MESSAGE);
		fieldAgentPassdownLogsPage.uploadImage(FieldAgentConstants.PASSDOWN_IMAGE_PATH);
//		softAssert.assertEquals(fieldAgentPassdownLogsPage.getHeadingEditImage(), "Edit Image",
//				"Heading of the image edit page is not as expected");
		fieldAgentPassdownLogsPage.clickUploadImage();
		softAssert.assertEquals(fieldAgentPassdownLogsPage.imageUploadSuccessMessage(),
				FieldAgentConstants.IMAGE_UPLOAD_SUCCESS_MESSAGE, "Image upload success message is not as expected");
		fieldAgentPassdownLogsPage.enterImageName(FieldAgentConstants.PASSDOWN_IMAGE_NAME);
		fieldAgentPassdownLogsPage.enterImageDescription(FieldAgentConstants.IMAGE_DESCRIPTION);
		fieldAgentPassdownLogsPage.clickSavePassdown();

		softAssert.assertTrue(fieldAgentPassdownLogsPage.isAddPassdownLogButtonDisplayed(),
				"Add Passdown Log button is not displayed after saving the passdown log");
		softAssert.assertTrue(fieldAgentPassdownLogsPage.getDataSiteName().contains(HRManagementConstants.SITE),
				"Site name dropdown value is not as expected");
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getDataMessage(), FieldAgentConstants.PASSDOWN_MESSAGE,
				"Passdown message is not as expected");

		softAssert.assertAll();
	}

}
