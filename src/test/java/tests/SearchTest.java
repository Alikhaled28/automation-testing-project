package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchTest extends BaseTest {

    @Test(description = "TC01 - Search with valid keyword")
    @Description("Search using a valid Arabic keyword and assert page title")
    public void testSearchWithValidKeyword() {
        HomePage homePage = new HomePage(driver);
        performSearch(homePage, "كيف تنضم إلى البنك");
        Assert.assertTrue(driver.getCurrentUrl().contains("search") ||
                        driver.getTitle().contains("eyouth"),
                "Search results page should be displayed");
    }

    @Step("Enter keyword '{keyword}' and click search")
    private void performSearch(HomePage homePage, String keyword) {
        homePage.searchFor(keyword);
    }
}