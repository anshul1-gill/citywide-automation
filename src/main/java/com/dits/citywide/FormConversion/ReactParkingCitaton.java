package com.dits.citywide.FormConversion;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.utilities.ElementUtils;

/**
 * Page Object Model for React Parking Citation form
 * Handles navigation, filtering, and citation creation
 */
public class ReactParkingCitaton {

	private final WebDriver driver;
	private final ElementUtils elementUtils;
	private final WebDriverWait wait;

	// Constructor
	public ReactParkingCitaton(WebDriver driver, ElementUtils elementUtils) {
		this.driver = driver;
		this.elementUtils = elementUtils;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// ==================== LOCATORS ====================

	// Navigation locators
	private By formsclick = By.xpath("//p[@title='Forms']");
	private By parkingcitationclick = By.xpath("//a[@href='/form/parking-citation']");

	// Listing page locators
	private By GlobalSearchparking = By.xpath("//input[@name='Search']");
	private By Filterparkingcitation = By.xpath("//button[@type='button' and normalize-space()='Filters']");
	private By SiteSearchFilter = By.xpath("//input[@placeholder='Site #']");
	private By LicensePlateFilter = By.xpath("//input[@id='license']");
	private By SelectStateDropdown = By
			.xpath("//input[@id='rc_select_2']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectStateOption = By.xpath("//div[@title='California']");
	private By FirstNameInputfield = By.xpath("//input[@id='first_name']");
	private By LastNameInputfield = By.xpath("//input[@placeholder='Last Name']");
	private By ApplyFilterButton = By.xpath("//button[@type='submit' and normalize-space()='Apply Filter']");

	// Lisiting page hyperlinks
	private By dataColumnInccident = By.xpath("//th[.//span[normalize-space()='Incident']]");
	private By hyperlinkIncident = By.xpath("//td[@data-label='Incident']//a");
	private By dataColumnSite = By.xpath("//th[.//span[normalize-space()='Site']]");
	private By hyperlinkSite = By.xpath("//td[@data-label='Site']//a");
	private By dropdownColumn = By.xpath("//button[@type='button' and normalize-space()='Columns']");

	// Actions Listing Page
	private By Eidtbutton = By.xpath("(//td[@data-label='Actions']//a[contains(@class,'cursor-pointer')])[1]");
	private By DeleteCitationButton = By.xpath("(//td[@data-label='Actions']//div[contains(@class,'actionicons deleteIcon')])[1]");

	// Add Citation Locators
	private By Addparkingcitation = By.xpath("//button[@type='button' and normalize-space()='Add New Citation']");
	private By SiteDropdownParkingCiotation = By
			.xpath("//input[@id='site_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By Calldropdownparkingcitatioon = By
			.xpath("//input[@id='call_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By incidentReport = By
			.xpath("//input[@id='incident_report']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By ModalVictimDropdown = By
			.xpath("//span[contains(@class,'collapse-title')]//strong[contains(text(),'Victims')]");
	private By SelectVictim1Modal = By
			.xpath("//div[contains(@class,'person-card')][.//span[contains(text(),'VICTIM')]]");
	private By ConfirmSelectionButton = By.xpath("//button[normalize-space()='Confirm Selection']");
	private By DatePickerParkingCitation = By
			.xpath("//input[@id='notice_datetime']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By DropdownSelectActivityCode = By
			.xpath("//input[@id='activity_code']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VInParkingCitation = By.xpath("//input[@id='ticket_vin']");
	private By LicensePlateParkingCitation = By.xpath("//input[@id='ticket_license_number']");
	private By StateDropdownParkingCitation = By
			.xpath("//input[@id='ticket_license_state']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By expdateParkingCitation = By
			.xpath("//input[@id='ticket_license_expire_date']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By Selectvehiclecolor = By
			.xpath("//input[@id='ticket_vehicle_color']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By Selectvehicleyear = By
			.xpath("//input[@id='ticket_vehicle_year']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By Selectvehiclemake = By
			.xpath("//input[@id='ticket_vehicle_make']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By Selectvehiclemodel = By
			.xpath("//input[@id='ticket_vehicle_model']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectVehicleVoilation = By
			.xpath("//input[@id='vehicle_violation']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By AdditionalDetails = By.xpath("//input[@id='ticket_added_details']");
	private By ButtonShowimpounded = By.xpath("//button[@type='button' and normalize-space()='Show Impounded Fields']");
	private By ImpundedDateTime = By
			.xpath("//input[@id='ticket_impound_datetime']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By TowingComingDropdown = By
			.xpath("//input[@id='ticket_towing_company']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By UploadImageParkigCitation = By
			.xpath("//div[contains(@class,'ant-upload-list-picture-card')]//input[@type='file']");
	private By ButtonSaveCitation = By.xpath("//button[@type='submit' and normalize-space()='Save Citation']");
	private By ButtonUpdateCitation = By.xpath("//button[@type='submit' and normalize-space()='Update Citation']");

	// Success message locator
	private By successMessage = By.xpath(
			"//div[contains(@class,'ant-message-success') or contains(@class,'ant-notification-notice-success')]");

	// ==================== NAVIGATION METHODS ====================

	/**
	 * Navigate to Parking Citation form from main menu
	 */
	public void navigateToParkingCitation() {
		try {
			// Click Forms menu
			elementUtils.waitForElementToBeClickable(formsclick, 10);
			elementUtils.safeClick(formsclick);
			System.out.println("✅ Clicked Forms menu");

			// Click Parking Citation link
			elementUtils.waitForElementToBeClickable(parkingcitationclick, 10);
			elementUtils.safeClick(parkingcitationclick);
			System.out.println("✅ Navigated to Parking Citation page");

			// Wait for page to load
			waitForParkingCitationPageLoad();
		} catch (Exception e) {
			System.err.println("❌ Failed to navigate to Parking Citation: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Wait for Parking Citation page to load
	 */
	private void waitForParkingCitationPageLoad() {
		try {
			wait.until(ExpectedConditions.or(
					ExpectedConditions.visibilityOfElementLocated(Addparkingcitation),
					ExpectedConditions.visibilityOfElementLocated(GlobalSearchparking),
					ExpectedConditions.urlContains("/parking-citation")));
			System.out.println("✅ Parking Citation page loaded");
		} catch (Exception e) {
			System.err.println("⚠️ Parking Citation page may not have loaded completely");
		}
	}

	// ==================== FILTER METHODS ====================

	/**
	 * Open the filters panel
	 */
	public void openFilters() {
		elementUtils.waitForElementToBeClickable(Filterparkingcitation, 10);
		elementUtils.safeClick(Filterparkingcitation);
		System.out.println("✅ Opened filters panel");
	}

	/**
	 * Apply filters with provided criteria
	 */
	public void applyFilters(String siteNumber, String licensePlate, String state,
			String firstName, String lastName) {
		try {
			openFilters();

			// Fill filter fields
			if (siteNumber != null && !siteNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(SiteSearchFilter, siteNumber);
				System.out.println("✅ Entered Site #: " + siteNumber);
			}

			if (licensePlate != null && !licensePlate.isEmpty()) {
				elementUtils.doSendKeysWithClear(LicensePlateFilter, licensePlate);
				System.out.println("✅ Entered License Plate: " + licensePlate);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(SelectStateDropdown, state);
				System.out.println("✅ Selected State: " + state);
			}

			if (firstName != null && !firstName.isEmpty()) {
				elementUtils.doSendKeysWithClear(FirstNameInputfield, firstName);
				System.out.println("✅ Entered First Name: " + firstName);
			}

			if (lastName != null && !lastName.isEmpty()) {
				elementUtils.doSendKeysWithClear(LastNameInputfield, lastName);
				System.out.println("✅ Entered Last Name: " + lastName);
			}

			// Click Apply Filter button
			elementUtils.waitForElementToBeClickable(ApplyFilterButton, 10);
			elementUtils.safeClick(ApplyFilterButton);
			System.out.println("✅ Applied filters");

		} catch (Exception e) {
			System.err.println("❌ Failed to apply filters: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Search using global search
	 */
	public void globalSearch(String searchText) {
		elementUtils.doSendKeysWithClear(GlobalSearchparking, searchText);
		elementUtils.pressEnterKey();
		System.out.println("✅ Performed global search: " + searchText);
	}

	// ==================== ADD CITATION METHODS ====================

	/**
	 * Click Add New Citation button
	 */
	public void clickAddNewCitation() {
		elementUtils.waitForElementToBeClickable(Addparkingcitation, 10);
		elementUtils.safeClick(Addparkingcitation);
		System.out.println("✅ Clicked Add New Citation button");
		waitForCitationFormLoad();
	}

	/**
	 * Wait for citation form to load
	 */
	private void waitForCitationFormLoad() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(SiteDropdownParkingCiotation));
			System.out.println("✅ Citation form loaded");
		} catch (Exception e) {
			System.err.println("️ Citation form may not have loaded completely");
		}
	}

	/**
	 * Fill citation form with all details
	 */
	public void fillCitationForm(String site, String call, String incidentReportValue,
			String noticeDate, String activityCode, String vin,
			String licensePlate, String state, String expDate,
			String vehicleColor, String vehicleYear, String vehicleMake,
			String vehicleModel, String violation, String additionalDetails) {
		try {
			// Site dropdown
			if (site != null && !site.isEmpty()) {
				selectFromReactDropdown(SiteDropdownParkingCiotation, site);
				System.out.println("Selected Site: " + site);
			}

			// Call dropdown
			if (call != null && !call.isEmpty()) {
				selectFromReactDropdown(Calldropdownparkingcitatioon, call);
				System.out.println("Selected Call: " + call);
			}

			// Incident Report dropdown
			if (incidentReportValue != null && !incidentReportValue.isEmpty()) {
				selectFromReactDropdown(incidentReport, incidentReportValue);
				System.out.println(" Selected Incident Report: " + incidentReportValue);
				Thread.sleep(3000); // Wait for form to update based on incident report selection

				// Handle Victim Selection Modal
				try {
					// Click on Victims modal dropdown
					elementUtils.waitForElementToBeClickable(ModalVictimDropdown, 10);
					elementUtils.safeClick(ModalVictimDropdown);
					System.out.println("✅ Clicked Victims dropdown in modal");
					Thread.sleep(1000);

					// Select first victim card
					elementUtils.waitForElementToBeClickable(SelectVictim1Modal, 10);
					elementUtils.safeClick(SelectVictim1Modal);
					System.out.println("✅ Selected first victim from modal");
					Thread.sleep(1000);

					// Click Confirm Selection button
					elementUtils.waitForElementToBeClickable(ConfirmSelectionButton, 10);
					elementUtils.safeClick(ConfirmSelectionButton);
					System.out.println("✅ Clicked Confirm Selection button");
					Thread.sleep(2000); // Wait for modal to close and form to update

				} catch (Exception e) {
					System.err.println("⚠️ Failed to handle victim selection modal: " + e.getMessage());
					// Continue execution even if victim selection fails
				}

			}

			// Notice Date with Time
			if (noticeDate != null && !noticeDate.isEmpty()) {
				try {
					// Direct approach: Type into the input field
					By dateInput = By.xpath("//input[@id='notice_datetime']");
					WebElement inputField = elementUtils.getElement(dateInput);

					if (inputField != null) {
						// Click to focus
						inputField.click();
						Thread.sleep(300);

						// Clear and type the date-time
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(noticeDate);
						Thread.sleep(300);

						// Press Enter to confirm
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);

						System.out.println("✅ Selected Notice Date: " + noticeDate);
					} else {
						System.err.println("⚠️ Date input field not found");
					}
				} catch (Exception e) {
					System.err.println("⚠️ Could not set date-time: " + e.getMessage());
					e.printStackTrace();
				}
			}

			// Activity Code
			if (activityCode != null && !activityCode.isEmpty()) {
				selectFromReactDropdown(DropdownSelectActivityCode, activityCode);
				System.out.println("✅ Selected Activity Code: " + activityCode);
			}

			// VIN
			if (vin != null && !vin.isEmpty()) {
				elementUtils.doSendKeysWithClear(VInParkingCitation, vin);
				System.out.println("✅ Entered VIN: " + vin);
			}

			// License Plate
			if (licensePlate != null && !licensePlate.isEmpty()) {
				elementUtils.doSendKeysWithClear(LicensePlateParkingCitation, licensePlate);
				System.out.println("✅ Entered License Plate: " + licensePlate);
			}

			// State
			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(StateDropdownParkingCitation, state);
				System.out.println("✅ Selected State: " + state);
			}

			// Expiration Date
			if (expDate != null && !expDate.isEmpty()) {
				try {
					By expDateInput = By.xpath("//input[@id='ticket_license_expire_date']");
					WebElement inputField = elementUtils.getElement(expDateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(expDate);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("✅ Selected Expiration Date: " + expDate);
					}
				} catch (Exception e) {
					System.err.println("⚠️ Could not set expiration date: " + e.getMessage());
				}
			}

			// Vehicle Color
			if (vehicleColor != null && !vehicleColor.isEmpty()) {
				selectFromReactDropdown(Selectvehiclecolor, vehicleColor);
				System.out.println("✅ Selected Vehicle Color: " + vehicleColor);
			}

			// Vehicle Year
			if (vehicleYear != null && !vehicleYear.isEmpty()) {
				selectFromReactDropdown(Selectvehicleyear, vehicleYear);
				System.out.println("✅ Selected Vehicle Year: " + vehicleYear);
			}

			// Vehicle Make
			if (vehicleMake != null && !vehicleMake.isEmpty()) {
				selectFromReactDropdown(Selectvehiclemake, vehicleMake);
				System.out.println("✅ Selected Vehicle Make: " + vehicleMake);
			}

			// Vehicle Model
			if (vehicleModel != null && !vehicleModel.isEmpty()) {
				selectFromReactDropdown(Selectvehiclemodel, vehicleModel);
				System.out.println("✅ Selected Vehicle Model: " + vehicleModel);
			}

			// Vehicle Violation
			if (violation != null && !violation.isEmpty()) {
				selectFromReactDropdown(SelectVehicleVoilation, violation);
				System.out.println("✅ Selected Violation: " + violation);
			}

			// Additional Details
			if (additionalDetails != null && !additionalDetails.isEmpty()) {
				elementUtils.doSendKeysWithClear(AdditionalDetails, additionalDetails);
				System.out.println("✅ Entered Additional Details: " + additionalDetails);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill citation form: " + e.getMessage());

		}
	}

	/**
	 * Fill impounded vehicle details
	 */
	public void fillImpoundedDetails(String impoundDateTime, String towingCompany) {
		try {
			// Click Show Impounded Fields button
			elementUtils.waitForElementToBeClickable(ButtonShowimpounded, 10);
			elementUtils.safeClick(ButtonShowimpounded);
			System.out.println(" Clicked Show Impounded Fields");

			// Impound Date Time
			if (impoundDateTime != null && !impoundDateTime.isEmpty()) {
				elementUtils.selectDateInAntPicker(ImpundedDateTime, impoundDateTime);
				System.out.println(" Selected Impound Date Time: " + impoundDateTime);
			}

			// Towing Company
			if (towingCompany != null && !towingCompany.isEmpty()) {
				selectFromReactDropdown(TowingComingDropdown, towingCompany);
				System.out.println(" Selected Towing Company: " + towingCompany);
			}

		} catch (Exception e) {
			System.err.println("Failed to fill impounded details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Upload image to citation
	 */
	public void uploadImage(String imagePath) {
		try {
			elementUtils.uploadFile(UploadImageParkigCitation, imagePath);
			System.out.println(" Uploaded image: " + imagePath);

			// Click OK after upload
			try {
				Thread.sleep(2000); // Wait for modal to appear
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 10);
				elementUtils.safeClick(okButton);
				System.out.println(" Clicked OK button for image upload");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("⚠️ OK button for image upload not found or not clickable: " + e.getMessage());
			}
		} catch (Exception e) {
			System.err.println(" Failed to upload image: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Click Save Citation button
	 */
	public void clickSaveCitation() {
		try {
			elementUtils.waitForElementToBeClickable(ButtonSaveCitation, 10);
			elementUtils.safeClick(ButtonSaveCitation);
			System.out.println(" Clicked Save Citation button");

			// Wait for and click OK button in confirmation dialog
			try {
				Thread.sleep(2000); // 2 seconds wait for dialog to be ready
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 15);
				elementUtils.safeClick(okButton);
				System.out.println(" Clicked OK button to confirm save");
				Thread.sleep(2000); // Wait for submission to process
			} catch (Exception e) {
				System.err.println("OK button for save confirmation not found or not clickable: " + e.getMessage());
			}

			// Wait for success message
			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println(" Failed to save citation: " + e.getMessage());
			throw e;
		}
	}

	// ==================== VERIFICATION METHODS ====================

	// ==================== UPDATE CITATION METHODS ====================

	/**
	 * Click Edit button on first citation from listing page
	 */
	public void clickEditCitation() {
		try {
			elementUtils.waitForElementToBeClickable(Eidtbutton, 10);
			elementUtils.safeClick(Eidtbutton);
			System.out.println("✅ Clicked Edit button for first citation");
			waitForCitationFormLoad();
		} catch (Exception e) {
			System.err.println("❌ Failed to click edit citation: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Update citation form with new values
	 * Only updates fields that are provided (non-null)
	 */
	public void updateCitationForm(String site, String call, String incidentReportValue,
			String noticeDate, String activityCode, String vin,
			String licensePlate, String state, String expDate,
			String vehicleColor, String vehicleYear, String vehicleMake,
			String vehicleModel, String violation, String additionalDetails) {
		try {
			System.out.println("🔄 Updating citation form...");

			// Site dropdown
			if (site != null && !site.isEmpty()) {
				selectFromReactDropdown(SiteDropdownParkingCiotation, site);
				System.out.println("✅ Updated Site: " + site);
			}

			// Call dropdown
			if (call != null && !call.isEmpty()) {
				selectFromReactDropdown(Calldropdownparkingcitatioon, call);
				System.out.println("✅ Updated Call: " + call);
			}

			// Incident Report dropdown
			if (incidentReportValue != null && !incidentReportValue.isEmpty()) {
				selectFromReactDropdown(incidentReport, incidentReportValue);
				System.out.println("✅ Updated Incident Report: " + incidentReportValue);
				Thread.sleep(3000); // Wait for form to update

				// Handle Victim Selection Modal if it appears
				try {
					elementUtils.waitForElementToBeClickable(ModalVictimDropdown, 5);
					elementUtils.safeClick(ModalVictimDropdown);
					System.out.println("✅ Clicked Victims dropdown in modal");
					Thread.sleep(1000);

					elementUtils.waitForElementToBeClickable(SelectVictim1Modal, 5);
					elementUtils.safeClick(SelectVictim1Modal);
					System.out.println("✅ Selected first victim from modal");
					Thread.sleep(1000);

					elementUtils.waitForElementToBeClickable(ConfirmSelectionButton, 5);
					elementUtils.safeClick(ConfirmSelectionButton);
					System.out.println("✅ Clicked Confirm Selection button");
					Thread.sleep(2000);
				} catch (Exception e) {
					System.out.println("ℹ️ Victim modal not shown (might be already selected)");
				}
			}

			// Notice Date with Time
			if (noticeDate != null && !noticeDate.isEmpty()) {
				try {
					By dateInput = By.xpath("//input[@id='notice_datetime']");
					WebElement inputField = elementUtils.getElement(dateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(noticeDate);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("✅ Updated Notice Date: " + noticeDate);
					}
				} catch (Exception e) {
					System.err.println("⚠️ Could not update date-time: " + e.getMessage());
				}
			}

			// Activity Code
			if (activityCode != null && !activityCode.isEmpty()) {
				selectFromReactDropdown(DropdownSelectActivityCode, activityCode);
				System.out.println("✅ Updated Activity Code: " + activityCode);
			}

			// VIN
			if (vin != null && !vin.isEmpty()) {
				elementUtils.doSendKeysWithClear(VInParkingCitation, vin);
				System.out.println("✅ Updated VIN: " + vin);
			}

			// License Plate
			if (licensePlate != null && !licensePlate.isEmpty()) {
				elementUtils.doSendKeysWithClear(LicensePlateParkingCitation, licensePlate);
				System.out.println("✅ Updated License Plate: " + licensePlate);
			}

			// State
			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(StateDropdownParkingCitation, state);
				System.out.println("✅ Updated State: " + state);
			}

			// Expiration Date
			if (expDate != null && !expDate.isEmpty()) {
				try {
					By expDateInput = By.xpath("//input[@id='ticket_license_expire_date']");
					WebElement inputField = elementUtils.getElement(expDateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(expDate);
						Thread.sleep(300);
						inputField.sendKeys(Keys.TAB);
						Thread.sleep(500);
						System.out.println("✅ Updated Expiration Date: " + expDate);
					}
				} catch (Exception e) {
					System.err.println("⚠️ Could not update expiration date: " + e.getMessage());
				}
			}

			// Vehicle Color
			if (vehicleColor != null && !vehicleColor.isEmpty()) {
				selectFromReactDropdown(Selectvehiclecolor, vehicleColor);
				System.out.println("✅ Updated Vehicle Color: " + vehicleColor);
			}

			// Vehicle Year
			if (vehicleYear != null && !vehicleYear.isEmpty()) {
				selectFromReactDropdown(Selectvehicleyear, vehicleYear);
				System.out.println("✅ Updated Vehicle Year: " + vehicleYear);
			}

			// Vehicle Make
			if (vehicleMake != null && !vehicleMake.isEmpty()) {
				selectFromReactDropdown(Selectvehiclemake, vehicleMake);
				System.out.println("✅ Updated Vehicle Make: " + vehicleMake);
			}

			// Vehicle Model
			if (vehicleModel != null && !vehicleModel.isEmpty()) {
				selectFromReactDropdown(Selectvehiclemodel, vehicleModel);
				System.out.println("✅ Updated Vehicle Model: " + vehicleModel);
			}

			// Vehicle Violation
			if (violation != null && !violation.isEmpty()) {
				selectFromReactDropdown(SelectVehicleVoilation, violation);
				System.out.println("✅ Updated Violation: " + violation);
			}

			// Additional Details
			if (additionalDetails != null && !additionalDetails.isEmpty()) {
				elementUtils.doSendKeysWithClear(AdditionalDetails, additionalDetails);
				System.out.println("✅ Updated Additional Details: " + additionalDetails);
			}

			System.out.println("✅ Citation form updated successfully");

		} catch (Exception e) {
			System.err.println("❌ Failed to update citation form: " + e.getMessage());

		}
	}

	/**
	 * Click Update Citation button
	 */
	public void clickUpdateCitation() {
		try {
			elementUtils.waitForElementToBeClickable(ButtonUpdateCitation, 10);
			elementUtils.safeClick(ButtonUpdateCitation);
			System.out.println("✅ Clicked Update Citation button");

			// Wait for and click OK button in confirmation dialog
			try {
				Thread.sleep(2000); // 2 seconds wait for dialog to be ready
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 15);
				elementUtils.safeClick(okButton);
				System.out.println("✅ Clicked OK button to confirm update");
				Thread.sleep(2000); // Wait for submission to process
			} catch (Exception e) {
				System.err
						.println("⚠️ OK button for update confirmation not found or not clickable: " + e.getMessage());
			}

			// Wait for success message
			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println("❌ Failed to update citation: " + e.getMessage());
			throw e;
		}
	}

	// ==================== DELETE CITATION METHOD ====================

	/**
	 * Click Delete button on first citation from listing page and confirm deletion
	 */
	public void deleteCitation() {
		try {
			elementUtils.waitForElementToBeClickable(DeleteCitationButton, 10);
			elementUtils.safeClick(DeleteCitationButton);
			System.out.println("✅ Clicked Delete button for first citation");

			// Wait for and click confirmation button
			try {
				Thread.sleep(1000); // Wait for confirmation dialog
				By confirmButton = By.xpath("//button[@type='button' and contains(text(),'Delete')]");
				elementUtils.waitForElementToBeClickable(confirmButton, 10);
				elementUtils.safeClick(confirmButton);
				System.out.println("✅ Confirmed deletion");
				Thread.sleep(2000); // Wait for deletion to complete
			} catch (Exception e) {
				System.err.println("⚠️ Confirmation button not found or not clickable: " + e.getMessage());
			}

			// Wait for success message
			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println("❌ Failed to delete citation: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Wait for success message after saving citation
	 */
	private void waitForSuccessMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
			System.out.println(" Success message appeared");
		} catch (Exception e) {
			System.err.println("Success message not detected");
		}
	}

	/**
	 * Verify if success message is displayed
	 */
	public boolean isSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(successMessage, 5);
	}

	/**
	 * Click on incident hyperlink (first one in the list)
	 */
	public void clickIncidentHyperlink() {
		elementUtils.waitForElementToBeClickable(hyperlinkIncident, 10);
		elementUtils.safeClick(hyperlinkIncident);
		System.out.println(" Clicked Incident hyperlink");
	}

	/**
	 * Click on site hyperlink (first one in the list)
	 */
	public void clickSiteHyperlink() {
		elementUtils.waitForElementToBeClickable(hyperlinkSite, 10);
		elementUtils.safeClick(hyperlinkSite);
		System.out.println("Clicked Site hyperlink");
	}

	// ==================== HELPER METHODS ====================
	/**
	 * Reusable method to select from React/Ant Design dropdown
	 * Uses typing/search functionality for better reliability
	 */
	private void selectFromReactDropdown(By dropdownLocator, String optionText) {
		try {
			// Step 1: Get the dropdown element
			WebElement dropdownElement = elementUtils.getElement(dropdownLocator);
			if (dropdownElement == null) {
				throw new RuntimeException("Dropdown not found: " + dropdownLocator);
			}

			// Step 2: Click the dropdown to open it
			elementUtils.waitForElementToBeClickable(dropdownLocator, 10);
			elementUtils.safeClick(dropdownLocator);
			System.out.println("🔽 Opened dropdown for: " + optionText);

			// Step 3: Wait for dropdown to open
			Thread.sleep(500);

			// Step 4: Find the input field INSIDE or NEAR this specific dropdown
			WebElement input = null;

			try {
				// Try 1: Find input inside the dropdown element
				input = dropdownElement.findElement(By.xpath(".//input[@role='combobox']"));
			} catch (Exception e1) {
				try {
					// Try 2: Find input in the parent container
					WebElement parent = dropdownElement
							.findElement(By.xpath("./ancestor::div[contains(@class,'ant-select')][1]"));
					input = parent.findElement(By.xpath(".//input[@role='combobox']"));
				} catch (Exception e2) {
					try {
						// Try 3: Find the currently focused input (the one that just opened)
						input = driver.findElement(By.xpath("//input[@role='combobox' and @aria-expanded='true']"));
					} catch (Exception e3) {
						// Try 4: Find any visible combobox input as last resort
						input = driver.findElement(By.xpath("//input[@role='combobox']"));
					}
				}
			}

			if (input == null) {
				throw new RuntimeException("Could not find input field for dropdown");
			}

			// Step 5: Clear any existing value
			input.clear();
			Thread.sleep(500);

			// Step 6: Type the search text
			input.sendKeys(optionText);
			System.out.println("⌨️  Typed: " + optionText);

			// Step 7: Wait for dropdown to filter results (increased to 2 seconds)
			Thread.sleep(2000);

			// Step 8: Press Enter to select the first matching option
			input.sendKeys(Keys.ENTER);
			System.out.println(" Selected by typing: " + optionText);

			// Step 9: Wait for React to update (increased to 500ms)
			Thread.sleep(500);

		} catch (Exception e) {
			System.err.println("️ Dropdown selection failed for: " + optionText);
			e.printStackTrace();
			throw new RuntimeException("Failed to select from dropdown: " + optionText, e);
		}
	}

}
