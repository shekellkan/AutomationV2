package ui.pages.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.pages.MainPage;
import ui.pages.TopMenuPage;

/**
 * Created by amateur on 22/11/2015.
 */
public class CloseProjectPage extends BasePageObject {
    private TopMenuPage topMenuPage;

    @FindBy(xpath = "//div[contains(@class,'big-message')]/h1")
    WebElement titleCloseProject;

    public CloseProjectPage(){
        topMenuPage = new TopMenuPage();
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleCloseProject));
    }

    public MainPage gotoMainPage(){
        return topMenuPage.goToMainPage();
    }

    public boolean isCloseProject(){
        return titleCloseProject.isDisplayed();
    }
}
