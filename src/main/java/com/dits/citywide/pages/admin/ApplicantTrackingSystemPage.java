package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ApplicantTrackingSystemPage {

    private WebDriver driver;
    private ElementUtils elementUtils;

    // ============================================================
    // ✅ Locators
    // ============================================================

    // 🔹 Tabs
    private By tabSettings = By.xpath("//a[normalize-space()='Settings']");
    private By tabJobPosting = By.xpath("//a[.//h4[normalize-space()='Job Postings']]");
    private By tabApplicants = By.xpath(".//h4[normalize-space()='Applicants']");
    private By tabInterview = By.xpath("//a[normalize-space()='Interview']");
    private By tabSendOffer = By.xpath("//a[normalize-space()='Send Offer']");
    private By tabRejected = By.xpath("//div[normalize-space()='Rejected/Blacklisted']");

    // ============================================================
    // 🔹 Settings Tab Locators
    // ============================================================
    private By btnAddnewform = By.xpath("//div[normalize-space()='Add new']");
    private By formNamefield = By.id("formName");
    private By formcheckbox = By.xpath("//label[@for='isEmployeeFields']");
    private By formSavebtn = By.xpath("//button[normalize-space()='Save Form']");

    private By tabSkilsAndQualifications = By.xpath("//div[normalize-space()='Skill/Qualification']");
    private By btnAddQualification = By.xpath("//button[@type='button' and contains(normalize-space(), 'Add Skill')]");
    private By txtQualificationName = By.xpath("//input[@id='name']");
    private By btnSaveQualification = By.xpath("//button[@type='submit' and normalize-space()='Save']");
    private By backbtnQualication  = By.xpath("//span[normalize-space()='Back']");  

    private By tabSourceType = By.xpath("//div[normalize-space()='Source Type']");
    private By btnAddSourceType = By.xpath("//button[normalize-space()='Add Source Type']");
    private By txtSourceTypeName = By.xpath("//input[@id='name']");
    private By btnSaveSourceType = By.xpath("//button[@type='submit' and normalize-space()='Save']");
    

    // ============================================================
    // 🔹 Job Post Form
    // ============================================================
    private By btnAddJob = By.xpath("//button[normalize-space()='Add New Job']");
    private By txtJobTitle = By.xpath("//input[@id='title']");
    private By dropdownDepartment = By.xpath("//input[@id='department']");
    private By dropdownBranches = By.xpath("//input[@id='location_id']");
    private By dropdownEmploymentType = By.id("employment_type");
    private By applicationenddate = By.xpath("//input[@id='application_end_date']");
    private By dropdownreqskills = By.xpath("//input[@id='required_skill']/ancestor::div[contains(@class,'ant-select')]");
    private By inputExplevel = By.id("experience");
    private By inputnumberopenings = By.xpath("//input[@id='number_opening']");
    private By inputsalaryrange = By.xpath("//input[@id='salary_range']");
    private By dropdownjobstatus = By.xpath("//input[@id='status']/ancestor::div[contains(@class,'ant-select')]");
    private By dropdownjobmode = By.xpath("//input[@id='job_mode']/ancestor::div[contains(@class,'ant-select')]");
    private By dropdownselectform = By.xpath("//input[@id='setting_form_id']/ancestor::div[contains(@class,'ant-select')]");
    private By txtJobDescription = By.xpath("//div[contains(@class,'public-DraftStyleDefault-block public-DraftStyleDefault-ltr')]");

    private By btnSaveJob = By.xpath("//button[normalize-space()='Save']");
    private By searchfield = By.xpath("//input[@placeholder='Search']");
    private By backbtnjOB  = By.xpath("//span[normalize-space()='Back']");
    // ============================================================
    // 🔹 Applicant Form
    // ============================================================
    private By btnAddApplicant = By.xpath("//span[normalize-space()='Add New Applicant']");
    private By txtApplicantFirstName = By.xpath("//input[@id='first_name']");
    private By txtApplicantLastName = By.xpath("//input[@id='last_name']");
    private By txtApplicantEmail = By.id("email");
    private By txtApplicantPhone = By.xpath("//input[@value='+1']");
    private By dropdownPositionApplied = By.xpath("//input[@id='position']/ancestor::div[contains(@class,'ant-select')]");
    private By dropdownSourceType = By.xpath("//input[@id='source_type']/ancestor::div[contains(@class,'ant-select')]");
    private By dropdownQualification = By.xpath("//input[@id='skill']/ancestor::div[contains(@class,'ant-select')]");
    private By inputCurrentemployee = By.xpath("//input[@id='current_employer']");
    private By inputcurrentrole = By.xpath("//input[@id='current_role']");
    private By dropdownStatus = By.xpath("//input[@id='status']/ancestor::div[contains(@class,'ant-select')]");
    private By fileUploadResume = By.xpath("//input[@type='file']");    
    private By btnSaveApplicant = By.xpath("//button[contains(normalize-space(),'Save')]");
    
    private By actionviewIcon = By.xpath("(//div[@class='actionicons viewIcon'])[1]");
    private By submitbtnapplicant = By.xpath("//button[normalize-space()='Submit']");
    private By btnokmodal = By.xpath("//button[@type='button' and normalize-space()='OK']");
    
    // ============================================================
    // 🔹 Interview Form

    // ============================================================
    private By btnscheduleinterview = By.xpath("//button[normalize-space()='Schedule Interview']");
    private By inputselectTimeslot = By.xpath("//span[@title='Select Time']");
    private By inputstarttime  = By.xpath("//input[@id='from_time']/ancestor::div[contains(@class,'ant-select')]//div[contains(@class,'ant-select-selector')]");
    private By selectInterviewmode = By.xpath("//input[@id='interview_mode']/ancestor::div[contains(@class,'ant-select')]//div[contains(@class,'ant-select-selector')]");
    private By InputOfflineAddress = By.xpath("//input[@id='offline_address']");
    private By inputinterviewersemail = By.xpath("//input[@id='interviewer_email']");
    private By interviewername = By.xpath("//input[@id='interviewer_name']");
    private By btnSubmitinterview = By.xpath("//button[@type='submit']"); //use thread sleep here of 5000
    
    private By radiobtncleared = By.xpath("//span[normalize-space()='Cleared']");
    private By Interviewnotes = By.xpath("//textarea[@placeholder='Type your notes here...']");
    private By btnUpdateStatus = By.xpath("//button[normalize-space()='Update Status']");
    private By btnsendoffer = By.xpath("//button[normalize-space()='Send offer']");
	private By dateOfferExpiryDate = By.xpath("//input[@id='offer_expire_date']");
	private By textSubject = By.xpath("//input[@id='subject']");
	private By textareanotesOffer = By.xpath("//div[@aria-label='rdw-editor' and @contenteditable='true']");	
	private By btnSubmit = By.xpath("//button[@type='submit' and normalize-space()='Submit']");
	private By Backbtn = By.xpath("//a[normalize-space()='Back']");



    // ============================================================
    // 🔹 Reject / Blacklist Form
    // ============================================================
    private By iconRejectCandidate = By.xpath("(//span[contains(@class,'anticon-right')])[1]");
    private By radiobtnRejectCandidate = By.xpath("//span[normalize-space()='Reject Applicant']");
    private By btnsubmit  = By.xpath("//button[normalize-space()='Submit']");
    private By radiobtnreject = By.xpath("//span[normalize-space()='Previously Denied']");
    private By rejectednotes = By.xpath("//textarea[@id='notes']");
    private By btnconfirmrejection = By.xpath("(//button[normalize-space()='Submit'])");
    
    private By btnBlacklistcandidate = By.xpath("//div[contains(@class,'ant-tabs-tabpane-active')]//tr[1]//span[contains(@class,'anticon-right')]");
    private By radiobtnblacklist = By.xpath("//span[normalize-space()='Blacklist Applicant']");
    private By radiobtnreasonblacklist = By.xpath("(//span[normalize-space()='Under Qualified'])[2]");
    private By blacklistednotes = By.xpath("(//textarea[@id='notes'])[2]");
    private By btnsubmitblacklist = By.xpath("(//button[normalize-space()='Submit'])[2]");
    
    private By radiobtnArchived = By.xpath("//span[normalize-space()='Archive Applicant']");
    private By btnsubmitArchive = By.xpath("(//span[normalize-space()='Submit'])[2]");
    private By btnconfirm = By.xpath("//button[normalize-space()='OK']");

    // ============================================================
    // ✅ Constructor
    // ============================================================
    public ApplicantTrackingSystemPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    // ============================================================
    // ✅ Settings Tab Actions
    // ==========================================================

    public void openSettingsTab(String Nameform) throws InterruptedException {
        elementUtils.waitForElementToBeClickable(tabSettings, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnAddnewform, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(formNamefield, Constants.DEFAULT_WAIT).sendKeys(Nameform);
        Thread.sleep(3000);
        elementUtils.waitForElementToBeClickable(formcheckbox, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(formSavebtn, Constants.DEFAULT_WAIT).click();
    }

    public void addSourceType(String sourceType) {
        elementUtils.waitForElementToBeClickable(tabSourceType, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnAddSourceType, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(txtSourceTypeName, Constants.DEFAULT_WAIT).sendKeys(sourceType);
        elementUtils.waitForElementToBeClickable(btnSaveSourceType, Constants.DEFAULT_WAIT).click();
    }

    public void addQualification(String qualification) {
        elementUtils.waitForElementToBeClickable(tabSkilsAndQualifications, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnAddQualification, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(txtQualificationName, Constants.DEFAULT_WAIT).sendKeys(qualification);
        elementUtils.waitForElementToBeClickable(backbtnQualication, Constants.DEFAULT_WAIT).click();
    }

    // ============================================================
    // ✅ Job Posting Actions
    // ============================================================
    public void openJobPostingTab() {
        elementUtils.waitForElementToBeClickable(tabJobPosting, Constants.DEFAULT_WAIT).click();
    }

    public void createJobPost(String title, String department, String branch, String employmentType,String endDate,
                              String reqSkill, String expLevel, String openings, String salaryRange,
                              String jobStatus, String jobMode, String form,  String jobDesc , String searchField) throws InterruptedException {

        elementUtils.waitForElementToBeClickable(btnAddJob, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(txtJobTitle, Constants.DEFAULT_WAIT).sendKeys(title);
        elementUtils.selectFromReactDropdown(dropdownDepartment, department);
        elementUtils.selectFromReactDropdown(dropdownBranches, branch);
        elementUtils.selectFromReactDropdown(dropdownEmploymentType, employmentType);

        WebElement endDateField = elementUtils.waitForElementVisible(applicationenddate, Constants.DEFAULT_WAIT);

     // 2️⃣ Set the value via JavaScript (bypassing calendar)
     String script = "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                     "nativeInputValueSetter.call(arguments[0], arguments[1]);" +
                     "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                     "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));";
     ((JavascriptExecutor) driver).executeScript(script, endDateField, endDate);

     // 3️⃣ Send TAB key to move focus to next field and close the calendar
     Actions actions = new Actions(driver);
     actions.moveToElement(endDateField)
            .sendKeys(Keys.TAB)
            .perform();
     
     	Thread.sleep(5000);
        elementUtils.selectReqSkillOption(dropdownreqskills, reqSkill);
        Thread.sleep(10000);        
        elementUtils.waitForElementVisible(inputExplevel, Constants.DEFAULT_WAIT).sendKeys(expLevel);
        elementUtils.waitForElementVisible(inputnumberopenings, Constants.DEFAULT_WAIT).sendKeys(openings);
        Thread.sleep(3000);
        elementUtils.waitForElementVisible(inputsalaryrange, Constants.DEFAULT_WAIT).sendKeys(salaryRange);
        Thread.sleep(1000);
        elementUtils.selectFromReactDropdown(dropdownjobstatus, jobStatus);
        Thread.sleep(1000);
        elementUtils.selectFromReactDropdown(dropdownjobmode, jobMode);
        elementUtils.selectFromReactDropdown(dropdownselectform, form);
        elementUtils.waitForElementVisible(txtJobDescription, Constants.DEFAULT_WAIT).sendKeys(jobDesc);
        elementUtils.waitForElementToBeClickable(btnSaveJob, Constants.DEFAULT_WAIT).click();
        
        Thread.sleep(5000);
        elementUtils.waitForElementVisible(searchfield, Constants.DEFAULT_WAIT).sendKeys(searchField);
        Thread.sleep(4000);
        elementUtils.waitForElementToBeClickable(backbtnjOB, Constants.DEFAULT_WAIT).click();
    }

    // ============================================================
    public void openApplicantsTab() {
        elementUtils.waitForElementToBeClickable(tabApplicants, Constants.DEFAULT_WAIT).click();
    }

    public void addApplicant(String fName, String lName, String email, String phone, String Positon , String Sourcetype , String skills
    		,String currentemployer, String currentrole , String Status ,  String resumePath) throws InterruptedException {
    	
        elementUtils.waitForElementToBeClickable(btnAddApplicant, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(txtApplicantFirstName, Constants.DEFAULT_WAIT).sendKeys(fName);
        elementUtils.waitForElementVisible(txtApplicantLastName, Constants.DEFAULT_WAIT).sendKeys(lName);
        elementUtils.waitForElementVisible(txtApplicantEmail, Constants.DEFAULT_WAIT).sendKeys(email);
        elementUtils.waitForElementVisible(txtApplicantPhone, Constants.DEFAULT_WAIT).sendKeys(phone);
        elementUtils.selectFromReactDropdown(dropdownPositionApplied, Positon);
        elementUtils.selectFromReactDropdown(dropdownSourceType, Sourcetype);
        elementUtils.selectFromReactDropdown(dropdownQualification, skills);
        elementUtils.waitForElementVisible(inputCurrentemployee, Constants.DEFAULT_WAIT).sendKeys(currentemployer);
        elementUtils.waitForElementVisible(inputcurrentrole, Constants.DEFAULT_WAIT).sendKeys(currentrole);
        elementUtils.selectFromReactDropdown(dropdownStatus, Status);
        elementUtils.uploadFile(fileUploadResume, resumePath);
        elementUtils.waitForElementToBeClickable(btnSaveApplicant, Constants.DEFAULT_WAIT).click();
        
        Thread.sleep(4000);
        elementUtils.waitForElementToBeClickable(actionviewIcon, Constants.DEFAULT_WAIT).click();
      
    }
    
    public void screenApplicant() {
		// Implementation for screening applicant can be added here
    	  elementUtils.waitForElementToBeClickable(submitbtnapplicant, Constants.DEFAULT_WAIT).click();
          elementUtils.waitForElementToBeClickable(btnokmodal, Constants.DEFAULT_WAIT).click();
    	
	}

    // ============================================================
    //  Interview Actions
    // ============================================================
    public void InterviewTab(String selecttime , String startTime , String Interviewmode  , String offlineAddress , String Interviewemail 
    		, String Interviewname ) throws InterruptedException {
    	 elementUtils.waitForElementToBeClickable(btnscheduleinterview, Constants.DEFAULT_WAIT).click();
    	 elementUtils.selectFromReactDropdown(inputselectTimeslot, selecttime);
    	 Thread.sleep(2000);
    	 elementUtils.selectFromReactDropdown(inputstarttime, startTime);
    	 elementUtils.selectFromReactDropdown(selectInterviewmode, Interviewmode);
    	 elementUtils.waitForElementVisible(InputOfflineAddress, Constants.DEFAULT_WAIT).sendKeys(offlineAddress);
    	 elementUtils.waitForElementVisible(inputinterviewersemail, Constants.DEFAULT_WAIT).sendKeys(Interviewemail);
    	 elementUtils.waitForElementVisible(interviewername, Constants.DEFAULT_WAIT).sendKeys(Interviewname);
    	 elementUtils.waitForElementToBeClickable(btnSubmitinterview, Constants.DEFAULT_WAIT).click();
    	 
    	 Thread.sleep(7000);
    	 elementUtils.waitForElementToBeClickable(radiobtncleared, Constants.DEFAULT_WAIT).click();
    	 elementUtils.waitForElementVisible(Interviewnotes, Constants.DEFAULT_WAIT).sendKeys(offlineAddress);
    	 elementUtils.waitForElementToBeClickable(btnUpdateStatus, Constants.DEFAULT_WAIT).click();
    	 Thread.sleep(2000);
    	
    }

    public void SendOfferTab() {
    	 elementUtils.waitForElementToBeClickable(btnsendoffer, Constants.DEFAULT_WAIT).click();
    }

    public void sendOffer( String expireDate, String Subject , String offernotes) throws InterruptedException {
        elementUtils.waitForElementVisible(dateOfferExpiryDate, Constants.DEFAULT_WAIT).sendKeys(expireDate);
        elementUtils.waitForElementVisible(textSubject, Constants.DEFAULT_WAIT).sendKeys(Subject);
        elementUtils.waitForElementVisible(textareanotesOffer, Constants.DEFAULT_WAIT).sendKeys(offernotes);
        elementUtils.waitForElementToBeClickable(btnSubmit, Constants.DEFAULT_WAIT).click();
        
        Thread.sleep(3000);
        elementUtils.waitForElementToBeClickable(Backbtn, Constants.DEFAULT_WAIT).click();
        
    }

    // ============================================================
    // ✅ Rejection Actions
    // ============================================================

    public void rejectCandidate( String reason) {
        elementUtils.waitForElementToBeClickable(iconRejectCandidate, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(radiobtnRejectCandidate, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(btnsubmit, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementToBeClickable(radiobtnreject, Constants.DEFAULT_WAIT).click();
        elementUtils.waitForElementVisible(rejectednotes, Constants.DEFAULT_WAIT).sendKeys(reason);
        elementUtils.waitForElementToBeClickable(btnconfirmrejection, Constants.DEFAULT_WAIT).click();
    }
    
    public void openRejectedTab(String blacklistnotes) throws InterruptedException {
    	elementUtils.safeClick(tabRejected);
    	Thread.sleep(3000);
        elementUtils.waitForElementToBeClickable(btnBlacklistcandidate, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(radiobtnblacklist, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(btnsubmitblacklist, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(radiobtnreasonblacklist, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementVisible(blacklistednotes, Constants.DEFAULT_WAIT).sendKeys(blacklistnotes);
        elementUtils.waitForElementToBeClickable(btnsubmitblacklist, Constants.DEFAULT_WAIT).click();
        Thread.sleep(5000);
    }
    
    public void ArchivedTab() throws InterruptedException {
    	elementUtils.waitForElementToBeClickable(btnBlacklistcandidate, Constants.DEFAULT_WAIT).click();
    	Thread.sleep(2000);
    	elementUtils.waitForElementToBeClickable(radiobtnArchived, Constants.DEFAULT_WAIT).click();
    	elementUtils.waitForElementToBeClickable(btnsubmitArchive, Constants.DEFAULT_WAIT).click();
    	elementUtils.waitForElementToBeClickable(btnconfirm, Constants.DEFAULT_WAIT).click();
    }

}
