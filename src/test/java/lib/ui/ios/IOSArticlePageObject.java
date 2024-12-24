package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        SECOND_TITLE = "id:Java";
        ADD_TO_LIST_SAVE_BUTTON = "id:Save for later";
    }

    public IOSArticlePageObject (RemoteWebDriver driver) {
        super(driver);
    }
}
