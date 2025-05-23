package com.dits.citywide.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentStartShiftPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtMessageOfTheWeek = By.xpath(
			"//div[@class='flex items-center justify-between px-3 py-2 text-white rounded-t-lg bg-blue2 dark:bg-blue2']/h2");
	private By btnMarkAsRead = By.xpath("//div[@class='flex items-center gap-3']/button");
	private By tabStartShift = By.xpath("(//span[contains(text(),'Start Shift')])[1]");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By btnViewSite = By.xpath("//div[@class='ant-flex css-yw7p3q']/a");
	private By dataSite = By.xpath("//label[contains(text(),'Site')]/following-sibling::p");
	private By dataSchedule = By.xpath("//label[contains(text(),'Schedule')]/following-sibling::p");
	private By dataServiceType = By.xpath("//label[contains(text(),'Service Type')]/following-sibling::p");
	private By dataAddress = By.xpath("//label[contains(text(),'Address')]/following-sibling::p");
	private By dataNotes = By.xpath("//label[contains(text(),'Notes')]/following-sibling::p");
	private By btnStartShift = By.xpath("(//span[contains(text(),'Start Shift')])[2]");
	private By btnEndShift = By.xpath("//span[contains(text(),'End Shift')]");


	// Start Shift Page
	private By nameFieldAgentWithWelcome = By.xpath("//h3[contains(@class,'text-primary')]");
	private By txtWelcomeDescription = By
			.xpath("//p[contains(@class, 'font-normal') and contains(@class, 'text-bas')]");
	private By btnStartShiftBegin = By.xpath("//button[contains(text(),'Start Shift')]");

	public FieldAgentStartShiftPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

//	public void btnMarkAsRead() {
//		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.LONG_TIME_OUT_WAIT);
//		elementUtils.waitForElementVisible(txtMessageOfTheWeek, Constants.DEFAULT_WAIT);
//		elementUtils.waitForElementVisible(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT).click();
//	}

	public void btnMarkAsRead() {
		try {
			elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.LONG_TIME_OUT_WAIT);

			if (elementUtils.doIsDisplayed(txtMessageOfTheWeek, Constants.SHORT_TIME_OUT_WAIT)
					&& elementUtils.doIsDisplayed(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT)) {

				elementUtils.waitForElementVisible(txtMessageOfTheWeek, Constants.DEFAULT_WAIT);
				elementUtils.waitForElementVisible(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT).click();
				System.out.println("Clicked on 'Mark As Read' button.");
			} else {
				System.out.println("'Mark As Read' message or button not visible, skipping click.");
			}
		} catch (Exception e) {
			System.out.println("Exception while trying to click 'Mark As Read': " + e.getMessage());
		}
	}

	public void doClickTabStartShift() {
		elementUtils.waitForElementToBeClickable(tabStartShift, Constants.DEFAULT_WAIT).click();
	}

	public void viewShiftDetails(String day) {
		String dayxpath = "//div[contains(text(),'" + day + "')]/following-sibling::div";
		// elementUtils.waitForElementToBeClickable(By.xpath(dayxpath),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doClickWithActionsAndWait(By.xpath(dayxpath), Constants.DEFAULT_WAIT);
	}

	public String getSite() {
		return elementUtils.waitForElementVisible(dataSite, Constants.DEFAULT_WAIT).getText();
	}

	public boolean getSchedule() {
		return elementUtils.doIsDisplayed(dataSchedule, Constants.DEFAULT_WAIT);
	}

	public boolean getServiceType() {
		return elementUtils.doIsDisplayed(dataServiceType, Constants.DEFAULT_WAIT);
	}

	public boolean getAddress() {
		return elementUtils.doIsDisplayed(dataAddress, Constants.DEFAULT_WAIT);
	}

	public String getNotes() {
		return elementUtils.waitForElementVisible(dataNotes, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickViewSite() {
		elementUtils.waitForElementToBeClickable(btnViewSite, Constants.DEFAULT_WAIT).click();
	}

	public void doClickStartShift() {
		elementUtils.waitForElementToBeClickable(btnStartShift, Constants.DEFAULT_WAIT).click();
	}

	public boolean isStartShiftButtonVisible() {
		return elementUtils.doIsDisplayed(btnStartShift, Constants.DEFAULT_WAIT);
	}

	public void doClickEndShift() {
		elementUtils.waitForElementToBeClickable(btnEndShift, Constants.DEFAULT_WAIT).click();
	}

	// Start Shift Page
	public String getFieldAgentNameWithWelcome() {
		return elementUtils.waitForElementVisible(nameFieldAgentWithWelcome, Constants.DEFAULT_WAIT).getText();
	}

	public String getWelcomeDescriptionText() {
		return elementUtils.waitForElementVisible(txtWelcomeDescription, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickStartShiftBegin() {
		elementUtils.waitForElementToBeClickable(btnStartShiftBegin, Constants.DEFAULT_WAIT).click();
	}

}
