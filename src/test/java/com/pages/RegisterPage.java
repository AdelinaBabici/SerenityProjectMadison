package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElementFacade firstNameField;

    @FindBy(id = "lastname")
    private WebElementFacade lastNameField;

    @FindBy(id = "email_address")
    private WebElementFacade emailAddressField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "confirmation")
    private WebElementFacade confirmPasswordField;

    @FindBy(css = "button[title=\"Register\"]")
    private WebElementFacade registerButton;

    @FindBy(css = ".success-msg span")
    private WebElementFacade registrationConfirmationMessage;

    @FindBy(className = "validation-advice")
    private List<WebElement> validationMessages;

    public void EntryFirstName(String firstName) {
        typeInto(firstNameField, firstName);
    }

    public void EntryLastName(String lastName) {
        typeInto(lastNameField, lastName);
    }

    public void EntryEmail(String email) {
        typeInto(emailAddressField, email);
    }

    public void EntryPassword(String password) {
        typeInto(passwordField, password);
    }

    public void EntryConfirmationPassword(String confirmationPassword) {
        typeInto(confirmPasswordField, confirmationPassword);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public String getConfirmationMessage(){
        return registrationConfirmationMessage.getText();
    }

    public WebElement waitForConfirmationMessage(){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success-msg span")));
    }

    public boolean verifyValidationMessages(String message) {
        boolean isEqual = true;
        for (WebElement element : validationMessages) {
            if (!element.getText().equals(message)) {
                return isEqual = false;
            }
        }
        return isEqual;
    }
}


