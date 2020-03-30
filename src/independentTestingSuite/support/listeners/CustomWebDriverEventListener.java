package independentTestingSuite.support.listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import independentTestingSuite.support.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;

public class CustomWebDriverEventListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        ExtentTestManager.getTest().info("Clicking [" + element.getText() + "]",
                        GetScreenshot.getElementCaptureForReport(element));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        if (keysToSend != null) {
            ExtentTestManager.getTest().info("Typed " + Arrays.toString(keysToSend) + " into [" + element.getText() + "]",
                    GetScreenshot.getElementCaptureForReport(element));
        }
    }
}
