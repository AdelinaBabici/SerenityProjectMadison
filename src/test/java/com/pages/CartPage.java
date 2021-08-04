package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "product-cart-info")
    private List<WebElement> productInfo;

    @FindBy(className = "method-checkout-cart-methods-onepage-bottom")
    private WebElementFacade proceedToCheckoutButton;



    public boolean verifyPresenceOfProduct(String name) {
        boolean isProductFound = false;
        for (WebElement productName : productInfo) {
            if (productName.findElement(By.cssSelector("h2 a")).getText().equals(name)) {
                return isProductFound = true;
            }
        }
        return isProductFound;
    }
    public void clickOnCheckoutButton(){
        clickOn(proceedToCheckoutButton);
    }


}
