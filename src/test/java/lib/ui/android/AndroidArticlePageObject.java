package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "xpath://*[contains(@text,'Java (programming language)')]";
        SECOND_TITLE = "xpath://*[contains(@text,'Java')]";
        ADD_TO_LIST_SAVE_BUTTON = "id:org.wikipedia:id/page_save";
        ADD_TO_LIST_BUTTON = "xpath://*[@text='Add to list']";
        MY_LIST_TEXT_INPUT = "id:org.wikipedia:id/text_input";
        NAME_OF_FOLDER_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
    }

    public AndroidArticlePageObject (RemoteWebDriver driver) {
        super(driver);
    }
}
