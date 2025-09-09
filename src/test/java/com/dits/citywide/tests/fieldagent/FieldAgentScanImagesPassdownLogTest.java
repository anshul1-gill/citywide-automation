package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgentScanImagesPassdownLogTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void scanImagesPassdownLogTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentPassdownLogsPage = fieldAgentStartShiftPage.clickOnPassdownLogsTab();
		fieldAgentPassdownLogsPage.clickScanImage(FieldAgentConstants.PASSDOWN_MESSAGE);

		softAssert.assertTrue(fieldAgentPassdownLogsPage.getDataSiteNameScan().contains(HRManagementConstants.SITE),
				"Site name in the scan images passdown log is not as expected");
		softAssert.assertTrue(fieldAgentPassdownLogsPage.getDataCreatedByScan().contains(prop.getProperty("employeeID")),
				"Created by in the scan images passdown log is not as expected");
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getDataPassdownTextScan().trim(), FieldAgentConstants.PASSDOWN_MESSAGE,
				"Message in the scan images passdown log is not as expected");
		softAssert.assertTrue(fieldAgentPassdownLogsPage.isDataImageScanDisplayed(),
				"Image in the scan images passdown log is not displayed as expected");
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getDataImageFileNameScan(), FieldAgentConstants.PASSDOWN_IMAGE_NAME,
				"Image file name in the scan images passdown log is not as expected");
		softAssert.assertEquals(fieldAgentPassdownLogsPage.getDataImageDescriptionScan().trim(),
				FieldAgentConstants.IMAGE_DESCRIPTION,
				"Image description in the scan images passdown log is not as expected");
		softAssert.assertTrue(fieldAgentPassdownLogsPage.isDataQRCodeScanDisplayed(),
				"QR code in the scan images passdown log is not displayed as expected");

		softAssert.assertAll();
	}

}
