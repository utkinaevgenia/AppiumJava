package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.OnbordingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.OndordingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        String search_line = "Linking Park discograp";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_result = SearchPageObject.getAmountOfFoundArticles();
        assertTrue(
                "Amount of search results more than one",
                amount_of_search_result >=1
        );
    }

    @Test
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
    public void testSearchFieldContainsText()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.assertSearchInputHasText();
    }
}
