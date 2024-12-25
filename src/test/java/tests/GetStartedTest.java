package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.OnbordingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.OndordingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Onbording")
public class GetStartedTest  extends CoreTestCase
{
    @Test
    @DisplayName("Test passing through the welcome screens")
    @Description("This test verifies that the user can pass through all onboarding screens and start the application.")
    @Step("Starting test testPassThroughWelcome")
    @Severity(SeverityLevel.CRITICAL)
    public void testPassThroughWelcome ()
    {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMw())
        {
            return;
        }
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.waitForFirstPageTitle();
        OnbordingPageObject.clickNextButton();

        OnbordingPageObject.waitForSecondPageTitle();
        OnbordingPageObject.clickNextButton();

        OnbordingPageObject.waitForThirdPageTitle();
        OnbordingPageObject.clickNextButton();

        OnbordingPageObject.waitForForthPageTitle();
        OnbordingPageObject.clickStartButton();
    }

    @Test
    @DisplayName("Test swiping through onboarding screens on iOS")
    @Step("Starting test testSwipeOnbordingLeftAndCheckTitleIos")
    @Description("This test verifies that the user can swipe left through all onboarding screens and the titles match the expected values.")
    @Severity(SeverityLevel.NORMAL)
    public void testSwipeOnbordingLeftAndCheckTitleIos() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isMw())
        {
            return;
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.waitToSkip();
        String title_first_screen = OnbordingPageObject.getFirstScreenTitleAttribute();
        Assert.assertEquals(
                "Unexpected title of first screen",
                "The free encyclopedia",
                title_first_screen
        );
        OnbordingPageObject.oneSwipeLeft(200);
        String title_second_screen = OnbordingPageObject.getSecondScreenTitleAttribute();
        Assert.assertEquals(
                "Unexpected title of second screen",
                "New ways to explore",
                title_second_screen
        );
        OnbordingPageObject.oneSwipeLeft(200);
        String title_third_screen = OnbordingPageObject.getThirdScreenTitleAttribute();
        Assert.assertEquals(
                "Unexpected title of third screen",
                "Search in over 300 languages",
                title_third_screen
        );
        OnbordingPageObject.oneSwipeLeft(200);
        String title_forth_screen = OnbordingPageObject.getForthScreenTitleAttribute();
        Assert.assertEquals(
                "Unexpected title of third screen",
                "Data & Privacy",
                title_forth_screen
        );
        OnbordingPageObject.clickToStartOnOnbording();
        SearchPageObject.checkSearchInput();
    }
}
