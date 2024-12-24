package lib.ui.mobile_web;

import lib.ui.SavedArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSavedArticlePageObject extends SavedArticlePageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://li[contains(@class, 'page-summary with-watchstar')]//h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "css:a.watch-this-article.watched";
        SAVED_RESULT_LOCATOR = "xpath://li[contains(@class, 'page-summary with-watchstar')]";
        SAVED_BUTTON = "css:a#ca-watch > span.minerva-icon.minerva-icon--unStar";
    }

    public MWSavedArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
