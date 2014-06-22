package net.slisenko.pageobject.model;

/**
 * Collection of different users.
 */
public enum User {

    ADMIN("admin", "123456"),
    WRONG_USER("wrong", "wrong");

    private String login;
    private String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
}
