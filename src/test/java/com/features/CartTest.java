package com.features;

import com.steps.serenity.CartSteps;
import com.steps.serenity.HeaderSteps;
import com.steps.serenity.ProductDetailsSteps;
import com.steps.serenity.ProductsSeps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Steps
    private ProductsSeps productsSeps;
    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private CartSteps cartSteps;
    @Steps
    private ProductDetailsSteps productDetailsSteps;

    @Test
    public void addToCart() {
        headerSteps.navigateToSubcategory("WOMEN", "NEW ARRIVALS");
        productsSeps.clickOnAProduct("TORI TANK");
        productsSeps.addToCart("indigo", "m", "1");
        cartSteps.verifyPresenceOfProductInCart("TORI TANK");
    }

    @Test
    public void addToCartProductWithoutCaracteristics() {
        headerSteps.navigateToSubcategory("MEN", "NEW ARRIVALS");
        productsSeps.clickOnAProduct("LINEN BLAZER");
        productsSeps.clickAddToCartButton();
        productDetailsSteps.verifyValidationMessage("This is a required field.");

    }
}
