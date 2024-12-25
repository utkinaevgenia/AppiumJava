package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class OnbordingPageObject extends MainPageObject
{
    protected static String
            START_BUTTON,
            SKIP_BUTTON,
            SCREEN_TITLE,
            ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE,
            FIRST_TITLE,
            SECOND_TITLE,
            THIRD_TITLE,
            FORTH_TITLE,
            NEXT_BUTTON;

    public OnbordingPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Wait for the 'Skip' button to appear")
    public void waitToSkip()
    {
        this.waitForElementPresent(
                (SKIP_BUTTON),
                "Cannot find Skip button",
                5);
    }

    @Step("Click on the 'Skip' button")
    public void clickToSkip()
    {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){
        this.waitForElementAndClick(
                (SKIP_BUTTON),
                "Cannot find Skip button",
                5);
    } else {
            System.out.println("Method clickToSkip() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Swipe through the onboarding screens to find the 'Get started' button")
    public void swipeOnbording ()
    {
        this.swipeLeftToFindElement(
                (START_BUTTON),
                "Cannot find 'Get started' text",
                20
        );
    }

    @Step("Click on the 'Get started' button in the onboarding screen")
    public void clickToStartOnOnbording ()
    {
        this.waitForElementAndClick(
                (START_BUTTON),
                "Cannot find 'Get started' text",
                20
        );
    }

    @Step("Perform one swipe to the left for {timeOfSwipe} milliseconds")
    public void oneSwipeLeft(int timeOfSwipe)
    {
        this.swipeLeft(timeOfSwipe);
    }

    @Step("Get the 'text' attribute of the current screen title")
    public String getScreenTitleAttribute()
    {
            return this.waitForElementAndGetAttribute(
                    (SCREEN_TITLE),
                    "text",
                    ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE,
                    15);
    }

    @Step("Wait for the first onboarding screen title to appear")
    public void waitForFirstPageTitle()
    {
        this.waitForElementPresent((FIRST_TITLE), "Cannot find first title" + FIRST_TITLE, 10);
    }

    @Step("Wait for the second onboarding screen title to appear")
    public void waitForSecondPageTitle()
    {
        this.waitForElementPresent((SECOND_TITLE), "Cannot find second title" + SECOND_TITLE, 10);
    }

    @Step("Wait for the third onboarding screen title to appear")
    public void waitForThirdPageTitle()
    {
        this.waitForElementPresent((THIRD_TITLE), "Cannot find second title" + THIRD_TITLE, 10);
    }

    @Step("Wait for the fourth onboarding screen title to appear")
    public void waitForForthPageTitle()
    {
        this.waitForElementPresent((FORTH_TITLE), "Cannot find second title" + FORTH_TITLE, 10);
    }

    @Step("Click on the 'Next' button in the onboarding screen")
    public void clickNextButton()
    {
        this.waitForElementAndClick((NEXT_BUTTON), "Cannot find Next button", 10);
    }

    @Step("Click on the 'Start' button in the onboarding screen")
    public void clickStartButton()
    {
        this.waitForElementAndClick((START_BUTTON), "Cannot find Start button", 10);
    }

    @Step("Get the 'name' attribute of the first onboarding screen title")
    public String getFirstScreenTitleAttribute()
    {
        return this.waitForElementAndGetAttribute(
                (FIRST_TITLE),
                "name",
                ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE,
                15);
    }

    @Step("Get the 'name' attribute of the second onboarding screen title")
    public String getSecondScreenTitleAttribute()
    {
        return this.waitForElementAndGetAttribute(
                (SECOND_TITLE),
                "name",
                ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE,
                15);
    }

    @Step("Get the 'name' attribute of the third onboarding screen title")
    public String getThirdScreenTitleAttribute()
    {
        return this.waitForElementAndGetAttribute(
                (THIRD_TITLE),
                "name",
                ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE,
                15);
    }

    @Step("Get the 'name' attribute of the fourth onboarding screen title")
    public String getForthScreenTitleAttribute()
    {
        return this.waitForElementAndGetAttribute(
                (FORTH_TITLE),
                "name",
                ERROR_MESSAGE_FOR_GETTING_ATTRIBUTE,
                15);
    }

}
