package kfirPractice.pom.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    static {
        System.setProperty("webdriver.chrome.driver",
                            "D:/Automation/Driver/chromedriver.exe");
    }

    private WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void terminate() {
        if (driver != null) {
            driver.quit();
        }
    }
}
