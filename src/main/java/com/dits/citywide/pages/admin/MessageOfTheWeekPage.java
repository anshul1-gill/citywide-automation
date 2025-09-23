package com.dits.citywide.pages.admin;

import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class MessageOfTheWeekPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public MessageOfTheWeekPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

}
