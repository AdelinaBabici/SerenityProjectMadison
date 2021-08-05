package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "h2 a")
    private List<WebElement> productName;

    @FindBy(xpath = "//ul[@id='configurable_swatch_color']")
    private List<WebElement> colorsContainer;

    @FindBy(xpath = "//ul[@id='configurable_swatch_size']")
    private List<WebElement> sizesContainer;

    /*@FindBy(id = "configurable_swatch_color")
    private List<WebElement> colorsContainer;

    @FindBy(id = "configurable_swatch_size")
    private List<WebElement> sizesContainer;*/

    @FindBy(id = "qty")
    private WebElementFacade quantityInputField;

    @FindBy(css = ".add-to-cart-buttons .btn-cart")
    private WebElementFacade addToCartButton;


    public void clickOnAProduct(String name) {
        for (WebElement product : productName) {
            if (product.getText().contains(name)) {
                product.click();
                break;
            }
        }
    }

    public void selectByColorName(String colorName) {
        for (WebElement element : colorsContainer) {
            if (element.findElement(By.xpath("//a[contains(@name,'" + colorName + "')]")).isDisplayed()) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element.findElement(By.xpath("//a[contains(@name,'" + colorName + "')]")));
                break;
            }
        }
/*        for (WebElement el : colorsContainer) {
            if (el.findElement(By.cssSelector("a")).getAttribute("name").equals(colorName)) {
                JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                executor.executeScript("arguments[0].click();", el);
                break;
            }
        }*/
    }

    public void selectSizeByName(String sizeName) {
        for (WebElement element : sizesContainer) {
            if (element.findElement(By.xpath("//a[contains(@name,'" + sizeName + "')]")).isDisplayed()) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element.findElement(By.xpath("//a[contains(@name,'" + sizeName + "')]")));
                break;
            }
        }
/*        for (WebElement el : sizesContainer) {
            if (el.findElement(By.cssSelector("a")).getAttribute("name").equals(sizeName)) {
                JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                executor.executeScript("arguments[0].click();", el);
                break;
            }
        }*/
    }

    public void typeQuantity(String quantity) {
        quantityInputField.type(quantity);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }


}
