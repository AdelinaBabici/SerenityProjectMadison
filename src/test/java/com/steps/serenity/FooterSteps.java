package com.steps.serenity;

import com.pages.FooterPage;
import net.thucydides.core.annotations.Step;

public class FooterSteps {
    private FooterPage footerPage;

    @Step
    public void clickOnOrdersAndReturnsLink(){
        footerPage.clickOnOrdersAndReturnsLink();
    }
}
