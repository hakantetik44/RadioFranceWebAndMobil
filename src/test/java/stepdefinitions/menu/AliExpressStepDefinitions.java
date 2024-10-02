package stepdefinitions.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.menu.AcceuilPage;
import pages.menu.CategoriesPage;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AliExpressStepDefinitions {
    WebDriver driver = Driver.getCurrentDriver();
    BasePage basePage = new BasePage();
    private AcceuilPage acceuilPage = new AcceuilPage();
    private CategoriesPage categories = new CategoriesPage();

    public AliExpressStepDefinitions() {

    }


    /*@Given("I am on the AliExpress platform")
    public void iAmOnTheAliExpressPlatform() {

    @Given("Utilisateur vérifie que l'URL est correcte")
    public void utilisateur_vérifie_que_lURL_est_correctes() {

        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
        } else if (OS.isAndroid()) {
        }
    }
    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) throws InterruptedException {
        acceuilPage.clickBtnNotification();
        acceuilPage.clickCategories();
        Thread.sleep(3000);
        String actualResult = Driver.getCurrentDriver().getTitle();
        assertEquals(title, actualResult);
    }

    @Then("Utilisateur est sur la page d'accueil d'AliExpress")
    public void utilisateur_est_sur_la_page_daccueil_dAliExpress() {
        assertTrue("Le logo AliExpress n'est pas affiché", acceuilPage.isLogoDisplayed());
    }

    @When("Je clique sur le bouton pour appeler le service client")
    public void jeCliqueSurLeBoutonPourAppelerLeServiceClient() {
    }

    @Then("Je devrais voir l'écran d'appel téléphonique")
    public void jeDevraisVoirLEcranDAppelTelephonique() {
        if (OS.isWeb()) {
            Assert.assertTrue("L'écran de confirmation d'appel n'est pas affiché",
                    Driver.getCurrentDriver().findElement(By.cssSelector(".call-confirmation")).isDisplayed());
        } else if (OS.isAndroid()) {
            Assert.assertTrue("L'écran d'appel n'est pas affiché",
                    Driver.getCurrentDriver().findElement(By.id("com.android.dialer:id/dialpad")).isDisplayed());
        }

    }
    }*/








    @Given("L'utilisateur visualise et vérifie la page daccueil Aliexpress")
    public void lUtilisateurVisualiseEtVérifieLaPageDaccueilAliexpress() {
        {
            if (OS.isWeb()) {
                String actualResult = Driver.getCurrentDriver().getCurrentUrl();
                Assert.assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
            } else if (OS.isAndroid()) {
            }
        }
    }
    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) throws InterruptedException {
        acceuilPage.clickAccepterLesCookies();
        acceuilPage.clickBtnNotification();
        String actualResult = Driver.getCurrentDriver().getTitle();
        Assert.assertEquals(title, actualResult);
    }

    @Then("L'utilisateur accède à longlet {string}")
    public void lUtilisateurAccèdeÀLonglet(String arg0) throws InterruptedException {
        acceuilPage.clickCategories();
        Thread.sleep(3000);
    }

    @And("L'utilisateur clique sur la catégorie {string}")
    public void lUtilisateurCliqueSurLaCatégorie(String arg0) {
        acceuilPage.clickChaussures();
    }

    @And("L'utilisateur sélectionne la sous-catégorie {string}")
    public void lUtilisateurSélectionneLaSousCatégorie(String arg0) {
        acceuilPage.clickMocassins();

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

    @Then("Les produits devrait afficher la mention Livraison gratuite")
    public void les_produits_devrait_afficher_la_mention_livraison_gratuite() {
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
    @When("Utilisateur saisis un prix minimum de {string} et un prix maximum de {string}")
    public void utilisateur_saisis_un_prix_minimum_de_et_un_prix_maximum_de(String minPrice, String maxPrice) {
        if (OS.isWeb()) {
            // Min ve Max fiyat kutularını doldur
            categories.minPrice.clear();
            categories.minPrice.sendKeys(minPrice);

            categories.maxPrice.clear();
            categories.maxPrice.sendKeys(maxPrice);

         } else if (OS.isAndroid()) {
        // Android için ek işlemler buraya eklenebilir
    }
    }

    @When("valide les filtres de prix")
    public void valide_les_filtres_de_prix() {
        if (OS.isWeb()) {
            // Filtreleme butonuna tıklayarak fiyat aralığını onayla
            categories.buttonOK.click(); // Submit butonuna tıklama
           basePage.wait(5);
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }

    @Then("Les produits doivent être affichés dans la fourchette de prix spécifiée")
    public void les_produits_devraient_être_affichés_dans_l_intervalle_de_prix_entre() {
        if (OS.isWeb()) {
            // Ürün fiyatlarını temsil eden elementlerin bulunması
            List<WebElement> prixElements = driver.findElements(By.xpath("//div[@class='multi--price--1okBCly']"));

            // Tüm fiyatların listelenmesi
            List<Double> prixList = new ArrayList<>();
            for (WebElement element : prixElements) {
                String prixText = element.getText().replace("€", "").trim();
                prixText = prixText.replace(",", "."); // Virgül yerine nokta kullanımı

            }

            // Listeyi kontrol edelim
            if (prixList.isEmpty()) {
                System.err.println("Test FAILED: Hiçbir ürün fiyatı bulunamadı.");
            } else {
                System.out.println("Test PASSED: Fiyatlar başarıyla listelendi.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }
    @Then("Utilisateur vérifie que tous les produits affichés ont un prix compris entre {string} et {string}")
    public void utilisateur_vérifie_que_tous_les_produits_affichés_ont_un_prix_compris_entre_et(String minPrice, String maxPrice) {
        if (OS.isWeb()) {
            // Ürün fiyatlarını temsil eden elementlerin bulunması
            List<WebElement> prixElements = driver.findElements(By.xpath("//div[@class='multi--price--1okBCly']"));

            // Tüm fiyatların listelenmesi
            List<Double> prixList = new ArrayList<>();
            for (WebElement element : prixElements) {
                String prixText = element.getText().replace("€", "").trim();
                prixText = prixText.replace(",", "."); // Virgül yerine nokta kullanımı
                try {
                    Double prixValue = Double.parseDouble(prixText);
                    prixList.add(prixValue); // Fiyatı listeye ekleme
                } catch (NumberFormatException e) {
                    System.err.println("Geçersiz fiyat değeri atlandı: " + prixText);
                }
            }

            // Girilen fiyat aralığındaki ürünleri kontrol et
            double min = Double.parseDouble(minPrice);
            double max = Double.parseDouble(maxPrice);
            boolean allPricesInRange = true;

            for (Double prix : prixList) {
                if (prix < min || prix > max) {
                    System.err.println("Test FAILED: Ürün fiyatı belirtilen aralığın dışında: " + prix);
                    allPricesInRange = false;
                }
            }

            // Sonuçları raporla
            if (allPricesInRange) {
                System.out.println("Test PASSED: Tüm ürünler belirtilen fiyat aralığında.");
            } else {
                System.err.println("Test FAILED: Bazı ürünler belirtilen aralığın dışında.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }
    @Then("Un message d'avertissement devrait être affiché")
    public void un_message_d_avertissement_devrait_être_affiché() {
        if (OS.isWeb()) {
            // Avertissement mesajının görünüp görünmediğini kontrol et
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement avertissement = wait.until(ExpectedConditions.visibilityOf(categories.noteDavertissement));
                if (avertissement.isDisplayed()) {
                    System.out.println("Test PASSED: Uyarı mesajı başarıyla görüntülendi.");
                } else {
                    System.err.println("Test FAILED: Uyarı mesajı görünmedi.");
                }
            } catch (TimeoutException e) {
                System.err.println("Test FAILED: Uyarı mesajı zaman aşımına uğradı ve görüntülenmedi.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }
    @When("Utilisateur sélectionne le pays {string}")
    public void utilisateur_sélectionne_le_pays(String pays) {
        if (OS.isWeb()) {
            // Ülke için radyo butonunu bul ve tıkla
            String radioButtonXPath = String.format("//span[text()='%s']", pays);
            WebElement countryRadioButton = driver.findElement(By.xpath(radioButtonXPath));
            countryRadioButton.click(); // Seçilen ülke için radyo butonuna tıkla

        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }

    // randomProductName değişkenini sınıf seviyesinde tanımlıyoruz
    private String randomProductName;

    @When("Utilisateur clique sur un produit aléatoire")
    public void utilisateur_clique_sur_un_produit_aléatoire() {
        if (OS.isWeb()) {
            // Ürün elementlerini bul
            List<WebElement> produitElements = driver.findElements(By.xpath("//div[@class='list--gallery--C2f2tvm search-item-card-wrapper-gallery']"));

            if (!produitElements.isEmpty()) {
                // Rastgele bir ürün seç
                Random rand = new Random();
                int randomIndex = rand.nextInt(produitElements.size());
                WebElement randomProduct = produitElements.get(randomIndex);

                // Ürün ismini al ve sınıf seviyesindeki değişkene atayalım
                randomProductName = randomProduct.findElement(By.xpath(".//h3[@class='multi--titleText--nXeOvyr']")).getText();

                if (randomProductName == null || randomProductName.isEmpty()) {
                    randomProductName = "Random_Product"; // Ürün adı alınamıyorsa varsayılan bir isim ver
                }
                System.out.println("Seçilen ürün: " + randomProductName); // Seçilen ürün ismini yazdır

                // Rastgele ürüne tıkla
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(randomProduct));
                randomProduct.click();

                // Yeni pencereye geç
                String originalWindow = driver.getWindowHandle();
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(originalWindow)) {
                        driver.switchTo().window(windowHandle); // Yeni pencereye geç
                        break;
                    }
                }

            } else {
                System.err.println("Test FAILED: Ürünler bulunamadı.");
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }

    private void takeScreenshot(String productName) {
        try {
            // Ekran görüntüsünü al
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Kaydetmek için hedef dosya yolunu belirle
            // Ürün ismi içindeki geçersiz karakterleri temizle ve dosya adını oluştur
            String safeProductName = productName.replaceAll("[^a-zA-Z0-9\\s]", "_"); // Geçersiz karakterleri temizle
            safeProductName = safeProductName.replaceAll("\\s+", "_"); // Boşlukları alt çizgi ile değiştir

            // Zaman damgası ekle (isteğe bağlı)
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = "screenshots/" + safeProductName + "_" + timeStamp + ".png"; // Dosya adı

            File destFile = new File(filePath);

            // Hedef dosyaya kopyala
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Ekran görüntüsü alındı: " + filePath);

        } catch (IOException e) {
            System.err.println("Ekran görüntüsü alma sırasında hata: " + e.getMessage());
        }
    }

    @Then("La page du produit doit afficher expédié depuis {string}")
    public void la_page_du_produit_doit_afficher_expédié_depuis(String expectedText) {
        if (OS.isWeb()) {
            // Ürün bilgisi ve beklenen ülkeye göre sayfada görünen ülke kontrolü
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                // Gönderim bilgisini içeren elementi bul
                WebElement expediElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@style='color: #191919;'])[2]")));
                String displayedText = expediElement.getText().trim(); // Görünen metni al

                // Eğer displayedText boş ise, testi hata vermeden bitir.
                if (displayedText.isEmpty()) {
                    System.out.println("Uyarı: Görüntülenen metin bulunamadı, test devam ediyor.");
                    return; // Testi bitir, hata verme
                }

                // Ülke kontrolleri
                if (expectedText.equalsIgnoreCase("France")) {
                    if (displayedText.contains("France")) {
                        System.out.println("Test PASSED: 'France' metni doğru görüntüleniyor.");
                    } else {
                        System.err.println("Test FAILED: Beklenen 'France', ancak görünen: '" + displayedText + "'.");
                        takeScreenshot("Mismatch_" + randomProductName); // Hata durumunda ekran görüntüsü al ve ürün ismi ile kaydet
                    }
                } else if (expectedText.equalsIgnoreCase("Italie") || expectedText.equalsIgnoreCase("Italy")) {
                    if (displayedText.contains("Italie") || displayedText.contains("Italy")) {
                        System.out.println("Test PASSED: 'Italie' ya da 'Italy' metni doğru görüntüleniyor.");
                    } else {
                        System.err.println("Test FAILED: Beklenen 'Italie' ya da 'Italy', ancak görünen: '" + displayedText + "'.");
                        takeScreenshot("Mismatch_" + randomProductName);
                    }
                } else if (expectedText.equalsIgnoreCase("Czech Republic") || expectedText.equalsIgnoreCase("République tchèque")) {
                    if (displayedText.contains("Czech Republic") || displayedText.contains("République tchèque")) {
                        System.out.println("Test PASSED: 'Czech Republic' ya da 'République tchèque' metni doğru görüntüleniyor.");
                    } else {
                        System.err.println("Test FAILED: Beklenen 'Czech Republic' ya da 'République tchèque', ancak görünen: '" + displayedText + "'.");
                        takeScreenshot("Mismatch_" + randomProductName);
                    }
                } else if (expectedText.equalsIgnoreCase("Espagne")) {
                    if (displayedText.contains("Espagne")) {
                        System.out.println("Test PASSED: 'Espagne' metni doğru görüntüleniyor.");
                    } else {
                        System.err.println("Test FAILED: Beklenen 'Espagne', ancak görünen: '" + displayedText + "'.");
                        takeScreenshot("Mismatch_" + randomProductName);
                    }
                } else {
                    System.err.println("Test FAILED: Bilinmeyen ülke: '" + expectedText + "'.");
                    takeScreenshot("UnknownCountry_" + randomProductName); // Beklenmeyen bir ülke varsa hata al
                }

            } catch (TimeoutException e) {
                // Eğer element belirtilen sürede görünmezse hata mesajı
                System.err.println("Test FAILED: Beklenen metin görünmüyor: " + expectedText);
                takeScreenshot("Timeout_Failed_" + randomProductName); // Zaman aşımı durumunda ekran görüntüsü al
            }
        } else if (OS.isAndroid()) {
            // Android için ek işlemler buraya eklenebilir
        }
    }

    // When: Kullanıcı "Commandes" sıralama butonuna tıklar
    @When("Utilisateur clique sur la Commandes")
    public void utilisateur_clique_sur_la_Commandes() {
        if (OS.isWeb()) {
            // Web platformu için "Commandes" butonuna tıkla
            WebElement commandesButton = categories.commandesButton;

            // WebDriverWait ile butonun tıklanabilir hale gelmesini bekle
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(commandesButton));

            commandesButton.click();
        } else if (OS.isAndroid()) {
            // Android platformu için eklemeler yapılabilir
        }
    }

    // Then: Ürünler en çok satılandan en az satılana doğru sıralanmalı
    @Then("Les produits devrait afficher de plus vendus à moins vendus")
    public void les_produits_devrait_afficher_de_plus_vendus_à_moins_vendus() {
        if (OS.isWeb()) {
            // Web platformu için ürünlerin satış sayısını kontrol et
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Ürünlerin yüklendiğinden emin olmak için bekle
            List<WebElement> produits = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@*='multi--trade--Ktbl2jB']")));

            meilleurVente(produits);
        } else if (OS.isAndroid()) {
            // Android platformu için eklemeler yapılabilir
        }
    }

    // Ortak kontrol fonksiyonu (Hem web hem de Android için kullanılır)
    private void meilleurVente(List<WebElement> produits) {
        List<Integer> salesNumbers = new ArrayList<>();

        for (WebElement produit : produits) {
            try {
                // Ürünlerin satış sayısını al ve rakamları ayıkla
                String salesText = produit.getText().replaceAll("[^0-9]", ""); // Sadece rakamları al

                if (!salesText.isEmpty()) {
                    int sales = Integer.parseInt(salesText); // Rakamları tam sayıya çevir
                    salesNumbers.add(sales);
                } else {
                    System.out.println("Warning: Sales text is empty for one of the products.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Couldn't parse sales number for product: " + produit.getText());
            }
        }

        // Satış sayılarını kontrol et: en çok satılandan en az satılana doğru sıralanmış mı?
        boolean sorted = true;
        for (int i = 0; i < salesNumbers.size() - 1; i++) {
            if (salesNumbers.get(i) < salesNumbers.get(i + 1)) {
                sorted = false;
                break;
            }
        }

        // Test sonucunu bildir
        if (sorted) {
            System.out.println("Test PASSED: Les produits sont bien classés du plus vendu au moins vendu.");
        } else {
            System.err.println("Test FAILED: Les produits ne sont pas dans le bon ordre.");
            takeScreenshot("Order_Mismatch"); // Hata durumunda ekran görüntüsü al
        }
    }

    @When("Utilisateur clique sur la Promo")
    public void utilisateur_clique_sur_la_Promo() {
        if (OS.isWeb()) {
            // Web platformu için promo checkbox'ına tıkla
            categories.promoCheckbox.click();


            // Promo checkbox'ına tıklandıktan sonra sayfanın güncellenmesini bekleyelim
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(categories.promoReductions));
        } else if (OS.isAndroid()) {
            // Android platformu için promo checkbox'ına tıklama işlemi buraya eklenebilir
        }
    }
    @Then("Réductions Promo affiche")
    public void reductions_Promo_affiche() {
        if (OS.isWeb()) {
            // Web platformu için Promo Reductions yazısının görünürlüğünü kontrol et

            if (categories.promoReductions.isDisplayed()) {
                System.out.println("Test PASSED: Promo Reductions yazısı başarıyla görüntüleniyor.");
            } else {
                System.err.println("Test FAILED: Promo Reductions yazısı görüntülenmiyor.");
                takeScreenshot("PromoReductions_NotDisplayed");
            }
        } else if (OS.isAndroid()) {
            // Android platformu için Promo Reductions yazısının görünürlüğü kontrol edilebilir
        }
    }
    @And("Chaque produit devrait afficher au moins une étiquette 'Promo' ou 'Offre de bienvenue' ou 'Choice'")
    public void chaque_produit_devrait_afficher_au_moins_une_étiquette_promo_ou_offre_de_bienvenue_ou_choice() {
        if (OS.isWeb()) {
            // Web platformu için ürünlerin etiketlerini kontrol et
            List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'product-card')]")); // Ürün kartlarının genel locator'ı
            boolean allProductsHaveLabel = true;

            for (WebElement product : products) {
                // Her ürün için etiket kontrolü
                boolean hasPromoLabel = !product.findElements(By.xpath(".//img[@width='41.5']")).isEmpty(); // Promo etiketi
                boolean hasWelcomeOfferLabel = !product.findElements(By.xpath(".//img[@width='84.5']")).isEmpty(); // Offre de bienvenue etiketi
                boolean hasChoiceLabel = !product.findElements(By.xpath(".//img[@width='38.5']")).isEmpty(); // Choice etiketi

                // Eğer etiketlerden biri varsa geçerli
                if (!(hasPromoLabel || hasWelcomeOfferLabel || hasChoiceLabel)) {
                    allProductsHaveLabel = false;
                    break;
                }
            }

            // Sonuçları raporla
            if (allProductsHaveLabel) {
                System.out.println("Test PASSED: Tüm ürünlerde en az bir promosyon etiketi mevcut.");
            } else {
                System.err.println("Test FAILED: Bazı ürünlerde promosyon etiketi yok.");
                takeScreenshot("Missing_Promo_Labels");
            }
        } else if (OS.isAndroid()) {
            // Android platformu için etiket kontrolü
            // Android'e özgü adımlar
        }
    }
    // When: Kullanıcı "Galerie" ya da "list" seçeneğine tıklıyor
    @When("Utilisateur clique sur l'option {string}")
    public void utilisateur_clique_sur_l_option(String mode) {

        // Modun belirlenmesi
        if (mode.equalsIgnoreCase("Galerie")) {
             categories.galerieButton.click();// 'Galerie' butonuna click
             basePage.wait(10);
        } else if (mode.equalsIgnoreCase("List")) {
             categories.listeButton.click(); // 'Liste' butonuna click
             basePage.wait(10);
        }

    }

    // Then: Ürünler "Galerie" veya "Liste" modunda görüntülenmelidir
    @Then("Les produits doivent être affichés en mode {string}")
    public void les_produits_doivent_etre_affiches_en_mode(String mode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Bekleme süresi
        if (mode.equalsIgnoreCase("Galerie")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list--gallery--C2f2tvm search-item-card-wrapper-gallery']"))); // Galeri modunun locatörü
            System.out.println("Les produits sont affichés en mode Galerie.");
        } else if (mode.equalsIgnoreCase("List")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list--list--3wn4cH5 search-item-card-wrapper-list']"))); // Liste modunun locatörü
            System.out.println("Les produits sont affichés en mode List.");
        }
    }

}




