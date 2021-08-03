package com.steps.serenity;

import com.pages.HomePage;
import com.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchSteps {
    SearchPage searchPage;
    private HomePage homePage;


    @Step public void addProductToWishlist(String name){
        searchPage.addProductToWishlist(name);
    }

    @Step
    public void search(String keyword){
        homePage.searchAProduct(keyword);
        homePage.clickOnSearchIcon();
    }

    @Step
    public void verifySearchResults(String value){
        Assert.assertTrue("products aren`t displayed", searchPage.getResultedProductContainer(value).isDisplayed());
    }
}
