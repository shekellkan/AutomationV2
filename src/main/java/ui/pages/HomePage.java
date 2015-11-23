package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/12/15
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends BasePageObject{

    @FindBy(xpath = "//a[contains(text(),' Log in… ')]")
    WebElement home;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(home));
    }

    public HomePage(){

    }
}
