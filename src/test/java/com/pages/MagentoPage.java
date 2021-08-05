package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class MagentoPage extends BasePage {

    @FindBy(id = "username")
    private WebElementFacade usernameField;

    @FindBy(id = "login")
    private WebElementFacade passwordField;

    @FindBy(css = "input[value='Login']")
    private WebElementFacade loginButton;

    @FindBy(css = "#message-popup-window > div.message-popup-head > a")
    private WebElementFacade popupMessage;

    @FindBy(xpath = "//*[@id='nav']/li/a/span")
    private List<WebElementFacade> headline;

    @FindBy(css = "#nav ul li.level1")
    private List<WebElementFacade> reviewAndRatings;

    @FindBy(css = "#nav > li.active.parent.level0 > ul > li:nth-child(6) > ul > li.parent.level2 > a")
    private WebElementFacade customersReviews;

    @FindBy(css = "#nav > li.active.parent.level0 > ul > li:nth-child(6) > ul > li.parent.level2 > ul > li:nth-child(1) > a > span")
    private WebElementFacade pendingReviews;

    @FindBy(css = "#reviwGrid_table > tbody > tr.even.pointer.on-mouse > td.last > a")
    private WebElementFacade editLink;


    public void setUsernameField(String userName) {
        typeInto(usernameField, userName);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void closePopupMessage() {
        clickOn(popupMessage);
    }

    Actions actions;

    public void hoverOverCatalog(String categoryName) {
        actions = new Actions(getDriver());
        for (WebElement category : headline) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                actions.moveToElement(category).perform();
                    break;
                }

            }
        }

        public void hoverOverReviewsAndRatings (String category){
            actions = new Actions(getDriver());
            for (WebElement cat : headline) {
            if (cat.getText().equalsIgnoreCase(category)) {
                actions.moveToElement(cat).perform();
            }
        }
//
//        public void hoverOverCustomerReviews (String categoryName){
//            actions = new Actions(getDriver());
//            if (customersReviews.getText().equalsIgnoreCase(categoryName)) {
//                actions.moveToElement(customersReviews);
//            }
//        }
//        public void hoverOverPendingReviews (String categoryName){
//            if (pendingReviews.getText().equalsIgnoreCase(categoryName)) {
//                clickOn(pendingReviews);
//            }
        }
    public void navigateThroughCategories(String... pathNodes) {
        Actions actions = new Actions(getDriver());
        for (int i = 0; i < pathNodes.length - 1; i++) {
           WebElement currentElement=getDriver().findElement(By.xpath("//ul/li[a/span[text()='" + pathNodes[i] + "']]"));
            actions.moveToElement(currentElement).perform();
        }
    }
    }







