package kfirPractice.pom.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selophane.elements.factory.api.ElementFactory;

import java.time.Duration;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private final int DEFAULT_TIMEOUT_IN_SECONDS = 10;

    protected PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_IN_SECONDS);

        ElementFactory.initElements(driver, this);
    }

    public void setWaitTimeOut(Duration timeOut) {
        this.wait.withTimeout(timeOut);
    }
}
