package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.NavigationUIPageObject;
import lib.ui.android.AndroidNavigationUIPageObjectPageObject;
import lib.ui.ios.IOSNavigationUIPageObjectPageObject;
import lib.ui.mobile_web.MWNavigationUIPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIPageObjectFactory
{
    public static NavigationUIPageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUIPageObjectPageObject(driver);
        }
        else if (Platform.getInstance().isIOS()){
            return new IOSNavigationUIPageObjectPageObject(driver);
        }
        else return new MWNavigationUIPageObject(driver);
    }
}