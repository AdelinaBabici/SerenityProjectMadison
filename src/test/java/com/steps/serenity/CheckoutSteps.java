package com.steps.serenity;

import com.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class CheckoutSteps {

    private CheckoutPage checkoutPage;


    @Step
    public void saveBillingAddress() {
        checkoutPage.clickOnShipToThisAddress();
        checkoutPage.clickOnContinueButton();
    }

    @Step
    public void saveShippingMethod() throws InterruptedException {
       // checkoutPage.clickOnFreeShipping();
        checkoutPage.clickOnShippingContinueButton();
    }

    @Step
    public void savePaymentInformation() {
        checkoutPage.clickOnPaymentContinueButton();
    }

    @Step
    public void placeOrder() {
        checkoutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void verifyOrderPlaceMessage() {
        Assert.assertTrue(checkoutPage.verifyOrderPlaceMessage());
    }
}
