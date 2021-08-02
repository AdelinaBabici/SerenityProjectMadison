package com.steps.serenity;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.WishlistPage;
import net.thucydides.core.annotations.Step;

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
