package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{

    @FindBy(css = "#wishlist-table tr[id]")
    private List<WebElement> wishlistProducts;

    @FindBy(css = "a[href*='http://qa2.dev.evozon.com/wishlist/index/configure/'")
    private WebElementFacade editBtn;

    @FindBy(css = ".cart-cell input[class*='input-text qty validate-not-negative-number'")
    private WebElement updatedQty;

    @FindBy(css = "textarea[title*='Comment'")
    private WebElementFacade commentsSection;
    @FindBy(css = "button[title*='Update Wishlist'")
    private WebElementFacade updateBtn;
    @FindBy(css = ".cart-cell button[title*='Add to Cart")
    private WebElementFacade addToCartBtn;

    public void isProductDisplayedOnWishlistPage(String productName) {
        boolean productFound = false;
        for (WebElement el :  wishlistProducts) {
            if (el.findElement(By.cssSelector("h3 a")).getText().equals(productName)) {
                productFound = true;
                break;
            }
        }
    }


    public void clickOnEditButton(){
        clickOn(editBtn);
    }

    public boolean isQuantityChanged(String qty){
        return updatedQty.getAttribute("value").equals(qty);
    }

    public void enterCommentForAProduct(String comment){
        commentsSection.clear();
        typeInto(commentsSection,comment);
    }
    public void clickOnUpdateWishlistButton(){
        clickOn(updateBtn);
    }
    public boolean verifyIfCommentIsDisplayed(String comment){
        return commentsSection.containsOnlyText(comment);

    }
    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
    }
}
