package stepdefinitions.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.menu.AcceuilPage;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;

import java.net.URL;

public class AliExpressStepDefinitions {

    private AcceuilPage acceuilPage = new AcceuilPage();

    @Given("I am on the AliExpress platform")
    public void iAmOnTheAliExpressPlatform() {
        if (OS.isWeb()) {
            String actualResult = Driver.getCurrentDriver().getCurrentUrl();
            Assert.assertEquals("https://fr.aliexpress.com/?gatewayAdapt=glo2fra", actualResult);
        } else if (OS.isAndroid()) {

        }
    }

    @When("Je vérifie que title est {string}")
    public void jeVerifieQueTitleEst(String title) {
        String actualResult = Driver.getCurrentDriver().getTitle();
        Assert.assertEquals(title, actualResult);
    }

    @Then("Je devrais voir la page d'accueil d'AliExpress")
    public void jeDevraisVoirLaPageDAccueilDAliExpress() {
        Assert.assertTrue("Le logo AliExpress n'est pas affiché", acceuilPage.isLogoDisplayed());
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
}