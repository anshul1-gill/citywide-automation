package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentIncidentReportsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNewIncidentReport = By.xpath("//a[normalize-space()='Add New Incident']");

	public FieldAgentIncidentReportsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

}
