package com.dits.citywide.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class EmployeesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNewEmployee = By.xpath("//span[text()='Add New Employee']");
	private By txtNoDataFound = By.xpath("//div[contains(text(),'No Data Found')]");

	private By dropdownStatus = By.xpath("(//span[@class='ant-select-selection-wrap'])[3]");
	private By txtboxSearch = By.cssSelector("input[placeholder='Search']");
	private By searchDropdownValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
//	private By employeeID = By.xpath("//td[text()='808']");

	private By dataEmployeeID = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Employee ID']");
	private By dataFirstName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='First Name']");
	private By dataLastName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Last Name']");
	private By dataBranchName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Branch Name']");
	private By dataPhoneNumberPrimary = By
			.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Phone Number (Primary)']");
	private By dataRoles = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Role(s)']");

	private By btnViewEmployee = By.cssSelector(".actionicons.viewIcon");
	private By btnEditEmployee = By.cssSelector("div[aria-describedby=':r30:']");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	private By permissionError = By
			.xpath("//h3[contains(text(),'You may not have the correct permissions to view the page.')]");

	public EmployeesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isAddNewEmployeeButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnAddNewEmployee, Constants.DEFAULT_WAIT);
	}

	public boolean isAddNewEmployeeButtonClickable() {
		return elementUtils.doIsClickable(btnAddNewEmployee, Constants.SHORT_TIME_OUT_WAIT);
	}

	public AddEmployeePage doClickAddNewEmployee() {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoDataFound, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddNewEmployee, Constants.DEFAULT_WAIT).click();
		return new AddEmployeePage(driver);
	}

	public void selectStatus() {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoDataFound, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownStatus, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(searchDropdownValues, "All", Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public void searchInTextbox(String searchText) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

//		String xpath = "//td[text()='" + searchText + "']";
//		elementUtils.waitForElementVisible(By.xpath(xpath), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(txtboxSearch, Constants.SHORT_TIME_OUT_WAIT).sendKeys(searchText);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getEmployeeIdData() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataEmployeeID, Constants.DEFAULT_WAIT).getText();
	}

	public String getFirstNameData() {
		return elementUtils.waitForElementVisible(dataFirstName, Constants.DEFAULT_WAIT).getText();
	}

	public String getLastNameData() {
		return elementUtils.waitForElementVisible(dataLastName, Constants.DEFAULT_WAIT).getText();
	}

	public String getBranchNameData() {
		return elementUtils.waitForElementVisible(dataBranchName, Constants.DEFAULT_WAIT).getText();
	}

	public String getPrimaryPhoneNumberData() {
		return elementUtils.waitForElementVisible(dataPhoneNumberPrimary, Constants.DEFAULT_WAIT).getText();
	}

	public String getRolesData() {
		return elementUtils.waitForElementVisible(dataRoles, Constants.DEFAULT_WAIT).getText();
	}

	public ViewEmployeePage doClickViewEmployee() {
		elementUtils.waitForElementVisible(btnViewEmployee, Constants.DEFAULT_WAIT);
		elementUtils.clickElementWithScroll(btnViewEmployee, Constants.SHORT_TIME_OUT_WAIT);
		return new ViewEmployeePage(driver);
	}

	public EditEmployeePage doClickEditEmployee() {
		elementUtils.waitForElementVisible(btnEditEmployee, Constants.DEFAULT_WAIT);
		elementUtils.clickElementWithScroll(btnEditEmployee, Constants.SHORT_TIME_OUT_WAIT);
		return new EditEmployeePage(driver);
	}

}
