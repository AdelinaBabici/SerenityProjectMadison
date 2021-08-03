package com.features.search;

import com.steps.serenity.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class ReviewsTest extends BaseTest{
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
    public void writeAReviewForAProduct(){
        headerSteps.navigateToSubcategory("ACCESSORIES","EYEWEAR");
    }

}
