package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends BasePage {

    @FindBy(id="email")
    private WebElementFacade emailField;

    @FindBy(id="pass")
    private WebElementFacade passField;

    @FindBy(id="send2")
    private WebElementFacade loginBtn;

    public void setEmailField(String email) {
        typeInto(emailField,email);
    }

    public void setPassField(String pass) {
        typeInto(passField,pass);
    }

    public void clickLoginBtn(){
        clickOn(loginBtn);
    }
}