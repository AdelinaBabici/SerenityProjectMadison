package com.features.search;

import com.steps.serenity.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class ReviewsTest extends BaseTest{

    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private ProductDetailsSteps productDetailsSteps;
    @Steps
    private ProductsSeps productsSeps;

    @Test
    public void writeAReviewForAProduct(){

        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
        productsSeps.clickOnAProduct("AVIATOR SUNGLASSES");
        productDetailsSteps.clickOnAddAReviewLink();
        productDetailsSteps.setReviewRating("QUALITY",3);
        productDetailsSteps.setReviewRating("PRICE",4);
        productDetailsSteps.setReviewRating("VALUE",1);
        productDetailsSteps.reviewProductWithValidData("beautiful product(color, type)","beautiful", "ada");
        productDetailsSteps.clickOnSubmitReviewButton();
        productDetailsSteps.verifyAcceptedReview("Your review has been accepted for moderation.");
    }

}
