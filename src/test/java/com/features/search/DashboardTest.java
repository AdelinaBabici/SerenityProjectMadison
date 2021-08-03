package com.features.search;

import com.pages.DashboardPage;
import com.pages.HomePage;
import com.steps.serenity.DashboardSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class DashboardTest extends BaseTest {

    @Steps
    private HomePage homePage;
    @Steps
    private DashboardSteps dashboardSteps;

    @Test
    public void changePasswordWithSuccess(){
        dashboardSteps.changeAccountPassword();
        dashboardSteps.verifyIfPasswordChanged("The account information has been saved.");
    }
}
