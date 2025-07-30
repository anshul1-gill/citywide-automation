package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class BeatsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingBeats = By.xpath("//h1[normalize-space()='Beats']");
	private By btnAddNewBeats = By.xpath("//span[normalize-space()='Add New Beat']");

	private By txtboxBeatID = By.xpath("//input[@id='beat_id']");
	private By txtboxBeatName = By.xpath("//input[@id='beat_description']");
	private By dropdownShiftType = By.xpath("(//span[@class='ant-select-selection-search'])[1]");
	private By selectShiftTypeValue = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By dropdwonNumberOfSites = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By searchNumberOfSites = By.xpath("//span[normalize-space()='Number of Sites']");

	private By btnSubmitAddBeat = By.xpath("//button[contains(@type,'submit')]");

	private By dataBitId = By.xpath("(//td[@data-label='Beat ID'])[1]");
	private By dataShiftType = By.xpath("(//td[@data-label='Shift Type'])[1]");
	private By btnViewSite = By.xpath("(//span[contains(text(),'View Sites')])[1]");
	private By dataSiteName = By.xpath("//a[@class='sites-value agent-name']");

	private By btnUpdateBeat = By.xpath("//button[@type='submit']");
	private By btnOkDeleteBreak = By.xpath("//button[normalize-space()='OK']");
	private By txtDeleteSuccessMessage = By.xpath("//div[contains(text(),'Beat deleted successfully')]");

	public BeatsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	public boolean isBeatsPageVisible() {
		return elementUtils.doIsDisplayed(txtHeadingBeats, Constants.DEFAULT_WAIT);
	}

	public boolean isAddNewBeatsButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddNewBeats, Constants.DEFAULT_WAIT);
	}

	public void clickAddNewBeatsButton() {
		elementUtils.waitForElementToBeClickable(btnAddNewBeats, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddNewBeatsForm(String beatID, String beatName, String shiftType, String numberOfSites)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxBeatID, Constants.DEFAULT_WAIT).sendKeys(beatID);
		elementUtils.waitForElementVisible(txtboxBeatName, Constants.DEFAULT_WAIT).sendKeys(beatName);
		elementUtils.waitForElementVisible(dropdownShiftType, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(selectShiftTypeValue, shiftType, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActionsAndWait(dropdwonNumberOfSites, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(searchNumberOfSites, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchNumberOfSites, numberOfSites);
		Thread.sleep(3000);
		elementUtils.pressEnterKey();
		Thread.sleep(2000);
	}

	public void clickSubmitAddBeatButton() {
		elementUtils.waitForElementToBeClickable(btnSubmitAddBeat, Constants.DEFAULT_WAIT).click();
	}

	public String getDataBeatId() {
		return elementUtils.waitForElementVisible(dataBitId, Constants.DEFAULT_WAIT).getText();
	}

	public String getDataShiftType() {
		return elementUtils.waitForElementVisible(dataShiftType, Constants.DEFAULT_WAIT).getText();
	}

	public void clickViewSiteButton() {
		elementUtils.waitForElementToBeClickable(btnViewSite, Constants.DEFAULT_WAIT).click();
	}

	public String getDataSiteName() {
		return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
	}

	// Update methods can be added here for editing and deleting beats as needed

	public void clickEditBeatButton(String siteId) {
		String siteid = siteId;
		String editxpath = "//td[contains(normalize-space(), '" + siteid
				+ "')]/following-sibling::td//div[@class='actionicons editPencil']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickDeleteBeatButton(String siteId) {
		String siteid = siteId;
		String editxpath = "//td[contains(normalize-space(), '" + siteid
				+ "')]/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void updateBeat(String beatID, String beatName, String shiftType, String numberOfSites)
			throws InterruptedException {

		elementUtils.waitForElementVisible(txtboxBeatID, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxBeatID);
		elementUtils.doActionsSendKeys(txtboxBeatID, beatID);

		elementUtils.waitForElementVisible(txtboxBeatName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxBeatName);
		elementUtils.doActionsSendKeys(txtboxBeatName, beatName);

		elementUtils.doClickWithActionsAndWait(dropdownShiftType, Constants.DEFAULT_WAIT);
		elementUtils.selectElementThroughLocator(selectShiftTypeValue, shiftType, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.doClickWithActionsAndWait(dropdwonNumberOfSites, Constants.DEFAULT_WAIT);
		Thread.sleep(1000);
		elementUtils.clearTextBoxWithActions(searchNumberOfSites);
		elementUtils.pressDeleteKey();
		elementUtils.waitForElementVisible(searchNumberOfSites, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchNumberOfSites, numberOfSites);
		Thread.sleep(1000);
		elementUtils.pressEnterKey();
	}

	public void clickUpdateBeatButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateBeat, Constants.DEFAULT_WAIT).click();
	}

	public void clickOkDeleteBreakButton() {
		elementUtils.waitForElementToBeClickable(btnOkDeleteBreak, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public String getDeleteSuccessMessage() {
		return elementUtils.waitForElementVisible(txtDeleteSuccessMessage, Constants.DEFAULT_WAIT).getText();
	}
	

}
