package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.dits.citywide.constants.Constants;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.utilities.ElementUtils;

public class RankAndPositionPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // ==============================
    // Constructor
    // ==============================
    public RankAndPositionPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    // ==============================
    // Locators
    // ==============================
    private By txtHeadingRank = By.xpath("//h4[normalize-space()='Rank/Position']");
    private By btnAddNewRank = By.xpath("//a[normalize-space()='Add New Rank']");
    
    private By txtRankName = By.xpath("//input[@id='rank_name']");
    private By txtOrder = By.xpath("//input[@id='rank_order']");
    
    private By dropdownBranch = By.xpath("(//label[normalize-space()='Select Branch']/ancestor::div[contains(@class,'relative')]//input[@data-te-select-input-ref])[1]");
    private By dropdownBranchOptions = By.xpath("//div[@data-te-select-option-ref]//span[@data-te-select-option-text-ref]");
    
    private By btnclickblank = By.xpath("//div[contains(@class,'justify-end')]");
    		
    private By btnSubmitAddRank = By.xpath("//button[@type='submit' and normalize-space()='Add New Rank']");
    private By btnUpdateRank = By.xpath("//button[@type='submit'and normalize-space()='Update Rank']");
    private By btnOkDeleteRank = By.xpath("//button[normalize-space()='OK']");

    private By txtAddSuccessMessage = By.xpath("//span[normalize-space()='Rank Created Successfully.']");
    private By txtUpdateSuccessMessage = By.xpath("//h2[contains(text(),'Information Updated Successfully')]/following-sibling::span");
    private By txtDeleteSuccessMessage = By.xpath("//div[contains(text(),'Rank deleted successfully')]");
    
    private By inputSearchRank = By.xpath("//input[@placeholder='Search']");


    // ==============================
    // Page Validation
    // ==============================
    public boolean isRankPageVisible() {
        return elementUtils.doIsDisplayed(txtHeadingRank, Constants.DEFAULT_WAIT);
    }

    public boolean isAddNewRankButtonVisible() {
        return elementUtils.doIsDisplayed(btnAddNewRank, Constants.DEFAULT_WAIT);
    }

    // ==============================
    // CRUD Methods
    // ==============================

    /** Click Add New Rank Button */
    public void clickAddNewRankButton() {
        elementUtils.waitForElementToBeClickable(btnAddNewRank, Constants.DEFAULT_WAIT).click();
    }

    /** Fill Add Rank Form — Supports Multi-Select Branches */
    public void fillAddNewRankForm(String rankName, String order, String... branches) throws InterruptedException {
        elementUtils.waitForElementVisible(txtRankName, Constants.DEFAULT_WAIT).sendKeys(rankName);
        elementUtils.waitForElementVisible(txtOrder, Constants.DEFAULT_WAIT).sendKeys(order);

        // Open dropdown
        elementUtils.waitForElementVisible(dropdownBranch, Constants.DEFAULT_WAIT).click();

        // Select each branch from constants or data
        for (String branch : branches) {
            String branchXpath = "//div[@data-te-select-option-ref]//span[@data-te-select-option-text-ref and normalize-space()='" + branch + "']";
            elementUtils.waitForElementToBeClickable(By.xpath(branchXpath), Constants.SHORT_TIME_OUT_WAIT).click();
        }
    }
    
    public void clickBlankArea() {
        elementUtils.waitForElementToBeClickable(btnclickblank, Constants.DEFAULT_WAIT).click();
    }


    /** Click Submit Button */
    public void clickSubmitAddRankButton() {
        elementUtils.waitForElementToBeClickable(btnSubmitAddRank, Constants.DEFAULT_WAIT).click();
    }
    
    /** 
     * Search for a Rank by name before performing Edit or Delete 
     */
    public void searchRank(String rankName) {
        elementUtils.waitForElementVisible(inputSearchRank, Constants.DEFAULT_WAIT).clear();
        elementUtils.doActionsSendKeys(inputSearchRank, rankName);
        elementUtils.pressEnterKey();

        // Wait until the searched rank appears in the table
        elementUtils.waitForElementVisible(
            By.xpath("//td[normalize-space()='" + rankName + "']"),
            Constants.SHORT_TIME_OUT_WAIT
        );
    }


    /** Edit Rank Record */
    /** Edit Rank Record */
    public void clickEditRankButton(String rankName) {
        // Step 1: Search the rank in the table
        searchRank(rankName);

        // Step 2: Click Edit button for the searched rank
        String xpath = "//td[normalize-space()='" + rankName + "']/following-sibling::td//button[@title='Edit Rank']";
        elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.SHORT_TIME_OUT_WAIT).click();
    }

    /** Update Rank Form — Supports Multi-Select Branches */
    public void updateRank(String rankName, String order, String... branches) throws InterruptedException {
        elementUtils.waitForElementVisible(txtRankName, Constants.DEFAULT_WAIT);
        elementUtils.clearTextBoxWithActions(txtRankName);
        elementUtils.doActionsSendKeys(txtRankName, rankName);

        elementUtils.waitForElementVisible(txtOrder, Constants.DEFAULT_WAIT);
        elementUtils.clearTextBoxWithActions(txtOrder);
        elementUtils.doActionsSendKeys(txtOrder, order);

    }

    /** Click Update Button */
    public void clickUpdateRankButton() {
        elementUtils.waitForElementToBeClickable(btnUpdateRank, Constants.DEFAULT_WAIT).click();
    }

    /** Delete Rank */
    public void clickDeleteRankButton(String rankName) {
        String xpath = "//td[normalize-space()='" + rankName + "']/following-sibling::td//button[@title='Delete Rank']";
        elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.SHORT_TIME_OUT_WAIT).click();
    }

    /** Confirm Delete */
    public void clickConfirmDeleteButton() {
        elementUtils.waitForElementToBeClickable(btnOkDeleteRank, Constants.DEFAULT_WAIT).click();
    }

    // ==============================
    // Toast Messages
    // ==============================
    public String getAddSuccessMessage() {
        return elementUtils.waitForElementVisible(txtAddSuccessMessage, Constants.DEFAULT_WAIT).getText();
    }

    public String getUpdateSuccessMessage() {
        return elementUtils.waitForElementVisible(txtUpdateSuccessMessage, Constants.DEFAULT_WAIT).getText();
    }

    public String getDeleteSuccessMessage() {
        return elementUtils.waitForElementVisible(txtDeleteSuccessMessage, Constants.DEFAULT_WAIT).getText();
    }
}
