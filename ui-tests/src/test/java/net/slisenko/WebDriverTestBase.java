package net.slisenko;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Manages webdriver lifecycle
 */
public abstract class WebDriverTestBase {

    protected WebDriver driver;

    @Before
    public void setUp() {
        // Set execute firefox 17
        FirefoxBinary binary = new FirefoxBinary(new File("/home/kslisenko/Environment/firefox17/firefox"));
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(binary, profile);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
