package com.features.search;

import com.steps.serenity.FooterSteps;
import com.steps.serenity.OrderInfoSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class OrderStatusTest extends BaseTest{

    @Steps
    private FooterSteps footerSteps;
    @Steps
    private OrderInfoSteps orderInfoSteps;


    @Test
    public void checkOrderStatus(){
        footerSteps.clickOnOrdersAndReturnsLink();
        orderInfoSteps.fillInOrderInformationForm("145000015", "aaa","Email Address");
        orderInfoSteps.enterEmail("aaaaa@yahoo.com");
        orderInfoSteps.clickOnContinueButton();
        orderInfoSteps.verifyIfUserGetOrdersStatus("145000015");

    }
}
