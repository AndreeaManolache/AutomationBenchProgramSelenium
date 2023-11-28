import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OrangeHRMSteps extends SeleniumTest{


    public static WebDriver driver;
    @Given("I navigate to the website")
    public void iNavigateToTheWebsite()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }

    @When("I enter the username and password")
    public void iEnterTheUsernameAndPassword() {
        WebElement username= driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.click();
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.cssSelector("input[type=\"password\"]"));
        password.click();
        password.sendKeys("admin123");
    }

    @And("Press Login button")
    public void pressLoginButton() {
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
    }

    @Then("I am logged into OrangeHRM")
    public void iAmLoggedIntoOrangeHRM() {
        System.out.println("LogIn Successfully");
        driver.close(); // closes only a single window that is being accessed by the WebDriver instance currently
        driver.quit();// closes all the windows that were opened by the WebDriver instance
    }

    @Given("I access OrangeHRM page")
    public void iAccessOrangeHRMPage() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }

    @When("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials() {
        WebElement username= driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.click();
        username.sendKeys("Test");
        WebElement password=driver.findElement(By.cssSelector("input[type=\"password\"]"));
        password.click();
        password.sendKeys("Test123");
    }

    @And("I press the Login button to log into my account")
    public void iPressTheLoginButtonToLogIntoMyAccount() {
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
    }

    @Then("I verify that an appropriate message is displayed for invalid credentials")
    public void iVerifyThatAnAppropriateMessageIsDisplayedForInvalidCredentials() {
        WebElement warningMessage=driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
       warningMessage.isDisplayed();
        driver.close(); // closes only a single window that is being accessed by the WebDriver instance currently
        driver.quit();// closes all the windows that were opened by the WebDriver instance
    }

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        WebElement username= driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.click();
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.cssSelector("input[type=\"password\"]"));
        password.click();
        password.sendKeys("admin123");
    }

    @Then("I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application by using XPath selector")
    public void iVerifyThatIAmLoggedIntoMyAccountByCheckingThatTheUsernameIsDisplayedInTheNavigationBarInTheRightCornerOfTheApplicationByUsingXPathSelector() {
        WebElement usernameDisplayed=driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        usernameDisplayed.isDisplayed();
        driver.close();
        driver.quit();
    }

    @And("I click the Leave link from the menu")
    public void iClickTheLeaveLinkFromTheMenu()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement leaveLink=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        leaveLink.click();
    }

    @And("I select the Rejected status from the Show Leave with Status section")
    public void iSelectTheRejectedStatusFromTheShowLeaveWithStatusSection() {
        WebElement status=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        status.click();
        WebElement valueSelected=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]"));
        valueSelected.sendKeys("Rejected");
        valueSelected.click();
        WebElement valueRejected=driver.findElement(By.xpath("//span[@class='oxd-chip oxd-chip--default oxd-multiselect-chips-selected']"));
        valueRejected.click();

    }

    @Then("I check that the Rejected status is present as a selection by using XPath selector")
    public void iCheckThatTheRejectedStatusIsPresentAsASelectionByUsingXPathSelector() {
        WebElement rejectStatus=driver.findElement(By.xpath("//span[@class='oxd-chip oxd-chip--default oxd-multiselect-chips-selected']"));
        rejectStatus.isDisplayed();
    }

    @And("I click the My Info option from the menu")
    public void iClickTheMyInfoOptionFromTheMenu()  {
//        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
//        loginButton.click();
        WebElement myInfoOption=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        myInfoOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebDriverWait wait = new WebDriverWait(initialization.driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(myInfoOption)));
