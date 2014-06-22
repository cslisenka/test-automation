package net.slisenko.pageobject.page;

import net.slisenko.pageobject.model.User;
import org.openqa.selenium.WebDriver;

/**
 * Represents login page.
 */
public class LoginPage extends AbstractPage {

    private String url;

    public LoginPage(String url, WebDriver driver) {
        super(driver);
        this.url = url;
    }

    public LoginPage open() {
        driver.navigate().to(url);
        return this;
    }


    public NewsPage loginAs(User user) {
        // Fill login and password
        printText("login", user.getLogin());
        printText("password", user.getPassword());
        // Press login button
        click("loginBtn");

        return new NewsPage(driver);
    }
}
