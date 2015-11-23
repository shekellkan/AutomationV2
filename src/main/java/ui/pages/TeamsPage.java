package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamsPage extends BasePageObject {
    private TopMenuPage topMenuPage;

    @FindBy(xpath = "//h1[@class='u-inline']")
    WebElement titleTeam;
    /******** MENU Btn *************/
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    WebElement menuSettings;
    @FindBy(xpath = "//a[contains(text(),'Boards')]")
    WebElement menuBoards;
    @FindBy(xpath = "//a[contains(text(),'Members')]")
    WebElement menuMembers;
    @FindBy(xpath = "//a[contains(text(),'Business Class')]")
    WebElement menuBusiness;
    /******** DELETE Btn ************/
    @FindBy(xpath = "//a[contains(text(), 'Delete this team?')]")
    WebElement deletedBtn;
    @FindBy(xpath = "//input[@value='Delete Forever']")
    WebElement deletedForeverBtn;
    @FindBy(xpath = "//a[contains(text(), 'Add Members')]")
    /******** ADD elements *********/
    WebElement addMembersBtn;
    @FindBy(xpath = "//div[@class='search-with-spinner']/input")
    WebElement emailField;
    @FindBy(xpath = "//div[contains(@class,'js-search-results')]/h4[contains(text(), 'Select to add')]")
    WebElement selectAddForm;
    @FindBy(xpath = "//input[contains(@class,'js-full-name')]")
    WebElement fullNameInvited;
    @FindBy(xpath = "//a[contains(@class,'icon-close' )]")
    WebElement iconClose;
    @FindBy(xpath = "//div[contains(@class,'js-search-results')]/ul/div/li/a")
    WebElement membersOption;
    @FindBy(xpath = "//form[contains(@class,'js-email-data')]/label[contains(text(), 'Full Name')]")
    WebElement fullNameForm;
    @FindBy(xpath = "//form[contains(@class,'js-email-data')]/input[contains(@class,'js-send-email-invite') and contains(@value,'Send')]")
    WebElement sendInvitedBtn;

    WebElement memberInTeam = null;

    public TeamsPage(){
        topMenuPage = new TopMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleTeam));
    }

    public boolean isNameTeamsDisplayed() {
        return titleTeam.isDisplayed();
    }

    public String nameTeam(){
        return titleTeam.getText();
    }

    /******************** MENUS TEAMS ***********************/
    public TeamsPage clickMenuSetting(){
        menuSettings.click();
        wait.until(ExpectedConditions.visibilityOf(deletedBtn));
        return this;
    }

    public TeamsPage clickMenuBoards(){
        menuBoards.click();
        return this;
    }

    public TeamsPage clickMenuMembers(){
        menuMembers.click();
        wait.until(ExpectedConditions.visibilityOf(addMembersBtn));
        return this;
    }

    public TeamsPage clickMenuBusiness(){
        menuBusiness.click();
        return this;
    }
    /**************** DELETE *****************/
    public TeamsPage clickBtnDeleted(){
        deletedBtn.click();
        return this;
    }

    public MainPage clickBtnDeletedForever(){
        deletedForeverBtn.click();
        return new MainPage();
    }

    public MainPage deleteTeam(){
        clickMenuSetting();
        clickBtnDeleted();
        return clickBtnDeletedForever();
    }
    /*************** ADD MEMBER **************/
    public TeamsPage clickAddMembersBtn(){
        addMembersBtn.click();
        return this;
    }

    public TeamsPage setEmailMembers(String email){
        emailField.clear();
        emailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(membersOption));
        return this;
    }

    public TeamsPage setNameInvite(String fullName){
        fullNameInvited.clear();
        fullNameInvited.sendKeys(fullName);
        wait.until(ExpectedConditions.visibilityOf(fullNameForm));
        return this;
    }

    public TeamsPage clickMemberOptions(){
        membersOption.click();
        return this;
    }

    public TeamsPage clickIconClose(){
        iconClose.click();
        return this;
    }

    public TeamsPage clickSendInvitedMember(){
        sendInvitedBtn.click();
        return this;
    }

    public String isNewMemberTeamDisplayed(String fullName){
        memberInTeam = driver.findElement(By.xpath("//span[contains(@class, 'full-name') and contains(text(),'"+fullName+"')]"));
        return memberInTeam.getText();
    }

    public TeamsPage addMemberInTeam(String nameMember, String email){
        clickAddMembersBtn();
        setEmailMembers(email);
        if(selectAddForm.isDisplayed() && selectAddForm.isEnabled()){
            clickMemberOptions();
            clickIconClose();
        }
        else if (fullNameForm.isDisplayed() && fullNameForm.isEnabled()){
            setNameInvite(nameMember);
            clickSendInvitedMember();
        }
        return this;
    }

    /************ HOME **********/
    public MainPage goToMainPage(){
        return topMenuPage.goToMainPage();
    }
}
