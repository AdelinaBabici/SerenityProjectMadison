package com.pages;

import com.gargoylesoftware.htmlunit.WaitingRefreshHandler;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailPage extends BasePage {

    @FindBy(css = ".qty-wrapper input[id*='qty'")
    private WebElementFacade qtyInput;
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
    private WebElementFacade submitReviewBtn;
    @FindBy(css = "li[class='success-msg'")
    private WebElementFacade successMsg;

    @FindBy(id = "advice-required-entry-attribute92")
    private WebElementFacade validationadvice;


    public void changeCurrentQuantity(String qty) {
        typeInto(qtyInput, qty);
    }

    public void clickOnUpdateWishlistLink() {
        clickOn(updateWishlistLink);
    }

    public void clickOnAddAReviewLink() {
        clickOn(addAReviewLink);
    }

    public void setReviewRating(String criteria, int nrStars) {
        for (WebElement el : reviewCriteriaRows) {
            if (el.findElement(By.cssSelector("th")).getText().equalsIgnoreCase(criteria)) {
                el.findElement(By.cssSelector("input[id*='" + nrStars + "']")).click();
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
        clickOn(submitReviewBtn);
    }

    public void isMessageOfReviewApprovalDisplayed(String message) {
        Assert.assertTrue("Review has not been approved", receiveValidMsg(message));
    }

    public boolean receiveValidMsg(String message) {
        boolean validMsg = false;
        if (successMsg.getText().contains(message)) {
            return validMsg = true;
        } else {
            return false;
        }

    }

    public boolean receiveValidationMessage(String message) {
        boolean validMsg = false;
        if (validationadvice.getText().contains(message)) {
            return validMsg = true;
        } else {
            return false;
        }
    }

    public void isValidationMessageDisplayed(String msg) {
        Assert.assertTrue("Validation messaged is not diplayed.", receiveValidationMessage(msg));



    }
}
