package ui.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;
import ui.pages.ProjectsPage;

/**
 * Created by amateur on 22/11/2015.
 */
public class AddProjectPage extends BasePageObject {
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(),'Create Board')]")
    WebElement createTitle;
    /******** Projects *********/
    @FindBy(xpath = "//input[@id='boardNewTitle']")
    WebElement projectTitle;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement createProjectBtn;
    @FindBy(xpath = "//select[contains(@name,'org-id')]")
    WebElement selectField;
    Select selectTeam = new Select(selectField);

    public AddProjectPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createTitle));
    }

    public  AddProjectPage setProjectTitle(String title){
        projectTitle.clear();
        projectTitle.sendKeys(title);
        return this;
    }

    public ProjectsPage clickCreateNewProject(){
        createProjectBtn.click();
        return new ProjectsPage();
    }

    public AddProjectPage selectTeamProject(String nameTeam){
        selectTeam.selectByVisibleText(nameTeam);
        return this;
    }

    public ProjectsPage createNewProjects(String title){
        setProjectTitle(title);
        return clickCreateNewProject();
    }

    public ProjectsPage createNewProjectWithTeam(String nameTeam, String titleProject){
        setProjectTitle(titleProject);
        selectTeamProject(nameTeam);
        return clickCreateNewProject();
    }
}
