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
import utils.Driver;
import utils.OS;
import static org.junit.Assert.assertEquals;


public class AliExpressStepDefinitions {
    WebDriver driver = Driver.getCurrentDriver();
    BasePage basePage = new BasePage();
    private AcceuilPage acceuilPage = new AcceuilPage();
    private CategoriesPage categories = new CategoriesPage();

    public AliExpressStepDefinitions() {

    }


    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) {
        String actualResult = Driver.getCurrentDriver().getTitle();
        assertEquals(title, actualResult);
    }


    @Then("Je vérifie que l'URL est correcte")
    public void jeVerifieQueLURLEstCorrecte() {

        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
        } else if (OS.isAndroid()) {

        }
    }

    @Then("Utilisateur est sur la page Toutes les Catégories")
    public void utilisateurEstSurLaPageToutesLesCategories() {
    }

    @When("Utilisateur clique sur la catégorie {string}")
    public void utilisateurCliqueSurLaCategorie(String arg0) {
    }

    @Then("Utilisateur devrait être redirigé vers la page de la catégorie {string}")
    public void utilisateurDevraitEtreRedirigeVersLaPageDeLaCategorie(String arg0) {
    }
}