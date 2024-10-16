package pages.menu;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.OS;
import static utils.Driver.getCurrentDriver;

public class AcceuilPage {

    public AcceuilPage() {
        PageFactory.initElements(getCurrentDriver(), this);
    }

    public void clickBtnRechercher() {
        By btnRecherche = OS.isAndroid() ?
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Recherche\")"):
                By.xpath("//span[normalize-space()='Rechercher']");
        getCurrentDriver().findElement(btnRecherche).click();
    }

    public void clickAccepterLesCookies() {
        By cookies = OS.isAndroid() ?
                By.id("com.alibaba.aliexpresshd:id/nav_more") :
                By.cssSelector(".btn-accept");
        getCurrentDriver().findElement(cookies).click();
    }


    public void clickCategories() {
        By btnCategori = OS.isAndroid() ?
                By.id("com.alibaba.aliexpresshd:id/nav_more") :
                By.cssSelector(".Categoey--categoryTitle--_3bKGRN");
        getCurrentDriver().findElement(btnCategori).click();
    }

    public void clickChaussures() {
        By categorieChaussures = OS.isAndroid() ? //Android mi,web mi olduğunu kontrol eder ve uygun bir locator belirler.
                By.id("com.alibaba.aliexpresshd:id/nav_more") : //Anroid locate'i yazilacak.
                By.cssSelector(".Categoey--categoryList--2QES_k6 > a:nth-child(10) > li:nth-child(1)"); //Web
        getCurrentDriver().findElement(categorieChaussures).click();
    }
    public void clickMocassins() {
        By mocassins = OS.isAndroid() ?
                By.id("com.alibaba.aliexpresshd:id/some_android_id_for_mocassins") :  // Android için uygun ID'yi buraya koymanız gerekecek
                By.cssSelector("div.lv3Category--lv3CategoryBox--1Nts99Z:nth-child(6) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"); // Web için CSS Selector
        getCurrentDriver().findElement(mocassins).click();
    }





}