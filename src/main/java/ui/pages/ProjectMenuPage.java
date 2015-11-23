package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.projects.CloseProjectPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectMenuPage extends BasePageObject {
    private ProjectsPage projectPage;

    @FindBy(xpath = "//h3[contains(text(),'Menu')]")
    WebElement title;
    /********* MORE *********/
    @FindBy(xpath = "//li/a[@class='board-menu-navigation-item-link js-open-more' and contains(text(),'More')]")
    WebElement ItemMenuMore;
    @FindBy(xpath = "//h3[contains(@class,'js-board-menu-title-text') and contains(text(),'More')]")
    WebElement menuMore;
    @FindBy(xpath = "//a[contains(@class,'js-close-board') and contains(text(),'Close Board…')]")
    WebElement closeBoard;
    @FindBy(xpath = "//span[contains(@class,'js-fill-pop-over-title') and contains(text(),'Close Board?')]")
    WebElement confirmCloseBoard;
    @FindBy(xpath = "//input[contains(@class,'js-confirm') and contains(@value,'Close')]")
    WebElement closeBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public ProjectMenuPage clickMenuMore(){
        ItemMenuMore.click();
        wait.until(ExpectedConditions.visibilityOf(menuMore));
        return this;
    }

    public ProjectMenuPage clickCloseBoard(){
        closeBoard.click();
        wait.until(ExpectedConditions.visibilityOf(confirmCloseBoard));
        return this;
    }

    public CloseProjectPage clickConfirmCloseBoard(){
        closeBtn.click();
        return new CloseProjectPage();
    }

    public CloseProjectPage closeProject() {
        clickMenuMore();
        clickCloseBoard();
        return clickConfirmCloseBoard();
    }
}
