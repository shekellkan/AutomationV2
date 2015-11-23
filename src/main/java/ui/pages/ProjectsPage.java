package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Projects;
import ui.BasePageObject;
import ui.pages.projects.CloseProjectPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectsPage extends BasePageObject {
    private TopMenuPage topMenu;
    private ProjectMenuPage projectMenu;

    @FindBy(xpath = "//span[@class='board-header-btn-text']")
    WebElement nameProject;
    @FindBy(xpath = "//div[contains(@class,'js-add-list')]/form/span")
    WebElement addBoardBtn;

    WebElement boardSearch;

    public ProjectsPage(){
        waitUntilPageObjectIsLoaded();
        topMenu = new TopMenuPage();
        projectMenu = new ProjectMenuPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameProject));
    }

    public boolean isNameProjectDisplayed() {
        return nameProject.isDisplayed();
    }

    public WebElement titleProject(){
        return nameProject;
    }

    public CloseProjectPage deleteProject(){
        return projectMenu.closeProject();
    }

    public AddBoardPage clickAddBoardList(){
        addBoardBtn.click();
        return new AddBoardPage();
    }

    public String isBoardPresent(String nameBoardSearch){
        boardSearch = driver.findElement(By.xpath("//h2[contains(@class,'list-header-name') and contains(text(),'"+nameBoardSearch+"')]"));
        return boardSearch.getText();
    }
}
