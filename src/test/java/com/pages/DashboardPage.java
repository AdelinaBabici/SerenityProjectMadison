package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMsg;

    @FindBy(css = ".success-msg span")
    private WebElementFacade confirmationMessage;

    public boolean isWelcomeMsg(String text){
        return welcomeMsg.containsOnlyText("Hello, " + text + "!");
    }
    public boolean isConfirmationMessage(String value){
        return confirmationMessage.containsElements("Thank you for registering with Madison Island.");
    }

}
