package common;

import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.TopMenuPage;

public class CommonMethods {
    private static PageTransporter pageTransporter = PageTransporter.getInstance();
    private static LoginPage loginPage;
    private static TopMenuPage topMenuPage;

    public static void logOut() {
        topMenuPage = new TopMenuPage();
        topMenuPage.logout();
    }

    public static void logIn() {
        loginPage = pageTransporter.navigateToLoginPage();
        loginPage.loginSuccessful("miguel.terceros@fundacion-jala.org", "morfeo3730");
    }
}