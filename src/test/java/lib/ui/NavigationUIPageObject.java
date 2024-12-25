package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
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

    @Step("Navigate back by clicking the 'Back' button")
    public void navigation_back ()
    {
        this.waitForElementAndClick(
                (NAVIGATION_BACK_BUTTON),
                "Cannot find 'Back' button",
                5
        );
    }

    @Step("Open the navigation menu")
    public void openNavigation() {
        if (Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click menu button", 50);
        } else {
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Click on the 'Saved' button")
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

    @Step("Click the 'Cancel' button in the search line")
    public void clickCancel()
    {
        this.waitForElementAndClick(CANCEL_BUTTON, "Cannot find cancel button in search line",5);
    }
}
