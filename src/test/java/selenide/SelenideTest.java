package selenide;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.SelenideBlogPage;
import pages.SelenideHomePage;
import pages.SelenideSearchPage;

public class SelenideTest extends BaseTest{
    @BeforeMethod
    @Override
    public void parentSetUp() {
        super.parentSetUp();
    }

    @Test
    public static void selenideSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.acceptEverything();
        googleHomePage.searchFieldClick();
        SelenideSearchPage selenideSearchPage = new SelenideSearchPage();
        selenideSearchPage.checkNumberOfResultsAndClickFirst();
        SelenideHomePage selenideHomePage = new SelenideHomePage();
        selenideHomePage.checkURL();
        selenideHomePage.checkSupportOfUkraine();
        SelenideBlogPage selenideBlogPage = new SelenideBlogPage();
        selenideBlogPage.searchBlog();
        selenideBlogPage.getCurrentBlogURL();
    }
}
