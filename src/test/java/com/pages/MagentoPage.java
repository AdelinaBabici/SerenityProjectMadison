package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//*[@id='reviwGrid_table']/tbody/tr[2]")
    private List<WebElementFacade> pendingReview;

    @FindBy(css = "a[href*='edit/ret/pending'")
    private WebElementFacade reviewEditLink;

    @FindBy(css = "#reviwGrid_table > tbody > tr:nth-child(1)")
    private List<WebElementFacade> reviewContainer;

    @FindBy(css = "#status_id")
    private WebElementFacade statusReviewDropdownlist;

    @FindBy(css = "button[onclick*='editForm.submit();'")
    private WebElementFacade saveReviewButton;


    @FindBy(className = "review-meta")
    private WebElementFacade reviewSection;

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

    public void hoverOverReviewsAndRatings(String category) {
        actions = new Actions(getDriver());
        for (WebElement cat : headline) {
            if (cat.getText().equalsIgnoreCase(category)) {
                actions.moveToElement(cat).perform();
            }
        }
    }

    public void navigateThroughCategories(String... pathNodes) {
        Actions actions = new Actions(getDriver());

        for (int i = 0; i < pathNodes.length; i++) {
            WebElement currentElement = getDriver().findElement(By.xpath("//ul/li[a/span[text()='" + pathNodes[i] + "']]"));
            actions.moveToElement(currentElement).perform();
            actions.click().perform();


        }

    }

    public void clickOnPendingReview(String product) {
        getReviewContainer(product).findElement(org.openqa.selenium.By.cssSelector("#reviwGrid_table > tbody > tr:nth-child(1) > td:nth-child(9)")).click();
    }

    public WebElement getReviewContainer(String name) {
        for (WebElement product : reviewContainer) {
            if (product.findElement(org.openqa.selenium.By.cssSelector("#reviwGrid_table > tbody > tr:nth-child(1) > td:nth-child(9)")).getText().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }


    public WebElement approveReview(String text) {
        Select oselect = new Select(statusReviewDropdownlist);
        // findByField.selectByVisibleText(text);
        List<WebElement> status = oselect.getOptions();
        for (WebElement approve : status) {
            if (approve.getText().equalsIgnoreCase(text)) {
                approve.click();
                return approve;

            }

        }
        return null;

    }

    public void clickOnSaveReviewButton() {
        clickOn(saveReviewButton);
    }

    public boolean verifyPresenceOfReview(String name) {
        return reviewSection.containsText(name);
    }
}







