package com.steps.serenity;

import com.pages.HomePage;
import com.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class RegisterSteps {

    private HomePage homePage;
    private RegisterPage registerPage;

    @Step
    public void navigateToRegisterPage() {
        homePage.open();
        homePage.clickMyAccount();
        homePage.clickRegisterLink();
    }

    @Step
    public void registerWithCredentials(String firstName, String lastName, String email, String password, String confirmationPassword) {
        registerPage.EntryFirstName(firstName);
        registerPage.EntryLastName(lastName);
        registerPage.EntryEmail(email);
        registerPage.EntryPassword(password);
        registerPage.EntryConfirmationPassword(confirmationPassword);
        registerPage.clickRegisterButton();
    }

    @Step
    public  void  verifyConfirmationMessage(){
        Assert.assertEquals(registerPage.getConfirmationMessage(),"Thank you for registering with Madison Island.");
    }

    @Step
    public  void  verifyValidationMessages(String message){
        Assert.assertEquals(registerPage.verifyValidationMessages(message),true);
    }

}
