package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUIPageObjectPageObject extends NavigationUIPageObject
{
    static {
        NAVIGATION_BACK_BUTTON = "id:Back";
        SAVED_LINK = "id:Saved";
        CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
    }
    public IOSNavigationUIPageObjectPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
