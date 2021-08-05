package com.features;

import com.utils.Constants;
import com.steps.serenity.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;


@RunWith(SerenityRunner.class)
public class DdtWishlistTest extends BaseTest {

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


    @Test
    public void editQtyOfProduct() throws Throwable {
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.EMAIL, Constants.PASS);
        headerSteps.navigateToSubcategory("ACCESSORIES", "EYEWEAR");
        searchSteps.addProductToWishlist("AVIATOR SUNGLASSES");
        withTestDataFrom("src/resource/editQtyofProduct.csv").run(wishlistSteps).editAndVerifyQuantityOfAProduct();
    }

}
