package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMsg;

    @FindBy(css = ".success-msg span")
    private WebElementFacade confirmationMessage;

    @FindBy(css = "a[href*='/changepass']")
    private WebElementFacade changePassword;

    @FindBy(className = "success-msg")
    private WebElementFacade successMsg;

    public boolean isWelcomeMsg(String text) {
        return welcomeMsg.containsOnlyText("Hello, " + text + "!");
    }
    public void clickChangePassword(){
        clickOn(changePassword);
    }
    public boolean isSuccessMessage(String msg){
        return successMsg.containsText("The account information has been saved.");
    }
}
