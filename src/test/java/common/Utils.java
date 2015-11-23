package common;

import framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static WebElement memberFound;
    public static WebDriver driver = DriverManager.getInstance().getWebDriver();

    public static boolean isElementPresent(By byElement) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            driver.findElement(byElement);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally
        {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }

    public static Boolean waitElementIsRemoved(By element){
        Boolean elementFind;
        do{
            elementFind = isElementPresent(element);
        }while (elementFind == Boolean.TRUE);       //todo update solve bucle infinito
        return elementFind;
    }

    public static WebElement findMember(By member){

        memberFound = driver.findElement(member);
        System.out.println("Aqui esta:" + memberFound.getText());
        return memberFound;
    }
}
