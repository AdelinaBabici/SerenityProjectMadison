package com.steps.serenity;

import com.pages.HomePage;
import com.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps {
    SearchPage searchPage;
    private HomePage homePage;

    private String searchKeyword;
    private String searchResult;

    @Step
    public void addProductToWishlist(String name) {
        searchPage.addProductToWishlist(name);
    }

    @Step
    public void searchAndVerifyResult() {
        searchInput(searchKeyword);
        verifySearchResults(searchResult);
    }

    @Step
    public void searchInput(String keyword) {
        homePage.searchAProduct(keyword);
        homePage.clickOnSearchIcon();
    }

    @Step
    public void verifySearchResults(String value) {
        Assert.assertTrue("products aren`t displayed", searchPage.getResultedProductContainer(value).isDisplayed());
    }

    @Step
    public void verifyNoResultsMessage() {
        Assert.assertTrue("The no results message is not display",
                searchPage.getNoResultsMessage().equals("Your search returns no results."));
    }
}
