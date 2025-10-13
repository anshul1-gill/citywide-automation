package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentMyAttendancePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By dataBranchName = By.xpath("(//td[@data-label='Branch Name'])[1]");
	private By dataSiteOrBeat = By.xpath("(//td[@data-label='Site/Beat'])[1]");
	private By dataShiftStart = By.xpath("(//td[@data-label='Shift Start'])[1]");
	private By dataCheckIn = By.xpath("(//td[@data-label='Check In'])[1]//span");
	private By dataShiftEnd = By.xpath("(//td[@data-label='Shift End'])[1]");
	private By dataCheckOut = By.xpath("(//td[@data-label='Check Out'])[1]//span");
	private By dataShiftHours = By.xpath("(//td[@data-label='Shift Hours'])[1]");
	private By dataBreakDuration = By.xpath("(//td[@data-label='Break Duration (HH:MM)'])[1]/div");
	private By dataActualBreak = By.xpath("(//td[@data-label='Actual Break (HH:MM)'])[1]");
	private By dataTotalHours = By.xpath("(//td[@data-label='Total Hours'])[1]");
	private By dataStatus = By.xpath("(//td[@data-label='Status'])[1]/div");

	public FieldAgentMyAttendancePage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public String getDataBranchName() {
		return elementUtils.getText(dataBranchName, Constants.DEFAULT_WAIT);
	}

	public String getDataSiteOrBeat() {
		return elementUtils.getText(dataSiteOrBeat, Constants.DEFAULT_WAIT);
	}

	public String getDataShiftStart() {
		return elementUtils.getText(dataShiftStart, Constants.DEFAULT_WAIT);
	}

	public String getDataCheckIn() {
		return elementUtils.getText(dataCheckIn, Constants.DEFAULT_WAIT);
	}

	public String getDataShiftEnd() {
		return elementUtils.getText(dataShiftEnd, Constants.DEFAULT_WAIT);
	}

	public String getDataCheckOut() {
		return elementUtils.getText(dataCheckOut, Constants.DEFAULT_WAIT);
	}

	public String getDataShiftHours() {
		return elementUtils.getText(dataShiftHours, Constants.DEFAULT_WAIT);
	}

	public String getDataBreakDuration() {
		return elementUtils.getText(dataBreakDuration, Constants.DEFAULT_WAIT);
	}

	public String getDataActualBreak() {
		return elementUtils.getText(dataActualBreak, Constants.DEFAULT_WAIT);
	}

	public String getDataTotalHours() {
		return elementUtils.getText(dataTotalHours, Constants.DEFAULT_WAIT);
	}

	public String getDataStatus() {
		return elementUtils.getText(dataStatus, Constants.DEFAULT_WAIT);
	}

}
