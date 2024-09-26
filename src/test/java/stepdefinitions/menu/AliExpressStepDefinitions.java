package stepdefinitions.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.menu.AcceuilPage;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;


import java.net.URL;

import java.time.Duration;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AliExpressStepDefinitions {
    WebDriver driver = Driver.getCurrentDriver();
    BasePage basePage = new BasePage();
    private AcceuilPage acceuilPage = new AcceuilPage();

    public AliExpressStepDefinitions() {

    }

    @Given("I am on the AliExpress platform")
    public void iAmOnTheAliExpressPlatform() {
        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
        } else if (OS.isAndroid()) {

        }
    }

    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) {
        String actualResult = Driver.getCurrentDriver().getTitle();
        assertEquals(title, actualResult);
    }

    @Then("Je devrais voir la page d'accueil d'AliExpress")
    public void jeDevraisVoirLaPageDAccueilDAliExpress() {
        assertTrue("Le logo AliExpress n'est pas affiché", acceuilPage.isLogoDisplayed());
    }

    @When("Je clique sur le bouton pour appeler le service client")
    public void jeCliqueSurLeBoutonPourAppelerLeServiceClient() {
        // acceuilPage.clickCustomerServiceCallButton();
    }

    @Then("Je devrais voir l'écran d'appel téléphonique")
    public void jeDevraisVoirLEcranDAppelTelephonique() {

     /*   if (OS.isWeb()) {

            Assert.assertTrue("L'écran de confirmation d'appel n'est pas affiché",
                    Driver.getCurrentDriver().findElement(By.cssSelector(".call-confirmation")).isDisplayed());
        } else if (OS.isAndroid()) {
            Assert.assertTrue("L'écran d'appel n'est pas affiché",
                    Driver.getCurrentDriver().findElement(By.id("com.android.dialer:id/dialpad")).isDisplayed());
        }
    } */

    }
    @Given("The user verifies that user be on the AliExpress platform")
    public void the_user_verifies_that_user_be_on_the_ali_express_platform() {
        String actualUrl = Driver.getCurrentDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("urlBelgium");
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Given("The user accepts to cookies")
    public void the_user_accepts_to_cookies() {
        acceuilPage.cookies.click();
    }
    @Given("The user clicks to allow")
    public void the_user_clicks_to_allow() {
        acceuilPage.allow.click();
    }

    @Given("The user clicks on Alle Rubrieken")
    public void the_user_clicks_on() {
        acceuilPage.alleRubrieken.click();
    }
    @Given("Je suis sur la page d'acceuil d'AliExpress")
    public void je_suis_sur_la_page_d_acceuil_d_ali_express() {
        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
        } else if (OS.isAndroid()) {

        }

    }
    @Then("Je vérifie que l'URL est correcte")
    public void je_vérifie_que_l_url_est_correcte() {
        // Beklenen URL'yi configuration dosyasından al
        String expectedUrl = ConfigReader.getProperty("webUrl");
        String actualUrl = Driver.getCurrentDriver().getCurrentUrl();

        // Beklenen domain kısmını ayır
        String expectedDomain = expectedUrl.replace("https://", "").replace("http://", "").replace("www.", "");

        // Bilgilendirme amaçlı yazdır
        System.out.println("Beklenen domain: " + expectedDomain);
        System.out.println("Gerçek URL: " + actualUrl);

        // URL'nin doğru olup olmadığını kontrol et
        assertTrue("URL doğrulanamadı: Beklenen -> " + expectedDomain + ", Gerçek -> " + actualUrl,
                actualUrl.contains(expectedDomain));
    }
    @Then("Je suis sur la Toutes les Categories")
    public void je_suis_sur_la_toutes_les_categories() {
        if (OS.isWeb()) {
        WebDriver driver = Driver.getCurrentDriver();
        WebElement categoryButton = driver.findElement(By.xpath("//*[@*='Categoey--categoryTitle--_3bKGRN']"));
        categoryButton.click();
        System.out.println("L'utilisateur est sur la Toutes Les Catégories" );
        } else if (OS.isAndroid()) {

        }

    }
    @When("Je clique sur la categorie {string}")
    public void je_clique_sur_la_categorie(String categoryName) {
        if (OS.isWeb()) {
            WebDriver driver = Driver.getCurrentDriver();
            // categoryName parametresi ile ilgili kategori elementini alıyoruz
            WebElement categoryElement = AcceuilPage.getCategoryElement(categoryName);

            // Kategoriyi bulup, tıklıyoruz
            (categoryElement).click();
            System.out.println("L'utilisateur a cliqué sur la catégorie: " + categoryName);
        } else if (OS.isAndroid()) {


        }
    }
    @Then("Je devrais être redirigé vers la page de la catégorie {string}")
    public void je_devrais_être_redirigé_vers_la_page_de_la_catégorie(String expectedCategory) {
        if (OS.isWeb()) {
            WebDriver driver = Driver.getCurrentDriver();

            // Yeni sayfanın yüklenmesini bekle ve yeni pencereye geçiş yap
            basePage.switchToNewWindow();

            // Biraz bekle (isteğe bağlı, geçiş sonrası yüklenme süresi için)
            basePage.wait(5);

            // Bekleme süresini artırarak sayfa başlığını bekle
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Yeni pencereye geçiş kontrolü ve sayfa başlığı görünürlüğü
            try {
                // Sayfa başlığının görünür olmasını bekliyoruz
                wait.until(ExpectedConditions.visibilityOf(acceuilPage.categoryPageTitle));

                // Sayfa başlığını alıyoruz
                String actualCategoryTitle = acceuilPage.categoryPageTitle.getText();

                // Sayfa başlığının beklenen kategori ile eşleşip eşleşmediğini kontrol ediyoruz
                Assert.assertTrue("L'utilisateur n'est pas sur la bonne catégorie: " +
                                "Expected: " + expectedCategory + ", but got: " + actualCategoryTitle,
                        actualCategoryTitle.equalsIgnoreCase(expectedCategory));

                System.out.println("L'utilisateur est sur la page de la catégorie: " + actualCategoryTitle);
            } catch (TimeoutException e) {
                // Sayfa başlığı bulunamadığında veya sayfa yüklenmediğinde hata mesajı veriyoruz
                System.out.println("TimeoutException: Kategori sayfası başlığı bulunamadı.");
                e.printStackTrace();
                Assert.fail("Kategori sayfası başlığı bulunamadı veya sayfa yüklenmedi.");
            } catch (NoSuchElementException e) {
                // Eğer element bulunamazsa, hata mesajı veriyoruz
                System.out.println("NoSuchElementException: Kategori sayfası başlığı bulunamadı.");
                e.printStackTrace();
                Assert.fail("Kategori sayfası başlığı bulunamadı.");
            }

        } else if (OS.isAndroid()) {

        }
    }
  @When("Je clique sur chaque groupe de produits et la page s'ouvre")
    public void je_clique_sur_chaque_groupe_de_produits_et_la_page_souvre(){
      if (OS.isWeb()) {
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Bekleme süresi

          // Tüm ürünlerin locate edilmesi
          List<WebElement> produits = driver.findElements(By.xpath("//div[@class='lv3Category--lv3CategoryContentName--2JnCa6z']"));

          // Listeyi yazdırma
          System.out.println("Toplam ürün sayısı: " + produits.size());

          for (int i = 0; i < produits.size(); i++) {
              // Geri dönüldüğünde eski WebElement referansları geçersiz olur, bu yüzden her defasında ürün listesini tekrar alıyoruz
              produits = driver.findElements(By.xpath("//div[@class='lv3Category--lv3CategoryContentName--2JnCa6z']"));
              WebElement produit = produits.get(i);

              // Ürün adını al ve temizle
              String produitNom = produit.getText().trim();
              System.out.println("Testing product: " + produitNom); // Ürün adını yazdır

              try {
                  produit.click(); // Ürüne tıkla

                  // Sayfanın yüklenmesini bekle
                  String dynamicXPath = "//input[@value='" + produitNom + "']";  // Dinamik XPath
                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));

                  // Eğer bu noktaya geldiyse, arama çubuğundaki değer doğru
                  System.out.println("Test PASSED for product: " + produitNom);

              } catch (Exception e) {
                  // Hata durumunda ürün ismini ve hatayı terminale yaz
                  System.err.println("Test FAILED for product: " + produitNom);
                  System.err.println("Error: " + e.toString()); // Hata mesajını detaylı yazdır
              }

              // Geri dönme işlemi
              driver.navigate().back();

              // Geri dönmeden sonra ana sayfanın tamamen yüklenmesini bekleyin (ilk ürünü tekrar locate etmek gibi)
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lv3Category--lv3CategoryContentName--2JnCa6z']")));

                }
      }
      else if (OS.isAndroid()) {

      }
    }


}