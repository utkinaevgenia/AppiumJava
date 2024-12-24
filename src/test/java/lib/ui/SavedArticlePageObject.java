package lib.ui;

import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SavedArticlePageObject extends MainPageObject
{
    protected static String
    NAME_OF_FOLDER_TPL,
    ARTICLE_BY_TITLE_TPL,
    SECOND_ARTICLE_BY_TITLE_TPL,
    REMOVE_FROM_SAVED_BUTTON,
    SAVED_RESULT_LOCATOR,
    SAVED_BUTTON,
    CLOSE_SYNC_BUTTON;

    private static String getFolderXpathByName (String name_of_folder)
    {
        return NAME_OF_FOLDER_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByName (String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getSecondSavedArticleXpathByName (String second_article_title)
    {
        return SECOND_ARTICLE_BY_TITLE_TPL.replace("{SECOND_TITLE}", second_article_title);
    }

    private static String getRemoveButtonByTitle (String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public SavedArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openFolderByName (String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                (folder_name_xpath),
                "Cannot find folder by name" + name_of_folder,
                5
        );
    }

    public void openSecondSavedArticleByTitleAndCheck(String second_article_title)
    {
        this.waitForSecondArticleToAppearByTitle(second_article_title);
        String second_article_title_xpath = getSecondSavedArticleXpathByName(second_article_title);
        this.waitForElementAndClick(
                second_article_title_xpath,
                "Cannot find article by name " + second_article_title,
                20);
        this.waitForElementPresent(second_article_title_xpath,"Cannot find saved article title " + second_article_title, 25);
        if (Platform.getInstance().isAndroid()) {
            String actual_second_article_title = this.waitForElementAndGetAttribute(second_article_title_xpath,
                    "text",
                    "Cannot get attribute from article " + second_article_title,
                    20);
            Assert.assertEquals(
                    "We see unexpected title of saved article",
                    second_article_title,
                    actual_second_article_title
            );
        } else {
            String actual_second_article_title = this.waitForElementAndGetAttribute(second_article_title_xpath,
                    "name",
                    "Cannot get attribute from article " + second_article_title,
                    20);
            Assert.assertEquals(
                    "We see unexpected title of saved article",
                    second_article_title,
                    actual_second_article_title
            );
        }
    }

    public void openSecondSavedArticleByTitle(String second_article_title)
    {
        this.waitForSecondArticleToAppearByTitle(second_article_title);
        String second_article_title_xpath = getSecondSavedArticleXpathByName(second_article_title);
        this.waitForElementAndClick(
                second_article_title_xpath,
                "Cannot find article by name " + second_article_title,
                20);
    }

    public void openFirstSavedArticleByTitle(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByName(article_title);
        this.waitForElementAndClick(
                article_title_xpath,
                "Cannot find article by name " + article_title,
                20);
    }

    public void checkWatchStar () {
        if (Platform.getInstance().isIOS()){
        this.waitForElementPresent(SAVED_BUTTON,"Cannot find star button",20);
        String star_actual_status = this.waitForElementAndGetAttribute(SAVED_BUTTON, "name", "Cannot find star button", 20);
        Assert.assertEquals(
                "We see unexpected status of saved article",
                "Saved. Activate to unsave.",
                star_actual_status
        );
        } else {
            WebElement saved_button_element = this.waitForElementPresent(SAVED_BUTTON,"Cannot find star button",20);
            Assert.assertTrue(saved_button_element.isDisplayed());
        }
}

    public int getAmountOfSavedArticles () {
        this.waitForElementPresent(
                SAVED_RESULT_LOCATOR,
                "Cannot find anything saved",
                5);
        return this.getAmountOfElements((SAVED_RESULT_LOCATOR));
    }

    public void waitForArticleToDisappearByTitle (String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByName(article_title);
        this.waitForElementNotPresent(
                (article_title_xpath),
                "Saved article still present with title" + article_title,
                15
        );
    }

    public void waitForArticleToAppearByTitle (String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByName(article_title);
        this.waitForElementPresent(
                (article_title_xpath),
                "Cannot find saved article with title " + article_title,
                15
        );
    }

    public void waitForSecondArticleToAppearByTitle (String second_article_title)
    {
        String second_article_title_xpath = getSavedArticleXpathByName(second_article_title);
        this.waitForElementPresent(
                (second_article_title_xpath),
                "Cannot find saved article with title" + second_article_title,
                15
        );
    }

    public void swipeByArticleToDelete (String article_title)
    {
        if (Platform.getInstance().isIOS()){
            this.waitForElementAndClick(
                    CLOSE_SYNC_BUTTON,
                    "Cannot find X button",
                    20);
        }
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByName(article_title);
        if (Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(
                    (article_title_xpath),
                    "Cannot find saved article"
            );
        } else if (Platform.getInstance().isIOS()){
            this.swipeElementToLeft(article_title_xpath, "Cannot find saved article");
            this.clickElementToTheRightUpperCorner(article_title_xpath,"Cannot find saved article");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator, "Cannot find button to remove article from Saved", 10);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.navigate().refresh();
        }
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.waitForArticleToDisappearByTitle(article_title);
        }
    }
}