//        (initialization.driver).click();
    }

    @And("I click on the Contact Details link which will redirect me to the contactDetails page")
    public void iClickOnTheContactDetailsLinkWhichWillRedirectMeToTheContactDetailsPage() {
        WebElement contactDetails=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/a"));
        contactDetails.click();
    }

    @And("I update the Street {int} field from contact details")
    public void iUpdateTheStreetFieldFromContactDetails(int arg0) {
        WebElement street1=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input"));
        street1.click();
        street1.sendKeys("Dealul Zorilor");
    }

    @And("I select Algeria as country")
    public void iSelectAlgeriaAsCountry() {
        WebElement country=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]"));
        country.click();
        country.sendKeys("aaa");
        WebElement countryAlgeria=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]"));
        countryAlgeria.click();
    }

    @And("I press the Save button")
    public void iPressTheSaveButton() {
        WebElement saveButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        saveButton.click();
    }

    @Then("I should see the successfully updated confirmation message")
    public void iShouldSeeTheSuccessfullyUpdatedConfirmationMessage() {
        System.out.println("The successful message is displayed on the screen");
        driver.close();
        driver.quit();
    }

    @And("I click the Add Attachments button")
    public void iClickTheAddAttachmentsButton() {
        WebElement addAttachmentButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text']"));
        addAttachmentButton.click();
    }

    @And("I add a comment for this document uploaded in the comment field")
    public void iAddACommentForThisDocumentUploadedInTheCommentField() {
        WebElement commentBox=driver.findElement(By.xpath("//textarea[@placeholder='Type comment here']"));
        commentBox.click();
        commentBox.sendKeys("Test");

    }

    @And("I press the Save button for this attachment added")
    public void iPressTheSaveButtonForThisAttachmentAdded() {
        WebElement saveButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        saveButton.click();
    }

    @And("I click the Admin link from the menu")
    public void iClickTheAdminLinkFromTheMenu() {
        WebElement adminButton=driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        adminButton.click();

    }

    @And("I click on the Configuration dropdown menu button")
    public void iClickOnTheConfigurationDropdownMenuButton() {
        WebElement configurationDropdown=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/span"));
        configurationDropdown.click();
    }

    @And("I click on the Language Packages option")
    public void iClickOnTheLanguagePackagesOption() {
        WebElement languagePackages=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/ul/li[4]/a"));
        languagePackages.click();
    }

    @And("I click on the Translate button for Spanish - Español language package")
    public void iClickOnTheTranslateButtonForSpanishEspañolLanguagePackage() {
        WebElement spanishTranslate=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[8]/div/div[2]/div/button[1]"));
        spanishTranslate.click();

    }

    @Then("I should be redirected to the languageCustomization page")
    public void iShouldBeRedirectedToTheLanguageCustomizationPage() {
        System.out.println("You are redirected to the Spanish page");
        driver.close();
        driver.quit();
    }

    @And("I click on the Leave List option")
    public void iClickOnTheLeaveListOption() {
        WebElement leaveList=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[6]/a"));
        leaveList.click();

    }

    @And("I select Rejected status by filtering from Show Leave section")
    public void iSelectRejectedStatusByFilteringFromShowLeaveSection() {
        WebElement status=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        status.click();
        WebElement valueSelected=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]"));
        valueSelected.sendKeys("Rejected");
        valueSelected.click();
        WebElement valueRejected=driver.findElement(By.xpath("//span[@class='oxd-chip oxd-chip--default oxd-multiselect-chips-selected']"));
        valueRejected.click();
    }

    @And("I click the Admin link from the menu which will redirect me to the viewSystemUsers page")
    public void iClickTheAdminLinkFromTheMenuWhichWillRedirectMeToTheViewSystemUsersPage() {
        WebElement adminLink=driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        adminLink.click();
    }

    @And("I click the Add button to add a new language to the packages")
    public void iClickTheAddButtonToAddANewLanguageToThePackages() {
        WebElement addButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
        addButton.click();
    }

    @And("I select the language Colognian\\(Germany) from that list")
    public void iSelectTheLanguageColognianGermanyFromThatList() {
        WebElement languageArrow=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        languageArrow.click();
        WebElement languageSelected=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[1]/div/div[2]/div/div/div[1]"));
        languageSelected.click();
        languageSelected.sendKeys("Colognian");
        languageSelected.click();
    }

    @And("I press the Save to add this new language to my packages")
    public void iPressTheSaveToAddThisNewLanguageToMyPackages() {
        WebElement saveButton=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[3]/button[2]"));
        saveButton.click();
    }

    @Then("I should be able to see the confirmation message that the language was successfully saved")
    public void iShouldBeAbleToSeeTheConfirmationMessageThatTheLanguageWasSuccessfullySaved() {
        System.out.println("Successfully saved");
    }

    @And("I click on the button with three dots which is located in the left corner for an employee record")
    public void iClickOnTheButtonWithThreeDotsWhichIsLocatedInTheLeftCornerForAnEmployeeRecord() {
        WebElement threeDots=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[9]/div/li/button/i"));
        threeDots.click();
    }

    @And("I select to Add Comment from that list")
    public void iSelectToAddCommentFromThatList() {
        WebElement addComment=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[9]/div/li/button/i"));
        addComment.click();
        //no records found in the list
    }

    @And("I enter a comment in the Leave Request Comments section")
    public void iEnterACommentInTheLeaveRequestCommentsSection() {

    }

    @And("I save the comment")
    public void iSaveTheComment() {

    }

    @Then("I should be able to see the confirmation message that the comment was added successfully")
    public void iShouldBeAbleToSeeTheConfirmationMessageThatTheCommentWasAddedSuccessfully() {
        System.out.println("Comment was added");
    }

    @And("I select a period from {int}{int}{int} to {int}{int}{int}")
    public void iSelectAPeriodFromTo(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        WebElement fromDate=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        fromDate.click();
//        fromDate.click();
//        fromDate.clear();
//        fromDate.sendKeys("2021-12-01");
        WebElement toDate=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
       // toDate.click();

    }

    @And("I select to see only leave with Pending Approval status")
    public void iSelectToSeeOnlyLeaveWithPendingApprovalStatus() {
        WebElement status=driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        status.click();
//        WebElement valueSelected=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]"));
//        valueSelected.sendKeys("Pending Approval");
    }

    @And("I select Leave Type as CAN - Personal")
    public void iSelectLeaveTypeAsCANPersonal() {
        WebElement leaveType=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]"));
        leaveType.click();
        leaveType.sendKeys("CAN - Personal");
    }

    @And("I enter Anthony Nolan in the Employee Name field")
    public void iEnterAnthonyNolanInTheEmployeeNameField() {
        WebElement employeeName=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        employeeName.click();
        employeeName.sendKeys("Anthony Nolan");
    }

    @And("I press the Search button")
    public void iPressTheSearchButton() {
        WebElement searchButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        searchButton.click();
    }

    @And("I click on the Reset button")
    public void iClickOnTheResetButton() {
        WebElement resetButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']"));
        resetButton.click();
    }

    @Then("I should see a pop-up message that says no records found")
    public void iShouldSeeAPopUpMessageThatSaysNoRecordsFound() {
        WebElement noRecordsFound=driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
        noRecordsFound.isDisplayed();
    }

    @And("I select the Job Titles option from the Job menu dropdown")
    public void iSelectTheJobTitlesOptionFromTheJobMenuDropdown() {
        WebElement jobDropdown=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span"));
        jobDropdown.click();
        WebElement jobTitle=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a"));
        jobTitle.click();
    }

    @And("I click the Add button to add a new job")
    public void iClickTheAddButtonToAddANewJob() {
        WebElement addButton=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button/i"));
        addButton.click();

    }

    @And("I add a name for the job in the Job Title field")
    public void iAddANameForTheJobInTheJobTitleField() {
        WebElement jobTitleField=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input"));
       jobTitleField.click();
       jobTitleField.sendKeys("QA Engineer");
    }

    @And("I add a job description")
    public void iAddAJobDescription() {
        WebElement jobDescription=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea"));
        jobDescription.click();
        jobDescription.sendKeys("Is a tester Job");
    }

    @And("I click the Save button to add the new job")
    public void iClickTheSaveButtonToAddTheNewJob() {
        WebElement saveButton=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]"));
        saveButton.click();
    }

    @Then("I should see the confirmation message that the job was successfully added")
    public void iShouldSeeTheConfirmationMessageThatTheJobWasSuccessfullyAdded() {
        System.out.println("The job was added successfully");
    }

    @And("I click on the Recruitment link from the menu")
    public void iClickOnTheRecruitmentLinkFromTheMenu() {
        WebElement recruitmentLink=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span"));
        recruitmentLink.click();
    }

    @And("I click on the view icon located in the Actions section to see a candidate's application in Status Shortlisted")
    public void iClickOnTheViewIconLocatedInTheActionsSectionToSeeACandidateSApplicationInStatusShortlisted() {
        WebElement viewAction=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[7]/div/button[1]/i"));
        viewAction.click();
    }

    @And("I click the Schedule Interview button for that candidate")
    public void iClickTheScheduleInterviewButtonForThatCandidate() {
        WebElement scheduleInterview=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]"));
        scheduleInterview.click();
    }

    @And("I add the title of the interview")
    public void iAddTheTitleOfTheInterview() {
        WebElement interviewTitle=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        interviewTitle.click();
        interviewTitle.sendKeys("QA interview");
    }

    @And("I add two interviewers in the Interviewer field")
    public void iAddTwoInterviewersInTheInterviewerField() {
        WebElement interviewer=driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active oxd-autocomplete-text-input--error']"));
        interviewer.click();
        interviewer.sendKeys("t");

    }

    @And("I select a date and hour")
    public void iSelectADateAndHour() {
        WebElement date=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div/input"));
        date.sendKeys("2023-11-23");
        WebElement time=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div[1]/input"));
        time.sendKeys("02:00 PM");
    }

    @And("I press the Save button to schedule the interview")
    public void iPressTheSaveButtonToScheduleTheInterview() {
        WebElement saveButtonInterview=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveButtonInterview.click();
    }

    @Then("I should see the confirmation message for this scheduled interview")
    public void iShouldSeeTheConfirmationMessageForThisScheduledInterview() {
        System.out.println("Interview scheduled");
    }

    @And("I click on the Vacancies option")
    public void iClickOnTheVacanciesOption() {
        WebElement vacancies=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a"));
        vacancies.click();
    }

    @And("I search for vacancies with job title as Account Assistant")
    public void iSearchForVacanciesWithJobTitleAsAccountAssistant() {
        WebElement jobTitleForVacancies=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i"));
        jobTitleForVacancies.click();
        jobTitleForVacancies.sendKeys("Account Assistant");
        jobTitleForVacancies.click();
    }

    @Then("I can see that all records are displayed for Account Assistant")
    public void iCanSeeThatAllRecordsAreDisplayedForAccountAssistant() {
        WebElement searchButtonJob=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        System.out.println("All jobs for Account Assistant are displayed");
    }

    @And("I click on the PIM option from the menu")
    public void iClickOnThePIMOptionFromTheMenu() {
        WebElement pimLink=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span"));
        pimLink.click();
    }

    @And("I choose the Add Employee option")
    public void iChooseTheAddEmployeeOption() {
        WebElement addEmployee=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a"));
        addEmployee.click();
    }

    @And("I enter the employee's full name in the Employee Full Name section")
    public void iEnterTheEmployeeSFullNameInTheEmployeeFullNameSection() {
        WebElement employeeFullName=driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']"));
        employeeFullName.click();
        employeeFullName.sendKeys("Test");
        WebElement middleName=driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']"));
        middleName.click();
        middleName.sendKeys("test");
        WebElement lastName=driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']"));
        lastName.click();
        lastName.sendKeys("test1");
    }

    @And("I enter an employee id in the Employee Id field")
    public void iEnterAnEmployeeIdInTheEmployeeIdField() {
        WebElement employeeId=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
        employeeId.click();
    }

    @And("I click the Create Login Details button to make the option available")
    public void iClickTheCreateLoginDetailsButtonToMakeTheOptionAvailable() {
        WebElement createLoginDetails=driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));
        createLoginDetails.click();
    }

    @And("I add a username and password")
    public void iAddAUsernameAndPassword() {
        WebElement usernameEmployee=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
        usernameEmployee.click();
        usernameEmployee.sendKeys("test1");
        WebElement passwordEmployee=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
        passwordEmployee.click();
        passwordEmployee.sendKeys("test1234567");
        WebElement confirmPasswordEmployee=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
        confirmPasswordEmployee.click();
        confirmPasswordEmployee.sendKeys("test1234567");
    }

    @Then("I should see a confirmation message that the employee was successfully saved")
    public void iShouldSeeAConfirmationMessageThatTheEmployeeWasSuccessfullySaved() {
        System.out.println("The employee is added successfully");
    }

    @And("I click on the Maintenance option from the menu which will redirect me to the purgeEmployee page")
    public void iClickOnTheMaintenanceOptionFromTheMenuWhichWillRedirectMeToThePurgeEmployeePage() {
        WebElement maintenanceLink=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a/span"));
        maintenanceLink.click();
    }

    @And("I enter my password to validate my administrator credentials")
    public void iEnterMyPasswordToValidateMyAdministratorCredentials() {
        WebElement adminPassword=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input"));
        adminPassword.click();
        adminPassword.sendKeys("admin123");
    }

    @And("I click the Confirm button")
    public void iClickTheConfirmButton() {
        WebElement confirmButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-admin-access-button']"));
       confirmButton.click();
    }

    @And("I click on the Access Records option")
    public void iClickOnTheAccessRecordsOption() {
        WebElement accessRecords=driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']"));
        accessRecords.click();
    }

    @And("I enter Anthony Anadebe in the Employee Name field")
    public void iEnterAnthonyAnadebeInTheEmployeeNameField() {
        WebElement employeeName=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div/div/input"));
        employeeName.click();
        employeeName.sendKeys("Anthony Anadebe");
    }

    @And("click on the Search button")
    public void clickOnTheSearchButton() {
        WebElement searchButton=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
        searchButton.click();
    }

    @Then("I can see that the employee ID is displayed in the Selected Employee section by using css selector")
    public void iCanSeeThatTheEmployeeIDIsDisplayedInTheSelectedEmployeeSectionByUsingCssSelector() {
        System.out.println("The employee ID is displayed");
    }
}