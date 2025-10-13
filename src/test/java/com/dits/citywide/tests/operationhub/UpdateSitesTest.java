package com.dits.citywide.tests.operationhub;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;
import com.dits.citywide.pages.admin.UpdateSites;
import com.dits.citywide.utilities.ElementUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateSitesTest extends BaseTest {

    private UpdateSites updateSitesPage;
	private ElementUtils elementUtils;


    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Perform login
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Initialize ElementUtils with driver
        elementUtils = new ElementUtils(driver);

        // Pass the initialized elementUtils to the Page Object
        updateSitesPage = new UpdateSites(elementUtils);
    }

    @Test
    public void updateSiteTest() throws InterruptedException {

        // Navigate to Sites and click Edit
        dashboardPage.doClickSitesTab();
        updateSitesPage.searchSites(OperationsHubConstant.SEARCH_SITE_NAME);
        Thread.sleep(3000);
        updateSitesPage.clickEditSite();

        // --- Prepare arguments for updateGeneralDetails ---
//        String siteName = OperationsHubConstant.UPDATE_SITE_NAME;
//        List<String> agencyBeat = Arrays.stream(OperationsHubConstant.UPDATE_AGENCY_BEAT.split(","))
//                                        .map(String::trim).collect(Collectors.toList());
//        String callResponse = OperationsHubConstant.UPDATE_CALL_RESPONSE;
//        String startingPoint = OperationsHubConstant.UPDATE_SERVICE_TIME.split("-")[0].trim();
//        boolean isPdfReport = true;
//        String reportTime = OperationsHubConstant.UPDATE_REPORT_TIME;
//        String clientEmail = OperationsHubConstant.UPDATE_CONTACT_EMAIL;
//
//        List<String> policeAgencies = Arrays.stream(OperationsHubConstant.UPDATE_POLICE_AGENCIES.split(","))
//                                            .map(String::trim).collect(Collectors.toList());
//        List<String> fireAgencies = Arrays.stream(OperationsHubConstant.UPDATE_FIRE_AGENCIES.split(","))
//                                          .map(String::trim).collect(Collectors.toList());
//        List<String> medicAgencies = Arrays.stream(OperationsHubConstant.UPDATE_MEDICAL_AGENCIES.split(","))
//                                           .map(String::trim).collect(Collectors.toList());
//        List<String> otherAgencies = Arrays.stream(OperationsHubConstant.UPDATE_OTHER_AGENCIES.split(","))
//                                           .map(String::trim).collect(Collectors.toList());
//        List<String> qualifications = Arrays.stream(OperationsHubConstant.UPDATE_QUALIFICATIONS.split(","))
//                                            .map(String::trim).collect(Collectors.toList());
//        List<String> accountManagers = Arrays.stream(OperationsHubConstant.UPDATE_ACCOUNT_MANAGER.split(","))
//                                             .map(String::trim).collect(Collectors.toList());
//
//        // --- Update General Details ---
//        updateSitesPage.updateGeneralDetails(siteName, agencyBeat, callResponse, startingPoint,
//                isPdfReport, reportTime, clientEmail, policeAgencies, fireAgencies, medicAgencies,
//                otherAgencies, qualifications, accountManagers);
//
//        // --- Update Address ---
//        updateSitesPage.updateAddressDetails(
//                OperationsHubConstant.UPDATE_SITE_STREET_NUMBER,
//                OperationsHubConstant.UPDATE_SITE_STREET_NAME,
//                OperationsHubConstant.UPDATE_SITE_CITY,
//                OperationsHubConstant.UPDATE_SITE_STATE,
//                OperationsHubConstant.UPDATE_SITE_ZIP_CODE
//        );
//        // --- Update Geofencing ---
//        updateSitesPage.updateGeofencingDetails(
//                OperationsHubConstant.UPDATE_GEOFENCE_NAME,
//                OperationsHubConstant.UPDATE_GEOFENCE_ADDRESS
//        );
//
//        // --- Update Main Contact ---
//        updateSitesPage.updateMainContactDetails(
//                OperationsHubConstant.UPDATE_CONTACT_FIRST_NAME,
//                OperationsHubConstant.UPDATE_CONTACT_LAST_NAME,
//                OperationsHubConstant.UPDATE_MAIN_CONTACT_PHONE,
//                OperationsHubConstant.UPDATE_MOBILE,
//                OperationsHubConstant.UPDATE_FAX,
//                OperationsHubConstant.UPDATE_CONTACT_EMAIL
//    );  
//
//        // --- Update Site Contact ---
////        updateSitesPage.clickAddSiteContact();
//        updateSitesPage.updateSiteContactDetails(
//                OperationsHubConstant.UPDATE_JOB_TITLE,
//                OperationsHubConstant.UPDATE_NEW_CONTACT_NAME,
//                OperationsHubConstant.UPDATE_NEW_CONTACT_PHONE
//        );
//        updateSitesPage.clickSaveAndNext();
//
//        // Add additional sections here if required (e.g., coverage, assignments, reports)
//
//        // Optional: Add soft asserts for verification
//        // softAssert.assertEquals(...);
//        // softAssert.assertAll();
//
//
//            // Update Property Access Details
//            updateSitesPage.updatePropertyAccessDetails(
//                    OperationsHubConstant.UPDATE_GATE_CODE,
//                    OperationsHubConstant.UPDATE_ALARM_ARM_CODE,
//                    OperationsHubConstant.UPDATE_ALARM_UNARM_CODE,
//                    OperationsHubConstant.UPDATE_ALARM_NOTES,
//                    true, // Lockbox enabled
//                    OperationsHubConstant.UPDATE_LOCKBOX_CODE,
//                    OperationsHubConstant.UPDATE_LOCKBOX_NOTES
//            );
//            updateSitesPage.clickSaveAndNext();
//            
//            updateSitesPage.updateParkingEnforcementDetails(
//            	    OperationsHubConstant.UPDATE_TOW_COMPANY,
//            	    OperationsHubConstant.UPDATE_TOW_PHONE,
//            	    true,  // Tow Authorized
//            	    OperationsHubConstant.UPDATE_TOW_NOTES,
//            	    true,  // Parking Enforcement Enabled
//            	    OperationsHubConstant.UPDATE_PARKING_NOTES
//            	);
//    7
//            	updateSitesPage.clickSaveAndNext();
//
//            	updateSitesPage.siteReporInstructions(OperationsHubConstant.UPDATE_REPORT_INSTRUCTIONS);
//            	
//            	updateSitesPage.clickSaveAndNext();
//            	
//            	updateSitesPage.overallSiteCoverage(OperationsHubConstant.UPDATE_OVERALL_COVERAGE);
            	
//            	updateSitesPage.updateMobileCoverageDetails(
//            		    OperationsHubConstant.UPDATE_MOBILE_COVERAGE_NAME,   // coverageName
//            		    OperationsHubConstant.UPDATE_MOBILE_SERVICE_TYPE,    // serviceTypeValue (mobile)
//            		    OperationsHubConstant.UPDATE_MOBILE_BILLING_TYPE,    // billingType
//            		    OperationsHubConstant.UPDATE_MOBILE_BILLING_RATE,    // billingRate
//            		    OperationsHubConstant.UPDATE_HOLIDAY_RATE,           // holidayRate
//            		    OperationsHubConstant.UPDATE_COVERAGE_END_DATE,      // coverageEndDate
//            		    OperationsHubConstant.UPDATE_MOBILE_DAY_START_TIME,  // dayStartTime
//            		    OperationsHubConstant.UPDATE_MOBILE_DAY_END_TIME,    // dayEndTime
//            		    OperationsHubConstant.UPDATE_MOBILE_DAY_HITS,        // dayHits
//            		    OperationsHubConstant.UPDATE_MOBILE_SWING_HITS,      // swingHits
//            		    OperationsHubConstant.UPDATE_MOBILE_NIGHT_HITS,      // nightHits
//            		    true,                                                // copyTimesToAll
//            		    true                                                 // copyHitsT    All
//            		);
            		
//            	updateSitesPage.clickSaveAndNext();
//            	updateSitesPage.updateStationaryCoverageDetails(
//            		    OperationsHubConstant.UPDATE_STATIONARY_COVERAGE_NAME,
//            		    OperationsHubConstant.UPDATE_STATIONARY_SERVICE_TYPE,
//            		    OperationsHubConstant.UPDATE_STATIONARY_COVERAGE_END,
//            		    OperationsHubConstant.UPDATE_STATIONARY_BILLING_TYPE,
//            		    OperationsHubConstant.UPDATE_BILLING_RATE,
//            		    OperationsHubConstant.UPDATE_HOLIDAY_BILLING_RATE,
//            		    OperationsHubConstant.UPDATE_POST_RATE,
//            		    OperationsHubConstant.UPDATE_ALLOWANCE_RATE,
//            		    OperationsHubConstant.UPDATE_ALLOWANCE_TYPE,
//            		    OperationsHubConstant.UPDATE_STATIONARY_START_TIME,
//            		    OperationsHubConstant.UPDATE_STATIONARY_END_TIME,
//            		    true
//            		);
//
//            	updateSitesPage.clickSaveAndNext();
            	
            	  updateSitesPage.updateSiteAreaDetails(
            	            OperationsHubConstant.UPDATE_SITE_AREA_NAME,
            	            OperationsHubConstant.UPDATE_SITE_DOOR_GATE_COUNT,
            	            OperationsHubConstant.UPDATE_SITE_AREA_NOTES,
            	            OperationsHubConstant.UPDATE_SITE_LOCKUP_TIME,
            	            OperationsHubConstant.UPDATE_SITE_UNLOCK_TIME,
            	            true
            	    );
            	
            	  updateSitesPage.clickSaveAndNext();
            	
            	
    }
}
