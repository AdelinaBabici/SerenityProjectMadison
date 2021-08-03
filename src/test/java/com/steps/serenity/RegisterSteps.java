package com.steps.serenity;

import com.pages.DashboardPage;
import com.pages.HomePage;
import com.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSteps {

    private HomePage homePage;
    private RegisterPage registerPage;
    private DashboardPage dashboardPage;


    @Step
    public void navigateToRegisterPage(){
        homePage.open();
        homePage.clickMyAccount();
        homePage.clickRegisterLink();
    }

    @Step
    public void registerWithCredentials(String firstName, String lastName, String email,String password, String confirmationPassword){
        registerPage.EntryFirstName(firstName);
        registerPage.EntryLastName(lastName);
        registerPage.EntryEmail(email);
        registerPage.EntryPassword(password);
        registerPage.EntryConfirmationPassword(confirmationPassword);
        registerPage.ClickRegisterButton();

    }

    @Step
    public void verifyRegisterIn(String value) {
            Assert.assertTrue(dashboardPage.isConfirmationMessage(value));
        }


    }
