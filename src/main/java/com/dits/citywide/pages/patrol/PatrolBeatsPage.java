package com.dits.citywide.pages.patrol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class PatrolBeatsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnViewSites = By.xpath("//span[normalize-space()='View Sites']");
	private By dataBeats = By.xpath("//td[@data-label='Beats']/a");
	private By dataNumberOfSites = By.xpath("//td[@data-label='Number of Sites']");
	private By dataSwiftType = By.xpath("//td[@data-label='Shift Type']");
	private By btnCheckOut = By.xpath("//span[normalize-space()='Check Out']");
	private By btnView = By.xpath("//span[normalize-space()='View']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By btnCancel = By.xpath("//button[normalize-space()='Cancel']");

	// View Sites
	private By totalCountOfSites = By.xpath("//div[@class='sites-value agent-name c-flex c-gap-3']");

	// View Beat

	public PatrolBeatsPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void clickOnViewSites() {
		elementUtils.waitForElementToBeClickable(btnViewSites, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnViewBeat() {
		elementUtils.waitForElementToBeClickable(btnView, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnCheckOut() {
		elementUtils.waitForElementToBeClickable(btnCheckOut, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getBeatName() {
		return elementUtils.waitForElementVisible(dataBeats, Constants.DEFAULT_WAIT).getText();
	}

	public String getNumberOfSites() {
		return elementUtils.waitForElementVisible(dataNumberOfSites, Constants.DEFAULT_WAIT).getText();
	}

	public String getSwiftType() {
		return elementUtils.waitForElementVisible(dataSwiftType, Constants.DEFAULT_WAIT).getText();
	}

	public String getTotalCountOfSites() {
		List<WebElement> ele = elementUtils.waitsForElementsVisible(totalCountOfSites, Constants.DEFAULT_WAIT);
		ele.forEach(site -> System.out.println("Site: " + site.getText()));
		return String.valueOf(ele.size());
	}

	public void clickOnCancel() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.DEFAULT_WAIT).click();
	}

}
