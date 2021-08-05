package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMessage;

    @FindBy(css = ".success-msg span")
    private WebElementFacade confirmationMessage;

    @FindBy(css = "a[href*='/changepass']")
    private WebElementFacade changePassword;

    @FindBy(className = "success-msg")
    private WebElementFacade successMessage;

    public boolean isWelcomeMessage(String text) {
        return welcomeMessage.containsOnlyText("Hello, " + text + "!");
    }

    public void clickChangePassword() {
        clickOn(changePassword);
    }

    public boolean isSuccessMessage(String message) {
        return successMessage.containsText("The account information has been saved.");
    }
}
