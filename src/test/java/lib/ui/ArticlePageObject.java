package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
    TITLE,
    SECOND_TITLE,
    ADD_TO_LIST_SAVE_BUTTON,
    REMOVE_FROM_MY_LIST_BUTTON,
    ADD_TO_LIST_BUTTON,
    MY_LIST_TEXT_INPUT,
    NAME_OF_FOLDER_TPL,
    STAR_BUTTON,
    MY_LIST_OK_BUTTON;

    public ArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    private static String getFolderXpathByName (String name_of_folder)
    {
        return NAME_OF_FOLDER_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public WebElement waitForTitleElement ()
    {
        return this.waitForElementPresent(
                (TITLE),
                "Cannot find article title",
                20);
    }

    public WebElement waitForSecondTitleElement ()
    {
        return this.waitForElementPresent(
                (SECOND_TITLE),
                "Cannot find article title",
                20);
    }

    public String getArticleTitle ()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public String getSecondArticleTitle ()
    {
        WebElement second_title_element = waitForSecondTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return second_title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return second_title_element.getAttribute("name");
        } else {
            return second_title_element.getText();
        }
    }

    public void clickFolderByName (String name_of_folder)
    {
        String folder_name = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                (folder_name),
                "Cannot find folder by name" + name_of_folder,
                5
        );
    }

    public void addArticleToMyList (String name_of_folder)
    {
        this.waitForElementAndClick(
                (ADD_TO_LIST_SAVE_BUTTON),
                "Cannot find 'Save' button",
                15
        );

        this.waitForElementAndClick(
                (ADD_TO_LIST_BUTTON),
                "Cannot find 'Add to list' button",
                12
        );


        this.waitForElementAndSentValue(
                (MY_LIST_TEXT_INPUT),
                name_of_folder,
                "Cannot find input to set name of article folder",
                15
        );

        this.waitForElementAndClick(
                (MY_LIST_OK_BUTTON),
                "Cannot press 'OK' button",
                5
        );
    }

    public void addArticleToTheSameList (String name_of_folder)
    {
        this.waitForElementAndClick(
                (ADD_TO_LIST_SAVE_BUTTON),
                "Cannot find 'Save' button",
                15
        );

        this.waitForElementAndClick(
                (ADD_TO_LIST_BUTTON),
                "Cannot find 'Add to list' button",
                12
        );

        this.clickFolderByName(
                name_of_folder
        );
    };

    public void addArticleToSaved ()
    {
//        if (Platform.getInstance().isMw()){
//            this.removeArticleFromSavedIfItAdded();
//        }
        this.waitForElementAndClick(ADD_TO_LIST_SAVE_BUTTON, "Cannot find Saved button", 5);
    }

    public void removeArticleFromSavedIfItAdded() {
        if (this.isElementPresent(REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(REMOVE_FROM_MY_LIST_BUTTON, "Cannot click button to romove from saved article", 20);
        };
        this.waitForElementPresent(ADD_TO_LIST_SAVE_BUTTON,"Cannot find Save button", 5);
    }

    public void assertTitleArticlePresent()
    {
        this.assertElementPresent(
                (TITLE),
                "Cannot find article title"
        );
    }
}
