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
        homePage.searchAProduct("TOP SPRING-WHITE-S");
        homePage.clickOnSearchIcon();
    }

    @Step
    public void verifySearchResults(String value){
        Assert.assertTrue("products aren`t displayed", searchPage.getResultedProductContainer("TOP SPRING-WHITE-S").isDisplayed());
    }
}
