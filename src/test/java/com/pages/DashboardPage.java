package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMsg;
    @FindBy(css = "#header-nav ol > li")
    private List<WebElement> headline;

    @FindBy(css = ".catblocks span")
    private List<WebElementFacade> subcategoryNames;

    public boolean isWelcomeMsg(String text){
        return welcomeMsg.containsOnlyText("Hello, " + text + "!");
    }


    }




