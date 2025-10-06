package com.dits.citywide.mobile;

import org.openqa.selenium.By;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.AppElementUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginScreen {

	AppiumDriver driver;
	AppElementUtils appElementUtils;

	private By btnNext = AppiumBy.accessibilityId("Next");
	private By txtboxSearch = AppiumBy.className("android.widget.EditText");
	private By txtResult = AppiumBy.xpath("//android.widget.TextView[@text='city wide protection services']");

	private By txtLoginHeader = AppiumBy.androidUIAutomator("new UiSelector().text(\"Please Login\")");
	private By btnInfo = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");
	private By checkboxRememberMe = AppiumBy.androidUIAutomator("new UiSelector().text(\"Remember me\")");
	private By lnkSwichToOrganizationPage = AppiumBy
			.androidUIAutomator("new UiSelector().text(\"Switch to Organisation Page\")");

	private By txtboxBadgeNumber = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(0)");
	private By txtboxPassword = AppiumBy
			.androidUIAutomator("new UiSelector().resourceId(\"text-input-outlined\").instance(1)");
	private By btnLogin = AppiumBy.accessibilityId("Sign In");
	private By txtWelcome = AppiumBy.androidUIAutomator("new UiSelector().text(\"Welcome\")");

	public LoginScreen(AppiumDriver driver) {
		this.driver = driver;
		appElementUtils = new AppElementUtils(driver);
	}

	public void searchAndProceed(String searchText) throws InterruptedException {
		Thread.sleep(2000);
		appElementUtils.safeClick(btnNext, Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(txtboxSearch, searchText, Constants.DEFAULT_WAIT);
		appElementUtils.safeClick(txtResult, Constants.DEFAULT_WAIT);
		appElementUtils.safeClick(btnNext, Constants.DEFAULT_WAIT);
	}

	public boolean isLoginScreenDisplayed() {
		return appElementUtils.doIsDisplayed(txtLoginHeader, Constants.DEFAULT_WAIT);
	}

	public boolean isInfoButtonDisplayed() {
		return appElementUtils.doIsDisplayed(btnInfo, Constants.DEFAULT_WAIT);
	}

	public boolean isRememberMeCheckboxDisplayed() {
		return appElementUtils.doIsDisplayed(checkboxRememberMe, Constants.DEFAULT_WAIT);
	}

	public boolean isRememberMeCheckboxSelected() {
		return appElementUtils.doIsSelected(checkboxRememberMe, Constants.DEFAULT_WAIT);
	}

	public void clickRememberMeCheckbox() {
		appElementUtils.safeClick(checkboxRememberMe, Constants.DEFAULT_WAIT);

	}

	public boolean isSwitchToOrganizationLinkDisplayed() {
		return appElementUtils.doIsDisplayed(lnkSwichToOrganizationPage, Constants.DEFAULT_WAIT);

	}

	public void clickSwitchToOrganizationPageLink() {
		appElementUtils.safeClick(lnkSwichToOrganizationPage, Constants.DEFAULT_WAIT);

	}

	public HomeScreen login(String username, String password) {
		appElementUtils.doSendKeysWithWait(txtboxBadgeNumber, username, Constants.DEFAULT_WAIT);
		appElementUtils.doSendKeysWithWait(txtboxPassword, password, Constants.DEFAULT_WAIT);
		appElementUtils.safeClick(btnLogin, Constants.DEFAULT_WAIT);
		return new HomeScreen(driver);
	}

	public boolean isLoginSuccessful() {
		return appElementUtils.doIsDisplayed(txtWelcome, Constants.DEFAULT_WAIT);
	}

}
