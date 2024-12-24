package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUIPageObjectPageObject extends NavigationUIPageObject
{
    static {
        NAVIGATION_BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        SAVED_LINK = "xpath://android.widget.FrameLayout[@content-desc='Saved']/android.widget.FrameLayout";
    }
    public AndroidNavigationUIPageObjectPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
