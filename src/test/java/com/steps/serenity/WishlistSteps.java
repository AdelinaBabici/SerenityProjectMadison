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
    private String qty;
    private String productName;
    private String qtyy;

    @Step
    public void verifyPresenceOfProductInWishlist(String value){
       wishlistPage.isProductDisplayedOnWishlistPage(value);
    }
    @Step
    public void editQuantityInWishlist(String qty, String name){
       wishlistPage.clickOnEditButtonForProduct(name);
        productDetailPage.changeCurrentQuantity(qty);
        productDetailPage.clickOnUpdateWishlistLink();

    }
    @Step
    public void editAndVerifyQtyOfAProduct(){
        editQuantityInWishlist(qty,productName);
        verifyIfQuantityIsChanged(qtyy);
    }
    @Step
    public void verifyIfQuantityIsChanged(String qty){
        Assert.assertTrue(wishlistPage.isQuantityChanged(qty));
    }
    @Step
    public void updateProductInWishList(String name,String comment){
        wishlistPage.getWishlistCommentContainer(name,comment);
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
