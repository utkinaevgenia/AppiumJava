package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject
{
    protected static String
    SEARCH_INIT_ELEMENT,
    SEARCH_INPUT,
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    SEARCH_CANSEL_BUTTON,
    SEARCH_RESULT_LOCATOR,
    SEARCH_EMPTY_RESULTS_LABEL;

    public SearchPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement (String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES METHODS */

    @Step("Initialize search input field")
    public void initSearchInput()
    {
        this.waitForElementPresent((SEARCH_INIT_ELEMENT),"Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick((SEARCH_INIT_ELEMENT),"Cannot find and click search init element", 5);
    }

    @Step("Check if the search input is present")
    public void checkSearchInput()
    {
        this.waitForElementPresent((SEARCH_INIT_ELEMENT),"Cannot find search input", 5);
    }

    @Step("Wait for cancel button to appear")
    public void waitForCanselButtonToAppear ()
        {
            this.waitForElementPresent((SEARCH_CANSEL_BUTTON),"Cancel button is still present on page", 5);
        }

    @Step("Click the cancel button")
    public void clickCancelButton ()
    {
        this.waitForElementAndClick((SEARCH_CANSEL_BUTTON), "Cannot find and click cancel button", 5);
    }

    @Step("Wait for cancel button to disappear")
    public void waitForCanselButtonToDisappear ()
    {
        this.waitForElementNotPresent((SEARCH_CANSEL_BUTTON),"Cannot find cancel button", 5);
    }

    @Step("Typing '{search_line}' into the search input")
    public void typeSearchLine (String search_line)
    {
        this.waitForElementAndSentValue((SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    @Step("Wait for search result with substring '{substring}'")
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent((search_result_xpath),"Cannot find search result with substring " + substring,5);
    }

    @Step("Click on the article with substring '{substring}'")
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                (search_result_xpath),
                "Cannot find and click search result with substring " + substring,
                15);
    }

    @Step("Get the amount of found articles")
    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                (SEARCH_RESULT_LOCATOR),
                "Cannot find anything by the request ",
                35
        );
        return this.getAmountOfElements((SEARCH_RESULT_LOCATOR));
    }

    @Step("Wait for empty results label to appear")
    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(
                (SEARCH_EMPTY_RESULTS_LABEL),
                "Cannot find empty result label",
                15
        );
    }

    @Step("Verify that no search results are present")
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(
                (SEARCH_RESULT_LOCATOR),
                "We've found some results by request "
        );
    }

    @Step("Verify that search input contains expected text")
    public void assertSearchInputHasText()
    {
        this.asserElementHasText(
                (SEARCH_INPUT),
                "Field does not contain expected text",
                "Search Wikipedia",
                15
        );
    }
}
