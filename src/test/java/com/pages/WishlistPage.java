package com.pages;

import com.gargoylesoftware.htmlunit.WaitingRefreshHandler;
import net.serenitybdd.core.pages.WebElementFacade;
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
    @FindBy(css = "table[id*='wishlist-table'] tbody tr")
    private List<WebElement> productContainers;
    @FindBy(css = "td[class*='wishlist-cell1 customer-wishlist-item-info'")
    private List<WebElement> commentContainer;

    public void isProductDisplayedOnWishlistPage(String productName) {
        boolean productFound = false;
        for (WebElement el :  wishlistProducts) {
            if (el.findElement(By.cssSelector("h3 a")).getText().equalsIgnoreCase(productName)) {
                productFound = true;
                break;
            }
        }
    }
public void clickOnEditButtonForProduct(String product){
    getWishlistProductContainer(product).findElement(By.cssSelector("a[class*='link-edit button button-secondary'")).click();
}
    public WebElement getWishlistProductContainer(String name){
        for (WebElement el : productContainers) {
            if (el.findElement(By.cssSelector("h3 a")).getText().equals(name)) {
                return el;
            }
        }
        return null;
    }


    public boolean isQuantityChanged(String qty){
        return updatedQty.getAttribute("value").equals(qty);
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

    public void getWishlistCommentContainer(String name, String comment){
        for (WebElement el : commentContainer) {
            if (el.findElement(By.cssSelector("h3 a")).getText().equals(name)) {
                typeInto(commentsSection,comment);
                break;
            }
        }

    }

}
