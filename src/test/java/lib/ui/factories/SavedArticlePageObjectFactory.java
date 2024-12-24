package lib.ui.factories;

import lib.Platform;
import lib.ui.SavedArticlePageObject;
import lib.ui.android.AndroidSavedArticlePageObject;
import lib.ui.ios.IOSSavedArticlePageObject;
import lib.ui.mobile_web.MWSavedArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SavedArticlePageObjectFactory {
    public static SavedArticlePageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid())
        {
            return new AndroidSavedArticlePageObject(driver);
        }else if (Platform.getInstance().isIOS())
        {
            return new IOSSavedArticlePageObject(driver);
        }
        else return new MWSavedArticlePageObject(driver);
    }
}
