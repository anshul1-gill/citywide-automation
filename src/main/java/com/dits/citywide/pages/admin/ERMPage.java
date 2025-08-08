package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ERMPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAnalitics = By.xpath("//h4[normalize-space()='Analytics']");
	private By btnRemarksHistory = By.xpath("//h4[normalize-space()='Remarks History']");
	private By btnSettings = By.xpath("//h4[normalize-space()='Settings']");

	public ERMPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public ERMSettingsPage clickSettings() {
		elementUtils.waitForElementToBeClickable(btnSettings, Constants.DEFAULT_WAIT).click();
		return new ERMSettingsPage(driver);
	}

}
