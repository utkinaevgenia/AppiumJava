package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Assert;
import org.junit.Test;

public class SavedArticle extends CoreTestCase
{
    private static final String name_of_folder = "Test";
    private static final String login = "Ev Glt";
    private static final String password = "Q1W2E3R4";

    @Test
    @Features(value = {@Feature(value = "Search"),@Feature(value = "Article"),@Feature(value = "Save articles")})
    @DisplayName("Save the first article to the reading list")
    @Description("This test verifies that a user can save an article to their reading list or saved items and then delete it.")
    @Step("Starting test testSaveFirstArticleToMyList")
    @Severity(SeverityLevel.CRITICAL)
    public void testSaveFirstArticleToMyList ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();
        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToSaved();
        }
        if (Platform.getInstance().isMw()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            Assert.assertEquals(
                    "We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
        }
        NavigationUIPageObject NavigationUIPageObject = NavigationUIPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()){
            NavigationUIPageObject.navigation_back();
            NavigationUIPageObject.navigation_back();
        } else if (Platform.getInstance().isIOS()){
            NavigationUIPageObject.navigation_back();
            NavigationUIPageObject.clickCancel();
        } else {
            NavigationUIPageObject.openNavigation();
        }

        NavigationUIPageObject.clickSaved();

        SavedArticlePageObject SavedArticlePageObject = SavedArticlePageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid())
        {
            SavedArticlePageObject.openFolderByName(name_of_folder);
        }
        SavedArticlePageObject.swipeByArticleToDelete(article_title);

    }

    @Test
    @Features(value = {@Feature(value = "Search"),@Feature(value = "Article"),@Feature(value = "Save articles")})
    @DisplayName("Save two articles and delete one")
    @Description("This test verifies that a user can save two articles to the reading list or saved items, delete one, and verify the remaining.")
    @Step("Starting test testSaveTwoArticlesAndDeleteOne")
    @Severity(SeverityLevel.CRITICAL)
    public void testSaveTwoArticlesAndDeleteOne () {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        OnbordingPageObject OnbordingPageObject = OndordingPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUIPageObject NavigationUIPageObject = NavigationUIPageObjectFactory.get(driver);
        OnbordingPageObject.clickToSkip();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        String article_title = ArticlePageObject.getArticleTitle();
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToSaved();
        }
        if (Platform.getInstance().isMw()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            Assert.assertEquals(
                    "We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
        }
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            NavigationUIPageObject.navigation_back();
        } else {
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine("Java");
        }
        SearchPageObject.clickByArticleWithSubstring("Island in Indonesia");
        String second_article_title = ArticlePageObject.getSecondArticleTitle();
            if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToTheSameList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToSaved();
        }
        if (Platform.getInstance().isAndroid()) {
            NavigationUIPageObject.navigation_back();
            NavigationUIPageObject.navigation_back();
        } else if (Platform.getInstance().isIOS()) {
            NavigationUIPageObject.navigation_back();
            NavigationUIPageObject.clickCancel();
        } else {
            NavigationUIPageObject.openNavigation();
        }

        NavigationUIPageObject.clickSaved();

        SavedArticlePageObject SavedArticlePageObject = SavedArticlePageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            SavedArticlePageObject.openFolderByName(name_of_folder);
        }
        SavedArticlePageObject.swipeByArticleToDelete(article_title);
        int amount_of_saved_result = SavedArticlePageObject.getAmountOfSavedArticles();
            Assert.assertTrue(
                    "Amount of saved results more than one",
                    amount_of_saved_result == 1
        );
        if (Platform.getInstance().isAndroid()) {
            SavedArticlePageObject.openSecondSavedArticleByTitleAndCheck(second_article_title);
        }
        else if (Platform.getInstance().isIOS()){
            SavedArticlePageObject.openSecondSavedArticleByTitle(second_article_title);
            SavedArticlePageObject.checkWatchStar();
        }
        else {
            SavedArticlePageObject.openFirstSavedArticleByTitle(article_title);
            SavedArticlePageObject.checkWatchStar();
        }
    }
}
