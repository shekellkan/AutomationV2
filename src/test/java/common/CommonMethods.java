package common;

import ui.PageTransporter;

public class CommonMethods {
    private static PageTransporter pageTransporter = PageTransporter.getInstance();

    public static void logOut() {
        pageTransporter
                .navigateToHomePage()
                .clickAuthenticatedDropdownButton()
                .clickSignOutButton()
        ;
    }

    public static void logIn() {
        pageTransporter
                .navigateToMainPage()
                .clickLogInButton()
                .loginSuccessful("Jhasmany.Quiroz@fundacion-jala.org", "1c7hu57&7")
        ;
    }
}