package com.steps.serenity;

import com.pages.HeaderPage;
import net.thucydides.core.annotations.Step;

public class HeaderSteps {
    private HeaderPage headerPage;
    @Step
    public void navigateToSubcategory(String category, String subcategory){
        headerPage.clickOnACategory(category);
        headerPage.clickOnASubcategry(subcategory);
    }
}
