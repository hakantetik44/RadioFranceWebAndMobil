package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Driver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static utils.Driver.getCurrentDriver;
import static utils.Driver.getWebDriver;


public class BasePage {
    WebDriver driver = Driver.getCurrentDriver();
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public static void scrollToTop(int x, int y) throws InterruptedException, MalformedURLException {
        TouchAction touch = new TouchAction((PerformsTouchActions) getCurrentDriver());
        touch.press(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x, 0))
                .release()
                .perform();
    }

    private static int calculateOffsetForUpAndDownScroll(int scrollAmount) throws MalformedURLException, InterruptedException {
        Dimension dimension = getCurrentDriver().manage().window().getSize();
        return ((scrollAmount * dimension.height) / 100);
    }

    public static void scrollUp(WebElement element, int scrollPercentage) throws MalformedURLException, InterruptedException {
        Actions actions = new Actions(getCurrentDriver());
        actions.clickAndHold(element)
                .moveByOffset(0, (calculateOffsetForUpAndDownScroll(scrollPercentage)))
                .release()
                .perform();

    }

    private static int calculateOffsetForLeftScroll(int scrollAmount) throws MalformedURLException, InterruptedException {
        Dimension dimension = getCurrentDriver().manage().window().getSize();
        return ((scrollAmount * dimension.width) / 100);
    }

    public static void scrollLeft(WebElement element, int scrollPercentage) throws MalformedURLException, InterruptedException {
        Actions actions = new Actions(getCurrentDriver());
        int xOffset = calculateOffsetForLeftScroll(scrollPercentage);
        int yOffset = element.getSize().getHeight() / 2;
        actions.clickAndHold(element)
                .moveToElement(element, -xOffset, yOffset)
                .release()
                .perform();
    }

   /* public static void swipe(WebElement element, String direction, double percent, int speed){
     // getWebDriver().executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }*/


    public void scrollFromButtomToUp() throws InterruptedException, MalformedURLException {

        Dimension dimension = getCurrentDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);
        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.5);


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> mobileDriver = new ThreadLocal<>();

    // WebDriver'ı başlatan ve döndüren metot
    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            String browser = ConfigReader.getProperty("browser");  // config'den tarayıcı bilgisi alınıyor
            webDriver.set(getWebDriver(browser));  // Tarayıcıya göre driver'ı başlatıyor
        }
        return webDriver.get();
    }

    // WebDriver'ı tarayıcıya göre başlatan ve döndüren metot (Chrome, Firefox, Edge eklemeleriyle)
    public static WebDriver getWebDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                // Chrome için özel ayarlar ve opsiyonlar ekleniyor
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-search-engine-choice-screen");
                chromeOptions.addArguments("--no-first-run"); // Tarayıcı ilk kurulum adımlarını geç
                chromeOptions.addArguments("--start-maximized"); // Tarayıcıyı maksimum boyutta aç
                chromeOptions.addArguments("--disable-default-apps"); // Varsayılan uygulamaları devre dışı bırak
                chromeOptions.addArguments("--no-default-browser-check"); // Varsayılan tarayıcı kontrolünü geç
                driver = new ChromeDriver(chromeOptions); // ChromeDriver'ı opsiyonlarla başlat
                break;

            case "firefox":
                // Firefox için özel ayarlar ekleniyor
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions); // Firefox tarayıcı başlatılıyor
                break;

            case "edge":
                // Edge için özel ayarlar ekleniyor
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions); // Edge tarayıcı başlatılıyor
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);

    public static void dragAndDrop(double endX, double endY) throws MalformedURLException, InterruptedException {
        ((JavascriptExecutor) getCurrentDriver()).executeScript(
                "mobile: dragGesture",
                ImmutableMap.of(
                        "endX", endX,
                        "endY", endY,
                        "speed", 5000
                ));
    }




    public Map<String, String> frDayMap = new HashMap<String, String>() {{
        put("Lun.", "01");
        put("Mar.", "02");
        put("Mer.", "03");
        put("Jeu.", "04");
        put("Ven.", "05");
        put("Sam.", "06");
        put("Dim.", "07");
    }};


    public String getExpectedDate(String dayOfWeek, String dayOfMonth, String month) {
        String dayNumber = frDayMap.get(dayOfWeek);
        return dayOfWeek + dayNumber + "." + month;
    }


    public String getFormattedDate(String dayOfWeek, String dayOfMonth, String month) {
        String dayNumber = frDayMap.get(dayOfWeek);
        return dayOfWeek + dayNumber + " " + month;
    }

    public boolean cliquerLogoOverKizConnectSixFois(Actions actions, WebElement logoOverKizConnect) {
        try {
            for (int i = 0; i < 6; i++) {
                actions.click(logoOverKizConnect);
            }
            actions.perform();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Başlatılan tarayıcı ile URL'yi açıyoruz
        driver.get(ConfigReader.getProperty("webUrl"));
        return driver;
    }

    // Mobil driver'ı başlatan ve döndüren metot
    public static AppiumDriver getMobileDriver() throws MalformedURLException {
        if (mobileDriver.get() == null) {
            String platform = ConfigReader.getProperty("mobile.platform");  // config'den platform bilgisi alınıyor
            String appiumUrl = ConfigReader.getProperty("appium.url");      // Appium server URL'si

            if ("android".equalsIgnoreCase(platform)) {
                mobileDriver.set(new AndroidDriver(new URL(appiumUrl), (Capabilities) null));
            } else if ("ios".equalsIgnoreCase(platform)) {
                mobileDriver.set(new IOSDriver(new URL(appiumUrl), null));
            } else {
                throw new RuntimeException("Unsupported mobile platform: " + platform);
            }
        }
        return mobileDriver.get();
    }

    // Tüm driver'ları kapatan metot
    public static void quitDrivers() {
        // WebDriver'ı kapatma
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
        // Mobil driver'ı kapatma
        if (mobileDriver.get() != null) {
            mobileDriver.get().quit();
            mobileDriver.remove();
        }
    }

}

    private void setImplicitlyWait(int seconds) {
        getCurrentDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    private void resetImplicitlyWait() {
        getCurrentDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Bekleme sırasında bir hata oluştu: " + e.getMessage());
        }
    }

   /* // Elementin tıklanabilir olmasını bekleyip tıklama işlemi
    public void waitAndClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            System.out.println("Element başarıyla tıklandı: " + element);
        } catch (Exception e) {
            System.out.println("Element tıklanamadı: " + element + " Hata: " + e.getMessage());
        }
    }*/

    // Yeni açılan pencereye geçiş işlemi
    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Yeni pencereye geçildi: " + window);
                break;
            }
        }
    }

    // Orijinal pencereye geri dönme işlemi
    public void switchBackToOriginalWindow() {
        String originalWindow = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(originalWindow);
        System.out.println("Orijinal pencereye geri dönüldü.");
    }

}




