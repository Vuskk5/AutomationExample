package independentTestingSuite.support;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import independentTestingSuite.tests.base.BaseTest;
import kfirPractice.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class GetScreenshot {
    private static ThreadLocal<WebDriver> driver = BaseTest.getThreadDriver();
    private static final String SCREENSHOT_PATH = ExtentManager.getScreenShotsPath();

    /**
     * Returns an object which represents the captured screenshot. This object should be passed to
     * {@link com.aventstack.extentreports.ExtentTest#log(Status, Throwable, MediaEntityModelProvider)} or
     * {@link com.aventstack.extentreports.ExtentTest#log(Status, String, MediaEntityModelProvider)}
     * @param imageTitle the name of the saved image and the title to be displayed in the report.
     * @return {@link MediaEntityModelProvider} media object that represents a screen capture image.
     */
    public static MediaEntityModelProvider getScreenCaptureForReport(final String imageTitle) {
        String imagePath = GetScreenshot.takeScreenShot((TakesScreenshot) driver.get(), imageTitle);
        return getMediaEntityModelProviderFromPath(imagePath, imageTitle);
    }

    public static MediaEntityModelProvider getElementCaptureForReport(final WebElement element) {
        return getElementCaptureForReport(element, null);
    }

    public static MediaEntityModelProvider getElementCaptureForReport(
            final WebElement element,
            final String imageTitle) {
        String imagePath = GetScreenshot.takeScreenShot(element, imageTitle);
        return getMediaEntityModelProviderFromPath(imagePath, imageTitle);
    }

    private static MediaEntityModelProvider getMediaEntityModelProviderFromPath(
            final String imagePath,
            final String imageName) {
        if (imagePath != null) {
            try {
                return MediaEntityBuilder.createScreenCaptureFromPath(imagePath, imageName).build();
            }
            catch (IOException ex) {
                System.out.println("Could not add screen capture to report.");
                ex.printStackTrace();
            }
        }

        return null;
    }

    private static String takeScreenShot(
            final TakesScreenshot takesScreenshot,
            String imageName) {
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        imageName = parseImageName(imageName);
        try {
            File destination = new File(SCREENSHOT_PATH + "\\" + imageName + ".png");
            FileUtils.copyFile(source, destination);

            return destination.getAbsolutePath();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String parseImageName(final String imageName) {
        // Replace all illegal characters in the image name
        if (imageName != null) {
            return imageName.replaceAll("[^a-zA-Z0-9.\\-]", "_");
        }
        else {
            return String.valueOf(System.currentTimeMillis());
        }
    }
}
