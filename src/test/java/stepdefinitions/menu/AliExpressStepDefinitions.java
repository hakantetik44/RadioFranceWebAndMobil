package stepdefinitions.menu;
import io.cucumber.java.en.And;
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



    @Then("Je vérifie que je suis sur la page d'accueil")
    public void jeVerifieQueJeSuisSurLaPageDAccueil() {

        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            assertEquals("https://www.radiofrance.fr/franceculture", actualResult);

        } else if (OS.isAndroid()) {


        }
    }

    @When("Je clique sur le bouton {string}")
    public void jeCliqueSurLeBouton(String rechercher) {
        acceuilPage.clickBtnRechercher();
    }

    @And("Je saisis {string} dans le champ de recherche")
    public void jeSaisisDansLeChampDeRecherche(String arg0) {
    }

    @Then("Je devrais voir les résultats de recherche pour {string}")
    public void jeDevraisVoirLesResultatsDeRecherchePour(String arg0) {
    }
}