package com.steps.serenity;

import com.pages.CartPage;
import net.thucydides.core.annotations.Step;

public class CartSteps {
    private CartPage cartPage;

    @Step
    public void verifyPresenceOfProductInCart(String name){
        cartPage.verifyPresenceOfProduct(name);
    }
}
