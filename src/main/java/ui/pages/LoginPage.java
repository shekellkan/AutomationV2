package ui.pages;

import common.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;

import javax.swing.*;
import java.util.NoSuchElementException;

/**
 *
 */
public class LoginPage extends BasePageObject {

    @FindBy(name = "user")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(name = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(className = "error-message")
    WebElement error;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    public LoginPage setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPage setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage clickLoginBtnSuccessful() {
        loginBtn.click();
        return new MainPage();
    }

    public LoginPage clickLoginBtnFailed() {
        loginBtn.click();
        return this;
    }

    public void login(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
    }

    public MainPage loginSuccessful(String userName, String password) {
        login(userName, password);
        return clickLoginBtnSuccessful();
    }

    public LoginPage loginFailed(String userName, String password) {
        login(userName, password);
        return clickLoginBtnFailed();
    }

    public boolean getErrorMessage(){
        return Utils.isElementPresent(By.xpath("//div[@id='error']//p[@class='error-message']"));
    }
}
