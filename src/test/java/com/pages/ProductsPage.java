package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

    @FindBy(className = "link-wishlist")
    private WebElementFacade linkWishlist;


    public void clickOnAddToWishlistLink(){
      clickOn(linkWishlist);
    }


}