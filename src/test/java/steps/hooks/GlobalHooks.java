package steps.hooks;

import cucumber.api.java.Before;
import ui.PageTransporter;

/**
 *
 */
public class GlobalHooks {
    private static boolean started = false;

    @Before(order=1)
    public void setUp() throws Exception {
        if(!started) {
            PageTransporter.getInstance().navigateToLoginPage();
            started = true;
        }
    }
}
