package com.steps.serenity;

import com.utils.Constants;
import com.pages.DashboardPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class DashboardSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AccountInformationPage accountInformationPage;
    private Constants constants;

    @Step
    public void navigateToDashboardPage(){
        dashboardPage.getDriver().get(constants.URL + "customer/account/");
    }

    @Step
    public void changeAccountPassword(String currentPassword, String newPassword, String confirmationPassword){
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
