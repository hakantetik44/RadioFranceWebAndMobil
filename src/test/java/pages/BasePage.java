package pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static utils.Driver.getCurrentDriver;
import static utils.Driver.getWebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class BasePage {

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

        TouchAction touch = new TouchAction((PerformsTouchActions) getCurrentDriver());
        touch.press(point(start_x, start_y)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(end_x, end_y)).release().perform();
        Thread.sleep(3000);
    }

    public void scrollFromUpToButtom() throws InterruptedException, MalformedURLException {

        Dimension dimension = getCurrentDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.2);
        int start_y = (int) (dimension.height * 0.2);
        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.5);

        TouchAction touch = new TouchAction((PerformsTouchActions) getCurrentDriver());
        touch.press(point(start_x, start_y)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(end_x, end_y)).release().perform();
        Thread.sleep(3000);
    }

    public void scrollDown() throws InterruptedException, MalformedURLException {

        Dimension dimension = getCurrentDriver().manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.5);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction((PerformsTouchActions) getCurrentDriver());
        touch.press(point(start_x, start_y)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(end_x, end_y)).release().perform();
        Thread.sleep(3000);
    }


    public void performSwipe(int x, int y) throws MalformedURLException, InterruptedException {
        Dimension dimension = getCurrentDriver().manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = x;

        int end_x = (int) (dimension.width * 0.2);
        int end_y = y;

        TouchAction touch = new TouchAction((PerformsTouchActions) getCurrentDriver());
        touch.press(point(start_x, start_y))
                .waitAction(waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(end_x, end_y))
                .release()
                .perform();
    }

    public static void dragAndDrop(double endX, double endY) throws MalformedURLException, InterruptedException {
        ((JavascriptExecutor) getCurrentDriver()).executeScript(
                "mobile: dragGesture",
                ImmutableMap.of(
                        "endX", endX,
                        "endY", endY,
                        "speed", 5000
                ));
    }
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Bekleme sırasında bir hata oluştu: " + e.getMessage());
        }
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
    }


    public boolean cliquerLogoOverKizConnectSeptFois(Actions actions, WebElement logoOverKizConnect) {
        try {
            for (int i = 0; i < 7; i++) {
                actions.click(logoOverKizConnect);
            }
            actions.perform();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getRandomName() {
        final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
        final String VOYELS = "aeiouy";

        Random random = new Random();
        StringBuilder nameBuilder = new StringBuilder();
        int nameLength = random.nextInt(6) + 5;
        nameBuilder.append(VOYELS.charAt(random.nextInt(VOYELS.length())));

        for (int i = 1; i < nameLength; i++) {
            nameBuilder.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }
        return nameBuilder.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(getRandomName());}}

    public static String getRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumberBuilder = new StringBuilder();
        phoneNumberBuilder.append("0").append(random.nextInt(2) + 6);
        for (int i = 0; i < 8; i++) {
            phoneNumberBuilder.append(random.nextInt(10));
        }
        return phoneNumberBuilder.toString();}



    public static String getRandomAddress() {
        Random random = new Random();
        StringBuilder addressBuilder = new StringBuilder();
        addressBuilder.append(random.nextInt(99) + 1).append(" Rue des Frères Montgolfier");
        return addressBuilder.toString();
    }

    public static String getRandomPostalCode() {
        Random random = new Random();
        StringBuilder postalCodeBuilder = new StringBuilder();
        postalCodeBuilder.append(String.format("%02d", random.nextInt(99) + 1)).append(String.format("%03d", random.nextInt(1000)));
        while (postalCodeBuilder.length() < 5) {
        postalCodeBuilder.append("0");}
    return postalCodeBuilder.toString();}

    public boolean isElementClickable(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                return true;}
            else {
                return false;}
        } catch (Exception e) {
            return false;}}

    public void cliquerSurLocatorEtPoint(By locator, int y) {
        try {
            WebElement element = getCurrentDriver().findElement(locator);

            int x = element.getLocation().getX();


            TouchAction touchAction = new TouchAction((PerformsTouchActions) getCurrentDriver());
            touchAction.tap(PointOption.point(x, y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .perform();
        } catch (Exception e) {
            System.out.println("L'erruer: " + e.getMessage());
        }
    }

    public void addAppOperationManager(WebDriver driver) {
        List<String> appNames = new ArrayList<>(Arrays.asList("wisniowski", "hexaom", "flexomv3", "kizconnect"));

        for (String variable : appNames) {
            for (String appName : appNames) {
                setImplicitlyWait(1);
                String locator = "com.overkiz." + appName + ":id/" + variable;
                WebElement element = findElementIfExists(locator);
                if (element != null) {
                    element.click();
                    resetImplicitlyWait();
                    return;
                }
            }
        }
        resetImplicitlyWait();
    }

    public WebElement findElementIfExists(String locator) {
        try {
            return getCurrentDriver().findElement(By.id(locator));
        } catch (Exception e) {
            return null;
        }
    }

    private void setImplicitlyWait(int seconds) {
        getCurrentDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    private void resetImplicitlyWait() {
        getCurrentDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }






}




