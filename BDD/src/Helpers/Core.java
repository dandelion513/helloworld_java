package Helpers;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by Tatyana on 01.03.2016.
 */
public class Core {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        String baseUrl = "https://ru.wikipedia.org/";
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, 10);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static WebDriverWait getWait()
    {
        return wait;
    }
}
