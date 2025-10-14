package com.dits.citywide.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.AppElementUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class HomeScreen {

	AppiumDriver driver;
	WebDriverWait wait;
	AppElementUtils appElementUtils;

	private By boxOpenShifts = AppiumBy.androidUIAutomator("new UiSelector().text(\"Open\")");
	private By boxAssignedShift = AppiumBy.androidUIAutomator("new UiSelector().text(\"Assigned\")");
	private By boxCompleted = AppiumBy.androidUIAutomator("new UiSelector().text(\"Completed\")");
	private By btnConfirmAndRejectMultpleShift = AppiumBy.accessibilityId("Confirm/Reject Multiple Shifts");

	private By countOpenShifts = AppiumBy
			.xpath("//android.widget.TextView[@text=\"Open\"]/following-sibling::android.widget.TextView");
	private By countAssignedShifts = AppiumBy
			.xpath("//android.widget.TextView[@text=\"Assigned\"]/following-sibling::android.widget.TextView");
	private By countCompletedShifts = AppiumBy
			.xpath("//android.widget.TextView[@text=\"Completed\"]/following-sibling::android.widget.TextView");

	private By btnReject = AppiumBy.accessibilityId("Reject");
	private By btnConfirm = AppiumBy.accessibilityId("Confirm");
	private By btnStartShift = AppiumBy.accessibilityId("Start Shift");

	private By txtWelcome = AppiumBy.xpath("//android.widget.TextView[contains(@text, \"Welcome\")]");
	private By txtDescription = AppiumBy.androidUIAutomator(
			"new UiSelector().text(\"Hope you are doing well, lets begin your shift, remember shift also includes breaks please don’t hesitate for one !!\")");
	private By dataSiteName = AppiumBy
			.xpath("//android.widget.TextView[@text=\"Site:\"]/following-sibling::android.widget.TextView");

	private By tabReports = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)");
	private By tabShifts = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(5)");

	// Message of the week
	private By txtMessageOfTheWeek = AppiumBy.androidUIAutomator("new UiSelector().text(\"Message of the Week\")");
	private By btnMarkAsRead = AppiumBy.androidUIAutomator("new UiSelector().description(\"Mark As Read\")");

	// Logout from previous shift
	private By txtHeadingLogoutPreviousShift = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Logout of Previous Shift\")");
	private By txtSite = AppiumBy.androidUIAutomator("new UiSelector().text(\"Site Details\")");
	private By txtboxReason = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(3)");
	private By btnClear = AppiumBy.accessibilityId("Clear");
	private By btnSubmit = AppiumBy.accessibilityId("Submit");

	public HomeScreen(AppiumDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
		appElementUtils = new AppElementUtils(driver);
	}

	public boolean isOpenShiftsBoxDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(boxOpenShifts)).isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isAssignedShiftsBoxDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(boxAssignedShift)).isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isCompletedShiftsBoxDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(boxCompleted)).isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isConfirmAndRejectMultpleShiftButtonDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirmAndRejectMultpleShift))
					.isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public int getOpenShiftsCount() {
		String countText = driver.findElement(countOpenShifts).getText();
		return Integer.parseInt(countText);
	}

	public int getAssignedShiftsCount() {
		String countText = driver.findElement(countAssignedShifts).getText();
		return Integer.parseInt(countText);
	}

	public int getCompletedShiftsCount() {
		String countText = driver.findElement(countCompletedShifts).getText();
		return Integer.parseInt(countText);
	}

	public void tapConfirmAndRejectMultipleShiftButton() {
		driver.findElement(btnConfirmAndRejectMultpleShift).click();
	}

	public void tapRejectButton() {
		driver.findElement(btnReject).click();
	}

	public void tapConfirmButton() {
		driver.findElement(btnConfirm).click();
	}

	public void tapStartShiftButton() throws InterruptedException {
		appElementUtils.scrollToTextAndroidNew("Start Shift");
		Thread.sleep(1000);
		appElementUtils.doClickWithWait(btnStartShift, Constants.SHORT_TIME_OUT_WAIT);
		// driver.findElement(btnStartShift).click();
	}

	public ReportsScreen tapStartShift() throws InterruptedException {
		appElementUtils.scrollToTextAndroidNew("Start Shift");
		Thread.sleep(1000);

		appElementUtils.doClickWithWait(btnStartShift, Constants.SHORT_TIME_OUT_WAIT);
		// driver.findElement(btnStartShift).click();
		return new ReportsScreen(driver);
	}

	public void handleMessageOfTheWeek() {
		try {
			if (appElementUtils.doIsDisplayed(txtMessageOfTheWeek, Constants.SHORT_TIME_OUT_WAIT)) {
				appElementUtils.scrollToTextAndroidNew("Mark As Read");
				Thread.sleep(1000);
				appElementUtils.safeClick(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(txtMessageOfTheWeek));
				System.out.println("Clicked on 'Mark As Read' button and popup closed.");
			} else {
				System.out.println("'Message of the Week' not present. Skipping.");
			}
		} catch (Exception e) {
			System.out.println("Exception while handling 'Mark As Read': " + e.getMessage());
		}
	}

	public void handleLogoutOfPreviousShift() {
		try {
			if (appElementUtils.doIsDisplayed(txtHeadingLogoutPreviousShift, Constants.SHORT_TIME_OUT_WAIT)) {
				System.out.println("'Logout of Previous Shift' popup is displayed.");
				appElementUtils.doSendKeysWithWait(txtboxReason, "Ending My Previous Shift",
						Constants.SHORT_TIME_OUT_WAIT);
				appElementUtils.safeClick(btnSubmit, Constants.SHORT_TIME_OUT_WAIT);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(txtHeadingLogoutPreviousShift));
				System.out.println("Submitted reason and popup closed.");
			} else {
				System.out.println("'Logout of Previous Shift' popup not present. Skipping.");
			}
		} catch (Exception e) {
			System.out.println("Exception while handling 'Logout of Previous Shift': " + e.getMessage());
		}
	}

	public boolean isWelcomeTextDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(txtWelcome)).isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public boolean isDescriptionTextDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(txtDescription)).isDisplayed();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public String getSiteName() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(dataSiteName)).getText();
		} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			return null;
		}
	}

	public ReportsScreen clickOnReportsTab() {
		appElementUtils.doClickWithWait(tabReports, Constants.DEFAULT_WAIT);
		return new ReportsScreen(driver);
	}

	public MenuScreen clickOnMoreTab() {
		appElementUtils.doClickWithWait(tabShifts, Constants.DEFAULT_WAIT);
		return new MenuScreen(driver);
	}

}