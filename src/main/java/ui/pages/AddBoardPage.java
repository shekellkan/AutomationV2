package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by amateur on 23/11/2015.
 */
public class AddBoardPage extends BasePageObject {
    @FindBy(xpath = "//div[contains(@class,'mod-add')]/form/input[contains(@placeholder,'Add a list…')]")
    WebElement nameBoardField;
    @FindBy(xpath = "//input[contains(@class,'js-save-edit') and contains(@value,'Save')]")
    WebElement saveBtn;

    public AddBoardPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameBoardField));
    }

    public AddBoardPage setNameBoard(String nameBoard){
        nameBoardField.clear();
        nameBoardField.sendKeys(nameBoard);
        return this;
    }

    public ProjectsPage clickSaveBtn(){
        saveBtn.click();
        return new ProjectsPage();
    }

    public ProjectsPage createNewBoard(String nameBoard){
        setNameBoard(nameBoard);
        return clickSaveBtn();
    }
}
