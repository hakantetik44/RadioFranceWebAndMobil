package stepdefinitions.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.menu.AcceuilPage;
import utils.Driver;
import utils.OS;

public class AliExpressStepDefinitions {

    private AcceuilPage acceuilPage = new AcceuilPage();

    /*@Given("I am on the AliExpress platform")
    public void iAmOnTheAliExpressPlatform() {
        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            Assert.assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
        } else if (OS.isAndroid()) {
        }
    }
    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) throws InterruptedException {
        acceuilPage.clickBtnNotification();
        acceuilPage.clickCategories();
        Thread.sleep(3000);
        String actualResult = Driver.getCurrentDriver().getTitle();
        Assert.assertEquals(title, actualResult);
    }

    @Then("Je devrais voir la page d'accueil d'AliExpress")
    public void jeDevraisVoirLaPageDAccueilDAliExpress() {
        Assert.assertTrue("Le logo AliExpress n'est pas affiché", acceuilPage.isLogoDisplayed());
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
    }
}