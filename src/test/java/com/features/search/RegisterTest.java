package com.features.search;

import com.pages.HomePage;
import com.steps.serenity.RegisterSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class RegisterTest extends BaseTest{

    @Steps
    private RegisterTest registerTest;
    private HomePage homePage;
    private RegisterSteps registerSteps;

    @Test
    public void registerWithValidCredentials(){
        registerSteps.registerWithCredentials("Moni", "Holasz", "mholasz@yahoo.com", "password", "password");
        registerSteps.verifyRegisterIn("Thank you for registering with Madison Island.");






    }




}
