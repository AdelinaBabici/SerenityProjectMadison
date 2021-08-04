package com.steps.serenity;

import com.pages.ProductDetailPage;
import com.pages.ProductsPage;
import net.thucydides.core.annotations.Step;

public class ProductDetailsSteps {
    private ProductDetailPage productDetailPage;
    private ProductsPage productsPage;
    @Step
    public void setReviewRating(String criteria, int nrStars){
        productDetailPage.setReviewRating(criteria,nrStars);
    }

    @Step
    public void clickOnAddAReviewLink(){
        productDetailPage.clickOnAddAReviewLink();
    }

    @Step
    public void reviewProduct(String comment, String summary, String nickname){
        productDetailPage.writeReviewForAProduct(comment);
        productDetailPage.writeSummaryOfReview(summary);
        productDetailPage.enterNicknameForReview(nickname);
    }
    @Step
    public void clickOnSubmitReviewButton(){
        productDetailPage.clickOnSubmitReviewBtn();
    }

    @Step
    public void verifyMessageOfReviewApproval(String message){
        productDetailPage.isMessageOfReviewApprovalDisplayed(message);
    }

    @Step
    public void verifyValidationMessage(String msg){
        productDetailPage.isValidationMessageDisplayed(msg);
    }

}
