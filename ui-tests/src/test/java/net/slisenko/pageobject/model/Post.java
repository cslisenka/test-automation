package net.slisenko.pageobject.model;

/**
 * Collection of different posts.
 */
public enum Post {

    POST1("Post 1 title", "Post 1 text"),
    POST2("Post 2 title", "Post 2 text");

    private String title;
    private String text;

    Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
