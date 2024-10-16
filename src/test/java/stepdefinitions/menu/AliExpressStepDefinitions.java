package stepdefinitions.menu;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.menu.AcceuilPage;
import utils.Driver;
import utils.OS;
import static org.junit.Assert.assertEquals;


public class AliExpressStepDefinitions {

      AcceuilPage acceuilPage = new AcceuilPage();

    public AliExpressStepDefinitions() {

    }


    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) {
        String actualResult = Driver.getCurrentDriver().getTitle();
        assertEquals(title, actualResult);
    }


    @Then("Je vérifie que l'URL est correcte")
    public void jeVerifieQueLURLEstCorrecte() throws InterruptedException {

        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            assertEquals("https://www.radiofrance.fr/franceculture", actualResult);

        } else if (OS.isAndroid()) {
            Thread.sleep(10000);



        }
    }


    @Then("Utilisateur est sur la page acceuil")
    public void utilisateurEstSurLaPageAcceuil() {
        acceuilPage.clickBtnRechercher();

    }

    @When("Utilisateur clique sur la catégorie {string}")
    public void utilisateurCliqueSurLaCategorie(String arg0) {
    }

    @Then("Utilisateur devrait être redirigé vers la page de {string}")
    public void utilisateurDevraitEtreRedirigeVersLaPageDe(String arg0) {
    }
}