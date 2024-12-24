package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SavedArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSavedArticlePageObject extends SavedArticlePageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        SECOND_ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{SECOND_TITLE}']";
        CLOSE_SYNC_BUTTON = "id:Close";
        SAVED_RESULT_LOCATOR = "xpath://XCUIElementTypeCell";
        SAVED_BUTTON = "id:Saved. Activate to unsave.";
    }

    public IOSSavedArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
