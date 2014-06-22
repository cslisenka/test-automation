package net.slisenko.procedure;

import junit.framework.Assert;
import net.slisenko.WebDriverTestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.List;

/**
 * Checks adding posts to news page.
 * Test uses standard procedure-based approach.
 */
public class ProcedureLikeTest extends WebDriverTestBase {

    public static final String POST1_TITLE = "New Post!";
    public static final String POST1_TEXT = "New post text";
    public static final String POST2_TITLE = "post 2 title";
    public static final String POST2_TEXT = "post 2 text";
    public static final String ADMIN_LOGIN = "admin";
    public static final String ADMIN_PASSWORD = "123456";

    /**
     * All operations moved to methods which makes code more readable.
     * But it is till difficult to understand what does this test do.
     * We need comments in the code.
     * Also this code is not very extendable.
     */
    @Test
    public void testCreatePost() {
        // Go to login page
        driver.navigate().to("http://localhost:" + System.getProperty("jetty.port") + "/example-webapp/");
        login(ADMIN_LOGIN, ADMIN_PASSWORD);

        // Get all posts count, check that we do not have any posts on webpage
        assertPostCount(0);

        // Add post
        addPost(POST1_TITLE, POST1_TEXT);
        // Check that there is 1 post on webpage
        assertPostCount(1);
        // Assert post title and text
        assertPost(0, POST1_TITLE, POST1_TEXT);

        // Add second post
        addPost(POST2_TITLE, POST2_TEXT);
        // Check that there are 2 posts on webpage
        assertPostCount(2);
        // Assert post title and text
        assertPost(1, POST2_TITLE, POST2_TEXT);
    }

    // ------ WebDriver utility methods
    public void printText(String textBoxId, String text) {
        WebElement textBox = driver.findElement(By.id(textBoxId));
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void click(String id) {
        WebElement button = driver.findElement(By.id(id));
        button.click();
    }

    // ------ WebDriver utility methods

    // ------ Business logic methods
    public void login(String login, String password) {
        // Fill login and password
        printText("login", login);
        printText("password", password);

        // Press login button
        click("loginBtn");
    }

    public void addPost(String title, String text) {
        printText("title", title);
        printText("text", text);
        click("addPostBtn");
    }

    public void assertPost(int number, String title, String text) {
        List<WebElement> posts = driver.findElements(By.className("post"));
        Assert.assertEquals(title, posts.get(number).findElement(By.tagName("h3")).getText());
        Assert.assertEquals(text, posts.get(number).findElement(By.tagName("p")).getText());
    }

    public void assertPostCount(int count) {
        List<WebElement> posts = driver.findElements(By.className("post"));
        Assert.assertEquals(count, posts.size());
    }
    // ------ Business logic methods
}
