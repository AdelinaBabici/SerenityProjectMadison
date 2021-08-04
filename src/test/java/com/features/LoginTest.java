package com.features;

import com.utils.Constants;
import com.steps.serenity.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void loginTestWithValidUsername(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.EMAIL,Constants.PASS);
        loginSteps.verifyLoggedIn(Constants.USER_NAME);
    }

}
