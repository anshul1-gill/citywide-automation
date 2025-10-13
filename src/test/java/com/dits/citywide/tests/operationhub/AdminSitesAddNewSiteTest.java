package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdminSitesAddNewSiteTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNewSiteTest() throws InterruptedException {

		Thread.sleep(4000);
		sitesPage = dashboardPage.doClickSitesTab();
		sitesPage.doClickAddNewSiteButton();
		sitesPage.selectBranch(OperationsHubConstant.BRANCH_NAME);

		// --- Prepare arguments for fillGeneralDetails ---//stay uncomment
		// String siteId = "AUTO-SITE-" + System.currentTimeMillis(); //stay uncomment
		String siteName = OperationsHubConstant.SITE_NAME;
//		// List<String> agencyBeat = OperationsHubConstant.AGENCY_BEAT; //stay uncomment
		List<String> agencyBeat = Arrays.stream(OperationsHubConstant.AGENCY_BEAT.split(",")).map(String::trim)
				.collect(Collectors.toList());

		// SERVICE_TIME format: "12:00 - 06:00" -> split into start & end
		String serviceTime = OperationsHubConstant.SERVICE_TIME;
		String[] timeParts = serviceTime.split("-");
		String startTime = timeParts[0].trim();
		String endTime = timeParts[1].trim();
		String callResponse = OperationsHubConstant.CALL_RESPONSE;
		boolean isStationary = true;
		boolean isMobile = true;
		boolean isPayPostRate = true;
		boolean isAutoReport = true;
		boolean isPdfReport = true;

		String reportTime = OperationsHubConstant.REPORT_TIME;
		String clientEmail = "client.automation@example.com";

		List<String> policeAgencies = Arrays.stream(OperationsHubConstant.POLICE_AGENCIES.split(",")).map(String::trim)
				.collect(Collectors.toList());
		List<String> fireAgencies = Arrays.stream(OperationsHubConstant.FIRE_AGENCIES.split(",")).map(String::trim)
				.collect(Collectors.toList());
		List<String> medicAgencies = Arrays.stream(OperationsHubConstant.MEDICAL_AGENCIES.split(",")).map(String::trim)
				.collect(Collectors.toList());
		List<String> otherAgencies = Arrays.stream(OperationsHubConstant.OTHER_AGENCIES.split(",")).map(String::trim)
				.collect(Collectors.toList());
		List<String> qualifications = Arrays.stream(OperationsHubConstant.QUALIFICATIONS.split(",")).map(String::trim)
				.collect(Collectors.toList());
		List<String> accountManagers = Arrays.stream(OperationsHubConstant.ACCOUNT_MANAGER.split(",")).map(String::trim)
				.collect(Collectors.toList());

		sitesPage.fillGeneralDetails(siteName, agencyBeat, callResponse, startTime, endTime, isStationary, isMobile,
				isPayPostRate, isAutoReport, isPdfReport, reportTime, clientEmail, policeAgencies, fireAgencies,
				medicAgencies, otherAgencies, qualifications, accountManagers);

		sitesPage.fillAddressDetails(OperationsHubConstant.SITE_STREET_NUMBER, OperationsHubConstant.SITE_STREET_NAME,
				OperationsHubConstant.SITE_CITY, OperationsHubConstant.SITE_STATE, OperationsHubConstant.SITE_ZIP_CODE);

		sitesPage.fillGeofencingDetails(OperationsHubConstant.GEOFENCE_NAME, OperationsHubConstant.GEOFENCE_ADDRESS);

		sitesPage.fillMainContactDetails(OperationsHubConstant.CONTACT_FIRST_NAME,
				OperationsHubConstant.CONTACT_LAST_NAME, OperationsHubConstant.MAIN_CONTACT_PHONE,
				OperationsHubConstant.MOBILE, OperationsHubConstant.FAX, OperationsHubConstant.CONTACT_EMAIL);

		sitesPage.clickAddSiteContact();

		sitesPage.fillSiteContactDetails(OperationsHubConstant.JOB_TITLE, OperationsHubConstant.NEW_CONTACT_NAME,
				OperationsHubConstant.NEW_CONTACT_PHONE);
		sitesPage.clickSaveAndNext();
		
		sitesPage.fillPropertyAccessDetails(OperationsHubConstant.GATE_CODE , OperationsHubConstant.ALARM_ARM_CODE , 
				OperationsHubConstant.ALARM_UNARM_CODE , OperationsHubConstant.ALARM_NOTES
				,true , OperationsHubConstant.LOCKBOX_CODE , OperationsHubConstant.LOCKBOX_NOTES);
		
		sitesPage.clickSaveAndNext();
		
		sitesPage.fillParkingEnforcementDetails(OperationsHubConstant.TOW_COMPANY , OperationsHubConstant.TOW_PHONE ,
				true , OperationsHubConstant.TOW_NOTES , true , OperationsHubConstant.PARKING_ENFORCEMENT_NOTES);		
		sitesPage.clickSaveAndNext();
		
		sitesPage.fillsitereportinstrctions(OperationsHubConstant.Site_Reports);
		sitesPage.clickSaveAndNext();
		
		sitesPage.filloverallsitercoverage(OperationsHubConstant.Overall_Coverage);
		sitesPage.clickSaveAndNext();
		
		sitesPage.fillMobileCoverageDetails(
			    OperationsHubConstant.MOBILE_COVERAGE_NAME,   // coverageName
			    OperationsHubConstant.MOBILE_SERVICE_TYPE,    // serviceTypeValue (mobile)
			    OperationsHubConstant.MOBILE_BILLING_TYPE,
			    OperationsHubConstant.MOBILE_BILLING_RATE,    // billingRate
			    OperationsHubConstant.HOLIDAY_RATE,          // holidayRate
			    OperationsHubConstant.COVERAGE_END_DATE,     // coverageEndDate
			    OperationsHubConstant.MOBILE_DAY_START_TIME, // dayStartTime
			    OperationsHubConstant.MOBILE_DAY_END_TIME,   // dayEndTime
			    OperationsHubConstant.MOBILE_DAY_HITS,       // dayHits
			    OperationsHubConstant.MOBILE_SWING_HITS,     // swingHits
			    OperationsHubConstant.MOBILE_NIGHT_HITS,     // nightHits
			    OperationsHubConstant.MOBILE_DAY_NOTES,      // dayNotes
			    OperationsHubConstant.MOBILE_SWING_NOTES,    // swingNotes
			    OperationsHubConstant.MOBILE_NIGHT_NOTES,    // nightNotes
			    true,                                        // copyTimesToAll
			    true                                         
			);
		sitesPage.clickSaveAndNext();
		
		sitesPage.fillStationaryCoverageDetails(
			    OperationsHubConstant.STATIONARY_COVERAGE_NAME,  // coverageName
			    OperationsHubConstant.STATIONARY_SERVICE_TYPE,   // serviceTypeValu
			    OperationsHubConstant.STATIONARY_COVERAGE_END,        // coverageEndDate (you can reuse Mobile constant or create separate)
			    OperationsHubConstant.STATIONARY_BILLING_TYPE,
			    OperationsHubConstant.BILLING_RATE,             // billingRate
			    OperationsHubConstant.HOLIDAY_BILLING_RATE,     // holidayRate
			    OperationsHubConstant.POST_RATE,                // postRate
			    OperationsHubConstant.ALLOWANCE_RATE,           // allowanceRate
			    OperationsHubConstant.ALLOWANCE_TYPE,           // allowanceTypeValue
			    OperationsHubConstant.STATIONARY_START_TIME,    // startTime
			    OperationsHubConstant.STATIONARY_END_TIME,      // endTime
			    OperationsHubConstant.STATIONARY_DAY_NOTES,     // dayNotes
			    OperationsHubConstant.STATIONARY_SWING_NOTES,   // swingNotes
			    OperationsHubConstant.STATIONARY_NIGHT_NOTES,   // nightNotes
			    true                                            // copyTimesToAll
			);
		sitesPage.clickSaveAndNext();
		
		sitesPage.fillSiteAreaDetails(
			    OperationsHubConstant.SITE_AREA_NAME,
			    OperationsHubConstant.SITE_DOOR_GATE_COUNT,
			    OperationsHubConstant.SITE_AREA_NOTES,
			    OperationsHubConstant.SITE_LOCKUP_TIME,
			    OperationsHubConstant.SITE_UNLOCK_TIME,
			    true   // copyTimeToAll
			);
		sitesPage.clickSaveAndNext();
//		===================================================================================
//		sitesPage.fillTemporaryPostOrderDetails(
//			    OperationsHubConstant.TEMP_POST_ORDER_EXPIRE_DATE,
//			    OperationsHubConstant.TEMP_POST_ORDER_EXPIRE_TIME,
//			    OperationsHubConstant.TEMP_POST_ORDER_TEXT
//			);
//		sitesPage.clickSaveAndNext(); Uncomment 
/////////////////////////////=======================================================================		
		sitesPage.fillAddAssignmentForm(OperationsHubConstant.ASSIGNMENT_NAME,
				OperationsHubConstant.ASSIGNMENT_TEMPLATE, OperationsHubConstant.COVERAGE_TYPE,
				OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK, OperationsHubConstant.ASSIGNMENT_TIME,
				OperationsHubConstant.SNITCH_TIME);
		sitesPage.clickAddAssignment();

		// Assertions for Assignment
		softAssert.assertEquals(sitesPage.getSuccessMessage(),
				"Assignment \"" + OperationsHubConstant.ASSIGNMENT_NAME + "\" added successfully.");

		softAssert.assertEquals(sitesPage.getAssignmentName(OperationsHubConstant.ASSIGNMENT_NAME),
				OperationsHubConstant.ASSIGNMENT_NAME);

		softAssert.assertTrue(sitesPage.getTemplateName(OperationsHubConstant.ASSIGNMENT_NAME)
				.equalsIgnoreCase(OperationsHubConstant.ASSIGNMENT_TEMPLATE), "Template name mismatch!");

		String actualCoverage = sitesPage.getCoverageType(OperationsHubConstant.ASSIGNMENT_NAME).trim();
		String expectedCoverage = OperationsHubConstant.COVERAGE_TYPE.trim();
		softAssert.assertTrue(
				actualCoverage.startsWith(expectedCoverage) || expectedCoverage.startsWith(actualCoverage),
				"Coverage type mismatch! Expected something like [" + expectedCoverage + "] but found ["
						+ actualCoverage + "]");

		String actualDays = sitesPage.getDaysOfWeek(OperationsHubConstant.ASSIGNMENT_NAME);
		List<String> actualDaysList = Arrays.stream(actualDays.split(",")).map(String::trim).toList();

		softAssert.assertEquals(actualDaysList, OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK,
				"Days of week mismatch!");

		softAssert.assertTrue(sitesPage.getAssignmentTimeSlot(OperationsHubConstant.ASSIGNMENT_NAME)
				.startsWith(OperationsHubConstant.ASSIGNMENT_TIME), "Assignment time mismatch!");

		softAssert.assertTrue(
				sitesPage.getAddedBy(OperationsHubConstant.ASSIGNMENT_NAME).contains(prop.getProperty("email")),
				"Added by mismatch!");
//========================================================================================//
//		sitesPage.clickCheckPointThatOpensNewTab();
//		softAssert.assertEquals(sitesPage.getHeadingCheckPoint(), "Guard Tour Checkpoints");
//
//		sitesPage.clickAddNewCheckPoint();
//		sitesPage.fillCheckPointForm(OperationsHubConstant.CHECKPOINT_NAME,
//				OperationsHubConstant.CHECKPOINT_DESCRIPTION, OperationsHubConstant.CHECKPOINT_TYPE);
//		sitesPage.clickSave();
//
//		Thread.sleep(2000);
//		sitesPage.clickTabScanRules();
//		sitesPage.clickAddScanRule();
//		sitesPage.fillAddScanRuleForm(OperationsHubConstant.SCAN_TYPE_SCAN_TIME,
//				OperationsHubConstant.SCAN_TYPE_SNITCH_TIME, OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK);
//		sitesPage.clickSaveScanRule();
//		softAssert.assertEquals(sitesPage.getScanRuleSuccessMessage(),
//				OperationsHubConstant.SCAN_RULE_CREATED_SUCCESS_MESSAGE);
//
//		Thread.sleep(2000);
//		sitesPage.clickTabActionsRules();
//		sitesPage.clickAddActionRule();
//		sitesPage.fillAddActionRuleForm(OperationsHubConstant.ACTION_RULE_PRIORITY,
//				OperationsHubConstant.ACTION_RULE_INPUT_TYPE, OperationsHubConstant.ACTION_RULE_DIRECTIVE);
//		sitesPage.clickSaveActionRule();
//		softAssert.assertEquals(sitesPage.getActionRuleSuccessMessage(),
//				OperationsHubConstant.ACTION_RULE_CREATED_SUCCESS_MESSAGE);
//
//
//		
//		softAssert.assertAll();
//		sitesPage.clickSaveAndNext();
//		sitesPage.clickSaveAndNext();
//	==============================================================================================stay comment
        sitesPage.fillSiteDocPaymentTerms(
                OperationsHubConstant.CLIENT_FIRST_NAME,     // firstName
                OperationsHubConstant.CLIENT_LAST_NAME,      // lastName
                OperationsHubConstant.CLIENT_COMPANY_NAME,   // companyName
                OperationsHubConstant.CLIENT_DISPLAY_NAME,   // displayName
                OperationsHubConstant.CLIENT_PHONE_MAIN,     // phone
                OperationsHubConstant.CLIENT_PHONE_MOBILE,   // mobile
                OperationsHubConstant.CLIENT_FAX,            // fax
                OperationsHubConstant.CLIENT_EMAIL,          // email
                OperationsHubConstant.CLIENT_TERMS,          // terms
                OperationsHubConstant.BILLING_CYCLE_OPTION,  // billingCycle
                OperationsHubConstant.BILLING_START_DATE,    // billingStartDate
                OperationsHubConstant.INVOICE_NUMBER,        // invoiceNumber
                true ,
                true  ,       
                OperationsHubConstant.CLIENT_STREET_NUMBER,
                OperationsHubConstant.CLIENT_STREET_NAME,
                OperationsHubConstant.CLIENT_CITY,
                OperationsHubConstant.CLIENT_STATE, 
                OperationsHubConstant.CLIENT_ZIPCODE,
                OperationsHubConstant.CLIENT_COUNTRY                
        );
		
        sitesPage.clickSaveAndNext();
       Thread.sleep(2000);
        sitesPage.addCompliments(
        		OperationsHubConstant.ADD_COMMENTS );
        Thread.sleep(3000);
        sitesPage.clickSaveAndNext();
        sitesPage.enableSiteAndShowEnabled(OperationsHubConstant.SELECT_DISABLE , OperationsHubConstant.SELECT_ENAABLE);
	}
}