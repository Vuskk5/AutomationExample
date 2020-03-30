package independentTestingSuite.tests.base;

import independentTestingSuite.pages.LandingPage;
import independentTestingSuite.support.listeners.CustomWebDriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver", "D:/Automation/Driver/chromedriver.exe");
    }

    private static final String URL = "https://phptravels.com/";

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriverWait wait;

    protected void initialize() {
        driver.set(new EventFiringWebDriver(new ChromeDriver()));
        ((EventFiringWebDriver) getDriver()).register(new CustomWebDriverEventListener());
        wait = new WebDriverWait(getDriver(), 10);
        getDriver().manage().window().maximize();
        getDriver().navigate().to(URL);
    }

    protected void terminate() {
        getDriver().quit();
    }

    public LandingPage openSystem() {
        return new LandingPage(getDriver());
    }

    public static ThreadLocal<WebDriver> getThreadDriver() {
        return driver;
    }

    protected WebDriver getDriver() {
        return driver.get();
    }
}
