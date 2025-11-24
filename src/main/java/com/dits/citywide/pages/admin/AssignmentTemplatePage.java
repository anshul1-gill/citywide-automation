package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class AssignmentTemplatePage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // -------------------------------
    // Locators
    // -------------------------------
    private By assignmentTemplateHeader = By.xpath("//h4[normalize-space()='Assignment Templates']");
    private By btnAddNewtemplate = By.xpath("//a[normalize-space()='Add New Template']");
    private By txtTemplateName = By.xpath("//div[label[normalize-space()='Template name']]//input[@type='text']");

    private By dropdownActivityCode = By.xpath("(//label[normalize-space(text())='Activity Code']/ancestor::div[contains(@class,'relative')]//input[@data-te-select-input-ref])[1]");
    private By dropdownBranch = By.xpath("(//label[normalize-space(text())='Select Branch']/ancestor::div[contains(@class,'relative')]//input[@data-te-select-input-ref])[2]");
    private By dropdownQuestionType = By.xpath("(//label[normalize-space(text())='Question Type']/ancestor::div[contains(@class,'relative')]//input[@data-te-select-input-ref])[3]");

    private By txtQuestion = By.xpath("//textarea[@id='question']");
    private By ckEditorDescription = By.xpath("//div[contains(@class,'ck-editor__editable') and @contenteditable='true']");
    private By btnSaveQuestion = By.xpath("//button[normalize-space()='Save Questions']");
    private By btnAddNewQuestion = By.xpath("//button[normalize-space()='Add New Question']");
    private By btnBack = By.xpath("//a[normalize-space()='Back']");
    
    private By inputSearchTemplate = By.xpath("//input[@placeholder='Search']");


    // -------------------------------
    // Constructor
    // -------------------------------
    public AssignmentTemplatePage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    // -------------------------------
    // Actions
    // -------------------------------

    public boolean isAssignmentTemplateHeaderVisible() {
        return elementUtils.doIsDisplayed(assignmentTemplateHeader, Constants.DEFAULT_WAIT);
    }

    public void enterTemplateName(String templateName) {
    	 elementUtils.waitForElementToBeClickable(btnAddNewtemplate, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(txtTemplateName, Constants.DEFAULT_WAIT).sendKeys(templateName);
    }

    public void selectActivityCode(String activityCodeOption) {
        elementUtils.selectFromDropdown("Activity Code", activityCodeOption);
    }

//    public void selectBranch(String branchOption) {
//        elementUtils.selectFromDropdown("Select Branch", branchOption);
//    }

    public void selectQuestionType(String questionTypeOption) {
        elementUtils.selectFromDropdown("Question Type", questionTypeOption);
    }

    public void enterQuestion(String questionText) {
        elementUtils.waitForElementToBeClickable(txtQuestion, Constants.DEFAULT_WAIT).sendKeys(questionText);
    }

    public void enterDescription(String descriptionText) {
        elementUtils.waitForElementToBeClickable(ckEditorDescription, Constants.DEFAULT_WAIT).sendKeys(descriptionText);
    }

    public void clickAddNewQuestion() {
        elementUtils.waitForElementToBeClickable(btnAddNewQuestion, Constants.DEFAULT_WAIT).click();
    }

    public void clickSaveQuestion() {
        elementUtils.waitForElementToBeClickable(btnSaveQuestion, Constants.DEFAULT_WAIT).click();
    }
    public void clickBackbtn() {
        elementUtils.waitForElementToBeClickable(btnBack, Constants.DEFAULT_WAIT).click();
    }
    
    public void searchAssignmentTemplate(String templateName) {
        elementUtils.waitForElementVisible(inputSearchTemplate, Constants.DEFAULT_WAIT).clear();
        elementUtils.doActionsSendKeys(inputSearchTemplate, templateName);
        elementUtils.pressEnterKey();

        // Wait for the searched template to appear in the table
        elementUtils.waitForElementVisible(
            By.xpath("//td[normalize-space()='" + templateName + "']"),
            Constants.SHORT_TIME_OUT_WAIT
        );
    }
    
    public void clickEditTemplateButton(String templateName) {
        // Step 1: Search template
        searchAssignmentTemplate(templateName);

        // Step 2: Click Edit icon/button beside the searched template
        String xpath = "//td[normalize-space()='" + templateName + "']/following-sibling::td//a[@title='Add']";
        elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.SHORT_TIME_OUT_WAIT).click();
    }
    
 // For update mode (no "Add New Template" click)
    public void updateTemplateName(String templateName) {
        elementUtils.waitForElementVisible(txtTemplateName, Constants.DEFAULT_WAIT);
        elementUtils.clearTextBoxWithActions(txtTemplateName);
        elementUtils.doActionsSendKeys(txtTemplateName, templateName);
    }
    
    
    /** Delete an Assignment Template by name */
    public void deleteAssignmentTemplate(String templateName) {
        // Step 1: Search for the specific template
        searchAssignmentTemplate(templateName);

        // Step 2: Click on the delete icon/button
        String deleteXpath = "//td[normalize-space()='" + templateName + "']/following-sibling::td//button[@title='Delete']";
        elementUtils.waitForElementToBeClickable(By.xpath(deleteXpath), Constants.SHORT_TIME_OUT_WAIT).click();

        // Step 3: Confirm deletion
        By confirmDeleteBtn = By.xpath("//button[normalize-space()='OK']");
        elementUtils.waitForElementToBeClickable(confirmDeleteBtn, Constants.SHORT_TIME_OUT_WAIT).click();

        // Step 4: Wait for delete success message (if available)
//        By successMessage = By.xpath("//div[contains(text(),'deleted successfully')]");
//        elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT);
    }




    // -------------------------------
    // Composite Actions
    // -------------------------------
    public void createNewAssignmentTemplate(String templateName, String activityCode,  String questionType, String question, String description) throws InterruptedException {
        enterTemplateName(templateName);
        selectActivityCode(activityCode);
//        selectBranch(branch);
        selectQuestionType(questionType);
        enterQuestion(question);
        enterDescription(description);
        clickSaveQuestion();
        Thread.sleep(3000);
        clickBackbtn();
    }
    
    public void updateAssignmentTemplate(String activityCode, String questionType, String question, String description) {
        selectActivityCode(activityCode);
        selectQuestionType(questionType);
        enterQuestion(question);
        enterDescription(description);
        clickAddNewQuestion();
        clickBackbtn();
    }

}
