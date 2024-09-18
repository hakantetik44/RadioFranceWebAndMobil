package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.OS;

import static utils.Driver.getCurrentDriver;

public class AcceuilPage {

    public AcceuilPage() {
        PageFactory.initElements(getCurrentDriver(), this);
    }



    private By getLogo() {
        return OS.isAndroid() ?
                By.id("com.alibaba.aliexpresshd:id/logo") :  // Android locator
                By.cssSelector(".pc-header--logo--1H9dOEh");  // Web locator
    }

    private By getCustomerServiceCallButton() {
        return OS.isAndroid() ?
                By.id("com.alibaba.aliexpresshd:id/customer_service_call_button") :  // Android locator
                By.cssSelector(".service-call-button");  // Web locator
    }

    public void clickBtnEnPlus() {
        By btnEnplus = OS.isAndroid() ?
                By.id("com.alibaba.aliexpresshd:id/nav_more") :  
                By.cssSelector("comet-icon comet-icon-shoppingcart32 shop-cart--shoppingCartIcon--d5W36TW");
        getCurrentDriver().findElement(btnEnplus).click();
    }

    public boolean isLogoDisplayed() {
        return getCurrentDriver().findElement(getLogo()).isDisplayed();
    }


    public void clickCustomerServiceCallButton() {
        getCurrentDriver().findElement(getCustomerServiceCallButton()).click();
    }
}