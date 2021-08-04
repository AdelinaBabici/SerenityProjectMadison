package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage {
    @FindBy(css = "#header-nav ol > li")
    private List<WebElement> categories;

    @FindBy(css = ".catblocks span")
    private List<WebElementFacade> subcategories;

    public void clickOnACategory(String categoryName) {
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                category.click();
                break;
            }
        }

    }

    public void clickOnASubcategry(String subcategoryName) {
        for (WebElement subcategory : subcategories) {
            if (subcategory.getText().equals(subcategoryName)) {
                subcategory.click();
                break;
            }
        }
    }
}
