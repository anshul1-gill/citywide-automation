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

		// --- Prepare arguments for fillGeneralDetails ---
		// String siteId = "AUTO-SITE-" + System.currentTimeMillis();
		String siteName = OperationsHubConstant.SITE_NAME;
		// List<String> agencyBeat = OperationsHubConstant.AGENCY_BEAT;
		List<String> agencyBeat = Arrays.stream(OperationsHubConstant.AGENCY_BEAT.split(",")).map(String::trim)
				.collect(Collectors.toList());

		// SERVICE_TIME format: "12:00 - 06:00" -> split into start & end
		String serviceTime = OperationsHubConstant.SERVICE_TIME;
		String[] timeParts = serviceTime.split("-");
		String startTime = timeParts[0].trim();
		String endTime = timeParts[1].trim();
		String callResponse = OperationsHubConstant.CALL_RESPONSE;
		boolean isStationary = true;
		boolean isMobile = false;
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

		softAssert.assertAll();
	}
}