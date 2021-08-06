package com.features;

import com.steps.serenity.*;
import com.utils.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class ReviewsTest extends BaseTest {

    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private ProductDetailsSteps productDetailsSteps;
    @Steps
    private ProductsSeps productsSeps;
    @Steps
    private MagentoSteps magentoSteps;

    @Test
    public void writeAReviewForAProduct() {

        headerSteps.navigateToSubcategory("ACCESSORIES", "EYEWEAR");
        productsSeps.clickOnAProduct("AVIATOR SUNGLASSES");
        productDetailsSteps.clickOnAddAReviewLink();
        productDetailsSteps.setReviewRating("QUALITY", 3);
        productDetailsSteps.setReviewRating("PRICE", 4);
        productDetailsSteps.setReviewRating("VALUE", 1);
        productDetailsSteps.reviewProduct("beautiful product(color, type)", "beautiful", "ada");
        productDetailsSteps.clickOnSubmitReviewButton();
        magentoSteps.navigateToMagentoLoginPage();
        magentoSteps.loginWithCredentials(Constants.USER_NAME_MAGENTO, Constants.PASSWORD_MAGENTO);
        magentoSteps.navigateThroughCategories("Catalog", "Reviews and Ratings", "Customer Reviews", "Pending Reviews");
        magentoSteps.addReviewStatus("AVIATOR SUNGLASSES", "Approved");
        magentoSteps.navigateToMadisonPage();
        headerSteps.navigateToSubcategory("ACCESSORIES", "EYEWEAR");
        productsSeps.clickOnAProduct("AVIATOR SUNGLASSES");
        productDetailsSteps.clickOnAddAReviewLink();
        magentoSteps.verifyPresenceOfReviewInReviewsSection("ADA");

    }

}
