
package com.BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // 1. Browser Launch
    public static WebDriver browserLaunch() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://d3e7ipkep9wy7u.cloudfront.net/");

        return driver;
    }

    // 2. Close Browser
    public static void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }

    // 3. Click Element
    public static void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // 4. Send Keys
    public static void sendKeys(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    // 5. Clear Text
    public static void clearText(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    // 6. Clear and Enter Text
    public static void clearAndEnterText(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    // 7. Get Text
    public static String getText(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    // 8. Get Attribute
    public static String getAttribute(WebElement element, String attribute) {

        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    // 9. Is Displayed
    public static boolean isDisplayed(WebElement element) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 10. Is Enabled
    public static boolean isEnabled(WebElement element) {

        return wait.until(
            ExpectedConditions.visibilityOf(element)
        ).isEnabled();
    }

    // 11. Is Selected
    public static boolean isSelected(WebElement element) {

        return wait.until(
            ExpectedConditions.visibilityOf(element)
        ).isSelected();
    }

    // 12. Wait for Visibility
    public static void waitForVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // 13. Wait for Clickable
    public static void waitForClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // 14. Wait for Invisibility
    public static void waitForInvisibility(WebElement element) {

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // 15. Wait for URL
    public static void waitForURL(String url) {

        wait.until(ExpectedConditions.urlContains(url));
    }

    // 16. Wait for Page Title
    public static void waitForTitle(String title) {

        wait.until(ExpectedConditions.titleContains(title));
    }

    // 17. Select by Visible Text
    public static void selectByText(WebElement element, String text) {

        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOf(element))
        );

        select.selectByVisibleText(text);
    }

    // 18. Select by Value
    public static void selectByValue(WebElement element, String value) {

        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOf(element))
        );

        select.selectByValue(value);
    }

    // 19. Select by Index
    public static void selectByIndex(WebElement element, int index) {

        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOf(element))
        );

        select.selectByIndex(index);
    }

    // 20. Mouse Hover
    public static void mouseHover(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // 21. Double Click
    public static void doubleClick(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // 22. Right Click
    public static void rightClick(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // 23. Drag and Drop
    public static void dragAndDrop(WebElement source, WebElement target) {

        wait.until(ExpectedConditions.visibilityOf(source));
        wait.until(ExpectedConditions.visibilityOf(target));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // 24. Scroll to Element
    public static void scrollToElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            element
        );
    }

    // 25. Scroll to Bottom
    public static void scrollToBottom() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "window.scrollTo(0, document.body.scrollHeight);"
        );
    }

    // 26. Scroll to Top
    public static void scrollToTop() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, 0);");
    }

    // 27. Accept Alert
    public static void acceptAlert() {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    // 28. Dismiss Alert
    public static void dismissAlert() {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    // 29. Get Alert Text
    public static String getAlertText() {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    // 30. Enter Text in Alert
    public static void enterAlertText(String value) {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(value);
    }

    // 31. Switch to Frame
    public static void switchToFrame(WebElement element) {

        wait.until(
            ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)
        );
    }

    // 32. Switch to Default Content
    public static void switchToDefaultContent() {

        driver.switchTo().defaultContent();
    }

    // 33. Switch to New Window
    public static void switchToNewWindow(String parentWindow) {

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String window : driver.getWindowHandles()) {

            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // 34. Navigate Back
    public static void navigateBack() {

        driver.navigate().back();
    }

    // 35. Navigate Forward
    public static void navigateForward() {

        driver.navigate().forward();
    }

    // 36. Refresh Page
    public static void refreshPage() {

        driver.navigate().refresh();
    }

    // 37. Get Current URL
    public static String getCurrentURL() {

        return driver.getCurrentUrl();
    }

    // 38. Get Page Title
    public static String getPageTitle() {

        return driver.getTitle();
    }

    // 39. Press Enter
    public static void pressEnter(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element))
            .sendKeys(Keys.ENTER);
    }

    // 40. Get List of Elements
    public static List<WebElement> getElements(By locator) {

        return wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
        );
    }

    // 41. Wait for Text
    public static void waitForText(WebElement element, String text) {

        wait.until(
            ExpectedConditions.textToBePresentInElement(element, text)
        );
    }

    // 42. Wait for URL to Match
    public static void waitForURLToBe(String url) {

        wait.until(ExpectedConditions.urlToBe(url));
    }

    // 43. Wait for Element Presence
    public static void waitForPresence(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // 44. JavaScript Click
    public static void jsClick(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
    }

    // 45. Upload File
    public static void uploadFile(WebElement upload, String filePath) {

        wait.until(ExpectedConditions.visibilityOf(upload));
        upload.sendKeys(filePath);
    }

    // 46. Get Parent Window
    public static String parentWindow() {

        return driver.getWindowHandle();
    }

    // 47. Switch to Child Window
    public static void switchToChildWindow(String parentWindow) {

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String window : driver.getWindowHandles()) {

            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // 48. Switch to Child Window by URL
    public static void switchToChildWindowByUrlName(String value) {

        wait.until(d -> {

            for (String window : d.getWindowHandles()) {

                d.switchTo().window(window);

                if (d.getCurrentUrl().contains(value)) {
                    return true;
                }
            }

            return false;
        });
    }

    // 49. Switch to Parent Window
    public static void switchToParentWindow(String parentWindow) {

        driver.switchTo().window(parentWindow);
    }

    // 50. Close Current Window
    public static void closeCurrentWindowAndReturn(String parentWindow) {

        driver.close();
        driver.switchTo().window(parentWindow);
    }

    // 51. Close All Child Windows
    public static void closeAllChildWindows(String parentWindow) {

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }

        driver.switchTo().window(parentWindow);
    }

    // 52. Clear using Keyboard
    public static void clear(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
    }

    // 53. Get Texts from List
    public static List<String> getTexts(List<WebElement> elements) {

        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        return texts;
    }

    // 54. Get List Size
    public static int getSize(List<WebElement> elements) {

        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

        return elements.size();
    }

    // 55. Screenshot
    public static String takeScreenshot(String screenshotName)
            throws IOException {

        File folder = new File("./Screenshots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String filePath = "./Screenshots/" + screenshotName + ".png";

        File destination = new File(filePath);

        FileHandler.copy(source, destination);

        return destination.getAbsolutePath();
    }

    // 56. Enter Tab
    public static void tab(WebElement element) {

        element.sendKeys(Keys.TAB);
    }
}
