package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.utilities.ElementUtils;

/**
 * React version of Add New Site page object.
 * NOTE: Locators are placeholders and must be updated to match the React DOM.
 */
public class ReactAdminAddNewSitePage {
    private final WebDriver driver;
    private final ElementUtils elementUtils;
    private final WebDriverWait wait;

    public ReactAdminAddNewSitePage(WebDriver driver, ElementUtils elementUtils) {
        this.driver = driver;
        this.elementUtils = elementUtils;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // genral details locators
    private By addNewSiteButton = By.xpath("//button[normalize-space()='Add New Site']");
    private By BranchSelectDropdown = By.xpath("");
    private By SiteNameInputField = By
            .xpath("//input[@id='site_name'] | //label[contains(.,'Site Name')]/following::input[1]");
    private By AgencybeatMultiSelect = By
            .xpath("//input[@id='agency_beat']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By AssignofficerDropdown = By
            .xpath("//input[@id='assign_officers']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By Callresponsedropdown = By
            .xpath("//input[@id='call_response_only']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By ServicestarttimeInputField = By.xpath("//input[@id='service_starting_time']");
    private By ServiceendtimeInputField = By.xpath("//input[@id='service_end_time']");
    private By SitetypeStationaryCheckbox = By.xpath("//input[@value='stationary']");
    private By SitetypeMobileCheckbox = By.xpath("//input[@value='mobile']");
    private By AdminDispatchSites = By.xpath("//input[@value='admin_dispatch']");
    private By PaypostrateCheckbox = By.xpath("//input[@value='Pay Post Rate']");
    private By reportApprovalneeded = By.xpath("//input[@value='Report Approval Needed']");
    private By pdfreportneededyes = By.xpath("//input[@value='1']");
    private By pdfreportneededno = By.xpath("//input[@value='0']");
    private By ReporttimeInputField = By.xpath(
            "//label[@title='Report Time (HH:mm)']/ancestor::div[contains(@class,'ant-form-item')]//input | //input[@id='report_time']");
    private By ClientemailInputField = By.xpath("//input[@id='client_email']");
    private By PolicesAgencies = By
            .xpath("//input[@id='police_agencies']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By FireDepartments = By
            .xpath("//input[@id='fire_agencies']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By MedicalServices = By
            .xpath("//input[@id='medic_agencies']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By StreetnumberInputField = By
            .xpath("//input[@id='other_agencies']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By accountmanagerInputField = By
            .xpath("//input[@id='site_account_manager']/ancestor::div[contains(@class,'ant-select-selector')]");

    // Site Address
    private By SitestreetnumberInputField = By.xpath("//input[@id='site_address_street_num']");
    private By SitestreetnameInputField = By.xpath("//input[@id='site_address_street']");
    private By SitecityInputField = By.xpath("//input[@id='site_address_city']");
    private By SitestateInputField = By
            .xpath("//input[@id='site_address_state']");
    private By SitezipInputField = By.xpath("//input[@id='site_address_zip']");

    // Site Geofencing
    private By GeofencenRAdiustypedropdown = By
            .xpath("//input[@id='radius_type']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By GeofenceaddressInputField = By.xpath("//input[@id='radius_value']");

    // Main Contact
    private By ContactfirstnameInputField = By.xpath("//input[@id='contact_name_first']");
    private By ContactlastnameInputField = By.xpath("//input[@id='contact_name_last']");
    private By ContactphonemainInputField = By.xpath(
            "//label[normalize-space()='Main Phone']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By ContactmobileInputField = By.xpath(
            "//label[normalize-space()='Mobile']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By ContactfaxInputField = By.xpath(
            "//label[normalize-space()='Fax (Office)']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By ContactemailInputField = By.id("contact_email");

    // Site Contacts
    private By AddsitecontactButton = By.xpath("//button[.//span[@aria-label='plus']]");
    private By SitecontantOrderNumber = By.xpath("//input[@id='site_contacts_0_job_title']");
    private By SitecontactNameInputField = By.xpath("//input[@id='site_contacts_0_contact_name']");
    private By SitecontactPhoneInputField = By.xpath(
            "//label[normalize-space()='New Contact Phone']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By DeleteIconButton = By.xpath("//button[.//span[@aria-label='delete']]");
    private By SaveandnextButton = By.xpath("//button[normalize-space()='Save & Next']");

    // Add alternative form-ready markers
    private By AddNewSiteFormHeading = By.xpath(
            "//h1[contains(.,'Add New Site')] | //h2[contains(.,'Add New Site')] | //div[contains(@class,'page-title')][contains(.,'Add New Site')]");

    // Ant Select helpers - using patterns from other working pages
    private By AntSelectDropdownPanel = By.cssSelector(".ant-select-dropdown");
    private By AntSelectOptions = By.xpath("//div[contains(@class,'ant-select-item-option')]");
    private By AntSelectActiveOption = By.cssSelector(".ant-select-dropdown .ant-select-item-option-active");

    // ===== TAB NAVIGATION LOCATORS =====
    private By TabSiteDetails = By.xpath("//div[@role='tab'][contains(.,'Site Details') or contains(.,'1')]");
    private By TabPropertyAccess = By.xpath("//div[@role='tab'][contains(.,'Property Access') or contains(.,'2')]");
    private By TabParkingEnforcement = By
            .xpath("//div[@role='tab'][contains(.,'Parking Enforcement') or contains(.,'3')]");
    private By TabSecurityReport = By.xpath("//div[@role='tab'][contains(.,'Security Report') or contains(.,'4')]");
    private By TabOverallSiteCoverage = By
            .xpath("//div[@role='tab'][contains(.,'Overall Site Coverage') or contains(.,'5')]");
    private By TabStationaryCoverage = By
            .xpath("//div[@role='tab'][contains(.,'Stationary Coverage') or contains(.,'6')]");
    private By TabMobilePatrolCoverage = By.xpath("//div[@role='tab'][contains(.,'Mobile Patrol') or contains(.,'7')]");
    private By TabAdminCoverage = By.xpath("//div[@role='tab'][contains(.,'Admin Coverage') or contains(.,'8')]");
    private By TabTemporaryPostOrder = By
            .xpath("//div[@role='tab'][contains(.,'Temporary Post Order') or contains(.,'9')]");
    private By TabSiteArea = By.xpath("//div[@role='tab'][contains(.,'Site Area') or contains(.,'10')]");
    private By TabPostOrders = By.xpath("//div[@role='tab'][contains(.,'Post Orders') or contains(.,'11')]");
    private By TabSitePhotos = By.xpath("//div[@role='tab'][contains(.,'Site Photos') or contains(.,'12')]");
    private By TabSiteMap = By.xpath("//div[@role='tab'][contains(.,'Site Map') or contains(.,'13')]");
    private By TabSiteDoc = By
            .xpath("//div[@role='tab'][contains(.,'Site Doc') or contains(.,'Payment') or contains(.,'14')]");
    private By TabFeedback = By
            .xpath("//div[@role='tab'][contains(.,'Feedback') or contains(.,'Comment') or contains(.,'15')]");

    // 2nd Page locators - Property Access
    private By SiteGateCode = By.xpath("//input[@id='gate_codes']");
    private By SiteAlarmCode = By.xpath("//input[@id='alarm_code_arm']");
    private By SiteunArmCode = By.xpath("//input[@id='alarm_code_unarm']");
    private By AlarmNotes = By.xpath("//textarea[@id='alarm_code_notes']");
    private By SiteBoCode = By.xpath("//input[@id='lock_box_code']");
    private By LockBoxRequired = By.xpath("//label[.//span[normalize-space()='Yes']]//input[@type='radio']");
    private By LockBoxNotes = By.xpath("//textarea[@id='lock_box_notes']");
    private By ButtonUpdate = By.xpath("//button[normalize-space()='Update']");

    // 3rd Page locators - Parking Enforcement
    private By TowCompanyNAme = By.xpath("//input[@id='towing_company_name']");
    private By TowCompanyPhone = By.xpath(
            "//label[normalize-space()='Tow Phone']/ancestor::div[contains(@class,'ant-form-item-row')]//input[@type='tel']");
    private By TowRequirementYes = By.xpath("(//label[.//span[normalize-space()='Yes']]//input[@type='radio'])[1]");
    private By TowingNotes = By.xpath("//textarea[@id='parking_enforcement_notes']");
    private By ParkingEnforcementRequired = By
            .xpath("(//label[.//span[normalize-space()='Yes']]//input[@type='radio'])[2]");
    private By ParkingEnforcementNotes = By.xpath("//textarea[@id='tow_company_notes']");
    // use update Button

    // 4th Page - Security Report
    private By ReportInstructions = By.xpath("//textarea[@id='report_notes']");
    // use Update Button here also

    // 5th -Page Locators - Overall Site Coverage
    private By OverallSiteCoverageNotes = By.xpath("//textarea[@id='overall_site_coverage']");
    // Use the Update Button Here also

    // 6th Page - Stationary Coverage
    private By StationaryAddCoverageButton = By.xpath("//button[normalize-space()='Add Stationary Coverage']");
    private By StationaryCoverageName = By.xpath("//input[@id='coverage_name_0_0']");
    private By StationaryServiceTypeDropdown = By
            .xpath("//input[@id='service_id_0']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By StationaryCoverageEndDate = By.xpath("//input[@id='date_0_[object Object]']");
    private By StationaryBillingTypeDropdown = By
            .xpath("//input[@id='billing_type_0']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By StationaryUSDRates = By.xpath("//input[@id='billing_rate_0']");
    private By StationaryHolidayRates = By.xpath("//input[@id='holiday_rate_0']");
    private By StationaryStartTimeFrom = By.xpath("//input[@id='mon_from_0']");
    private By StationaryEndTimeTo = By.xpath("//input[@id='mon_to_0']");
    private By StationaryCopytoAllDays = By.xpath("//span[@role='img' and @aria-label='copy']");
    private By StationaryDayTimeCoverageNotes = By.xpath("//textarea[@id='standing_coverage_notes_day']");
    private By StationarySwingTimeCoverageNotes = By.xpath("//textarea[@id='standing_coverage_notes_swing']");
    private By StationaryNightTimeCoverageNotes = By.xpath("//textarea[@id='standing_coverage_notes_night']");
    // Use Update Button here also

    // 7th Page - Mobile Patrol Coverage
    private By MobilePatrolAddCoverageButton = By.xpath("//button[normalize-space()='Add Mobile Coverage']");
    private By MobileCoverageName = By.xpath("//input[@id='coverage_name_0']");
    private By MobileServiceTypeDropdown = By
            .xpath("//input[@id='service_id_0']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By MondayBillingTypeDropdown = By
            .xpath("//input[@id='billing_type_0']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By BillingUSDRates = By.xpath("//input[@id='billing_rate_0']");
    private By HolidayBillingRates = By.xpath("//input[@id='holiday_rate_0']");
    private By CoverageEndDate = By.xpath("//input[@id='patrol_date_0']");
    private By MobileStartTimeFrom = By.xpath("//input[@id='mon_from_0']");
    private By MobileEndTimeTo = By.xpath("//input[@id='mon_to_0']");
    private By MobileDayHits = By.xpath("//input[@id='mon_day_hits_0']");
    private By MobileSwingHits = By.xpath("//input[@id='mon_swing_hits_0']");
    private By MobileNightHits = By.xpath("//input[@id='mon_night_hits_0']");
    private By MobileCopyToAllDays = By.xpath("//span[@role='img' and @aria-label='copy']");
    private By MobilePatrolCoverageNotes = By.xpath("//textarea[@id='patrol_coverage_notes_day_0']");
    private By MobilePatrolSwingCoverageNotes = By.xpath("//textarea[@id='patrol_coverage_notes_swing_1']");
    private By MobilePatrolNightCoverageNotes = By.xpath("//textarea[@id='patrol_coverage_notes_night_2']");
    // Use Update Button here also

    // 8th Page - Admin Coverage
    private By AdmninADDCoverageButton = By.xpath("//button[normalize-space()='Add Admin Coverage']");
    private By AdminCoverageName = By.xpath("//input[@id='coverage_name_0']");
    private By AdminServiceTypeDropdown = By
            .xpath("//input[@id='service_id_0']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By AdminMondayStarttimeFrom = By.xpath("//input[@id='mon_from_0']");
    private By AdminMondayEndTimeTo = By.xpath("//input[@id='mon_to_0']");
    private By AdminCopyToAllDays = By.xpath("//span[@role='img' and @aria-label='copy']");
    private By AdminDayTimeCoverageNotes = By.xpath("//textarea[@id='admin_coverage_notes_day_0']");
    private By AdminSwingTimeCoverageNotes = By.xpath("//textarea[@id='admin_coverage_notes_swing_1']");
    private By AdminNightTimeCoverageNotes = By.xpath("//textarea[@id='admin_coverage_notes_night_2']");
    // Use Update Button here also

    // 9th Page - Temporary Post Order
    private By ButtonCreateNew = By.xpath("//button[normalize-space()='Create New']");
    private By temporaryOrderExpireDate = By.xpath("//input[@id='expires_date']");
    private By temporaryExpireTime = By.xpath("//input[@id='expires_time']");
    private By temporaryOrderNotes = By.xpath("//textarea[@id='post_order_text']");
    private By buttonCreate = By.xpath("//button[normalize-space()='Create']");
    private By HistoryTab = By.xpath("//div[@role='tab' and normalize-space()='History']");
    // Use Update Button here also

    // 10th Page - Site Area
    private By SiteAreaAddNewButton = By.xpath("//button[normalize-space()='Add New Site Area']");
    private By SiteAreaNameInputField = By.xpath("//input[@name='area_name_0']");
    private By SiteDoorCountInputField = By.xpath("//input[@id='door_count_0']");
    private By SiteAreaNotes = By.xpath("//textarea[@id='area_notes_0']");

    // 11th Post Orders
    private By PostOrdertextField = By.xpath("//textarea[@id='site_notes']");
    private By ProblemAreasTextField = By.xpath("//textarea[@id='problem_areas']");
    // CheckPoint locators
    private By ButtonCheckpoint = By.xpath("//button[normalize-space()='Check Point']");
    private By ButtonAddCheckPoint = By.xpath("//button[normalize-space()='Add Checkpoint']");
    private By CheckpointName = By.xpath("//input[@id='label']");
    private By CheckpointDescription = By.xpath("//input[@id='description']");
    private By CheckpointTypeDropdown = By
            .xpath("//input[@id='checkpoint_type']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By CheckpointSaveButton = By.xpath("//button[normalize-space()='Save']");
    private By tabScanRules = By.xpath("//div[normalize-space()='Scan Rules']");
    private By ButtonAddScanRule = By.xpath("//button[normalize-space()='Add Scan Rule']");
    private By ScanTime = By.xpath("//input[@id='scan_deadline_time']");
    private By SnitchTime = By.xpath("//input[@id='grace_period']");
    private By ActiveDropdown = By.xpath("//input[@id='days']/ancestor::div[contains(@class,'ant-select-selector')]");
    // ButtonAddScanRule use this loctor also
    private By TabActionRules = By.xpath("//div[normalize-space()='Action Rules']");
    private By buttonAddActionRules = By.xpath("//button[normalize-space()='Add Action Rule']");
    private By ActionPriority = By.xpath("//input[@id='priority']");
    private By DropdownInputType = By
            .xpath("//input[@id='input_type']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By ActionDirective = By.xpath("//input[@id='directive']");
    // buttonAddActionRules use this locator also
    private By TabLocationSetting = By.xpath("(//div[normalize-space()='Location settings'])[3]");
    private By AddressInputField = By.xpath("//input[@id='react-select-5-input']");
    private By RadiusInput = By.xpath("//input[@id='radius']");
    private By buttonUpdate = By.xpath("//button[normalize-space()='Update']");

    // --Assigmnet Loctors--//
    private By AssignmentNameField = By.xpath("//input[@id='assignment_task']");
    private By AssignmentTemplateDropdown = By
            .xpath("//input[@id='template_id']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By CoverageTypeDropdown = By
            .xpath("//input[@id='coverage_type']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By CoverageNameDropdown = By
            .xpath("//input[@id='coverage_name']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By DaysOFWeekDropdown = By
            .xpath("//input[@id='day_of_Week']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By AssignmentTime = By.xpath("//input[@id='assignment_time']");
    private By snitchTime = By.xpath("//input[@id='assignment_grace_time']");
    private By ButtonAddAssignment = By.xpath("//button[normalize-space()='Add Assignment']");
    // use Update Button here also

    // 12th Page - Site Photos
    private By SitePhotosUploadInput = By.xpath("//input[@type='file' and @accept='.jpg,.png']");
    // Use Update Button here also

    // 13th Page - Site map
    // Use Update Button here also

    // 14th Page - Site Doc/ payement Terms
    private By ClientFirstName = By.xpath("//input[@id='client_name_first']");
    private By ClientLastName = By.xpath("//input[@id='client_name_last']");
    private By ComapanyName = By.xpath("//input[@id='client_company_name']");
    private By ClientDisplayName = By.xpath("//input[@id='client_display_name']");
    private By ClientMainPhone = By.xpath(
            "//label[normalize-space()='Main Phone']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By ClientMobilePhone = By.xpath(
            "//label[normalize-space()='Mobile']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By ClientEmail = By.xpath("//input[@id='client_email']");
    private By FaxOffice = By.xpath(
            "//label[normalize-space()='Fax (Office)']/ancestor::div[contains(@class,'ant-form-item')]//input[@type='tel']");
    private By Clientterms = By.xpath("//input[@id='client_terms']");
    private By BillingCycleDropdown = By
            .xpath("//input[@id='client_billing_cycle']/ancestor::div[contains(@class,'ant-select-selector')]");
    private By BillingStartDate = By.xpath("//input[@id='client_billing_date']");
    private By BillingInvoiceNumber = By.xpath("//input[@id='client_billing_invoice']");
    private By ProjectedActualToggle = By.xpath("//button[@id='projected_hours']");
    // Billing Addressn locators
    private By BillingStreetNumber = By.xpath("//input[@id='client_address_street_num']");
    private By BillingStreetName = By.xpath("//input[@id='client_address_street']");
    private By BillingCity = By.xpath("//input[@id='client_address_city']");
    private By BillingState = By.xpath("//input[@id='client_address_state']");
    private By BillingZipCode = By.xpath("//input[@id='client_address_zip']");
    private By BillingCountry = By.xpath("//input[@id='client_address_country']");
    // Upload Document
    private By UploadDocumentInput = By.xpath("//div[contains(@class,'ant-upload')]//div[normalize-space()='Upload']");
    
    private By BackbuttonSites = By.xpath("//a[@href='/admin/sites' and span[normalize-space()='Back']]");
    
    
    
    // Use Update Button here also

    // 15th Page - Feedback Comments Compliments
    private By CommnetsComplimentsTextArea = By.xpath("//textarea[@id='comment']");

    public void openAddNewSiteForm() {
        // Scroll to button, try safe click, fallback to JS click
        try {
            elementUtils.scrollAndClickUsingJS(addNewSiteButton);
        } catch (Exception e) {
            try {
                elementUtils.safeClick(addNewSiteButton);
            } catch (Exception e2) {
                // Final fallback
                elementUtils.jsClickWithWait(addNewSiteButton, 10);
            }
        }

        // Wait for form to be ready
        waitForAddNewSiteFormReady();
    }

    private void waitForAddNewSiteFormReady() {
        // Heuristic: wait for any of these conditions
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(SiteNameInputField),
                    ExpectedConditions.visibilityOfElementLocated(AddNewSiteFormHeading),
                    ExpectedConditions.urlContains("/sites/add")));
        } catch (Exception ignore) {
            // As a secondary attempt, small pause and re-check
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            if (!elementUtils.doIsDisplayed(SiteNameInputField, 3)) {
                // Attempt opening again if still not visible
                elementUtils.retryClickWithJS(addNewSiteButton, 3);
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(SiteNameInputField),
                        ExpectedConditions.visibilityOfElementLocated(AddNewSiteFormHeading)));
            }
        }
    }

    // ===== Public high-level flows =====
    public void fillGeneralDetails(String siteName,
            String agencyBeatCsv,
            String assignOfficerCsv,
            String callResponse,
            String serviceStartTime,
            String serviceEndTime,
            boolean isStationary,
            boolean isMobile,
            boolean isAdminDispatch,
            boolean isPayPostRate,
            boolean isReportApprovalNeeded,
            boolean isPdfReportNeeded,
            String reportTime,
            String clientEmail,
            String policeAgenciesCsv,
            String fireAgenciesCsv,
            String medicalAgenciesCsv,
            String otherAgenciesCsv,
            String accountManager) throws InterruptedException {
        // Site name - use Actions class for reliable interaction with React fields
        WebElement siteNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SiteNameInputField));
        Thread.sleep(1000); // Wait for React to fully render

        // Use Actions class for more reliable interaction
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(siteNameField).click().perform();
        Thread.sleep(300);

        // Clear the field using keyboard
        siteNameField.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
        siteNameField.sendKeys(org.openqa.selenium.Keys.DELETE);
        Thread.sleep(300);

        // Type the site name
        actions.sendKeys(siteName).perform();
        Thread.sleep(500);

        System.out.println("✅ Site name entered: " + siteName);

        // Assign Beat via ARROWDOWN scrolling for long lists
        selectAssignBeatWithArrowScrolling(agencyBeatCsv, 200);

        // Assign officer
        multiSelectCsv(AssignofficerDropdown, assignOfficerCsv);

        // call response dropdown
        selectFromAntSelect(Callresponsedropdown, callResponse);

        // Times
        elementUtils.doSendKeysWithClear(ServicestarttimeInputField, serviceStartTime);
        elementUtils.doSendKeysWithClear(ServiceendtimeInputField, serviceEndTime);

        // Checkboxes/toggles
        setCheckbox(SitetypeStationaryCheckbox, isStationary);
        setCheckbox(SitetypeMobileCheckbox, isMobile);
        setCheckbox(AdminDispatchSites, isAdminDispatch);
        setCheckbox(PaypostrateCheckbox, isPayPostRate);
        setCheckbox(reportApprovalneeded, isReportApprovalNeeded);

        // PDF report radio
        setRadio(pdfreportneededyes, pdfreportneededno, isPdfReportNeeded);

        // Report time & Client email
        elementUtils.doSendKeysWithClear(ReporttimeInputField, reportTime);
        elementUtils.doSendKeysWithClear(ClientemailInputField, clientEmail);
        try {
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(ClientemailInputField))
                    .sendKeys(org.openqa.selenium.Keys.ENTER);
        } catch (Exception e) {
            // Fallback: send Enter to active element
            elementUtils.pressEnterKey();
        }

        // Agencies
        multiSelectCsv(PolicesAgencies, policeAgenciesCsv);
        multiSelectCsv(FireDepartments, fireAgenciesCsv);
        multiSelectCsv(MedicalServices, medicalAgenciesCsv);
        multiSelectCsv(StreetnumberInputField, otherAgenciesCsv);

        // Account Manager
        selectFromAntSelect(accountmanagerInputField, accountManager);
    }

    public void fillAddress(String streetNumber, String streetName, String city, String state, String zip) {
        elementUtils.doSendKeysWithClear(SitestreetnumberInputField, streetNumber);
        elementUtils.doSendKeysWithClear(SitestreetnameInputField, streetName);
        elementUtils.doSendKeysWithClear(SitecityInputField, city);

        // Ensure focus and visibility on State input (not a dropdown)
        try {
            elementUtils.scrollAndClickUsingJS(SitestateInputField);
        } catch (Exception e) {
            elementUtils.safeClick(SitestateInputField);
        }
        elementUtils.clearTextBoxWithActions(SitestateInputField);
        elementUtils.doSendKeysWithClear(SitestateInputField, state);

        // Optionally commit the value
        try {
            elementUtils.waitForElementToBeClickable(SitestateInputField, 5).sendKeys(org.openqa.selenium.Keys.ENTER);
        } catch (Exception ignore) {
            elementUtils.pressEnterKey();
        }

        elementUtils.doSendKeysWithClear(SitezipInputField, zip);
    }

    public void fillGeofencing(String radiusType, String radiusValue) {
        selectFromAntSelect(GeofencenRAdiustypedropdown, radiusType);
        elementUtils.doSendKeysWithClear(GeofenceaddressInputField, radiusValue);
    }

    public void fillMainContact(String firstName, String lastName, String phoneMain, String mobile, String fax,
            String email) {
        elementUtils.doSendKeysWithClear(ContactfirstnameInputField, firstName);
        elementUtils.doSendKeysWithClear(ContactlastnameInputField, lastName);
        elementUtils.doSendKeysWithClear(ContactphonemainInputField, phoneMain);
        elementUtils.doSendKeysWithClear(ContactmobileInputField, mobile);
        elementUtils.doSendKeysWithClear(ContactfaxInputField, fax);
        elementUtils.doSendKeysWithClear(ContactemailInputField, email);
    }

    public void addSiteContact(String jobTitle, String name, String phone) {
        elementUtils.safeClick(AddsitecontactButton);
        elementUtils.doSendKeysWithClear(SitecontantOrderNumber, jobTitle);
        elementUtils.doSendKeysWithClear(SitecontactNameInputField, name);
        elementUtils.doSendKeysWithClear(SitecontactPhoneInputField, phone);
    }

    public void clickSaveAndNext() throws InterruptedException {
        // Wait for form to be fully ready before saving
        Thread.sleep(3000);

        elementUtils.safeClick(SaveandnextButton);

        // Wait for and verify success toast message
        try {
            By successToast = By.xpath(
                    "//div[contains(@class,'ant-message-success') or contains(@class,'ant-notification')]//span[contains(text(),'success') or contains(text(),'saved') or contains(text(),'Site')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
            System.out.println("✅ Site details saved successfully - toast message appeared");
        } catch (Exception e) {
            System.out.println("⚠️ Success toast not detected, but continuing...");
        }
    }

    // ===== Helpers =====
    private void setCheckbox(By locator, boolean desired) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        boolean selected = el.isSelected();
        if (selected != desired)
            elementUtils.clickByLocator(locator);
    }

    private void setRadio(By yesLocator, By noLocator, boolean yes) {
        elementUtils.safeClick(yes ? yesLocator : noLocator);
    }

    private void selectFromAntSelect(By selectContainerLocator, String visibleText) {
        if (visibleText == null || visibleText.isEmpty())
            return;

        try {
            // Click to open the dropdown
            elementUtils.safeClick(selectContainerLocator);
            Thread.sleep(500);

            // Try to find and type in the search input
            WebElement searchInput = null;
            try {
                // Method 1: Find input inside the container
                WebElement container = driver.findElement(selectContainerLocator);
                searchInput = container.findElement(By.cssSelector("input.ant-select-selection-search-input"));
            } catch (Exception e1) {
                try {
                    // Method 2: Get the active element (should be the search input after clicking)
                    searchInput = driver.switchTo().activeElement();
                } catch (Exception e2) {
                    // Method 3: Find any visible search input
                    searchInput = driver.findElement(By.cssSelector(".ant-select-focused input"));
                }
            }

            // Type to filter
            if (searchInput != null) {
                try {
                    // Try to clear normally first
                    searchInput.clear();
                } catch (Exception clearEx) {
                    // If clear fails (invalid element state), try JavaScript clear
                    try {
                        ((org.openqa.selenium.JavascriptExecutor) driver)
                                .executeScript("arguments[0].value = '';", searchInput);
                    } catch (Exception jsEx) {
                        // If both fail, just continue without clearing
                        System.out.println("⚠️ Could not clear input for: " + visibleText);
                    }
                }
                searchInput.sendKeys(visibleText);
                Thread.sleep(1000); // Wait for filter results
            }

            // Try to find and click matching option using ant-select-item-option-content
            By optionLocator = By
                    .xpath("//div[contains(@class,'ant-select-item-option-content')][contains(normalize-space(),'"
                            + visibleText + "')]");
            boolean found = false;

            try {
                List<WebElement> options = driver.findElements(optionLocator);
                for (WebElement opt : options) {
                    try {
                        String text = opt.getText().trim();
                        if (text.toLowerCase().contains(visibleText.toLowerCase())) {
                            try {
                                opt.click();
                            } catch (Exception clickEx) {
                                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();",
                                        opt);
                            }
                            found = true;
                            System.out.println("✅ Selected: " + visibleText);
                            break;
                        }
                    } catch (Exception ex) {
                        // Continue to next option
                    }
                }
            } catch (Exception e) {
                // Options not found
            }

            // If clicking didn't work, try pressing Enter
            if (!found && searchInput != null) {
                try {
                    searchInput.sendKeys(org.openqa.selenium.Keys.ENTER);
                    found = true;
                    System.out.println("✅ Selected via Enter: " + visibleText);
                } catch (Exception e) {
                    System.out.println("⚠️ Enter key failed for: " + visibleText);
                }
            }

            if (!found) {
                System.out.println("⚠️ Could not select: " + visibleText);
            }

        } catch (Exception e) {
            System.out.println("⚠️ selectFromAntSelect failed for: " + visibleText + " - " + e.getMessage());
        }

        // Press escape to close any open dropdown
        elementUtils.pressEscapeKey();
    }

    private void multiSelectCsv(By selectContainerLocator, String csv) {
        if (csv == null || csv.isEmpty())
            return;
        List<String> values = Arrays.stream(csv.split(",")).map(String::trim).filter(s -> !s.isEmpty()).toList();

        for (String v : values) {
            try {
                // Click to open the dropdown
                elementUtils.safeClick(selectContainerLocator);
                Thread.sleep(500);

                // Try to find the search input
                WebElement searchInput = null;
                try {
                    WebElement container = driver.findElement(selectContainerLocator);
                    searchInput = container.findElement(By.cssSelector("input.ant-select-selection-search-input"));
                } catch (Exception e1) {
                    try {
                        searchInput = driver.switchTo().activeElement();
                    } catch (Exception e2) {
                        searchInput = driver.findElement(By.cssSelector(".ant-select-focused input"));
                    }
                }

                // Type to filter
                if (searchInput != null) {
                    searchInput.sendKeys(v);
                    Thread.sleep(1000); // Wait for filter
                }

                // Find and click matching option
                By optionLocator = By
                        .xpath("//div[contains(@class,'ant-select-item-option-content')][contains(normalize-space(),'"
                                + v + "')]");
                boolean found = false;

                try {
                    List<WebElement> options = driver.findElements(optionLocator);
                    for (WebElement opt : options) {
                        try {
                            String text = opt.getText().trim();
                            if (text.toLowerCase().contains(v.toLowerCase())) {
                                try {
                                    opt.click();
                                } catch (Exception clickEx) {
                                    ((org.openqa.selenium.JavascriptExecutor) driver)
                                            .executeScript("arguments[0].click();", opt);
                                }
                                found = true;
                                System.out.println("✅ Multi-selected: " + v);
                                break;
                            }
                        } catch (Exception ex) {
                            // Continue
                        }
                    }
                } catch (Exception e) {
                    // Options not found
                }

                // Try Enter if click didn't work
                if (!found && searchInput != null) {
                    try {
                        searchInput.sendKeys(org.openqa.selenium.Keys.ENTER);
                        found = true;
                        System.out.println("✅ Multi-selected via Enter: " + v);
                    } catch (Exception e) {
                        // Enter failed
                    }
                }

                if (!found) {
                    System.out.println("⚠️ Could not multi-select: " + v);
                }

                Thread.sleep(300); // Brief pause between selections

            } catch (Exception e) {
                System.out.println("⚠️ multiSelectCsv failed for: " + v + " - " + e.getMessage());
            }
        }
        elementUtils.pressEscapeKey();
    }

    // ===== Keyboard-based selection for long dropdowns =====
    private void selectAssignBeatWithArrowScrolling(String csv, int maxArrowScrollsPerValue) {
        if (csv == null || csv.isEmpty())
            return;
        List<String> values = Arrays.stream(csv.split(",")).map(String::trim).filter(s -> !s.isEmpty()).toList();
        for (String target : values) {
            // Open the dropdown
            elementUtils.safeClick(AgencybeatMultiSelect);

            // Wait for dropdown panel to appear
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(AntSelectDropdownPanel));
            } catch (Exception e) {
                // Dropdown may not have appeared, try clicking again
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                elementUtils.safeClick(AgencybeatMultiSelect);
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(AntSelectDropdownPanel));
                } catch (Exception e2) {
                    System.out.println("Warning: Could not open Agency Beat dropdown for: " + target);
                    continue;
                }
            }

            // Try direct click if present in viewport - with error handling
            boolean foundInView = false;
            try {
                List<WebElement> options = driver.findElements(AntSelectOptions);
                if (!options.isEmpty()) {
                    for (WebElement opt : options) {
                        try {
                            String text = opt.getText().trim();
                            if (text.equalsIgnoreCase(target)) {
                                elementUtils.doClickWeBElement(opt);
                                foundInView = true;
                                break;
                            }
                        } catch (Exception ex) {
                            // Element may be stale, continue
                        }
                    }
                }
            } catch (Exception e) {
                // Options not found with this selector, will use keyboard navigation
                System.out.println("Direct option selection failed, using keyboard navigation for: " + target);
            }
            if (foundInView)
                continue;

            // Type the search term to filter the dropdown
            try {
                WebElement searchInput = driver.findElement(By.xpath("//input[@id='agency_beat']"));
                searchInput.clear();
                searchInput.sendKeys(target);
                Thread.sleep(500); // Wait for filter

                // Try to find and click the matching option
                List<WebElement> filteredOptions = driver.findElements(AntSelectOptions);
                for (WebElement opt : filteredOptions) {
                    try {
                        String text = opt.getText().trim();
                        if (text.toLowerCase().contains(target.toLowerCase())) {
                            elementUtils.doClickWeBElement(opt);
                            foundInView = true;
                            break;
                        }
                    } catch (Exception ex) {
                        // Continue
                    }
                }
                if (foundInView)
                    continue;
            } catch (Exception e) {
                // Search input not found, use arrow navigation
            }

            // Keyboard ARROW_DOWN scrolling: move through list until match or limit
            int attempts = 0;
            while (attempts < maxArrowScrollsPerValue) {
                try {
                    // Send ARROW_DOWN to active element (ant-select input)
                    WebElement panel = driver.findElement(AntSelectDropdownPanel);
                    panel.click(); // focus
                    new org.openqa.selenium.interactions.Actions(driver)
                            .sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                            .perform();

                    // Check currently active option text
                    List<WebElement> active = driver.findElements(AntSelectActiveOption);
                    if (!active.isEmpty()) {
                        String t = active.get(0).getText().trim();
                        if (t.equalsIgnoreCase(target)) {
                            // Select it
                            new org.openqa.selenium.interactions.Actions(driver)
                                    .sendKeys(org.openqa.selenium.Keys.ENTER)
                                    .perform();
                            break;
                        }
                    }
                    attempts++;
                } catch (Exception e) {
                    attempts++;
                }
            }
        }
        elementUtils.pressEscapeKey();
    }

    // ===== PAGE 2: Property Access =====
    public void fillPropertyAccess(String gateCode, String alarmArm, String alarmUnarm, String alarmNotes,
            String lockBoxCode, boolean lockBoxRequired, String lockBoxNotes) throws InterruptedException {
        // Navigate to Property Access tab
        elementUtils.safeClick(TabPropertyAccess);
        Thread.sleep(2000);

        elementUtils.doSendKeysWithClear(SiteGateCode, gateCode);
        elementUtils.doSendKeysWithClear(SiteAlarmCode, alarmArm);
        elementUtils.doSendKeysWithClear(SiteunArmCode, alarmUnarm);
        elementUtils.doSendKeysWithClear(AlarmNotes, alarmNotes);
        elementUtils.doSendKeysWithClear(SiteBoCode, lockBoxCode);
        if (lockBoxRequired) {
            elementUtils.safeClick(LockBoxRequired);
        }
        elementUtils.doSendKeysWithClear(LockBoxNotes, lockBoxNotes);
    }

    // ===== PAGE 3: Parking Enforcement =====
    public void fillParkingEnforcement(String towCompanyName, String towPhone, boolean towRequired,
            String towingNotes, boolean parkingEnforcementRequired, String parkingNotes) throws InterruptedException {
        // Navigate to Parking Enforcement tab
        elementUtils.safeClick(TabParkingEnforcement);
        Thread.sleep(2000);

        elementUtils.doSendKeysWithClear(TowCompanyNAme, towCompanyName);
        elementUtils.doSendKeysWithClear(TowCompanyPhone, towPhone);
        if (towRequired) {
            elementUtils.safeClick(TowRequirementYes);
        }
        elementUtils.doSendKeysWithClear(TowingNotes, towingNotes);
        if (parkingEnforcementRequired) {
            elementUtils.safeClick(ParkingEnforcementRequired);
        }
        elementUtils.doSendKeysWithClear(ParkingEnforcementNotes, parkingNotes);
    }

    // ===== PAGE 4: Security Report =====
    public void fillSecurityReport(String reportInstructions) throws InterruptedException {
        // Navigate to Security Report tab
        elementUtils.safeClick(TabSecurityReport);
        Thread.sleep(2000);

        elementUtils.doSendKeysWithClear(ReportInstructions, reportInstructions);
    }

    // ===== PAGE 5: Overall Site Coverage =====
    public void fillOverallSiteCoverage(String coverageNotes) throws InterruptedException {
        // Navigate to Overall Site Coverage tab
        elementUtils.safeClick(TabOverallSiteCoverage);
        Thread.sleep(2000);

        elementUtils.doSendKeysWithClear(OverallSiteCoverageNotes, coverageNotes);
    }

    // ===== PAGE 6: Stationary Coverage =====
    public void fillStationaryCoverage(String coverageName, String serviceType, String billingType,
            String usdRate, String holidayRate, String startTime, String endTime,
            String dayNotes, String swingNotes, String nightNotes) throws InterruptedException {
        // Navigate to Stationary Coverage tab
        elementUtils.safeClick(TabStationaryCoverage);
        Thread.sleep(2000);

        elementUtils.safeClick(StationaryAddCoverageButton);
        Thread.sleep(1000);
        elementUtils.doSendKeysWithClear(StationaryCoverageName, coverageName);
        selectFromAntSelect(StationaryServiceTypeDropdown, serviceType);
        selectFromAntSelect(StationaryBillingTypeDropdown, billingType);
        elementUtils.doSendKeysWithClear(StationaryUSDRates, usdRate);
        elementUtils.doSendKeysWithClear(StationaryHolidayRates, holidayRate);
        elementUtils.doSendKeysWithClear(StationaryStartTimeFrom, startTime);
        elementUtils.doSendKeysWithClear(StationaryEndTimeTo, endTime);
        elementUtils.safeClick(StationaryCopytoAllDays);
        elementUtils.doSendKeysWithClear(StationaryDayTimeCoverageNotes, dayNotes);
        elementUtils.doSendKeysWithClear(StationarySwingTimeCoverageNotes, swingNotes);
        elementUtils.doSendKeysWithClear(StationaryNightTimeCoverageNotes, nightNotes);
    }

    // ===== PAGE 7: Mobile Patrol Coverage =====
    public void fillMobilePatrolCoverage(String coverageName, String serviceType, String billingType,
            String usdRate, String holidayRate, String startTime, String endTime,
            String dayHits, String swingHits, String nightHits,
            String dayNotes, String swingNotes, String nightNotes) throws InterruptedException {
        // Navigate to Mobile Patrol Coverage tab
        elementUtils.safeClick(TabMobilePatrolCoverage);
        Thread.sleep(2000);

        elementUtils.safeClick(MobilePatrolAddCoverageButton);
        Thread.sleep(1000);
        elementUtils.doSendKeysWithClear(MobileCoverageName, coverageName);
        selectFromAntSelect(MobileServiceTypeDropdown, serviceType);
        selectFromAntSelect(MondayBillingTypeDropdown, billingType);
        elementUtils.doSendKeysWithClear(BillingUSDRates, usdRate);
        elementUtils.doSendKeysWithClear(HolidayBillingRates, holidayRate);
        elementUtils.doSendKeysWithClear(MobileStartTimeFrom, startTime);
        elementUtils.doSendKeysWithClear(MobileEndTimeTo, endTime);
        elementUtils.doSendKeysWithClear(MobileDayHits, dayHits);
        elementUtils.doSendKeysWithClear(MobileSwingHits, swingHits);
        elementUtils.doSendKeysWithClear(MobileNightHits, nightHits);
        elementUtils.safeClick(MobileCopyToAllDays);
        elementUtils.doSendKeysWithClear(MobilePatrolCoverageNotes, dayNotes);
        elementUtils.doSendKeysWithClear(MobilePatrolSwingCoverageNotes, swingNotes);
        elementUtils.doSendKeysWithClear(MobilePatrolNightCoverageNotes, nightNotes);
    }

    // ===== PAGE 8: Admin Coverage =====
    public void fillAdminCoverage(String coverageName, String serviceType, String startTime, String endTime,
            String dayNotes, String swingNotes, String nightNotes) throws InterruptedException {
        // Navigate to Admin Coverage tab
        elementUtils.safeClick(TabAdminCoverage);
        Thread.sleep(2000);
        elementUtils.safeClick(AdmninADDCoverageButton);
        Thread.sleep(1000);
        elementUtils.doSendKeysWithClear(AdminCoverageName, coverageName);
        selectFromAntSelect(AdminServiceTypeDropdown, serviceType);
        elementUtils.doSendKeysWithClear(AdminMondayStarttimeFrom, startTime);
        elementUtils.doSendKeysWithClear(AdminMondayEndTimeTo, endTime);
        elementUtils.safeClick(AdminCopyToAllDays);
        elementUtils.doSendKeysWithClear(AdminDayTimeCoverageNotes, dayNotes);
        elementUtils.doSendKeysWithClear(AdminSwingTimeCoverageNotes, swingNotes);
        elementUtils.doSendKeysWithClear(AdminNightTimeCoverageNotes, nightNotes);
    }

    // ===== PAGE 9: Temporary Post Order =====
    public void fillTemporaryPostOrder(String orderNotes, String expireDateMmDdYyyy) throws InterruptedException {
        // Navigate to Temporary Post Order tab
        elementUtils.safeClick(TabTemporaryPostOrder);
        Thread.sleep(2000);

        // Click "Create New" button to open the form
        elementUtils.safeClick(ButtonCreateNew);
        Thread.sleep(1500);

        // Open and pick date using calendar helper
        elementUtils.selectDateInAntPicker(temporaryOrderExpireDate, expireDateMmDdYyyy);

        // Optionally set time if needed
        elementUtils.sendKeysWithEnter(temporaryExpireTime, "18:00");

        elementUtils.doSendKeysWithClear(temporaryOrderNotes, orderNotes);
        elementUtils.safeClick(buttonCreate);
    }

    // ===== PAGE 10: Site Area =====
    public void fillSiteArea(String areaName, String doorCount, String areaNotes) throws InterruptedException {
        // Navigate to Site Area tab
        elementUtils.safeClick(TabSiteArea);
        Thread.sleep(2000);

        elementUtils.safeClick(SiteAreaAddNewButton);
        Thread.sleep(1000);
        elementUtils.doSendKeysWithClear(SiteAreaNameInputField, areaName);
        elementUtils.doSendKeysWithClear(SiteDoorCountInputField, doorCount);
        elementUtils.doSendKeysWithClear(SiteAreaNotes, areaNotes);
    }

    // ===== PAGE 11: Post Orders =====
    public void fillPostOrders(String postOrderText, String problemAreas,
            String assignmentName, String assignmentTemplate, String coverageType,
            String coverageName, String daysOfWeek, String assignmentTime, String assignmentSnitchTime)
            throws InterruptedException {
        // Navigate to Post Orders tab
        // elementUtils.safeClick(TabPostOrders);
        Thread.sleep(2000);

        // Fill Post Order text fields
        elementUtils.doSendKeysWithClear(PostOrdertextField, postOrderText);
        elementUtils.doSendKeysWithClear(ProblemAreasTextField, problemAreas);

        // ===== Assignment Section =====
        elementUtils.doSendKeysWithClear(AssignmentNameField, assignmentName);

        // Assignment Template dropdown - use arrow navigation for long lists
        selectAntSelectWithArrow(AssignmentTemplateDropdown, assignmentTemplate, 30);
        Thread.sleep(500);

        // Coverage Type dropdown - use standard selection (arrow method doesn't work)
        selectFromAntSelect(CoverageTypeDropdown, coverageType);
        Thread.sleep(500);

        // Coverage Name dropdown - use standard selection (arrow method doesn't work)
        selectFromAntSelect(CoverageNameDropdown, coverageName);
        Thread.sleep(500);

        // Days of Week - handle as CSV to select each day individually
        if (daysOfWeek != null && !daysOfWeek.isEmpty()) {
            String[] days = daysOfWeek.split(",");
            for (String day : days) {
                String trimmedDay = day.trim();
                if (!trimmedDay.isEmpty()) {
                    selectFromAntSelect(DaysOFWeekDropdown, trimmedDay);
                    Thread.sleep(300);
                }
            }
        }

        elementUtils.doSendKeysWithClear(AssignmentTime, assignmentTime);
        elementUtils.doSendKeysWithClear(snitchTime, assignmentSnitchTime);
        elementUtils.safeClick(ButtonAddAssignment);
        Thread.sleep(2000);
    }

    // public void addCheckpoint(String name, String description, String type,
    // String scanTime, String snitchTime, String activeDays,
    // String actionPriority, String inputType, String actionDirective,
    // String address, String radius) throws InterruptedException {
    // // Click Checkpoint tab and add checkpoint
    // elementUtils.safeClick(ButtonCheckpoint);
    // Thread.sleep(1000);
    // elementUtils.safeClick(ButtonAddCheckPoint);
    // Thread.sleep(1000);
    //
    // // Fill checkpoint basic details
    // elementUtils.doSendKeysWithClear(CheckpointName, name);
    // elementUtils.doSendKeysWithClear(CheckpointDescription, description);
    // selectFromAntSelect(CheckpointTypeDropdown, type);
    // elementUtils.safeClick(CheckpointSaveButton);
    // Thread.sleep(1000);
    //
    // // ===== Scan Rules Tab =====
    // elementUtils.safeClick(tabScanRules);
    // Thread.sleep(1000);
    // elementUtils.safeClick(ButtonAddScanRule);
    // Thread.sleep(1000);
    // elementUtils.doSendKeysWithClear(ScanTime, scanTime);
    // elementUtils.doSendKeysWithClear(SnitchTime, snitchTime);
    // selectFromAntSelect(ActiveDropdown, activeDays);
    // elementUtils.safeClick(ButtonAddScanRule); // Click to save scan rule
    // Thread.sleep(1000);
    //
    // // ===== Action Rules Tab =====
    // elementUtils.safeClick(TabActionRules);
    // Thread.sleep(1000);
    // elementUtils.safeClick(buttonAddActionRules);
    // Thread.sleep(1000);
    // elementUtils.doSendKeysWithClear(ActionPriority, actionPriority);
    // selectFromAntSelect(DropdownInputType, inputType);
    // elementUtils.doSendKeysWithClear(ActionDirective, actionDirective);
    // elementUtils.safeClick(buttonAddActionRules); // Click to save action rule
    // Thread.sleep(1000);
    //
    // // ===== Location Settings Tab =====
    // elementUtils.safeClick(TabLocationSetting);
    // Thread.sleep(1000);
    // elementUtils.doSendKeysWithClear(AddressInputField, address);
    // elementUtils.doSendKeysWithClear(RadiusInput, radius);
    // elementUtils.safeClick(buttonUpdate); // Click to save location settings
    // Thread.sleep(1000);
    // }

    private void selectCoverageNameWithKeys(String coverageName, int i) {
        // TODO Auto-generated method stub

    }

    // ===== PAGE 14: Site Doc/Payment Terms =====
    public void fillSiteDocPayment(String firstName, String lastName, String companyName, String displayName,
            String mainPhone, String mobile, String email, String fax, String terms, String billingCycle,
            String invoiceNumber, String streetNum, String streetName, String city, String state,
            String zip, String country) throws InterruptedException {
        // Navigate to Site Doc/Payment tab
        elementUtils.safeClick(TabSiteDoc);
        Thread.sleep(2000);

        elementUtils.doSendKeysWithClear(ClientFirstName, firstName);
        elementUtils.doSendKeysWithClear(ClientLastName, lastName);
        elementUtils.doSendKeysWithClear(ComapanyName, companyName);
        elementUtils.doSendKeysWithClear(ClientDisplayName, displayName);
        elementUtils.doSendKeysWithClear(ClientMainPhone, mainPhone);
        elementUtils.doSendKeysWithClear(ClientMobilePhone, mobile);
        elementUtils.doSendKeysWithClear(ClientEmail, email);
        elementUtils.doSendKeysWithClear(FaxOffice, fax);
        elementUtils.doSendKeysWithClear(Clientterms, terms);
        selectFromAntSelect(BillingCycleDropdown, billingCycle);
        elementUtils.doSendKeysWithClear(BillingInvoiceNumber, invoiceNumber);
        elementUtils.doSendKeysWithClear(BillingStreetNumber, streetNum);
        elementUtils.doSendKeysWithClear(BillingStreetName, streetName);
        elementUtils.doSendKeysWithClear(BillingCity, city);
        elementUtils.doSendKeysWithClear(BillingState, state);
        elementUtils.doSendKeysWithClear(BillingZipCode, zip);
        elementUtils.doSendKeysWithClear(BillingCountry, country);
    }

    // ===== PAGE 15: Feedback Comments =====
    public void fillFeedbackComments(String comments) throws InterruptedException {
        // Navigate to Feedback Comments tab
        elementUtils.safeClick(TabFeedback);
        Thread.sleep(2000);
        elementUtils.doSendKeysWithClear(CommnetsComplimentsTextArea, comments);
    }

    // ===== Common: Click Update Button =====
    public void clickUpdate() throws InterruptedException {
        Thread.sleep(2000);
        elementUtils.safeClick(ButtonUpdate);
        try {
            By successToast = By.xpath(
                    "//div[contains(@class,'ant-message-success') or contains(@class,'ant-notification')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
            System.out.println("Update successful");
        } catch (Exception e) {
            System.out.println(" Update toast not detected, but continuing...");
        }
    }

    /**
     * Dynamically detects ALL visible tabs on a site and clicks Update on each.
     * Safe for production — no data changes, only clicks existing Update buttons.
     * - Skips tabs with no Update button
     * - Skips tabs where Update fails (e.g., required field validation)
     * - No toast waiting — just click and move on
     *
     * @return int[] = {tabsAttempted, tabsSucceeded, tabsSkipped, tabsFailed}
     */
    public int[] clickUpdateOnAllTabs(String siteId) {
        int tabsAttempted = 0;
        int tabsSucceeded = 0;
        int tabsSkipped = 0;
        int tabsFailed = 0;

        try {
            // Wait for page to fully load
            try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            // Find ALL visible tabs dynamically
            List<WebElement> tabs = driver.findElements(By.xpath("//div[@role='tab']"));
            int totalTabs = tabs.size();
            System.out.println("🔍 Site " + siteId + " — Found " + totalTabs + " tabs");

            if (totalTabs == 0) {
                System.out.println("⚠️ Site " + siteId + " — No tabs found! Skipping.");
                return new int[]{0, 0, 0, 0};
            }

            for (int i = 0; i < totalTabs; i++) {
                // Re-find tabs each iteration (DOM may refresh after Update clicks)
                tabs = driver.findElements(By.xpath("//div[@role='tab']"));
                if (i >= tabs.size()) {
                    System.out.println("⚠️ Site " + siteId + " — Tab index " + i + " out of range. Breaking.");
                    break;
                }

                WebElement tab = tabs.get(i);
                String tabName = "Unknown";
                try {
                    tabName = tab.getText().trim();
                    if (tabName.isEmpty()) tabName = "Tab " + (i + 1);
                } catch (Exception e) {
                    tabName = "Tab " + (i + 1);
                }

                tabsAttempted++;

                try {
                    // Click the tab
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", tab);
                    try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    tab.click();
                    try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

                    // Check if Update button exists on this tab
                    List<WebElement> updateButtons = driver.findElements(By.xpath("//button[normalize-space()='Update']"));
                    if (updateButtons.isEmpty()) {
                        System.out.println("  ⏭️ Tab " + (i + 1) + "/" + totalTabs + ": " + tabName + " — No Update button, skipping");
                        tabsSkipped++;
                        continue;
                    }

                    // Scroll to Update button and click
                    WebElement updateBtn = updateButtons.get(0);
                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", updateBtn);
                    try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

                    try {
                        updateBtn.click();
                    } catch (Exception clickEx) {
                        // Fallback: JS click
                        js.executeScript("arguments[0].click();", updateBtn);
                    }

                    // Brief wait for the action to complete (no toast waiting)
                    try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

                    // Check if any validation error appeared (required field)
                    List<WebElement> errors = driver.findElements(By.xpath(
                            "//div[contains(@class,'ant-form-item-explain-error')] | //div[contains(@class,'ant-message-error')]"));
                    if (!errors.isEmpty()) {
                        System.out.println("  ⚠️ Tab " + (i + 1) + "/" + totalTabs + ": " + tabName + " — Validation error, skipping");
                        tabsSkipped++;
                        continue;
                    }

                    System.out.println("  ✅ Tab " + (i + 1) + "/" + totalTabs + ": " + tabName + " — Updated");
                    tabsSucceeded++;

                } catch (Exception tabError) {
                    tabsFailed++;
                    System.out.println("  ❌ Tab " + (i + 1) + "/" + totalTabs + ": " + tabName + " — " + tabError.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Site " + siteId + " — Critical error: " + e.getMessage());
        }

        System.out.println("📊 Site " + siteId + " → ✅ " + tabsSucceeded + " updated | ⏭️ " + tabsSkipped
                + " skipped | ❌ " + tabsFailed + " failed (out of " + tabsAttempted + " tabs)");
        return new int[]{tabsAttempted, tabsSucceeded, tabsSkipped, tabsFailed};
    }

    public void clickBackButton() throws InterruptedException {
		Thread.sleep(2000);
		elementUtils.safeClick(BackbuttonSites);
	}

    /**
     * Opens an Ant Design select at the given locator, filters by typing the target
     * text,
     * then uses ARROW_DOWN navigation and ENTER to confirm selection. Also scrolls
     * the panel.
     */
    private void selectAntSelectWithArrow(By selectContainerLocator, String targetText, int maxArrowSteps) {
        if (targetText == null || targetText.isBlank())
            return;
        try {
            // Open the select
            elementUtils.safeClick(selectContainerLocator);
            WebElement panel = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(AntSelectDropdownPanel));

            // Try typing into the focused combobox input to filter
            WebElement focused = driver.switchTo().activeElement();
            try {
                focused.sendKeys(targetText);
                Thread.sleep(300);
            } catch (Exception ignore) {
            }

            // Navigate with ARROW_DOWN up to maxArrowSteps; select when active option
            // matches
            for (int i = 0; i < Math.max(1, maxArrowSteps); i++) {
                new org.openqa.selenium.interactions.Actions(driver)
                        .sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                        .perform();
                Thread.sleep(120);
                List<WebElement> active = driver.findElements(AntSelectActiveOption);
                if (!active.isEmpty()) {
                    String txt = active.get(0).getText().trim();
                    if (txt.equalsIgnoreCase(targetText) || txt.toLowerCase().contains(targetText.toLowerCase())) {
                        new org.openqa.selenium.interactions.Actions(driver)
                                .sendKeys(org.openqa.selenium.Keys.ENTER)
                                .perform();
                        elementUtils.pressEscapeKey();
                        return;
                    }
                }
                // small scroll to reveal more options
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 60;", panel);
            }

            // Fallback: click matching option by text if present
            List<WebElement> options = driver.findElements(AntSelectOptions);
            for (WebElement opt : options) {
                String txt = opt.getText().trim();
                if (txt.equalsIgnoreCase(targetText) || txt.toLowerCase().contains(targetText.toLowerCase())) {
                    elementUtils.doClickWeBElement(opt);
                    elementUtils.pressEscapeKey();
                    return;
                }
            }

            // Final fallback: press enter to accept current selection
            new org.openqa.selenium.interactions.Actions(driver)
                    .sendKeys(org.openqa.selenium.Keys.ENTER)
                    .perform();
            elementUtils.pressEscapeKey();
        } catch (Exception e) {
            System.out.println("⚠️ selectAntSelectWithArrow failed for: " + targetText + " - " + e.getMessage());
        }
    }
}
