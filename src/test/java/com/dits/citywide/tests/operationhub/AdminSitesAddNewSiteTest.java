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

        // ------------------ General Details ------------------
        String siteName = OperationsHubConstant.SITE_NAME;
        List<String> agencyBeat = Arrays.stream(OperationsHubConstant.AGENCY_BEAT.split(",")).map(String::trim)
                .collect(Collectors.toList());
        List<String> AssignOfficer = Arrays.stream(OperationsHubConstant.ASSIGN_OFFICER.split(",")).map(String::trim)
                .collect(Collectors.toList());
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

        sitesPage.fillGeneralDetails(siteName, agencyBeat, AssignOfficer , callResponse, startTime, endTime, isStationary, isMobile,
                isPayPostRate, isAutoReport, isPdfReport, reportTime, clientEmail, policeAgencies, fireAgencies,
                medicAgencies, otherAgencies, qualifications, accountManagers);

        // ------------------ Address & Geofencing ------------------
        sitesPage.fillAddressDetails(OperationsHubConstant.SITE_STREET_NUMBER, OperationsHubConstant.SITE_STREET_NAME,
                OperationsHubConstant.SITE_CITY, OperationsHubConstant.SITE_STATE, OperationsHubConstant.SITE_ZIP_CODE);
        sitesPage.fillGeofencingDetails(OperationsHubConstant.GEOFENCE_NAME, OperationsHubConstant.GEOFENCE_ADDRESS);

        // ------------------ Contacts ------------------
        sitesPage.fillMainContactDetails(OperationsHubConstant.CONTACT_FIRST_NAME,
                OperationsHubConstant.CONTACT_LAST_NAME, OperationsHubConstant.MAIN_CONTACT_PHONE,
                OperationsHubConstant.MOBILE, OperationsHubConstant.FAX, OperationsHubConstant.CONTACT_EMAIL);
        sitesPage.clickAddSiteContact();
        sitesPage.fillSiteContactDetails(OperationsHubConstant.JOB_TITLE, OperationsHubConstant.NEW_CONTACT_NAME,
                OperationsHubConstant.NEW_CONTACT_PHONE);
        sitesPage.clickSaveAndNext();

        // ------------------ Property & Parking ------------------
        sitesPage.fillPropertyAccessDetails(OperationsHubConstant.GATE_CODE, OperationsHubConstant.ALARM_ARM_CODE,
                OperationsHubConstant.ALARM_UNARM_CODE, OperationsHubConstant.ALARM_NOTES, true,
                OperationsHubConstant.LOCKBOX_CODE, OperationsHubConstant.LOCKBOX_NOTES);
        sitesPage.clickSaveAndNext();

        sitesPage.fillParkingEnforcementDetails(OperationsHubConstant.TOW_COMPANY, OperationsHubConstant.TOW_PHONE,
                true, OperationsHubConstant.TOW_NOTES, true, OperationsHubConstant.PARKING_ENFORCEMENT_NOTES);
        sitesPage.clickSaveAndNext();

        // ------------------ Site Reports & Coverage ------------------
        sitesPage.fillsitereportinstrctions(OperationsHubConstant.Site_Reports);
        sitesPage.clickSaveAndNext();
        sitesPage.filloverallsitercoverage(OperationsHubConstant.Overall_Coverage);
        sitesPage.clickSaveAndNext();

        sitesPage.fillMobileCoverageDetails(
                OperationsHubConstant.MOBILE_COVERAGE_NAME,
                OperationsHubConstant.MOBILE_SERVICE_TYPE,
                OperationsHubConstant.MOBILE_BILLING_TYPE,
                OperationsHubConstant.MOBILE_BILLING_RATE,
                OperationsHubConstant.HOLIDAY_RATE,
                OperationsHubConstant.COVERAGE_END_DATE,
                OperationsHubConstant.MOBILE_DAY_START_TIME,
                OperationsHubConstant.MOBILE_DAY_END_TIME,
                OperationsHubConstant.MOBILE_DAY_HITS,
                OperationsHubConstant.MOBILE_SWING_HITS,
                OperationsHubConstant.MOBILE_NIGHT_HITS,
                OperationsHubConstant.MOBILE_DAY_NOTES,
                OperationsHubConstant.MOBILE_SWING_NOTES,
                OperationsHubConstant.MOBILE_NIGHT_NOTES,
                true,
                true
        );
        sitesPage.clickSaveAndNext();

        sitesPage.fillStationaryCoverageDetails(
                OperationsHubConstant.STATIONARY_COVERAGE_NAME,
                OperationsHubConstant.STATIONARY_SERVICE_TYPE,
                OperationsHubConstant.STATIONARY_COVERAGE_END,
                OperationsHubConstant.STATIONARY_BILLING_TYPE,
                OperationsHubConstant.BILLING_RATE,
                OperationsHubConstant.HOLIDAY_BILLING_RATE,
                OperationsHubConstant.POST_RATE,
                OperationsHubConstant.ALLOWANCE_RATE,
                OperationsHubConstant.ALLOWANCE_TYPE,
                OperationsHubConstant.STATIONARY_START_TIME,
                OperationsHubConstant.STATIONARY_END_TIME,
                OperationsHubConstant.STATIONARY_DAY_NOTES,
                OperationsHubConstant.STATIONARY_SWING_NOTES,
                OperationsHubConstant.STATIONARY_NIGHT_NOTES,
                true
        );
        sitesPage.clickSaveAndNext();

        // ------------------ Site Area ------------------
        sitesPage.fillSiteAreaDetails(
                OperationsHubConstant.SITE_AREA_NAME,
                OperationsHubConstant.SITE_DOOR_GATE_COUNT,
                OperationsHubConstant.SITE_AREA_NOTES,
                OperationsHubConstant.SITE_LOCKUP_TIME,
                OperationsHubConstant.SITE_UNLOCK_TIME,
                true
        );
        sitesPage.clickSaveAndNext();

        // ------------------ Assignments ------------------
        sitesPage.fillAddAssignmentForm(OperationsHubConstant.ASSIGNMENT_NAME,
                OperationsHubConstant.ASSIGNMENT_TEMPLATE, OperationsHubConstant.COVERAGE_TYPE,
                OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK, OperationsHubConstant.ASSIGNMENT_TIME,
                OperationsHubConstant.SNITCH_TIME);
        sitesPage.clickAddAssignment();


        softAssert.assertEquals(sitesPage.getAssignmentName(OperationsHubConstant.ASSIGNMENT_NAME),
                OperationsHubConstant.ASSIGNMENT_NAME);
        softAssert.assertTrue(sitesPage.getTemplateName(OperationsHubConstant.ASSIGNMENT_NAME)
                .equalsIgnoreCase(OperationsHubConstant.ASSIGNMENT_TEMPLATE));
        softAssert.assertAll();

        // ------------------ Checkpoints, Scan & Action Rules ------------------
