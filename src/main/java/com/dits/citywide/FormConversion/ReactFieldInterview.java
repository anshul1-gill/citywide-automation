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

public class ReactFieldInterview {

	private final WebDriver driver;
	private final ElementUtils elementUtils;
	private final WebDriverWait wait;

	// Constructor
	public ReactFieldInterview(WebDriver driver, ElementUtils elementUtils) {
		this.driver = driver;
		this.elementUtils = elementUtils;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// Locators
	private By formsclick = By.xpath("//p[@title='Forms']");
	private By fieldInterviewClick = By.xpath("//a[@href='/form/field-interview']");

	private By AddFieldInterview = By
			.xpath("//button[@type='button' and normalize-space()='Add New Field Interview']");
	private By SiteDropdown = By
			.xpath("//input[@id='site_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CallDropdown = By
			.xpath("//input[@id='call_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By incidentReport = By
			.xpath("//input[@id='incident_report']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By DatePickerFieldInterview = By
			.xpath("//input[@id='interview_datetime']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By LastNameFieldInterview = By.xpath("//input[@id='person_last_name']");
	private By MiddleNameInterview = By.xpath("//input[@id='person_middle_initial']");
	private By FirstNameFieldInterview = By.xpath("//input[@id='person_first_name']");
	private By NickNameFieldInterview = By.xpath("//input[@id='person_nickname']");
	private By PhoneNumberFieldInterview = By.xpath("(//input[@type='tel' and @value='+1'])[1]");
	private By DLIDNumber = By.xpath("//input[@id='person_license_ID']");
	private By DLState = By
			.xpath("//input[@id='person_license_state']/ancestor::div[contains(@class,'ant-select-selector')]");

	// Interview Address
	private By StreetNumAddress = By.xpath("//input[@id='street']");
	private By StreetNameAddress = By.xpath("//input[@id='street_name']");
	private By UnitNumberAddress = By.xpath("//input[@id='apartment']");
	private By CityAddress = By.xpath("//input[@id='city']");
	private By StateDropdownAddress = By
			.xpath("//input[@id='state']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By ZipcodeAddress = By.xpath("//input[@id='zipcode']");

	// Residence Address
	private By ResStreetNumAddress = By.xpath("//input[@id='person_address_street_num']");
	private By ResStreetNameAddress = By.xpath("//input[@id='person_address_street']");
	private By ResUnitNumberAddress = By.xpath("//input[@id='person_address_unit_number']");
	private By ResCityAddress = By.xpath("//input[@id='person_address_city']");
	private By ResStateDropdownAddress = By
			.xpath("//input[@id='person_address_state']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By ResZipcodeAddress = By.xpath("//input[@id='person_address_zip']");

	// Person Description
	private By PersonRaceDropdown = By
			.xpath("//input[@id='person_race']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By persongenderDropdown = By
			.xpath("//input[@id='person_gender']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By personHairTypeDropdown = By
			.xpath("//input[@id='hair_type']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By personHairColorDropdown = By
			.xpath("//input[@id='person_hair']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By personEyesDropdown = By
			.xpath("//input[@id='person_eyes']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By personHeightFeetDropdown = By
			.xpath("//input[@id='person_height']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By personBuildDropdown = By
			.xpath("//input[@id='build_type']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By WeightLBS = By.xpath("//input[@id='person_weight']");
	private By personDOB = By.xpath("//input[@id='person_dob']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By physicalDescription = By.xpath("//input[@id='person_oddities_scars']");
	private By ClothingWorn = By.xpath("//input[@id='person_clothing_worn']");

	// Vehicle Details
	private By VehicleLicensePlate = By.xpath("//input[@id='vehicle_license_number']");
	private By VehicleStateDropdown = By
			.xpath("//input[@id='vehicle_license_state']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleYearDropdown = By
			.xpath("//input[@id='vehicle_year']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleMakeDropdown = By
			.xpath("//input[@id='vehicle_make']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleModelDropdown = By
			.xpath("//input[@id='vehicle_model']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleColor1 = By.xpath("//input[@id='vehicle_color_primary']");
	private By VehicleColor2 = By.xpath("//input[@id='vehicle_color_secondary']");
	private By VehicleTypeDropdown = By
			.xpath("//input[@id='vehicle_type']/ancestor::div[contains(@class,'ant-select-selector')]");

	// Companion details
	private By CompanionName = By.xpath("//input[@id='companion_0_companion_name']");
	private By CompanionAddress = By.xpath("//input[@id='companion_0_companion_address']");
	private By CompanionPhone = By.xpath("(//input[@type='tel' and @value='+1'])[2]");
	private By CompanionWorkphone = By.xpath("(//input[@type='tel' and @value='+1'])[3]");
	private By CompanionGender = By
			.xpath("//input[@id='companion_0_companion_gender']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionRace = By
			.xpath("//input[@id='companion_0_companion_race']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionHairType = By.xpath(
			"//input[@id='companion_0_companion_hair_type']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionHairColor = By
			.xpath("//input[@id='companion_0_companion_hair']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionEyes = By
			.xpath("//input[@id='companion_0_companion_eyes']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionHeight = By
			.xpath("//input[@id='companion_0_companion_height']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionBuild = By.xpath(
			"//input[@id='companion_0_companion_build_type']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CompanionWeight = By.xpath("//input[@id='companion_0_companion_weight']");

	// Report Description
	private By ReportNotes = By.xpath("//textarea[@id='report_desc']");

	// Crime Potentials
	private By SelectCrimePotential1 = By
			.xpath("//input[@id='crime_potential_1']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectCrimePotential2 = By
			.xpath("//input[@id='crime_potential_2']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By UploadImageFieldInterview = By
			.xpath("//div[contains(@class,'ant-upload-list-picture-card')]//input[@type='file']");
	private By SaveButtonFieldInterview = By
			.xpath("//button[@type='submit' and normalize-space()='Save Field Interview']");

	// Success message locator
	private By successMessage = By.xpath(
			"//div[contains(@class,'ant-message-success') or contains(@class,'ant-notification-notice-success')]");

	// ==================== NAVIGATION METHODS ====================

	/**
	 * Navigate to Field Interview form from main menu
	 */
	public void navigateToFieldInterview() {
		try {
			// Click Forms menu
			elementUtils.waitForElementToBeClickable(formsclick, 10);
			elementUtils.safeClick(formsclick);
			System.out.println("✅ Clicked Forms menu");

			// Click Field Interview link
			elementUtils.waitForElementToBeClickable(fieldInterviewClick, 10);
			elementUtils.safeClick(fieldInterviewClick);
			System.out.println("✅ Navigated to Field Interview page");

			// Wait for page to load
			waitForFieldInterviewPageLoad();
		} catch (Exception e) {
			System.err.println("❌ Failed to navigate to Field Interview: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Wait for Field Interview page to load
	 */
	private void waitForFieldInterviewPageLoad() {
		try {
			wait.until(ExpectedConditions.or(
					ExpectedConditions.visibilityOfElementLocated(AddFieldInterview),
					ExpectedConditions.urlContains("/field-interview")));
			System.out.println("✅ Field Interview page loaded");
		} catch (Exception e) {
			System.err.println("⚠️ Field Interview page may not have loaded completely");
		}
	}

	// ==================== ADD FIELD INTERVIEW METHODS ====================

	/**
	 * Click Add New Field Interview button
	 */
	public void clickAddNewFieldInterview() {
		elementUtils.waitForElementToBeClickable(AddFieldInterview, 10);
		elementUtils.safeClick(AddFieldInterview);
		System.out.println("✅ Clicked Add New Field Interview button");
		waitForFieldInterviewFormLoad();
	}

	/**
	 * Wait for field interview form to load
	 */
	private void waitForFieldInterviewFormLoad() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(SiteDropdown));
			System.out.println("✅ Field Interview form loaded");
		} catch (Exception e) {
			System.err.println("⚠️ Field Interview form may not have loaded completely");
		}
	}

	/**
	 * Fill incident details section
	 */
	public void fillIncidentDetails(String site, String call, String incidentReport, String interviewDateTime) {
		try {
			// Site dropdown
			if (site != null && !site.isEmpty()) {
				selectFromReactDropdown(SiteDropdown, site);
				System.out.println("✅ Selected Site: " + site);
			}

			// Call dropdown
			if (call != null && !call.isEmpty()) {
				selectFromReactDropdown(CallDropdown, call);
				System.out.println("✅ Selected Call: " + call);
			}

			// Incident Report dropdown
			if (incidentReport != null && !incidentReport.isEmpty()) {
				selectFromReactDropdown(this.incidentReport, incidentReport);
				System.out.println("✅ Selected Incident Report: " + incidentReport);
			}

			// Interview Date with Time
			if (interviewDateTime != null && !interviewDateTime.isEmpty()) {
				try {
					By dateInput = By.xpath("//input[@id='interview_datetime']");
					WebElement inputField = elementUtils.getElement(dateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(interviewDateTime);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("✅ Selected Interview Date: " + interviewDateTime);
					}
				} catch (Exception e) {
					System.err.println("⚠️ Could not set date-time: " + e.getMessage());
				}
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill incident details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill person information section
	 */
	public void fillPersonInfo(String lastName, String middleName, String firstName,
			String nickname, String phone, String dlNumber, String dlState) {
		try {
			if (lastName != null && !lastName.isEmpty()) {
				elementUtils.doSendKeysWithClear(LastNameFieldInterview, lastName);
				System.out.println(" Entered Last Name: " + lastName);
			}

			if (middleName != null && !middleName.isEmpty()) {
				elementUtils.doSendKeysWithClear(MiddleNameInterview, middleName);
				System.out.println(" Entered Middle Name: " + middleName);
			}

			if (firstName != null && !firstName.isEmpty()) {
				elementUtils.doSendKeysWithClear(FirstNameFieldInterview, firstName);
				System.out.println(" Entered First Name: " + firstName);
			}

			if (nickname != null && !nickname.isEmpty()) {
				elementUtils.doSendKeysWithClear(NickNameFieldInterview, nickname);
				System.out.println("✅ Entered Nickname: " + nickname);
			}

			if (phone != null && !phone.isEmpty()) {
				elementUtils.doSendKeysWithClear(PhoneNumberFieldInterview, phone);
				System.out.println("✅ Entered Phone: " + phone);
			}

			if (dlNumber != null && !dlNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(DLIDNumber, dlNumber);
				System.out.println("✅ Entered DL Number: " + dlNumber);
			}

			if (dlState != null && !dlState.isEmpty()) {
				selectFromReactDropdown(DLState, dlState);
				System.out.println("✅ Selected DL State: " + dlState);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill person info: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill interview location address
	 */
	public void fillInterviewAddress(String streetNum, String streetName, String unitNumber,
			String city, String state, String zipcode) {
		try {
			if (streetNum != null && !streetNum.isEmpty()) {
				elementUtils.doSendKeysWithClear(StreetNumAddress, streetNum);
				System.out.println("✅ Entered Street Number: " + streetNum);
			}

			if (streetName != null && !streetName.isEmpty()) {
				elementUtils.doSendKeysWithClear(StreetNameAddress, streetName);
				System.out.println("✅ Entered Street Name: " + streetName);
			}

			if (unitNumber != null && !unitNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(UnitNumberAddress, unitNumber);
				System.out.println("✅ Entered Unit Number: " + unitNumber);
			}

			if (city != null && !city.isEmpty()) {
				elementUtils.doSendKeysWithClear(CityAddress, city);
				System.out.println("✅ Entered City: " + city);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(StateDropdownAddress, state);
				System.out.println("✅ Selected State: " + state);
			}

			if (zipcode != null && !zipcode.isEmpty()) {
				elementUtils.doSendKeysWithClear(ZipcodeAddress, zipcode);
				System.out.println("✅ Entered Zipcode: " + zipcode);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill interview address: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill person residence address
	 */
	public void fillResidenceAddress(String streetNum, String streetName, String unitNumber,
			String city, String state, String zipcode) {
		try {
			if (streetNum != null && !streetNum.isEmpty()) {
				elementUtils.doSendKeysWithClear(ResStreetNumAddress, streetNum);
				System.out.println("✅ Entered Residence Street Number: " + streetNum);
			}

			if (streetName != null && !streetName.isEmpty()) {
				elementUtils.doSendKeysWithClear(ResStreetNameAddress, streetName);
				System.out.println("✅ Entered Residence Street Name: " + streetName);
			}

			if (unitNumber != null && !unitNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(ResUnitNumberAddress, unitNumber);
				System.out.println("✅ Entered Residence Unit Number: " + unitNumber);
			}

			if (city != null && !city.isEmpty()) {
				elementUtils.doSendKeysWithClear(ResCityAddress, city);
				System.out.println("✅ Entered Residence City: " + city);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(ResStateDropdownAddress, state);
				System.out.println("✅ Selected Residence State: " + state);
			}

			if (zipcode != null && !zipcode.isEmpty()) {
				elementUtils.doSendKeysWithClear(ResZipcodeAddress, zipcode);
				System.out.println("✅ Entered Residence Zipcode: " + zipcode);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill residence address: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill person description section
	 */
	public void fillPersonDescription(String race, String gender, String hairType, String hairColor,
			String eyes, String height, String build, String weight, String dob,
			String physicalDesc, String clothing) {
		try {
			if (race != null && !race.isEmpty()) {
				selectFromReactDropdown(PersonRaceDropdown, race);
				System.out.println("✅ Selected Race: " + race);
			}

			if (gender != null && !gender.isEmpty()) {
				selectFromReactDropdown(persongenderDropdown, gender);
				System.out.println("✅ Selected Gender: " + gender);
			}

			if (hairType != null && !hairType.isEmpty()) {
				selectFromReactDropdown(personHairTypeDropdown, hairType);
				System.out.println("✅ Selected Hair Type: " + hairType);
			}

			if (hairColor != null && !hairColor.isEmpty()) {
				selectFromReactDropdown(personHairColorDropdown, hairColor);
				System.out.println("✅ Selected Hair Color: " + hairColor);
			}

			if (eyes != null && !eyes.isEmpty()) {
				selectFromReactDropdown(personEyesDropdown, eyes);
				System.out.println("✅ Selected Eyes: " + eyes);
			}

			if (height != null && !height.isEmpty()) {
				selectFromReactDropdown(personHeightFeetDropdown, height);
				System.out.println("✅ Selected Height: " + height);
			}

			if (build != null && !build.isEmpty()) {
				selectFromReactDropdown(personBuildDropdown, build);
				System.out.println("✅ Selected Build: " + build);
			}

			if (weight != null && !weight.isEmpty()) {
				elementUtils.doSendKeysWithClear(WeightLBS, weight);
				System.out.println("✅ Entered Weight: " + weight);
			}

			if (dob != null && !dob.isEmpty()) {
				try {
					By dobInput = By.xpath("//input[@id='person_dob']");
					WebElement inputField = elementUtils.getElement(dobInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(dob);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("✅ Selected DOB: " + dob);
					}
				} catch (Exception e) {
					System.err.println("⚠️ Could not set DOB: " + e.getMessage());
				}
			}

			if (physicalDesc != null && !physicalDesc.isEmpty()) {
				elementUtils.doSendKeysWithClear(physicalDescription, physicalDesc);
				System.out.println("✅ Entered Physical Description: " + physicalDesc);
			}

			if (clothing != null && !clothing.isEmpty()) {
				elementUtils.doSendKeysWithClear(ClothingWorn, clothing);
				System.out.println("✅ Entered Clothing Worn: " + clothing);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill person description: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill vehicle details section
	 */
	public void fillVehicleDetails(String licensePlate, String state, String year, String make,
			String model, String color1, String color2, String type) {
		try {
			if (licensePlate != null && !licensePlate.isEmpty()) {
				elementUtils.doSendKeysWithClear(VehicleLicensePlate, licensePlate);
				System.out.println("✅ Entered License Plate: " + licensePlate);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(VehicleStateDropdown, state);
				System.out.println("✅ Selected Vehicle State: " + state);
			}

			if (year != null && !year.isEmpty()) {
				selectFromReactDropdown(VehicleYearDropdown, year);
				System.out.println("✅ Selected Vehicle Year: " + year);
			}

			if (make != null && !make.isEmpty()) {
				selectFromReactDropdown(VehicleMakeDropdown, make);
				System.out.println("✅ Selected Vehicle Make: " + make);
			}

			if (model != null && !model.isEmpty()) {
				selectFromReactDropdown(VehicleModelDropdown, model);
				System.out.println("✅ Selected Vehicle Model: " + model);
			}

			if (color1 != null && !color1.isEmpty()) {
				elementUtils.doSendKeysWithClear(VehicleColor1, color1);
				System.out.println("✅ Entered Vehicle Color 1: " + color1);
			}

			if (color2 != null && !color2.isEmpty()) {
				elementUtils.doSendKeysWithClear(VehicleColor2, color2);
				System.out.println("✅ Entered Vehicle Color 2: " + color2);
			}

			if (type != null && !type.isEmpty()) {
				selectFromReactDropdown(VehicleTypeDropdown, type);
				System.out.println("✅ Selected Vehicle Type: " + type);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill vehicle details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill companion details section
	 */
	public void fillCompanionDetails(String name, String address, String phone, String workPhone,
			String gender, String race, String hairType, String hairColor, String eyes,
			String height, String build, String weight) {
		try {
			if (name != null && !name.isEmpty()) {
				elementUtils.doSendKeysWithClear(CompanionName, name);
				System.out.println("✅ Entered Companion Name: " + name);
			}

			if (address != null && !address.isEmpty()) {
				elementUtils.doSendKeysWithClear(CompanionAddress, address);
				System.out.println("✅ Entered Companion Address: " + address);
			}

			if (phone != null && !phone.isEmpty()) {
				elementUtils.doSendKeysWithClear(CompanionPhone, phone);
				System.out.println("✅ Entered Companion Phone: " + phone);
			}

			if (workPhone != null && !workPhone.isEmpty()) {
				elementUtils.doSendKeysWithClear(CompanionWorkphone, workPhone);
				System.out.println("✅ Entered Companion Work Phone: " + workPhone);
			}

			if (gender != null && !gender.isEmpty()) {
				selectFromReactDropdown(CompanionGender, gender);
				System.out.println("✅ Selected Companion Gender: " + gender);
			}

			if (race != null && !race.isEmpty()) {
				selectFromReactDropdown(CompanionRace, race);
				System.out.println("✅ Selected Companion Race: " + race);
			}

			if (hairType != null && !hairType.isEmpty()) {
				selectFromReactDropdown(CompanionHairType, hairType);
				System.out.println("✅ Selected Companion Hair Type: " + hairType);
			}

			if (hairColor != null && !hairColor.isEmpty()) {
				selectFromReactDropdown(CompanionHairColor, hairColor);
				System.out.println("✅ Selected Companion Hair Color: " + hairColor);
			}

			if (eyes != null && !eyes.isEmpty()) {
				selectFromReactDropdown(CompanionEyes, eyes);
				System.out.println("✅ Selected Companion Eyes: " + eyes);
			}

			if (height != null && !height.isEmpty()) {
				selectFromReactDropdown(CompanionHeight, height);
				System.out.println("✅ Selected Companion Height: " + height);
			}

			if (build != null && !build.isEmpty()) {
				selectFromReactDropdown(CompanionBuild, build);
				System.out.println("✅ Selected Companion Build: " + build);
			}

			if (weight != null && !weight.isEmpty()) {
				elementUtils.doSendKeysWithClear(CompanionWeight, weight);
				System.out.println("✅ Entered Companion Weight: " + weight);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill companion details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill report description and crime potentials
	 */
	public void fillReportAndCrimePotentials(String reportNotes, String crimePotential1, String crimePotential2) {
		try {
			if (reportNotes != null && !reportNotes.isEmpty()) {
				elementUtils.doSendKeysWithClear(ReportNotes, reportNotes);
				System.out.println("✅ Entered Report Notes: " + reportNotes);
			}

			if (crimePotential1 != null && !crimePotential1.isEmpty()) {
				selectFromReactDropdown(SelectCrimePotential1, crimePotential1);
				System.out.println("✅ Selected Crime Potential 1: " + crimePotential1);
			}

			if (crimePotential2 != null && !crimePotential2.isEmpty()) {
				selectFromReactDropdown(SelectCrimePotential2, crimePotential2);
				System.out.println("✅ Selected Crime Potential 2: " + crimePotential2);
			}

		} catch (Exception e) {
			System.err.println("❌ Failed to fill report and crime potentials: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Upload image to field interview
	 */
	public void uploadImage(String imagePath) {
		try {
			elementUtils.uploadFile(UploadImageFieldInterview, imagePath);
			System.out.println("✅ Uploaded image: " + imagePath);

			// Click OK after upload
			try {
				Thread.sleep(2000);
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 10);
				elementUtils.safeClick(okButton);
				System.out.println("✅ Clicked OK button for image upload");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("⚠️ OK button for image upload not found or not clickable: " + e.getMessage());
			}
		} catch (Exception e) {
			System.err.println("❌ Failed to upload image: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Click Save Field Interview button
	 */
	public void clickSaveFieldInterview() {
		try {
			elementUtils.waitForElementToBeClickable(SaveButtonFieldInterview, 10);
			elementUtils.safeClick(SaveButtonFieldInterview);
			System.out.println("✅ Clicked Save Field Interview button");

			// Wait for and click OK button in confirmation dialog
			try {
				Thread.sleep(2000);
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 15);
				elementUtils.safeClick(okButton);
				System.out.println("✅ Clicked OK button to confirm save");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.err.println("⚠️ OK button for save confirmation not found or not clickable: " + e.getMessage());
			}

			// Wait for success message
			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println("❌ Failed to save field interview: " + e.getMessage());
			throw e;
		}
	}

	// ==================== VERIFICATION METHODS ====================

	/**
	 * Wait for success message after saving field interview
	 */
	private void waitForSuccessMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
			System.out.println("✅ Success message appeared");
		} catch (Exception e) {
			System.err.println("⚠️ Success message not detected");
		}
	}

	/**
	 * Verify if success message is displayed
	 */
	public boolean isSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(successMessage, 5);
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
			System.out.println("⌨️ Typed: " + optionText);

			// Step 7: Wait for dropdown to filter results
			Thread.sleep(2000);

			// Step 8: Press Enter to select the first matching option
			input.sendKeys(Keys.ENTER);
			System.out.println("✅ Selected by typing: " + optionText);

			// Step 9: Wait for React to update
			Thread.sleep(500);

		} catch (Exception e) {
			System.err.println("❌ Dropdown selection failed for: " + optionText);
			e.printStackTrace();
			throw new RuntimeException("Failed to select from dropdown: " + optionText, e);
		}
	}

}
