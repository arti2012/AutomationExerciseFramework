package utils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * A helper class for WebDriver to perform common actions such as clicking
 * elements,
 * sending keys, hovering, scrolling, handling alerts, and assertions.
 */
public class WebDriverHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    String parentWindow;

    /**
     * Constructor to initialize WebDriverHelper with a WebDriver instance.
     * 
     * @param driver the WebDriver instance.
     */
    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks an element specified by the locator.
     * 
     * @param locator the locator of the element to be clicked.
     */
    public void clickElement(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click the element: " + e.getMessage());
        }
    }

    /**
     * Hovers over an element specified by the locator.
     *  
     * @param locator the locator of the element to be hovered over.
     */
    public void hoverElement(By locator) {
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            throw new RuntimeException("Failed to hover over the element: " + e.getMessage());
        }
    }

    /**
     * Sends keys to an element specified by the locator.
     * 
     * @param locator the locator of the element.
     * @param keys    the keys to be sent.
     */
    public void sendKeysToElement(By locator, String keys) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(keys);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send keys to the element: " + e.getMessage());
        }
    }

    /**
     * Presses the Enter key on an element specified by the locator.
     * 
     * @param locator the locator of the element.
     */
    public void pressEnter(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new RuntimeException("Failed to press Enter on the element: " + e.getMessage());
        }
    }

    /**
     * Presses the Tab key on an element specified by the locator.
     * 
     * @param locator the locator of the element.
     */
    public void pressTab(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.sendKeys(Keys.TAB);
        } catch (Exception e) {
            throw new RuntimeException("Failed to press Tab on the element: " + e.getMessage());
        }
    }

    /**
     * Scrolls to the element specified by the locator.
     * 
     * @param locator the locator of the element to scroll to.
     */
    public void scrollToElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll to the element: " + e.getMessage());
        }
    }

    /**
     * Switches a tab using getWindowHandles.
     */
    public void switchTab() {
        parentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!parentWindow.contentEquals(windowHandle)) {
                // Switch to the new tab
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    /**
     * Accepts the currently displayed alert.
     */
    public void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
            throw new RuntimeException("Failed to accept the alert: " + e.getMessage());
        }
    }

    /**
     * Declines the currently displayed alert.
     */
    public void declineAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.dismiss();
        } catch (Exception e) {
            throw new RuntimeException("Failed to decline the alert: " + e.getMessage());
        }
    }

    /**
     * Asserts that the current URL matches the expected URL.
     * 
     * @param expectedUrl the expected URL.
     * @throws AssertionError if the current URL does not match the expected URL.
     */
    public void assertUrl(String expectedUrl) {
        try {
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl);
        } catch (AssertionError e) {
            throw new RuntimeException("Failed to assert actual URL matches expected URL: " + e.getMessage());
        }
    }
    
public void waitForElementToBeClickable(By locator) {
    WebDriverWait wait = new WebDriverWait(Base.driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(locator));
}
    /**
     * Asserts that the text of an element contains the expected text.
     * 
     * @param locator      the locator of the element.
     * @param expectedText the expected text to be contained.
     * @throws AssertionError if the element's text does not contain the expected
     *                        text.
     */
    public void assertElementTextContain(By locator, String expectedText) throws AssertionError {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String actualText = element.getText();
            Assert.assertTrue(actualText.contains(expectedText));
        } catch (Exception e) {
            throw new RuntimeException("Failed to assert element text contains expected text: " + e.getMessage());
        }
    }

    /**
     * Asserts that the text of an element matches the expected text.
     * 
     * @param locator      the locator of the element.
     * @param expectedText the expected text.
     * @throws AssertionError if the element's text does not match the expected
     *                        text.
     */
    public void assertElementText(By locator, String expectedText) throws AssertionError {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText, "Text does not match!");
        } catch (Exception e) {
            throw new RuntimeException("Failed to assert element text: " + e.getMessage());
        }
    }

    /**
     * Logs and reports an info message.
     * 
     * @param message the info message to be logged and reported.
     * @param test    the ExtentTest instance for reporting.
     */
    // public void logandReportInfo(String message, ExtentTest test) {
    // try {
    // loggerHandler.info(message);
    // reporter.addLogInfo(message, test);
    // } catch (Exception e) {
    // throw new RuntimeException("Failed to log and report info: " +
    // e.getMessage());
    // }
    // }

    /**
     * Logs and reports a failure message.
     * 
     * @param message the failure message to be logged and reported.
     * @param test    the ExtentTest instance for reporting.
     */
    // public void logandReportFail(String message, ExtentTest test) {
    // try {
    // loggerHandler.error(message);
    // reporter.addLogFail(message, test);
    // reporter.addScreenshottoReport(message + " Screenshot", test);
    // } catch (Exception e) {
    // throw new RuntimeException("Failed to log and report failure: " +
    // e.getMessage());
    // }
    // }
    public WebElement getWebElement(By locator) {
        WebElement element = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element = driver.findElement(locator);

        } catch (Exception e) {
            throw new RuntimeException("Failed to locate element " + e.getMessage());
        }
        return element;
    }
}
