package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.ConversionSiteData;
import com.dits.citywide.pages.admin.ReactAdminAddNewSitePage;
import com.dits.citywide.utilities.ElementUtils;

public class ReactAdminSitesAddNewSiteTest extends BaseTest {

    private ReactAdminAddNewSitePage reactSitesPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Use stage URL from config (set in BaseTest)
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Wait for dashboard to fully load after login
        Thread.sleep(2000);

        reactSitesPage = new ReactAdminAddNewSitePage(driver, new ElementUtils(driver));
    }

    @Test
    public void addNewSiteReactTest() throws InterruptedException {
        // Generate unique site name with timestamp to avoid duplicates
        String uniqueSiteName = ConversionSiteData.SITE_NAME + " " + System.currentTimeMillis();
        System.out.println("Creating site: " + uniqueSiteName);

        // Navigate to Sites and open React Add New Site form
        sitesPage = dashboardPage.doClickSitesTab();
        reactSitesPage.openAddNewSiteForm();

        // ===== PAGE 1: General Details =====
        reactSitesPage.fillGeneralDetails(
                uniqueSiteName, // Use dynamic site name
                ConversionSiteData.AGENCY_BEAT_CSV,
                ConversionSiteData.ASSIGN_OFFICER_CSV,
                ConversionSiteData.CALL_RESPONSE,
                ConversionSiteData.SERVICE_START_TIME,
                ConversionSiteData.SERVICE_END_TIME,
                ConversionSiteData.SITE_TYPE_STATIONARY,
                ConversionSiteData.SITE_TYPE_MOBILE,
                ConversionSiteData.ADMIN_DISPATCH,
                ConversionSiteData.PAY_POST_RATE,
                ConversionSiteData.REPORT_APPROVAL_NEEDED,
                ConversionSiteData.PDF_REPORT_NEEDED,
                ConversionSiteData.REPORT_TIME,
                ConversionSiteData.CLIENT_EMAIL,
                ConversionSiteData.POLICE_AGENCIES_CSV,
                ConversionSiteData.FIRE_AGENCIES_CSV,
                ConversionSiteData.MEDICAL_AGENCIES_CSV,
                ConversionSiteData.OTHER_AGENCIES_CSV,
                ConversionSiteData.ACCOUNT_MANAGER);

        reactSitesPage.fillAddress(
                ConversionSiteData.SITE_STREET_NUMBER,
                ConversionSiteData.SITE_STREET_NAME,
                ConversionSiteData.SITE_CITY,
                ConversionSiteData.SITE_STATE,
                ConversionSiteData.SITE_ZIP_CODE);

        reactSitesPage.fillGeofencing(
                ConversionSiteData.GEOFENCE_RADIUS_TYPE,
                ConversionSiteData.GEOFENCE_RADIUS_VALUE);

        reactSitesPage.fillMainContact(
                ConversionSiteData.CONTACT_FIRST_NAME,
                ConversionSiteData.CONTACT_LAST_NAME,
                ConversionSiteData.MAIN_CONTACT_PHONE,
                ConversionSiteData.CONTACT_MOBILE,
                ConversionSiteData.CONTACT_FAX,
                ConversionSiteData.CONTACT_EMAIL);

        reactSitesPage.addSiteContact(
                ConversionSiteData.SITE_CONTACT_JOB_TITLE,
                ConversionSiteData.SITE_CONTACT_NAME,
                ConversionSiteData.SITE_CONTACT_PHONE);

        reactSitesPage.clickSaveAndNext();
        System.out.println("✅ Page 1 completed");

        // ===== PAGE 2: Property Access =====
        reactSitesPage.fillPropertyAccess(
                ConversionSiteData.GATE_CODE,
                ConversionSiteData.ALARM_CODE_ARM,
                ConversionSiteData.ALARM_CODE_UNARM,
                ConversionSiteData.ALARM_NOTES,
                ConversionSiteData.LOCK_BOX_CODE,
                ConversionSiteData.LOCK_BOX_REQUIRED,
                ConversionSiteData.LOCK_BOX_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 2 completed");

        // ===== PAGE 3: Parking Enforcement =====
        reactSitesPage.fillParkingEnforcement(
                ConversionSiteData.TOW_COMPANY_NAME,
                ConversionSiteData.TOW_COMPANY_PHONE,
                ConversionSiteData.TOW_REQUIREMENT,
                ConversionSiteData.TOWING_NOTES,
                ConversionSiteData.PARKING_ENFORCEMENT_REQUIRED,
                ConversionSiteData.PARKING_ENFORCEMENT_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 3 completed");

        // ===== PAGE 4: Security Report =====
        reactSitesPage.fillSecurityReport(ConversionSiteData.REPORT_INSTRUCTIONS);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 4 completed");

        // ===== PAGE 5: Overall Site Coverage =====
        reactSitesPage.fillOverallSiteCoverage(ConversionSiteData.OVERALL_SITE_COVERAGE_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 5 completed");

        // ===== PAGE 6: Mobile Patrol Coverage =====
        reactSitesPage.fillMobilePatrolCoverage(
                ConversionSiteData.MOBILE_COVERAGE_NAME,
                ConversionSiteData.MOBILE_SERVICE_TYPE,
                ConversionSiteData.MOBILE_BILLING_TYPE,
                ConversionSiteData.MOBILE_USD_RATE,
                ConversionSiteData.MOBILE_HOLIDAY_RATE,
                ConversionSiteData.MOBILE_START_TIME,
                ConversionSiteData.MOBILE_END_TIME,
                ConversionSiteData.MOBILE_DAY_HITS,
                ConversionSiteData.MOBILE_SWING_HITS,
                ConversionSiteData.MOBILE_NIGHT_HITS,
                ConversionSiteData.MOBILE_DAY_NOTES,
                ConversionSiteData.MOBILE_SWING_NOTES,
                ConversionSiteData.MOBILE_NIGHT_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 6 completed");

        // ===== PAGE 7: Admin Coverage =====
        reactSitesPage.fillAdminCoverage(
                ConversionSiteData.ADMIN_COVERAGE_NAME,
                ConversionSiteData.ADMIN_SERVICE_TYPE,
                ConversionSiteData.ADMIN_START_TIME,
                ConversionSiteData.ADMIN_END_TIME,
                ConversionSiteData.ADMIN_DAY_NOTES,
                ConversionSiteData.ADMIN_SWING_NOTES,
                ConversionSiteData.ADMIN_NIGHT_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 7 completed");

        // ===== PAGE 8: Stationary Coverage =====
        reactSitesPage.fillStationaryCoverage(
                ConversionSiteData.STATIONARY_COVERAGE_NAME,
                ConversionSiteData.STATIONARY_SERVICE_TYPE,
                ConversionSiteData.STATIONARY_BILLING_TYPE,
                ConversionSiteData.STATIONARY_USD_RATE,
                ConversionSiteData.STATIONARY_HOLIDAY_RATE,
                ConversionSiteData.STATIONARY_START_TIME,
                ConversionSiteData.STATIONARY_END_TIME,
                ConversionSiteData.STATIONARY_DAY_NOTES,
                ConversionSiteData.STATIONARY_SWING_NOTES,
                ConversionSiteData.STATIONARY_NIGHT_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 8 completed");

        // ===== PAGE 9: Temporary Post Order =====
        reactSitesPage.fillTemporaryPostOrder(
                ConversionSiteData.TEMP_ORDER_NOTES,
                ConversionSiteData.TEMP_ORDER_EXPIRE_DATE);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 9 completed");

        // ===== PAGE 10: Site Area =====
        reactSitesPage.fillSiteArea(
                ConversionSiteData.SITE_AREA_NAME,
                ConversionSiteData.SITE_DOOR_COUNT,
                ConversionSiteData.SITE_AREA_NOTES);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 10 completed");

        // ===== PAGE 11: Post Orders =====
        reactSitesPage.fillPostOrders(
                ConversionSiteData.POST_ORDER_TEXT,
                ConversionSiteData.PROBLEM_AREAS,
                ConversionSiteData.ASSIGNMENT_NAME,
                ConversionSiteData.ASSIGNMENT_TEMPLATE,
                ConversionSiteData.ASSIGNMENT_COVERAGE_TYPE,
                ConversionSiteData.ASSIGNMENT_COVERAGE_NAME,
                ConversionSiteData.ASSIGNMENT_DAYS_OF_WEEK,
                ConversionSiteData.ASSIGNMENT_TIME,
                ConversionSiteData.ASSIGNMENT_SNITCH_TIME);
//        reactSitesPage.addCheckpoint(
//                ConversionSiteData.CHECKPOINT_NAME,
//                ConversionSiteData.CHECKPOINT_DESCRIPTION,
//                ConversionSiteData.CHECKPOINT_TYPE,
//                ConversionSiteData.SCAN_TIME,
//                ConversionSiteData.SNITCH_TIME,
//                ConversionSiteData.ACTIVE_DAYS,
//                ConversionSiteData.ACTION_PRIORITY,
//                ConversionSiteData.ACTION_INPUT_TYPE,
//                ConversionSiteData.ACTION_DIRECTIVE,
//                ConversionSiteData.CHECKPOINT_ADDRESS,
//                ConversionSiteData.CHECKPOINT_RADIUS);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 11 completed");

        // ===== PAGE 12: Site Photos (Skip - file upload) =====
        // reactSitesPage.navigateToSitePhotos();
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 12 completed (skipped photo upload)");

        // ===== PAGE 13: Site Map (Skip - just Update) =====
        // reactSitesPage.navigateToSiteMap();
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 13 completed");

        // ===== PAGE 14: Site Doc/Payment Terms =====
        reactSitesPage.fillSiteDocPayment(
                ConversionSiteData.CLIENT_FIRST_NAME,
                ConversionSiteData.CLIENT_LAST_NAME,
                ConversionSiteData.CLIENT_COMPANY_NAME,
                ConversionSiteData.CLIENT_DISPLAY_NAME,
                ConversionSiteData.CLIENT_MAIN_PHONE,
                ConversionSiteData.CLIENT_MOBILE_PHONE,
                ConversionSiteData.CLIENT_EMAIL_BILLING,
                ConversionSiteData.CLIENT_FAX,
                ConversionSiteData.CLIENT_TERMS,
                ConversionSiteData.BILLING_CYCLE,
                ConversionSiteData.BILLING_INVOICE_NUMBER,
                ConversionSiteData.BILLING_STREET_NUMBER,
                ConversionSiteData.BILLING_STREET_NAME,
                ConversionSiteData.BILLING_CITY,
                ConversionSiteData.BILLING_STATE,
                ConversionSiteData.BILLING_ZIP_CODE,
                ConversionSiteData.BILLING_COUNTRY);
        reactSitesPage.clickUpdate();
        System.out.println("✅ Page 14 completed");

        // ===== PAGE 15: Feedback Comments =====
        reactSitesPage.fillFeedbackComments(ConversionSiteData.FEEDBACK_COMMENTS);
        reactSitesPage.clickUpdate();
        reactSitesPage.clickBackButton();
        System.out.println("✅ Page 15 completed");

        System.out.println("🎉 All 15 pages completed successfully!");
    }
}
