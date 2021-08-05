package com.steps.serenity;

import com.pages.*;
import com.pages.ProductsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class WishlistSteps {
    private DashboardPage dashboardPage;
    private WishlistPage wishlistPage;
    private ProductsPage productPage;
    private LoginPage loginPage;
    private ProductDetailPage productDetailPage;
    private String quantity;
    private String productName;
    private String updatedQuantity;

    @Step
    public void verifyPresenceOfProductInWishlist(String value) {
        wishlistPage.isProductDisplayedOnWishlistPage(value);
    }

    @Step
    public void editQuantityInWishlist(String name, String quantity) {
        wishlistPage.clickOnEditButtonForProduct(name);
        productDetailPage.changeCurrentQuantity(quantity);
        productDetailPage.clickOnUpdateWishlistLink();

    }

    @Step
    public void editAndVerifyQuantityOfAProduct() {
        editQuantityInWishlist(quantity, productName);
        verifyIfQuantityIsUpdated(updatedQuantity);
    }

    @Step
    public void verifyIfQuantityIsUpdated(String quantity) {
        Assert.assertTrue(wishlistPage.isQuantityChanged(quantity));
    }

    @Step
    public void commentAProductInWishList(String name, String comment) {
        wishlistPage.getWishlistCommentContainer(name, comment);
        wishlistPage.clickOnUpdateWishlistButton();
    }

    @Step
    public void verifyIfCommentIsDisplayed(String text) {
        Assert.assertTrue(wishlistPage.isCommentIsDisplayed(text));
    }

    @Step
    public void addProductToCart() {
        wishlistPage.clickOnAddToCartButton();
    }
}
