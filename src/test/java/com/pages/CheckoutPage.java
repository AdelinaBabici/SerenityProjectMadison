package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import static com.utils.Constants.TIMEOUT;

public class CheckoutPage extends BasePage {

    @FindBy(css = "input[title='Ship to this address']")
    private WebElementFacade shipToThisAddressRadioButton;

    @FindBy(css = "button[onclick='billing.save()'")
    private WebElementFacade billingContinueButton;

    @FindBy(css = "input[id='s_method_freeshipping_freeshipping']")
    private WebElementFacade freeShippingRadioButton;

    @FindBy(css = "button[onclick='shippingMethod.save()'")
    private WebElementFacade shippingContinueButton;

    @FindBy(css = "#payment-buttons-container > button")
    private WebElementFacade paymentContinueButton;

    @FindBy(css = "#review-buttons-container > button")
    private WebElementFacade placeOrderButton;

    @FindBy(css = "div > h2")
    private WebElementFacade placeOrderMessage;

    public void clickOnShipToThisAddress() {
        clickOn(shipToThisAddressRadioButton);
    }

    public void clickOnContinueButton() {
        clickOn(billingContinueButton);
    }

    public void clickOnFreeShipping() {
        //freeShippingRadioButton.waitUntilEnabled();
        clickOn(freeShippingRadioButton);
    }

    public void clickOnShippingContinueButton() {
        clickOn(shippingContinueButton);
    }

    public void clickOnPaymentContinueButton() {
        clickOn(paymentContinueButton);

    }

    public void clickOnPlaceOrderButton() {
        clickOn(placeOrderButton);

    }

    public boolean verifyOrderPlaceMessage() {
        waitForTextToAppear("THANK YOU FOR YOUR PURCHASE!", TIMEOUT);
        return placeOrderMessage.containsText("THANK YOU FOR YOUR PURCHASE!");


    }
}
