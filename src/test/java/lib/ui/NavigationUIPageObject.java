package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUIPageObject extends MainPageObject
{
    protected static String
    NAVIGATION_BACK_BUTTON,
    SAVED_LINK,
    OPEN_NAVIGATION,
    CANCEL_BUTTON;

    public NavigationUIPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void navigation_back ()
    {
        this.waitForElementAndClick(
                (NAVIGATION_BACK_BUTTON),
                "Cannot find 'Back' button",
                5
        );
    }

    public void openNavigation() {
        if (Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click menu button", 50);
        } else {
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickSaved()
    {
        if (Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(SAVED_LINK,"Cannot find 'Saved' button", 5);
        } else this.waitForElementAndClick(
                (SAVED_LINK),
                "Cannot find 'Saved' button",
                5
        );
    }

    public void clickCancel()
    {
        this.waitForElementAndClick(CANCEL_BUTTON, "Cannot find cancel button in search line",5);
    }
}
