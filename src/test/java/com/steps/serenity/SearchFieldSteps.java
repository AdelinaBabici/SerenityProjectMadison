package com.steps.serenity;

import com.pages.HomePage;
import com.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchFieldSteps {

    private HomePage homePage;
    private SearchPage searchPage;

    @Step
    public void  search(){
        homePage.searchAProduct("top");
        homePage.clickOnSearchIcon();
    }

    @Step
    public void verifySearchResults(){
        Assert.assertTrue("the search aren t displayed", searchPage.productCategoryIsDisplayed());
    }
}
