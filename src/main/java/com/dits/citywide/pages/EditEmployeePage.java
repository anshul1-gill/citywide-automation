package com.dits.citywide.pages;

import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class EditEmployeePage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	
	

	public EditEmployeePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

}
