package com.features.search;

import com.Utils.Constants;
import com.pages.DashboardPage;
import com.pages.HomePage;
import com.steps.serenity.DashboardSteps;
import com.steps.serenity.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class DashboardTest extends BaseTest {

    @Steps
    private HomePage homePage;
    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private LoginSteps loginSteps;

    @Test
    public void changePasswordWithSuccess(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithCredentials(Constants.USER_TO_UPDATE_USERNAME, Constants.USER_TO_UPDATE_PASSWORD);
        dashboardSteps.navigateToDashboardPage();
        dashboardSteps.changeAccountPassword("eminem", "eminem", "eminem");
        dashboardSteps.verifyIfPasswordChanged("The account information has been saved.");
    }
}
