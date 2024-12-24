package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        SECOND_TITLE = "css:#content h1";
        ADD_TO_LIST_SAVE_BUTTON = "css:a#ca-watch";
        STAR_BUTTON = "css:a.watch-this-article";
        REMOVE_FROM_MY_LIST_BUTTON = "css:#ca-watch > span:last-of-type";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
