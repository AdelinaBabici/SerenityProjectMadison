package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{

    @FindBy(css = ".qty-wrapper input[id*='qty'")
    private WebElementFacade qtyInput;
    @FindBy(css = "a[href*='updateItemOptions'")
    private WebElementFacade updateWishlistLink;


    public void changeCurrentQuantity(String qty){
        qtyInput.clear();
        typeInto(qtyInput, qty);
    }

    public void clickOnUpdateWishlistLink(){
        clickOn(updateWishlistLink);
    }
}
