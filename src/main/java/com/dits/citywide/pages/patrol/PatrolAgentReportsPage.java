package com.dits.citywide.pages.patrol;

import java.util.List;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class PatrolAgentReportsPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // No Pre-Flight locators here
    private By btnAddNewReport = By.xpath("//a[contains(text(),'Add New Report')]");
    private By btnSubmitReports = By.xpath("//span[normalize-space()='Submit Reports']");
    private By txtNoItemsFound = By
            .xpath("//span[@class='px-2 py-8 text-base font-medium text-center text-gray-400 dark:text-white']");
    private By btnEndShift = By.xpath("//button[normalize-space()='End Shift']");
    private By endShiftConfirmationMessage = By.xpath("//div[@id='swal2-html-container']");
    private By btnOk = By.xpath("//button[normalize-space()='OK']");
    private List<By> btnReOpenPatrolLog = Arrays.asList(By.xpath("//button[normalize-space()='Re-Open Patrol Log']"),
            By.xpath("//button[normalize-space()='Re-open Patrol Log']"));
    private By txtNoDataFound = By.xpath("//td[normalize-space()='No Data Found']");
    private By txtCloseOutFieldAgentLog = By.xpath("//h2[normalize-space()='Close Out Field Agent Log']");
    private By checkboxShiftIsEnd = By.cssSelector("label[for='equip_ok-3']");
    private By btnEndShiftFinal = By.xpath("(//button[text()='End Shift'])[1]");

    // My Reports
    private By txtUpdateOfficerReportEntry = By.xpath("//h1[normalize-space()='Update Officer Report Entry']");
    private By btnEditReport2 = By.xpath("(//div[@class='actionicons editPencil'])[3]");
    private By btnEditReport3 = By.xpath("(//div[@class='actionicons editPencil'])[5]");
    private By btnEditReport4 = By.xpath("(//div[@class='actionicons editPencil'])[5]");
    private By btnEditReport5 = By.xpath("(//div[@class='actionicons editPencil'])[7]");
    private By btnEditReport6 = By.xpath("(//div[@class='actionicons editPencil'])[9]");
    private By btnEditReport7 = By.xpath("(//div[@class='actionicons editPencil'])[11]");
    private By btnEditReport8 = By.xpath("(//div[@class='actionicons editPencil'])[13]");
    private By btnEditReport9 = By.xpath("(//div[@class='actionicons editPencil'])[15]");

    private By dropdownPatrolSite = By.xpath("(//div[@class='ant-select-selector'])[1]");
    private By patrolSite = By.cssSelector("#patrol_site_id");
    private By dropdownActivityCode = By.xpath("(//div[@class='ant-select-selector'])[2]");
    private By searchboxActivityCode = By.cssSelector("#activity_code");
    private By dropdowncallId = By.xpath("(//div[@class='ant-select-selector'])[3]");
    private By callId = By.cssSelector("#call_id");
    private By clockArriveNow = By.xpath("(//span[@aria-label='clock-circle'])[1]");
    private By txtboxStreetNumber = By.xpath("//input[@id='street_num']");
    private By txtboxStreetName = By.xpath("//input[@id='street_name']");
    private By txtboxApartmentNumber = By.xpath("//input[@id='apartment']");
    private By txtboxCity = By.xpath("//input[@id='city']");
    private By txtboxStreetSate = By.xpath("//input[@id='state']");
    private By txtboxzipcode = By.xpath("//input[@id='zipcode']");
    private By txtboxDescription = By.xpath("//textarea[@id='activity_text']");
    private By txtHeadingReportPhotoVideoUpload = By.xpath("//h4[normalize-space()='Report Photo/Video Upload']");
    private By uploadFile = By.xpath("//input[@type='file']");
    private By uploadFileMyAssignment = By.xpath("(//input[@type='file'])[2]");
    private By btnUpdateLogEntry = By.cssSelector("button[type='submit'] span");
    private By txtboxImageName = By.cssSelector("#Name0");
    private By txtboxImageDescription = By.cssSelector("#Description0");

    // Start shift data
    private By dataArriveDateTime = By
            .xpath("//p[normalize-space()='SS']/ancestor::td/preceding-sibling::td[@data-label='Arrive']/p");
    private By dataSiteName = By
            .xpath("//p[normalize-space()='SS']/ancestor::td/preceding-sibling::td[@data-label='Site']//div");
    private By dataDepartDateTime = By
            .xpath("//p[normalize-space()='SS']/ancestor::td/preceding-sibling::td[@data-label='Depart']/p");

    private By btnAllReports = By.cssSelector("#rc-tabs-0-tab-all-reports");
    private By txtboxSearch = By.xpath("//input[@placeholder='Search']");
    private By dropdownColumn = By.xpath("//div[@class='ant-dropdown-trigger']");
    private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
    private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

    // Columns button and Activity Code checkbox (for All Reports table)
    private By btnColumns = By.xpath("//button[contains(.,'Columns')]");
    // Make the XPath more robust: allow for possible whitespace and not requiring
    // label as direct parent
    private By selectActivityCode = By.xpath("//span[contains(text(),'Activity Code')]");

    public PatrolAgentReportsPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    public void clickSubmitReports() {
        elementUtils.waitForElementToBeClickable(btnSubmitReports, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
    }

    public boolean isNoItemsFoundVisible() {
        return elementUtils.doIsDisplayed(txtNoItemsFound, Constants.DEFAULT_WAIT);
    }

    public void clickEndShift() {
        isNoItemsFoundVisible();
        elementUtils.waitForElementToBeClickable(btnEndShift, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
        isCloseOutFieldAgentLogVisible();
        elementUtils.waitForElementToBeClickable(checkboxShiftIsEnd, Constants.SHORT_TIME_OUT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnEndShiftFinal, Constants.SHORT_TIME_OUT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
    }

    public void clickOkButton() {
        elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
    }

    public String getNoDataFoundText() {
        return elementUtils.waitForElementVisible(txtNoDataFound, Constants.DEFAULT_WAIT).getText();
    }

    public boolean isReOpenPatrolLogVisible() {
        for (By locator : btnReOpenPatrolLog) {
            if (elementUtils.doIsDisplayed(locator, Constants.SHORT_TIME_OUT_WAIT)) {
                return true;
            }
        }
        return false;
    }

    public String getEndShiftConfirmationMessage() {
        return elementUtils.waitForElementVisible(endShiftConfirmationMessage, Constants.DEFAULT_WAIT).getText();
    }

    public boolean isCloseOutFieldAgentLogVisible() {
        return elementUtils.doIsDisplayed(txtCloseOutFieldAgentLog, Constants.DEFAULT_WAIT);
    }

    // My Reports
    public String getArriveDateTime() {
        return elementUtils.waitForElementVisible(dataArriveDateTime, Constants.DEFAULT_WAIT).getText();
    }

    public String getSiteName() {
        java.util.List<WebElement> elements = driver.findElements(dataSiteName);
        if (elements.isEmpty()) {
            throw new RuntimeException("No site name elements found for locator: " + dataSiteName.toString());
        }
        return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
    }

    public String getDepartDateTime() {
        return elementUtils.waitForElementVisible(dataDepartDateTime, Constants.DEFAULT_WAIT).getText();
    }

    public boolean isUpdateOfficerReportEntryVisible() {
        return elementUtils.doIsDisplayed(txtUpdateOfficerReportEntry, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport2() {
        elementUtils.jsClickWithWait(btnEditReport2, Constants.SHORT_TIME_OUT_WAIT);
    }

    public void clickEditReport3() {
        elementUtils.jsClickWithWait(btnEditReport3, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport4() {
        elementUtils.jsClickWithWait(btnEditReport4, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport5() {
        elementUtils.jsClickWithWait(btnEditReport5, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport6() {
        elementUtils.jsClickWithWait(btnEditReport6, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport7() {
        elementUtils.jsClickWithWait(btnEditReport7, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport8() {
        elementUtils.jsClickWithWait(btnEditReport8, Constants.DEFAULT_WAIT);
    }

    public void clickEditReport9() {
        elementUtils.jsClickWithWait(btnEditReport9, Constants.DEFAULT_WAIT);
    }

    public void addOfficerReportEntry(String url, String site, String activityCode, String callId, String streetNumber,
            String streetName, String apartmentNumber, String city, String state, String zipCode, String description,
            String photoVideoLink, String fileName, String fileDescription) {
        elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
        // Simulate filling out the report form
        elementUtils.waitForElementToBeClickable(clockArriveNow, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(dropdownPatrolSite, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(patrolSite, Constants.SHORT_TIME_OUT_WAIT).sendKeys(site);
        elementUtils.pressEnterKey();
        elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(searchboxActivityCode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(activityCode);
        elementUtils.pressEnterKey();
        elementUtils.waitForElementToBeClickable(dropdowncallId, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(this.callId, Constants.SHORT_TIME_OUT_WAIT).sendKeys(callId);
        elementUtils.pressEnterKey();
        elementUtils.waitForElementVisible(txtboxStreetNumber, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetNumber);
        elementUtils.waitForElementVisible(txtboxStreetName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetName);
        elementUtils.waitForElementVisible(txtboxApartmentNumber, Constants.SHORT_TIME_OUT_WAIT)
                .sendKeys(apartmentNumber);
        elementUtils.waitForElementVisible(txtboxCity, Constants.SHORT_TIME_OUT_WAIT).sendKeys(city);
        elementUtils.waitForElementVisible(txtboxStreetSate, Constants.SHORT_TIME_OUT_WAIT).sendKeys(state);
        elementUtils.waitForElementVisible(txtboxzipcode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(zipCode);
        elementUtils.waitForElementVisible(txtboxDescription, Constants.SHORT_TIME_OUT_WAIT).sendKeys(description);
        // Optionally handle file upload if required by your UI
        // elementUtils.uploadFile(uploadFile, photoVideoLink);
        // elementUtils.waitForElementVisible(txtboxImageName,
        // Constants.DEFAULT_WAIT).sendKeys(fileName);
        // elementUtils.waitForElementVisible(txtboxImageDescription,
        // Constants.DEFAULT_WAIT).sendKeys(fileDescription);
    }

    public boolean isAllReportsButtonVisible() {
        return elementUtils.doIsDisplayed(btnAllReports, Constants.DEFAULT_WAIT);
    }

    public void clickUpdateLogEntry() {
        elementUtils.waitForElementToBeClickable(btnUpdateLogEntry, Constants.DEFAULT_WAIT).click();
    }

    public void clickAllReports() {
        elementUtils.waitForElementToBeClickable(btnAllReports, Constants.DEFAULT_WAIT).click();
    }

    public void enterTextInSearchBox(String text) {
        WebElement searchBox = elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT);
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickDropdownColumn() {
        elementUtils.waitForElementToBeClickable(dropdownColumn, Constants.DEFAULT_WAIT).click();
    }

    public void selectActivityCode() {
        By selectActivityCode = By.xpath("//span[contains(text(),'Activity Code')]");
        elementUtils.waitForElementToBeClickable(selectActivityCode, Constants.DEFAULT_WAIT).click();
    }

    public String getOfficerNameDataStartOfShift() {
        By getOfficerNameDataStartOfShift = By.xpath("(//td[@data-label='Officer'])[1]");
        return elementUtils.waitForElementVisible(getOfficerNameDataStartOfShift, Constants.DEFAULT_WAIT).getText();
    }

    public String getArriveDataStartOfShift() {
        By getArriveDataStartOfShift = By.xpath("(//td[@data-label='Arrive'])[1]");
        return elementUtils.waitForElementVisible(getArriveDataStartOfShift, Constants.DEFAULT_WAIT).getText();
    }

    public String getActivityCodeDataStartOfShift() {
        By getActivityCodeDataStartOfShift = By.xpath("(//td[@data-label='Activity Code'])[1]");
        return elementUtils.waitForElementVisible(getActivityCodeDataStartOfShift, Constants.DEFAULT_WAIT).getText();
    }

    public enum TableDataState {
        DATA_PRESENT,
        NO_DATA
    }

    /**
     * Waits for either the first data row or the 'No Data Found' message to appear.
     * Returns which one appeared first.
     */
    public TableDataState waitForTableDataOrNoData(int timeoutSeconds) {
        By firstRowOfficer = By.xpath("(//td[@data-label='Officer'])[1]");
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;
        while (System.currentTimeMillis() < end) {
            try {
                if (driver.findElements(firstRowOfficer).size() > 0 &&
                        driver.findElements(firstRowOfficer).get(0).isDisplayed()) {
                    return TableDataState.DATA_PRESENT;
                }
            } catch (Exception ignored) {
            }
            try {
                if (driver.findElements(txtNoDataFound).size() > 0 &&
                        driver.findElements(txtNoDataFound).get(0).isDisplayed()) {
                    return TableDataState.NO_DATA;
                }
            } catch (Exception ignored) {
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
        // Timeout: neither appeared
        throw new RuntimeException("Neither table data nor 'No Data Found' message appeared within timeout");
    }

    /**
     * Checks if the first row contains a cell with the given data-label.
     */
    public boolean isCellPresent(String dataLabel) {
        By cellLocator = By.xpath("(//td[@data-label='" + dataLabel + "'])[1]");
        try {
            return driver.findElements(cellLocator).size() > 0 && driver.findElements(cellLocator).get(0).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Logs the table headers (th elements) of the All Reports table for debugging.
     */
    public void logTableHeaders() {
        try {
            java.util.List<org.openqa.selenium.WebElement> headers = driver.findElements(By.xpath("//table//th"));
            StringBuilder sb = new StringBuilder("Table headers: ");
            for (org.openqa.selenium.WebElement th : headers) {
                sb.append("[").append(th.getText()).append("] ");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println("Could not log table headers: " + e.getMessage());
        }
    }

    /**
     * Clicks the Columns button to open the columns selection menu.
     * Takes a screenshot after clicking for debugging.
     */
    public void clickColumnsButton() {
        WebElement columnsBtn = elementUtils.waitForElementToBeClickable(btnColumns, 10);
        columnsBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        // Take screenshot for debugging
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("columns_menu_debug.png"));
        } catch (Exception e) {
            System.out.println("Could not take screenshot: " + e.getMessage());
        }
    }

    /**
     * Selects the Activity Code checkbox in the columns menu if not already
     * selected.
     */
    public void selectActivityCodeColumn() {

        elementUtils.waitForElementToBeClickable(selectActivityCode, Constants.DEFAULT_WAIT).click();

    }

    /**
     * Checks if the Activity Code column is visible in the reports table.
     */
    public boolean isActivityCodeColumnVisible() {
        List<WebElement> headers = driver.findElements(By.xpath("//th[contains(.,'Activity Code')]"));
        return !headers.isEmpty();
    }
}
