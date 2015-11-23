package ui.pages;

import common.Utils;
import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;
import ui.pages.projects.AddProjectPage;
import ui.pages.teams.AddTeamPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/11/15
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */


public class MainPage extends BasePageObject{
    PageTransporter page = PageTransporter.getInstance();
    TopMenuPage topMenuPage;
    //declare WebElements
    @FindBy(xpath = "//h3[contains(text(), 'My Boards')]")
    WebElement myBoardsMain;
    /***** projects ************/
    @FindBy(xpath = "//li/a[contains(text(),'Create new board…')]")
    WebElement newProjectBtn;
    /******** teams **********/
    @FindBy(xpath = "//a[contains(text(),'Create a new team…')]")
    WebElement newTeamBtn;

    public MainPage(){
        topMenuPage = new TopMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(myBoardsMain));
    }

    public boolean isMyBoardsMainDisplayed() {
        return myBoardsMain.isDisplayed();
    }

    /******************** PROJECTS *****************/
    public AddProjectPage clickNewProject(){
        newProjectBtn.click();
        return new AddProjectPage();
    }

    public boolean isProjectPresent(String nameProject){
        By isProjectDeleted = By.xpath("//span[@class='details']/span[contains(text(),'"+nameProject+"')]");
        return Utils.isElementPresent(isProjectDeleted);
    }

    /******************** TEAMS *******************/
    public AddTeamPage clickNewTeam(){
        newTeamBtn.click();
        return new AddTeamPage();
    }

    public boolean isTeamPresent(String nameTeam){
        //By isTeamDeleted = By.xpath("//div[@class='boards-page-board-section-header']/h3[contains(text(),'"+nameTeam+"')]");
        By isTeamDeleted = By.xpath("//h3[contains(text(),'"+nameTeam+"')]");
        return Utils.waitElementIsRemoved(isTeamDeleted);
    }
}
