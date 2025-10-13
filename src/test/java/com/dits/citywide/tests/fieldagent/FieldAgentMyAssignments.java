package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;

public class FieldAgentMyAssignments extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void myAssignmentsFieldAgentTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentReportsPage = fieldAgentStartShiftPage.clickOnReportsTab();
		fieldAgentReportsPage.clickMyAssignments();
		fieldAgentReportsPage.enterTextInSearchBox(OperationsHubConstant.ASSIGNMENT_NAME);
		softAssert.assertEquals(fieldAgentReportsPage.getSiteNameByAssignment(OperationsHubConstant.ASSIGNMENT_NAME),
				OperationsHubConstant.ASSIGNMENT_NAME, "Assignment name mismatch!");
		softAssert.assertTrue(fieldAgentReportsPage.getSiteNameByAssignment(OperationsHubConstant.ASSIGNMENT_NAME)
				.contains(HRManagementConstants.SITE), "Site name mismatch!");
		softAssert.assertEquals(fieldAgentReportsPage.getTimeSlotByAssignment(OperationsHubConstant.ASSIGNMENT_NAME),
				OperationsHubConstant.ASSIGNMENT_TIME, "Time slot mismatch!");
		softAssert.assertEquals(fieldAgentReportsPage.getSnitchTimeByAssignment(OperationsHubConstant.ASSIGNMENT_NAME),
				OperationsHubConstant.SNITCH_TIME, "Snitch time mismatch!");
		softAssert.assertTrue(fieldAgentReportsPage.getAddedByByAssignment(OperationsHubConstant.ASSIGNMENT_NAME)
				.contains(prop.getProperty("employeeID")), "Added by mismatch!");
		softAssert.assertEquals(
				fieldAgentReportsPage.getStatusByAssignment(OperationsHubConstant.ASSIGNMENT_NAME).trim(), "Pending",
				"Status mismatch!");
		softAssert.assertTrue(fieldAgentReportsPage.isActionByAssignmentVisible(OperationsHubConstant.ASSIGNMENT_NAME),
				"Action link is not visible!");
		fieldAgentReportsPage.clickActionByAssignment(OperationsHubConstant.ASSIGNMENT_NAME);
		// Thread.sleep(5000);
		fieldAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
				OperationsHubConstant.FILE_DESCRIPTION);
		softAssert.assertTrue(fieldAgentReportsPage.isReportPhotoVideoUploadHeadingVisible());
//		fieldAgentReportsPage.uploadFileMyAssignment(OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK,
//				OperationsHubConstant.FILE_NAME, OperationsHubConstant.FILE_DESCRIPTION);
		fieldAgentReportsPage.clickUpdateLogEntry();
		fieldAgentReportsPage.clickOkButton();
		softAssert.assertTrue(fieldAgentReportsPage.isAllReportsButtonVisible());
		fieldAgentReportsPage.clickMyAssignments();
		softAssert.assertEquals(
				fieldAgentReportsPage.getStatusByAssignment(OperationsHubConstant.ASSIGNMENT_NAME).trim(), "Completed",
				"Status mismatch!");

		fieldAgentReportsPage.clickCheckPointsTab();
		softAssert.assertEquals(fieldAgentReportsPage.getCheckpointByName(OperationsHubConstant.CHECKPOINT_NAME),
				OperationsHubConstant.CHECKPOINT_NAME, "Checkpoint name mismatch!");
		softAssert.assertTrue(fieldAgentReportsPage.getSiteNameByCheckpoint(OperationsHubConstant.CHECKPOINT_NAME)
				.contains(HRManagementConstants.SITE), "Site name mismatch!");
		softAssert.assertEquals(fieldAgentReportsPage.getCheckpointTypeByName(OperationsHubConstant.CHECKPOINT_NAME),
				OperationsHubConstant.CHECKPOINT_TYPE, "Checkpoint type mismatch!");
//		softAssert.assertEquals(fieldAgentReportsPage.getScanTimeByCheckpoint(OperationsHubConstant.CHECKPOINT_NAME),
//				OperationsHubConstant.CHECKPOINT_SCAN_TIME, "Scan time mismatch!");
		softAssert.assertTrue(
				fieldAgentReportsPage.isViewCheckpointByNameVisible(OperationsHubConstant.CHECKPOINT_NAME),
				"View link is not visible!");

		softAssert.assertAll();
	}

}
