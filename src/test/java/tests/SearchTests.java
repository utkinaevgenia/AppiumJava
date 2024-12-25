package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.OnbordingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.OndordingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Amount of not empty search")
    @Description("This test verifies that amount of search more than one")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(SeverityLevel.CRITICAL)
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        String search_line = "Linking Park discograp";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_result = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue(
                "Amount of search results more than one",
                amount_of_search_result >=1
        );
    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Amount of empty search")
    @Description("This test shows that amount of search is empty")
    @Step("Starting test testAmountOfEmptySearch")
    @Severity(SeverityLevel.CRITICAL)
    public void testAmountOfEmptySearch ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        String search_line = "hjshfjk";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.assertThereIsNoResultOfSearch();
        }
    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search field contains text")
    @Description("This test checks that search input has text")
    @Step("Starting test testSearchFieldContainsText")
    @Severity(SeverityLevel.MINOR)
    public void testSearchFieldContainsText()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.assertSearchInputHasText();
    }
}
