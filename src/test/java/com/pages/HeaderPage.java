package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage {
    @FindBy(css = "#header-nav ol > li")
    private List<WebElement> headline;

    @FindBy(css = ".catblocks span")
    private List<WebElementFacade> subcategoryNames;

    @FindBy(css =".level0.nav-2.parent > a")
    private WebElementFacade menCategory;

    public void clickMenCategory(){
        clickOn(menCategory);
    }


    public void clickOnACategory(String headerName) {
        for (WebElement options : headline) {
            if (options.getText().equalsIgnoreCase(headerName)) {
                options.click();
                break;
            }
        }

    }

    public void clickOnASubcategry(String name) {
        for (WebElement op : subcategoryNames) {
            if (op.getText().equals(name)) {
                op.click();
                break;
            }
        }
    }
}
