package com.dits.citywide.pages.admin;

import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class ApplicantTrackingSystemPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public ApplicantTrackingSystemPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

}
