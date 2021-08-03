package com.steps.serenity;

import com.pages.ProductsPage;
import net.thucydides.core.annotations.Step;

public class ProductsSeps {

    private ProductsPage productsPage;

    @Step
    public void clickOnAProduct(String name){
        productsPage.clickOnAProduct(name);
    }

    @Step
    public  void addToCart(String color, String size, String quantity){
        productsPage.selectByColorName(color);
        productsPage.selectSizeByName(size);
        productsPage.typeQuantity(quantity);
        productsPage.clickAddToCartButton();
    }

}
