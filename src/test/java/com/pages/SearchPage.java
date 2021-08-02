package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(className = "category-products")
    private WebElementFacade categorySection;

    public boolean productCategoryIsDisplayed(){
        return categorySection.isDisplayed();
    }

}
