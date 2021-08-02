package com.steps.serenity;

import com.pages.*;
import com.sun.org.apache.xalan.internal.templates.Constants;
import net.thucydides.core.annotations.Step;
import org.seleniumhq.jetty9.server.HomeBaseWarning;

public class WishlistSteps {
    private DashboardPage dashboardPage;
    private WishlistPage wishlistPage;
    private ProductPage productPage;
    private LoginPage loginPage;


    @Step
    public void clickOnAddToWishlistLinks(){
        productPage.clickOnAddToWishlistLink();
    }



    @Step
    public void verifyPresenceOfProductInWishlist(String value){
       wishlistPage.isProductDisplayedOnWishlistPage(value);
    }
}
