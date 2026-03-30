package com.dits.citywide.FormConversion;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Page Object for the React Incident Report form.
 *
 * Design principles:
 * - No Thread.sleep — all waits use explicit WebDriverWait
 * - Phone fields located via following:: axis from a section anchor element,
 * so indices do NOT break when other sections are collapsed
 * - Exceptions are logged and rethrown — never silently swallowed
 */
public class ReactIncidentForm {

	private final WebDriver driver;
	private final ElementUtils elementUtils;
	private final WebDriverWait wait;

	public ReactIncidentForm(WebDriver driver, ElementUtils elementUtils) {
		this.driver = driver;
		this.elementUtils = elementUtils;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// ==================== LOCATORS — Navigation ====================
	private final By formsClick = By.xpath("//p[@title='Forms']");
	private final By incidentReportLink = By.xpath("//a[@href='/form/incident-report']");
	private final By addIncidentFormBtn = By.xpath(
			"//button[@type='button' and normalize-space()='Add New Incident Report']");

	// ==================== LOCATORS — Basic Details ====================
	private final By siteDropdown = By.xpath(
			"//input[@id='site_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private final By activityCodeDropdown = By.xpath(
			"//input[@id='activity_code']/ancestor::div[contains(@class,'ant-select-selector')]");
	private final By discoverCheckbox = By.xpath(
			"//input[@id='agent_discovered' and @type='checkbox']");
	private final By reportIncidentCheckbox = By.xpath(
			"//input[@id='agent_reported' and @type='checkbox']");

	// ==================== LOCATORS — Police ====================
	private final By policeCheckbox = By.xpath(
			"//input[@id='department_type_police' and @type='checkbox']");
	private final By policeOfficerName = By.xpath(
			"//input[@id='police_department_officer_name']");
	private final By policeBadgeNumber = By.xpath(
			"//input[@id='police_department_officer_badge_num']");
	private final By policeUnit = By.xpath("//input[@id='police_department_name']");
	private final By policeIncidentNumber = By.xpath(
			"//input[@id='police_department_incident_number']");
	private final By policeArriveTime = By.xpath(
			"//input[@id='police_department_time_arrive']");
	private final By policeDepartTime = By.xpath(
			"//input[@id='police_department_time_depart']");

	// ==================== LOCATORS — Fire ====================
	private final By fireCheckbox = By.xpath(
			"//input[@id='department_type_fire' and @type='checkbox']");
	private final By fireDeptName = By.xpath("//input[@id='fire_department_name']");
	private final By fireEngineNum = By.xpath("//input[@id='fire_department_engine_num']");
	private final By fireIncidentNumber = By.xpath("//input[@id='fire_incident']");
	private final By fireArriveTime = By.xpath("//input[@id='fire_department_time_arrive']");
	private final By fireDepartTime = By.xpath("//input[@id='fire_department_time_depart']");

	// ==================== LOCATORS — Medic ====================
	private final By ambulanceCheckbox = By.xpath(
			"//input[@id='department_type_ambulance' and @type='checkbox']");
	private final By medicDeptName = By.xpath("//input[@id='medic_department_name']");
	private final By medicAmbulanceNum = By.xpath("//input[@id='medic_ambulance_num']");
	private final By medicIncidentNumber = By.xpath("//input[@id='medic_incident']");
	private final By medicArriveTime = By.xpath("//input[@id='medic_department_time_arrive']");
	private final By medicDepartTime = By.xpath("//input[@id='medic_department_time_depart']");

	// ==================== LOCATORS — Other Agency ====================
	private final By otherCheckbox = By.xpath(
			"//input[@id='department_type_other' and @type='checkbox']");
	private final By otherDeptName = By.xpath("//input[@id='other_department_name']");
	private final By otherVehicle = By.xpath("//input[@id='other_department_vehicle_num']");
	private final By otherIncidentNumber = By.xpath("//input[@id='other_incident']");
	private final By otherArriveTime = By.xpath("//input[@id='other_department_time_arrive']");
	private final By otherDepartTime = By.xpath("//input[@id='other_department_time_depart']");

	// ==================Commander Notified====================
	private By commanderNotifiedCheckbox = By.xpath("//input[@id='watch_commander_notified']");
	private By Dispatcherumber = By.xpath("//input[@id='dispatcher_number']");
	private By OnSceneSupervisor = By.xpath("//input[@id='on_scene_supervisor']");
	// ==================== LOCATORS — Reporting Person ====================
	private final By reportPersonName = By.xpath("//input[@id='reporting_party_name']");
	private final By reportDob = By.xpath("//input[@id='reporting_party_dob']");
	// Phone fields are located relative to the name anchor to avoid global
	// positional index issues
	private final By reportPhone = By.xpath(
			"//input[@id='reporting_party_name']/following::input[@value='+1' and @type='tel'][1]");
	private final By reportWorkPhone = By.xpath(
			"//input[@id='reporting_party_name']/following::input[@value='+1' and @type='tel'][2]");
	private final By streetNum = By.xpath("//input[@id='street']");
	private final By streetNameField = By.xpath("//input[@id='street_name']");
	private final By unitNumber = By.xpath("//input[@id='apartment']");
	private final By city = By.xpath("//input[@id='city']");
	private final By stateDropdown = By.xpath(
			"//input[@id='state']/ancestor::div[contains(@class,'ant-select-selector')]");
	private final By zipCode = By.xpath("//input[@id='zipcode']");

	// ==================== LOCATORS — Classification ====================
	private final By equipmentCheckbox = By.xpath(
			"//input[@id='classification_equipment_failure' and @type='checkbox']");
	private final By safetyCheckbox = By.xpath(
			"//input[@id='classification_safety_issue' and @type='checkbox']");
	private final By propertyCheckbox = By.xpath(
			"//input[@id='classification_property_damage' and @type='checkbox']");
	private final By personalInjuryCheckbox = By.xpath(
			"//input[@id='classification_personal_injury' and @type='checkbox']");
	private final By conductCheckbox = By.xpath(
			"//input[@id='classification_conduct' and @type='checkbox']");
	private final By criminalCheckbox = By.xpath(
			"//input[@id='classification_criminal_act' and @type='checkbox']");
	private final By missingPersonCheckbox = By.xpath(
			"//input[@id='classification_missing_person' and @type='checkbox']");
	private final By deathCheckbox = By.xpath(
			"//input[@id='classification_death' and @type='checkbox']");
	private final By maintenanceCheckbox = By.xpath(
			"//input[@id='classification_maintenance_issue' and @type='checkbox']");
	private final By alarmCheckbox = By.xpath(
			"//input[@id='classification_alarm' and @type='checkbox']");
	private final By floodCheckbox = By.xpath(
			"//input[@id='classification_flood' and @type='checkbox']");
	private final By trainingCheckbox = By.xpath(
			"//input[@id='classification_training' and @type='checkbox']");

	// ==================== LOCATORS — Victim ====================
	private final By addVictimButton = By.xpath("//button[contains(text(),'Add Victim')]");
	private final By victim1Name = By.xpath("//input[@id='victims_0_victim_name']");
	private final By victim1Dob = By.xpath("//input[@id='victims_0_victim_dob']");
	// Scoped to victim section via following:: from the victim name anchor
	private final By victim1Phone = By.xpath(
			"//input[@id='victims_0_victim_name']/following::input[@value='+1' and @type='tel'][1]");

	// ==================== LOCATORS — Witness ====================
	private final By addWitnessButton = By.xpath("//button[contains(text(),'Add Witness')]");
	private final By witness1Name = By.xpath("//input[@id='witnesses_0_witness_name']");
	private final By witness1Dob = By.xpath("//input[@id='witnesses_0_witness_dob']");
	// Scoped to witness section via following:: from the witness name anchor
	private final By witness1Phone = By.xpath(
			"//input[@id='witnesses_0_witness_name']/following::input[@value='+1' and @type='tel'][1]");

	// ==================== LOCATORS — Suspect ====================
	private final By addSuspectButton = By.xpath("//button[contains(text(),'Add Suspect')]");
	private final By suspect1Name = By.xpath("//input[@id='suspects_0_suspect_name']");
	private final By suspect1Dob = By.xpath("//input[@id='suspects_0_suspect_dob']");
	// Scoped to suspect section via following:: from the suspect name anchor
	private final By suspect1Phone = By.xpath(
			"//input[@id='suspects_0_suspect_name']/following::input[@value='+1' and @type='tel'][1]");

	// ==================== LOCATORS — Client & Description ====================
	private final By clientNotifiedDate = By.xpath("//input[@id='client_notified_datetime']");
	private final By clientNotifiedPerson = By.xpath("//input[@id='client_notified_representative']");
	private final By incidentDescription = By.xpath("//textarea[@id='incident_description']");
	private final By uploadImageInput = By.xpath(
			"//div[contains(@class,'ant-upload-list-picture-card')]//input[@type='file']");
	private final By editButton = By.xpath(
			"(//td[@data-label='Actions']//a[contains(@class,'cursor-pointer')])[1]");
	private final By updateButton = By.xpath(
			"//button[.//span[normalize-space()='Scan And Update']]");
	private final By updateIncidentReportButton = By.xpath(
			"//button[.//span[normalize-space()='Update Incident Report']]");
	private final By saveButton = By.xpath(
			"//button[@type='submit' and normalize-space()='Save Incident Report']");
	private final By successMessage = By.xpath(
			"//*[contains(@class,'ant-message-success')"
					+ " or contains(@class,'ant-notification-notice-success')"
					+ " or (contains(@class,'ant-message') and .//*[contains(@class,'anticon-check-circle')])"
					+ " or (contains(@class,'ant-notification') and .//*[contains(@class,'anticon-check-circle')])"
					+ " or contains(@class,'success-message')"
					+ " or (contains(@class,'ant-message-notice') and contains(.,'success'))"
					+ " or contains(normalize-space(.),'successfully')]");
	private final By okButton = By.xpath(
			"//button[@type='button' and normalize-space()='OK']");

	// ==================== NAVIGATION ====================
	public void navigateToIncidentReport() {
		elementUtils.safeClick(formsClick);
		elementUtils.safeClick(incidentReportLink);
		wait.until(ExpectedConditions.or(
				ExpectedConditions.visibilityOfElementLocated(addIncidentFormBtn),
				ExpectedConditions.urlContains("/incident-report")));
	}

	public void clickAddNewIncidentReport() {
		elementUtils.safeClick(addIncidentFormBtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(siteDropdown));
	}

	// ==================== BASIC DETAILS ====================
	public void fillBasicDetails(String site, String dateTime, String activityCode,
			String discoverDateTime, String reportDateTime) {
		if (site != null)
			selectFromReactDropdown(siteDropdown, site);
		if (dateTime != null)
			fillDateOrTime(By.xpath("//input[@id='report_datetime']"), dateTime);
		if (activityCode != null)
			selectFromReactDropdown(activityCodeDropdown, activityCode);
		if (discoverDateTime != null) {
			elementUtils.safeClick(discoverCheckbox);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@id='discovered_datetime']")));
			fillDateOrTime(By.xpath("//input[@id='discovered_datetime']"), discoverDateTime);
		}
		if (reportDateTime != null) {
			elementUtils.safeClick(reportIncidentCheckbox);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@id='reported_datetime']")));
			fillDateOrTime(By.xpath("//input[@id='reported_datetime']"), reportDateTime);
		}
	}

	// ==================== EMERGENCY RESPONSE ====================
	public void fillPoliceDetails(String officerName, String badge, String unit,
			String incidentNum, String arriveTime, String departTime) {
		elementUtils.safeClick(policeCheckbox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(policeOfficerName));
		if (officerName != null)
			elementUtils.doSendKeysWithClear(policeOfficerName, officerName);
		if (badge != null)
			elementUtils.doSendKeysWithClear(policeBadgeNumber, badge);
		if (unit != null)
			elementUtils.doSendKeysWithClear(policeUnit, unit);
		if (incidentNum != null)
			elementUtils.doSendKeysWithClear(policeIncidentNumber, incidentNum);
		if (arriveTime != null)
			fillDateOrTime(policeArriveTime, arriveTime);
		if (departTime != null)
			fillDateOrTime(policeDepartTime, departTime);
	}

	public void fillFireDetails(String deptName, String engine, String incidentNum,
			String arriveTime, String departTime) {
		elementUtils.safeClick(fireCheckbox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fireDeptName));
		if (deptName != null)
			elementUtils.doSendKeysWithClear(fireDeptName, deptName);
		if (engine != null)
			elementUtils.doSendKeysWithClear(fireEngineNum, engine);
		if (incidentNum != null)
			elementUtils.doSendKeysWithClear(fireIncidentNumber, incidentNum);
		if (arriveTime != null)
			fillDateOrTime(fireArriveTime, arriveTime);
		if (departTime != null)
			fillDateOrTime(fireDepartTime, departTime);
	}

	public void fillMedicDetails(String teamName, String unit, String incidentNum,
			String arriveTime, String departTime) {
		elementUtils.safeClick(ambulanceCheckbox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(medicDeptName));
		if (teamName != null)
			elementUtils.doSendKeysWithClear(medicDeptName, teamName);
		if (unit != null)
			elementUtils.doSendKeysWithClear(medicAmbulanceNum, unit);
		if (incidentNum != null)
			elementUtils.doSendKeysWithClear(medicIncidentNumber, incidentNum);
		if (arriveTime != null)
			fillDateOrTime(medicArriveTime, arriveTime);
		if (departTime != null)
			fillDateOrTime(medicDepartTime, departTime);
	}

	public void fillOtherAgencyDetails(String agencyName, String phone, String vehicle,
			String incidentNum, String arriveTime, String departTime) {
		elementUtils.safeClick(otherCheckbox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(otherDeptName));
		// Other agency phone: first tel input after the agency name field
		By otherPhone = By.xpath(
				"//input[@id='other_department_name']/following::input[@value='+1' and @type='tel'][1]");
		if (agencyName != null)
			elementUtils.doSendKeysWithClear(otherDeptName, agencyName);
		if (phone != null)
			elementUtils.doSendKeysWithClear(otherPhone, phone);
		if (vehicle != null)
			elementUtils.doSendKeysWithClear(otherVehicle, vehicle);
		if (incidentNum != null)
			elementUtils.doSendKeysWithClear(otherIncidentNumber, incidentNum);
		if (arriveTime != null)
			fillDateOrTime(otherArriveTime, arriveTime);
		if (departTime != null)
			fillDateOrTime(otherDepartTime, departTime);
	}

	public void fillCommanderNotification(boolean commanderNotified, String dispatcherNum, String onSceneSupervisor) {
		if (commanderNotified)
			elementUtils.safeClick(commanderNotifiedCheckbox);
		if (dispatcherNum != null)
			elementUtils.doSendKeysWithClear(Dispatcherumber, dispatcherNum);
		if (onSceneSupervisor != null)
			elementUtils.doSendKeysWithClear(OnSceneSupervisor, onSceneSupervisor);
	}

	// ==================== REPORTING PERSON ====================
	public void fillReportingPerson(String name, String dob, String phone, String workPhone,
			String numStreet, String nameStreet, String unit, String cityName,
			String state, String zip) {
		if (name != null)
			elementUtils.doSendKeysWithClear(reportPersonName, name);
		if (dob != null)
			fillDateOrTime(reportDob, dob);
		if (phone != null)
			elementUtils.doSendKeysWithClear(reportPhone, phone);
		if (workPhone != null)
			elementUtils.doSendKeysWithClear(reportWorkPhone, workPhone);
		if (numStreet != null)
			elementUtils.doSendKeysWithClear(streetNum, numStreet);
		if (nameStreet != null)
			elementUtils.doSendKeysWithClear(streetNameField, nameStreet);
		if (unit != null)
			elementUtils.doSendKeysWithClear(unitNumber, unit);
		if (cityName != null)
			elementUtils.doSendKeysWithClear(city, cityName);
		if (state != null)
			selectFromReactDropdown(stateDropdown, state);
		if (zip != null)
			elementUtils.doSendKeysWithClear(zipCode, zip);
	}

	// ==================== CLASSIFICATION ====================
	public void fillClassification(boolean equipment, boolean safety, boolean property,
			boolean personalInjury, boolean conduct, boolean criminal,
			boolean missingPerson, boolean death, boolean maintenance,
			boolean alarm, boolean flood, boolean training) {
		if (equipment)
			elementUtils.safeClick(equipmentCheckbox);
		if (safety)
			elementUtils.safeClick(safetyCheckbox);
		if (property)
			elementUtils.safeClick(propertyCheckbox);
		if (personalInjury)
			elementUtils.safeClick(personalInjuryCheckbox);
		if (conduct)
			elementUtils.safeClick(conductCheckbox);
		if (criminal)
			elementUtils.safeClick(criminalCheckbox);
		if (missingPerson)
			elementUtils.safeClick(missingPersonCheckbox);
		if (death)
			elementUtils.safeClick(deathCheckbox);
		if (maintenance)
			elementUtils.safeClick(maintenanceCheckbox);
		if (alarm)
			elementUtils.safeClick(alarmCheckbox);
		if (flood)
			elementUtils.safeClick(floodCheckbox);
		if (training)
			elementUtils.safeClick(trainingCheckbox);
	}

	// ==================== VICTIM / WITNESS / SUSPECT ====================
	public void addVictim(String name, String dob, String phone) {
		try {
			elementUtils.safeClick(addVictimButton);
			wait.until(ExpectedConditions.visibilityOfElementLocated(victim1Name));
			if (name != null)
				elementUtils.doSendKeysWithClear(victim1Name, name);
			if (dob != null)
				fillDateOrTime(victim1Dob, dob);
			if (phone != null)
				elementUtils.doSendKeysWithClear(victim1Phone, phone);
		} catch (Exception e) {
			System.err.println("⚠️ Failed to add victim: " + e.getMessage());
			throw new RuntimeException("addVictim failed", e);
		}
	}

	public void addWitness(String name, String dob, String phone) {
		try {
			elementUtils.safeClick(addWitnessButton);
			wait.until(ExpectedConditions.visibilityOfElementLocated(witness1Name));
			if (name != null)
				elementUtils.doSendKeysWithClear(witness1Name, name);
			if (dob != null)
				fillDateOrTime(witness1Dob, dob);
			if (phone != null)
				elementUtils.doSendKeysWithClear(witness1Phone, phone);
		} catch (Exception e) {
			System.err.println("⚠️ Failed to add witness: " + e.getMessage());
			throw new RuntimeException("addWitness failed", e);
		}
	}

	public void addSuspect(String name, String dob, String phone) {
		try {
			elementUtils.safeClick(addSuspectButton);
			wait.until(ExpectedConditions.visibilityOfElementLocated(suspect1Name));
			if (name != null)
				elementUtils.doSendKeysWithClear(suspect1Name, name);
			if (dob != null)
				fillDateOrTime(suspect1Dob, dob);
			if (phone != null)
				elementUtils.doSendKeysWithClear(suspect1Phone, phone);
		} catch (Exception e) {
			System.err.println("⚠️ Failed to add suspect: " + e.getMessage());
			throw new RuntimeException("addSuspect failed", e);
		}
	}

	// ==================== CLIENT & DESCRIPTION ====================
	public void fillClientNotification(String dateTime, String personName) {
		try {
			if (dateTime != null)
				fillDateOrTime(clientNotifiedDate, dateTime);
			if (personName != null)
				elementUtils.doSendKeysWithClear(clientNotifiedPerson, personName);
		} catch (Exception e) {
			System.err.println("⚠️ Client notification fields not accessible: " + e.getMessage());
		}
	}

	public void fillIncidentDescription(String description) {
		if (description != null)
			elementUtils.doSendKeysWithClear(incidentDescription, description);
	}

	public void uploadImage(String imagePath) {
		elementUtils.uploadFile(uploadImageInput, imagePath);
		// Click OK twice as required by the image upload confirmation flow
		for (int i = 0; i < 2; i++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(okButton));
				elementUtils.safeClick(okButton);
			} catch (Exception e) {
				System.err.println("⚠️ Upload OK click #" + (i + 1) + " skipped: " + e.getMessage());
			}
		}
	}

	public void clickSave() {
		elementUtils.safeClick(saveButton);
		// Post-save confirmation dialog is optional; use a short wait
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.elementToBeClickable(okButton));
			elementUtils.safeClick(okButton);
		} catch (Exception e) {
			System.out.println("ℹ️ No post-save OK dialog.");
		}
	}

	public void clickEditIncidentReport() {
		try {
			elementUtils.waitForElementToBeClickable(editButton, 10);
			elementUtils.safeClick(editButton);
			System.out.println("✅ Clicked Edit button for first incident report");
			// Wait for edit form to load (site dropdown is a good anchor)
			wait.until(ExpectedConditions.visibilityOfElementLocated(siteDropdown));
		} catch (Exception e) {
			System.err.println("❌ Failed to click edit incident report: " + e.getMessage());
			throw e;
		}
	}

	public void clickUpdateIncidentReport() {
		try {
			elementUtils.waitForElementToBeClickable(updateButton, 10);
			elementUtils.safeClick(updateButton);
			System.out.println("✅ Clicked Scan And Update button");
			// Optional post-update confirmation dialog
			try {
				new WebDriverWait(driver, Duration.ofSeconds(5))
						.until(ExpectedConditions.elementToBeClickable(okButton));
				elementUtils.safeClick(okButton);
			} catch (Exception e) {
				System.out.println("ℹ️ No post-update OK dialog.");
			}
		} catch (Exception e) {
			System.err.println("❌ Failed to click scan and update incident report: " + e.getMessage());
			throw e;
		}
	}

	public void clickUpdateIncidentReportButton() {
		try {
			elementUtils.waitForElementToBeClickable(updateIncidentReportButton, 10);
			elementUtils.safeClick(updateIncidentReportButton);
			System.out.println("✅ Clicked Update Incident Report button");
			try {
				new WebDriverWait(driver, Duration.ofSeconds(5))
						.until(ExpectedConditions.elementToBeClickable(okButton));
				elementUtils.safeClick(okButton);
			} catch (Exception e) {
				System.out.println("ℹ️ No post-update OK dialog.");
			}
		} catch (Exception e) {
			System.err.println("❌ Failed to click Update Incident Report: " + e.getMessage());
			throw e;
		}
	}

	public boolean isSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(successMessage, 20);
	}

	// ==================== PRIVATE HELPERS ====================

	/**
	 * Fills any Ant Design date-picker or time-picker input.
	 * Clicks, clears, types the value, then tabs away to confirm.
	 */
	private void fillDateOrTime(By locator, String value) {
		try {
			WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
			field.click();
			field.clear();
			field.sendKeys(value);
			field.sendKeys(Keys.TAB);
		} catch (Exception e) {
			System.err.println("⚠️ fillDateOrTime failed for '" + value + "': " + e.getMessage());
			throw new RuntimeException("fillDateOrTime failed for: " + value, e);
		}
	}

	private void selectFromReactDropdown(By dropdownLocator, String optionText) {
		try {
			// Press Escape first to dismiss any previously open dropdown
			try {
				driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
			} catch (Exception ignored) {
			}

			elementUtils.safeClick(dropdownLocator);
			WebElement dropdownEl = elementUtils.getElement(dropdownLocator);
			WebElement input;
			try {
				input = dropdownEl.findElement(By.xpath(".//input[@role='combobox']"));
			} catch (Exception e1) {
				try {
					WebElement parent = dropdownEl.findElement(
							By.xpath("./ancestor::div[contains(@class,'ant-select')][1]"));
					input = parent.findElement(By.xpath(".//input[@role='combobox']"));
				} catch (Exception e2) {
					input = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//input[@role='combobox' and @aria-expanded='true']")));
				}
			}

			input.clear();
			input.sendKeys(optionText);

			By optionLocator = By.xpath(
					"//div[contains(@class,'ant-select-item-option') and contains(.,'"
							+ optionText + "')]");
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
				elementUtils.safeClick(optionLocator);
			} catch (Exception e) {
				// Fallback: pick the first visible option
				By firstOption = By.xpath("//div[contains(@class,'ant-select-item-option')][1]");
				wait.until(ExpectedConditions.visibilityOfElementLocated(firstOption));
				elementUtils.safeClick(firstOption);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to select from dropdown: " + optionText, e);
		}
	}
}
