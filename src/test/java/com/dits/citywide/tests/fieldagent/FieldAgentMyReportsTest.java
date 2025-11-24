package com.dits.citywide.tests.fieldagent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class FieldAgentMyReportsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void myReportsFieldAgentTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentReportsPage = fieldAgentStartShiftPage.clickOnReportsTab();
		softAssert.assertEquals(fieldAgentReportsPage.getArriveDateTime(), prop.getProperty("startShiftDateTime"));
		softAssert.assertTrue(fieldAgentReportsPage.getSiteName().contains(HRManagementConstants.SITE));
		String startShift = prop.getProperty("startShiftDateTime");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime shiftDateTime = LocalDateTime.parse(startShift, formatter);
		String expectedDeparture = shiftDateTime.plusMinutes(15).format(formatter);
		softAssert.assertEquals(fieldAgentReportsPage.getDepartDateTime(), expectedDeparture,
				"Departure DateTime mismatch!");

//		fieldAgentReportsPage.clickPreFlightReports();
//		softAssert.assertEquals(fieldAgentReportsPage.getPreflightConfirmationMessage(),
//				FieldAgentConstants.PREFLIGHT_CONFIRMATION_MESSAGE);
//		fieldAgentReportsPage.clickOkButton();
//		softAssert.assertEquals(fieldAgentReportsPage.getSuccessMessage(),
//				FieldAgentConstants.PREFLIGHT_SUCCESS_MESSAGE);

		fieldAgentReportsPage.clickEditReport2();
		Thread.sleep(2000);
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport3();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport4();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport5();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport6();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport7();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport8();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
//
//		fieldAgentReportsPage.clickEditReport9();
//		Thread.sleep(2000);
//		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
////		fieldAgentReportsPage.uploadFile(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
////				OperationsHubConstant.FILE_DESCRIPTION);
//		fieldAgentReportsPage.clickUpdateLogEntry();
//		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());

		fieldAgentReportsPage.clickSubmitReports();
//		fieldAgentReportsPage.clickOkButton();
		softAssert.assertEquals(fieldAgentReportsPage.getNoDataFoundText(), FieldAgentConstants.NO_DATA_FOUND_TEXT,
				"No Data Found text mismatch!");

		softAssert.assertAll();
	}

}
