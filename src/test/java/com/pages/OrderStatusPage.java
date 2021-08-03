package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OrderStatusPage extends BasePage{

    @FindBy(css = "h1")
    private WebElementFacade orderID;

    public boolean isOrderIdDisplayed(String id){
        return orderID.containsOnlyText("ORDER #" + id + " - COMPLETE");

    }
}
