package ui.pages.teams;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.TeamsPage;

/**
 * Created by amateur on 22/11/2015.
 */
public class AddTeamPage extends BasePageObject {
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(), 'Create Team')]")
    WebElement createTitle;
    /******** teams **********/
    @FindBy(xpath = "//input[@id='org-display-name']")
    WebElement teamTitle;
    @FindBy(xpath = "//textarea[@id='org-desc']")
    WebElement teamDescription;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement createTeamsBtn;

    public AddTeamPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createTitle));
    }

    public  AddTeamPage setTeamsTitle(String title){
        teamTitle.clear();
        teamTitle.sendKeys(title);
        return this;
    }

    public  AddTeamPage setTeamsDescription(String description){
        teamDescription.clear();
        teamDescription.sendKeys(description);
        return this;
    }

    public TeamsPage clickCreateNewTeam(){
        createTeamsBtn.click();
        return new TeamsPage();
    }

    public TeamsPage createNewTeams(String name, String description){
        setTeamsTitle(name);
        if(description != null && !description.isEmpty()){
            setTeamsDescription(description);
        }
        return clickCreateNewTeam();
    }

    public TeamsPage createTeam(String nameTeam) {
        setTeamsTitle(nameTeam);
        return clickCreateNewTeam();
    }
}
