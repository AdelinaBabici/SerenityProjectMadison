package com.features.search;

import com.Utils.Constants;
import com.steps.serenity.HeaderSteps;
import com.steps.serenity.LoginSteps;
import com.steps.serenity.SearchSteps;
import com.steps.serenity.WishlistSteps;
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
    @Test
    public void addProductToWishlist(){
        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
        searchSteps.addProductToWoshlist("AVIATOR SUNGLASSES");
        loginSteps.loginWithCredentials(Constants.EMAIL,Constants.PASS);
        wishlistSteps.verifyPresenceOfProductInWishlist("AVIATOR SUNGLASSES");
    }



}
