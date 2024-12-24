package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.OnbordingPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.OndordingPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase
{
    @Test
    public void testCompareArticleTitle ()
    {
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    public void testFindArticlesAndCanselSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Island in Indonesia");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForCanselButtonToAppear();
        SearchPageObject.clickCancelButton();
        SearchPageObject.waitForCanselButtonToDisappear();
    }

    @Test
    public void testAssertTitle()
    {
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.assertTitleArticlePresent();
    }
}
