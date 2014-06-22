package net.slisenko.pageobject;

import net.slisenko.WebDriverTestBase;
import net.slisenko.pageobject.model.Post;
import net.slisenko.pageobject.model.User;
import net.slisenko.pageobject.page.LoginPage;
import net.slisenko.pageobject.page.NewsPage;
import org.junit.Test;

/**
 * Checks adding posts to news page.
 * This test uses page-object pattern which makes it extendable.
 */
public class PageObjectLikeTest extends WebDriverTestBase {
    /**
     * All actions are more visible from business-logic side.
     * You can read the code and quickly understand what does this test do.
     * This code even do not need comments!
     */
    @Test
    public void testCreatePost() {
        LoginPage loginPage = new LoginPage("http://localhost:" + System.getProperty("jetty.port") + "/example-webapp/", driver);

        // You can also use property-files to store testing data e.g. users, posts
        // and make classes which get this information from this files
        NewsPage newsPage = loginPage.open().loginAs(User.ADMIN);

        newsPage.assertPostsCount(0)
                .addPost(Post.POST1)
                .assertPostsCount(1)
                .assertPost(0, Post.POST1);

        newsPage.addPost(Post.POST2)
                .assertPostsCount(2)
                .assertPost(1, Post.POST2);
    }
}
