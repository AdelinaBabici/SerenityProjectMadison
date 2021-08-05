package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage {

    @FindBy(css = "a[title*='Orders'")
    private WebElementFacade ordersAndReturnsLink;

    public void clickOnOrdersAndReturnsLink() {
        clickOn(ordersAndReturnsLink);
    }
}
