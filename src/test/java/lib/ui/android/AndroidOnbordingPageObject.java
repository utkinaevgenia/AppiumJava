package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnbordingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidOnbordingPageObject extends OnbordingPageObject {
    static {
        START_BUTTON = "xpath://*[contains(@text,'Get started')]";
        SKIP_BUTTON = "xpath://*[contains(@text,'Skip')]";
        SCREEN_TITLE = "id:org.wikipedia:id/primaryTextView";
        ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE = "Cannot find title on the screen";
    }

    public AndroidOnbordingPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
