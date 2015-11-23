package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by amateur on 22/11/2015.
 */
public class BoardsPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'list-header')]/h2[contains(@class,'list-header-name')]")
    WebElement titleBoard;
    @FindBy(xpath = "//a[contains(@class,'open-card-composer') and contains(text(),'Add a card…')]")
    WebElement addCardBtn;
    @FindBy(xpath = "//textarea[contains(@class,'js-card-title')]")
    WebElement textAreaName;
    @FindBy(xpath = "//input[contains(@class,'confirm') and contains(@value,'Add')]")
    WebElement addStoriesBtn;

    public BoardsPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleBoard));
    }

    /************ ADD CARD ************/
    public BoardsPage clickAddCard(){
        addCardBtn.click();
        return this;
    }

    public BoardsPage setTextAreaField(String nameUserStories){
        textAreaName.clear();
        textAreaName.sendKeys(nameUserStories);
        return this;
    }

    public BoardsPage clickAddStories(){
        addStoriesBtn.click();
        return this;
    }

    public BoardsPage createUserStories(String nameUserStories){
        clickAddCard();
        setTextAreaField(nameUserStories);
        return clickAddStories();
    }
}
