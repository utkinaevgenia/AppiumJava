package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.OnbordingPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSOnborgingPageObject extends OnbordingPageObject {
    static {
        START_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']";
        SKIP_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Skip']";
        FIRST_TITLE = "id:The free encyclopedia";
        SECOND_TITLE = "id:New ways to explore";
        THIRD_TITLE = "id:Search in over 300 languages";
        FORTH_TITLE = "id:Data & Privacy";
        NEXT_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Next']";
        ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE = "Cannot find title on the screen";
    }

    public IOSOnborgingPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
