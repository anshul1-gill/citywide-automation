package com.dits.citywide.mobile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.AppElementUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.WaitOptions;
import java.time.Duration;

public class ReportsScreen {

	AppiumDriver driver;
	AppElementUtils appElementUtils;

	private By txtHeadingReports = AppiumBy.androidUIAutomator("new UiSelector().text(\"Reports\").instance(0)");
	private By txtboxSearch = AppiumBy.androidUIAutomator("new UiSelector().text(\"Search\")");
	// private By tabAssignments = AppiumBy.accessibilityId("Assignments");
	// private By tabAllReports = AppiumBy.accessibilityId("All Reports");
	private By tabMyReports = AppiumBy.accessibilityId("My Reports");
	private By menuButton = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
	private By btnSubmitReport = AppiumBy.accessibilityId("Submit Reports");
	private By btnPreFlightReport = AppiumBy.accessibilityId("Pre-Flight-Report");

	private By txtConfirmationMessage = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"This will create 8 empty reports for your current site.\")");
	private By iconImage = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(4)");
	private By btnOk = AppiumBy.accessibilityId("Ok");
	private By btnCancel = AppiumBy.accessibilityId("Cancel");

	private By successMessage = AppiumBy.id("toastTouchableContainer");
	// private By successMessageText = AppiumBy.accessibilityId("Success, Prefilght
	// created successfully");
	private By firstTilePreflightReport = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Preflight\").instance(0)");
	private By btnEditReport = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");

	// My Reports tab
	private By btnAddNewReport = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(16)");
	private By txtHeadingUpdateOfficerReportEntry = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Update Officer Report Entry\")");
	private By btnArriveDateTime = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(13)");

	private List<By> patrolSiteLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(2)"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Patrol Site*\")"));

	private By dropdownActivityCode = AppiumBy.androidUIAutomator("new UiSelector().text(\"Activity Code*\")");
	private By searchActivityCode = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(3)");

	private By getDynamicLocatorByContentDesc(String value) {
		return By.xpath("//android.view.ViewGroup[contains(@content-desc,'" + value + "')]");
	}

	private List<By> callDropdownLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outline\").instance(4)"),
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"right-icon-adornment\")"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Call\")"));

	private List<By> reportAddressLocators = Arrays.asList(AppiumBy.accessibilityId("Report Address"),
			AppiumBy.androidUIAutomator("new UiSelector().description(\"Report Address\")"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Report Address\")"));

	private List<By> addressLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(5)"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Address\")"));

	private List<By> descriptionLocators = Arrays.asList(AppiumBy.xpath(
			"//android.widget.TextView[@text=\"Description\"]/ancestor::android.view.ViewGroup/following-sibling::android.widget.EditText[@resource-id=\"text-input-outlined\"]"));

	private By uploadImage = AppiumBy.accessibilityId("Select your file(s) to start uploading, Browse files");
	private By btnUpdateReport = AppiumBy.accessibilityId("Update Report");
	private By btnCancelReport = AppiumBy.accessibilityId("Cancel");

	private By btnSaveNewReport = AppiumBy.accessibilityId("Save New Report");
	private By btnClear = AppiumBy.accessibilityId("Clear");

	private By txtSuccessToast = AppiumBy.id("toastText2");

	// Assignments tab
	private By tabAssignments = AppiumBy.accessibilityId("Assignments");
	private By searchBox = AppiumBy.androidUIAutomator("new UiSelector().text(\"Search\")");
	private By firstAssignmentTile = AppiumBy.xpath("//android.widget.TextView[@text=\"Pending\"]");

	// All reports tab
	private By tabAllReports = AppiumBy.accessibilityId("All Reports");
	private By searchBoxAllReports = AppiumBy.androidUIAutomator("new UiSelector().text(\"Search\")");
	private By btnAddReportAllReports = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(16)");
	private By filterButton = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
	private By txtSelectDateRange = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Select Date Range\")");
	private By txtboxStartDate = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[1]");
	private By txtboxEndDate = AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]");
	private By btnClearAllFilters = AppiumBy.accessibilityId("Clear");
	private By btnSearchAllFilters = AppiumBy.accessibilityId("Search");

	public ReportsScreen(AppiumDriver driver) {
		this.driver = driver;
		appElementUtils = new AppElementUtils(driver);
	}

	public By findLocatorWithFallback(List<By> locators) {
		for (By locator : locators) {
			try {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return locator; // return the locator itself
				}
			} catch (Exception ignored) {
			}
		}
		throw new RuntimeException("Element not found using provided locators: " + locators);
	}

	public boolean isReportsHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingReports, Constants.DEFAULT_WAIT);
	}

	public boolean isSearchBoxDisplayed() {
		return appElementUtils.doIsDisplayed(txtboxSearch, Constants.DEFAULT_WAIT);
	}

	public boolean isAssignmentsTabDisplayed() {
		return appElementUtils.doIsDisplayed(tabAssignments, Constants.DEFAULT_WAIT);
	}

	public boolean isAllReportsTabDisplayed() {
		return appElementUtils.doIsDisplayed(tabAllReports, Constants.DEFAULT_WAIT);
	}

	public boolean isMyReportsTabDisplayed() {
		return appElementUtils.doIsDisplayed(tabMyReports, Constants.DEFAULT_WAIT);
	}

	public boolean isMenuButtonDisplayed() {
		return appElementUtils.doIsDisplayed(menuButton, Constants.DEFAULT_WAIT);
	}

	public void clickOnMenuButton() {
		appElementUtils.doClickWithWait(menuButton, Constants.DEFAULT_WAIT);
	}

	public boolean isSubmitReportButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnSubmitReport, Constants.DEFAULT_WAIT);
	}

	public boolean isPreFlightReportButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnPreFlightReport, Constants.DEFAULT_WAIT);
	}

	public void tapPreFlightReportButton() {
		appElementUtils.safeClick(btnPreFlightReport, Constants.DEFAULT_WAIT);
	}

	public boolean isConfirmationMessageDisplayed() {
		return appElementUtils.doIsDisplayed(txtConfirmationMessage, Constants.DEFAULT_WAIT);
	}

	public boolean isImageIconDisplayed() {
		return appElementUtils.doIsDisplayed(iconImage, Constants.DEFAULT_WAIT);
	}

	public void tapOkButton() {
		appElementUtils.doClickWithWait(btnOk, Constants.DEFAULT_WAIT);
	}

	public void tapCancelButton() {
		appElementUtils.doClickWithWait(btnCancel, Constants.DEFAULT_WAIT);
	}

	public boolean isSuccessMessageDisplayed() {
		return appElementUtils.doIsDisplayed(successMessage, Constants.DEFAULT_WAIT);
	}

	public void slideFirstPreflightReport() {
		WebElement eleFirstTile = appElementUtils.waitForElementVisible(firstTilePreflightReport,
				Constants.DEFAULT_WAIT);
		appElementUtils.swipeElement(eleFirstTile, "left");
	}

	public void tapEditReportButton() throws InterruptedException {
		appElementUtils.doClickWithWait(btnEditReport, Constants.DEFAULT_WAIT);
	}

	// My Reports tab methods

	public void tapAddNewReportButton() {
		appElementUtils.doClickWithWait(btnAddNewReport, Constants.DEFAULT_WAIT);
	}

	public boolean isHeadingUpdateOfficerReportEntryDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingUpdateOfficerReportEntry, Constants.DEFAULT_WAIT);
	}

	public void uploadImage() {
		try {
			// 1. Push the image file to the device (e.g., to /sdcard/Download/image.jpeg)
			String localPath = System.getProperty("user.dir") + "/src/test/resource/testdata/image.jpeg";
			String devicePath = "/sdcard/Download/image.jpeg";
			appElementUtils.pushFileToDevice(localPath, devicePath);
		} catch (Exception e) {
			throw new RuntimeException("Failed to push image to device", e);
		}
		// 2. Click the upload button to open the file picker
		appElementUtils.doClickWithWait(uploadImage, Constants.DEFAULT_WAIT);
		// 3. TODO: Automate file picker selection if needed (depends on app's UI)
	}

	public void fillReportForm(String patrolSite, String activityCode, String call, String address, String description)
			throws InterruptedException {
		Thread.sleep(5000);
		appElementUtils.safeClick(btnArriveDateTime, Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(findLocatorWithFallback(patrolSiteLocators), Constants.DEFAULT_WAIT);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(patrolSite), Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(dropdownActivityCode, Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(searchActivityCode, activityCode, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(activityCode), Constants.DEFAULT_WAIT);

//		Thread.sleep(4000);
//		appElementUtils.safeClick(findLocatorWithFallback(callDropdownLocators), Constants.DEFAULT_WAIT);
//		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(call), Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(findLocatorWithFallback(reportAddressLocators), Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(findLocatorWithFallback(addressLocators), address, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(address), Constants.DEFAULT_WAIT);

		appElementUtils.scrollToTextAndroidNew("Description");
		Thread.sleep(2000);
		appElementUtils.doSendKeysWithWait(findLocatorWithFallback(descriptionLocators), description,
				Constants.DEFAULT_WAIT);
	}

	public void tapUpdateReportButton() {
		appElementUtils.scrollToTextAndroidNew("Update Report");
		appElementUtils.waitForElementVisible(btnUpdateReport, Constants.DEFAULT_WAIT);
		appElementUtils.doClickWithWait(btnUpdateReport, Constants.DEFAULT_WAIT);
	}

	public void tapCancelReportButton() throws InterruptedException {
		appElementUtils.scrollToTextAndroidNew("Cancel");
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(btnCancelReport, Constants.DEFAULT_WAIT);
	}

	public void tapSaveNewReportButton() throws InterruptedException {
		appElementUtils.scrollToTextAndroidNew("Save New Report");
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(btnSaveNewReport, Constants.DEFAULT_WAIT);
	}

	public void tapClearButton() throws InterruptedException {
		appElementUtils.scrollToTextAndroidNew("Clear");
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(btnClear, Constants.DEFAULT_WAIT);
	}

	public void getSouceCode() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}

	public String isSuccessToastDisplayed() {
		try {
			WebElement toastElement = appElementUtils.waitForElementVisible(txtSuccessToast, Constants.DEFAULT_WAIT);
			String toastText = toastElement.getText();
			System.out.println("Toast message: " + toastText);
			return toastText;
		} catch (Exception e) {
			return null;
		}
	}

	// Assignments tab methods
	public void clickOnAssignmentsTab() {
		appElementUtils.safeClick(tabAssignments, Constants.DEFAULT_WAIT);
	}

	public boolean isSearchBoxInAssignmentsTabDisplayed() {
		return appElementUtils.doIsDisplayed(searchBox, Constants.DEFAULT_WAIT);
	}

	public void enterTextInSearchBox(String text) {
		appElementUtils.doSendKeysWithWait(searchBox, text, Constants.DEFAULT_WAIT);
	}

	public void tapFirstAssignmentTile() {
		appElementUtils.safeClick(firstAssignmentTile, Constants.DEFAULT_WAIT);
	}

	public void fillAssignmentReportForm(String patrolSite, String activityCode, String call, String address,
			String description) throws InterruptedException {
		Thread.sleep(5000);
		appElementUtils.safeClick(btnArriveDateTime, Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(findLocatorWithFallback(patrolSiteLocators), Constants.DEFAULT_WAIT);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(patrolSite), Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(dropdownActivityCode, Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(searchActivityCode, activityCode, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(activityCode), Constants.DEFAULT_WAIT);

//		Thread.sleep(4000);
//		appElementUtils.safeClick(findLocatorWithFallback(callDropdownLocators), Constants.DEFAULT_WAIT);
//		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(call), Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(findLocatorWithFallback(reportAddressLocators), Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(findLocatorWithFallback(addressLocators), address, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(address), Constants.DEFAULT_WAIT);

		appElementUtils.scrollToTextAndroidNew("Description");
		Thread.sleep(2000);
		appElementUtils.doSendKeysWithWait(findLocatorWithFallback(descriptionLocators), description,
				Constants.DEFAULT_WAIT);
	}

	// All Reports tab methods

	public void clickOnAllReportsTab() {
		appElementUtils.safeClick(tabAllReports, Constants.DEFAULT_WAIT);
	}

	public boolean isSearchBoxInAllReportsTabDisplayed() {
		return appElementUtils.doIsDisplayed(searchBoxAllReports, Constants.DEFAULT_WAIT);
	}

	public void enterTextInSearchBoxAllReportsTab(String text) {
		appElementUtils.doSendKeysWithWait(searchBoxAllReports, text, Constants.DEFAULT_WAIT);
	}
	
	public boolean isAddReportButtonInAllReportsTabDisplayed() {
		return appElementUtils.doIsDisplayed(btnAddReportAllReports, Constants.DEFAULT_WAIT);
	}

	public void tapAddReportInAllReportsTab() {
		appElementUtils.doClickWithWait(btnAddReportAllReports, Constants.DEFAULT_WAIT);
	}

	public void tapFilterButton() {
		appElementUtils.doClickWithWait(filterButton, Constants.DEFAULT_WAIT);
	}
	
	public boolean isSelectDateRangeTextDisplayed() {
		return appElementUtils.doIsDisplayed(txtSelectDateRange, Constants.DEFAULT_WAIT);
	}

	public void enterStartDate(String startDate) {
		appElementUtils.doClickWithWait(txtboxStartDate, Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(txtboxStartDate, startDate, Constants.DEFAULT_WAIT);
	}

	public void enterEndDate(String endDate) {
		appElementUtils.doClickWithWait(txtboxEndDate, Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(txtboxEndDate, endDate, Constants.DEFAULT_WAIT);
	}

	public void tapClearAllFiltersButton() {
		appElementUtils.doClickWithWait(btnClearAllFilters, Constants.DEFAULT_WAIT);
	}

	public void tapSearchAllFiltersButton() {
		appElementUtils.doClickWithWait(btnSearchAllFilters, Constants.DEFAULT_WAIT);
	}

}