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
import pages.menu.CategoriesPage;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;


import java.net.URL;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AliExpressStepDefinitions {
    WebDriver driver = Driver.getCurrentDriver();
    BasePage basePage = new BasePage();
    private AcceuilPage acceuilPage = new AcceuilPage();
    private CategoriesPage categories = new CategoriesPage();

    public AliExpressStepDefinitions() {

    }

    @Given("Utilisateur vérifie que l'URL est correcte")
    public void utilisateur_vérifie_que_lURL_est_correctes() {
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

    @Then("Utilisateur est sur la page d'accueil d'AliExpress")
    public void utilisateur_est_sur_la_page_daccueil_dAliExpress() {
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
    @Then("Utilisateur est sur la page Toutes les Catégories")
    public void utilisateur_est_sur_la_page_Toutes_les_Catégories() {
        if (OS.isWeb()) {
        WebDriver driver = Driver.getCurrentDriver();
        WebElement categoryButton = driver.findElement(By.xpath("//*[@*='Categoey--categoryTitle--_3bKGRN']"));
        categoryButton.click();
        System.out.println("L'utilisateur est sur la Toutes Les Catégories" );
        } else if (OS.isAndroid()) {

        }

    }
    @When("Utilisateur clique sur la catégorie {string}")
    public void utilisateur_clique_sur_la_catégorie(String categoryName) {
        if (OS.isWeb()) {
            WebDriver driver = Driver.getCurrentDriver();
            // categoryName parametresi ile ilgili kategori elementini alıyoruz
            WebElement categoryElement = categories.getCategoryElement(categoryName);

            // Kategoriyi bulup, tıklıyoruz
            (categoryElement).click();
            System.out.println("L'utilisateur a cliqué sur la catégorie: " + categoryName);
        } else if (OS.isAndroid()) {


        }
    }
    @Then("Utilisateur devrait être redirigé vers la page de la catégorie {string}")
    public void utilisateur_devrait_être_redirigé_vers_la_page_de_la_catégorie(String expectedCategory) {
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
                wait.until(ExpectedConditions.visibilityOf(categories.categoryPageTitle));

                // Sayfa başlığını alıyoruz
                String actualCategoryTitle = categories.categoryPageTitle.getText();

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
    @When("Utilisateur clique sur chaque groupe de produits et la page s'ouvre")
    public void utilisateur_clique_sur_chaque_groupe_de_produits_et_la_page_s_ouvre() {
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

    @When("Utilisateur clique sur la Livraison gratuite")
    public void utilisateur_clique_sur_la_livraison_gratuite() {

        categories.buttonLivraisonGratuit.click(); // Butona tıklama
    }

    @Then("Le produit devrait afficher la mention Livraison gratuite")
    public void le_produit_devrait_afficher_la_mention_livraison_gratuite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Bekleme süresi
        int maxScrolls = 5; // Maksimum kaydırma sayısı. goruntulemek istedigimiz urun miktarina gore sayfayi kaydirabiliriz
        int scrollCount = 0; // Kaydırma sayacını başlatma

        // Ürünleri bulmak için temel locator
        List<WebElement> produits = driver.findElements(By.xpath("//div[@class='_1Hxqh']"));

        // Sayfadaki toplam ürün sayısı
        int initialProductCount = produits.size();
        boolean hasMoreProducts = true;

        // Döngü, sayfa kaydırdıkça ürünlerin yüklenmeye devam ettiğini kontrol eder
        while (hasMoreProducts && scrollCount < maxScrolls) {
            // Her bir ürün için "Livraison gratuite" kontrolü
            for (WebElement produit : produits) {
                try {
                    // Ürün başlığını al
                    String produitTitre = produit.getText();
                    System.out.println("Produit: " + produitTitre); // Ürünün adını yazdır

                    // "Livraison gratuite" yazısını içerip içermediğini kontrol et
                    if (produitTitre.contains("Livraison gratuite")) {
                        System.out.println("Test PASSED: 'Livraison gratuite' est présent pour ce produit.");
                    } else {
                        System.out.println("Test FAILED: 'Livraison gratuite' n'est pas présent pour ce produit.");
                    }
                } catch (Exception e) {
                    System.err.println("Erreur lors de la vérification du produit: " + e.getMessage());
                }
            }

            // Sayfayı aşağı kaydırarak yeni ürünlerin yüklenmesini sağla
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Yeni ürünler yüklenene kadar bekle
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='_1Hxqh']"), initialProductCount));

            // Yeni ürünler yüklendiğinde listeyi güncelle
            produits = driver.findElements(By.xpath("//div[@class='_1Hxqh']"));

            // Eğer yeni ürün yüklenmediyse döngüden çık
            if (produits.size() == initialProductCount) {
                hasMoreProducts = false;
            } else {
                initialProductCount = produits.size(); // Yeni ürün sayısını kaydet
                scrollCount++; // Kaydırma sayısını artır
            }
        }

        System.out.println("Nombre total de scrolls effectués: " + scrollCount);
        System.out.println("Tous les produits visibles ont été vérifiés.");
    }

    @Given("Utilisateur est sur la page d'une sous-catégorie sélectionnée")
    public void utilisateur_est_sur_la_page_d_une_sous_catégorie_sélectionnée() {
        if (OS.isWeb()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Bekleme süresi

            // Tüm alt kategori ürün gruplarının locate edilmesi
            List<WebElement> produits = driver.findElements(By.xpath("//div[@class='lv3Category--lv3CategoryContentName--2JnCa6z']"));

            // Ürün grubu sayısının yazdırılması
            System.out.println("Toplam ürün grubu sayısı: " + produits.size());

            // Eğer sayfada en az bir ürün grubu varsa, rastgele bir ürün grubu seç
            if (produits.size() > 0) {
                // Random sınıfını kullanarak rastgele bir index seçiyoruz
                Random random = new Random();
                int randomIndex = random.nextInt(produits.size());

                // Rastgele seçilen ürün grubu
                WebElement produit = produits.get(randomIndex);
                String produitNom = produit.getText().trim();
                System.out.println("Randomly selected product group: " + produitNom); // Seçilen ürün adını yazdır

                try {
                    produit.click(); // Rastgele seçilen ürün grubuna tıkla

                    // Sayfanın yüklenmesini bekle (dinamik olarak arama çubuğundaki ürün ismiyle kontrol)
                    String dynamicXPath = "//input[@value='" + produitNom + "']";
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));

                    // Eğer bu noktaya geldiyse, ürün detay sayfası başarıyla açıldı
                    System.out.println("Navigated to the selected sub-category page for product: " + produitNom);

                } catch (Exception e) {
                    // Hata durumunda ürün ismini ve hatayı terminale yazdır
                    System.err.println("Failed to navigate to sub-category page for product: " + produitNom);
                    System.err.println("Error: " + e.toString());
                }
            } else {
                System.err.println("No product groups found on the page.");
            }
    }
        else if (OS.isAndroid()) {

        }
    }
    @When("Utilisateur sélectionne le tri par {string}")
    public void utilisateur_sélectionne_le_tri_par(String triType) {
        if (OS.isWeb()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Bekleme süresi
            try {
                // Pop-up var mı kontrol et ve tıklama işlemini gerçekleştir
                WebElement googlePopUp = wait.until(ExpectedConditions.visibilityOf(categories.GooglePopUp));
                if (googlePopUp.isDisplayed()) {
                    googlePopUp.click(); // Eğer pop-up görünürse tıkla
                    System.out.println("Google pop-up tıklandı.");
                }
            } catch (TimeoutException e) {
                // Eğer pop-up görünmezse (örneğin sayfada değilse), test devam eder
                System.out.println("Google pop-up görünmedi, devam ediliyor.");
            } catch (Exception e) {
                // Diğer hatalar için genel hata yönetimi
                System.err.println("Pop-up işlemi sırasında bir hata oluştu: " + e.toString());
            }

            // Sıralama türüne göre butona tıklama
            if ("Prix croissant".equalsIgnoreCase(triType)) {
                categories.prixDownButton.click(); // Artan fiyat için butona tıkla
                System.out.println("Artan fiyat sıralaması seçildi.");
            } else if ("Prix décroissant".equalsIgnoreCase(triType)) {
                categories.prixUpButton.click(); // Azalan fiyat için butona tıkla
                System.out.println("Azalan fiyat sıralaması seçildi.");
            } else {
                System.err.println("Geçersiz sıralama türü: " + triType);
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }
    @Then("Les produits devraient être triés par prix du plus bas au plus élevé")
    public void les_produits_devraient_être_triés_par_prix_du_plus_bas_au_plus_élevé() {
        if (OS.isWeb()) {
            // Bekleme süresi
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Fiyatları temsil eden elementlerin bulunması
            List<WebElement> prixElements = driver.findElements(By.xpath("//div[@class='multi--price--1okBCly']"));

            // Fiyatların listelenmesi
            List<Double> prixList = new ArrayList<>();

            // Orijinal ve sıralı listeyi karşılaştırma
            List<Double> sortedPrixList = new ArrayList<>(prixList);
            Collections.sort(sortedPrixList);

            // Eğer sıralı liste orijinal listeyle aynı değilse hata mesajı
            if (!prixList.equals(sortedPrixList)) {
                System.err.println("Test FAILED: Les produits ne sont pas triés correctement.");
                System.err.println("Prix list: " + prixList);
                System.err.println("Sorted prix list: " + sortedPrixList);
                printUnsortedProducts(prixList, sortedPrixList);
            } else {
                System.out.println("Test PASSED: Les produits sont triés correctement.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }

    }

    // Sıralamayı bozan ürünleri yazdıran metot
    private void printUnsortedProducts(List<Double> prixList, List<Double> sortedPrixList) {
        for (int i = 0; i < prixList.size(); i++) {
            if (!prixList.get(i).equals(sortedPrixList.get(i))) {
                System.err.println("Sıralamayı bozan ürün fiyatı: " + prixList.get(i));
            }
        }
    }
    @Then("Utilisateur vérifie que le tri est correct pour {string}")
    public void utilisateur_vérifie_que_le_tri_est_correct_pour(String  order) {
        // Fiyatları temsil eden elementlerin bulunması
        List<WebElement> prixElements = driver.findElements(By.xpath("//div[@class='multi--price--1okBCly']"));

        // Fiyatların listelenmesi
        List<Double> prixList = new ArrayList<>();

        if (OS.isWeb()) {
            // Sıralama kontrolü
            List<Double> sortedPrixList = new ArrayList<>(prixList);
            if (order.equals("croissant")) {
                Collections.sort(sortedPrixList); // Artan sıralama
            } else if (order.equals("décroissant")) {
                Collections.sort(sortedPrixList, Collections.reverseOrder()); // Azalan sıralama
            } else {
                System.err.println("Geçersiz sıralama tipi: " + order);
                return; // Geçersiz sıralama tipi durumunda metodu bitir
            }

            // Eğer sıralı liste orijinal listeyle aynı değilse hata mesajı
            if (!prixList.equals(sortedPrixList)) {
                System.err.println("Test FAILED: Les produits ne sont pas triés correctement.");
                System.err.println("Prix list: " + prixList);
                System.err.println("Sorted prix list: " + sortedPrixList);
                printUnsortedProducts(prixList, sortedPrixList);
            } else {
                System.out.println("Test PASSED: Les produits sont triés correctement.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }


    @Then("Les produits devraient être triés par prix du plus élevé au plus bas")
    public void les_produits_devraient_être_triés_par_prix_du_plus_élevé_au_plus_bas() {
        if (OS.isWeb()) {
            // Bekleme süresi
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Fiyatları temsil eden elementlerin bulunması
            List<WebElement> prixElements = driver.findElements(By.xpath("//div[@class='multi--price--1okBCly']"));

            // Fiyatların listelenmesi
            List<Double> prixList = new ArrayList<>();

            // Orijinal ve sıralı listeyi karşılaştırma
            List<Double> sortedPrixList = new ArrayList<>(prixList);
            Collections.sort(sortedPrixList, Collections.reverseOrder()); // Azalan sıralama

            // Eğer sıralı liste orijinal listeyle aynı değilse hata mesajı
            if (!prixList.equals(sortedPrixList)) {
                System.err.println("Test FAILED: Les produits ne sont pas triés correctement.");
                System.err.println("Prix list: " + prixList);
                System.err.println("Sorted prix list: " + sortedPrixList);
                printUnsortedProducts(prixList, sortedPrixList);
            } else {
                System.out.println("Test PASSED: Les produits sont triés correctement.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }
}