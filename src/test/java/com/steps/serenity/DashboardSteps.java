package com.steps.serenity;

import com.pages.DashboardPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class DashboardSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AccountInformationPage accountInformationPage;

    @Step
    public void changeAccountPassword(){
        homePage.open();
        homePage.clickMyAccount();
        homePage.clickLoginLink();
        loginPage.setEmailField("moni@yahoo.com");
        loginPage.setPassField("eminem");
        loginPage.clickLoginBtn();
        dashboardPage.clickChangePassword();
        accountInformationPage.enterCurrentPassword("eminem");
        accountInformationPage.enterNewPassword("eminem");
        accountInformationPage.enterConfirmNewPassword("eminem");
        accountInformationPage.clickSaveButton();
    }

    @Step
    public void verifyIfPasswordChanged(String msg){
        Assert.assertTrue(dashboardPage.isSuccessMessage(msg));
    }
}
