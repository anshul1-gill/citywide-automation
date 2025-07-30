package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class ScanImagesPassdownLogTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void scanImagesPassdownLogTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		passdownLogsPage = fieldAgentStartShiftPage.clickOnPassdownLogsTab();
		passdownLogsPage.clickScanImage(FieldAgentConstants.PASSDOWN_MESSAGE);

		softAssert.assertTrue(passdownLogsPage.getDataSiteNameScan().contains(HRManagementConstants.SITE),
				"Site name in the scan images passdown log is not as expected");
		softAssert.assertTrue(passdownLogsPage.getDataCreatedByScan().contains(prop.getProperty("employeeID")),
				"Created by in the scan images passdown log is not as expected");
		softAssert.assertEquals(passdownLogsPage.getDataPassdownTextScan().trim(), FieldAgentConstants.PASSDOWN_MESSAGE,
				"Message in the scan images passdown log is not as expected");
		softAssert.assertTrue(passdownLogsPage.isDataImageScanDisplayed(),
				"Image in the scan images passdown log is not displayed as expected");
		softAssert.assertEquals(passdownLogsPage.getDataImageFileNameScan(), FieldAgentConstants.PASSDOWN_IMAGE_NAME,
				"Image file name in the scan images passdown log is not as expected");
		softAssert.assertEquals(passdownLogsPage.getDataImageDescriptionScan().trim(),
				FieldAgentConstants.IMAGE_DESCRIPTION,
				"Image description in the scan images passdown log is not as expected");
		softAssert.assertTrue(passdownLogsPage.isDataQRCodeScanDisplayed(),
				"QR code in the scan images passdown log is not displayed as expected");

		softAssert.assertAll();
	}

}
