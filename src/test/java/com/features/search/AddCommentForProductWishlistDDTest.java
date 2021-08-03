package com.features.search;

import com.Utils.Constants;
import com.steps.serenity.*;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/resource/addCommentForProductWl.csv")
public class AddCommentForProductWishlistDDTest {

    @Managed(uniqueSession = true)
    private WebDriver webdriver;

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private SearchSteps searchSteps;
    @Steps
    private WishlistSteps wishlistSteps;
    @Steps
    private CartSteps cartSteps;

    private String category;
    private String subcategory;
    private String productName;
    private String comment;


    @Test
    public void enterCommentForAProduct(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.EMAIL, Constants.PASS);
        headerSteps.navigateToSubcategory(category,subcategory);
        searchSteps.addProductToWishlist(productName);
        wishlistSteps.updateProductInWishList(productName,comment);
        wishlistSteps.verifyIfCommentIsDisplayed(comment);
    }



}
