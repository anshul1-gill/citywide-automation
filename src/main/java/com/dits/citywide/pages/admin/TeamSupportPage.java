package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class TeamSupportPage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	private By btnFilter = By.cssSelector("//span[normalize-space()='Filters']");
	private By dropdownMyRequests = By.xpath("(//div[@class='ant-select-selector'])[1]");

	private By getRequestOption(String optionText) {
		return By.xpath(
				String.format("//div[@class='ant-select-item-option-content' and normalize-space()='%s']", optionText));
	}

	private By searchBox = By.cssSelector("input[placeholder='Search']");

	public TeamSupportPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	private By getTicketNumberCell(String ticketNumber) {
		return By.xpath("//td[@data-label='Ticket No.']//a[normalize-space()='" + ticketNumber + "']");
	}

	/**
	 * Returns a dynamic XPath locator for a cell in the ticket table based on
	 * ticket number and column name.
	 * 
	 * @param ticketNumber The ticket number to search for.
	 * @param columnName   The column name (e.g., 'Site Name', 'Subject', etc.)
	 * @return By locator for the cell.
	 */
	private By getCellByTicketAndColumn(String ticketNumber, String columnName) {
		return By.xpath("//tr[td[@data-label='Ticket No.']//a[normalize-space()='" + ticketNumber
				+ "']]//td[@data-label='" + columnName + "']");
	}

	private By getViewButtonByTicketNumber(String ticketNumber) {
		return By.xpath("//tr[td[@data-label='Ticket No.']//a[normalize-space()='" + ticketNumber
				+ "']]//div[contains(@class,'viewIcon')]");
	}

	private By getUpdateButtonByTicketNumber(String ticketNumber) {
		return By.xpath("//tr[td[@data-label='Ticket No.']//a[normalize-space()='" + ticketNumber
				+ "']]//div[contains(@class,'editPencil')]");
	}

	private By ticketNoValue = By.xpath("//div[contains(@class,'ticket-no')]//h3[contains(text(),'Ticket No')]/span");
	private By dropdownStatus = By.className("ant-select-selector");

	private By getStatusOption(String status) {
		return By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + status + "']");
	}

	private By dataCurrentStatus = By.xpath(
			"//div[@class='invoice-detail current-status c-mb-3']/strong[contains(text(),'Current Status')]/following-sibling::span");
	private By dataTo = By
			.xpath("//div[@class='invoice-detail']/strong[contains(text(),'To')]/following-sibling::span");
	private By dataCC = By
			.xpath("//div[@class='invoice-detail']/strong[contains(text(),'CC')]/following-sibling::span");
	private By dataSubject = By
			.xpath("//div[@class='invoice-detail']/strong[contains(text(),'Subject')]/following-sibling::text()");
	private By dataMessage = By
			.xpath("//div[@class='invoice-detail']/strong[contains(text(),'Site Name')]/following-sibling::text()");

}