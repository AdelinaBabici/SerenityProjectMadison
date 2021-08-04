package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{

    @FindBy(css = "#wishlist-table tr[id]")
    private List<WebElement> wishlistProducts;

    @FindBy(css = "a[href*='http://qa2.dev.evozon.com/wishlist/index/configure/'")
    private WebElementFacade editButton;

    @FindBy(css = ".cart-cell input[class*='input-text qty validate-not-negative-number'")
    private WebElement updatedQuantity;

    @FindBy(css = "textarea[title*='Comment'")
    private WebElementFacade commentsSection;
    @FindBy(css = "button[title*='Update Wishlist'")
    private WebElementFacade updateButton;
    @FindBy(css = ".cart-cell button[title*='Add to Cart")
    private WebElementFacade addToCartButton;
    @FindBy(css = "table[id*='wishlist-table'] tbody tr")
    private List<WebElement> productContainers;
    @FindBy(css = "td[class*='wishlist-cell1 customer-wishlist-item-info'")
    private List<WebElement> commentContainer;

    public void isProductDisplayedOnWishlistPage(String productName) {
        boolean isProductFound = false;
        for (WebElement product :  wishlistProducts) {
            if (product.findElement(By.cssSelector("h3 a")).getText().equalsIgnoreCase(productName)) {
                isProductFound = true;
                break;
            }
        }
    }
public void clickOnEditButtonForProduct(String product){
    getWishlistProductContainer(product).findElement(By.cssSelector("a[class*='link-edit button button-secondary'")).click();
}
    public WebElement getWishlistProductContainer(String name){
        for (WebElement product : productContainers) {
            if (product.findElement(By.cssSelector("h3 a")).getText().equals(name)) {
                return product;
            }
        }
        return null;
    }


    public boolean isQuantityChanged(String quantity){
        return updatedQuantity.getAttribute("value").equals(quantity);
    }


    public void clickOnUpdateWishlistButton(){
        clickOn(updateButton);
    }
    public boolean isCommentIsDisplayed(String comment){
        return commentsSection.containsOnlyText(comment);

    }
    public void clickOnAddToCartBtn(){
        clickOn(addToCartButton);
    }

    public void getWishlistCommentContainer(String name, String commentForProduct){
        for (WebElement comment : commentContainer) {
            if (comment.findElement(By.cssSelector("h3 a")).getText().equals(name)) {
                typeInto(commentsSection,commentForProduct);
                break;
            }
        }

    }

}
