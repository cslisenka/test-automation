package net.slisenko.pageobject.page;

import junit.framework.Assert;
import net.slisenko.pageobject.model.Post;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Represents page with news.
 */
public class NewsPage extends AbstractPage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage assertPostsCount(int count) {
        List<WebElement> posts = driver.findElements(By.className("post"));
        Assert.assertEquals(count, posts.size());
        return this;
    }

    public NewsPage addPost(Post post) {
        printText("title", post.getTitle());
        printText("text", post.getText());
        click("addPostBtn");
        return this;
    }

    public NewsPage assertPost(int number, Post post) {
        List<WebElement> posts = driver.findElements(By.className("post"));
        Assert.assertEquals(post.getTitle(), posts.get(number).findElement(By.tagName("h3")).getText());
        Assert.assertEquals(post.getText(), posts.get(number).findElement(By.tagName("p")).getText());
        return this;
    }
}
