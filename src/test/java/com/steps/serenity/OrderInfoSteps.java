package com.steps.serenity;

import com.pages.OrderInfoPage;
import com.pages.OrderStatusPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class OrderInfoSteps {
    private OrderInfoPage orderInfoPage;
    private OrderStatusPage orderStatusPage;

    @Step
    public void fillInOrderInformationForm(String id,String name, String text, String info){
        orderInfoPage.enterOrderId(id);
        orderInfoPage.enterLastName(name);
        orderInfoPage.selectEmailOrZipCode(text);
        orderInfoPage.enterValidDataInField(text, info);
    }
    @Step
    public void clickOnContinueButton(){
        orderInfoPage.clickOnContinueButton();
    }
    @Step
    public void verifyIfUserGetOrdersStatus(String id){
        Assert.assertTrue(orderStatusPage.isOrderIdDisplayed(id));
    }
}
