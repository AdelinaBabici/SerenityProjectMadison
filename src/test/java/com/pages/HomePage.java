package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa2.dev.evozon.com/")
public class HomePage extends BasePage {

    @FindBy(css = "a[href*='/account'] .label")
    private WebElementFacade accountLink;

    @FindBy(css = "a[title='Log In']")
    private WebElementFacade loginLink;

    @FindBy(id = "search")
    private WebElementFacade searchField;
    @FindBy(css = "button[title*='Search'")
    private WebElementFacade searchIcon;

    @FindBy(css = "a[title='Register']")
    private WebElementFacade registerLink;

    @FindBy(css ="a[href*='/changepass']")
    private WebElementFacade changePassword;

    public void clickMyAccount() {
        clickOn(accountLink);
    }

    public void clickLoginLink() {
        clickOn(loginLink);
    }

    public void searchAProduct(String text) {
        typeInto(searchField, text);
    }

    public void clickOnSearchIcon() {
        clickOn(searchIcon);
    }

    public void clickRegisterLink() {
        clickOn(registerLink);
    }
//    public void clickChangePassword(){
//        clickOn(changePassword);
    }

