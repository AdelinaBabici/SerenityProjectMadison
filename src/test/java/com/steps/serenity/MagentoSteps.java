package com.steps.serenity;

import com.pages.MagentoPage;
import com.utils.Constants;
import net.thucydides.core.annotations.Step;
import org.yecht.Data;

public class MagentoSteps {

    private MagentoPage magentoPage;

    @Step
    public void navigateToMagentoLoginPage() {
        magentoPage.getDriver().get(Constants.URL_MAGENTO);
    }
    @Step
    public void loginWithCredentials(String username, String password){
        magentoPage.setUsernameField(username);
        magentoPage.setPasswordField(password);
        magentoPage.clickLoginButton();
        magentoPage.closePopupMessage();
    }
    @Step
    public void navigateToPendingReviewsPage(String catalog, String reviews, String customer, String pending){
        magentoPage.hoverOverCatalog(catalog);
        //magentoPage.hoverOverReviewsAndRatings(reviews);
//        magentoPage.hoverOverCustomerReviews(customer);
//        magentoPage.hoverOverPendingReviews(pending);
  }
  @Step
  public void navigateThroughCategories(String... pathNodes){
        magentoPage.navigateThroughCategories(pathNodes);
  }
  @Step
    public void editPendingReview(String name){
        magentoPage.editPendingReview(name);
  }

}
