package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "product-cart-info")
    private List<WebElement> cartProduct;

    @FindBy(css = "h2 a")
    private WebElementFacade productFromCart;


    public boolean verifyPresenceOfProduct(String productName) {
        boolean productFound = false;
        for (WebElement el : cartProduct) {
            if (productFromCart.getText().equals(productName)) {
                return productFound = true;
            }
        }
        return productFound;
    }


}
