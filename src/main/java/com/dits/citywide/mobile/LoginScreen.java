package com.dits.citywide.mobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginScreen {

	AppiumDriver driver;
	WebDriverWait wait;

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
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT));
	}

	public void searchAndProceed(String searchText) {
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(btnNext));
		nextButton.click();
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(txtboxSearch));
		searchBox.sendKeys(searchText);
		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(txtResult));
		result.click();
		WebElement next2Button = wait.until(ExpectedConditions.elementToBeClickable(btnNext));
		next2Button.click();
	}

	public boolean isLoginScreenDisplayed() {
		WebElement loginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(txtLoginHeader));
		return loginHeader.isDisplayed();
	}

	public boolean isInfoButtonDisplayed() {
		WebElement infoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnInfo));
		return infoButton.isDisplayed();
	}

	public boolean isRememberMeCheckboxDisplayed() {
		WebElement rememberMeCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxRememberMe));
		return rememberMeCheckbox.isDisplayed();
	}

	public boolean isRememberMeCheckboxSelected() {
		WebElement rememberMeCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxRememberMe));
		return rememberMeCheckbox.isSelected();
	}

	public void clickRememberMeCheckbox() {
		WebElement rememberMeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxRememberMe));
		rememberMeCheckbox.click();
	}

	public void clearRememberMeCheckbox() {
		WebElement rememberMeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxRememberMe));
		if (rememberMeCheckbox.isSelected()) {
			rememberMeCheckbox.click();
		}
	}

	public boolean isSwitchToOrganizationLinkDisplayed() {
		WebElement switchToOrgPageLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(lnkSwichToOrganizationPage));
		return switchToOrgPageLink.isDisplayed();
	}

	public void clickSwitchToOrganizationPageLink() {
		WebElement switchToOrgPageLink = wait
				.until(ExpectedConditions.elementToBeClickable(lnkSwichToOrganizationPage));
		switchToOrgPageLink.click();
	}

	public void login(String username, String password) {
		WebElement badgeNumberBox = wait.until(ExpectedConditions.visibilityOfElementLocated(txtboxBadgeNumber));
		badgeNumberBox.sendKeys(username);
		WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(txtboxPassword));
		passwordBox.sendKeys(password);
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		loginButton.click();
	}

	public boolean isLoginSuccessful() {
		WebElement welcomeText = wait.until(ExpectedConditions.visibilityOfElementLocated(txtWelcome));
		return welcomeText.isDisplayed();
	}

}
