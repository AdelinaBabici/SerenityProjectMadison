package com.features;

import com.utils.Constants;
import com.steps.serenity.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CheckoutTest extends BaseTest {
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
    @Steps
    private MagentoSteps magentoSteps;

    @Test
    public void placeAnOrder() throws InterruptedException {
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.USER_TO_UPDATE_USERNAME, Constants.USER_TO_UPDATE_PASSWORD);
        headerSteps.navigateToSubcategory("WOMEN", "NEW ARRIVALS");
        productsSeps.clickOnAProduct("TORI TANK");
        productsSeps.addToCart("indigo", "m", "1");
        cartSteps.clickOnCheckoutButton();
        checkoutSteps.saveBillingAddress();
        checkoutSteps.saveShippingMethod();
        checkoutSteps.savePaymentInformation();
        checkoutSteps.placeOrder();
        checkoutSteps.verifyOrderPlaceMessage();

    }
    @Test
    public void verifyQuantityOfAProductInMagento(){
        magentoSteps.navigateToMagentoLoginPage();
        magentoSteps.loginWithCredentials(Constants.USER_NAME_MAGENTO, Constants.PASSWORD_MAGENTO);
        magentoSteps.navigateThroughCategories("Catalog", "Manage Products");
        magentoSteps.addProduct("Clothing", "Pink dress", "beautiful","beauty");
        magentoSteps.addProductCaracteristics("Dress", "2","Enabled" );

    }
}
