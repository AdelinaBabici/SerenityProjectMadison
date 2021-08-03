package com.features.search;

import com.Utils.Constants;
import com.Utils.Utils;
import com.pages.RegisterPage;
import com.steps.serenity.LoginSteps;
import com.steps.serenity.RegisterSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Steps
    private RegisterSteps registerSteps;
    @Steps
    private RegisterPage registerPage;

    Utils utils = new Utils();

    @Test
    public void registerWithValidCredentials() {
        String email = "testing@"+ utils.getRandomNumberUntil(2000) +"testing.com";
        registerSteps.navigateToRegisterPage();
        registerSteps.registerWithCredentials("Moni", "Holasz", email, "password", "password");
        registerPage.waitForConfirmationMessage();
        registerSteps.verifyConfirmationMessage();
    }

    @Test
    public void registerValidations() {
        registerSteps.navigateToRegisterPage();
        registerSteps.registerWithCredentials("", "", "", "", "");
        registerSteps.verifyValidationMessages("This is a required field.");
    }
}



