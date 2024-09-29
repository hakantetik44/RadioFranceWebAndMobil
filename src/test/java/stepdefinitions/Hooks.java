package stepdefinitions;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Driver;
import utils.OS;

public class Hooks {
    public static final String APK_NAME = "aliexpress.apk";
    public static final String WEB_URL = "https://www.aliexpress.com";

    @Given("Je lance mon app")
    public void launchApp() throws MalformedURLException {
        if (OS.OS.equals("Android")) {
            System.out.println("Launching Android app: " + APK_NAME);
            Driver.Android = Driver.getAndroidDriver(Driver.getAndroidApps());
        } else if (OS.OS.equals("Web")) {
            System.out.println("Launching web app: " + WEB_URL);
            Driver.Web = Driver.getWebDriver(ConfigReader.getProperty("browser"));
            Driver.Web.get(WEB_URL);
        } else {
            throw new IllegalStateException("Unsupported platform: " + OS.OS);
        }
    }

    @Before
    public void beforeAll(Scenario scenario) throws MalformedURLException {
        OS.OS = ConfigReader.getProperty("platformName");
        if (OS.isWeb()) {
            // WebDriver başlatma işlemi
            launchApp();
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
            try {
                // 5 saniye bekleme ekleniyor
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (OS.OS.equals("Android")) {
                killApplication((AndroidDriver) driver);
            }
            driver.quit();

        }

    }
}