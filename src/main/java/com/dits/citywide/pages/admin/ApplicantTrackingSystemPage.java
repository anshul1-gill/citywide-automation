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
    private By checkboxPrescreeningQuestions = By.xpath("//span[normalize-space()='Pre-Screening Questions']");
    private By screeningquestion1 = By.xpath("//input[@name='dq_question_0']");
    private By scrrenAnswer1 = By.xpath("//span[@class='ant-radio-label' and normalize-space()='Yes']");
    private By Addsectionbutton = By.xpath("//button[@title='Add section']");
    private By screeningquestion2 = By.xpath("//input[@name='dq_question_1']");
    private By scrrenAnswer2 = By.xpath("(//span[@class='ant-radio-label' and normalize-space()='No'])[2]");

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

    // =======================ATS Through the Link=====================================
    
    private By applyjob = By.xpath("(//span[normalize-space()='Apply'])[1]");
    private By firstName  = By.xpath("//input[@id='first_name']");
    private By lastName  = By.xpath("//input[@id='last_name']");
    private By Birthdate  = By.xpath("//input[@id='birthdate']");
    private By email  = By.xpath("//input[@id='email']");
    private By Alternateemail = By.xpath("//input[@id='email_address_alternate']");
    private By primaryphone  = By.xpath("(//input[@type='tel'])[1]");
    private By alternatephone  = By.xpath("(//input[@type='tel'])[2]");
    private By emergencyName = By.xpath("//input[@id='emergency_contact_name']");
    private By emergencyNumber = By.xpath("(//input[@type='tel'])[3]");
    private By emergencyRelation = By.xpath("//input[@id='emergency_contact_relationship']");
    private By uploadResume = By.xpath("//input[@type='file']");
    
    //Residence Address 
    private By residenceStreet = By.xpath("//input[@id='residence_street_address_1']");
    private By residenceStreetname = By.xpath("//input[@id='residence_street_address_2']");
    private By residenceStno = By.xpath("//input[@id='residence_address']");
    private By residencezipcode = By.xpath("//input[@id='residence_zip_code']");
    
    private By sameasabove = By.xpath("(//span[normalize-space()='Same as above'])[1]");
    
    //Driver license 
    private By driverState= By.xpath("//input[@id='state_driver_license']");
    private By driverLicenseNumber = By.xpath("//input[@id='permit_number_driver_license']");
    private By dateofIssue = By.xpath("//input[@id='date_of_issue_driver_license']");
    private By dateofExpiry = By.xpath("//input[@id='date_of_expiry_driver_license']");
    
    private By applyjobform = By.xpath("//button[@type='submit']");
    
  
    
    //===========================================================
    
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
        elementUtils.waitForElementToBeClickable(btnSaveQualification, Constants.DEFAULT_WAIT).click();
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
                              String jobStatus, String jobMode, String form,  String jobDesc , String searchField,
                              String question1, String question2) throws InterruptedException {

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
        WebElement reqSkillInput = elementUtils.waitForElementVisible(By.xpath("//input[@id='required_skill']"), Constants.DEFAULT_WAIT);
        reqSkillInput.click();
        Thread.sleep(1000);
        reqSkillInput.sendKeys(reqSkill);
        Thread.sleep(2000);
        reqSkillInput.sendKeys(Keys.ENTER);
        Thread.sleep(3000);        
        elementUtils.waitForElementVisible(inputExplevel, Constants.DEFAULT_WAIT).sendKeys(expLevel);
        elementUtils.waitForElementVisible(inputnumberopenings, Constants.DEFAULT_WAIT).sendKeys(openings);
        Thread.sleep(3000);
        elementUtils.waitForElementVisible(inputsalaryrange, Constants.DEFAULT_WAIT).sendKeys(salaryRange);
        Thread.sleep(1000);
        elementUtils.selectFromReactDropdown(dropdownjobstatus, jobStatus);
        Thread.sleep(2000);
        elementUtils.selectFromReactDropdown(dropdownjobmode, jobMode);
        Thread.sleep(2000);
        elementUtils.selectFromReactDropdown(dropdownselectform, form);
        elementUtils.waitForElementVisible(txtJobDescription, Constants.DEFAULT_WAIT).sendKeys(jobDesc);

        // Pre-Screening Questions
        addPreScreeningQuestions(question1, question2);

        elementUtils.waitForElementToBeClickable(btnSaveJob, Constants.DEFAULT_WAIT).click();
        
        Thread.sleep(5000);
        elementUtils.waitForElementVisible(searchfield, Constants.DEFAULT_WAIT).sendKeys(searchField);
        Thread.sleep(4000);
        elementUtils.waitForElementToBeClickable(backbtnjOB, Constants.DEFAULT_WAIT).click();
    }

    public void addPreScreeningQuestions(String question1Text, String question2Text) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Enable Pre-Screening Questions checkbox
        System.out.println("📝 Enabling Pre-Screening Questions...");
        WebElement prescreenCheckbox = elementUtils.waitForElementToBeClickable(checkboxPrescreeningQuestions, Constants.DEFAULT_WAIT);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", prescreenCheckbox);
        Thread.sleep(500);
        prescreenCheckbox.click();
        Thread.sleep(1000);

        // Fill Question 1
        System.out.println("📝 Adding Question 1: " + question1Text);
        elementUtils.waitForElementVisible(screeningquestion1, Constants.DEFAULT_WAIT).sendKeys(question1Text);
        Thread.sleep(500);
        elementUtils.waitForElementToBeClickable(scrrenAnswer1, Constants.DEFAULT_WAIT).click();
        Thread.sleep(500);
        System.out.println("✅ Question 1 added with answer: Yes");

        // Click Add Section to add second question
        System.out.println("📝 Adding new section for Question 2...");
        elementUtils.waitForElementToBeClickable(Addsectionbutton, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);

        // Fill Question 2
        System.out.println("📝 Adding Question 2: " + question2Text);
        elementUtils.waitForElementVisible(screeningquestion2, Constants.DEFAULT_WAIT).sendKeys(question2Text);
        Thread.sleep(500);
        elementUtils.waitForElementToBeClickable(scrrenAnswer2, Constants.DEFAULT_WAIT).click();
        Thread.sleep(500);
        System.out.println("✅ Question 2 added with answer: No");
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
        WebElement skillInput = elementUtils.waitForElementVisible(By.xpath("//input[@id='skill']"), Constants.DEFAULT_WAIT);
        skillInput.click();
        Thread.sleep(1000);
        skillInput.sendKeys(skills);
        Thread.sleep(2000);
        skillInput.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
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

    // ============================================================
    // ✅ ATS Through Public Link Actions
    // ============================================================

    public boolean verifyJobPostingsVisible(WebDriver driver, String publicLink) throws InterruptedException {
        driver.get(publicLink);
        Thread.sleep(5000);
        try {
            WebElement heading = elementUtils.waitForElementVisible(
                    By.xpath("//h2[contains(text(),'Current Openings')] | //h1[contains(text(),'Current Openings')]"),
                    Constants.DEFAULT_WAIT);
            return heading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickApplyOnFirstJob() throws InterruptedException {
        elementUtils.waitForElementToBeClickable(applyjob, Constants.DEFAULT_WAIT).click();
        Thread.sleep(3000);
    }

    public void applyThroughLink(String fName, String lName, String birthdate, String emailAddr,
                                  String altEmail, String phone, String altPhone,
                                  String emergName, String emergPhone, String emergRelation,
                                  String street, String streetName, String stNo, String zipCode,
                                  String dlState, String dlNumber, String dlIssueDate, String dlExpiryDate,
                                  String resumePath) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Personal Information
        System.out.println("📝 Filling Personal Information...");
        elementUtils.waitForElementVisible(firstName, Constants.DEFAULT_WAIT).sendKeys(fName);
        elementUtils.waitForElementVisible(lastName, Constants.DEFAULT_WAIT).sendKeys(lName);
        elementUtils.waitForElementVisible(Birthdate, Constants.DEFAULT_WAIT).sendKeys(birthdate);
        elementUtils.waitForElementVisible(email, Constants.DEFAULT_WAIT).sendKeys(emailAddr);
        elementUtils.waitForElementVisible(Alternateemail, Constants.DEFAULT_WAIT).sendKeys(altEmail);
        elementUtils.waitForElementVisible(primaryphone, Constants.DEFAULT_WAIT).sendKeys(phone);
        elementUtils.waitForElementVisible(alternatephone, Constants.DEFAULT_WAIT).sendKeys(altPhone);
        System.out.println("✅ Personal Information filled.");

        // Scroll down to Emergency Contact section
        js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(1000);

        // Emergency Contact
        System.out.println("📝 Filling Emergency Contact...");
        elementUtils.waitForElementVisible(emergencyName, Constants.DEFAULT_WAIT).sendKeys(emergName);
        elementUtils.waitForElementVisible(emergencyNumber, Constants.DEFAULT_WAIT).sendKeys(emergPhone);
        elementUtils.waitForElementVisible(emergencyRelation, Constants.DEFAULT_WAIT).sendKeys(emergRelation);
        System.out.println("✅ Emergency Contact filled.");

        // Scroll down to Residence Address section
        js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(1000);

        // Residence Address
        System.out.println("📝 Filling Residence Address...");
        elementUtils.waitForElementVisible(residenceStreet, Constants.DEFAULT_WAIT).sendKeys(street);
        elementUtils.waitForElementVisible(residenceStreetname, Constants.DEFAULT_WAIT).sendKeys(streetName);
        elementUtils.waitForElementVisible(residenceStno, Constants.DEFAULT_WAIT).sendKeys(stNo);
        elementUtils.waitForElementVisible(residencezipcode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
        System.out.println("✅ Residence Address filled.");

        // Scroll down and click "Same as above" checkbox
        js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(1000);
        try {
            System.out.println("📝 Clicking 'Same as above' checkbox...");
            WebElement checkbox = elementUtils.waitForElementToBeClickable(sameasabove, Constants.DEFAULT_WAIT);
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkbox);
            Thread.sleep(500);
            checkbox.click();
            System.out.println("✅ 'Same as above' checkbox clicked.");
        } catch (Exception e) {
            System.out.println("⚠️ 'Same as above' checkbox not found or not clickable: " + e.getMessage());
        }
        Thread.sleep(1000);

        // Driver License
        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(1000);
        System.out.println("📝 Filling Driver License...");
        elementUtils.waitForElementVisible(driverState, Constants.DEFAULT_WAIT).sendKeys(dlState);
        elementUtils.waitForElementVisible(driverLicenseNumber, Constants.DEFAULT_WAIT).sendKeys(dlNumber);
        elementUtils.waitForElementVisible(dateofIssue, Constants.DEFAULT_WAIT).sendKeys(dlIssueDate);
        elementUtils.waitForElementVisible(dateofExpiry, Constants.DEFAULT_WAIT).sendKeys(dlExpiryDate);
        System.out.println("✅ Driver License filled.");

        // Scroll down to Resume Upload
        js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(1000);

        // Resume Upload
        System.out.println("📝 Uploading Resume...");
        elementUtils.uploadFile(uploadResume, resumePath);
        Thread.sleep(3000);
        System.out.println("✅ Resume uploaded.");

        // Scroll to Submit button
        WebElement submitBtn = elementUtils.waitForElementVisible(applyjobform, Constants.DEFAULT_WAIT);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", submitBtn);
        Thread.sleep(1000);

        // Submit Application
        System.out.println("📝 Submitting Application...");
        elementUtils.waitForElementToBeClickable(applyjobform, Constants.DEFAULT_WAIT).click();
        Thread.sleep(10000);
        System.out.println("✅ Application submitted.");
    }

}
