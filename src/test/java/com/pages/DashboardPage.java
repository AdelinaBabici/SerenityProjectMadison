package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMsg;

    public boolean isWelcomeMsg(String text){
        return welcomeMsg.containsOnlyText("Hello, " + text + "!");
    }
}
