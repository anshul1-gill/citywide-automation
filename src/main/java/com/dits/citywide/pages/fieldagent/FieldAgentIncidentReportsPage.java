package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.constants.Constants; // added for consistent waits

public class FieldAgentIncidentReportsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNewIncident = By.xpath("//a[normalize-space()='Add New Incident']");
	private By headingAddNewIncident = By.xpath("//h1[contains(normalize-space(),'Add New Incident')]");

	// Add new incident Details
	private By txtboxSiteSearch = By.xpath("//input[@id='site_search']");

	private By getSiteNameLocator(String siteName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", siteName));
	}

	private By datetimeField = By.xpath("//input[@id='report_datetime']");
	private By dropdownActivitycode = By.cssSelector("input[role='combobox']");
	private By searchActivitycode = By.cssSelector("input[placeholder='Search...']");

	private By getStateLocator(String stateCode) {
		return By.xpath(String.format("//span[contains(text(),'%s')]", stateCode));
	}

	private By Checkboxdiscover = By.xpath("//input[@id='agent_discovered']");
	private By discoverdateTime = By.id("discovered_datetime");
	private By reportCheckbox = By.xpath("//input[@id='inlineCheckbox1']");
	private By reportDatetime = By.id("reported_datetime");

	// Police Department
	private By checkboxPolice = By.xpath("//input[@id='department_type_police']");
	private By txtPoliceDepartment = By.xpath("//input[@id='police_department_name']");
	private By txtofficerName = By.xpath("//input[@id='police_department_officer_name']");
	private By txtofficerBadge = By.xpath("//input[@id='police_department_officer_badge_num']");
	private By dateTimeArrived = By.xpath("//input[@id='police_department_time_arrive']");
	private By dateTimeDeparted = By.xpath("//input[@id='police_department_time_depart']");
	private By txtIncidentNumber = By.xpath("//input[@id='police_department_incident_number']");

	// Fire Department
	private By checkboxFire = By.xpath("//input[@id='department_type_fire']");
	private By txtFireDepartment = By.xpath("//input[@id='fire_department_name']");
	private By txtEngine = By.xpath("//input[@id='fire_department_engine_num']");
	private By dateTimeArrive = By.xpath("//input[@id='fire_department_time_arrive']");
	private By dateTimeDepart = By.xpath("//input[@id='fire_department_time_depart']");
	private By txtIncidentNumberfire = By.xpath("//input[@id='fire_incident']");

	// Ambulance Department
	private By checkboxAmbulance = By.xpath("//input[@id='department_type_ambulance']");
	private By txtmedicDepartment = By.xpath("//input[@id='medic_department_name']");
	private By txtmedicUnit = By.xpath("//input[@id='medic_ambulance_num']");
	private By dateTimeArriveAmbulance = By.xpath("//input[@id='medic_department_time_arrive']");
	private By dateTimeDepartAmbulance = By.xpath("//input[@id='medic_department_time_depart']");
	private By txtIncidentNumberAmbulance = By.xpath("//input[@id='medic_incident']");

	// other Department
	private By checkboxOther = By.xpath("//input[@id='department_type_other']");
	private By txtOtherDepartment = By.xpath("//input[@id='other_department_name']");
	private By txtcontantPhone = By.xpath("//input[@id='other_department_phone']");
	private By vehicleNumber = By.xpath("//input[@id='other_department_vehicle_num']");
	private By dateTimeArriveOther = By.xpath("//input[@id='other_department_time_arrive']");
	private By dateTimeDepartOther = By.xpath("//input[@id='other_department_time_depart']");
	private By txtIncidentNumberOther = By.xpath("//input[@id='other_incident']");

	// Commander Notify
	private By checkboxCommander = By.xpath("//input[@id='watch_commander_notified']");
	private By DispatcherNumber = By.xpath("//input[@id='dispatcher_number']"); // fixed missing quote
	private By txtonsceneSupervisor = By.xpath("//input[@id='on_scene_supervisor']");

	// Reporting Person (Not on the Duty security Guard)
	private By txtReportingPerson = By.xpath("//input[@id='reporting_party_name']");
	private By dobReportingPerson = By.xpath("(//input[@placeholder=\"MM/DD/YYYY\"])[1]");
	private By txtReportingPhone = By.xpath("//input[@id='reporting_party_phone']");
	private By workPhoneReportingPerson = By.cssSelector("#reporting_party_phone_work");

	// Reporting Person Address
	private By txtReportingStreetNum = By.xpath("//input[@id='rp_street_num']");
	private By txtReportingStreetName = By.xpath("//input[@id='rp_street']");
	private By txtUnitNum = By.xpath("//input[@id='rp_apartment']");
	private By txtReportingCity = By.xpath("//input[@id='rp_city']");
	private By dropdownReportingState = By.xpath("//select[@id='rp_state']");
	private By txtReportingZipCode = By.xpath("//input[@id='rp_zipcode']");

	// Victim-1 Description
	private By txtVictimName = By.xpath("//input[@id='victim_0_name']");
	private By txtDOBvictim = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[2]");
	private By txtVictimPhone = By.xpath("//input[@id='victim_0_phone']");
	private By txtVictimWorkPhone = By.xpath("//input[@id='victim_0_phone_work']");
	private By dropdownGenderVictim = By.xpath("//select[@id='victim_0_gender']");
	private By dropdownRaceVictim = By.xpath("//select[@id='victim_0_race']");
	private By dropdownVictimHairType = By.xpath("//select[@id='victim_0_hair_type']");
	private By dropdownVictimHairColor = By.xpath("//select[@id='victim_0_hair']");
	private By dropdownVictimEyes = By.xpath("//select[@id='victim_0_eyes']");
	private By dropdownvictimHeight = By.xpath("//select[@id='victim_0_height']");
	private By dropdownBuild = By.xpath("//select[@id='victim_0_build']");
	private By txtWeight = By.xpath("//input[@id='victim_arr.0.weight']");

	// Victim-1 Addresss Information
	private By checkboxvictimAddress = By.xpath("//input[@id='victim_arr.0.victim_checkbox']");
	private By txtstreetAdd = By.cssSelector("#rp_street_num");
	private By txtstreetName = By.cssSelector("input[id='victim_arr.0.person_address_street']");
	private By txtUnitNumber = By.xpath("//input[@id='victim_arr.0.person_address_unit_number']");
	private By txtvictimmCity = By.xpath("//input[@id='victim_arr.0.person_address_city']");
	private By dropdownState = By.cssSelector("#person_address_state");
	private By txtvictimzipcode = By.xpath("//input[@id='victim_arr.0.person_address_zip']");

	// Victim-1 Vehicle Information
	private By checkboxVictimVehicle = By.xpath("//input[@id='victim_arr.0.victim_vehicle_checkbox']");
	private By txtvictimvehicle = By.xpath("//input[@id='victim_arr.0.vehicle_year']");
	private By txtVictimvehiclemake = By.xpath("//input[@id='victim_arr.0.vehicle_make']");
	private By txtvictimvehiclemodel = By.xpath("//input[@id='victim_arr.0.vehicle_model']");
	private By txtvehiclecolor = By.xpath("//input[@id='victim_arr.0.vehicle_color']");
	private By txtVictimvehicleplate = By.xpath("//input[@id='victim_arr.0.vehicle_plate']");
	private By dropdownVictimState = By.xpath("//select[@id='victim_arr.0.vehicle_state']");

	// Witness-1 Description
	private By txtWitnessName = By.xpath("//input[@id='witness_0_name']");
	private By txtWitnessDOB = By.xpath("(//input[@placeholder='MM/DD/YYYY'])[3]");
	private By txtWitnessPhone = By.xpath("//input[@id='witness_0_phone']");
	private By txtWitnessWorkPhone = By.xpath("//input[@id='witness_0_phone_work']");
	private By dropdownWitnessGender = By.xpath("//select[@id='witness_0_gender']");
	private By dropdownWitnessRace = By.cssSelector("#witness_0_race");
	private By dropdownWitnessHairType = By.cssSelector("#witness_0_hair_type");
	private By dropdownWitnessHairColor = By.xpath("//select[@id='witness_0_hair']");
	private By dropdownWitnessEyes = By.xpath("//select[@id='witness_0_eyes']");
	private By dropdownWitnessHeight = By.xpath("//select[@id='witness_0_height']");
	private By dropdownWitnessBuild = By.cssSelector("#witness_0_build");
	private By txtWitnessWeight = By.xpath("//input[@id='witness_0_weight']");

	// Witness-1 Address Information
	private By checkboxWitnessAddress = By.xpath("//input[@id='witness_arr.0.witness_checkbox']");
	private By txtWitnessStreetNum = By.xpath("//input[@id='witness_0_person_address_street_num']");
	private By txtWitnessStreetName = By.xpath("//input[@id='witness_0_street_name']");
	private By txtWitnessUnitNum = By.xpath("//input[@id='witness_0_apartment']");
	private By txtWitnessCity = By.xpath("//input[@id='witness_0_city']");
	private By dropdownWitnessState = By.xpath("//select[@id='witness_0_state']");
	private By txtWitnessZipCode = By.xpath("//input[@id='witness_0_zipcode']");

	// Witness-1 Vehicle Information
	private By checkboxWitnessVehicle = By.xpath("//input[@id='witness_arr.0.witness_vehicle_checkbox']");
	private By txtWitnessVehicleYear = By.xpath("//input[@id='vehicle_year_0']");
	private By txtWitnessVehicleMake = By.xpath("//input[@id='vehicle_make_0']");
	private By txtWitnessVehicleModel = By.xpath("//input[@id='vehicle_model_0']");
	private By txtWitnessVehicleColor = By.xpath("//input[@id='vehicle_color_0']");
	private By txtWitnessVehiclePlate = By.xpath("//input[@id='vehicle_plate_0']");
	private By dropdownWitnessVehicleState = By.xpath("//select[@id='vehicle_state_0']");

	// suspect-1 description
	private By txtSuspectName = By.xpath("//input[@id='suspect_0_name']");
	private By txtSuspectDOB = By.cssSelector("label[for='suspect_arr.0.suspect_info.dob'] + input");
	private By txtSuspectPhone = By.cssSelector("#suspect_0_phone");
	private By txtSuspectWorkPhone = By.cssSelector("#suspect_0_phone_work");
	private By dropdownSuspectGender = By.cssSelector("#suspect_0_gender");
	private By dropdownSuspectRace = By.xpath("//select[@id='suspect_0_race']");
	private By dropdownSuspectHairType = By.xpath("//select[@id='suspect_0_hair_type']");
	private By dropdownSuspectHairColor = By.cssSelector("#suspect_0_hair");
	private By dropdownSuspectEyes = By.xpath("//select[@id='suspect_0_eyes']");
	private By dropdownSuspectHeight = By.xpath("//select[@id='suspect_0_height']");
	private By dropdownSuspectBuild = By.xpath("//select[@id='suspect_0_build']");
	private By txtSuspectWeight = By.xpath("//input[@id='suspect_0_weight']");

	// Suspect-1 Address Information
	private By checkboxSuspectAddress = By.xpath("//input[@id='suspect_arr.0.suspect_checkbox']");
	private By txtSuspectStreetNum = By.xpath("//input[@id='suspect_0_person_address_street_num']");
	private By txtSuspectStreetName = By.xpath("//input[@id='suspect_0_person_address_street']");
	private By txtSuspectUnitNum = By.xpath("//input[@id='suspect_0_person_address_unit_number']");
	private By txtSuspectCity = By.xpath("//input[@id='suspect_0_person_address_city']");
	private By dropdownSuspectState = By.xpath("//select[@id='suspect_0_person_address_state']");
	private By txtSuspectZipCode = By.xpath("//input[@id='suspect_0_person_address_zip']");

	// Suspect-1 Vehicle Information
	private By checkboxSuspectVehicle = By.id("suspect_arr.0.suspect_vehicle_checkbox");
	private By txtboxSuspectVehicleYear = By.cssSelector("#vehicle_year");
	private By txtboxSuspectVehicleMake = By.cssSelector("#vehicle_make");
	private By txtboxSuspectVehicleModel = By.cssSelector("#vehicle_model");
	private By txtboxSuspectVehicleColor = By.cssSelector("#vehicle_color");
	private By txtboxSuspectVehiclePlate = By.cssSelector("#vehicle_plate");
	private By dropdownSuspectVehicleState = By.cssSelector("#vehicle_state");

	// Classification and Disposition
	private By checkboxEquipment = By.xpath("//label[normalize-space()='Equipment Failure']");
	private By checkboxSafety = By.xpath("//label[normalize-space()='Safety Hazard']");
	private By checkboxPropertyDamage = By.xpath("//label[normalize-space()='Property Damage']");
	private By checkboxPersonalinjury = By.xpath("//label[normalize-space()='Personal Injury']");
	private By checkboxConduct = By.xpath("//label[normalize-space()='Conduct']");
	private By checkboxCriminal = By.xpath("//label[normalize-space()='Criminal Act']");
	private By checkboxMissing = By.xpath("//label[normalize-space()='Missing Person']");
	private By checkboxDeath = By.xpath("//label[normalize-space()='Death']");
	private By checkboxMaintenance = By.xpath("//label[normalize-space()='Maintenance Issue']");
	private By checkboxAlarm = By.xpath("//label[normalize-space()='Alarm']");
	private By checkboxFlood = By.xpath("//label[normalize-space()='Flood']");
	private By checkboxTraining = By.xpath("//label[normalize-space()='Training']");

	// Client notified
	private By DateClientNotified = By.xpath("//input[@id='client_notified_date']");
	private By txtClientrepresentative = By.xpath("//input[@id='client_notified_representative']");

	// Incident Description
	private By txtIncidentDescription = By.xpath("//textarea[@id='incident_description']");

	private By incidentReportImageUpload = By.xpath("//input[@type='file']");
	private By txtboxFileName = By.cssSelector("#image_name_0");

	private By deleteImageIcon = By.xpath("//div[normalize-space()='x']");

	// Save Incident Report
	private By btnSaveIncidentReport = By.id("incidentReport");

	private By btnUpdateIncidentReport = By.id("updateIncident");

	// Update

	private By dropdownUpdateWitnessState = By.name("victim_arr.0.victim_address.state");
	private By txtboxUpdateWitnessWeight = By.cssSelector("input[id='witness_arr.0.weight']");
	private By txtboxUpdateWitnessStreetNum = By.cssSelector("input[id='witness_arr.0.street']");
	private By txtboxUpdateWitnessStreetName = By.id("witness_arr.0.person_address_street");
	private By txtboxUpdateWitnessUnitNum = By.id("witness_arr.0.person_address_unit_number");
	private By txtboxUpdateWitnessCity = By.id("witness_arr.0.person_address_city");
	private By dropdownUpdateWitnessStateDropdown = By
			.id("//select[@id='person_address_state' and @name='witness_arr.0.witness_address.state']");
	private By txtboxUpdateWitnessZipCode = By.id("witness_arr.0.person_address_zip");

	private By txtboxUpdateWitnessVehicleYear = By.id("witness_arr.0.vehicle_year");
	private By txtboxUpdateWitnessVehicleMake = By.id("witness_arr.0.vehicle_make");
	private By txtboxUpdateWitnessVehicleModel = By.id("witness_arr.0.vehicle_model");
	private By txtboxUpdateWitnessVehicleColor = By.id("witness_arr.0.vehicle_color");
	private By txtboxUpdateWitnessVehiclePlate = By.id("witness_arr.0.vehicle_plate");
	private By dropdownUpdateWitnessVehicleState = By.id("witness_arr.0.vehicle_state");

	// Data
	private By incidentIdData = By.xpath("(//td[@data-label='Incident']/a)[1]");
	private By brnachData = By.xpath("(//td[@data-label='Branch'])[1]");
	private By siteData = By.xpath("(//td[@data-label='Site'])[1]");
	private By rpNameData = By.xpath("(//td[@data-label='RP name'])[1]");
	private By victimsData = By.xpath("(//td[@data-label='Victims'])[1]");
	private By witnessesData = By.xpath("(//td[@data-label='Witnesses'])[1]");
	private By suspectsData = By.xpath("(//td[@data-label='Suspects'])[1]");
	private By dateDepts = By.xpath("(//td[@data-label='Depts'])[1]");
	private By dateClass = By.xpath("(//td[@data-label='Class'])[1]");

	private By txtboxSearch = By.cssSelector("input[placeholder='Search']");
	// Delete
	private By txtboxCharge = By.cssSelector("#person_charges");

	private By getIncidentDeleteButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Delete Incident']",
				incidentNumber);
		return By.xpath(xpath);
	}

	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By successMessage = By.cssSelector("#swal2-title>span");

	private By txtNoItemsFound = By.xpath("//span[contains(text(),'No items found.')]");

	// Update
	private By getIncidentEditButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Edit Incident']", incidentNumber);
		return By.xpath(xpath);
	}

	public FieldAgentIncidentReportsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickOnAddNewIncident() throws InterruptedException {
		elementUtils.waitForElementVisible(btnAddNewIncident, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddNewIncidentButtonDisplayed() {
		try {
			return elementUtils.doIsDisplayed(btnAddNewIncident, Constants.DEFAULT_WAIT);
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public boolean verifyAddNewIncidentPage() {
		elementUtils.waitForElementVisible(headingAddNewIncident, Constants.DEFAULT_WAIT);
		return elementUtils.doIsDisplayed(headingAddNewIncident, Constants.DEFAULT_WAIT);
	}

	// Further methods to interact with the form can be added here
	public void fillBasicIncidentDetails(String siteName, String dateTime, String activityCode, String discoverDateTime,
			String reportDateTime) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxSiteSearch, Constants.DEFAULT_WAIT).sendKeys(siteName);
		elementUtils.waitForElementVisible(getSiteNameLocator(siteName), Constants.DEFAULT_WAIT).click();
		// elementUtils.waitForElementVisible(datetimeField,
		// Constants.DEFAULT_WAIT).sendKeys(dateTime);
		elementUtils.sendKeysUsingJavaScript(datetimeField, dateTime, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.waitForElementVisible(dropdownActivitycode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchActivitycode, Constants.DEFAULT_WAIT).sendKeys(activityCode);
		elementUtils.waitForElementVisible(getStateLocator(activityCode), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(Checkboxdiscover, Constants.DEFAULT_WAIT).click();
		// elementUtils.waitForElementVisible(discoverdateTime,
		// Constants.DEFAULT_WAIT).sendKeys(discoverDateTime);
		elementUtils.sendKeysUsingJavaScript(discoverdateTime, discoverDateTime, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.waitForElementVisible(reportCheckbox, Constants.DEFAULT_WAIT).click();
		// elementUtils.waitForElementVisible(reportDatetime,
		// Constants.DEFAULT_WAIT).sendKeys(reportDateTime);
		elementUtils.sendKeysUsingJavaScript(reportDatetime, reportDateTime, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
	}

	public void fillPoliceDepartmentDetails(String policeDept, String officerName, String badgeNum, String timeArrive,
			String timeDepart, String incidentNum) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxPolice, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtPoliceDepartment, Constants.DEFAULT_WAIT).sendKeys(policeDept);
		elementUtils.waitForElementVisible(txtofficerName, Constants.DEFAULT_WAIT).sendKeys(officerName);
		elementUtils.waitForElementVisible(txtofficerBadge, Constants.DEFAULT_WAIT).sendKeys(badgeNum);
		// elementUtils.waitForElementVisible(dateTimeArrived,
		// Constants.DEFAULT_WAIT).sendKeys(timeArrive);
		elementUtils.sendKeysUsingJavaScript(dateTimeArrived, timeArrive, Constants.DEFAULT_WAIT);
		// elementUtils.waitForElementVisible(dateTimeDeparted,
		// Constants.DEFAULT_WAIT).sendKeys(timeDepart);
		elementUtils.sendKeysUsingJavaScript(dateTimeDeparted, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtIncidentNumber, Constants.DEFAULT_WAIT).sendKeys(incidentNum);
	}

	public void fillFireDepartmentDetails(String fireDept, String engineNum, String timeArrive, String timeDepart,
			String incidentNum) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxFire, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtFireDepartment, Constants.DEFAULT_WAIT).sendKeys(fireDept);
		elementUtils.waitForElementVisible(txtEngine, Constants.DEFAULT_WAIT).sendKeys(engineNum);
		// elementUtils.waitForElementVisible(dateTimeArrive,
		// Constants.DEFAULT_WAIT).sendKeys(timeArrive);
		elementUtils.sendKeysUsingJavaScript(dateTimeArrive, timeArrive, Constants.DEFAULT_WAIT);
		// elementUtils.waitForElementVisible(dateTimeDepart,
		// Constants.DEFAULT_WAIT).sendKeys(timeDepart);
		elementUtils.sendKeysUsingJavaScript(dateTimeDepart, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtIncidentNumberfire, Constants.DEFAULT_WAIT).sendKeys(incidentNum);
	}

	public void fillAmbulanceDepartmentDetails(String medicDept, String ambulanceNum, String timeArrive,
			String timeDepart, String incidentNum) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxAmbulance, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtmedicDepartment, Constants.DEFAULT_WAIT).sendKeys(medicDept);
		elementUtils.waitForElementVisible(txtmedicUnit, Constants.DEFAULT_WAIT).sendKeys(ambulanceNum);
		// elementUtils.waitForElementVisible(dateTimeArriveAmbulance,
		// Constants.DEFAULT_WAIT).sendKeys(timeArrive);
		elementUtils.sendKeysUsingJavaScript(dateTimeArriveAmbulance, timeArrive, Constants.DEFAULT_WAIT);
		// elementUtils.waitForElementVisible(dateTimeDepartAmbulance,
		// Constants.DEFAULT_WAIT).sendKeys(timeDepart);
		elementUtils.sendKeysUsingJavaScript(dateTimeDepartAmbulance, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtIncidentNumberAmbulance, Constants.DEFAULT_WAIT).sendKeys(incidentNum);
	}

	public void fillOtherDepartmentDetails(String otherDept, String contactPhone, String vehicleNum, String timeArrive,
			String timeDepart, String incidentNum) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxOther, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtOtherDepartment, Constants.DEFAULT_WAIT).sendKeys(otherDept);
		elementUtils.waitForElementVisible(txtcontantPhone, Constants.DEFAULT_WAIT).sendKeys(contactPhone);
		elementUtils.waitForElementVisible(vehicleNumber, Constants.DEFAULT_WAIT).sendKeys(vehicleNum);
		// elementUtils.waitForElementVisible(dateTimeArriveOther,
		// Constants.DEFAULT_WAIT).sendKeys(timeArrive);
		elementUtils.sendKeysUsingJavaScript(dateTimeArriveOther, timeArrive, Constants.DEFAULT_WAIT);
		// elementUtils.waitForElementVisible(dateTimeDepartOther,
		// Constants.DEFAULT_WAIT).sendKeys(timeDepart);
		elementUtils.sendKeysUsingJavaScript(dateTimeDepartOther, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtIncidentNumberOther, Constants.DEFAULT_WAIT).sendKeys(incidentNum);
	}

	public void fillCommanderNotifyDetails(String dispatcherNum, String onSceneSupervisor) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxCommander, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(DispatcherNumber, Constants.DEFAULT_WAIT).sendKeys(dispatcherNum);
		elementUtils.waitForElementVisible(txtonsceneSupervisor, Constants.DEFAULT_WAIT).sendKeys(onSceneSupervisor);
	}

	public void fillReportingPersonDetails(String name, String dob, String phone, String workPhone)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtReportingPerson, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.waitForElementVisible(dobReportingPerson, Constants.DEFAULT_WAIT).sendKeys(dob);
		elementUtils.waitForElementVisible(txtReportingPhone, Constants.DEFAULT_WAIT).sendKeys(phone);
		elementUtils.waitForElementVisible(workPhoneReportingPerson, Constants.DEFAULT_WAIT).sendKeys(workPhone);
	}

	public void fillReportingPersonAddress(String streetNum, String streetName, String unitNum, String city,
			String state, String zipCode) throws InterruptedException {
		elementUtils.waitForElementVisible(txtReportingStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtReportingStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtReportingCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.waitForElementVisible(dropdownReportingState, Constants.DEFAULT_WAIT).click();
		// elementUtils.waitForElementVisible(getStateLocator(state),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doSelectBy(dropdownReportingState, state);
		elementUtils.waitForElementVisible(txtReportingZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillVictim1Details(String name, String dob, String phone, String workPhone, String gender, String race,
			String hairType, String hairColor, String eyeColor, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtVictimName, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.waitForElementVisible(txtDOBvictim, Constants.DEFAULT_WAIT).sendKeys(dob);
		elementUtils.waitForElementVisible(txtVictimPhone, Constants.DEFAULT_WAIT).sendKeys(phone);
		elementUtils.waitForElementVisible(txtVictimWorkPhone, Constants.DEFAULT_WAIT).sendKeys(workPhone);
		elementUtils.doSelectBy(dropdownGenderVictim, gender);
		elementUtils.doSelectBy(dropdownRaceVictim, race);
		elementUtils.doSelectBy(dropdownVictimHairType, hairType);
		elementUtils.doSelectBy(dropdownVictimHairColor, hairColor);
		elementUtils.doSelectBy(dropdownVictimEyes, eyeColor);
		elementUtils.doSelectBy(dropdownvictimHeight, height);
		elementUtils.doSelectBy(dropdownBuild, build);
		elementUtils.waitForElementVisible(txtWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
	}

	public void fillVictim1Address(String streetNum, String steetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxvictimAddress, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtstreetAdd, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtstreetName, Constants.DEFAULT_WAIT).sendKeys(steetName);
		elementUtils.waitForElementVisible(txtUnitNumber, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtvictimmCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.doSelectBy(dropdownState, state);
		elementUtils.waitForElementVisible(txtvictimzipcode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillVictim1VehicleDetails(String vehicleYear, String make, String model, String color, String plate,
			String state) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxVictimVehicle, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtvictimvehicle, Constants.DEFAULT_WAIT).sendKeys(vehicleYear);
		elementUtils.waitForElementVisible(txtVictimvehiclemake, Constants.DEFAULT_WAIT).sendKeys(make);
		elementUtils.waitForElementVisible(txtvictimvehiclemodel, Constants.DEFAULT_WAIT).sendKeys(model);
		elementUtils.waitForElementVisible(txtvehiclecolor, Constants.DEFAULT_WAIT).sendKeys(color);
		elementUtils.waitForElementVisible(txtVictimvehicleplate, Constants.DEFAULT_WAIT).sendKeys(plate);
		elementUtils.doSelectBy(dropdownVictimState, state);
	}

	public void fillWitness1Details(String name, String dob, String phone, String workPhone, String gender, String race,
			String hairType, String hairColor, String eyeColor, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtWitnessName, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.waitForElementVisible(txtWitnessDOB, Constants.DEFAULT_WAIT).sendKeys(dob);
		elementUtils.waitForElementVisible(txtWitnessPhone, Constants.DEFAULT_WAIT).sendKeys(phone);
		elementUtils.waitForElementVisible(txtWitnessWorkPhone, Constants.DEFAULT_WAIT).sendKeys(workPhone);
		elementUtils.doSelectBy(dropdownWitnessGender, gender);
		elementUtils.doSelectBy(dropdownWitnessRace, race);
		elementUtils.doSelectBy(dropdownWitnessHairType, hairType);
		elementUtils.doSelectBy(dropdownWitnessHairColor, hairColor);
		elementUtils.doSelectBy(dropdownWitnessEyes, eyeColor);
		elementUtils.doSelectBy(dropdownWitnessHeight, height);
		elementUtils.doSelectBy(dropdownWitnessBuild, build);
		elementUtils.waitForElementVisible(txtWitnessWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
	}

	public void fillWitness1Address(String streetNum, String streetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxWitnessAddress, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtWitnessStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtWitnessStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtWitnessUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtWitnessCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.waitForElementVisible(dropdownWitnessState, Constants.DEFAULT_WAIT).click();
		elementUtils.doSelectBy(dropdownWitnessState, state);
		elementUtils.waitForElementVisible(txtWitnessZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);

	}

	public void fillWitness1VehicleDetails(String vehicleYear, String make, String model, String color, String plate,
			String state) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxWitnessVehicle, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtWitnessVehicleYear, Constants.DEFAULT_WAIT).sendKeys(vehicleYear);
		elementUtils.waitForElementVisible(txtWitnessVehicleMake, Constants.DEFAULT_WAIT).sendKeys(make);
		elementUtils.waitForElementVisible(txtWitnessVehicleModel, Constants.DEFAULT_WAIT).sendKeys(model);
		elementUtils.waitForElementVisible(txtWitnessVehicleColor, Constants.DEFAULT_WAIT).sendKeys(color);
		elementUtils.waitForElementVisible(txtWitnessVehiclePlate, Constants.DEFAULT_WAIT).sendKeys(plate);
		elementUtils.waitForElementVisible(dropdownWitnessVehicleState, Constants.DEFAULT_WAIT).click();
		elementUtils.doSelectBy(dropdownWitnessVehicleState, state);
	}

	public void fillSuspect1Details(String name, String dob, String phone, String workPhone, String gender, String race,
			String hairType, String hairColor, String eyeColor, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtSuspectName, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.sendKeysUsingJavaScript(txtSuspectDOB, dob, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.waitForElementVisible(txtSuspectPhone, Constants.DEFAULT_WAIT).sendKeys(phone);
		elementUtils.waitForElementVisible(txtSuspectWorkPhone, Constants.DEFAULT_WAIT).sendKeys(workPhone);
		elementUtils.doSelectBy(dropdownSuspectGender, gender);
		elementUtils.doSelectBy(dropdownSuspectRace, race);
		elementUtils.doSelectBy(dropdownSuspectHairType, hairType);
		elementUtils.doSelectBy(dropdownSuspectHairColor, hairColor);
		elementUtils.doSelectBy(dropdownSuspectEyes, eyeColor);
		elementUtils.doSelectBy(dropdownSuspectHeight, height);
		elementUtils.doSelectBy(dropdownSuspectBuild, build);
		elementUtils.waitForElementVisible(txtSuspectWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
	}

	public void fillSuspect1Address(String streetNum, String streetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxSuspectAddress, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtSuspectStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtSuspectStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtSuspectUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtSuspectCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.waitForElementVisible(dropdownSuspectState, Constants.DEFAULT_WAIT).click();
		// elementUtils.waitForElementVisible(getStateLocator(state),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doSelectBy(dropdownSuspectState, state);
		elementUtils.waitForElementVisible(txtSuspectZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillSuspect1VehicleDetails(String vehicleYear, String make, String model, String color, String plate,
			String state) throws InterruptedException {
		elementUtils.waitForElementVisible(checkboxSuspectVehicle, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxSuspectVehicleYear, Constants.DEFAULT_WAIT).sendKeys(vehicleYear);
		elementUtils.waitForElementVisible(txtboxSuspectVehicleMake, Constants.DEFAULT_WAIT).sendKeys(make);
		elementUtils.waitForElementVisible(txtboxSuspectVehicleModel, Constants.DEFAULT_WAIT).sendKeys(model);
		elementUtils.waitForElementVisible(txtboxSuspectVehicleColor, Constants.DEFAULT_WAIT).sendKeys(color);
		elementUtils.waitForElementVisible(txtboxSuspectVehiclePlate, Constants.DEFAULT_WAIT).sendKeys(plate);
		elementUtils.doSelectBy(dropdownSuspectVehicleState, state);
	}

	public void fillClassificationAndDisposition(boolean equipmentFailure, boolean safetyHazard, boolean propertyDamage,
			boolean personalInjury, boolean conduct, boolean criminalAct, boolean missingPerson, boolean death,
			boolean maintenanceIssue, boolean alarm, boolean flood, boolean training) throws InterruptedException {

		clickIfTrue(equipmentFailure, checkboxEquipment);
		clickIfTrue(safetyHazard, checkboxSafety);
		clickIfTrue(propertyDamage, checkboxPropertyDamage);
		clickIfTrue(personalInjury, checkboxPersonalinjury);
		clickIfTrue(conduct, checkboxConduct);
		clickIfTrue(criminalAct, checkboxCriminal);
		clickIfTrue(missingPerson, checkboxMissing);
		clickIfTrue(death, checkboxDeath);
		clickIfTrue(maintenanceIssue, checkboxMaintenance);
		clickIfTrue(alarm, checkboxAlarm);
		clickIfTrue(flood, checkboxFlood);
		clickIfTrue(training, checkboxTraining);

	}

	private void clickIfTrue(boolean condition, By locator) {
		if (condition) {
			elementUtils.waitForElementVisible(locator, Constants.DEFAULT_WAIT).click();
		}
	}

	public void fillClientNotifiedDetails(String date, String representative) {
		elementUtils.sendKeysUsingJavaScript(DateClientNotified, date, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtClientrepresentative, Constants.DEFAULT_WAIT).sendKeys(representative);
	}

	public void fillIncidentDescription(String description) throws InterruptedException {
		elementUtils.waitForElementVisible(txtIncidentDescription, Constants.DEFAULT_WAIT).sendKeys(description);
	}

	public void uploadIncidentReportImage(String imagePath) {
		try {
			elementUtils.uploadFile(incidentReportImageUpload, imagePath);
			elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT).sendKeys("Test Image");
			System.out.println("Image uploaded successfully: " + imagePath);
		} catch (NoSuchElementException e) {
			System.err.println("Upload element not found: " + e.getMessage());
		} catch (TimeoutException e) {
			System.err.println("Timeout while waiting for the upload element: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Failed to upload incident report image: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickOnSaveIncidentReport() throws InterruptedException {
		elementUtils.waitForElementVisible(btnSaveIncidentReport, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000);
	}

	// Get Incident ID
	public String getIncidentID() {
		elementUtils.waitForElementVisible(incidentIdData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(incidentIdData, Constants.DEFAULT_WAIT);
	}

	public String getBranchData() {
		elementUtils.waitForElementVisible(brnachData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(brnachData, Constants.DEFAULT_WAIT);
	}

	public String getSiteData() {
		elementUtils.waitForElementVisible(siteData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(siteData, Constants.DEFAULT_WAIT);
	}

	public String getRpNameData() {
		elementUtils.waitForElementVisible(rpNameData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(rpNameData, Constants.DEFAULT_WAIT);
	}

	public String getVictimsData() {
		elementUtils.waitForElementVisible(victimsData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(victimsData, Constants.DEFAULT_WAIT);
	}

	public String getWitnessesData() {
		elementUtils.waitForElementVisible(witnessesData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(witnessesData, Constants.DEFAULT_WAIT);
	}

	public String getSuspectsData() {
		elementUtils.waitForElementVisible(suspectsData, Constants.DEFAULT_WAIT);
		return elementUtils.getText(suspectsData, Constants.DEFAULT_WAIT);
	}

	public String getDateDepts() {
		elementUtils.waitForElementVisible(dateDepts, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dateDepts, Constants.DEFAULT_WAIT);
	}

	public String getDateClass() {
		elementUtils.waitForElementVisible(dateClass, Constants.DEFAULT_WAIT);
		return elementUtils.getText(dateClass, Constants.DEFAULT_WAIT);
	}

	public void searchIncidentReport(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT).sendKeys(incidentNumber);
		Thread.sleep(2000);
	}

	// Delete
	public void deleteIncidentReport(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(getIncidentDeleteButtonLocator(incidentNumber), Constants.DEFAULT_WAIT)
				.click();
		elementUtils.waitForElementVisible(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getNoRecordFoundMessage() {
		return elementUtils.waitForElementVisible(txtNoItemsFound, Constants.DEFAULT_WAIT).getText();
	}

	public String isSuccessMessageDisplayed() {
		elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT);
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	// Update

	public void clickOnEditIncidentReport(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(getIncidentEditButtonLocator(incidentNumber), Constants.DEFAULT_WAIT)
				.click();
	}

	// Update methods for all fill forms
	public void updateBasicIncidentDetails(String siteName, String dateTime, String activityCode,
			String discoverDateTime, String reportDateTime) throws InterruptedException {
		Thread.sleep(2000);
		// elementUtils.clearTextBoxWithActions(txtboxSiteSearch);
		// elementUtils.doActionsSendKeys(txtboxSiteSearch, siteName);
		// elementUtils.waitForElementVisible(getSiteNameLocator(siteName),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.clearTextBoxWithJS(datetimeField, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(datetimeField, dateTime, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.doClickWithActionsAndWait(dropdownActivitycode, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchActivitycode, activityCode);
		elementUtils.waitForElementVisible(getStateLocator(activityCode), Constants.DEFAULT_WAIT).click();
		elementUtils.clearTextBoxWithJS(discoverdateTime, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(discoverdateTime, discoverDateTime, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.clearTextBoxWithJS(reportDatetime, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(reportDatetime, reportDateTime, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);

	}

	public void updatePoliceDepartmentDetails(String policeDept, String officerName, String badgeNum, String timeArrive,
			String timeDepart, String incidentNum) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtPoliceDepartment);
		elementUtils.doActionsSendKeys(txtPoliceDepartment, policeDept);
		elementUtils.clearTextBoxWithActions(txtofficerName);
		elementUtils.doActionsSendKeys(txtofficerName, officerName);
		elementUtils.clearTextBoxWithActions(txtofficerBadge);
		elementUtils.doActionsSendKeys(txtofficerBadge, badgeNum);
		elementUtils.clearTextBoxWithJS(dateTimeArrived, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeArrived, timeArrive, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithJS(dateTimeDeparted, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeDeparted, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtIncidentNumber);
		elementUtils.doActionsSendKeys(txtIncidentNumber, incidentNum);
	}

	public void updateFireDepartmentDetails(String fireDept, String engineNum, String timeArrive, String timeDepart,
			String incidentNum) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtFireDepartment);
		elementUtils.doActionsSendKeys(txtFireDepartment, fireDept);
		elementUtils.clearTextBoxWithActions(txtEngine);
		elementUtils.doActionsSendKeys(txtEngine, engineNum);
		elementUtils.clearTextBoxWithJS(dateTimeArrive, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeArrive, timeArrive, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithJS(dateTimeDepart, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeDepart, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtIncidentNumberfire);
		elementUtils.doActionsSendKeys(txtIncidentNumberfire, incidentNum);
	}

	public void updateAmbulanceDepartmentDetails(String medicDept, String ambulanceNum, String timeArrive,
			String timeDepart, String incidentNum) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtmedicDepartment);
		elementUtils.doActionsSendKeys(txtmedicDepartment, medicDept);
		elementUtils.clearTextBoxWithActions(txtmedicUnit);
		elementUtils.doActionsSendKeys(txtmedicUnit, ambulanceNum);
		elementUtils.clearTextBoxWithJS(dateTimeArriveAmbulance, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeArriveAmbulance, timeArrive, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithJS(dateTimeDepartAmbulance, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeDepartAmbulance, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtIncidentNumberAmbulance);
		elementUtils.doActionsSendKeys(txtIncidentNumberAmbulance, incidentNum);
	}

	public void updateOtherDepartmentDetails(String otherDept, String contactPhone, String vehicleNum,
			String timeArrive, String timeDepart, String incidentNum) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtOtherDepartment);
		elementUtils.doActionsSendKeys(txtOtherDepartment, otherDept);
		elementUtils.clearTextBoxWithActions(txtcontantPhone);
		elementUtils.doActionsSendKeys(txtcontantPhone, contactPhone);
		elementUtils.clearTextBoxWithActions(vehicleNumber);
		elementUtils.doActionsSendKeys(vehicleNumber, vehicleNum);
		elementUtils.clearTextBoxWithJS(dateTimeArriveOther, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeArriveOther, timeArrive, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithJS(dateTimeDepartOther, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(dateTimeDepartOther, timeDepart, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtIncidentNumberOther);
		elementUtils.doActionsSendKeys(txtIncidentNumberOther, incidentNum);
	}

	public void updateCommanderNotifyDetails(String dispatcherNum, String onSceneSupervisor)
			throws InterruptedException {
		elementUtils.clearTextBoxWithActions(DispatcherNumber);
		elementUtils.doActionsSendKeys(DispatcherNumber, dispatcherNum);
		elementUtils.clearTextBoxWithActions(txtonsceneSupervisor);
		elementUtils.doActionsSendKeys(txtonsceneSupervisor, onSceneSupervisor);
	}

	public void updateReportingPersonDetails(String name, String dob, String phone, String workPhone)
			throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtReportingPerson);
		elementUtils.doActionsSendKeys(txtReportingPerson, name);
		elementUtils.clearTextBoxWithActions(dobReportingPerson);
		elementUtils.doActionsSendKeys(dobReportingPerson, dob);
		elementUtils.clearTextBoxWithActions(txtReportingPhone);
		elementUtils.doActionsSendKeys(txtReportingPhone, phone);
		elementUtils.clearTextBoxWithActions(workPhoneReportingPerson);
		elementUtils.doActionsSendKeys(workPhoneReportingPerson, workPhone);
	}

	public void updateReportingPersonAddress(String streetNum, String streetName, String unitNum, String city,
			String state, String zipCode) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtReportingStreetNum);
		elementUtils.doActionsSendKeys(txtReportingStreetNum, streetNum);
		elementUtils.clearTextBoxWithActions(txtReportingStreetName);
		elementUtils.doActionsSendKeys(txtReportingStreetName, streetName);
		elementUtils.clearTextBoxWithActions(txtUnitNum);
		elementUtils.doActionsSendKeys(txtUnitNum, unitNum);
		elementUtils.clearTextBoxWithActions(txtReportingCity);
		elementUtils.doActionsSendKeys(txtReportingCity, city);
		elementUtils.doSelectBy(dropdownReportingState, state);
		elementUtils.clearTextBoxWithActions(txtReportingZipCode);
		elementUtils.doActionsSendKeys(txtReportingZipCode, zipCode);
	}

	public void updateVictim1Details(String name, String dob, String phone, String workPhone, String gender,
			String race, String hairType, String hairColor, String eyeColor, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtVictimName);
		elementUtils.doActionsSendKeys(txtVictimName, name);
		elementUtils.clearTextBoxWithActions(txtDOBvictim);
		elementUtils.doActionsSendKeys(txtDOBvictim, dob);
		elementUtils.clearTextBoxWithActions(txtVictimPhone);
		elementUtils.doActionsSendKeys(txtVictimPhone, phone);
		elementUtils.clearTextBoxWithActions(txtVictimWorkPhone);
		elementUtils.doActionsSendKeys(txtVictimWorkPhone, workPhone);
		elementUtils.doSelectBy(dropdownGenderVictim, gender);
		elementUtils.doSelectBy(dropdownRaceVictim, race);
		elementUtils.doSelectBy(dropdownVictimHairType, hairType);
		elementUtils.doSelectBy(dropdownVictimHairColor, hairColor);
		elementUtils.doSelectBy(dropdownVictimEyes, eyeColor);
		elementUtils.doSelectBy(dropdownvictimHeight, height);
		elementUtils.doSelectBy(dropdownBuild, build);
		elementUtils.clearTextBoxWithActions(txtWeight);
		elementUtils.doActionsSendKeys(txtWeight, weight);
	}

	public void updateVictim1Address(String streetNum, String steetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtstreetAdd);
		elementUtils.doActionsSendKeys(txtstreetAdd, streetNum);
		elementUtils.clearTextBoxWithActions(txtstreetName);
		elementUtils.doActionsSendKeys(txtstreetName, steetName);
		elementUtils.clearTextBoxWithActions(txtUnitNumber);
		elementUtils.doActionsSendKeys(txtUnitNumber, unitNum);
		elementUtils.clearTextBoxWithActions(txtvictimmCity);
		elementUtils.doActionsSendKeys(txtvictimmCity, city);
		elementUtils.waitForElementVisible(dropdownUpdateWitnessState, Constants.DEFAULT_WAIT);
		elementUtils.doSelectByValue(dropdownUpdateWitnessState, state);
		elementUtils.clearTextBoxWithActions(txtvictimzipcode);
		elementUtils.doActionsSendKeys(txtvictimzipcode, zipCode);
	}

	public void updateVictim1VehicleDetails(String vehicleYear, String make, String model, String color, String plate,
			String state) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtvictimvehicle);
		elementUtils.doActionsSendKeys(txtvictimvehicle, vehicleYear);
		elementUtils.clearTextBoxWithActions(txtVictimvehiclemake);
		elementUtils.doActionsSendKeys(txtVictimvehiclemake, make);
		elementUtils.clearTextBoxWithActions(txtvictimvehiclemodel);
		elementUtils.doActionsSendKeys(txtvictimvehiclemodel, model);
		elementUtils.clearTextBoxWithActions(txtvehiclecolor);
		elementUtils.doActionsSendKeys(txtvehiclecolor, color);
		elementUtils.clearTextBoxWithActions(txtVictimvehicleplate);
		elementUtils.doActionsSendKeys(txtVictimvehicleplate, plate);
		elementUtils.doSelectBy(dropdownVictimState, state);
	}

	public void updateWitness1Details(String name, String dob, String phone, String workPhone, String gender,
			String race, String hairType, String hairColor, String eyeColor, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtWitnessName);
		elementUtils.doActionsSendKeys(txtWitnessName, name);
		elementUtils.clearTextBoxWithActions(txtWitnessDOB);
		elementUtils.doActionsSendKeys(txtWitnessDOB, dob);
		elementUtils.clearTextBoxWithActions(txtWitnessPhone);
		elementUtils.doActionsSendKeys(txtWitnessPhone, phone);
		elementUtils.clearTextBoxWithActions(txtWitnessWorkPhone);
		elementUtils.doActionsSendKeys(txtWitnessWorkPhone, workPhone);
		elementUtils.doSelectBy(dropdownWitnessGender, gender);
		elementUtils.doSelectBy(dropdownWitnessRace, race);
		elementUtils.doSelectBy(dropdownWitnessHairType, hairType);
		elementUtils.doSelectBy(dropdownWitnessHairColor, hairColor);
		elementUtils.doSelectBy(dropdownWitnessEyes, eyeColor);
		elementUtils.doSelectBy(dropdownWitnessHeight, height);
		elementUtils.doSelectBy(dropdownWitnessBuild, build);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessWeight);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessWeight, weight);
	}

	public void updateWitness1Address(String streetNum, String streetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessStreetNum);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessStreetNum, streetNum);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessStreetName);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessStreetName, streetName);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessUnitNum);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessUnitNum, unitNum);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessCity);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessCity, city);
		// elementUtils.waitForElementToBeClickable(dropdownUpdateWitnessStateDropdown,
		// Constants.DEFAULT_WAIT);
		// elementUtils.doSelectBy(dropdownUpdateWitnessStateDropdown, state);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessZipCode);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessZipCode, zipCode);
	}

	public void updateWitness1VehicleDetails(String vehicleYear, String make, String model, String color, String plate,
			String state) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessVehicleYear);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessVehicleYear, vehicleYear);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessVehicleMake);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessVehicleMake, make);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessVehicleModel);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessVehicleModel, model);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessVehicleColor);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessVehicleColor, color);
		elementUtils.clearTextBoxWithActions(txtboxUpdateWitnessVehiclePlate);
		elementUtils.doActionsSendKeys(txtboxUpdateWitnessVehiclePlate, plate);
		elementUtils.waitForElementVisible(dropdownUpdateWitnessVehicleState, Constants.DEFAULT_WAIT);
		elementUtils.doSelectBy(dropdownUpdateWitnessVehicleState, state);
	}

	public void updateSuspect1Details(String name, String dob, String phone, String workPhone, String gender,
			String race, String hairType, String hairColor, String eyeColor, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtSuspectName);
		elementUtils.doActionsSendKeys(txtSuspectName, name);
		elementUtils.clearTextBoxWithJS(txtSuspectDOB, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(txtSuspectDOB, dob, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		elementUtils.clearTextBoxWithActions(txtSuspectPhone);
		elementUtils.doActionsSendKeys(txtSuspectPhone, phone);
		elementUtils.clearTextBoxWithActions(txtSuspectWorkPhone);
		elementUtils.doActionsSendKeys(txtSuspectWorkPhone, workPhone);
		elementUtils.doSelectBy(dropdownSuspectGender, gender);
		elementUtils.doSelectBy(dropdownSuspectRace, race);
		elementUtils.doSelectBy(dropdownSuspectHairType, hairType);
		elementUtils.doSelectBy(dropdownSuspectHairColor, hairColor);
		elementUtils.doSelectBy(dropdownSuspectEyes, eyeColor);
		elementUtils.doSelectBy(dropdownSuspectHeight, height);
		elementUtils.doSelectBy(dropdownSuspectBuild, build);
		elementUtils.clearTextBoxWithActions(txtSuspectWeight);
		elementUtils.doActionsSendKeys(txtSuspectWeight, weight);
	}

	public void updateSuspect1Address(String streetNum, String streetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtSuspectStreetNum);
		elementUtils.doActionsSendKeys(txtSuspectStreetNum, streetNum);
		elementUtils.clearTextBoxWithActions(txtSuspectStreetName);
		elementUtils.doActionsSendKeys(txtSuspectStreetName, streetName);
		elementUtils.clearTextBoxWithActions(txtSuspectUnitNum);
		elementUtils.doActionsSendKeys(txtSuspectUnitNum, unitNum);
		elementUtils.clearTextBoxWithActions(txtSuspectCity);
		elementUtils.doActionsSendKeys(txtSuspectCity, city);
		elementUtils.waitForElementVisible(dropdownSuspectState, Constants.DEFAULT_WAIT);
		elementUtils.doSelectBy(dropdownSuspectState, state);
		elementUtils.clearTextBoxWithActions(txtSuspectZipCode);
		elementUtils.doActionsSendKeys(txtSuspectZipCode, zipCode);

	}

	public void updateSuspect1VehicleDetails(String vehicleYear, String make, String model, String color, String plate,
			String state) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtboxSuspectVehicleYear);
		elementUtils.doActionsSendKeys(txtboxSuspectVehicleYear, vehicleYear);
		elementUtils.clearTextBoxWithActions(txtboxSuspectVehicleMake);
		elementUtils.doActionsSendKeys(txtboxSuspectVehicleMake, make);
		elementUtils.clearTextBoxWithActions(txtboxSuspectVehicleModel);
		elementUtils.doActionsSendKeys(txtboxSuspectVehicleModel, model);
		elementUtils.clearTextBoxWithActions(txtboxSuspectVehicleColor);
		elementUtils.doActionsSendKeys(txtboxSuspectVehicleColor, color);
		elementUtils.clearTextBoxWithActions(txtboxSuspectVehiclePlate);
		elementUtils.doActionsSendKeys(txtboxSuspectVehiclePlate, plate);
		elementUtils.waitForElementVisible(dropdownSuspectVehicleState, Constants.DEFAULT_WAIT);
		elementUtils.doSelectBy(dropdownSuspectVehicleState, state);
	}

	public void updateClassificationAndDisposition(boolean equipmentFailure, boolean safetyHazard,
			boolean propertyDamage, boolean personalInjury, boolean conduct, boolean criminalAct, boolean missingPerson,
			boolean death, boolean maintenanceIssue, boolean alarm, boolean flood, boolean training)
			throws InterruptedException {
		// No clearing needed for checkboxes, just click as needed
		clickIfTrue(equipmentFailure, checkboxEquipment);
		clickIfTrue(safetyHazard, checkboxSafety);
		clickIfTrue(propertyDamage, checkboxPropertyDamage);
		clickIfTrue(personalInjury, checkboxPersonalinjury);
		clickIfTrue(conduct, checkboxConduct);
		clickIfTrue(criminalAct, checkboxCriminal);
		clickIfTrue(missingPerson, checkboxMissing);
		clickIfTrue(death, checkboxDeath);
		clickIfTrue(maintenanceIssue, checkboxMaintenance);
		clickIfTrue(alarm, checkboxAlarm);
		clickIfTrue(flood, checkboxFlood);
		clickIfTrue(training, checkboxTraining);
	}

	public void updateClientNotifiedDetails(String date, String representative) {
		elementUtils.clearTextBoxWithJS(DateClientNotified, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(DateClientNotified, date, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtClientrepresentative);
		elementUtils.doActionsSendKeys(txtClientrepresentative, representative);
	}

	public void updateIncidentDescription(String description) throws InterruptedException {
		elementUtils.clearTextBoxWithActions(txtIncidentDescription);
		elementUtils.doActionsSendKeys(txtIncidentDescription, description);
	}

	public void deleteImageIfExists() throws InterruptedException {
		try {
			WebElement deleteBtn = elementUtils.waitForElementVisible(deleteImageIcon, Constants.DEFAULT_WAIT);
			if (deleteBtn.isDisplayed()) {
				deleteBtn.click();
				elementUtils.waitForElementVisible(btnOk, Constants.DEFAULT_WAIT).click();
				Thread.sleep(2000);
			}
		} catch (TimeoutException e) {
			System.out.println("No existing image to delete.");
		}
	}

	public void updateIncidentReportImage(String imagePath) throws InterruptedException {
		if (imagePath != null && !imagePath.isEmpty()) {
			elementUtils.waitForInvisibilityOfElementLocated(deleteImageIcon, Constants.DEFAULT_WAIT);
			elementUtils.uploadFile(incidentReportImageUpload, imagePath);
			elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT).sendKeys("Image 2");
		}
	}

	public void clickOnUpdateIncidentReport() throws InterruptedException {
		elementUtils.waitForElementVisible(btnUpdateIncidentReport, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000);
	}
}
