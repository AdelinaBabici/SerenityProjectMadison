package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{

    @FindBy(css = "#wishlist-table tr[id]")
    private List<WebElement> wishlistProducts;

    public void isProductDisplayedOnWishlistPage(String productName) {
        boolean productFound = false;
        for (WebElement el :  wishlistProducts) {
            if (el.findElement(By.cssSelector("h3 a")).getText().equals(productName)) {
                productFound = true;
                break;
            }
        }
    }
}
