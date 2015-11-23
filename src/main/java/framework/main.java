package framework;

import org.openqa.selenium.WebDriver;

/**
 * Created by MiguelTerceros on 11/10/2015.
 */
public class main {
    public static void main(String[] args) {
        WebDriver webDriver;
        DriverManager driver;
        driver = DriverManager.getInstance();
        webDriver = driver.initialize();
        webDriver.get("http://trello.com/login");
    }
}
