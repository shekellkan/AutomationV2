package common;

import ui.pages.TopMenuPage;

/**
 * Created by silvia valencia on 11/9/2015.
 */
public class CommonMethods {
    public static TopMenuPage topMenu;
    /**
     * Log outs from the web app
     */
    public static void logOut() {
        topMenu = new TopMenuPage();
        topMenu.logout();
    }
}
