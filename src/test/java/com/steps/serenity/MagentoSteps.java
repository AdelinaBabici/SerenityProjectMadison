package com.steps.serenity;

import com.pages.MagentoPage;
import com.utils.Constants;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class MagentoSteps {

    private MagentoPage magentoPage;

    @Step
    public void navigateToMagentoLoginPage() {
        magentoPage.getDriver().get(Constants.URL_MAGENTO);
    }

    @Step
    public void loginWithCredentials(String username, String password) {
        magentoPage.setUsernameField(username);
        magentoPage.setPasswordField(password);
        magentoPage.clickLoginButton();
        magentoPage.closePopupMessage();
    }

    @Step
    public void navigateThroughCategories(String... pathNodes) {
        magentoPage.navigateThroughCategories(pathNodes);
    }

    @Step
    public void addReviewStatus(String name, String status) {
        magentoPage.clickOnPendingReview(name);
        magentoPage.approveReview(status);
        magentoPage.clickOnSaveReviewButton();
    }

    @Step
    public void navigateToMadisonPage() {
        magentoPage.getDriver().get(Constants.URL);
    }

    @Step
    public void verifyPresenceOfReviewInReviewsSection(String name) {
        Assert.assertTrue(magentoPage.verifyPresenceOfReview(name));
    }
    @Step
    public void addProduct(String attribute, String name, String description, String shortdescription){
        magentoPage.clickAddProductButton();
        magentoPage.setAttribute(attribute);
        magentoPage.clickOnContinueButton();
        magentoPage.addNameToProduct(name);
        magentoPage.addDescriptionToProduct(description);
        magentoPage.addShortDescriptionToProduct(shortdescription);
    }
    @Step
    public void addProductCaracteristics(String sku, String weight, String status){
        magentoPage.addSKUToProduct(sku);
        magentoPage.addWeightToProduct(weight);
        magentoPage.setStatus(status);
    }



}
