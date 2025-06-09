package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;
import com.dits.citywide.constants.SchedulingConstant;

public class FieldAgentEndShiftTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void endShiftTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.btnMarkAsRead();
		fieldAgentStartShiftPage.doClickTabStartShift();
		Thread.sleep(3000);
		fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);
		softAssert.assertTrue(fieldAgentStartShiftPage.isEndShiftButtonVisible(), "End Shift button should be visible");
		fieldAgentReportsPage = fieldAgentStartShiftPage.doClickEndShift();
		fieldAgentReportsPage.clickPreFlightReports();

		fieldAgentReportsPage.clickEditReport2();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport3();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport4();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport5();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport6();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport7();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport8();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickEditReport9();
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), OperationsHubConstant.ACTIVITY_CODE,
				OperationsHubConstant.STREET_NUMBER, OperationsHubConstant.STREET_NAME,
				OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY, OperationsHubConstant.STATE,
				OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickSubmitReports();
		fieldAgentReportsPage.clickOkButton();
		fieldAgentReportsPage.clickEndShift();
		fieldAgentReportsPage.clickOkButton();
		softAssert.assertAll();
	}

}
