package com.pages;

import com.gargoylesoftware.htmlunit.WaitingRefreshHandler;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderInfoPage extends BasePage{

    @FindBy(css = "input[id='oar_order_id'")
    private WebElementFacade orderIdField;
    @FindBy(css = "input[id='oar_billing_lastname'")
    private WebElementFacade lastNameField;
    @FindBy(css = "select[id*='quick_search_type_id'")
    private WebElementFacade findByField;
    @FindBy(css = "input[id='oar_email'")
    private WebElementFacade emailField;
    @FindBy(css = "input[name='oar_zip'")
    private WebElementFacade zipField;
    @FindBy(css = "button[title*='Continue'")
    private WebElementFacade continueBtn;


    public void enterOrderId(String id){
        typeInto(orderIdField, id);
    }
    public void enterLastName(String name){
        typeInto(lastNameField, name);
    }
    public WebElement selectEmailOrZipCode(String text) {
        Select oselect = new Select(findByField);
       // findByField.selectByVisibleText(text);
        List<WebElement> emailOrZipCode = oselect.getOptions();
        for(WebElement el :emailOrZipCode){
            if(el.getText().equalsIgnoreCase(text)){
                el.click();
                return el;

            }

        }return null;

    }


    public void clickOnContinueButton(){
        clickOn(continueBtn);
    }
    public void enterEmail(String text){
        typeInto(emailField,text);
    }
    public void enterZipCode(String text){
        typeInto(zipField,text);
    }

}
