package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class NewPassdownLogTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void addNewPassdownLogTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		passdownLogsPage = fieldAgentStartShiftPage.clickOnPassdownLogsTab();
		passdownLogsPage.clickAddPassdownLog();
		softAssert.assertTrue(passdownLogsPage.getSiteNameDropdownValue().contains(HRManagementConstants.SITE),
				"Site name dropdown value is not as expected");
		passdownLogsPage.enterMessage(FieldAgentConstants.PASSDOWN_MESSAGE);
		passdownLogsPage.uploadImage(FieldAgentConstants.PASSDOWN_IMAGE_PATH);
		softAssert.assertEquals(passdownLogsPage.getHeadingEditImage(), "Edit Image",
				"Heading of the image edit page is not as expected");
		passdownLogsPage.clickUploadImage();
		softAssert.assertEquals(passdownLogsPage.imageUploadSuccessMessage(),
				FieldAgentConstants.IMAGE_UPLOAD_SUCCESS_MESSAGE, "Image upload success message is not as expected");
		passdownLogsPage.enterImageName(FieldAgentConstants.PASSDOWN_IMAGE_NAME);
		passdownLogsPage.enterImageDescription(FieldAgentConstants.IMAGE_DESCRIPTION);
		passdownLogsPage.clickSavePassdown();

		softAssert.assertTrue(passdownLogsPage.isAddPassdownLogButtonDisplayed(),
				"Add Passdown Log button is not displayed after saving the passdown log");
		softAssert.assertTrue(passdownLogsPage.getDataSiteName().contains(HRManagementConstants.SITE),
				"Site name dropdown value is not as expected");
		softAssert.assertEquals(passdownLogsPage.getDataMessage(), FieldAgentConstants.PASSDOWN_MESSAGE,
				"Passdown message is not as expected");

		softAssert.assertAll();
	}

}
