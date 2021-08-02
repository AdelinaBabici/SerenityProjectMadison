package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.security.krb5.internal.PAForUserEnc;

public class ProductPage extends BasePage{

    @FindBy(className = "link-wishlist")
    private WebElementFacade linkWishlist;

    public void clickOnAddToWishlistLink(){
      clickOn(linkWishlist);
    }
}
