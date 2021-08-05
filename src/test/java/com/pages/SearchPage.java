package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(className = "category-products")
    private WebElementFacade categorySection;

    @FindBy(css = " h2[class*='product-name'")
    private WebElementFacade productsDisplayed;

    @FindBy(css = ".products-grid>li")
    private List<WebElement> productsContainers;

    @FindBy(className = "note-msg")
    private WebElementFacade noResultsMessage;

    public WebElement getResultedProductContainer(String productName) {

        for (WebElement product : productsContainers) {
            if (product.findElement(By.cssSelector("h2[class*='product-name'")).getText().equals(productName)) {
                return product;
            }
        }
        return null;
    }


    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }

    public void addProductToWishlist(String name) {
        getResultedProductContainer(name).findElement(By.className("link-wishlist")).click();
    }
}
