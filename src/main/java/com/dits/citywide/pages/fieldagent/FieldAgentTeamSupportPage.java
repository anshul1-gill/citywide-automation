package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentTeamSupportPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddnewRequest = By.xpath("//button[@type='button']/span[text()='Add New Request']");
	private By dropdownboxSite = By.xpath("//input[@id='request_site']");
	private By dropdownboxSubject = By.xpath("//input[@id='form_id']");

	private By getSubjectDiv(String subject) {
		return By.xpath("(//div[normalize-space()='" + subject + "'])[2]");
	}

	private By txtboxMessage = By.xpath("//textarea[@id='request_message_text']");
	// Abuse template
	private By txtboxexplain = By.xpath("//input[@placeholder='Explain the incidence ']");
	private By txtboxbage = By.xpath("//input[@id='text_input_3F179234-6D87-4EEF-A4CF-A09BD76598F0']");
	private By datetimepicker = By.xpath("//input[@id='date_picker_3928A8F7-029B-4F73-BDC1-29BFDF7F93C2']");
	private By btnSave = By.xpath("//button[normalize-space()='Save']");

	private By tdTicketNo = By.xpath("(//td[@data-label='Ticket No.'])[1]");
	private By tdsiteName = By.xpath("(//td[@data-label='Site Name'])[1]");
	private By tdSubject = By.xpath("(//td[@data-label='Subject'])[1]");
	private By tdType = By.xpath("(//td[@data-label='Type'])[1]");
	private By tdRaisedBy = By.xpath("(//td[@data-label='Raised By'])[1]");
	private By tdRespondedBy = By.xpath("(//td[@data-label='Responded By'])[1]");
	private By tdCreatedat = By.xpath("(//td[@data-label='Created At'])[1]");
	private By tdUpdatedat = By.xpath("(//td[@data-label='Updated At'])[1]");
	private By tdStatus = By.xpath("(//td[@data-label='Status'])[1]");
	private By tdAction = By.xpath("(//td[@data-label='Action'])[1]");

	public FieldAgentTeamSupportPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickOnAddNewRequestButton() {
		elementUtils.waitForElementToBeClickable(btnAddnewRequest, Constants.DEFAULT_WAIT).click();
	}

	public void fillOutAndSubmitAbuseRequestForm(String site, String subject, String message)
			throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownboxSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(dropdownboxSite, Constants.DEFAULT_WAIT).sendKeys(site);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(dropdownboxSubject, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getSubjectDiv(subject), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxMessage, Constants.DEFAULT_WAIT).sendKeys(message);
	}

	public void fillAbuseRequestForm(String explain, String bage, String date) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxexplain, Constants.DEFAULT_WAIT).sendKeys(explain);
		elementUtils.waitForElementVisible(txtboxbage, Constants.DEFAULT_WAIT).sendKeys(bage);
		elementUtils.waitForElementVisible(datetimepicker, Constants.DEFAULT_WAIT).sendKeys(date);
	}

	public void clickOnSaveButton() {
		elementUtils.waitForElementToBeClickable(btnSave, Constants.DEFAULT_WAIT).click();
	}

}
