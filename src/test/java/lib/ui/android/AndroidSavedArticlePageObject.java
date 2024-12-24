package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SavedArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSavedArticlePageObject extends SavedArticlePageObject
{
    static {
        NAME_OF_FOLDER_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        SECOND_ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{SECOND_TITLE}']";
        SAVED_RESULT_LOCATOR = "id:page_list_item_container";
    }

    public AndroidSavedArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
