package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(className = "category-products")
    private WebElementFacade categorySection;

    @FindBy(css =" h2[class*='product-name'")
    private WebElement productsDisplayed;
    @FindBy(css=".products-grid>li")
    private List<WebElement> productsContainers;

    public WebElement getResultedProductContainer(String productName){

        for (WebElement el : productsContainers) {
            if (el.findElement(By.cssSelector("h2[class*='product-name'")).getText().equals(productName)) {
                return el;
            }
        }
        return null;
    }

    public boolean productCategoryIsDisplayed(){
        return categorySection.isDisplayed();
    }
public void addProductToWoshlist(String name){
        getResultedProductContainer(name).findElement(By.className("link-wishlist")).click();
}
}
