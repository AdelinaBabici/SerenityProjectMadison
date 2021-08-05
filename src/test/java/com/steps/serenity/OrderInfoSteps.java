package com.steps.serenity;

import com.pages.OrderInfoPage;
import com.pages.OrderStatusPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OrderInfoSteps {
    private OrderInfoPage orderInfoPage;
    private OrderStatusPage orderStatusPage;


    @Step
    public void fillInOrderInformationForm(String id, String name, String text) {
        orderInfoPage.enterOrderId(id);
        orderInfoPage.enterLastName(name);
        orderInfoPage.selectEmailOrZipCode(text);

    }

    @Step
    public void enterEmail(String text) {
        orderInfoPage.enterEmail(text);
    }

    @Step
    public void enterZIPCode(String text) {
        orderInfoPage.enterZipCode(text);
    }

    @Step
    public void clickOnContinueButton() {
        orderInfoPage.clickOnContinueButton();
    }

    @Step
    public void verifyIfOrdersStatusIsDisplayed(String id) {
        Assert.assertTrue(orderStatusPage.isOrderIdDisplayed(id));
    }
}
