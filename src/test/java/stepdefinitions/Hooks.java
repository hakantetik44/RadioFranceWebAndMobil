package stepdefinitions;

import static utils.Driver.getCurrentDriver;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;

public class Hooks {
    public static final String APK_NAME = "aliexpress.apk";
    public static final String WEB_URL = "https://www.aliexpress.com";

    protected WebDriverWait wait;

    @Given("Je lance mon app")
    public void lanceApp() throws MalformedURLException {
        if (OS.isAndroid()) {
            System.out.println("Launching Android app: " + APK_NAME);
            Driver.Android = Driver.getAndroidDriver(Driver.getAndroidApps());
        } else if (OS.isWeb()) {
            System.out.println("Launching web app: " + WEB_URL);
            Driver.Web = Driver.getWebDriver(ConfigReader.getProperty("browser"));
            Driver.Web.get(WEB_URL);

            this.wait = new WebDriverWait(Driver.Web, Duration.ofSeconds(1));

            handlePopupsAndCookies();
        } else {
            throw new IllegalStateException("Unsupported platform: " + OS.OS);
        }
    }

    private void handlePopupsAndCookies() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pop-close-btn")));
            closeButton.click();
            System.out.println("Ad pop-up successfully closed.");
        } catch (Exception e) {
            System.out.println("Ad pop-up not found or already closed.");
        }

        try {
            WebElement popupRefuse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Ne pas autoriser']")));
            popupRefuse.click();
            System.out.println("Pop-up successfully declined.");
        } catch (Exception e) {
            System.out.println("Pop-up not found or already declined.");
        }

        try {
            WebElement cookiesAccept = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accepter les cookies']")));
            cookiesAccept.click();
            System.out.println("Cookies successfully accepted.");
        } catch (Exception e) {
            System.out.println("Cookie accept button not found or already accepted.");
        }
    }

    @Before
    public void beforeAll(Scenario scenario) throws MalformedURLException {
        OS.OS = ConfigReader.getProperty("platformName");
        if (OS.isWeb()) {
            // WebDriver başlatma işlemi
            lanceApp();
        } else if (OS.isAndroid()) {
            // AndroidDriver başlatma işlemi
            // Driver.Android = Driver.getAndroidDriver(Driver.getAndroidApps());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
            WebDriver driver = Driver.getCurrentDriver();
            if (driver != null && driver instanceof TakesScreenshot) {
                screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
        }
        quitDriver();
    }

    public static String getAppPackage() {
        return "com.alibaba.aliexpresshd";
    }

    public void killApplication(AndroidDriver driver) {
        driver.terminateApp(getAppPackage());
    }

    public void quitDriver() {
      /*  if (OS.OS.equals("Android")) {
            killApplication(Driver.Android);
        }
        getCurrentDriver().quit(); */
        WebDriver driver = Driver.getCurrentDriver();
        if (driver != null) {
            if (OS.OS.equals("Android")) {
                killApplication((AndroidDriver) driver);
            }
            driver.quit();

        }

    }
}