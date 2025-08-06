package com.dits.citywide.pages.patrol;

import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class VehicleInspectionPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public VehicleInspectionPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

}
