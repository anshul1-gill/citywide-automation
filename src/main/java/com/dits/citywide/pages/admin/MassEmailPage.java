package com.dits.citywide.pages.admin;

import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class MassEmailPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public MassEmailPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

}
