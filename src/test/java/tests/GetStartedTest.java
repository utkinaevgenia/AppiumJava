package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.OnbordingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.OndordingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class GetStartedTest  extends CoreTestCase
{
    @Test
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
