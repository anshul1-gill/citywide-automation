package com.dits.citywide.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.pages.fieldagent.FieldAgentStartShiftPage;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;
import com.dits.citywide.utilities.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By imgCompanyLogoHeader = By.xpath("(//img)[1]");
	private By imgCompanyLogoBody = By.xpath("(//img)[2]");

	private By txtBadgeOrEmail = By.xpath("//div[@id='email-login']/label");
	private By txtPassword = By.xpath("//div[@class='mb-4 relative']/label");

	private By txtboxEmail = By.id("email");
	private By txtboxPassword = By.id("password");
	private By btnSignIn = By.xpath("//button[@type='submit']");

	private By txtEmailValidationErrorMessage = By
			.xpath("//span[contains(text(),\"Please enter your Badge# or Email Address.\")]");
	private By txtPasswordValidationErrorMessage = By
			.xpath("//span[contains(text(),\"The password field is required.\")]");
	private By txtInvalidEmailAndPasswordValidationErrorMessage = By
			.xpath("//span[contains(text(),\"These credentials do not match our records.\")]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isCompanyLogoHeaderDisplayed() {
		return elementUtils.doIsDisplayed(imgCompanyLogoHeader, Constants.DEFAULT_WAIT);
	}

	public boolean isCompanyLogoBodyDisplayed() {
		return elementUtils.doIsDisplayed(imgCompanyLogoBody, Constants.DEFAULT_WAIT);
	}

	public boolean isBadgeOrEmailTextDisplayed() {
		return elementUtils.doIsEnabled(txtBadgeOrEmail, Constants.DEFAULT_WAIT);
	}

	public boolean isPasswordTextDisplayed() {
		return elementUtils.doIsEnabled(txtPassword, Constants.DEFAULT_WAIT);
	}

	public boolean isImageNotBroken(By imageLocator) {
		WebElement imgElement = elementUtils.getElement(imageLocator);
		Boolean isImageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && "
				+ "typeof arguments[0].naturalWidth != 'undefined' && " + "arguments[0].naturalWidth > 0", imgElement);
		return isImageLoaded;
	}

	public boolean isCompanyLogoHeaderNotBroken() {
		return isImageNotBroken(imgCompanyLogoHeader);
	}

	public boolean isCompanyLogoBodyNotBroken() {
		return isImageNotBroken(imgCompanyLogoBody);
	}

	public DashboardPage doLogin(String email, String password) {
		elementUtils.waitForElementVisible(txtboxEmail, Constants.DEFAULT_WAIT).sendKeys(email);
		elementUtils.waitForElementVisible(txtboxPassword, Constants.DEFAULT_WAIT).sendKeys(password);
		elementUtils.waitForElementToBeClickable(btnSignIn, Constants.DEFAULT_WAIT).click();
		return new DashboardPage(driver);
	}

	public String getEmailValidationErrorMessageText() {
		return elementUtils.waitForElementVisible(txtEmailValidationErrorMessage, Constants.SHORT_TIME_OUT_WAIT)
				.getText();
	}

	public String getPasswordValidationErrorMessageText() {
		return elementUtils.waitForElementVisible(txtPasswordValidationErrorMessage, Constants.SHORT_TIME_OUT_WAIT)
				.getText();
	}

	public String getInvalidEmailPasswordErrorMessageText() {
		return elementUtils.getText(txtInvalidEmailAndPasswordValidationErrorMessage, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void verifyLoginValidationErrorMessage(String email, String password) throws InterruptedException {

		elementUtils.doSendKeysWithClear(txtboxEmail, email);
		elementUtils.doSendKeysWithClear(txtboxPassword, password);
		elementUtils.jsClick(btnSignIn);
		
		Thread.sleep(2000);
	}

	public List<String> getAllErrorMessages() {

		List<String> errorMessages = new ArrayList<String>();

		if (isElementVisible(txtEmailValidationErrorMessage)) {
			errorMessages.add(getEmailValidationErrorMessageText().trim());
		}

		if (isElementVisible(txtPasswordValidationErrorMessage)) {
			errorMessages.add(getPasswordValidationErrorMessageText().trim());
		}

		if (isElementVisible(txtInvalidEmailAndPasswordValidationErrorMessage)) {
			errorMessages.add(getInvalidEmailPasswordErrorMessageText().trim());
		}

		return errorMessages;
	}

	private boolean isElementVisible(By locator) {
		try {
			return elementUtils.doIsDisplayed(locator, Constants.SHORT_TIME_OUT_WAIT);
		} catch (Exception e) {
			return false;
		}
	}
	
	// 
	
	public FieldAgentStartShiftPage doLoginFieldAgent(String email, String password) {
		elementUtils.waitForElementVisible(txtboxEmail, Constants.DEFAULT_WAIT).sendKeys(email);
		elementUtils.waitForElementVisible(txtboxPassword, Constants.DEFAULT_WAIT).sendKeys(password);
		elementUtils.waitForElementToBeClickable(btnSignIn, Constants.DEFAULT_WAIT).click();
		return new FieldAgentStartShiftPage(driver);
	}
	
	public PatrolStartShiftPage doLoginPatrol(String email, String password) {
		elementUtils.waitForElementVisible(txtboxEmail, Constants.DEFAULT_WAIT).sendKeys(email);
		elementUtils.waitForElementVisible(txtboxPassword, Constants.DEFAULT_WAIT).sendKeys(password);
		elementUtils.waitForElementToBeClickable(btnSignIn, Constants.DEFAULT_WAIT).click();
		return new PatrolStartShiftPage(driver);
	}


}
