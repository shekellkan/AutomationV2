package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by MiguelTerceros on 11/10/2015.
 */
public class DriverManager {
    //declare variables
    private static DriverManager instance = null;
    private WebDriver driver;
    private WebDriver Mozilla = null;
    private WebDriverWait wait;

    public static DriverManager getInstance(){
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private DriverManager(){
        initialize();
    }

    public WebDriver initialize(){
        if(Mozilla == null){
            driver = new FirefoxDriver();
            Mozilla = driver;
            wait = new WebDriverWait(driver, 30, 100);
        }else if(Mozilla != null){
            driver = Mozilla;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quitDriver() {
        driver.quit();
    }
}
