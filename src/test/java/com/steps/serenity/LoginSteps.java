package com.steps.serenity;

import com.pages.DashboardPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps {
private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @Step
    public void navigateToLoginPage(){
homePage.open();
homePage.clickMyAccount();
homePage.clickLoginLink();

    }

    @Step
    public void loginWithCredentials(String email, String passsword){
        loginPage.setEmailField(email);
        loginPage.setPassField(passsword);
        loginPage.clickLoginBtn();

    }
    @Step
    public void verifyLoggedIn(String value){
        Assert.assertTrue(dashboardPage.isWelcomeMsg(value));
    }

}
