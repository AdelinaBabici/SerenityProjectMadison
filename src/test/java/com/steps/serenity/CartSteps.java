package com.steps.serenity;

import com.pages.CartPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps {
    private CartPage cartPage;

    @Step
    public void verifyPresenceOfProductInCart(String name){
        Assert.assertTrue(cartPage.verifyPresenceOfProduct(name));
    }
}
