package com.features.search;

import com.Utils.Constants;
import com.steps.serenity.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class WishlistTest extends BaseTest{

    @Steps
    private WishlistSteps wishlistSteps;
    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private SearchSteps searchSteps;
    @Steps
    private BaseSteps baseSteps;
    @Steps
    private CartSteps cartSteps;

    @Test
    public void addProductToWishlist(){
        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
        searchSteps.addProductToWishlist("AVIATOR SUNGLASSES");
        loginSteps.loginWithCredentials(Constants.EMAIL,Constants.PASS);
        wishlistSteps.verifyPresenceOfProductInWishlist("AVIATOR SUNGLASSES");
    }

    @Test
    public void editQuantityOfAProductInWishList(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.EMAIL, Constants.PASS);
        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
        searchSteps.addProductToWishlist("AVIATOR SUNGLASSES");
        wishlistSteps.editQuantityInWishlist("5","AVIATOR SUNGLASSES");
        wishlistSteps.verifyIfQuantityIsChanged("5");


    }
    @Test
    public void enterCommentForAProduct(){

        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.EMAIL, Constants.PASS);
        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
        searchSteps.addProductToWishlist("AVIATOR SUNGLASSES");
        wishlistSteps.updateProductInWishList("beautiful");
        wishlistSteps.verifyIfCommentIsDisplayed("beautiful");
    }

    @Test
    public void addProductFromWishlistToCart(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.EMAIL, Constants.PASS);
        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
        searchSteps.addProductToWishlist("AVIATOR SUNGLASSES");
        wishlistSteps.addProductToCart();
        cartSteps.verifyPresenceOfProductInCart("AVIATOR SUNGLASSES");

    }

}
