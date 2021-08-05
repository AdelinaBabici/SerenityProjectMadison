package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductDetailPage extends BasePage {

    @FindBy(css = ".qty-wrapper input[id*='qty'")
    private WebElementFacade quantityInput;

    @FindBy(css = "a[href*='updateItemOptions'")
    private WebElementFacade updateWishlistLink;

    @FindBy(css = "a[href*='review-form'")
    private WebElementFacade addAReviewLink;

    @FindBy(css = "#product-review-table tbody tr")
    private List<WebElement> reviewCriteriaRows;

    @FindBy(css = "textarea[name='detail'")
    private WebElementFacade reviewSection;

    @FindBy(css = "input[id='summary_field'")
    private WebElementFacade summaryOfReview;

    @FindBy(css = "input[id='nickname_field'")
    private WebElementFacade nicknameForReview;

    @FindBy(css = "button[title='Submit Review'")
    private WebElementFacade submitReviewButton;

    @FindBy(css = "li[class='success-msg'")
    private WebElementFacade successMessage;

    @FindBy(id = "advice-required-entry-attribute92")
    private WebElementFacade validationAdvice;


    public void changeCurrentQuantity(String quantity) {
        quantityInput.clear();
        typeInto(quantityInput, quantity);
    }

    public void clickOnUpdateWishlistLink() {
        clickOn(updateWishlistLink);
    }

    public void clickOnAddAReviewLink() {
        clickOn(addAReviewLink);
    }

    public void setReviewRating(String criteria, int nrStars) {
        for (WebElement criteriaRow : reviewCriteriaRows) {
            if (criteriaRow.findElement(By.cssSelector("th")).getText().equalsIgnoreCase(criteria)) {
                criteriaRow.findElement(By.cssSelector("input[id*='" + nrStars + "']")).click();
                break;
            }

        }
    }

    public void writeReviewForAProduct(String comment) {
        typeInto(reviewSection, comment);
    }

    public void writeSummaryOfReview(String comment) {
        typeInto(summaryOfReview, comment);
    }

    public void enterNicknameForReview(String nickname) {
        typeInto(nicknameForReview, nickname);
    }

    public void clickOnSubmitReviewBtn() {
        clickOn(submitReviewButton);
    }

    public void isMessageOfReviewApprovalDisplayed(String message) {
        Assert.assertTrue("Review has not been approved", receiveValidMsg(message));
    }

    public boolean receiveValidMsg(String message) {
        boolean isValidMsg = false;
        if (successMessage.getText().contains(message)) {
            return isValidMsg = true;
        } else {
            return false;
        }

    }

    public boolean receiveValidationMessage(String message) {
        boolean isValidMsg = false;
        if (validationAdvice.getText().contains(message)) {
            return isValidMsg = true;
        } else {
            return false;
        }
    }

    public void isValidationMessageDisplayed(String message) {
        Assert.assertTrue("Validation messaged is not diplayed.", receiveValidationMessage(message));


    }
}
