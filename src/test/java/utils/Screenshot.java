package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;

/**
 * This class handles capturing screenshots.
 */
public class Screenshot {

    public static TakesScreenshot ts;

    /**
     * Captures a screenshot of the whole page and saves it to the screenshots
     * directory.
     * 
     * @param filename The base name of the screenshot file.
     */
    public static void captureScreenShot(String filename) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";
        ts = (TakesScreenshot) Base.driver;
        File file = ts.getScreenshotAs(OutputType.FILE);

        // Ensure the screenshots directory exists
        File directory = new File(System.getProperty("user.dir") + "/screenshots");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File target = new File(directory + "/" + name);
        try {
            Files.copy(file, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Captures a screenshot of a specified web element and saves it to the
     * screenshots directory.
     * 
     * @param locator  The locator of the web element.
     * @param filename The base name of the screenshot file.
     */
    public static void captureScreenshotOfParticularWebElement(By locator, String filename) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";
        File captured = Base.driver.findElement(locator).getScreenshotAs(OutputType.FILE);

        // Ensure the screenshots directory exists
        File directory = new File(System.getProperty("user.dir") + "/screenshots");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File target = new File(directory + "/" + name);
        try {
            Files.copy(captured, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
