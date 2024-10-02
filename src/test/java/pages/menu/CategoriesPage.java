package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.OS;

import static utils.Driver.getCurrentDriver;

public class CategoriesPage {
    public CategoriesPage() {
        PageFactory.initElements(getCurrentDriver(), this);
    }

    // kategoriler icin dinamik locate alma methodu
    public static WebElement getCategoryElement(String categoryName) {
        WebDriver driver = Driver.getCurrentDriver();
        String dynamicXpath = "//div[text()='" + categoryName + "']";
        return driver.findElement(By.xpath(dynamicXpath));
    }

    // secilen kategorinin acilan sayfadaki sayfa basligi
    @FindBy(xpath = "//*[@class='component--lv3CategoryTitle--3NEC_gC']")
    public WebElement categoryPageTitle;

    // secilen kategoriye ait urunlerin oldugu sayfadaki livraison gratuit butonu
    @FindBy(xpath = "//div[text()='Livraison gratuite']")
    public WebElement buttonLivraisonGratuit;

    @FindBy(xpath = "//*[@*='comet-icon comet-icon-arrowtriangledown topRefine2023--iconAsc--Q3bAVQK']")
    public WebElement prixDownButton;

    @FindBy(xpath = "//*[@*='comet-icon comet-icon-arrowtriangleup topRefine2023--active--moBCIXk topRefine2023--iconDesc--2v_ixsT']")
    public WebElement prixUpButton;

    @FindBy(xpath = "//*[@class='Bz112c Bz112c-r9oPif']")
    public WebElement GooglePopUp;

    @FindBy(xpath = "//*[@name='minPrice']")
    public WebElement minPrice;

    @FindBy(xpath = "//*[@name='maxPrice']")
    public WebElement maxPrice;

    @FindBy(xpath = "//*[@class='price--ok--30GSiFy']")
    public WebElement buttonOK;

    @FindBy(xpath = "//div[text()='Veuillez entrer des chiffres valides dans la plage de prix']")
    public WebElement noteDavertissement;

    @FindBy(xpath = "//*[@id='canvas']")
    public WebElement chercheImageFermee;

    @FindBy(xpath = "//span[text()='Commandes']")
    public  WebElement commandesButton;

    @FindBy(xpath = "//*[text()='Promo']")
    public WebElement promoCheckbox;

    @FindBy(xpath = "(//span[text()='Promo'])[2]")
    public WebElement promoReductions;

    @FindBy(xpath = "//span[text()='Galerie']")
    public WebElement galerieButton;

    @FindBy(xpath = "//span[text()='Liste']")
    public WebElement listeButton;
}