//        sitesPage.clickCheckPointThatOpensNewTab();
//        softAssert.assertEquals(sitesPage.getHeadingCheckPoint(), "Guard Tour Checkpoints");
//
//        sitesPage.clickAddNewCheckPoint();
//        sitesPage.fillCheckPointForm(OperationsHubConstant.CHECKPOINT_NAME,
//                OperationsHubConstant.CHECKPOINT_DESCRIPTION, OperationsHubConstant.CHECKPOINT_TYPE);
//        sitesPage.clickSave();
//
//        Thread.sleep(2000);
//        sitesPage.clickTabScanRules();
//        sitesPage.clickAddScanRule();
//        sitesPage.fillAddScanRuleForm(OperationsHubConstant.SCAN_TYPE_SCAN_TIME,
//                OperationsHubConstant.SCAN_TYPE_SNITCH_TIME, OperationsHubConstant.ASSIGNMENT_DAYS_OF_WEEK);
//        sitesPage.clickSaveScanRule();
//
//
//        Thread.sleep(2000);
//        sitesPage.clickTabActionsRules();
//        sitesPage.clickAddActionRule();
//        sitesPage.fillAddActionRuleForm(OperationsHubConstant.ACTION_RULE_PRIORITY,
//                OperationsHubConstant.ACTION_RULE_INPUT_TYPE, OperationsHubConstant.ACTION_RULE_DIRECTIVE);
//        sitesPage.clickSaveActionRule();
//        softAssert.assertEquals(sitesPage.getActionRuleSuccessMessage(),
//                OperationsHubConstant.ACTION_RULE_CREATED_SUCCESS_MESSAGE);
 //======================================================================================================//

        sitesPage.clickSaveAndNext();
        sitesPage.clickSaveAndNext();

        // ------------------ Client Payment & Documentation ------------------
        sitesPage.fillSiteDocPaymentTerms(
                OperationsHubConstant.CLIENT_FIRST_NAME,
                OperationsHubConstant.CLIENT_LAST_NAME,
                OperationsHubConstant.CLIENT_COMPANY_NAME,
                OperationsHubConstant.CLIENT_DISPLAY_NAME,
                OperationsHubConstant.CLIENT_PHONE_MAIN,
                OperationsHubConstant.CLIENT_PHONE_MOBILE,
                OperationsHubConstant.CLIENT_FAX,
                OperationsHubConstant.CLIENT_EMAIL,
                OperationsHubConstant.CLIENT_TERMS,
                OperationsHubConstant.BILLING_CYCLE_OPTION,
                OperationsHubConstant.BILLING_START_DATE,
                OperationsHubConstant.INVOICE_NUMBER,
                true,
                true,
                OperationsHubConstant.CLIENT_STREET_NUMBER,
                OperationsHubConstant.CLIENT_STREET_NAME,
                OperationsHubConstant.CLIENT_CITY,
                OperationsHubConstant.CLIENT_STATE,
                OperationsHubConstant.CLIENT_ZIPCODE,
                OperationsHubConstant.CLIENT_COUNTRY
        );
        sitesPage.clickSaveAndNext();

        Thread.sleep(2000);
        sitesPage.addCompliments(OperationsHubConstant.ADD_COMMENTS);
        Thread.sleep(3000);
        sitesPage.clickSaveAndNext();

        sitesPage.enableSiteAndShowEnabled(OperationsHubConstant.SELECT_DISABLE, OperationsHubConstant.SELECT_ENAABLE);
    }
}
