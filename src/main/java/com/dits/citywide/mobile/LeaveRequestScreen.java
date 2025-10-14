package com.dits.citywide.mobile;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.AppElementUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LeaveRequestScreen {

	AppiumDriver driver;
	AppElementUtils appElementUtils;

	private By txtHeadingLeaveRequest = AppiumBy.androidUIAutomator("new UiSelector().text(\"Leave Requests\")");
	private By btnApplyLeave = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(9)");
	private By btnBellIcon = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)");
	private By searchLeave = AppiumBy.androidUIAutomator("new UiSelector().text(\"Search\")");
	private List<By> leaveTypes = Arrays.asList(AppiumBy.androidUIAutomator("new UiSelector().text(\"Leave Type*\")"),
			AppiumBy.accessibilityId("Leave Type*, Leave Type*"),
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"text-input-outline\").instance(0)"));

	private By getViewGroupByAccessibilityId(String value) {
		String xpath = String.format("//android.view.ViewGroup[@content-desc='%s']", value);
		return By.xpath(xpath);
	}

	private By btnSelectFromDate = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(23)");
	private By btnSelectToDate = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(28)");
	private By txtboxDescription = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(3)");
	private By btnApplyLeaveSubmit = AppiumBy
			.androidUIAutomator("new UiSelector().description(\"Apply Leave\").instance(1)");
	private By btnClear = AppiumBy.accessibilityId("Clear");
	private By btnBackArrow = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(9)");

	private List<By> txtSuccessMessage = Arrays.asList(
			AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"toastText2\")"),
			AppiumBy.id("toastAnimatedContainer"));

	// Edit Leave locators
	private By btnEditLeave = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
	private By txtboxEditDescription = AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Leave\")");
	private List<By> dropDownLeaveType = Arrays.asList(AppiumBy.xpath(
			"//android.widget.TextView[@text=\"Leave Type*\"]/ancestor::android.view.ViewGroup/following-sibling::android.widget.EditText"),
			AppiumBy.id("right-icon-adornment-container"));
	private By btnFromUpdateDate = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(23)");
	private By btnToUpdateDate = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(28)");
	private By btnUpdateDescription = AppiumBy.xpath(
			"//android.widget.TextView[@text='Description*']/ancestor::android.view.ViewGroup/following-sibling::android.widget.EditText");
	private By btnUpdateLeaveSubmit = AppiumBy.accessibilityId("Update Leave");
	private By btnUpdateClear = AppiumBy.accessibilityId("Clear");

	// Cancel Leave locators
	private By btnCancelLeave = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)");

	public LeaveRequestScreen(AppiumDriver driver) {
		this.driver = driver;
		appElementUtils = new AppElementUtils(driver);
	}

	public By findLocatorWithFallback(List<By> locators) {
		for (By locator : locators) {
			try {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return locator;
				}
			} catch (Exception ignored) {
			}
		}
		throw new RuntimeException("Element not found using provided locators: " + locators);
	}

	public boolean isLeaveRequestHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtHeadingLeaveRequest, Constants.DEFAULT_WAIT);
	}

	public boolean isApplyLeaveButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnApplyLeave, Constants.DEFAULT_WAIT);
	}

	public void clickOnApplyLeaveButton() throws InterruptedException {
		appElementUtils.safeClick(btnApplyLeave, Constants.DEFAULT_WAIT);
	}

	public boolean isBellIconDisplayed() {
		return appElementUtils.doIsDisplayed(btnBellIcon, Constants.DEFAULT_WAIT);
	}

	public boolean isSearchLeaveDisplayed() {
		return appElementUtils.doIsDisplayed(searchLeave, Constants.DEFAULT_WAIT);
	}

	public boolean isLeaveTypeDropdownDisplayed() {
		return appElementUtils.doIsDisplayed(findLocatorWithFallback(leaveTypes), Constants.DEFAULT_WAIT);
	}

	public void clickOnLeaveTypeDropdown() throws InterruptedException {
		appElementUtils.safeClick(findLocatorWithFallback(leaveTypes), Constants.DEFAULT_WAIT);
	}

	public void selectLeaveType(String leaveType) throws InterruptedException {
		By leaveTypeOption = getViewGroupByAccessibilityId(leaveType);
		appElementUtils.safeClick(leaveTypeOption, Constants.DEFAULT_WAIT);
	}

	public boolean isFromDateButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnSelectFromDate, Constants.DEFAULT_WAIT);
	}

	public void clickOnFromDateButton() throws InterruptedException {
		appElementUtils.safeClick(btnSelectFromDate, Constants.DEFAULT_WAIT);
	}

	public boolean isToDateButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnSelectToDate, Constants.DEFAULT_WAIT);
	}

	public void clickOnToDateButton() throws InterruptedException {
		appElementUtils.safeClick(btnSelectToDate, Constants.DEFAULT_WAIT);
	}

	public boolean isDescriptionTextboxDisplayed() {
		return appElementUtils.doIsDisplayed(txtboxDescription, Constants.DEFAULT_WAIT);
	}

	public void enterDescription(String description) throws InterruptedException {
		appElementUtils.doSendKeysWithWait(txtboxDescription, description, Constants.DEFAULT_WAIT);
	}

	public boolean isApplyLeaveSubmitButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnApplyLeaveSubmit, Constants.DEFAULT_WAIT);
	}

	public void clickOnApplyLeaveSubmitButton() throws InterruptedException {
		appElementUtils.safeClick(btnApplyLeaveSubmit, Constants.DEFAULT_WAIT);
	}

	public boolean isClearButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnClear, Constants.DEFAULT_WAIT);
	}

	public void clickOnClearButton() throws InterruptedException {
		appElementUtils.safeClick(btnClear, Constants.DEFAULT_WAIT);
	}

	public void clickOnBackArrow() throws InterruptedException {
		appElementUtils.safeClick(btnBackArrow, Constants.DEFAULT_WAIT);
	}

	public boolean isBackArrowDisplayed() {
		return appElementUtils.doIsDisplayed(btnBackArrow, Constants.DEFAULT_WAIT);
	}

	public boolean isSuccessMessageDisplayed() {
		return appElementUtils.doIsDisplayed(findLocatorWithFallback(txtSuccessMessage), Constants.DEFAULT_WAIT);
	}

	// Edit Leave methods
	public void clickOnEditLeaveButton() throws InterruptedException {
		appElementUtils.safeClick(btnEditLeave, Constants.DEFAULT_WAIT);
	}

	public boolean isEditLeaveHeadingDisplayed() {
		return appElementUtils.doIsDisplayed(txtboxEditDescription, Constants.DEFAULT_WAIT);
	}

	public boolean isLeaveTypeDropdownInEditDisplayed() {
		return appElementUtils.doIsDisplayed(findLocatorWithFallback(dropDownLeaveType), Constants.DEFAULT_WAIT);
	}

	public void clickOnLeaveTypeDropdownInEdit() throws InterruptedException {
		appElementUtils.safeClick(findLocatorWithFallback(dropDownLeaveType), Constants.DEFAULT_WAIT);
	}

	public void selectLeaveTypeInEdit(String leaveType) throws InterruptedException {
		By leaveTypeOption = getViewGroupByAccessibilityId(leaveType);
		appElementUtils.safeClick(leaveTypeOption, Constants.DEFAULT_WAIT);
	}

	public boolean isFromDateButtonInEditDisplayed() {
		return appElementUtils.doIsDisplayed(btnFromUpdateDate, Constants.DEFAULT_WAIT);
	}

	public void clickOnFromDateButtonInEdit() throws InterruptedException {
		appElementUtils.safeClick(btnFromUpdateDate, Constants.DEFAULT_WAIT);
	}

	public boolean isToDateButtonInEditDisplayed() {
		return appElementUtils.doIsDisplayed(btnToUpdateDate, Constants.DEFAULT_WAIT);
	}

	public void clickOnToDateButtonInEdit() throws InterruptedException {
		appElementUtils.safeClick(btnToUpdateDate, Constants.DEFAULT_WAIT);
	}

	public boolean isDescriptionTextboxInEditDisplayed() {
		return appElementUtils.doIsDisplayed(btnUpdateDescription, Constants.DEFAULT_WAIT);
	}

	public void enterDescriptionInEdit(String description) throws InterruptedException {
		appElementUtils.doSendKeysWithWait(btnUpdateDescription, description, Constants.DEFAULT_WAIT);
	}

	public boolean isUpdateLeaveSubmitButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnUpdateLeaveSubmit, Constants.DEFAULT_WAIT);
	}

	public void clickOnUpdateLeaveSubmitButton() throws InterruptedException {
		appElementUtils.safeClick(btnUpdateLeaveSubmit, Constants.DEFAULT_WAIT);
	}

	public boolean isUpdateClearButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnUpdateClear, Constants.DEFAULT_WAIT);
	}

	public void clickOnUpdateClearButton() throws InterruptedException {
		appElementUtils.safeClick(btnUpdateClear, Constants.DEFAULT_WAIT);
	}

	// Cancel Leave methods
	public void clickOnCancelLeaveButton() throws InterruptedException {
		appElementUtils.safeClick(btnCancelLeave, Constants.DEFAULT_WAIT);
	}

}
