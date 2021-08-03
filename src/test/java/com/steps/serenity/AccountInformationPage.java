package com.steps.serenity;

import com.pages.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AccountInformationPage extends BasePage {

    @FindBy(id = "current_password")
    private WebElementFacade currentPassword;

    @FindBy(id = "password")
    private WebElementFacade newPassword;

    @FindBy(id = "confirmation")
    private WebElementFacade confirmNewPassword;

    @FindBy(css = "[title~=Save]")
    private WebElementFacade saveButton;

    public void enterCurrentPassword(String curentpass){
        typeInto(currentPassword, curentpass);
    }
    public void enterNewPassword(String newpass){
        typeInto(newPassword, newpass);
    }
    public void enterConfirmNewPassword(String confirmpass){
        typeInto(confirmNewPassword, confirmpass);
    }

    public void clickSaveButton() {
        clickOn(saveButton);

    }
}
