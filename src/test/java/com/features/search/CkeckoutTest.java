package com.features.search;

import com.Utils.Constants;
import com.steps.serenity.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CkeckoutTest extends BaseTest {
    @Steps
    private ProductsSeps productsSeps;

    @Steps
    private HeaderSteps headerSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private ProductDetailsSteps productDetailsSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CheckoutSteps checkoutSteps;

    @Test
    public void placeAnOrder() throws InterruptedException {
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.USER_TO_UPDATE_USERNAME, Constants.USER_TO_UPDATE_PASSWORD);
        headerSteps.navigateToSubcategory("WOMEN", "NEW ARRIVALS");
        productsSeps.clickOnAProduct("TORI TANK");
        productsSeps.addToCart("indigo", "m", "1");
        cartSteps.clickOnCheckoutBtn();
        checkoutSteps.saveBillingAddress();
        checkoutSteps.saveShippingMethod();
        checkoutSteps.savePaymentInformation();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyOrderPlaceMessage();
    }
}
