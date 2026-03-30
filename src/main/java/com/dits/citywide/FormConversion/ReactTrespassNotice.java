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

public class ReactTrespassNotice {

	private final WebDriver driver;
	private final ElementUtils elementUtils;
	private final WebDriverWait wait;

	// Constructor
	public ReactTrespassNotice(WebDriver driver, ElementUtils elementUtils) {
		this.driver = driver;
		this.elementUtils = elementUtils;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// Locators
	private By formsclick = By.xpath("//p[@title='Forms']");
	private By parkingcitationclick = By.xpath("//a[@href='/form/trespass-notice']");

	// We Will add Lisiting page locators lator although it remain same as the react
	// parking citation form

	private By AddTrespassNotice = By
			.xpath("//button[@type='button' and normalize-space()='Add New Trespass Advisal']");
	private By SiteDropdownTrespassNotice = By
			.xpath("//input[@id='site_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By CalldropdownTrespassNotice = By
			.xpath("//input[@id='call_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By incidentReport = By
			.xpath("//input[@id='incident_report']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By DatePickerTrespassNotice = By
			.xpath("//input[@id='notice_datetime']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By ActivityCodeField = By.xpath("//input[@id='activity_code']");
	// Location Address (1st occurrence)
	private By LocationStreetAddress = By.xpath("(//input[@id='street_num'])[1]");
	private By LocationStreetName = By.xpath("(//input[@id='street'])[1]");
	private By LocationUnitNumber = By.xpath("(//input[@id='unit_number'])[1]");
	private By LocationCityField = By.xpath("(//input[@id='city'])[1]");
	private By LocationStateDropdown = By
			.xpath("(//input[@id='state']/ancestor::div[contains(@class,'ant-select-selector')])[1]");
	private By LocationZipcode = By.xpath("//input[@id='zip']");

	// Trespasser details
	private By TrespassLastName = By.xpath("//input[@id='person_last_name']");
	private By TrespassMiddleName = By.xpath("//input[@id='person_middle_initial']");
	private By TrespassFirstName = By.xpath("//input[@id='person_first_name']");
	private By DLNumber = By.xpath("//input[@id='person_license_ID']");
	private By DLState = By
			.xpath("//input[@id='person_license_state']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By DLExpire = By
			.xpath("//input[@id='person_license_exp']/ancestor::div[contains(@class,'ant-picker-input')]");

	// Trespasser Address (2nd occurrence)
	private By TrespasserStreetAddress = By.xpath("//input[@id='person_address_street_num']");
	private By TrespasserStreetName = By.xpath("//input[@id='person_address_street']");
	private By TrespasserUnitNumber = By.xpath("//input[@id='person_address_unit_number']");
	private By TrespasserCityField = By.xpath("//input[@id='person_address_city']");
	private By TrespasserStateDropdown = By
			.xpath("(//input[@id='person_address_state']/ancestor::div[contains(@class,'ant-select-selector')])[1]");
	private By TrespasserZipcode = By.xpath("//input[@id='person_address_zipcode']");

	// Vehicle Number
	private By VehicleYear = By
			.xpath("//input[@id='vehicle_year']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleMake = By
			.xpath("//input[@id='vehicle_make']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleModel = By
			.xpath("//input[@id='vehicle_model']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehicleColor = By
			.xpath("//input[@id='vehicle_color']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By VehiclePlate = By.xpath("//input[@id='vehicle_plate']");
	private By VehicleStateDropdown = By
			.xpath("//input[@id='vehicle_state']/ancestor::div[contains(@class,'ant-select-selector')]");

	// Description
	private By SelectGender = By
			.xpath("//input[@id='person_gender']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By Selectrace = By
			.xpath("//input[@id='person_race']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectHairType = By
			.xpath("//input[@id='hair_type']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By Selectpersonhair = By
			.xpath("//input[@id='person_hair']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectEyes = By
			.xpath("//input[@id='person_eyes']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectPersonHeight = By
			.xpath("//input[@id='person_height']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By SelectBuildType = By
			.xpath("//input[@id='build_type']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By personWeight = By.xpath("//input[@id='person_weight']");

	// Trespass Narrative
	private By TrespassNarrative = By.xpath("//textarea[@id='notice_notes']");
	private By PDContactedYes = By.xpath("(//input[@value='Yes'])[1]");
	private By inputRespondingagency = By.xpath("//input[@id='responding_agency_name']");
	private By inputTimeofContact = By
			.xpath("//input[@id='time_of_contact']/ancestor::div[contains(@class,'ant-picker-input')]");
	private By DidTheyshow = By.xpath("(//input[@value='Yes'])[2]");
	private By pdOfficerName = By.xpath("//input[@id='responding_agency_officer_name']");
	private By OfficerBadgeNumber = By.xpath("//input[@id='responding_agency_officer_badge_num']");
	private By IncidentNumber = By.xpath("//input[@id='responding_agency_case_number']");
	private By wasArrested = By.xpath("(//input[@value='Yes'])[3]");
	private By WhatCharge = By
			.xpath("//input[@id='person_charges_id']/ancestor::div[contains(@class,'ant-select-selector')]");
	private By UploadImageTrespassNotice = By
			.xpath("//div[contains(@class,'ant-upload-list-picture-card')]//input[@type='file']");
	private By SaveButtonTrespassNotice = By
			.xpath("//button[@type='submit' and normalize-space()='Save Trespass Advisal']");
	private By Eidtbutton = By.xpath("(//td[@data-label='Actions']//a[contains(@class,'cursor-pointer')])[1]");
	private By DeleteTrespassNoticeButton = By.xpath("(//td[@data-label='Actions']//div[contains(@class,'actionicons deleteIcon')])[1]");
	private By ButtonUpdateTrespassNotice = By
			.xpath("//button[@type='submit' and normalize-space()='Update Trespass Advisal']");

	// Success message locator
	private By successMessage = By.xpath(
			"//*[contains(@class,'ant-message-success') or contains(@class,'ant-notification-notice-success') or contains(.,'successfully') or contains(.,'Successfully')]");

	// Error message locator
	private By errorMessage = By.xpath(
			"//*[contains(@class,'ant-message-error') or contains(@class,'ant-notification-notice-error') or contains(@class,'ant-form-item-explain-error')]");

	// ==================== NAVIGATION METHODS ====================

	/**
	 * Navigate to Trespass Notice form from main menu
	 */
	public void navigateToTrespassNotice() {
		try {
			// Click Forms menu
			elementUtils.waitForElementToBeClickable(formsclick, 10);
			elementUtils.safeClick(formsclick);
			System.out.println("  Clicked Forms menu");

			// Click Trespass Notice link
			elementUtils.waitForElementToBeClickable(parkingcitationclick, 10);
			elementUtils.safeClick(parkingcitationclick);
			System.out.println("  Navigated to Trespass Notice page");

			// Wait for page to load
			waitForTrespassNoticePageLoad();
		} catch (Exception e) {
			System.err.println("   Failed to navigate to Trespass Notice: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Wait for Trespass Notice page to load
	 */
	private void waitForTrespassNoticePageLoad() {
		try {
			wait.until(ExpectedConditions.or(
					ExpectedConditions.visibilityOfElementLocated(AddTrespassNotice),
					ExpectedConditions.urlContains("/trespass-notice")));
			System.out.println("  Trespass Notice page loaded");
		} catch (Exception e) {
			System.err.println("  Trespass Notice page may not have loaded completely");
		}
	}

	// ==================== ADD TRESPASS NOTICE METHODS ====================

	/**
	 * Click Add New Trespass Notice button
	 */
	public void clickAddNewTrespassNotice() {
		elementUtils.waitForElementToBeClickable(AddTrespassNotice, 10);
		elementUtils.safeClick(AddTrespassNotice);
		System.out.println("  Clicked Add New Trespass Advisal button");
		waitForTrespassNoticeFormLoad();
	}

	/**
	 * Wait for trespass notice form to load
	 */
	private void waitForTrespassNoticeFormLoad() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(SiteDropdownTrespassNotice));
			System.out.println("  Trespass Notice form loaded");
		} catch (Exception e) {
			System.err.println("  Trespass Notice form may not have loaded completely");
		}
	}

	/**
	 * Fill location details section
	 */
	public void fillLocationDetails(String site, String call, String incidentReport,
			String noticeDateTime, String activityCode, String streetNum, String streetName, String unitNumber,
			String city, String state, String zipcode) {
		try {
			// Site dropdown
			if (site != null && !site.isEmpty()) {
				selectFromReactDropdown(SiteDropdownTrespassNotice, site);
				System.out.println("  Selected Site: " + site);
			}

			// Call dropdown
			if (call != null && !call.isEmpty()) {
				selectFromReactDropdown(CalldropdownTrespassNotice, call);
				System.out.println("  Selected Call: " + call);
			}

			// Incident Report dropdown
			if (incidentReport != null && !incidentReport.isEmpty()) {
				selectFromReactDropdown(this.incidentReport, incidentReport);
				System.out.println("  Selected Incident Report: " + incidentReport);
			}

			// Notice Date with Time
			if (noticeDateTime != null && !noticeDateTime.isEmpty()) {
				try {
					By dateInput = By.xpath("//input[@id='notice_datetime']");
					WebElement inputField = elementUtils.getElement(dateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(noticeDateTime);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("  Selected Notice Date: " + noticeDateTime);
					}
				} catch (Exception e) {
					System.err.println("  Could not set date-time: " + e.getMessage());
				}
			}

			// Activity Code
			if (activityCode != null && !activityCode.isEmpty()) {
				elementUtils.doSendKeysWithClear(ActivityCodeField, activityCode);
				System.out.println("  Entered Activity Code: " + activityCode);
			}

			// Address fields
			if (streetNum != null && !streetNum.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationStreetAddress, streetNum);
				System.out.println("  Entered Street Number: " + streetNum);
			}

			if (streetName != null && !streetName.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationStreetName, streetName);
				System.out.println("  Entered Street Name: " + streetName);
			}

			if (unitNumber != null && !unitNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationUnitNumber, unitNumber);
				System.out.println("  Entered Unit Number: " + unitNumber);
			}

			if (city != null && !city.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationCityField, city);
				System.out.println("  Entered City: " + city);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(LocationStateDropdown, state);
				System.out.println("  Selected State: " + state);
			}

			if (zipcode != null && !zipcode.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationZipcode, zipcode);
				System.out.println("  Entered Zipcode: " + zipcode);
			}

		} catch (Exception e) {
			System.err.println("   Failed to fill location details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill trespasser details section
	 */
	public void fillTrespasserDetails(String lastName, String middleName, String firstName,
			String dlNumber, String dlState, String dlExpire) {
		try {
			if (lastName != null && !lastName.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespassLastName, lastName);
				System.out.println("  Entered Last Name: " + lastName);
			}

			if (middleName != null && !middleName.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespassMiddleName, middleName);
				System.out.println("  Entered Middle Name: " + middleName);
			}

			if (firstName != null && !firstName.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespassFirstName, firstName);
				System.out.println("  Entered First Name: " + firstName);
			}

			if (dlNumber != null && !dlNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(DLNumber, dlNumber);
				System.out.println("  Entered DL Number: " + dlNumber);
			}

			if (dlState != null && !dlState.isEmpty()) {
				selectFromReactDropdown(DLState, dlState);
				System.out.println("  Selected DL State: " + dlState);
			}

			if (dlExpire != null && !dlExpire.isEmpty()) {
				try {
					By expDateInput = By.xpath("//input[@id='person_license_exp']");
					WebElement inputField = elementUtils.getElement(expDateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(dlExpire);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("  Selected DL Expire Date: " + dlExpire);
					}
				} catch (Exception e) {
					System.err.println("  Could not set DL expire date: " + e.getMessage());
				}
			}

		} catch (Exception e) {
			System.err.println("   Failed to fill trespasser details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill trespasser address (reusing location address locators)
	 */
	public void fillTrespasserAddress(String streetNum, String streetName, String unitNumber,
			String city, String state, String zipcode) {
		try {
			// Try to fill trespasser address if section exists
			if (streetNum != null && !streetNum.isEmpty()) {
				try {
					elementUtils.doSendKeysWithClear(TrespasserStreetAddress, streetNum);
					System.out.println("  Entered Trespasser Street Number: " + streetNum);
				} catch (Exception e) {
					System.out.println("  Trespasser address section not available, skipping");
					return; // Exit if first field not found
				}
			}

			if (streetName != null && !streetName.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespasserStreetName, streetName);
				System.out.println("  Entered Trespasser Street Name: " + streetName);
			}

			if (unitNumber != null && !unitNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespasserUnitNumber, unitNumber);
				System.out.println("  Entered Trespasser Unit Number: " + unitNumber);
			}

			if (city != null && !city.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespasserCityField, city);
				System.out.println("  Entered Trespasser City: " + city);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(TrespasserStateDropdown, state);
				System.out.println("  Selected Trespasser State: " + state);
			}

			if (zipcode != null && !zipcode.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespasserZipcode, zipcode);
				System.out.println("  Entered Trespasser Zipcode: " + zipcode);
			}

		} catch (Exception e) {
			System.out.println("  Trespasser address section not available: " + e.getMessage());
		}
	}

	/**
	 * Fill vehicle details section
	 */
	public void fillVehicleDetails(String vehicleYear, String vehicleMake, String vehicleModel,
			String vehicleColor, String vehiclePlate, String vehicleState) {
		try {
			if (vehicleYear != null && !vehicleYear.isEmpty()) {
				selectFromReactDropdown(VehicleYear, vehicleYear);
				System.out.println(" Selected Vehicle Year: " + vehicleYear);
			}

			if (vehicleMake != null && !vehicleMake.isEmpty()) {
				selectFromReactDropdown(VehicleMake, vehicleMake);
				System.out.println(" Selected Vehicle Make: " + vehicleMake);
			}

			if (vehicleModel != null && !vehicleModel.isEmpty()) {
				selectFromReactDropdown(VehicleModel, vehicleModel);
				System.out.println(" Selected Vehicle Model: " + vehicleModel);
			}

			if (vehicleColor != null && !vehicleColor.isEmpty()) {
				selectFromReactDropdown(VehicleColor, vehicleColor);
				System.out.println(" Selected Vehicle Color: " + vehicleColor);
			}

			if (vehiclePlate != null && !vehiclePlate.isEmpty()) {
				elementUtils.doSendKeysWithClear(VehiclePlate, vehiclePlate);
				System.out.println("Entered Vehicle Plate: " + vehiclePlate);
			}

			if (vehicleState != null && !vehicleState.isEmpty()) {
				try {
					selectFromReactDropdown(VehicleStateDropdown, vehicleState);
					System.out.println("Selected Vehicle State: " + vehicleState);
				} catch (Exception e) {
					System.out.println("️ Vehicle State field not available, skipping");
				}
			}

		} catch (Exception e) {
			System.err.println("Failed to fill vehicle details: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill description section
	 */
	public void fillDescription(String gender, String race, String hairType, String hairColor,
			String eyes, String height, String buildType, String weight) {
		try {
			if (gender != null && !gender.isEmpty()) {
				selectFromReactDropdown(SelectGender, gender);
				System.out.println("Selected Gender: " + gender);
			}

			if (race != null && !race.isEmpty()) {
				selectFromReactDropdown(Selectrace, race);
				System.out.println(" Selected Race: " + race);
			}

			if (hairType != null && !hairType.isEmpty()) {
				selectFromReactDropdown(SelectHairType, hairType);
				System.out.println(" Selected Hair Type: " + hairType);
			}

			if (hairColor != null && !hairColor.isEmpty()) {
				selectFromReactDropdown(Selectpersonhair, hairColor);
				System.out.println("Selected Hair Color: " + hairColor);
			}

			if (eyes != null && !eyes.isEmpty()) {
				selectFromReactDropdown(SelectEyes, eyes);
				System.out.println("Selected Eyes: " + eyes);
			}

			if (height != null && !height.isEmpty()) {
				selectFromReactDropdown(SelectPersonHeight, height);
				System.out.println(" Selected Height: " + height);
			}

			if (buildType != null && !buildType.isEmpty()) {
				selectFromReactDropdown(SelectBuildType, buildType);
				System.out.println(" Selected Build Type: " + buildType);
			}

			if (weight != null && !weight.isEmpty()) {
				elementUtils.doSendKeysWithClear(personWeight, weight);
				System.out.println("Entered Weight: " + weight);
			}

		} catch (Exception e) {
			System.err.println(" Failed to fill description: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Fill trespass narrative and PD contact section
	 */
	public void fillNarrativeAndPDContact(String narrative, String pdContacted,
			String respondingAgency, String timeOfContact, String didTheyShow,
			String officerName, String badgeNumber, String incidentNumber,
			String wasArrested, String charge) {
		try {
			if (narrative != null && !narrative.isEmpty()) {
				elementUtils.doSendKeysWithClear(TrespassNarrative, narrative);
				System.out.println("Entered Narrative: " + narrative);
			}

			if (pdContacted != null && pdContacted.equalsIgnoreCase("Yes")) {
				elementUtils.safeClick(PDContactedYes);
				System.out.println(" Selected PD Contacted: Yes");

				// Wait for conditional fields to appear
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Fill additional PD fields if Yes is selected
				if (respondingAgency != null && !respondingAgency.isEmpty()) {
					elementUtils.doSendKeysWithClear(inputRespondingagency, respondingAgency);
					System.out.println("  Entered Responding Agency: " + respondingAgency);
				}

				if (timeOfContact != null && !timeOfContact.isEmpty()) {
					try {
						By timeInput = By.xpath("//input[@id='time_of_contact']");
						WebElement inputField = elementUtils.getElement(timeInput);
						if (inputField != null) {
							inputField.click();
							Thread.sleep(300);
							inputField.clear();
							Thread.sleep(200);
							inputField.sendKeys(timeOfContact);
							Thread.sleep(300);
							inputField.sendKeys(Keys.ENTER);
							Thread.sleep(500);
							System.out.println("  Selected Time of Contact: " + timeOfContact);
						}
					} catch (Exception e) {
						System.err.println("  Could not set time of contact: " + e.getMessage());
					}
				}

				if (didTheyShow != null && didTheyShow.equalsIgnoreCase("Yes")) {
					elementUtils.safeClick(DidTheyshow);
					System.out.println("  Selected Did They Show: Yes");

					// Wait for officer fields to appear
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (officerName != null && !officerName.isEmpty()) {
					try {
						elementUtils.waitForElementToBeVisible(pdOfficerName, 5);
						elementUtils.doSendKeysWithClear(pdOfficerName, officerName);
						System.out.println("  Entered Officer Name: " + officerName);
					} catch (Exception e) {
						System.out.println("  Officer Name field not available");
					}
				}

				if (badgeNumber != null && !badgeNumber.isEmpty()) {
					try {
						elementUtils.doSendKeysWithClear(OfficerBadgeNumber, badgeNumber);
						System.out.println("  Entered Badge Number: " + badgeNumber);
					} catch (Exception e) {
						System.out.println("  Badge Number field not available");
					}
				}

				if (incidentNumber != null && !incidentNumber.isEmpty()) {
					try {
						elementUtils.doSendKeysWithClear(IncidentNumber, incidentNumber);
						System.out.println("  Entered Incident Number: " + incidentNumber);
					} catch (Exception e) {
						System.out.println("  Incident Number field not available");
					}
				}

				if (wasArrested != null && wasArrested.equalsIgnoreCase("Yes")) {
					elementUtils.safeClick(this.wasArrested);
					System.out.println("  Selected Was Arrested: Yes");
				}

				if (charge != null && !charge.isEmpty()) {
					try {
						selectFromReactDropdown(WhatCharge, charge);
						System.out.println("  Selected Charge: " + charge);
					} catch (Exception e) {
						System.out.println("  Charge field not available, skipping");
					}
				}
			}

		} catch (Exception e) {
			System.err.println("   Failed to fill narrative and PD contact: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Upload image to trespass notice
	 */
	public void uploadImage(String imagePath) {
		try {
			elementUtils.uploadFile(UploadImageTrespassNotice, imagePath);
			System.out.println("  Uploaded image: " + imagePath);

			// Click OK after upload
			try {
				Thread.sleep(2000);
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 10);
				elementUtils.safeClick(okButton);
				System.out.println("  Clicked OK button for image upload");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("  OK button for image upload not found or not clickable: " + e.getMessage());
			}
		} catch (Exception e) {
			System.err.println("   Failed to upload image: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Click Save Trespass Notice button
	 */
	public void clickSaveTrespassNotice() {
		try {
			elementUtils.waitForElementToBeClickable(SaveButtonTrespassNotice, 10);
			elementUtils.safeClick(SaveButtonTrespassNotice);
			System.out.println("  Clicked Save Trespass Advisal button");

			// Wait for and click OK button in confirmation dialog
			try {
				Thread.sleep(2000);
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 15);
				elementUtils.safeClick(okButton);
				System.out.println("  Clicked OK button to confirm save");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.err.println("  OK button for save confirmation not found or not clickable: " + e.getMessage());
			}

			// Wait for success message
			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println("   Failed to save trespass notice: " + e.getMessage());
			throw e;
		}
	}

	// ==================== DELETE TRESPASS NOTICE METHOD ====================

	/**
	 * Click Delete button on first trespass notice from listing page and confirm deletion
	 */
	public void deleteTrespassNotice() {
		try {
			elementUtils.waitForElementToBeClickable(DeleteTrespassNoticeButton, 10);
			elementUtils.safeClick(DeleteTrespassNoticeButton);
			System.out.println("  Clicked Delete button for first trespass notice");

			try {
				Thread.sleep(1000); 
				By confirmButton = By.xpath("//button[@type='button' and contains(text(),'Delete')]");
				elementUtils.waitForElementToBeClickable(confirmButton, 10);
				elementUtils.safeClick(confirmButton);
				System.out.println("  Confirmed deletion");
				Thread.sleep(2000); // Wait for deletion to complete
			} catch (Exception e) {
				System.err.println("  Confirmation button not found or not clickable: " + e.getMessage());
			}
			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println("Failed to delete trespass notice: " + e.getMessage());
			throw e;
		}	
		try {
			Thread.sleep(2000);
			By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
			elementUtils.waitForElementToBeClickable(okButton, 10);
			elementUtils.safeClick(okButton);
			System.out.println("Confirm OK button after deletion");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.err.println("  OK button clicked " + e.getMessage());
		}
	}

	// ==================== UPDATE TRESPASS NOTICE METHODS ====================

	/**
	 * Click Edit button on first trespass notice from listing page
	 */
	public void clickEditTrespassNotice() {
		try {
			elementUtils.waitForElementToBeClickable(Eidtbutton, 10);
			elementUtils.safeClick(Eidtbutton);
			System.out.println("  Clicked Edit button for first trespass notice");
			waitForTrespassNoticeFormLoad();
		} catch (Exception e) {
			System.err.println("   Failed to click edit trespass notice: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Update trespass notice form with new values (non-null fields only)
	 */
	public void updateTrespassNoticeForm(String site, String noticeDateTime, String activityCode,
			String streetNum, String streetName, String unitNumber, String city, String state, String zipcode) {
		try {
			System.out.println("  Updating trespass notice form...");

			if (site != null && !site.isEmpty()) {
				selectFromReactDropdown(SiteDropdownTrespassNotice, site);
				System.out.println("  Updated Site: " + site);
			}

			if (noticeDateTime != null && !noticeDateTime.isEmpty()) {
				try {
					By dateInput = By.xpath("//input[@id='notice_datetime']");
					WebElement inputField = elementUtils.getElement(dateInput);
					if (inputField != null) {
						inputField.click();
						Thread.sleep(300);
						inputField.clear();
						Thread.sleep(200);
						inputField.sendKeys(noticeDateTime);
						Thread.sleep(300);
						inputField.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						System.out.println("  Updated Notice Date: " + noticeDateTime);
					}
				} catch (Exception e) {
					System.err.println("  Could not update date-time: " + e.getMessage());
				}
			}

			if (activityCode != null && !activityCode.isEmpty()) {
				elementUtils.doSendKeysWithClear(ActivityCodeField, activityCode);
				System.out.println("  Updated Activity Code: " + activityCode);
			}

			if (streetNum != null && !streetNum.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationStreetAddress, streetNum);
				System.out.println("  Updated Street Number: " + streetNum);
			}

			if (streetName != null && !streetName.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationStreetName, streetName);
				System.out.println("  Updated Street Name: " + streetName);
			}

			if (unitNumber != null && !unitNumber.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationUnitNumber, unitNumber);
				System.out.println("  Updated Unit Number: " + unitNumber);
			}

			if (city != null && !city.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationCityField, city);
				System.out.println("  Updated City: " + city);
			}

			if (state != null && !state.isEmpty()) {
				selectFromReactDropdown(LocationStateDropdown, state);
				System.out.println("  Updated State: " + state);
			}

			if (zipcode != null && !zipcode.isEmpty()) {
				elementUtils.doSendKeysWithClear(LocationZipcode, zipcode);
				System.out.println("  Updated Zipcode: " + zipcode);
			}

			System.out.println("  Trespass notice form updated successfully");

		} catch (Exception e) {
			System.err.println("   Failed to update trespass notice form: " + e.getMessage());
		}
	}

	/**
	 * Click Update Trespass Notice button
	 */
	public void clickUpdateTrespassNotice() {
		try {
			elementUtils.waitForElementToBeClickable(ButtonUpdateTrespassNotice, 10);
			elementUtils.safeClick(ButtonUpdateTrespassNotice);
			System.out.println("  Clicked Update Trespass Advisal button");

			try {
				Thread.sleep(2000);
				By okButton = By.xpath("//button[@type='button' and normalize-space()='OK']");
				elementUtils.waitForElementToBeClickable(okButton, 15);
				elementUtils.safeClick(okButton);
				System.out.println("  Clicked OK button to confirm update");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.err.println("  OK button for update confirmation not found or not clickable: " + e.getMessage());
			}

			waitForSuccessMessage();
		} catch (Exception e) {
			System.err.println("   Failed to update trespass notice: " + e.getMessage());
			throw e;
		}
	}

	// ==================== VERIFICATION METHODS ====================


	/**
	 * Wait for success message after saving trespass notice
	 */
	private void waitForSuccessMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
			System.out.println("  Success message appeared");
		} catch (Exception e) {
			System.err.println("  Success message not detected");
		}
	}

	/**
	 * Verify if success message is displayed
	 */
	public boolean isSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(successMessage, 10);
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

			// Step 7: Wait for dropdown to filter results
			Thread.sleep(2000);

			// Step 8: Press Enter to select the first matching option
			input.sendKeys(Keys.ENTER);
			System.out.println("  Selected by typing: " + optionText);

			// Step 9: Wait for React to update
			Thread.sleep(500);

		} catch (Exception e) {
			System.err.println("  Dropdown selection failed for: " + optionText);
			e.printStackTrace();
			throw new RuntimeException("Failed to select from dropdown: " + optionText, e);
		}
	}

}
