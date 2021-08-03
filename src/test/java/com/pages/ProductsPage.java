package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(className = "link-wishlist")
    private WebElementFacade linkWishlist;
    @FindBy(css = "h2 a")
    private List<WebElement> products;


    public void clickOnAddToWishlistLink(){
      clickOn(linkWishlist);
    }

    public void clickOnAProduct(String productName){
        for(WebElement el: products){
            if(el.getText().contains(productName)){
                el.click();
                break;
            }
        }
    }

}
