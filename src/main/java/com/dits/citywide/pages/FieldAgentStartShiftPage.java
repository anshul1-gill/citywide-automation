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
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	public FieldAgentStartShiftPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void btnMarkAsRead() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.LONG_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtMessageOfTheWeek, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(btnMarkAsRead, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void viewShiftDetails(String day) {
		String dayxpath = "//div[contains(text(),'" + day + "')]/following-sibling::div";
		// elementUtils.waitForElementToBeClickable(By.xpath(dayxpath),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doClickWithActionsAndWait(By.xpath(dayxpath), Constants.DEFAULT_WAIT);
	}

}
