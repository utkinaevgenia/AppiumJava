package lib.ui.mobile_web;

import lib.ui.NavigationUIPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUIPageObject extends NavigationUIPageObject {
    static {
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
        SAVED_LINK = "css:a[data-event-name='menu.watchlist']";
    }
    public MWNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
