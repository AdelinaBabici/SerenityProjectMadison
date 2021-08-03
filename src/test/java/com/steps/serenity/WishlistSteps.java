package com.steps.serenity;

import com.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import javax.swing.plaf.PanelUI;

public class WishlistSteps {
    private DashboardPage dashboardPage;
    private WishlistPage wishlistPage;
    private ProductsPage productPage;
    private LoginPage loginPage;
    private ProductDetailPage productDetailPage;


    @Step
    public void verifyPresenceOfProductInWishlist(String value){
       wishlistPage.isProductDisplayedOnWishlistPage(value);
    }
    @Step
    public void editQuantityInWishlist(String qty, String name){
       wishlistPage.getWishlistProductContainer(name);
        productDetailPage.changeCurrentQuantity(qty);
        productDetailPage.clickOnUpdateWishlistLink();

    }
    @Step
    public void verifyIfQuantityIsChanged(String qty){
        Assert.assertTrue(wishlistPage.isQuantityChanged(qty));
    }
    @Step
    public void updateProductInWishList(String comment){
        wishlistPage.enterCommentForAProduct(comment);
        wishlistPage.clickOnUpdateWishlistButton();
    }
    @Step
    public void verifyIfCommentIsDisplayed(String text){
        Assert.assertTrue(wishlistPage.verifyIfCommentIsDisplayed(text));
    }

    @Step
    public void addProductToCart(){
        wishlistPage.clickOnAddToCartBtn();
    }
}
