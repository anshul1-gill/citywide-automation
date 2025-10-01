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
	private By tabAssignments = AppiumBy.accessibilityId("Assignments");
	private By tabAllReports = AppiumBy.accessibilityId("All Reports");
	private By tabMyReports = AppiumBy.accessibilityId("My Reports");
	private By menuButton = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
	private By btnSubmitReport = AppiumBy.accessibilityId("Submit Reports");
	private By btnPreFlightReport = AppiumBy.accessibilityId("Pre-Flight-Report");
	// private By btnPreFlight = AppiumBy.androidUIAutomator("new
	// UiSelector().text(\"Pre-Flight-Report\")");

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
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(17)");
	private By txtHeadingUpdateOfficerReportEntry = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Update Officer Report Entry\")");
	private By btnArriveDateTime = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");
	// private By dropdownPatrolSite = AppiumBy.androidUIAutomator("new
	// UiSelector().text(\"Patrol Site*\")");
	private List<By> patrolSiteLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(2)"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Patrol Site*\")"));

	private By dropdownActivityCode = AppiumBy.androidUIAutomator("new UiSelector().text(\"Activity Code*\")");
	private By searchActivityCode = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(3)");

	private By getDynamicLocatorByContentDesc(String value) {
		return By.xpath("//android.view.ViewGroup[contains(@content-desc,'" + value + "')]");
	}

	// private By dropdownCall = AppiumBy.accessibilityId("Call, Call");
	private List<By> callDropdownLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(4)"),
			AppiumBy.accessibilityId("Call, Call"),
			AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"text-input-outline\"])[5]"),
			AppiumBy.id("right-icon-adornment"));

	// private By btnReportAddress = AppiumBy.accessibilityId("Report Address");
	private List<By> reportAddressLocators = Arrays.asList(AppiumBy.accessibilityId("Report Address"),
			AppiumBy.androidUIAutomator("new UiSelector().description(\"Report Address\")"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Report Address\")"));
//	private By txtboxAddress = AppiumBy
//			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(5)");
//	private By txtboxAddress2 = AppiumBy.androidUIAutomator("new UiSelector().text(\"Address\")");

	private List<By> addressLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(5)"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Address\")"));

	// private By txtboxDescription = AppiumBy.androidUIAutomator("new
	// UiSelector().text(\"Description\")");
	private List<By> descriptionLocators = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(3)"),
			AppiumBy.androidUIAutomator("new UiSelector().text(\"Description\")"), AppiumBy.xpath(
					"//android.widget.TextView[@resource-id=\"text-input-outlined-label-inactive\" and @text=\"Description\"]"));

	private By uploadImage = AppiumBy.accessibilityId("Select your file(s) to start uploading, Browse files");
	private By btnUpdateReport = AppiumBy.accessibilityId("Update Report");
	private By btnCancelReport = AppiumBy.accessibilityId("Cancel");

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
		// appElementUtils.waitForElementToBeClickable(btnPreFlight,
		// Constants.DEFAULT_WAIT);
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

		Thread.sleep(4000);
		appElementUtils.safeClick(findLocatorWithFallback(callDropdownLocators), Constants.DEFAULT_WAIT);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(call), Constants.DEFAULT_WAIT);

		appElementUtils.doClickWithWait(findLocatorWithFallback(reportAddressLocators), Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(findLocatorWithFallback(addressLocators), address, Constants.DEFAULT_WAIT);
		Thread.sleep(2000);
		appElementUtils.doClickWithWait(getDynamicLocatorByContentDesc(address), Constants.DEFAULT_WAIT);

		appElementUtils.scrollToTextAndroidNew("Description");
		Thread.sleep(5000);
		appElementUtils.doSendKeysWithWait(findLocatorWithFallback(descriptionLocators), description,
				Constants.DEFAULT_WAIT);
		Thread.sleep(5000);
	}

	public void tapUpdateReportButton() {
		appElementUtils.doClickWithWait(btnUpdateReport, Constants.DEFAULT_WAIT);
	}

	public void tapCancelReportButton() {
		appElementUtils.doClickWithWait(btnCancelReport, Constants.DEFAULT_WAIT);
	}

}