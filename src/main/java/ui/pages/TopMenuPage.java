package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;

/**
 * Created by amateur on 15/11/2015.
 */
public class TopMenuPage extends BasePageObject {
    PageTransporter page = PageTransporter.getInstance();

    @FindBy(xpath = "//a[@aria-label='Trello Home']")
    WebElement logo;

    @FindBy(xpath = "//a[contains(@aria-label,'Open Member Menu')]")
    WebElement user;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logoutBtn;

    public TopMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void logout() {
        user.click();
        logoutBtn.click();
        page.navigateToHomePage();
    }

    public MainPage goToMainPage() {
        logo.click();
        return new MainPage();
    }
}
