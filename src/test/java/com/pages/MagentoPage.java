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

    @FindBy(css = "button[title*='Add Product'")
    private WebElementFacade addProductButton;

    @FindBy(css = "select[id='attribute_set_id']")
    private WebElementFacade attributeSetDropdownlist;

    @FindBy(css ="button[title='Continue']")
    private WebElementFacade continueButton;

    @FindBy(css = "input[id='name']")
    private WebElementFacade nameInput;

    @FindBy(css = "textarea[name='product[description]']")
    private WebElementFacade descriptionInput;

    @FindBy(css = "textarea[name='product[short_description]']")
    private WebElementFacade shortDescriptionInput;

    @FindBy(css ="input[name='product[sku]']")
    private WebElementFacade SKUInput;

    @FindBy(css = "input[name='product[weight]']")
    private WebElementFacade weightInput;

    @FindBy(css= "select[id='status']")
    private WebElementFacade statusDropdownlist;


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

    public void clickAddProductButton() {
        clickOn(addProductButton);
    }

    public WebElement setAttribute(String text) {
        Select oselect = new Select(attributeSetDropdownlist);
        // findByField.selectByVisibleText(text);
        List<WebElement> attributes = oselect.getOptions();
        for (WebElement attribute : attributes) {
            if (attribute.getText().equalsIgnoreCase(text)) {
                attribute.click();
                return attribute;

            }
        }
        return null;
    }
    public void clickOnContinueButton(){
        clickOn(continueButton);
    }
    public void addNameToProduct(String name){
        typeInto(nameInput, name);

    }
    public void addDescriptionToProduct(String description){
        typeInto(descriptionInput, description);
    }
    public void addShortDescriptionToProduct(String shortdescription){
        typeInto(shortDescriptionInput, shortdescription);
    }
    public void addSKUToProduct(String sku){
        typeInto(SKUInput, sku);
    }
    public void addWeightToProduct(String weight){
        typeInto(weightInput, weight);
    }
    public WebElement setStatus(String text) {
        Select oselect = new Select(statusDropdownlist);
        // findByField.selectByVisibleText(text);
        List<WebElement> attributes = oselect.getOptions();
        for (WebElement attribute : attributes) {
            if (attribute.getText().equalsIgnoreCase(text)) {
                attribute.click();
                return attribute;

            }
        }
        return null;
    }

}







