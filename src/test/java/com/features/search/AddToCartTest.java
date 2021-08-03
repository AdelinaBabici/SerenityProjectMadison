package com.features.search;

import com.steps.serenity.CartSteps;
import com.steps.serenity.HeaderSteps;
import com.steps.serenity.ProductsSeps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class AddToCartTest extends  BaseTest{

    @Steps
    private ProductsSeps productsSeps;

    @Steps
    private HeaderSteps headerSteps;

    @Steps
    private CartSteps cartSteps;

    @Test
    public  void AddToCart(){
        headerSteps.navigateToSubcategory("WOMEN","NEW ARRIVALS");
        productsSeps.clickOnAProduct("TORI TANK");
        productsSeps.addToCart("indigo", "m","1");
        cartSteps.verifyPresenceOfProductInCart("TORI TANK");
    }
}
